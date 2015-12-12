package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionServiceOfferingsInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionServiceOffering implements ActionServiceOfferingsInterface{
	
	private DAPBeanInterface components;

	public String createBit(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		if(resourceBean.getServiceOfferings().getServiceofferingsList()==null || resourceBean.getServiceOfferings().getServiceofferingsList().length==0){
			command.append(AIRCommands.AIR_COMMAND_SET_SERVICEOFFERINGS+resourceBean.getServiceOfferings().getServiceOffering()).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG_ON);
		}
		else if(resourceBean.getServiceOfferings().getServiceofferingsList()!=null && resourceBean.getServiceOfferings().getServiceofferingsList().length!=0){
			command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGS);
			for(int i=0; i<resourceBean.getServiceOfferings().getServiceofferingsList().length; i++){
				command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGSID+resourceBean.getServiceOfferings().getServiceofferingsList()[i]).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG_ON);
			}
		}
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String deleteBit(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		if(resourceBean.getServiceOfferings().getServiceofferingsList()==null || resourceBean.getServiceOfferings().getServiceofferingsList().length==0){
			command.append(AIRCommands.AIR_COMMAND_SET_SERVICEOFFERINGS+resourceBean.getServiceOfferings().getServiceOffering()).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG_OFF);
		}
		else if(resourceBean.getServiceOfferings().getServiceofferingsList()!=null && resourceBean.getServiceOfferings().getServiceofferingsList().length!=0){
			command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGS);
			for(int i=0; i<resourceBean.getServiceOfferings().getServiceofferingsList().length; i++){
				command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGSID+resourceBean.getServiceOfferings().getServiceofferingsList()[i]).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG_OFF);
			}
		}
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String createDecimal(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGS);
		for(int i=0; i<resourceBean.getServiceOfferings().getServiceofferingsList().length; i++){
			command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGSID).append(i+1).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG).append(resourceBean.getServiceOfferings().getServiceofferingsList()[i]);
		}
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}
	
	public String deleteDecimal(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGS);
		for(int i=0; i<resourceBean.getServiceOfferings().getServiceofferingsList().length; i++){
			if(resourceBean.getServiceOfferings().getServiceofferingsList()[i].equals("1")){
				command.append(AIRCommands.AIR_COMMAND_SERVICEOFFERINGSID).append(i+1).append(AIRCommands.PARAMETER_SERVICEOFFERINGS_FLAG_OFF);
			}
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
		command.append(AIRCommands.AIR_COMMAND_GET_ACCOUNTDETAILS);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
