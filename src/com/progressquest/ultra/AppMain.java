package com.progressquest.ultra;

import javax.swing.UIManager;

public class AppMain {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		FrontForm app = new FrontForm();
		app.setVisible(true);
		app.setLocationRelativeTo(null);
	}

}
