package com.innovery.mpm.provisioning.implementations.gui.util;

import com.innovery.mpm.provisioning.interfaces.gui.BsoResourceInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningResetMethodsInterface;

public class ProvisioningResetMethods implements ProvisioningResetMethodsInterface {

	private BsoResourceInterface reference;
	
	public void optionalParametersAndAction(int toHide) {
		
		reference.getSelectDiscountCombo().setVisible(false); reference.getDiscount_label().setVisible(false);
		reference.getParameter_1_label().setVisible(false); reference.getParameter_1_field().setVisible(false); reference.getParameter_1_field().setText("");
		reference.getParameter_2_label().setVisible(false); reference.getParameter_2_field().setVisible(false); reference.getParameter_2_field().setText("");
		reference.getParameter_3_label().setVisible(false); reference.getParameter_3_field().setVisible(false); reference.getParameter_3_field().setText("");
		reference.getParameter_4_label().setVisible(false); reference.getParameter_4_field().setVisible(false); reference.getParameter_4_field().setText("");
		reference.getParameter_5_label().setVisible(false); reference.getParameter_5_field().setVisible(false); reference.getParameter_5_field().setText("");
		reference.getParameter_6_label().setVisible(false); reference.getParameter_6_field().setVisible(false); reference.getParameter_6_field().setText("");
		
		reference.getCug_action_label().setVisible(false); reference.getRadioGroupChangeCug_panel().setVisible(false); reference.getRadioGroupChangeCug().clearSelection();

		if(toHide == ProvisioningUtil._HIDE_OPTIONAL_ACTION){
			
			reference.getRadioGroupAction().clearSelection();
			reference.getRdbtnIn().setEnabled(false); 
			reference.getRdbtnOut().setEnabled(false); 
			reference.getRdbtnBookOut().setEnabled(false); 
			reference.getRdbtnChange().setEnabled(false); 
			reference.getRdbtnGet().setEnabled(false);
			reference.getTextArea().setText("");
		}
	}

	public void setReference(BsoResourceInterface reference) {
		this.reference = reference;
	}
}