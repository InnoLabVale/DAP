package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;

public class ChangeBillCycleVerification {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JComboBox actionComboboxSelection;
	private JTextField dayField;
	private JTextField monthField;
	
	public boolean execute() {
		
		String day_patt = "^1|11|21$";
		String month_patt = "^(pari|dispari)$";
		
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID) && marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
			
			if (actionComboboxSelection.getSelectedIndex()==0) {
				components.getNotifications().error("Select and action for bill cycle.");
				return false;
			}
			
			if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE)){
				if(dayField.getText().equals("") || !Pattern.matches(day_patt, dayField.getText())){
					components.getNotifications().error("Day is mandatory. It must be 1, 11 or 21.");
					return false;
				}
			}
			
			else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE)){
				if(!dayField.getText().equals("") && !Pattern.matches(day_patt, dayField.getText())){
					components.getNotifications().error("Day must be 1, 11 or 21.");
					return false;
				}
			}
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			if(!Pattern.matches(day_patt, dayField.getText())){
				components.getNotifications().error("Day must be 1, 11 or 21.");
				return false;
			}
			
			if(!dayField.getText().equals("") && monthField.getText().equals("")){
				components.getNotifications().error("Day and month must be provided together");
				return false;
			}
			
			else if(!Pattern.matches(month_patt, monthField.getText())){
				components.getNotifications().error("Month must be \"pari\" or \"dispari\".");
				return false;
			}
		}
		return true;
	}


	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}


	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}


	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}


	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}


	public void setActionComboboxSelection(JComboBox actionComboboxSelection) {
		this.actionComboboxSelection = actionComboboxSelection;
	}


	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}


	public void setMonthField(JTextField monthField) {
		this.monthField = monthField;
	}
}
