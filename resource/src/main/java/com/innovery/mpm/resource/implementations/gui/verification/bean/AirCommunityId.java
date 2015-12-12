package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiCommunityIdPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirCommunityId implements AirResourceBeanVerifyInterface {

	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String communityNew_1 = ((GuiCommunityIdPanel) guiPanel).getIdNewText_1().getText();
		String communityNew_2 = ((GuiCommunityIdPanel) guiPanel).getIdNewText_2().getText();
		String communityNew_3 = ((GuiCommunityIdPanel) guiPanel).getIdNewText_3().getText();
		
		
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			
			if(communityNew_1.equals("") || (!communityNew_1.equals("") && !Pattern.matches(AIRRegEx.zero_999, communityNew_1))){
				components.getNotifications().error(AIRMessages.AIR_COMMUNITY_1_WARNING);
				return false;
			}
			
			if(!communityNew_2.equals("") && !Pattern.matches(AIRRegEx.zero_999, communityNew_2)){
				components.getNotifications().error(AIRMessages.AIR_COMMUNITY_2_WARNING);
				return false;
			}
			
			if(!communityNew_3.equals("") && !Pattern.matches(AIRRegEx.zero_999, communityNew_3)){
				components.getNotifications().error(AIRMessages.AIR_COMMUNITY_3_WARNING);
				return false;
			}
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setGuiPanel(GuiResourcePanelInterface guiPanel) {
		this.guiPanel = guiPanel;
	}

	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}
}
