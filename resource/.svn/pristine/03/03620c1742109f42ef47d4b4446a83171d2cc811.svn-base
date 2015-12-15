package com.innovery.mpm.resource.implementations.gui.verification;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirAccountGroupId;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirAccumulator;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirCommunityId;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirDedicatedAccount;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirFaf;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirLanguage;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirMainBalance;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirOfferId;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirPam;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirPromotionPlan;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirServiceClass;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirServiceOfferings;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirShareAccount;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirSimExp;
import com.innovery.mpm.resource.implementations.gui.verification.bean.AirSupExp;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceVerifyInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;

/**
 * 
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class AirResourceVerify implements AirResourceVerifyInterface{
	
	private DAPBeanInterface components;
	
	private String resourceSelected;
	private JComboBox resourceSelectedComboboxSelection;
	private JTextField msisdnField;
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	private AirResourceBeanVerifyInterface airResourceBean;
	
	@Override
	public boolean verify_input(){
		
		if(resourceSelected==null || resourceSelected.equals(AIRActions.DEFAULT)){
			components.getNotifications().error(AIRMessages.AIR_REOSURCE_WARNING);
			return false;
		}
		
		if(!Pattern.matches(AIRRegEx.msisdn_pattern, msisdnField.getText())){
			components.getNotifications().error(AIRMessages.AIR_MSISDN_WARNING);
			return false;
		}
		
		if(marketButtonGroup.getSelection()==null){
			components.getNotifications().error(AIRMessages.AIR_MARKET_WARNING);
			return false;
		}
		
		if(actionButtonGroup.getSelection()==null){
			components.getNotifications().error(AIRMessages.AIR_ACTION_WARNING);
			return false;
		}
		
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_GET)){
			return true;
		}
		
		if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.ACCOUNT_GRUOP_ID)){
			airResourceBean = new AirAccountGroupId();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.ACCUMULATOR)){
			airResourceBean = new AirAccumulator();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.COMMUNITY)){
			airResourceBean = new AirCommunityId();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.DEDICATED_ACCOUNT)){
			airResourceBean = new AirDedicatedAccount();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.FAF)){
			airResourceBean = new AirFaf();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();		
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.LANGUAGE)){
			airResourceBean = new AirLanguage();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.BALANCE)){
			airResourceBean = new AirMainBalance();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}

		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.OFFER)){
			airResourceBean = new AirOfferId();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.PAM)){
			airResourceBean = new AirPam();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.PROMOTION_PLAN)){
			airResourceBean = new AirPromotionPlan();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.SERVICE_CLASS)){
			airResourceBean = new AirServiceClass();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.SERVICE_OFFERING)){
			airResourceBean = new AirServiceOfferings();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.SHARE_ACCOUNT)){
			airResourceBean = new AirShareAccount();
			airResourceBean.setComponents(components);
			airResourceBean.setActionButtonGroup(actionButtonGroup);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.SIM)){
			airResourceBean = new AirSimExp();
			airResourceBean.setComponents(components);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		
		else if(resourceSelectedComboboxSelection.getSelectedItem().equals(AIRActions.SUP)){
			airResourceBean = new AirSupExp();
			airResourceBean.setComponents(components);
			airResourceBean.setGuiPanel(guiPanel);
			return airResourceBean.verify();
		}
		return true;
	}
	
	public static boolean isNumber(String number){
		
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setResourceSelected(String resourceSelected) {
		this.resourceSelected = resourceSelected;
	}

	@Override
	public void setResourceSelectedComboboxSelection(JComboBox resourceSelectedComboboxSelection) {
		this.resourceSelectedComboboxSelection = resourceSelectedComboboxSelection;
	}

	@Override
	public void setMsisdnField(JTextField msisdnField) {
		this.msisdnField = msisdnField;
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setGuiPanel(GuiResourcePanelInterface guiPanel) {
		this.guiPanel = guiPanel;
	}
}
