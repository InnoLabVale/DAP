package com.innovery.mpm.ssh.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.ssh.implementations.util.SSHActions;
import com.innovery.mpm.ssh.implementations.util.SSHCommands;
import com.innovery.mpm.ssh.interfaces.action.ActionServiceCodeInterface;
import com.innovery.mpm.ssh.interfaces.bean.ServiceCodeInterface;

public class ActionServiceCode implements ActionServiceCodeInterface{
	
	private DAPBeanInterface components;

	public String executeServiceCodeCommand(ServiceCodeInterface serviceCode){
		String action = serviceCode.getAction();
		StringBuffer command = new StringBuffer();
		if(action.equals(SSHActions.SSH_ACTION_CREATE)){
			command = createServiceCode(serviceCode);
		}
		else if(action.equals(SSHActions.SSH_ACTION_DELETE)){
			command = deleteServiceCode(serviceCode);
		}
		else if(action.equals(SSHActions.SSH_ACTION_GET)){
			command = getServiceCode(serviceCode);
		}
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(SSHCommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(SSHCommands.END).toString()).trim();
	}

	private StringBuffer createServiceCode(ServiceCodeInterface serviceCode){
		StringBuffer command = new StringBuffer(SSHCommands.SSH_COMMAND_CREATE);
		command.append(SSHCommands.MSISDN).append(serviceCode.getMsisdn());
		if(!serviceCode.getServiceCodeId().equals("") && !serviceCode.getActivationDate().equals("")){
			command.append(SSHCommands.PARAMETER_SET_SERVICECODE).append(serviceCode.getServiceCodeId());
			command.append(SSHCommands.PARAMETER_ACTIVATION_DATE).append(serviceCode.getActivationDate());
		}
		if(!serviceCode.getSmartStartDate_text().equals("")){
			command.append(SSHCommands.PARAMETER_SET_SMART_START_DATE).append(serviceCode.getSmartStartDate_text());
		}
		return command;
	}
	
	private StringBuffer deleteServiceCode(ServiceCodeInterface serviceCode){
		StringBuffer command =  new StringBuffer();
		if(!serviceCode.getServiceCodeId().equals("")){
			command.append(SSHCommands.SSH_COMMAND_DELETE);
			command.append(SSHCommands.MSISDN).append(serviceCode.getMsisdn());
			command.append(SSHCommands.PARAMETER_DEL_SERVICECODE).append(serviceCode.getServiceCodeId());
			if(serviceCode.isSmartStartDate_check()){
				command.append(SSHCommands.PARAMETER_DEL_SMART_START_DATE);
			}
		}
		
		else if(serviceCode.getServiceCodeId().equals("")){
			
			if(serviceCode.isSmartStartDate_check()){
				command.append(SSHCommands.SSH_COMMAND_SET);
				command.append(SSHCommands.MSISDN).append(serviceCode.getMsisdn());
				command.append(SSHCommands.PARAMETER_DEL_SMART_START_DATE);
			}
			
			else {
				command.append(SSHCommands.SSH_COMMAND_DELETE);
				command.append(SSHCommands.MSISDN).append(serviceCode.getMsisdn());
			}
		}
		return command;
	}
	
	private StringBuffer getServiceCode(ServiceCodeInterface serviceCode){
		StringBuffer command =  new StringBuffer(SSHCommands.SSH_COMMAND_GET);
		command.append(SSHCommands.MSISDN).append(serviceCode.getMsisdn());
		if(!serviceCode.getServiceCodeId().equals("")){
			command.append(SSHCommands.PARAMETER_GET_SERVICECODE).append(serviceCode.getServiceCodeId());
		}
		return command;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
