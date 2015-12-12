package com.innovery.mpm.af.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface AccountFinderResponseManagerInterface {

	public void getResponse();
	
	public void setComponents(DAPBeanInterface components);
	
	public void setGridManager(AccountFinderResponseGridManagerInterface gridManager);

	public void setTextArea(JTextArea textArea);

	public void setBtnExecute(JButton btnExecute);

	public void setMsisdnField(JTextField msisdnField);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup);

	public void setSdpComboboxSelection(JComboBox sdpComboboxSelection);
}
