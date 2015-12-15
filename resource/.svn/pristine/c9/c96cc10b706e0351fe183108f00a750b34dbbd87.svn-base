package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiFafPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.verification.AirResourceVerify;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirFaf implements AirResourceBeanVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String faf_number = ((GuiFafPanel) guiPanel).getNumberText().getText();
		String k_indicator = ((GuiFafPanel) guiPanel).getKindText().getText();
		
		if(!Pattern.matches(AIRRegEx.faf_number_patt, faf_number)){
			components.getNotifications().error(AIRMessages.AIR_FAF_NUMBER_WARNING);
			return false;
		}
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE) || actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			if(!AirResourceVerify.isNumber(k_indicator) || Integer.parseInt(k_indicator)<1 || Integer.parseInt(k_indicator)>65535){
				components.getNotifications().error(AIRMessages.AIR_FAF_K_MANDATORY_WARNING);
				return false;
			}
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_DELETE)){
			if(!k_indicator.equals("") && (!AirResourceVerify.isNumber(k_indicator) || Integer.parseInt(k_indicator)<1 || Integer.parseInt(k_indicator)>65535)){
				components.getNotifications().error(AIRMessages.AIR_FAF_K_WARNING);
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

	public void setGuiPanel(GuiResourcePanelInterface guiPanel) {
		this.guiPanel = guiPanel;
	}
}
