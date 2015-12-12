package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionAccumulator implements ActionResourceInterface{

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
		command.append(AIRCommands.AIR_COMMAND_SET_ACCUMULATORS).append(resourceBean.getAccumulator().getAccId());
		if(!resourceBean.getAccumulator().getAccValueAbs().equals("")){
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_ABS_VALUE).append(resourceBean.getAccumulator().getAccValueAbs());
		}		
		if(!resourceBean.getAccumulator().getStartDate().equals(""))
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_STARTDATE).append(resourceBean.getAccumulator().getStartDate());
		
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
		command.append(AIRCommands.AIR_COMMAND_DEL_ACCUMULATORS).append(resourceBean.getAccumulator().getAccId());
		if(!resourceBean.getAccumulator().getEndDate().equals("")){
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_ENDDATE).append(resourceBean.getAccumulator().getEndDate());
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
		command.append(AIRCommands.AIR_COMMAND_SET_ACCUMULATORS).append(resourceBean.getAccumulator().getAccId());
		if(!resourceBean.getAccumulator().getAccValueAbs().equals("") && resourceBean.getAccumulator().getAccValueRel().equals("")){
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_ABS_VALUE).append(resourceBean.getAccumulator().getAccValueAbs());
		}	
		else if(resourceBean.getAccumulator().getAccValueAbs().equals("") && !resourceBean.getAccumulator().getAccValueRel().equals("")){
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_REL_VALUE).append(resourceBean.getAccumulator().getAccValueRel());
		}
		if(!resourceBean.getAccumulator().getStartDate().equals("")){
			command.append(AIRCommands.PARAMETER_ACCUMULATORS_STARTDATE).append(resourceBean.getAccumulator().getStartDate());
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
		command.append(AIRCommands.AIR_COMMAND_GET_ACCUMULATORS);
		
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
