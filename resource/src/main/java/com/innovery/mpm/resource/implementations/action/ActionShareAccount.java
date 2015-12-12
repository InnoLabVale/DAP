package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionShareAccount implements ActionResourceInterface{

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
		command.append(AIRCommands.PARAMETER_TRANSACTION);
		command.append(AIRCommands.AIR_COMMAND_SET_SHAREACCOUNT);
		if(!resourceBean.getShareAccount().getUCID().equals("")){
			command.append(AIRCommands.PARAMETER_UC).append(resourceBean.getShareAccount().getUCID());
			if(!resourceBean.getShareAccount().getUCMValueNew().equals("") && resourceBean.getShareAccount().getUCMValueAdj().equals("")){
				command.append(AIRCommands.PARAMETER_UC_ABS_VALUE).append(resourceBean.getShareAccount().getUCMValueNew());
			}
			else if(resourceBean.getShareAccount().getUCMValueNew().equals("") &&!resourceBean.getShareAccount().getUCMValueAdj().equals("")){
				command.append(AIRCommands.PARAMETER_UC_REL_VALUE).append(resourceBean.getShareAccount().getUCMValueAdj());
			}
		}
		if(!resourceBean.getShareAccount().getUTID().equals("") && !resourceBean.getShareAccount().getUTMValueNew().equals("")){
			command.append(AIRCommands.PARAMETER_UT).append(resourceBean.getShareAccount().getUTID());
			command.append(AIRCommands.PARAMETER_UT_ABS_VALUE).append(resourceBean.getShareAccount().getUTMValueNew());
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
		command.append(AIRCommands.AIR_COMMAND_DEL_SHAREACCOUNT+resourceBean.getShareAccount().getUTID());
		
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
		command.append(AIRCommands.AIR_COMMAND_GET_SHAREACCOUNT);
		
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
