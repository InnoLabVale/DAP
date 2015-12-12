package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ChangeMsisdn{
	
	private DAPBeanInterface components;
	private JTextField msisdnNewField;
	private JTextField msisdnNewRefillField;
	private ButtonGroup ctypeButtonGroup;
	
	public boolean execute() {
		String refill_patt = "[0-9]{1,12}$";
		
		if(!isMsisdn(msisdnNewField.getText())){
			components.getNotifications().error("MSISDN NEW is mandatory. Must be numeric, from 1 to 28 digits.");
			return false;
		}
		
		else if(!msisdnNewRefillField.getText().equals("") && !Pattern.matches(refill_patt, msisdnNewRefillField.getText()) && ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			components.getNotifications().error("Refill amount value not valid. It must be numeric, from -999999999999 to 999999999999.");
			return false;
		}
		return true;
	}
	
	private boolean isMsisdn(String msisdn) {
		return Pattern.matches("^[0-9]{1,28}$", msisdn);
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setMsisdnNewField(JTextField msisdnNewField) {
		this.msisdnNewField = msisdnNewField;
	}

	public void setMsisdnNewRefillField(JTextField msisdnNewRefillField) {
		this.msisdnNewRefillField = msisdnNewRefillField;
	}

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}
}
