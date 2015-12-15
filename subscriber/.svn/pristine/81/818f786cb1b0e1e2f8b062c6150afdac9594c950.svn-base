package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeBillCycle implements ActionSubscriberUtilInterface {
	
	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		if(subscriber.getCtype().equals(DAPBeanInterface.PREPAID)){
			if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE)){
				command.append(SUBSCRIBERCommands.ACTION_BILLCYCLE_IN);
			}
			
			else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE)){
				command.append(SUBSCRIBERCommands.ACTION_BILLCYCLE_CHG);
			}
			
			else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILL_CYCLE)){
				command.append(SUBSCRIBERCommands.ACTION_BILLCYCLE_OUT);
			}
			
			if(!subscriber.getDay().equals("")){
				command.append(SUBSCRIBERCommands.PARAMETER_DAY).append(subscriber.getDay());
			}
		}
		
		else if(subscriber.getCtype().equals(DAPBeanInterface.POSTPAID)){
			command.append(SUBSCRIBERCommands.ACTION_BILLCYCLE_CHG);
			command.append(SUBSCRIBERCommands.PARAMETER_DAY).append(subscriber.getDay());
			command.append(SUBSCRIBERCommands.PARAMETER_MONTH).append(subscriber.getMonth());
		}
		
		return command;
	}
}
