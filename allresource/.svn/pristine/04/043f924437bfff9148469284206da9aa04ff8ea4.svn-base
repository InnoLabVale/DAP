package com.innovery.mpm.allresource.implementations.action.ssh;

import com.innovery.mpm.allresource.implementations.util.ALLRESOURCECommands;
import com.innovery.mpm.allresource.interfaces.action.ssh.ActionServiceCodeInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ActionServiceCode implements ActionServiceCodeInterface {

	private DAPBeanInterface components;
	
	public String get(String msisdn){
		StringBuffer command =  new StringBuffer();
		command.append(ALLRESOURCECommands.SSH_COMMAND_GET);
		command.append(ALLRESOURCECommands.MSISDN).append(msisdn);
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(ALLRESOURCECommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(ALLRESOURCECommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
