package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberAssuranceInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberChangeInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberCreateInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTypeInterface;

public class SubscriberType implements SubscriberTypeInterface {
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private SubscriberCreateInterface createManager;
	private SubscriberAssuranceInterface assuranceManager;
	private SubscriberChangeInterface change;
	private JComboBox changeComboboxSelection;

	@Override
	public void actionOnPrepaid(){
		
		if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE)){
			createManager.showCreateOnPrepaid();
		}
		else if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE)){
			changeComboboxSelection.setEnabled(false);
		}
		else if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN)){
			assuranceManager.showAssurancePrepaid();
		}
		else if(actionButtonGroup.getSelection()!=null && actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG)){	
			if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
				change.actionOnSubscriberChangeConsumerPrepaid(changeComboboxSelection.getSelectedIndex());
			}
			else if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
				change.actionOnSubscriberChangeCorporatePrepaid(changeComboboxSelection.getSelectedIndex());
			}
			
		}
	}
	
	@Override
	public void actionOnPostpaid(){
		
		if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE)){
			createManager.showCreateOnPostpaid();
		}
		else if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE)){
			changeComboboxSelection.setEnabled(false);
		}
		else if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE)
				|| (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN)){
			assuranceManager.showAssurancePostpaid();
		}
		
		else if(actionButtonGroup.getSelection()!=null && actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG)){
			change.actionOnSubscriberChangePostpaid(changeComboboxSelection.getSelectedIndex());
			
		}
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setCreateManager(SubscriberCreateInterface createManager) {
		this.createManager = createManager;
	}

	@Override
	public void setAssuranceManager(SubscriberAssuranceInterface assuranceManager) {
		this.assuranceManager = assuranceManager;
	}

	@Override
	public void setChange(SubscriberChangeInterface change) {
		this.change = change;
	}

	@Override
	public void setChangeComboboxSelection(JComboBox changeComboboxSelection) {
		this.changeComboboxSelection = changeComboboxSelection;
	}
}