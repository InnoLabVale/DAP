package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiDedicatedAccountPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.verification.AirResourceVerify;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirDedicatedAccount implements AirResourceBeanVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String ded_id = ((GuiDedicatedAccountPanel) guiPanel).getIdText().getText();
		String ded_unit = ((GuiDedicatedAccountPanel) guiPanel).getUnitSelected();
		String ded_value_abs = ((GuiDedicatedAccountPanel) guiPanel).getValueText().getText();
		String ded_value_rel = ((GuiDedicatedAccountPanel) guiPanel).getValueAdjText().getText();
		String ded_exp_date = ((GuiDedicatedAccountPanel) guiPanel).getExpiryText().getText();
		String ded_exp_adj_date = ((GuiDedicatedAccountPanel) guiPanel).getExpiryAdjText().getText();
		
		if(!AirResourceVerify.isNumber(ded_id) || Integer.parseInt(ded_id)==0 || Integer.parseInt(ded_id)>2147483647){
			components.getNotifications().error(AIRMessages.AIR_DEDICATED_ID_WARNING);
			return false;
		}
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(ded_unit==null || ded_unit.equals("") || ded_unit.equals(GuiDedicatedAccountPanel.DEFAULT)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_UNIT_WARNING);
				return false;
			}
			if(!ded_value_abs.equals("") && !Pattern.matches(AIRRegEx.zero_999999999999, ded_value_abs)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_VALUE_ABS_WARNING);
				return false;
			}
			if(!ded_exp_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, ded_exp_date)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_ENDDATE_ABS_WARNING);
				return false;
			}			
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_DELETE)){
			if(!ded_exp_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, ded_exp_date)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_ENDDATE_ABS_WARNING);
				return false;
			}
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			if(ded_unit==null || ded_unit.equals("") || ded_unit.equals(GuiDedicatedAccountPanel.DEFAULT)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_UNIT_WARNING);
				return false;
			}
			if(!ded_value_abs.equals("") && !Pattern.matches(AIRRegEx.zero_999999999999, ded_value_abs)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_VALUE_ABS_WARNING);
				return false;
			}
			if(!ded_value_rel.equals("") && !Pattern.matches(AIRRegEx.zero_999999999999_meno, ded_value_rel)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_VALUE_REL_WARNING);
				return false;
			}
			if(!ded_exp_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, ded_exp_date)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_ENDDATE_ABS_WARNING);
				return false;
			}
			if(!ded_exp_adj_date.equals("") && !Pattern.matches(AIRRegEx.zero_999_meno0, ded_exp_adj_date)){
				components.getNotifications().error(AIRMessages.AIR_DEDICATED_ENDDATE_REL_WARNING);
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
