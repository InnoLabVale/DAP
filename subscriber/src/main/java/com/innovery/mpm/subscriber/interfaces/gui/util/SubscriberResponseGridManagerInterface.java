package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SubscriberResponseGridManagerInterface {

	void setFrame(JFrame frame);

	void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup);

	void setActionButtonGroup(ButtonGroup actionButtonGroup);

	void setResponseFieldsetGrid(JPanel responseFieldsetGrid);

	void setResponseFieldset(JPanel responseFieldset);

	void setComponents(DAPBeanInterface components);

	void setResponseGridAssurance(String response_mpm);
}