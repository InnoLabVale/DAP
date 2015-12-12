package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeDiscount implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT)){
			command.append(SUBSCRIBERCommands.ACTION_DISCOUNT_IN);
		}
		else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT)){
			command.append(SUBSCRIBERCommands.ACTION_DISCOUNT_OUT);
		}
		command.append(SUBSCRIBERCommands.PARAMETER_DISCOUNT).append(subscriber.getFeediscount());
		if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT) && !subscriber.getFeedelay().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_DELAY).append(subscriber.getFeedelay());
		}
		return command;
	}
}
