package com.innovery.mpm.provisioning.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface BsoResponseGridManagmentInterface {

	public void setResponseGridAssurance(String response_mpm);

	public void setComponents(DAPBeanInterface components);

	void setActionButtonGroup(ButtonGroup actionButtonGroup);

	void setResponseGridField(JPanel responseGridField);

	void setResponseField(JPanel responseField);
}