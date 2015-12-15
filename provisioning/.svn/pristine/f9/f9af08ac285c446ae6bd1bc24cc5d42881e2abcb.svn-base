package com.innovery.mpm.provisioning.implementations.gui.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.provisioning.implementations.gui.util.options.ProvisioningDiscount;
import com.innovery.mpm.provisioning.implementations.gui.util.options.ProvisioningMaster;
import com.innovery.mpm.provisioning.implementations.gui.util.options.ProvisioningPostpone;
import com.innovery.mpm.provisioning.implementations.gui.util.options.ProvisioningTariffPlan;
import com.innovery.mpm.provisioning.implementations.gui.util.parameters.ProvisioningParameters;
import com.innovery.mpm.provisioning.implementations.util.OPTION_FAMILY;
import com.innovery.mpm.provisioning.implementations.xml.XmlScanner;
import com.innovery.mpm.provisioning.interfaces.gui.BsoResourceInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningUtilInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningOptionLoaderInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningResetMethodsInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.options.ProvisioningDiscountInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.options.ProvisioningMasterInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.options.ProvisioningPostponeInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.options.ProvisioningTariffPlanInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.parameters.ProvisioningParametersInterface;
import com.innovery.mpm.provisioning.interfaces.xml.XmlScannerInterface;

public class ProvisioningUtil implements ProvisioningUtilInterface{

	private BsoResourceInterface reference;
	private DAPBeanInterface components;
	
	private ProvisioningMasterInterface master;
	private ProvisioningDiscountInterface discount;
	private ProvisioningPostponeInterface postpone;
	private ProvisioningTariffPlanInterface tariff_plan;
	private ProvisioningOptionLoaderInterface optionLoader;
	private ProvisioningResetMethodsInterface reset;
	private ProvisioningParametersInterface option_parameters;
	private XmlScannerInterface option_scanner;
	
	public static final int _HIDE_OPTIONAL_ONLY = 1;
	public static final int _HIDE_OPTIONAL_ACTION = 2;
	
	public void marketSelection(){
		reset.optionalParametersAndAction(_HIDE_OPTIONAL_ACTION);
		if(reference.getRadioGroupCtype()!=null && reference.getRadioGroupCtype().getSelection()!=null){
			optionLoader.load();
			reference.getSelectOptionCombo().setEnabled(true);
		}
	}
	
	public void ctypeSelection(){
		reset.optionalParametersAndAction(_HIDE_OPTIONAL_ACTION);
		if(reference.getRadioGroupMarket().getSelection()!=null){
			optionLoader.load();
			reference.getSelectOptionCombo().setEnabled(true);
		}
	}
	
	public void serviceSelection(){
		reset.optionalParametersAndAction(_HIDE_OPTIONAL_ACTION);
		if (reference.getSelectOptionCombo().getSelectedIndex()!=0) {
			showActions();
		} 
	}
	
	public void actionSelection() {
		if (reference.getSelectOptionCombo().getSelectedIndex()!=0  && reference.getRadioGroupAction().getSelection()!=null) {
			reset.optionalParametersAndAction(_HIDE_OPTIONAL_ONLY);
			String parameters = null;
			parameters = option_scanner.getParameters(reference.getRadioGroupAction().getSelection().getActionCommand());
			components.getLogger().info("PARAMETERS: "+parameters);
			
			TechincalOptions();
			
			if(parameters!=null){
				showParameters(parameters);
			}
		}
	}
	
	private void showActions(){
		if (reference.getSelectOptionCombo().getSelectedIndex()!=0) {
			String actions = null;
			option_scanner.setReference(reference);
			actions = option_scanner.getAction();
			if (actions != null) {
				if (actions.equals(OPTION_FAMILY.POSTPONE)) {
					postpone = new ProvisioningPostpone();
					postpone.setReference(reference);
					postpone.setComponents(components);
					postpone.enable();
				}else if(actions.equals(OPTION_FAMILY.DISCOUNT)){
					discount = new ProvisioningDiscount();
					discount.setReference(reference);
					discount.setComponents(components);
					discount.enable();
				}else if(actions.equals(OPTION_FAMILY.TARIFF_PLAN) || ((String) reference.getSelectOptionCombo().getSelectedItem()).startsWith("GET")){
					tariff_plan = new ProvisioningTariffPlan();
					tariff_plan.setReference(reference);
					tariff_plan.enable();
				}else if (!actions.equals(OPTION_FAMILY.POSTPONE) && !actions.equals(OPTION_FAMILY.DISCOUNT)) {
					master = new ProvisioningMaster();
					master.setReference(reference);
					master.setComponents(components);
					master.enable(actions);
				}
			}
		}
	}
	
	private void showParameters(String parameters){
		if(parameters!=null && !parameters.equals("")){
			String[] parametersList = parameters.split("\\|");
			reference.setParametersList(parametersList);
			reference.getInputParametersRegex().clear();
			for (int i = 0; i < reference.getParametersList().length; i++) {
				
				String new_parameter;
				
				if(reference.getParametersList()[i].contains("[") && reference.getParametersList()[i].contains("]")){
					new_parameter = components.getCommonGUI().optional(reference.getParametersList()[i]);
				}
				else {
					new_parameter = components.getCommonGUI().mandatory(reference.getParametersList()[i]);
				}
				
				reference.getLabelList().get(i).setText(new_parameter);
				reference.getInputParametersRegex().add(option_scanner.getRegex(reference.getParametersList()[i]));
				
				if(reference.getLabelList().get(i).getText().contains("FEEDISCOUNT")){
					option_parameters.enableParameterDiscount(i);
				}
				else{
					option_parameters.enableOtherParameters(i);
				}
			}
		}
	}
	
	private void TechincalOptions(){
		if(reference.getSelectOptionCombo().getSelectedItem().equals("cug")){
			option_parameters.enableTechnicalOptionParameters();
		}
	}
	
	public void backButtonActionPerformed() {
		if (reference.getBtnExecute().getActionCommand().equals("reconnect")) {
			components.getLogger().info("Clicked on Reconnect");
			
			String redirect = components.getConnectionManagerStandard().reconnectionStandard(reference.getBtnExecute().getActionCommand());
			
			reference.getTextArea().setText(redirect);
			reference.getGrid_managment().resetResponseGrid();
			reference.getGrid_managment().setResponseGridStatusMessage(redirect);
			if (redirect.equals(components.getErrorMessages().get_RELOGGED())) {
				reference.getBtnExecute().setText("Execute");
				reference.getBtnExecute().setActionCommand("execute");
			}
			else if (redirect.equals(components.getErrorMessages().get_NOT_LOGGED_ERROR()) || 
					 redirect.equals(components.getErrorMessages().get_MPM_CONNECTION_ERROR()) || 
					 redirect.equals(components.getErrorMessages().get_MPM_ERROR())) {
				reference.getBtnExecute().setText("Home");
				reference.getBtnExecute().setActionCommand("home");
			}

		} else if (reference.getBtnExecute().getActionCommand().equals("home")){
			components.getLogger().info("Clicked on Home");
			reference.getFrame().dispose();
		}
	}

	public void setReference(BsoResourceInterface reference) {
		this.reference = reference;
		
		optionLoader = new ProvisioningOptionLoader();
		optionLoader.setReference(this.reference);
		
		reset = new ProvisioningResetMethods();
		reset.setReference(this.reference);
		
		option_parameters = new ProvisioningParameters();
		option_parameters.setReference(this.reference);
		
		option_scanner = new XmlScanner();
		
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
		optionLoader.setComponents(components);
		option_scanner.setComponents(components);
	}
}
