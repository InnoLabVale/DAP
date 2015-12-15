package com.innovery.mpm.af.implementations.action;

import com.innovery.mpm.af.implementations.util.AFActions;
import com.innovery.mpm.af.implementations.util.AFCommands;
import com.innovery.mpm.af.interfaces.action.ActionAccountFinderInterface;
import com.innovery.mpm.af.interfaces.bean.AFinderInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ActionAccountFinder implements ActionAccountFinderInterface{
	
	private DAPBeanInterface components;

	public String executeAfCommand(AFinderInterface af){
		
		StringBuffer command = new StringBuffer();
		
		if(af.getAction().equals(AFActions.AF_ACTION_CREATE)){
			command.append(AFCommands.AF_COMMAND_CREATE);
		}
		
		else if(af.getAction().equals(AFActions.AF_ACTION_DELETE)){
			command.append(AFCommands.AF_COMMAND_DELETE);
		}
		
		else if(af.getAction().equals(AFActions.AF_ACTION_GET)){
			command.append(AFCommands.AF_COMMAND_GET);
		}
		
		command.append(AFCommands.TRANSID).append(components.getTRANSID().generateTransID());
		
		if(af.getMarket().equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(af.getMarket().equals(DAPBeanInterface.CORPORATE)){
			command.append(DAPBeanInterface.CH2);
		}
		
		command.append(AFCommands.MSISDN).append(af.getMsisdn());
		
		if(af.getAction().equals(AFActions.AF_ACTION_CREATE)){
			command.append(AFCommands.SDPHOSTNAME).append(af.getSdp_host_name());
		}
		
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(AFCommands.END).toString()).trim();
		}
		
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(AFCommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
