package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionCostControlUnblock implements ActionSubscriberUtilInterface{
	
	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		
		command.append(SUBSCRIBERCommands.ACTION_DATACC_UNBLOCK_CHG);
		if (subscriber.getCtype().equals(DAPBeanInterface.PREPAID) && !subscriber.getNational().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_NAT_TEMPUNBLOCK).append(subscriber.getNational());
		}
		if (!subscriber.getInternational().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_INT_TEMPUNBLOCK).append(subscriber.getInternational());
		}
		
		if (subscriber.getChannel().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SMS)){
			command.append(SUBSCRIBERCommands.PARAMETER_CHANNEL_SMS);
		}
		
		else if (subscriber.getChannel().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SPLASH)){
			command.append(SUBSCRIBERCommands.PARAMETER_CHANNEL_SPLASH);
		}
		
		return command;
	}
}
