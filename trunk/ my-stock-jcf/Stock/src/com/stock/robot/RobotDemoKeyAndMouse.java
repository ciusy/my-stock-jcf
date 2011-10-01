package com.stock.robot;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RobotDemoKeyAndMouse extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1782018907289706593L;
	
	Robot r;

	public RobotDemoKeyAndMouse(){
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		Button btn = new Button("Start");
		btn.addActionListener(this);
		cp.add(btn);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("java.awt.Robot Demo");
		setSize(200, 100);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) { // for "start" button
		try {
			Runtime.getRuntime().exec("notepad.exe"); // launch notepad
			r = new Robot();
			
			r.delay(1000); // wait for notepad to launch

			int[] keys = { KeyEvent.VK_T, KeyEvent.VK_E, KeyEvent.VK_S,
					KeyEvent.VK_T, KeyEvent.VK_ENTER };
			for (int i = 0; i < keys.length; i++)
				sendKey(keys[i]);
			// send mouse event to exit notepad
			sendMouseClick(55, 74); // File
			sendMouseClick(50, 260); // Exit

			sendKey(KeyEvent.VK_TAB); // Don't save
			sendKey(KeyEvent.VK_ENTER);
		} catch (java.io.IOException ex) {
			ex.printStackTrace(); // for Runtime.exec()
		} catch (AWTException ex) {
			ex.printStackTrace(); // for Robot()

		}
	}

	private void sendKey(int keyCode) {
		r.keyPress(keyCode);
		r.keyRelease(keyCode);
		r.delay(500); // for you to see the keystroke
	}

	private void sendMouseClick(int x, int y) {
		r.mouseMove(x, y);
		r.delay(1000); // for you to see the move
		r.mousePress(InputEvent.BUTTON1_MASK);
		r.mouseRelease(InputEvent.BUTTON1_MASK);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RobotDemoKeyAndMouse();
			}
		});
	}
}
