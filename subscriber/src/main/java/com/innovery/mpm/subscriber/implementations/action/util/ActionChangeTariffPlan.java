package com.innovery.mpm.subscriber.implementations.action.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionChangeTariffPlan implements ActionSubscriberUtilInterface {

	public StringBuffer execute(SubscriberBeanInterface subscriber, StringBuffer command) {
		command.append(SUBSCRIBERCommands.ACTION_TARIFFPLAN_CHG);
		command.append(SUBSCRIBERCommands.PARAMETER_TARIFFPLAN).append(subscriber.getTariff_plan());
		if (subscriber.getMarket().equals(DAPBeanInterface.CONSUMER)) {
			if (!subscriber.getSave_balance().equals("") && !subscriber.getExpiry_date().equals("")) {
				command.append(SUBSCRIBERCommands.PARAMETER_SAVEBALANCE).append(subscriber.getSave_balance());
				command.append(SUBSCRIBERCommands.PARAMETER_EXPIRYDATE).append(subscriber.getExpiry_date());
			}
		}
		if (subscriber.getMarket().equals(DAPBeanInterface.CORPORATE)) {
			if (!subscriber.getRefill_type().equals("") && !subscriber.getAmount().equals("")) {
				command.append(SUBSCRIBERCommands.PARAMETER_REFILLTYPE).append(subscriber.getRefill_type());
				command.append(SUBSCRIBERCommands.PARAMETER_AMOUNTID).append(subscriber.getAmount());
			}
		}
		if (!subscriber.getFeediscount().equals("")	&& !subscriber.getFeedelay().equals("")) {
			command.append(SUBSCRIBERCommands.PARAMETER_DISCOUNT).append(subscriber.getFeediscount());
			command.append(SUBSCRIBERCommands.PARAMETER_DELAY).append(subscriber.getFeedelay());
		}
		return command;
	}
}
