package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeDataServices implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		command.append(SUBSCRIBERCommands.ACTION_DATASERVICE_CHG);
		if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATA_SERVICE)){
			command.append(SUBSCRIBERCommands.PARAMETER_DATASERVICES_SET);
		}
		else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATA_SERVICE)){
			command.append(SUBSCRIBERCommands.PARAMETER_DATASERVICES_ADD);
		}
		else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATA_SERVICE)){
			command.append(SUBSCRIBERCommands.PARAMETER_DATASERVICES_DEL);
		}
		command.append(subscriber.getData_services());
		return command;
	}
}
