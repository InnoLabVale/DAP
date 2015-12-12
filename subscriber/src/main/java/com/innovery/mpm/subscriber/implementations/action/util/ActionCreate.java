package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionCreate implements ActionSubscriberUtilInterface {
	
	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		
		if(subscriber.getCtype().equals(DAPBeanInterface.PREPAID)){
			command.append(SUBSCRIBERCommands.PARAMETER_TARIFFPLAN).append(subscriber.getTariff_plan());
			if (subscriber.getMarket().equals(DAPBeanInterface.CORPORATE)) {
				command.append(SUBSCRIBERCommands.PARAMETER_REFILLTYPE).append(subscriber.getRefill_type());
			}
			command.append(SUBSCRIBERCommands.PARAMETER_AMOUNTID_CREATE).append(subscriber.getAmount());
			command.append(SUBSCRIBERCommands.PARAMETER_NAT_THRESHOLD).append(subscriber.getNational());
			command.append(SUBSCRIBERCommands.PARAMETER_INT_THRESHOLD).append(subscriber.getInternational());
			if (!subscriber.getData_services().equals("")) {
				command.append(SUBSCRIBERCommands.PARAMETER_DATASERVICES_SET).append(subscriber.getData_services());
			}
			if (!subscriber.getFeediscount().equals("")) {
				command.append(SUBSCRIBERCommands.PARAMETER_DISCOUNT).append(subscriber.getFeediscount());
				command.append(SUBSCRIBERCommands.PARAMETER_DELAY).append(subscriber.getFeedelay());
			}
		}
		
		else if(subscriber.getCtype().equals(DAPBeanInterface.POSTPAID)){
			command.append(SUBSCRIBERCommands.PARAMETER_TARIFFPLAN).append(subscriber.getTariff_plan());
			if(!subscriber.getDay().equals("")){
				command.append(SUBSCRIBERCommands.PARAMETER_DAY).append(subscriber.getDay());
			}
			
			if(!subscriber.getMonth().equals("")){
				command.append(SUBSCRIBERCommands.PARAMETER_MONTH).append(subscriber.getMonth());
			}
			
			if(!subscriber.getInternational().equals("")){
				command.append(SUBSCRIBERCommands.PARAMETER_INT_THRESHOLD).append(subscriber.getInternational());
			}
			
			if (!subscriber.getData_services().equals("")) {
				command.append(SUBSCRIBERCommands.PARAMETER_DATASERVICES_SET).append(subscriber.getData_services());
			}
		}
		return command;
	}
}
