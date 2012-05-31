/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.istock.utils;

import java.beans.PropertyChangeSupport;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivilegedAction;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Minimal implementation of the <b>Manager</b> interface that supports no
 * session persistence or distributable capabilities. This class may be
 * subclassed to create more sophisticated Manager implementations.
 * 
 * @author Craig R. McClanahan
 * @version $Id: ManagerBase.java 939518 2010-04-30 00:08:58Z kkolinko $
 */

public class SessionHelp {

	private static SessionHelp instance;

	private SessionHelp() {
	}

	public static synchronized SessionHelp getInstance() {

		if (instance == null)
			instance = new SessionHelp();
		return instance;

	}

	// ----------------------------------------------------- Instance Variables

	protected DataInputStream randomIS = null;
	protected String devRandomSource = "/dev/urandom";

	/**
	 * The default message digest algorithm to use if we cannot use the
	 * requested one.
	 */
	protected static final String DEFAULT_ALGORITHM = "MD5";

	/**
	 * The message digest algorithm to be used when generating session
	 * identifiers. This must be an algorithm supported by the
	 * <code>java.security.MessageDigest</code> class on your platform.
	 */
	protected String algorithm = DEFAULT_ALGORITHM;

	/**
	 * Return the MessageDigest implementation to be used when creating session
	 * identifiers.
	 */
	protected MessageDigest digest = null;

	/**
	 * A String initialization parameter used to increase the entropy of the
	 * initialization of our random number generator.
	 */
	protected String entropy = null;
	/**
	 * The session id length of Sessions created by this Manager.
	 */
	protected int sessionIdLength = 16;
	/**
	 * A random number generator to use when generating session identifiers.
	 */
	protected Random random = null;

	/**
	 * The Java class name of the random number generator class to be used when
	 * generating session identifiers.
	 */
	protected String randomClass = "java.security.SecureRandom";

	/**
	 * The set of currently active Sessions for this Manager, keyed by session
	 * identifier.
	 */
	protected Map<String, String> sessions = new ConcurrentHashMap<String, String>();

	// number of duplicated session ids - anything >0 means we have problems
	protected int duplicates = 0;

	/**
	 * The property change support for this component.
	 */
	protected PropertyChangeSupport support = new PropertyChangeSupport(this);

	// ------------------------------------------------------------- Security
	// classes

	private class PrivilegedSetRandomFile implements
			PrivilegedAction<DataInputStream> {

		public PrivilegedSetRandomFile(String s) {
			devRandomSource = s;
		}

		public DataInputStream run() {
			try {
				File f = new File(devRandomSource);
				if (!f.exists())
					return null;
				randomIS = new DataInputStream(new FileInputStream(f));
				randomIS.readLong();
				return randomIS;
			} catch (IOException ex) {
				if (randomIS != null) {
					try {
						randomIS.close();
					} catch (Exception e) {
					}
				}
				devRandomSource = null;
				randomIS = null;
				return null;
			}
		}
	}

	/**
	 * Return the MessageDigest object to be used for calculating session
	 * identifiers. If none has been created yet, initialize one the first time
	 * this method is called.
	 */
	public synchronized MessageDigest getDigest() {

		if (this.digest == null) {
			try {
				this.digest = MessageDigest.getInstance(algorithm);
			} catch (NoSuchAlgorithmException e) {
				try {
					this.digest = MessageDigest.getInstance(DEFAULT_ALGORITHM);
				} catch (NoSuchAlgorithmException f) {
					this.digest = null;
				}
			}
		}

		return (this.digest);

	}

	/**
	 * Return the entropy increaser value, or compute a semi-useful value if
	 * this String has not yet been set.
	 */
	public String getEntropy() {

		// Calculate a semi-useful value if this has not been set
		if (this.entropy == null) {
			// Use APR to get a crypto secure entropy value
			byte[] result = new byte[32];
			boolean apr = false;
			try {
				String methodName = "random";
				Class paramTypes[] = new Class[2];
				paramTypes[0] = result.getClass();
				paramTypes[1] = int.class;
				Object paramValues[] = new Object[2];
				paramValues[0] = result;
				paramValues[1] = new Integer(32);
				Method method = Class.forName("org.apache.tomcat.jni.OS")
						.getMethod(methodName, paramTypes);
				method.invoke(null, paramValues);
				apr = true;
			} catch (Throwable t) {
				// Ignore
			}
			if (apr) {
				setEntropy(new String(result));
			} else {
				setEntropy(this.toString());
			}
		}

		return (this.entropy);

	}

