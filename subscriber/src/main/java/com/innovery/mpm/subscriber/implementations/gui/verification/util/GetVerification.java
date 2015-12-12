package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;

public class GetVerification{
	
	private DAPBeanInterface components;
	
	private ButtonGroup getButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JTextField amountIdField;
	
	public boolean execute() {
		String ids_patt = "^0(,\\d||,\\d\\d||,\\d\\d\\d)*$";
		
		if (getButtonGroup.getSelection() == null) {
			if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
				components.getNotifications().error("Select assurance type, \"amount\", \"profile\", \"data services\" or \"bill cycle\".");
			}
			
			else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
				components.getNotifications().error("Select assurance type, \"tariff plan\", \"profile\", \"data services\" or \"bill cycle\".");
			}
			
			return false;
		} 
		
		else if (getButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT) && !Pattern.matches(ids_patt, amountIdField.getText())) {
			components.getNotifications().error("IDs not valid. If \"amount\" is selected, IDs is mandatory and must be 0 followed by DAs identifiers, separated by comma.");
			return false;
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setGetButtonGroup(ButtonGroup getButtonGroup) {
		this.getButtonGroup = getButtonGroup;
	}

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	public void setAmountIdField(JTextField amountIdField) {
		this.amountIdField = amountIdField;
	}
}
