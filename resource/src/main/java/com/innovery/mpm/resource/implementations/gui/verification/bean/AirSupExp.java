package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiSUPExpPanel;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirSupExp implements AirResourceBeanVerifyInterface{

	private DAPBeanInterface components;
	
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String sup_date = ((GuiSUPExpPanel) guiPanel).getSupExpText().getText();
		String sup_date_adj = ((GuiSUPExpPanel) guiPanel).getSupExpAdjText().getText();
		
		if(sup_date.equals("") && sup_date_adj.equals("")){
			components.getNotifications().error(AIRMessages.AIR_SUP_ENDDATE_ABS_REL_WARNING);
			return false;
		}
		if(!sup_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, sup_date)){
			components.getNotifications().error(AIRMessages.AIR_SUP_ENDDATE_ABS_WARNING);
			return false;
		}
		else if(!sup_date_adj.equals("") && (!Pattern.matches(AIRRegEx.zero_999_meno0, sup_date_adj) || Integer.parseInt(sup_date_adj)==0)){
			components.getNotifications().error(AIRMessages.AIR_SUP_ENDDATE_REL_WARNING);
			return false;
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setGuiPanel(GuiResourcePanelInterface guiPanel) {
		this.guiPanel = guiPanel;
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		// TODO Auto-generated method stub
		
	}
}