	/**
	 * Set the entropy increaser value.
	 * 
	 * @param entropy
	 *            The new entropy increaser value
	 */
	public void setEntropy(String entropy) {

		String oldEntropy = entropy;
		this.entropy = entropy;
		support.firePropertyChange("entropy", oldEntropy, this.entropy);

	}

	/**
	 * Use /dev/random-type special device. This is new code, but may reduce the
	 * big delay in generating the random.
	 * 
	 * You must specify a path to a random generator file. Use /dev/urandom for
	 * linux ( or similar ) systems. Use /dev/random for maximum security ( it
	 * may block if not enough "random" exist ). You can also use a pipe that
	 * generates random.
	 * 
	 * The code will check if the file exists, and default to java Random if not
	 * found. There is a significant performance difference, very visible on the
	 * first call to getSession ( like in the first JSP ) - so use it if
	 * available.
	 */
	public void setRandomFile(String s) {
		// as a hack, you can use a static file - and generate the same
		// session ids ( good for strange debugging )
		if (System.getSecurityManager() != null) {
			randomIS = AccessController
					.doPrivileged(new PrivilegedSetRandomFile(s));
		} else {
			try {
				devRandomSource = s;
				File f = new File(devRandomSource);
				if (!f.exists())
					return;
				randomIS = new DataInputStream(new FileInputStream(f));
				randomIS.readLong();
			} catch (IOException ex) {
				if (randomIS != null) {
					try {
						randomIS.close();
					} catch (Exception e) {
					}
				}
				devRandomSource = null;
				randomIS = null;
			}
		}
	}

	public String getRandomFile() {
		return devRandomSource;
	}

	/**
	 * Return the random number generator instance we should use for generating
	 * session identifiers. If there is no such generator currently defined,
	 * construct and seed a new one.
	 */
	public Random getRandom() {
		if (this.random == null) {
			// Calculate the new random number generator seed
			long seed = System.currentTimeMillis();
			char entropy[] = getEntropy().toCharArray();
			for (int i = 0; i < entropy.length; i++) {
				long update = ((byte) entropy[i]) << ((i % 8) * 8);
				seed ^= update;
			}
			try {
				// Construct and seed a new random number generator
				Class clazz = Class.forName(randomClass);
				this.random = (Random) clazz.newInstance();
				this.random.setSeed(seed);
			} catch (Exception e) {
				// Fall back to the simple case
				this.random = new java.util.Random();
				this.random.setSeed(seed);
			}
		}

		return (this.random);

	}

	protected void getRandomBytes(byte bytes[]) {
		// Generate a byte array containing a session identifier
		if (devRandomSource != null && randomIS == null) {
			setRandomFile(devRandomSource);
		}
		if (randomIS != null) {
			try {
				int len = randomIS.read(bytes);
				if (len == bytes.length) {
					return;
				}
			} catch (Exception ex) {
				// Ignore
			}
			devRandomSource = null;

			try {
				randomIS.close();
			} catch (Exception e) {
			}

			randomIS = null;
		}
		getRandom().nextBytes(bytes);
	}

	/**
	 * Generate and return a new session identifier.
	 */
	public synchronized String generateSessionId() {

		byte random[] = new byte[16];
		String result = null;
		// Render the result as a String of hexadecimal digits
		StringBuffer buffer = new StringBuffer();
		do {
			int resultLenBytes = 0;
			if (result != null) {
				buffer = new StringBuffer();
				duplicates++;
			}
			while (resultLenBytes < this.sessionIdLength) {
				getRandomBytes(random);
				random = getDigest().digest(random);

				for (int j = 0; j < random.length
						&& resultLenBytes < this.sessionIdLength; j++) {
					byte b1 = (byte) ((random[j] & 0xf0) >> 4);
					byte b2 = (byte) (random[j] & 0x0f);
					if (b1 < 10)
						buffer.append((char) ('0' + b1));
					else
						buffer.append((char) ('A' + (b1 - 10)));
					if (b2 < 10)
						buffer.append((char) ('0' + b2));
					else
						buffer.append((char) ('A' + (b2 - 10)));
					resultLenBytes++;
				}
			}
			result = buffer.toString();
		} while (sessions.containsKey(result));
		return (result);

	}

	public static void main(String[] args) {
		// SessionHelp managerBase = new SessionHelp();
		// System.out.println(managerBase.generateSessionId());

		// int a =34;
		// int b=2;
		// do{
		// System.out.println(a);
		// a++;
		// }while(a<b);
		// System.out.println(a);

	}
}
