package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiMainBalancePanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirMainBalance implements AirResourceBeanVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String main_account = ((GuiMainBalancePanel) guiPanel).getMainBalanceText().getText();
		
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			if(!Pattern.matches(AIRRegEx.main_account_patt, main_account)){
				components.getNotifications().error(AIRMessages.AIR_MAIN_WARNING);
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
