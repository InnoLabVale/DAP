package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;

public class ActionSUPExp implements ActionResourceInterface{

	private DAPBeanInterface components;
	
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
		command.append(AIRCommands.PARAMETER_BALANCEANDDATE);
		if(!resourceBean.getSup().getSupExpDate().equals("")){
			command.append(AIRCommands.PARAMETER_SUPEXP_ABS_EXPIRYDATE).append(resourceBean.getSup().getSupExpDate());
		}
		else if(!resourceBean.getSup().getSupExpDateAdj().equals("")){
			command.append(AIRCommands.PARAMETER_SUPEXP_REL_EXPIRYDATE).append(resourceBean.getSup().getSupExpDateAdj());
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
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn()).append(AIRCommands.AIR_COMMAND_GET_ACCOUNTDETAILS);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public String create(CommonResourceInterface resourceBean) {
		return null;
	}

	public String delete(CommonResourceInterface resourceBean) {
		return null;
	}

	public String run(CommonResourceInterface resourceBean) {
		return null;
	}
}
