package com.stock.robot;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class RobotNotepad {

	static int keyInput[] = { KeyEvent.VK_J, KeyEvent.VK_A, KeyEvent.VK_V,
			KeyEvent.VK_A, KeyEvent.VK_SPACE, KeyEvent.VK_P, KeyEvent.VK_R,
			KeyEvent.VK_O, KeyEvent.VK_G, KeyEvent.VK_R, KeyEvent.VK_A,
			KeyEvent.VK_M, KeyEvent.VK_M, KeyEvent.VK_I, KeyEvent.VK_N,
			KeyEvent.VK_G, KeyEvent.VK_SPACE, KeyEvent.VK_F, KeyEvent.VK_O,
			KeyEvent.VK_R, KeyEvent.VK_U, KeyEvent.VK_M, KeyEvent.VK_S,
			KeyEvent.VK_SPACE, KeyEvent.VK_PERIOD, KeyEvent.VK_C,
			KeyEvent.VK_O, KeyEvent.VK_M };

	public static void main(String[] args) throws AWTException, IOException {

	Runtime.getRuntime().exec("notepad");
//		Runtime.getRuntime().exec("C:\\stock\\new_pazq\\TdxW.exe");

		Robot robot = new Robot();
		robot.delay(6000);
//		robot.delay(60000);
//		robot.delay(60000);
		for (int i = 0; i < keyInput.length; i++) {

			robot.keyPress(keyInput[i]);

			robot.delay(100);

		}
	}
}
