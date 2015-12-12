package com.innovery.mpm.connection.implementations.util;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

public class Notification implements NotificationInterface {

	public void info(String msg) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, msg, "Info", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void warning(String msg) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, msg, "Warning",	JOptionPane.WARNING_MESSAGE);
	}

	public void error(String msg) {
		UIManager.put("OptionPane.okButtonText", "Ok");
		JOptionPane.showMessageDialog(null, msg, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
