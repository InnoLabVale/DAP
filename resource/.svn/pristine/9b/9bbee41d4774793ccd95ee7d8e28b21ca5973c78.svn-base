package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionMainBalance implements ActionResourceInterface{

	private DAPBeanInterface components;
	
	public String update(CommonResourceInterface resourceBean){
		
		String response_ok ="^RESP:TRANSID,[A-Za-z0-9]+:0:[A-Za-z0-9\\-\\_\\;\\:\\,]+\\;$";
		String internal_get = internatGet(resourceBean);
		
		if(!internal_get.matches(response_ok)){
			components.getLogger().error("ERROR IN BALANCE GET: "+internal_get);
			return internal_get;
		}
		
		String mainBalanceValue = internalBalanceValueExtractor(internal_get);
		if(!mainBalanceValue.equals("0")){
			
			String clearBalanceReset = internalResetCurrentBalance(resourceBean.getMsisdn(), resourceBean.getMarket(), mainBalanceValue).trim();
			if(!clearBalanceReset.matches(response_ok)){
				components.getLogger().error("ERROR IN BALANCE RESET: "+clearBalanceReset);
				return clearBalanceReset;
			}
		}
		return internalNewBalanceSetter(resourceBean.getMsisdn(), resourceBean.getMainBalance().getAdjustment(), resourceBean.getMarket());
	}
	
	private String internatGet(CommonResourceInterface resourceBean){
		
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
			return internalSplitter(components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim());
			
		}
		return internalSplitter(components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim());
	}
	
	private String internalBalanceValueExtractor(String internal_response_mpm){
		internal_response_mpm = internal_response_mpm.trim().replace(";", "");
		String[] internal_response_mpm_parts = internal_response_mpm.split(":");
		String[] current_main_balance_paramenter_value = internal_response_mpm_parts[3].split(",");
		String current_main_balance_value = current_main_balance_paramenter_value[1];
		components.getLogger().info("BALANCE VALUE BEFORE RESET "+current_main_balance_value);
		return current_main_balance_value;
	}
	
	private String internalResetCurrentBalance(String msisdn, String market, String current_value){

		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(market.equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(market.equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(msisdn);
		if(!current_value.contains("-")){
			command.append(AIRCommands.PARAMETER_BALANCE_NEGATIVE_ADJ).append(current_value);
		}
		else if(current_value.contains("-")){
			command.append(AIRCommands.PARAMETER_BALANCE_POSITIVE_ADJ).append(current_value.replace("-", ""));
		}
		command.append(AIRCommands.PARAMETER_TRANSACTION);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return internalSplitter(components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim());
			
		}
		return internalSplitter(components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim());
	}
	
	private String internalSplitter(String internal_mpm_response){
		String[] internal_response_parts = internal_mpm_response.trim().replace(AIRCommands.END, "").split("\\:");
		
		String internal_response_main_balance = null;
		
		for(int i=0; i<internal_response_parts.length; i++){
			if(!internal_response_parts[2].equals("0")){
				internal_response_main_balance = internal_mpm_response;
			}
			
			else if(internal_response_parts[i].contains("ACCOUNTVALUE1")){
				internal_response_main_balance = internal_response_parts[0]+":"
												+internal_response_parts[1]+":"
												+internal_response_parts[2]+":"
												+internal_response_parts[i]+";";
			}
		}
		return internal_response_main_balance;
	}
	
	private String internalNewBalanceSetter(String msisdn, String value_adj, String market){
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(market.equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(market.equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(msisdn);
		command.append(AIRCommands.PARAMETER_BALANCE_POSITIVE_ADJ).append(value_adj);
		command.append(AIRCommands.PARAMETER_TRANSACTION);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return internalSplitter(components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim());
			
		}
		return internalSplitter(components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim());
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
