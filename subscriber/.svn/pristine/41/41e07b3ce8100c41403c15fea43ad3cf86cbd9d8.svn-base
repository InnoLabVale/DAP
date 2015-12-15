package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.JTextField;

import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberDataServiceVerificationInterface;

public class SubscriberDataServiceVerification implements SubscriberDataServiceVerificationInterface {
	
	private JTextField dataServicesField;
	
	public void verify(){
		if (dataServicesField.getText().length() > 0) {
			if (dataServicesField.getText().toUpperCase().contains("ROPZ") || 
			    dataServicesField.getText().toUpperCase().contains("OPT") || 
			    dataServicesField.getText().toUpperCase().contains("NULL")) {
				
				dataServicesField.setText(dataServicesField.getText().toUpperCase());
			}
		} else {
			dataServicesField.setText(dataServicesField.getText().toLowerCase());
		}
	}

	public void setDataServicesField(JTextField dataServicesField) {
		this.dataServicesField = dataServicesField;
	}
	
}
