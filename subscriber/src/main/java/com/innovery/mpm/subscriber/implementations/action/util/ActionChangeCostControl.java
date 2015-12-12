package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeCostControl implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		command.append(SUBSCRIBERCommands.ACTION_DATACC_CHG);
		if (!subscriber.getNational().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_NAT_THRESHOLD).append(subscriber.getNational());
		}
		if (!subscriber.getInternational().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_INT_THRESHOLD).append(subscriber.getInternational());
		}
		return command;
	}
}
