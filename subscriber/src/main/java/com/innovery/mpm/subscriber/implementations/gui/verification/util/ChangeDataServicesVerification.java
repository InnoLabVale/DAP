package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ChangeDataServicesVerification{
	
	private DAPBeanInterface components;
	
	private JComboBox actionComboboxSelection;
	private ButtonGroup marketButtonGroup;
	private JTextField dataServicesField;
	
	public boolean execute() {
		String cons_patt = "^(ROPZ)[0-9]{3,7}[A-Za-z]{0,1}$";
		String corp_patt = "^(OPTBE|OPT)[0-9]{2,7}$";
		
		if (actionComboboxSelection.getSelectedIndex()==0) {
			components.getNotifications().error("Select and action for change data services.");
			return false;
		}

		if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CONSUMER)	&& !Pattern.matches(cons_patt, dataServicesField.getText())) {
			components.getNotifications().error("Data service for \"consumer\" must be ROPZxxxx.");
			return false;
		} 
		
		else if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE)	&& !Pattern.matches(corp_patt, dataServicesField.getText())) {
			components.getNotifications().error("Data service for \"corporate\" must be OPTxxxx.");
			return false;
		}
		return true;
	}


	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}


	public void setActionComboboxSelection(JComboBox actionComboboxSelection) {
		this.actionComboboxSelection = actionComboboxSelection;
	}


	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}


	public void setDataServicesField(JTextField dataServicesField) {
		this.dataServicesField = dataServicesField;
	}
}
