package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.JTextField;

import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberFeeDiscountVerificationInterface;

public class SubscriberFeeDiscountVerification implements SubscriberFeeDiscountVerificationInterface {
	
	private JTextField feediscountField;
	private JTextField feedelayField;
	
	public void verify(){
		if (feediscountField.getText().length() > 0) {
			if (feediscountField.getText().toUpperCase().contains("ROPZ") || 
				feediscountField.getText().toUpperCase().contains("OPT") || 
				feediscountField.getText().toUpperCase().contains("OPTBE")) {
				
				feedelayField.setEnabled(true);
				feediscountField.setText(feediscountField.getText().toUpperCase());
			}
		} else {
			feedelayField.setEnabled(false);
		}
	}

	public void setFeediscountField(JTextField feediscountField) {
		this.feediscountField = feediscountField;
	}

	public void setFeedelayField(JTextField feedelayField) {
		this.feedelayField = feedelayField;
	}

}
