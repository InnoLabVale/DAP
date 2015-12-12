package com.innovery.mpm.ssh.interfaces.gui.verification;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SshResourceVerifyInterface {

	public boolean sshVerify();
	
	public void setComponents(DAPBeanInterface components);
	
	public void setMsisdnField(JTextField msisdnField);

	public void setServiceCodeField(JTextField serviceCodeField);

	public void setServiceCodeDateField(JTextField serviceCodeDateField);

	public void setSmartDateField(JTextField smartDateField);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup);
}
