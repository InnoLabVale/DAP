package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ChangePreferentialList{
	
	private DAPBeanInterface components;
	
	private JTextField preferentialList;
	
	
	public boolean execute() {
		
		String zero_999 ="^[0-9]{1,3}$";
		
		if(preferentialList.getText().equals("")){
			components.getNotifications().error("Community id is mandatory");
			return false;
		}
		
		else if(!preferentialList.getText().equals("") && !Pattern.matches(zero_999, preferentialList.getText())){
			components.getNotifications().error("Community id not valid. It must be numerico, from 0 to 999.");
			return false;
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setPreferentialList(JTextField preferentialList) {
		this.preferentialList = preferentialList;
	}
}
