package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberChangeInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;

public class SubscriberChange implements SubscriberChangeInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private ButtonGroup marketButtonGroup;
	
	private JTextField msisdnNewField;
	private JTextField msisdnNewRefillField;
	
	private JLabel msisdnNewLabel;
	private JLabel msisdnNewRefillLabel;
	
	private JLabel tariffPlanLabel;
	private JComboBox tariffPlanComboboxSelection;
	
	private JLabel refillTypeLabel;
	private JComboBox refillTypeComboboxSelection;
	
	private JLabel saveBalanceLabel;
	private JPanel saveBalancePanel;
	
	private JLabel expiryDateLabel;
	private JTextField expiryDateField;
	
	private JLabel feediscountLabel;
	private JTextField feediscountField;
	
	private JLabel feedelayLabel;
	private JTextField feedelayField;
	
	private JLabel actionLabelOnChange;
	
	private JLabel amountLabel;
	private JTextField amountField;
	
	private JLabel dayLabel;
	private JTextField dayField;
	
	private JLabel monthLabel;
	private JTextField monthField;

	private JComboBox actionOnChangeComboboxSelection;
	
	private JLabel lineStateLabel;
	private JPanel lineStatePanel;
	
	private JLabel nationalLabel;
	private JTextField nationalField;
	
	private JLabel internationalLabel;
	private JTextField internationalField;
	
	private JPanel nationalPanel;
	private JPanel internationalPanel;
	
	private JLabel preferentialListLabel;
	private JTextField preferentialListField;
	
	private JLabel unblockLabel;
	private JComboBox channelComboboxSelection;
	
	private SubscriberTariffPlanInterface tariffPlan;
	
	@Override
	public void actionOnSubscriberChangeConsumerPrepaid(int index) {
		switch (index) {
		case 0:
			break;
		case 1:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_MSISDN);
			showChengeMsisdn();
			break;
		case 2:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_TARIFF_PLAN);
			showChangeTariffPlan();
			break;
		case 3:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_BILL_CYCLE);
			showChangeBillCycle();
			break;
		case 4:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DATASERVICES);
			showChangeDataServices();
			break;
		case 5:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC);
			showChengeCostControl();
			break;
		case 6:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK);
			showCostControlBlockUnblock();
			break;
		case 7:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DISCOUNT);
			showChangeDiscount();
			break;
		case 8:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_LINE_STATE);
			showLineState();
			break;
		}
	}
	
	@Override
	public void actionOnSubscriberChangeCorporatePrepaid(int index) {
		switch (index) {
		case 0:
			break;
		case 1:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_MSISDN);
			showChengeMsisdn();
			break;
		case 2:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_TARIFF_PLAN);
			showChangeTariffPlan();
			break;
		case 3:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DATASERVICES);
			showChangeDataServices();
			break;
		case 4:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC);
			showChengeCostControl();
			break;
		case 5:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK);
			showCostControlBlockUnblock();
			break;
		case 6:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DISCOUNT);
			showChangeDiscount();
			break;
		case 7:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_LINE_STATE);
			showLineState();
			break;
		}
	}
	
	@Override
	public void actionOnSubscriberChangePostpaid(int index) {
		switch (index) {
		case 0:
			break;
		case 1:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_MSISDN);
			showChengeMsisdn();
			break;
		case 2:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_TARIFF_PLAN);
			showChangeTariffPlan();
			break;
		case 3:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_BILL_CYCLE);
			showChangeBillCycle();
			break;
		case 4:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DATASERVICES);
			showChangeDataServices();
			break;
		case 5:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC);
			showChengeCostControl();
			break;
		case 6:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_CRM);
			showCostControlBlockUnblock();
			break;
		case 7:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS);
			showCostControlBlockUnblock();
			break;
		case 8:
			actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_PREFERENTIAL_LIST);
			showChangePreferentialList();
			break;
		
		}
	}
	
	@Override
	public void showChengeMsisdn(){
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			
			msisdnNewLabel.setVisible(true);
			msisdnNewField.setVisible(true);
			
			msisdnNewRefillLabel.setVisible(true);
			msisdnNewRefillField.setVisible(true);
			
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			msisdnNewLabel.setVisible(true);
			msisdnNewField.setVisible(true);
		}
	}
	
	private void showChangeTariffPlan() {
		tariffPlan.updateTariffPlanComboList();

		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
				
				tariffPlanLabel.setVisible(true);
				tariffPlanComboboxSelection.setVisible(true);
				
				refillTypeLabel.setVisible(false);
				refillTypeComboboxSelection.setVisible(false);
				
				saveBalanceLabel.setVisible(true);
				saveBalancePanel.setVisible(true);
				
				expiryDateLabel.setVisible(true);
				expiryDateField.setVisible(true);
				
				feediscountLabel.setVisible(true);
				feediscountField.setVisible(true);
				
				feedelayLabel.setVisible(true);
				feedelayField.setVisible(true);
				feedelayField.setEnabled(false);
			}
			else if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
				
				tariffPlanLabel.setVisible(true);
				
				tariffPlanComboboxSelection.setVisible(true);
				
				refillTypeLabel.setText(components.getCommonGUI().optional(refillTypeLabel.getText()));
				refillTypeLabel.setVisible(true);
				refillTypeComboboxSelection.setVisible(true);
				
				amountLabel.setText(components.getCommonGUI().optional(amountLabel.getText()));
				amountLabel.setVisible(true);
				amountField.setVisible(true);
				
				feediscountLabel.setVisible(true);
				feediscountField.setVisible(true);
				
				feedelayLabel.setVisible(true);
				feedelayField.setVisible(true);
				feedelayField.setEnabled(false);
			}
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			tariffPlanLabel.setVisible(true);
			tariffPlanComboboxSelection.setVisible(true);
		}
	}

	private void showChangeBillCycle(){
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			actionOnChangeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_BILLCYCLE_ACTION_LIST));
			actionOnChangeComboboxSelection.setVisible(true);
			actionLabelOnChange.setVisible(true);
			actionLabelOnChange.setText("Bill cycle action*");
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			actionLabelOnChange.setVisible(false);
			
			dayLabel.setText(components.getCommonGUI().mandatory(dayLabel.getText()));
			dayLabel.setVisible(true);
			dayField.setVisible(true);
			
			monthLabel.setText(components.getCommonGUI().mandatory(monthLabel.getText()));
			monthLabel.setVisible(true);
			monthField.setVisible(true);
		}
	}
	
	private void showLineState() {
		lineStateLabel.setVisible(true);
		lineStatePanel.setVisible(true);
	}

	private void showChangeDiscount() {
		actionOnChangeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_DISCOUNT_ACTION_LIST));
		
		actionOnChangeComboboxSelection.setVisible(true);
		actionLabelOnChange.setVisible(true);
		actionLabelOnChange.setText("Discount action*");
	}

	private void showChangeDataServices() {
		actionOnChangeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_DATASERVICES_ACTION_LIST));
		actionOnChangeComboboxSelection.setVisible(true);
		actionLabelOnChange.setVisible(true);
		actionLabelOnChange.setText("Data services action*");
	}

	private void showChengeCostControl() {
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			
			nationalLabel.setText(components.getCommonGUI().mandatory(nationalLabel.getText()));
			nationalLabel.setVisible(true);
			nationalField.setVisible(true);
			
			internationalLabel.setText(components.getCommonGUI().mandatory(internationalLabel.getText()));
			internationalLabel.setVisible(true);
			internationalField.setVisible(true);
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			
			nationalLabel.setVisible(false);
			nationalField.setVisible(false);
			
			internationalLabel.setText(components.getCommonGUI().mandatory(internationalLabel.getText()));
			internationalLabel.setVisible(true);
			internationalField.setVisible(true);
		}
		
		
	}

	private void showCostControlBlockUnblock() {
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			
			nationalLabel.setText(components.getCommonGUI().mandatory(nationalLabel.getText()));
			nationalLabel.setVisible(true);
			nationalPanel.setVisible(true);
			
			internationalLabel.setText(components.getCommonGUI().mandatory(internationalLabel.getText()));
			internationalLabel.setVisible(true);
			internationalPanel.setVisible(true);
		}
		
		else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS)){
				channelComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_CHANNEL_OPTION_LIST));
				unblockLabel.setText(components.getCommonGUI().mandatory(unblockLabel.getText()));
				unblockLabel.setVisible(true);
				channelComboboxSelection.setVisible(true);
			}
			
			else {
				channelComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT));
				unblockLabel.setText(components.getCommonGUI().optional(unblockLabel.getText()));
				unblockLabel.setVisible(false);
				channelComboboxSelection.setVisible(false);
			}
		
			nationalLabel.setText(components.getCommonGUI().mandatory(nationalLabel.getText()));
			nationalLabel.setVisible(false);
			nationalPanel.setVisible(false);
			
			internationalLabel.setText(components.getCommonGUI().mandatory(internationalLabel.getText()));
			internationalLabel.setVisible(true);
			internationalPanel.setVisible(true);
		}
	}
	
	private void showChangePreferentialList(){
		preferentialListLabel.setVisible(true);
		preferentialListField.setVisible(true);
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	@Override
	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setMsisdnNewField(JTextField msisdnNewField) {
		this.msisdnNewField = msisdnNewField;
	}

	@Override
	public void setMsisdnNewRefillField(JTextField msisdnNewRefillField) {
		this.msisdnNewRefillField = msisdnNewRefillField;
	}

	@Override
	public void setMsisdnNewLabel(JLabel msisdnNewLabel) {
		this.msisdnNewLabel = msisdnNewLabel;
	}

	@Override
	public void setMsisdnNewRefillLabel(JLabel msisdnNewRefillLabel) {
		this.msisdnNewRefillLabel = msisdnNewRefillLabel;
	}

	@Override
	public void setTariffPlanLabel(JLabel tariffPlanLabel) {
		this.tariffPlanLabel = tariffPlanLabel;
	}

	@Override
	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection) {
		this.tariffPlanComboboxSelection = tariffPlanComboboxSelection;
	}

	@Override
	public void setRefillTypeLabel(JLabel refillTypeLabel) {
		this.refillTypeLabel = refillTypeLabel;
	}

	@Override
	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection) {
		this.refillTypeComboboxSelection = refillTypeComboboxSelection;
	}

	@Override
	public void setSaveBalanceLabel(JLabel saveBalanceLabel) {
		this.saveBalanceLabel = saveBalanceLabel;
	}

	@Override
	public void setSaveBalancePanel(JPanel saveBalancePanel) {
		this.saveBalancePanel = saveBalancePanel;
	}

	@Override
	public void setExpiryDateLabel(JLabel expiryDateLabel) {
		this.expiryDateLabel = expiryDateLabel;
	}

	@Override
	public void setExpiryDateField(JTextField expiryDateField) {
		this.expiryDateField = expiryDateField;
	}

	@Override
	public void setFeediscountLabel(JLabel feediscountLabel) {
		this.feediscountLabel = feediscountLabel;
	}

	@Override
	public void setFeediscountField(JTextField feediscountField) {
		this.feediscountField = feediscountField;
	}

	@Override
	public void setFeedelayLabel(JLabel feedelayLabel) {
		this.feedelayLabel = feedelayLabel;
	}

	@Override
	public void setFeedelayField(JTextField feedelayField) {
		this.feedelayField = feedelayField;
	}

	@Override
	public void setActionLabelOnChange(JLabel actionLabelOnChange) {
		this.actionLabelOnChange = actionLabelOnChange;
	}

	@Override
	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	@Override
	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	@Override
	public void setDayLabel(JLabel dayLabel) {
		this.dayLabel = dayLabel;
	}

	@Override
	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}

	@Override
	public void setMonthLabel(JLabel monthLabel) {
		this.monthLabel = monthLabel;
	}

	@Override
	public void setMonthField(JTextField monthField) {
		this.monthField = monthField;
	}

	@Override
	public void setActionOnChangeComboboxSelection(JComboBox actionOnChangeComboboxSelection) {
		this.actionOnChangeComboboxSelection = actionOnChangeComboboxSelection;
	}

	@Override
	public void setLineStateLabel(JLabel lineStateLabel) {
		this.lineStateLabel = lineStateLabel;
	}

	@Override
	public void setLineStatePanel(JPanel lineStatePanel) {
		this.lineStatePanel = lineStatePanel;
	}

	@Override
	public void setNationalLabel(JLabel nationalLabel) {
		this.nationalLabel = nationalLabel;
	}

	@Override
	public void setNationalField(JTextField nationalField) {
		this.nationalField = nationalField;
	}

	@Override
	public void setInternationalLabel(JLabel internationalLabel) {
		this.internationalLabel = internationalLabel;
	}

	@Override
	public void setInternationalField(JTextField internationalField) {
		this.internationalField = internationalField;
	}

	@Override
	public void setNationalPanel(JPanel nationalPanel) {
		this.nationalPanel = nationalPanel;
	}

	@Override
	public void setInternationalPanel(JPanel internationalPanel) {
		this.internationalPanel = internationalPanel;
	}

	@Override
	public void setPreferentialListLabel(JLabel preferentialListLabel) {
		this.preferentialListLabel = preferentialListLabel;
	}

	@Override
	public void setPreferentialListField(JTextField preferentialListField) {
		this.preferentialListField = preferentialListField;
	}

	@Override
	public void setUnblockLabel(JLabel unblockLabel) {
		this.unblockLabel = unblockLabel;
	}

	@Override
	public void setChannelComboboxSelection(JComboBox channelComboboxSelection) {
		this.channelComboboxSelection = channelComboboxSelection;
	}

	@Override
	public void setTariffPlan(SubscriberTariffPlanInterface tariffPlan) {
		this.tariffPlan = tariffPlan;
	}
}
