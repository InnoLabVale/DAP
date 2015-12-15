package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionDedicated implements ActionResourceInterface{

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
		command.append(AIRCommands.AIR_COMMAND_SET_DEDICATED).append(resourceBean.getDedicatedAccount().getDedicatedId());
		command.append(AIRCommands.PARAMETER_DEDICATED_UNIT).append(resourceBean.getDedicatedAccount().getDedicatedUnit());
		if(!resourceBean.getDedicatedAccount().getDedicatedValueNew().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATE_ABS_VALUE).append(resourceBean.getDedicatedAccount().getDedicatedValueNew());
		}
		if(!resourceBean.getDedicatedAccount().getDedicatedExpiry().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATED_ABS_EXPIRYDATE).append(resourceBean.getDedicatedAccount().getDedicatedExpiry());
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
		command.append(AIRCommands.AIR_COMMAND_DEL_DEDICATED).append(resourceBean.getDedicatedAccount().getDedicatedId());
		if(!resourceBean.getDedicatedAccount().getDedicatedExpiry().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATED_ABS_EXPIRYDATE).append(resourceBean.getDedicatedAccount().getDedicatedExpiry());
		}
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String update(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_SET_DEDICATED).append(resourceBean.getDedicatedAccount().getDedicatedId());
		command.append(AIRCommands.PARAMETER_DEDICATED_UNIT).append(resourceBean.getDedicatedAccount().getDedicatedUnit());
		if(!resourceBean.getDedicatedAccount().getDedicatedValueNew().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATE_ABS_VALUE).append(resourceBean.getDedicatedAccount().getDedicatedValueNew());
		}
		if(!resourceBean.getDedicatedAccount().getDedicatedValueRelative().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATE_REL_VALUE).append(resourceBean.getDedicatedAccount().getDedicatedValueRelative());
		}
		if(!resourceBean.getDedicatedAccount().getDedicatedExpiry().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATED_ABS_EXPIRYDATE).append(resourceBean.getDedicatedAccount().getDedicatedExpiry());
		}
		else if(!resourceBean.getDedicatedAccount().getDedicatedExpiryAdjustment().equals("")){
			command.append(AIRCommands.PARAMETER_DEDICATED_REL_EXPIRYDATE).append(resourceBean.getDedicatedAccount().getDedicatedExpiryAdjustment());
		}
		
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

	public String run(CommonResourceInterface resourceBean) {
		return null;
	}
}
