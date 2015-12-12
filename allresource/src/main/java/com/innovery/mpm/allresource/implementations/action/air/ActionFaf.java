package com.innovery.mpm.allresource.implementations.action.air;

import com.innovery.mpm.allresource.implementations.util.ALLRESOURCECommands;
import com.innovery.mpm.allresource.interfaces.action.air.SpecificActionGetResources;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ActionFaf implements SpecificActionGetResources{

	private DAPBeanInterface components;
	private final String TRANSID = ":TRANSID,";
	private final String MSISDN = ":MSISDN,";
	private final String FAFLIST = ":REQUESTEDOWNER,3:RETURNDATA,FAFLIST";
	private final String END_COMMAND = ";";
	
	public String get(String msisdn, String market, String ctype){
		StringBuffer command =  new StringBuffer(ALLRESOURCECommands.AIR_COMMAND_GET);
		command.append(TRANSID).append(components.getTRANSID().generateTransID());
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
		command.append(MSISDN).append(msisdn);
		command.append(FAFLIST);
		if(!components.getConnectionManagerCai().getSession().isSessionAvailable()){
			return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(END_COMMAND).toString()).trim();
		}
		return components.getConnectionManagerCai().getSession().getConnectionCai().send(command.append(END_COMMAND).toString()).trim();
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
