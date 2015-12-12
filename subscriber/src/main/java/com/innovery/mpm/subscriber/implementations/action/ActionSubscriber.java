package com.innovery.mpm.subscriber.implementations.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.action.util.ActionAssurance;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeBillCycle;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeCostControl;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeDataServices;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeMsisdn;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeTariffPlan;
import com.innovery.mpm.subscriber.implementations.action.util.ActionCostControlUnblock;
import com.innovery.mpm.subscriber.implementations.action.util.ActionCreate;
import com.innovery.mpm.subscriber.implementations.action.util.ActionLineState;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.implementations.action.util.ActionChangeDiscount;
import com.innovery.mpm.subscriber.interfaces.action.ActionSubscriberInterface;
import com.innovery.mpm.subscriber.interfaces.action.util.ActionSubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class ActionSubscriber implements ActionSubscriberInterface {
	
	private DAPBeanInterface components;

	public String executeBsoSubscriberCommand(SubscriberBeanInterface subscriber) {
		
		ActionSubscriberUtilInterface actionUtil;
		StringBuffer command;
		
		if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE)){
			
			command = new StringBuffer(SUBSCRIBERCommands.CREATE);
			command.append(SUBSCRIBERCommands.TRANSID).append(components.getTRANSID().generateTransID());
			command.append(SUBSCRIBERCommands.MSISDN).append(subscriber.getMsisdn());
			
			if(subscriber.getMarket().equals(DAPBeanInterface.CONSUMER) && subscriber.getCtype().equals(DAPBeanInterface.PREPAID)){
				command.append(SUBSCRIBERCommands.SERVICE_MNP);
			}
			
			else if(subscriber.getMarket().equals(DAPBeanInterface.CONSUMER) && subscriber.getCtype().equals(DAPBeanInterface.POSTPAID)){
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			}
			
			else if(subscriber.getMarket().equals(DAPBeanInterface.CORPORATE) && subscriber.getCtype().equals(DAPBeanInterface.PREPAID)){
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			}
			
			else if(subscriber.getMarket().equals(DAPBeanInterface.CORPORATE) && subscriber.getCtype().equals(DAPBeanInterface.POSTPAID)){
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			}
			
			else {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			}
			
			command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
			command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
			
			actionUtil = new ActionCreate();
			command = actionUtil.execute(subscriber, command);
		}

		else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE)) {
			command = new StringBuffer(SUBSCRIBERCommands.DELETE);
			command.append(SUBSCRIBERCommands.TRANSID).append(components.getTRANSID().generateTransID());
			command.append(SUBSCRIBERCommands.MSISDN).append(subscriber.getMsisdn());		
			command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
			command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
		} 
		
		else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE)) {
			command = new StringBuffer(SUBSCRIBERCommands.GET);
			command.append(SUBSCRIBERCommands.TRANSID).append(components.getTRANSID().generateTransID());
			command.append(SUBSCRIBERCommands.MSISDN).append(subscriber.getMsisdn());
			
			if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN)){
				command.append(SUBSCRIBERCommands.SERVICE_TARIFF_PLAN);
			}
			
			else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE)){
				command.append(SUBSCRIBERCommands.SERVICE_BILL_CYCLE);
			}
			else{
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
			}
			command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
			command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
			
			actionUtil = new ActionAssurance();
			command = actionUtil.execute(subscriber, command);
		} 
		
		else{
			
			command = new StringBuffer(SUBSCRIBERCommands.SET);
			command.append(SUBSCRIBERCommands.TRANSID).append(components.getTRANSID().generateTransID());
			command.append(SUBSCRIBERCommands.MSISDN).append(subscriber.getMsisdn());
			
			if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC)) {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeCostControl();
				command = actionUtil.execute(subscriber, command);
			} 
			
			else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_CRM) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS)) {
				if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS)){
					command.append(SUBSCRIBERCommands.SERVICE_NIS);
				}
				
				else {
					command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				}
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionCostControlUnblock();
				command = actionUtil.execute(subscriber, command);
			} 
			
			else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATA_SERVICE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATA_SERVICE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATA_SERVICE)) {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeDataServices();
				command = actionUtil.execute(subscriber, command);
			}
			
			else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_TARIFF_PLAN)) {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeTariffPlan();
				command = actionUtil.execute(subscriber, command);
			}
			
			else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_BILL_CYCLE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILL_CYCLE)){
				command.append(SUBSCRIBERCommands.SERVICE_BILL_CYCLE);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeBillCycle();
				command = actionUtil.execute(subscriber, command);
			}
			
			else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT) || subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT)) {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeDiscount();
				command = actionUtil.execute(subscriber, command);
			}
			
			else if(subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_MSISDN)){
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionChangeMsisdn();
				command = actionUtil.execute(subscriber, command);
			}
			
			else if (subscriber.getAction().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_LINE_STATE)) {
				command.append(SUBSCRIBERCommands.SERVICE_ACCOUNT);
				command.append(SUBSCRIBERCommands.MARKET).append(subscriber.getMarket());
				command.append(SUBSCRIBERCommands.CTYPE).append(subscriber.getCtype());
				actionUtil = new ActionLineState();
				command = actionUtil.execute(subscriber, command);
			} 
		}
		
		return components.getConnectionManagerStandard().getSession().getConnection().send(command.append(SUBSCRIBERCommands.END).toString().trim());
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
