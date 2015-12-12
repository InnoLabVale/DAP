package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeMsisdn implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		command.append(SUBSCRIBERCommands.ACTION_MSISDN_CHG);
		command.append(SUBSCRIBERCommands.PARAMETER_MSISDN_NEW).append(subscriber.getMsisdn_new());
		if(!subscriber.getMsisdn_new_refill().equals("")){
			command.append(SUBSCRIBERCommands.PARAMETER_MSISDN_NEW_AMOUNT+"0,VALUE,").append(subscriber.getMsisdn_new_refill());
		}
		return command;
	}
}
