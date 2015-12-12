package com.innovery.mpm.resource.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;
import com.innovery.mpm.resource.implementations.util.AIRCommands;
import com.innovery.mpm.resource.interfaces.action.ActionResourceInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public class ActionCommunity implements ActionResourceInterface{

	private DAPBeanInterface components;
	private String internal_get_transid;
	private String NOT_FOUND = "not_found";
	
	public String update(CommonResourceInterface resourceBean){
		
		String standard_response = "RESP:TRANSID,<transid>:0:NEGOTIATEDCAPABILITIES,0:AVAILABLESERVERCAPABILITIES,512;";
		String response_ok ="^RESP:TRANSID,[A-Za-z0-9]+:0:[A-Za-z0-9\\-\\_\\;\\:\\,]+\\;$";
		
		String internal_get = internalGet(resourceBean);
		components.getLogger().info("INTERNAL REQUEST COMMUNITY: "+internal_get);
		
		if(!internal_get.matches(response_ok) && !internal_get.equals(NOT_FOUND)){
			return internal_get;
		}
		
		String current_id_1 = null;
		String current_id_2 = null;
		String current_id_3 = null;
		
		if(!internal_get.equals(NOT_FOUND)){
			String[] community_present_configuration = ((internal_get.replace(AIRCommands.END, "")).split("\\:")[3]).split(",");
			if(community_present_configuration.length==2){
				current_id_1 = community_present_configuration[1];
				current_id_2 = "";
				current_id_3 = "";
			}
			
			else if(community_present_configuration.length==3){
				current_id_1 = community_present_configuration[1];
				current_id_2 = community_present_configuration[2];
				current_id_3 = "";
			}
			
			else if(community_present_configuration.length==4){
				current_id_1 = community_present_configuration[1];
				current_id_2 = community_present_configuration[2];
				current_id_3 = community_present_configuration[3];
			}
		}
		
		else {
			if(resourceBean.getAction().equals(AIRActions.AIR_ACTION_DELETE)){
				return standard_response.replace("<transid>", internal_get_transid);
			}
			
			current_id_1 = "";
			current_id_2 = "";
			current_id_3 = "";
		}
		
		resourceBean.getCommunityId().setCommOld_1(current_id_1);
		resourceBean.getCommunityId().setCommOld_2(current_id_2);
		resourceBean.getCommunityId().setCommOld_3(current_id_3);
		
		return internalUpdate(resourceBean);
	}
	
	private String internalUpdate(CommonResourceInterface resourceBean){
		
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_SET);
		command.append(AIRCommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		
		command.append(AIRCommands.PARAMETER_COMMUNITY_NEW);
		
		if(!resourceBean.getCommunityId().getCommNew_1().equals("")){
			command.append(resourceBean.getCommunityId().getCommNew_1());
			
			if(!resourceBean.getCommunityId().getCommNew_2().equals("")){
				command.append(",").append(resourceBean.getCommunityId().getCommNew_2());
				
				if(!resourceBean.getCommunityId().getCommNew_3().equals("")){
					command.append(",").append(resourceBean.getCommunityId().getCommNew_3());
				}
				
				else if(!resourceBean.getCommunityId().getCommOld_3().equals("")){
					command.append(",");
				}
			}
			
			else if(!resourceBean.getCommunityId().getCommOld_2().equals("")){
				
				if(!resourceBean.getCommunityId().getCommOld_3().equals("")){
					command.append(",");
				}
				
				command.append(",");
			}
		}
		
		command.append(AIRCommands.PARAMETER_COMMUNITY_OLD);
		
		if(!(resourceBean.getCommunityId().getCommOld_1()).equals("")){
			command.append(resourceBean.getCommunityId().getCommOld_1());
			
			if(!resourceBean.getCommunityId().getCommOld_2().equals("")){
				command.append(",").append(resourceBean.getCommunityId().getCommOld_2());
				
				if(!resourceBean.getCommunityId().getCommOld_3().equals("")){
					command.append(",").append(resourceBean.getCommunityId().getCommOld_3());
				}
				
				else if(!resourceBean.getCommunityId().getCommNew_3().equals("")){
					command.append(",");
				}
			}
			
			else if(!resourceBean.getCommunityId().getCommNew_2().equals("")){
				
				if(!resourceBean.getCommunityId().getCommNew_3().equals("")){
					command.append(",");
				}
				
				command.append(",");
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
	
	private String internalGet(CommonResourceInterface resourceBean){
		
		internal_get_transid =  components.getTRANSID().generateTransID();
		StringBuffer command = new StringBuffer(AIRCommands.AIR_COMMAND_GET);
		command.append(AIRCommands.TRANSID).append(internal_get_transid);
		if(resourceBean.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(resourceBean.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		command.append(AIRCommands.MSISDN).append(resourceBean.getMsisdn());
		command.append(AIRCommands.AIR_COMMAND_GET_ACCOUNTDETAILS);
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return internalSplitter(components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AIRCommands.END).toString()).trim());
			
		}
		return internalSplitter(components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AIRCommands.END).toString()).trim());
	}
	
	private String internalSplitter(String internal_mpm_response){
		String[] internal_response_parts = internal_mpm_response.trim().replace(AIRCommands.END, "").split("\\:");
		
		String internal_response_main_balance = NOT_FOUND;
		
		for(int i=0; i<internal_response_parts.length; i++){
			if(!internal_response_parts[2].equals("0")){
				internal_response_main_balance = internal_mpm_response;
			}
			
			else if(internal_response_parts[i].contains(AIRCommands.PARAMETER_COMMUNITY_LIST)){
				internal_response_main_balance = internal_response_parts[0]+":"
												+internal_response_parts[1]+":"
												+internal_response_parts[2]+":"
												+internal_response_parts[i]+";";
			}
		}
		return internal_response_main_balance;
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
