package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionLineState implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber,	StringBuffer command) {
		command.append(SUBSCRIBERCommands.ACTION_LINESTATE_CHG);
		command.append(SUBSCRIBERCommands.PARAMETER_LINESTATE).append(subscriber.getLine_state());
		return command;
	}
}
