package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiPromotionPlanPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirPromotionPlan implements AirResourceBeanVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;

	public boolean verify(){
		String promotion_id = ((GuiPromotionPlanPanel) guiPanel).getIdText().getText();
		String promotion_start = ((GuiPromotionPlanPanel) guiPanel).getStartDateText().getText();
		String promotion_end = ((GuiPromotionPlanPanel) guiPanel).getEndDateText().getText();
		
		if(!Pattern.matches(AIRRegEx.date_patt, promotion_start)){
			components.getNotifications().error(AIRMessages.AIR_PROMOTION_STARTDATE_WARNING);
			return false;
		}
		if(!Pattern.matches(AIRRegEx.date_patt, promotion_end)){
			components.getNotifications().error(AIRMessages.AIR_PROMOTION_ENDDATE_WARNING);
			return false;
		}
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(!Pattern.matches(AIRRegEx.promotion_id_patt, promotion_id)){
				components.getNotifications().error(AIRMessages.AIR_PROMOTION_ID_WARNING);
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
