package com.innovery.mpm.allresource.implementations.action.air;

import com.innovery.mpm.allresource.implementations.util.ALLRESOURCECommands;
import com.innovery.mpm.allresource.interfaces.action.air.SpecificActionGetResources;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ActionAccumulator implements SpecificActionGetResources{

	private DAPBeanInterface components;
		
	public String get(String msisdn, String market, String ctype){
		StringBuffer command = new StringBuffer(ALLRESOURCECommands.AIR_COMMAND_GET);
		command.append(ALLRESOURCECommands.TRANSID).append(components.getTRANSID().generateTransID());
		if(market.equals(DAPBeanInterface.CONSUMER)){
			command.append(DAPBeanInterface.CH1);
		}
		else if(market.equals(DAPBeanInterface.CORPORATE)){
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				command.append(DAPBeanInterface.CH2);
			}
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				command.append(DAPBeanInterface.CH1);
			}
		}
		command.append(ALLRESOURCECommands.MSISDN).append(msisdn);
		command.append(ALLRESOURCECommands.ACCUMULATORS);
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(ALLRESOURCECommands.END).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(ALLRESOURCECommands.END).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
