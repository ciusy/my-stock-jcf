package com.stock.robot;

import java.awt.*;
import java.awt.event.*;


public class SendKeyTest extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3685202682002278516L;
	
	private Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	private javax.swing.JTextField text1;
	private javax.swing.JTextField text2;
	Robot r;

	public SendKeyTest() {
		text1 = new javax.swing.JTextField();
		text2 = new javax.swing.JTextField();
		setTitle("Test SendKey");
		getContentPane().setLayout(null);
		getContentPane().add(text1);
		getContentPane().add(text2);
		text1.setBounds(10, 20, 100, 30);
		text2.setBounds(10, 50, 100, 60);
		try {
			r = new Robot();
		} catch (AWTException ex) {
			ex.printStackTrace(); // for Robot()
		}
		text1.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendKey(KeyEvent.VK_TAB);
				}
			}
		});
		text2.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					sendKey(KeyEvent.VK_TAB);
				}
			}
		});
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setSize(360, 360);
		setResizable(false);
		setLocation(d.width / 2 - getWidth() / 2, d.height / 2 - getHeight()
				/ 2);
		setVisible(true);
	}

	private void sendKey(int keyCode) {
		r.keyPress(keyCode);
		r.keyRelease(keyCode);
		r.delay(500); // for you to see the keystroke
	}

	public static void main(String args[]) {
		SendKeyTest sk = new SendKeyTest();
	}
}
