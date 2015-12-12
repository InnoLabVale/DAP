package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiPamPanel;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirPam implements AirResourceBeanVerifyInterface {

	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String pam_service = ((GuiPamPanel) guiPanel).getServiceText().getText();
		String pam_class = ((GuiPamPanel) guiPanel).getClassText().getText();
		String pam_class_old = ((GuiPamPanel) guiPanel).getClassOldText().getText();
		String pam_class_new = ((GuiPamPanel) guiPanel).getClassNewText().getText();
		String pam_sched = ((GuiPamPanel) guiPanel).getSchedText().getText();
		String pam_sched_old = ((GuiPamPanel) guiPanel).getSchedOldText().getText();
		String pam_sched_new = ((GuiPamPanel) guiPanel).getSchedNewText().getText();
		String pam_period = ((GuiPamPanel) guiPanel).getPamPeriodText().getText();
		String pam_date = ((GuiPamPanel) guiPanel).getPamDateText().getText();
		String pam_priority = ((GuiPamPanel) guiPanel).getPamPriorityText().getText();
		String pam_priority_old = ((GuiPamPanel) guiPanel).getPamPriorityOldText().getText();
		String pam_priority_new = ((GuiPamPanel) guiPanel).getPamPriorityNewText().getText();
		
		String pam_service_patt = "^[0-9]{1,2}$";
		String pam_period_patt = "^[1-9A-Za-z/-]{1,20}$";
		String pam_priority_patt = "^[0-9]{1}";
		
		if(!Pattern.matches(pam_service_patt, pam_service)){
			components.getNotifications().error(AIRMessages.AIR_PAM_SERVICE_ID_WARNING);
			return false;
		}
		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE)){
			if(!Pattern.matches(AIRRegEx.zero_9999, pam_class)){
				components.getNotifications().error(AIRMessages.AIR_PAM_CLASS_ID_WARNING);
				return false;
			}
			if(!Pattern.matches(AIRRegEx.zero_9999, pam_sched)){
				components.getNotifications().error(AIRMessages.AIR_PAM_SCHEDULE_ID_WARNING);
				return false;
			}
			if(!pam_period.equals("") && !Pattern.matches(pam_period_patt, pam_period)){
				components.getNotifications().error(AIRMessages.AIR_PAM_PERIOD_WARNING);
				return false;
			}
			if(!pam_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, pam_date)){
				components.getNotifications().error(AIRMessages.AIR_PAM_DEFERRED_WARNING);
				return false;
			}
			if(!pam_priority.equals("") && !Pattern.matches(pam_priority_patt, pam_priority)){
				components.getNotifications().error(AIRMessages.AIR_PAM_PRIORITY_WARNING);
				return false;
			}
		}
		else if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			if((!pam_class_old.equals("") && pam_class_new.equals("")) || (pam_class_old.equals("") && !pam_class_new.equals(""))){
				components.getNotifications().error(AIRMessages.AIR_PAM_CLASS_ID_OLD_NEW_WARNING);
				return false;
			}
			if(!pam_class_old.equals("") && !Pattern.matches(AIRRegEx.zero_9999, pam_class_old)){
				components.getNotifications().error(AIRMessages.AIR_PAM_CLASS_ID_OLD_WARNING);
			}
			if(!pam_class_new.equals("") && !Pattern.matches(AIRRegEx.zero_9999, pam_class_new)){
				components.getNotifications().error(AIRMessages.AIR_PAM_CLASS_ID_NEW_WARNING);
			}
			if((!pam_sched_old.equals("") && pam_sched_new.equals("")) || (pam_sched_old.equals("") && !pam_sched_new.equals(""))){
				components.getNotifications().error(AIRMessages.AIR_PAM_SCHEDULE_ID_OLD_NEW_WARNING);
				return false;
			}
			if(!pam_sched_old.equals("") && !Pattern.matches(AIRRegEx.zero_9999, pam_sched_old)){
				components.getNotifications().error(AIRMessages.AIR_PAM_SCHEDULE_ID_OLD_WARNING);
			}
			if(!pam_sched_new.equals("") && !Pattern.matches(AIRRegEx.zero_9999, pam_sched_new)){
				components.getNotifications().error(AIRMessages.AIR_PAM_SCHEDULE_ID_NEW_WARNING);
			}
			if(!pam_period.equals("") && !Pattern.matches(pam_period_patt, pam_period)){
				components.getNotifications().error(AIRMessages.AIR_PAM_PERIOD_WARNING);
				return false;
			}
			if(!pam_date.equals("") && !Pattern.matches(AIRRegEx.date_patt, pam_date)){
				components.getNotifications().error(AIRMessages.AIR_PAM_DEFERRED_WARNING);
				return false;
			}
			
			if((!pam_priority_old.equals("") && pam_priority_new.equals(""))||(pam_priority_old.equals("") && !pam_priority_new.equals(""))){
				components.getNotifications().error(AIRMessages.AIR_PAM_PRIORITY_OLD_NEW_WARNING);
				return false;
			}
			
			if((!pam_priority_old.equals("") && !Pattern.matches(pam_priority_patt, pam_priority_old))){
				components.getNotifications().error(AIRMessages.AIR_PAM_PRIORITY_OLD_WARNING);
				return false;
			}
			
			if((!pam_priority_new.equals("") && !Pattern.matches(pam_priority_patt, pam_priority_new))){
				components.getNotifications().error(AIRMessages.AIR_PAM_PRIORITY_NEW_WARNING);
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
