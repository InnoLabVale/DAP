package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiAccumulatorPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.verification.AirResourceVerify;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirAccumulator implements AirResourceBeanVerifyInterface{
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String accumulator_id = ((GuiAccumulatorPanel) guiPanel).getIdText().getText();
		String accumulator_value_abs = ((GuiAccumulatorPanel) guiPanel).getValueAbsText().getText();
		String accumulator_value_rel = ((GuiAccumulatorPanel) guiPanel).getValueRelText().getText();
		String accumulator_start_date = ((GuiAccumulatorPanel) guiPanel).getStartDateText().getText();
		String accumulator_end_date = ((GuiAccumulatorPanel) guiPanel).getEndDateText().getText();
		
		if(!AirResourceVerify.isNumber(accumulator_id) || Integer.parseInt(accumulator_id)<1 || Integer.parseInt(accumulator_id)>2147483647){
			components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_ID_WARNING);
			return false;
		}
		
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(!AirResourceVerify.isNumber(accumulator_value_abs) || Integer.parseInt(accumulator_value_abs)<-2147483648 || Integer.parseInt(accumulator_value_abs)>2147483647){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_VALUE_ABS_NOT_VALID_WARNING);
				return false;
			}
			if(!accumulator_start_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, accumulator_start_date)){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_STARTDATE_WARNING);
				return false;
			}			
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_DELETE)){
			if(!accumulator_end_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, accumulator_end_date)){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_ENDDATE_WARNING);
				return false;
			}
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			if(accumulator_value_abs.equals("") && accumulator_value_rel.equals("")){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_VALUE_ABS_MANDATORY_WARNING);
				return false;
			}
			if(!accumulator_value_abs.equals("") && (!AirResourceVerify.isNumber(accumulator_value_abs) || Integer.parseInt(accumulator_value_abs)<-2147483648 || Integer.parseInt(accumulator_value_abs)>2147483647)){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_VALUE_ABS_NOT_VALID_WARNING);
				return false;
			}
			if(!accumulator_value_rel.equals("") && (!AirResourceVerify.isNumber(accumulator_value_rel) || Integer.parseInt(accumulator_value_rel)<-2147483648 || Integer.parseInt(accumulator_value_rel)>2147483647)){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_VALUE_REL_NOT_VALID_WARNING);
				return false;
			}
			if(!accumulator_start_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, accumulator_start_date)){
				components.getNotifications().error(AIRMessages.AIR_ACCUMULATOR_STARTDATE_WARNING);
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
