package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionOfferId implements ActionResourceInterface{

	private DAPBeanInterface components;
	
	public String create(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_SET_OFFER).append(resourceBean.getOfferId().getOfferId());
		if(!resourceBean.getOfferId().getStartDate().equals("") && resourceBean.getOfferId().getStartDateRelative().equals("")){
			command.append(AIRCommands.PARAMETER_OFFER_ABS_STARTDATE).append(resourceBean.getOfferId().getStartDate());
		}
		if(resourceBean.getOfferId().getStartDate().equals("") && !resourceBean.getOfferId().getStartDateRelative().equals("")){
			command.append(AIRCommands.PARAMETER_OFFER_REL_STARTDATE).append(resourceBean.getOfferId().getStartDateRelative());
		}
		if(!resourceBean.getOfferId().getExpiryDate().equals("") && resourceBean.getOfferId().getExpiryDateRelative().equals("")){
			command.append(AIRCommands.PARAMETER_OFFER_ABS_EXPIRYDATE).append(resourceBean.getOfferId().getExpiryDate());
		}
		else if(resourceBean.getOfferId().getExpiryDate().equals("") && !resourceBean.getOfferId().getExpiryDateRelative().equals("")){
			command.append(AIRCommands.PARAMETER_OFFER_REL_EXPIRYDATE).append(resourceBean.getOfferId().getExpiryDateRelative());
		}
		if(!resourceBean.getOfferId().getType().equals("")){
			command.append(AIRCommands.PARAMETER_OFFER_TYPE).append(resourceBean.getOfferId().getType());
		}

		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String delete(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_DEL_OFFER).append(resourceBean.getOfferId().getOfferId());
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String get(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_GET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_GET_BALANCEANDDATE);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public String update(CommonResourceInterface resourceBean) {
		return null;
	}

	public String run(CommonResourceInterface resourceBean) {
		return null;
	}
}
