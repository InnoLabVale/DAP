package com.innovery.mpm.option.interfaces.gui;

import javax.swing.JFrame;

import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

public interface OptionManagmentInitializationInterface {
	
	public void initialize();

	public JFrame getFrame();
	
	public NotificationInterface getNotification();

	public void setNotification(NotificationInterface notification);
}
