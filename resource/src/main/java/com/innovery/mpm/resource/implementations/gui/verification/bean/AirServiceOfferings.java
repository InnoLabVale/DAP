package com.innovery.mpm.resource.implementations.gui.verification.bean;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiServiceOfferingsPanel;
import com.innovery.mpm.resource.implementations.gui.verification.AirResourceVerify;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRMessages;
import com.innovery.mpm.resource.implementations.util.AIRRegEx;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceBeanVerifyInterface;

public class AirServiceOfferings implements AirResourceBeanVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private GuiResourcePanelInterface guiPanel;
	
	public boolean verify(){
		String service_offerings_bit = ((GuiServiceOfferingsPanel) guiPanel).getSoText().getText();
		String service_offerings_decimal = ((GuiServiceOfferingsPanel) guiPanel).getSo_dec_text().getText();

		if(service_offerings_bit.equals("") && service_offerings_decimal.equals("")){
			components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_BIT_DEC_WARNING);
			return false;
		}
		if(!service_offerings_bit.equals("") && !Pattern.matches(AIRRegEx.so_patt, service_offerings_bit)){
			components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_BIT_WARNING);
			return false;
		}
		if(!service_offerings_decimal.equals("") && !AirResourceVerify.isNumber(service_offerings_decimal)){
			components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_DEC_WARNING);
			return false;
		}

		if(actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_CREATE) || 
		   actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_DELETE) || 
		   actionButtonGroup.getSelection().getActionCommand().equals(AIRActions.AIR_ACTION_SET)){
			
			if(!service_offerings_bit.equals("")){
				
				if(service_offerings_bit.contains(",")){
					String[] bit_list = service_offerings_bit.split(",");
					for(int i=0; i<bit_list.length; i++){
						if((Integer.parseInt(bit_list[i])<1 || Integer.parseInt(bit_list[i])>31)){
							components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_BIT_VALUE_WARNING);
							return false;
						}
					}
				}
				else if(!service_offerings_bit.contains(",")){
					if((Integer.parseInt(service_offerings_bit)<1 || Integer.parseInt(service_offerings_bit)>31)){
						components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_BIT_VALUE_WARNING);
						return false;
					}
				}
			}
			else if(!service_offerings_decimal.equals("") && (Integer.parseInt(service_offerings_decimal)<1 || Integer.parseInt(service_offerings_decimal)>2147483647)){
				components.getNotifications().error(AIRMessages.AIR_SERVICEOFFERINGS_DEC_VALUE_WARNING);
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
