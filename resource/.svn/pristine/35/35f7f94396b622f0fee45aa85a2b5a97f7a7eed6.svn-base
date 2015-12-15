package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionPam implements ActionResourceInterface{

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
		command.append(AIRCommands.AIR_COMMAND_DEF_PAM).append(resourceBean.getPam().getPamServiceId());
		command.append(AIRCommands.PARAMETER_PAMCLASS).append(resourceBean.getPam().getPamClassId());
		command.append(AIRCommands.PARAMETER_PAMSCHED).append(resourceBean.getPam().getPamSchedulId());
		if(!resourceBean.getPam().getCurrentPamPeriod().equals("")){
			command.append(AIRCommands.PARAMETER_PAMPERIOD).append(resourceBean.getPam().getCurrentPamPeriod());
		}
		if(!resourceBean.getPam().getDeferredToDate().equals("")){
			command.append(AIRCommands.PARAMETER_PAMDATE).append(resourceBean.getPam().getDeferredToDate());
		}

		if(!resourceBean.getPam().getService_priority().equals("")){
			command.append(AIRCommands.PARAMETER_PAMPRIORITY).append(resourceBean.getPam().getService_priority());
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
		command.append(AIRCommands.AIR_COMMAND_DEL_PAM).append(resourceBean.getPam().getPamServiceId());
		
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
		command.append(AIRCommands.AIR_COMMAND_SET_PAM).append(resourceBean.getPam().getPamServiceId());
		if(!resourceBean.getPam().getPamClassIdOld().equals("") && !resourceBean.getPam().getPamClassIdNew().equals("")){
			command.append(AIRCommands.PARAMETER_PAMCLASS_OLD).append(resourceBean.getPam().getPamClassIdOld());
			command.append(AIRCommands.PARAMETER_PAMCLASS_NEW).append(resourceBean.getPam().getPamClassIdNew());
		}
		if(!resourceBean.getPam().getPamSchedulIdOld().equals("") && !resourceBean.getPam().getPamSchedulIdNew().equals("")){
			command.append(AIRCommands.PARAMETER_PAMSCHED_OLD).append(resourceBean.getPam().getPamSchedulIdOld());
			command.append(AIRCommands.PARAMETER_PAMSCHED_NEW).append(resourceBean.getPam().getPamSchedulIdNew());
		}
		if(!resourceBean.getPam().getCurrentPamPeriod().equals("")){
			command.append(AIRCommands.PARAMETER_PAMPERIOD).append(resourceBean.getPam().getCurrentPamPeriod());
		}
		if(!resourceBean.getPam().getDeferredToDate().equals("")){
			command.append(AIRCommands.PARAMETER_PAMDATE).append(resourceBean.getPam().getDeferredToDate());
		}
		if(!resourceBean.getPam().getService_priority_old().equals("") && !resourceBean.getPam().getService_priority_new().equals("")){
			command.append(AIRCommands.PARAMETER_PAMPRIORITY_OLD).append(resourceBean.getPam().getService_priority_old());
			command.append(AIRCommands.PARAMETER_PAMPRIORITY_NEW).append(resourceBean.getPam().getService_priority_new());
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
		command.append(AIRCommands.AIR_COMMAND_GET_PAM);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String run(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_RUN_PAM).append(resourceBean.getPam().getPamServiceId());
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
			
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
