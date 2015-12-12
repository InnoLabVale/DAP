package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiOfferIdPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirOfferId implements AirResourceBeanVerifyInterface {

	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String offer_id = ((GuiOfferIdPanel) guiPanel).getIdText().getText();
		String offer_type = ((GuiOfferIdPanel) guiPanel).getTypeText().getText();
		String offer_start = ((GuiOfferIdPanel) guiPanel).getStartDateText().getText();
		String offer_start_adj = ((GuiOfferIdPanel) guiPanel).getStartDateAdjText().getText();
		String offer_end = ((GuiOfferIdPanel) guiPanel).getEndDateText().getText();
		String offer_end_adj = ((GuiOfferIdPanel) guiPanel).getEndDateAdjText().getText();
		
		String offer_type_patt = "^[0-7]{1}$";
		
		if(!Pattern.matches(AIRRegEx.zero_9_piu, offer_id) || Integer.parseInt(offer_id)<1 || Integer.parseInt(offer_id)>2147483647){
			components.getNotifications().error(AIRMessages.AIR_OFFER_ID_WARNING);			
			return false;
		}
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(!offer_type.equals("") && !Pattern.matches(offer_type_patt, offer_type)){
				components.getNotifications().error(AIRMessages.AIR_OFFER_TYPE_WARNING);
				return false;
			}
			if(!offer_start.equals("") && !Pattern.matches(AIRRegEx.date_patt, offer_start)){
				components.getNotifications().error(AIRMessages.AIR_STARTDATE_ABS_WARNING);
				return false;
			}
			if(!offer_start_adj.equals("") && !Pattern.matches(AIRRegEx.zero_999_meno0, offer_start_adj)){
				components.getNotifications().error(AIRMessages.AIR_STARTDATE_REL_WARNING);
				return false;
			}
			
			if(!offer_end.equals("") && !Pattern.matches(AIRRegEx.date_patt, offer_end)){
				components.getNotifications().error(AIRMessages.AIR_ENDDATE_ABS_WARNING);
				return false;
			}
			if(!offer_end_adj.equals("") && !Pattern.matches(AIRRegEx.zero_999_meno0, offer_end_adj)){
				components.getNotifications().error(AIRMessages.AIR_ENDDATE_REL_WARNING);
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
