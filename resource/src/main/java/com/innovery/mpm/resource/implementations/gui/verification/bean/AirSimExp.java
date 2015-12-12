package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiSIMExpPanel;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirSimExp implements AirResourceBeanVerifyInterface {

	private DAPBeanInterface components;
	
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String sim_date = ((GuiSIMExpPanel) guiPanel).getSimExpText().getText();
		String sim_date_adj = ((GuiSIMExpPanel) guiPanel).getSimExpAdjText().getText();
		
		if(sim_date.equals("") && sim_date_adj.equals("")){
			components.getNotifications().error(AIRMessages.AIR_SIM_ENDDATE_ABS_REL_WARNING);
			return false;
		}
		if(!sim_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, sim_date)){
			components.getNotifications().error(AIRMessages.AIR_SIM_ENDDATE_ABS_WARNING);
			return false;
		}
		else if(!sim_date_adj.equals("") && !Pattern.matches(AIRRegEx.zero_999_meno0, sim_date_adj) && Integer.parseInt(sim_date_adj)==0){
			components.getNotifications().error(AIRMessages.AIR_SIM_ENDDATE_REL_WARNING);
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
	}
}
