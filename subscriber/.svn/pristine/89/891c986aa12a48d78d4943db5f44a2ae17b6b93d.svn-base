package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;

public class CostControlVerification{

	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	
	private ButtonGroup nationalButtonGroup;
	private ButtonGroup internationalButtonGroup;
	
	private JComboBox chanelComboBoxSelection;
	
	private JTextField nationaField;
	private JTextField internationalField;
	
	public boolean execute() {
		boolean verifyCostControl = false;

		if (ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)) {
			verifyCostControl = verifyCostControlPrepaid();
		}

		else if (ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)) {
			verifyCostControl = verifyCostControlPostpaid();
		}

		return verifyCostControl;
	}

	private boolean verifyCostControlPrepaid() {
		if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC)) {
			if (nationaField.getText().equals("") && internationalField.getText().equals("")) {
				components.getNotifications().error("At least one of the the Cost Control shall be provided.");
				return false;
			} 
			
			if (!nationaField.getText().equals("") && !isNumber(nationaField.getText())) {
				components.getNotifications().error("National threshold must be numeric.");
				return false;
			} else if (!internationalField.getText().equals("") && !isNumber(internationalField.getText())) {
				components.getNotifications().error("International threshold must be numeric.");
				return false;
			}
			
		} 
		
		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK) && nationalButtonGroup.getSelection() == null && internationalButtonGroup.getSelection() == null) {
			components.getNotifications().error("At least one of the the Cost Control must be provided.");
			return false;
		}
		return true;
	}

	private boolean verifyCostControlPostpaid() {
		if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC)) {
			if (!isNumber(internationalField.getText())) {
				components.getNotifications().error("International threshold must be numeric.");
				return false;
			}
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS)) {
			if (internationalButtonGroup.getSelection() == null) {
				components.getNotifications().error("International Cost Control is mandatory.");
				return false;
			}

			if (chanelComboBoxSelection.getSelectedIndex() == 0) {
				components.getNotifications().error("Select a channel for temporary unblock.");
				return false;
			}
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_CRM) && internationalButtonGroup.getSelection() == null) {
			components.getNotifications().error("International Cost Control is mandatory.");
			return false;
		}
		return true;
	}

	private boolean isNumber(String number) {

		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	public void setNationalButtonGroup(ButtonGroup nationalButtonGroup) {
		this.nationalButtonGroup = nationalButtonGroup;
	}

	public void setInternationalButtonGroup(ButtonGroup internationalButtonGroup) {
		this.internationalButtonGroup = internationalButtonGroup;
	}

	public void setChanelComboBoxSelection(JComboBox chanelComboBoxSelection) {
		this.chanelComboBoxSelection = chanelComboBoxSelection;
	}

	public void setNationaField(JTextField nationaField) {
		this.nationaField = nationaField;
	}

	public void setInternationalField(JTextField internationalField) {
		this.internationalField = internationalField;
	}
}
