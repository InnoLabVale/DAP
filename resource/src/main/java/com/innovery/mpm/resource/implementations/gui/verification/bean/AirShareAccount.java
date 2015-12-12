package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiShareAccountPanel;
import com.innovery.mpm.resource.implementations.gui.verification.AirResourceVerify;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirShareAccount implements AirResourceBeanVerifyInterface {

	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String uc_id = ((GuiShareAccountPanel) guiPanel).getUcText().getText();
		String uc_value = ((GuiShareAccountPanel) guiPanel).getUcValueText().getText();
		String uc_value_adj = ((GuiShareAccountPanel) guiPanel).getUcValueAdjText().getText();
		String ut_id =((GuiShareAccountPanel) guiPanel).getUtText().getText();
		String ut_value = ((GuiShareAccountPanel) guiPanel).getUtValueText().getText();
		
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(uc_id.equals("") && ut_id.equals("")){
				components.getNotifications().error(AIRMessages.AIR_UT_UC_WARNING);
				return false;
			}
			
			if(!uc_id.equals("")){
				if(!AirResourceVerify.isNumber(uc_id) || Integer.parseInt(uc_id)<1 || Integer.parseInt(uc_id)>2147483647){
					components.getNotifications().error(AIRMessages.AIR_UC_ID_WARNING);
					return false;
				}
				if(uc_value.equals("") && uc_value_adj.equals("")){
					components.getNotifications().error(AIRMessages.AIR_UC_VALUE_ABS_REL_WARNING);
					return false;
				}
				if(!uc_value.equals("") && !Pattern.matches(AIRRegEx.zero_999999999999, uc_value)){
					components.getNotifications().error(AIRMessages.AIR_UC_VALUE_ABS_WARNING);
					return false;
				}
				if(!uc_value_adj.equals("") && !Pattern.matches(AIRRegEx.zero_999999999999_meno, uc_value_adj)){
					components.getNotifications().error(AIRMessages.AIR_UC_VALUE_REL_WARNING);
					return false;
				}
			}
				
				
			if(!ut_id.equals("")){
				if(!AirResourceVerify.isNumber(ut_id) || Integer.parseInt(ut_id)<1 || Integer.parseInt(ut_id)>2147483647){
					components.getNotifications().error(AIRMessages.AIR_UT_ID_WARNING);
					return false;
				}
				if(ut_value.equals("")){
					components.getNotifications().error(AIRMessages.AIR_UT_ID_VALUE_WARNING);
					return false;
				}
				if(!ut_value.equals("") && (!Pattern.matches(AIRRegEx.zero_999999999999, ut_value))){
					components.getNotifications().error(AIRMessages.AIR_UT_VALUE_WARNING);
					return false;
				}
			}
		}
			
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_DELETE)){
			if(ut_id.equals("")){
				components.getNotifications().error(AIRMessages.AIR_UT_ID_MANDATORY_WARNING);
				return false;
			}
			else if(!AirResourceVerify.isNumber(ut_id) || Integer.parseInt(ut_id)<1 || Integer.parseInt(ut_id)>2147483647){
				components.getNotifications().error(AIRMessages.AIR_UT_ID_WARNING);
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
