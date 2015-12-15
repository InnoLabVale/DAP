package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionAssurance implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT)){
			command.append(SUBSCRIBERCommands.GET_AMOUNT).append(subscriber.getAmount_ids());
		}
		
		else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE)){
			command.append(SUBSCRIBERCommands.GET_PROFILE);
		}
		
		else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES)){
			command.append(SUBSCRIBERCommands.GET_DATASERVICES);
		}
		return command;
	}
}
