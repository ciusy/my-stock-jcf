package com.stock.robot;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotTest {

	public static void main(String[] args) throws Exception {

		Thread.sleep(10000);

//		sendKey("{Tab}");// tab8
//		sendKey("{<}");// <
		sendKey("600050");
		sendKey("{Enter}");// $
		Thread.sleep(20000);
		sendKey("601628");
		sendKey("{Enter}");// $
		Thread.sleep(20000);
		sendKey("601006");
		sendKey("{Enter}");// $
		Thread.sleep(20000);
//		sendKey("{At}");// @
//		sendKey("{Dollar}");// $
	
//		sendKey("{Up}");// up arrow
		System.out.println("查找到的值： " + (KeyStore.findKeyStore("{Dollar}")).v
				+ "  定义的值：   " + KeyEvent.VK_DOLLAR);
		System.out.println("查找到的值： " + (KeyStore.findKeyStore("{<}")).v
				+ "  定义的值：   " + KeyEvent.VK_TAB);
	}

	static Robot robot;
	static {
		try {
			robot = new Robot();
		} catch (AWTException e) {
		}
	}

	static void sendKey(String ks) {
		KeyStore k = KeyStore.findKeyStore(ks);
		if (k != null) {
			if (k.upCase)
				upCase(k.v);
			else
				sendKey(k.v);
		} else {
			for (int i = 0; i < ks.length(); i++) {
				char c = ks.charAt(i);
				if (c >= '0' && c <= '9') {
					sendKey(c);
				} else if (c >= 'a' && c <= 'z') {
					sendKey(c - 32);
				} else if (c >= 'A' && c <= 'Z') {
					upCase(c);
				}
				// ...
			}
		}
	}

	private static void upCase(int kc) {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(kc);
		robot.keyRelease(kc);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}

	private static void sendKey(int kc) {
		robot.keyPress(kc);
		robot.keyRelease(kc);
	}

	static class KeyStore {
		// special keys
		final static KeyStore[] sp = { new KeyStore("{Tab}", KeyEvent.VK_TAB),// tab
				new KeyStore("{Enter}", KeyEvent.VK_ENTER),// enter
				new KeyStore("{PUp}", KeyEvent.VK_PAGE_UP),// page up
				// ...
				new KeyStore("{<}", KeyEvent.VK_LESS),// <
				// ...
				new KeyStore("{Up}", KeyEvent.VK_UP),// up key
				// ...
				new KeyStore("{At}", KeyEvent.VK_AT, true),// @
				new KeyStore("{Dollar}", KeyEvent.VK_DOLLAR, true),// $
		// ...
		};

		String k;
		int v;
		boolean upCase;

		KeyStore(String k, int v) {
			this(k, v, false);
		}

		KeyStore(String s, int i, boolean up) {
			k = s;
			v = i;
			upCase = up;
		}

		static KeyStore findKeyStore(String k) {
			for (int i = 0; i < sp.length; i++) {
				if (sp[i].k.equals(k))
					return sp[i];
			}
			return null;
		}
	}
}