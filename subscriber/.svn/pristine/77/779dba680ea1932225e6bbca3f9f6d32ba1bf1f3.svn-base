package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberAssuranceInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberChangeInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberCreateInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTypeInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberUtilInterface;

public class SubscriberUtil implements SubscriberUtilInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private ButtonGroup nationalButtonGroup;
	private ButtonGroup internationalButtonGroup;
	private ButtonGroup saveBalanceButtonGroup;
	private ButtonGroup lineStateButtonGroup;
	
	private JButton btnExecute;
	private JFrame frame;
	private JTextArea textArea;
	
	private JComboBox changeComboboxSelection;
	private JComboBox tariffPlanComboboxSelection;
	private JComboBox refillTypeComboboxSelection;
	private JComboBox channelComboboxSelection;
	private JComboBox actionOnChangeComboboxSelection;
	
	private JRadioButton rdbtnPrepaid;
	private JRadioButton rdbtnPostpaid;
	private JRadioButton rdbtnConsumer;
	private JRadioButton rdbtnCorporate;
	private JRadioButton rdbtnGet;
	
	private JTextField msisdnNewField;
	private JTextField msisdnNewRefillField;
	private JTextField expiryDateField;
	private JTextField dayField;
	private JTextField amountField;
	private JTextField feediscountField;
	private JTextField feedelayField;
	private JTextField monthField;
	private JTextField nationalField;
	private JTextField internationalField;
	private JTextField preferentialListField;
	private JTextField dataServicesField;
	private JTextField msisdnField;
	private JTextField amountIdField;
	
	private JLabel msisdnNewLabel;
	private JLabel msisdnNewRefillLabel;
	private JLabel tariffPlanLabel;
	private JLabel refillTypeLabel;
	private JLabel saveBalanceLabel;
	private JLabel expiryDateLabel;
	private JLabel feediscountLabel;
	private JLabel feedelayLabel;
	private JLabel actionOnChangeLabel;
	private JLabel amountLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel lineStateLabel;
	private JLabel dataServicesLabel;
	private JLabel assuranceLabel;
	private JLabel nationalLabel;
	private JLabel internationalLabel;
	private JLabel preferentialListLabel;
	private JLabel channelLabel;
	private JLabel amountIdLabel;
	
	private JPanel saveBalancePanel;
	private JPanel lineStatePanel;
	private JPanel nationalPanel;
	private JPanel internationalPanel;
	private JPanel assurancePanel;
	
	private SubscriberTypeInterface type;
	private SubscriberCreateInterface createManager;
	private SubscriberAssuranceInterface assuranceManager;
	private SubscriberChangeInterface changeManager;
	private SubscriberTariffPlanInterface tariffPlanManager;
	
	@Override
	public void commonActionOnActionRadioButton(){
		if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE) || 
		   (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE) || 
		   (actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET)){
			
			changeComboboxSelection.setSelectedIndex(0);
			changeComboboxSelection.setEnabled(false);
		}
		else if((actionButtonGroup.getSelection().getActionCommand()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG)){
			changeComboboxSelection.setEnabled(true);
		}
		clearAll();
		hideAll();
		enableCommonFields();
	}
	
	@Override
	public void actionOnCType(){
		setSubscriberCreateClass();
		
		type.setActionButtonGroup(actionButtonGroup);
		type.setMarketButtonGroup(marketButtonGroup);
		type.setChange(changeManager);
		type.setChangeComboboxSelection(changeComboboxSelection);
		type.setCreateManager(createManager);
		type.setAssuranceManager(assuranceManager);
		
		clearAll();
		hideAll();
		
		if(actionButtonGroup.getSelection()!=null && marketButtonGroup.getSelection()!=null && ctypeButtonGroup.getSelection()!=null){
			if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
				if(changeComboboxSelection.getSelectedIndex()==0){
					if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
						changeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_CONSUMER_PREPAID_CAHNGE_OPTIONS_LIST));
					}
					
					else if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
						changeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_CORPORATE_PREPAID_CAHNGE_OPTIONS_LIST));
					}
					
				}
				hideAll();
				clearAll();
				type.actionOnPrepaid();
			}
			else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
				if(changeComboboxSelection.getSelectedIndex()==0){
					changeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_POSTPAID_CHANGE_OPTIONS_LIST));
				}
				hideAll();
				clearAll();
				type.actionOnPostpaid();
			}
		}
	}
	
	@Override
	public void actionOnChangeCombo(){
		setSubscriberChangeClass();
		
		if(ctypeButtonGroup.getSelection()!=null && ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
			if(marketButtonGroup.getSelection()!=null && marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
				hideAll();
				clearAll();
				changeManager.actionOnSubscriberChangeConsumerPrepaid(changeComboboxSelection.getSelectedIndex());
			}
			else if(marketButtonGroup.getSelection()!=null && marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
				hideAll();
				clearAll();
				changeManager.actionOnSubscriberChangeCorporatePrepaid(changeComboboxSelection.getSelectedIndex());
			}
			
		}
		
		else if(ctypeButtonGroup.getSelection()!=null && ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			hideAll();
			clearAll();
			changeManager.actionOnSubscriberChangePostpaid(changeComboboxSelection.getSelectedIndex());
		}
	}
	
	@Override
	public void hideAll(){
		
		tariffPlanLabel.setVisible(false);
		tariffPlanComboboxSelection.setVisible(false);
		
		preferentialListLabel.setVisible(false);
		preferentialListField.setVisible(false);
		
		msisdnNewLabel.setVisible(false);
		msisdnNewField.setVisible(false);
		
		msisdnNewRefillLabel.setVisible(false);
		msisdnNewRefillField.setVisible(false);
		
		refillTypeLabel.setVisible(false);
		refillTypeComboboxSelection.setVisible(false);
		
		dayLabel.setVisible(false);
		dayField.setVisible(false);
		
		monthLabel.setVisible(false);
		monthField.setVisible(false);
		
		amountLabel.setVisible(false);
		amountField.setVisible(false);
		
		nationalPanel.setVisible(false);
		nationalLabel.setVisible(false);
		nationalField.setVisible(false);
		
		internationalPanel.setVisible(false);
		internationalLabel.setVisible(false);
		internationalField.setVisible(false);
		
		dataServicesLabel.setVisible(false);
		dataServicesField.setVisible(false);
		
		actionOnChangeLabel.setVisible(false);
		actionOnChangeComboboxSelection.setVisible(false);
		
		feediscountLabel.setVisible(false);
		feediscountField.setVisible(false);
		
		feedelayLabel.setVisible(false);
		feedelayField.setVisible(false);
		feedelayField.setEnabled(false);
		
		saveBalancePanel.setVisible(false);
		saveBalanceLabel.setVisible(false);
		
		expiryDateLabel.setVisible(false);
		expiryDateField.setVisible(false);
		
		assuranceLabel.setVisible(false);
		assurancePanel.setVisible(false);
		
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		
		lineStateLabel.setVisible(false);
		lineStatePanel.setVisible(false);
		
		channelComboboxSelection.setVisible(false);
		channelLabel.setVisible(false);
	}
	
	@Override
	public void clearAll(){
		tariffPlanComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT));
		tariffPlanComboboxSelection.setSelectedIndex(0);
		preferentialListField.setText("");
		msisdnNewField.setText("");
		msisdnNewRefillField.setText("");
		refillTypeComboboxSelection.setSelectedIndex(0);
		dayField.setText("");
		monthField.setText("");
		amountField.setText("");
		nationalButtonGroup.clearSelection();
		nationalField.setText("");
		internationalButtonGroup.clearSelection();
		internationalField.setText("");
		dataServicesField.setText("");
		feediscountField.setText("");
		saveBalanceButtonGroup.clearSelection();
		expiryDateField.setText("");
		amountIdField.setText("0");
		actionOnChangeComboboxSelection.setSelectedIndex(0);
		lineStateButtonGroup.clearSelection();
		channelComboboxSelection.setSelectedIndex(0);
	}
	
	@Override
	public void enableCommonFields(){
		msisdnField.setEnabled(true);
		rdbtnPrepaid.setEnabled(true);
		rdbtnPostpaid.setEnabled(true);
		rdbtnConsumer.setEnabled(true);
		rdbtnCorporate.setEnabled(true);
	}
	
	private void setSubscriberChangeClass(){
		changeManager.setActionButtonGroup(actionButtonGroup);
		changeManager.setMarketButtonGroup(marketButtonGroup);
		changeManager.setCtypeButtonGroup(ctypeButtonGroup);
		changeManager.setMsisdnNewField(msisdnNewField);
		changeManager.setMsisdnNewLabel(msisdnNewLabel);
		changeManager.setMsisdnNewRefillField(msisdnNewRefillField);
		changeManager.setMsisdnNewRefillLabel(msisdnNewRefillLabel);
		changeManager.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		changeManager.setTariffPlanLabel(tariffPlanLabel);
		changeManager.setTariffPlan(tariffPlanManager);
		changeManager.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
		changeManager.setRefillTypeLabel(refillTypeLabel);
		changeManager.setSaveBalanceLabel(saveBalanceLabel);
		changeManager.setSaveBalancePanel(saveBalancePanel);
		changeManager.setExpiryDateField(expiryDateField);
		changeManager.setExpiryDateLabel(expiryDateLabel);
		changeManager.setFeediscountField(feediscountField);
		changeManager.setFeediscountLabel(feediscountLabel);
		changeManager.setFeedelayField(feedelayField);
		changeManager.setFeedelayLabel(feedelayLabel);
		changeManager.setActionLabelOnChange(actionOnChangeLabel);
		changeManager.setActionOnChangeComboboxSelection(actionOnChangeComboboxSelection);
		changeManager.setAmountField(amountField);
		changeManager.setAmountLabel(amountLabel);
		changeManager.setDayField(dayField);
		changeManager.setDayLabel(dayLabel);
		changeManager.setMonthField(monthField);
		changeManager.setMonthLabel(monthLabel);
		changeManager.setLineStateLabel(lineStateLabel);
		changeManager.setLineStatePanel(lineStatePanel);
		changeManager.setNationalField(nationalField);
		changeManager.setNationalLabel(nationalLabel);
		changeManager.setNationalPanel(nationalPanel);
		changeManager.setInternationalField(internationalField);
		changeManager.setInternationalLabel(internationalLabel);
		changeManager.setInternationalPanel(internationalPanel);
		changeManager.setPreferentialListField(preferentialListField);
		changeManager.setPreferentialListLabel(preferentialListLabel);
		changeManager.setUnblockLabel(channelLabel);
		changeManager.setChannelComboboxSelection(channelComboboxSelection);
	}
	
	private void setSubscriberCreateClass(){
		createManager.setMarketButtonGroup(marketButtonGroup);
		createManager.setChangeComboboxSelection(changeComboboxSelection);
		createManager.setMsisdnNewField(msisdnNewField);
		createManager.setMsisdnNewLabel(msisdnNewLabel);
		createManager.setTariffPlanLabel(tariffPlanLabel);
		createManager.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		createManager.setTariffPlan(tariffPlanManager);
		createManager.setRefillTypeLabel(refillTypeLabel);
		createManager.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
		createManager.setFeediscountField(feediscountField);
		createManager.setFeediscountLabel(feediscountLabel);
		createManager.setFeedelayField(feedelayField);
		createManager.setFeedelayLabel(feedelayLabel);
		createManager.setAmountField(amountField);
		createManager.setAmountLabel(amountLabel);
		createManager.setDataServicesField(dataServicesField);
		createManager.setDataServicesLabel(dataServicesLabel);
		createManager.setDayField(dayField);
		createManager.setDayLabel(dayLabel);
		createManager.setMonthField(monthField);
		createManager.setMonthLabel(monthLabel);
		createManager.setNationalField(nationalField);
		createManager.setNationalLabel(nationalLabel);
		createManager.setInternationalField(internationalField);
		createManager.setInternationalLabel(internationalLabel);
	}
	
	@Override
	public void resetChangeCombo(){
		changeComboboxSelection.setSelectedIndex(0);
	}
	
	@Override
	public void resetAssuranceActionOnMarketCtypeChange(){
		if(actionButtonGroup.getSelection()!=null){
			for(int i=0; i<SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_OPTION_LIST.length; i++){
				if(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_OPTION_LIST[i].equals(actionButtonGroup.getSelection().getActionCommand())){
					if(rdbtnGet.isSelected()){
						actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET);
					}
				}
			}
			
			for(int i=0; i<SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_OPTION_LIST.length; i++){
				if(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_OPTION_LIST[i].equals(actionButtonGroup.getSelection().getActionCommand())){
					if(rdbtnGet.isSelected()){
						actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG);
					}
				}
			}
		}
	}
	
	@Override
	public void backButtonActionPerformed() {
		if (btnExecute.getActionCommand().equals("reconnect")) {
			
			String redirect = components.getConnectionManagerStandard().reconnectionStandard(btnExecute.getActionCommand());
			
			textArea.setText(redirect);
			if (redirect.equals(components.getErrorMessages().get_RELOGGED())) {
				btnExecute.setText("Execute");
				btnExecute.setActionCommand("execute");
			}else if (redirect.equals(components.getErrorMessages().get_NOT_LOGGED_ERROR()) || 
					  redirect.equals(components.getErrorMessages().get_MPM_CONNECTION_ERROR()) || 
					  redirect.equals(components.getErrorMessages().get_MPM_ERROR())) {
				btnExecute.setText("Home");
				btnExecute.setActionCommand("home");
			}

		} else if (btnExecute.getActionCommand().equals("home")){
			frame.dispose();
		}
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
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	@Override
	public void setBtnExecute(JButton btnExecute) {
		this.btnExecute = btnExecute;
	}

	@Override
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	@Override
	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	@Override
	public void setChangeComboboxSelection(JComboBox changeComboboxSelection) {
		this.changeComboboxSelection = changeComboboxSelection;
	}

	@Override
	public void setRdbtnGet(JRadioButton rdbtnGet) {
		this.rdbtnGet = rdbtnGet;
	}

	@Override
	public void setType(SubscriberTypeInterface type) {
		this.type = type;
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
	public void setActionOnChangeLabel(JLabel actionOnChangeLabel) {
		this.actionOnChangeLabel = actionOnChangeLabel;
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
	public void setChannelLabel(JLabel channelLabel) {
		this.channelLabel = channelLabel;
	}

	@Override
	public void setChannelComboboxSelection(JComboBox channelComboboxSelection) {
		this.channelComboboxSelection = channelComboboxSelection;
	}

	@Override
	public void setTariffPlanManager(SubscriberTariffPlanInterface tariffPlanManager) {
		this.tariffPlanManager = tariffPlanManager;
	}

	@Override
	public void setDataServicesLabel(JLabel dataServicesLabel) {
		this.dataServicesLabel = dataServicesLabel;
	}

	@Override
	public void setDataServicesField(JTextField dataServicesField) {
		this.dataServicesField = dataServicesField;
	}

	@Override
	public void setAssuranceLabel(JLabel assuranceLabel) {
		this.assuranceLabel = assuranceLabel;
	}

	@Override
	public void setAssurancePanel(JPanel assurancePanel) {
		this.assurancePanel = assurancePanel;
	}

	@Override
	public void setAmountIdLabel(JLabel amountIdLabel) {
		this.amountIdLabel = amountIdLabel;
	}

	@Override
	public void setAmountIdField(JTextField amountIdField) {
		this.amountIdField = amountIdField;
	}

	@Override
	public void setNationalButtonGroup(ButtonGroup nationalButtonGroup) {
		this.nationalButtonGroup = nationalButtonGroup;
	}

	@Override
	public void setInternationalButtonGroup(ButtonGroup internationalButtonGroup) {
		this.internationalButtonGroup = internationalButtonGroup;
	}

	@Override
	public void setMsisdnField(JTextField msisdnField) {
		this.msisdnField = msisdnField;
	}

	@Override
	public void setRdbtnPrepaid(JRadioButton rdbtnPrepaid) {
		this.rdbtnPrepaid = rdbtnPrepaid;
	}

	@Override
	public void setRdbtnPostpaid(JRadioButton rdbtnPostpaid) {
		this.rdbtnPostpaid = rdbtnPostpaid;
	}

	@Override
	public void setRdbtnConsumer(JRadioButton rdbtnConsumer) {
		this.rdbtnConsumer = rdbtnConsumer;
	}

	@Override
	public void setRdbtnCorporate(JRadioButton rdbtnCorporate) {
		this.rdbtnCorporate = rdbtnCorporate;
	}

	@Override
	public void setSaveBalanceButtonGroup(ButtonGroup saveBalanceButtonGroup) {
		this.saveBalanceButtonGroup = saveBalanceButtonGroup;
	}

	@Override
	public void setLineStateButtonGroup(ButtonGroup lineStateButtonGroup) {
		this.lineStateButtonGroup = lineStateButtonGroup;
	}

	@Override
	public void setChangeManager(SubscriberChangeInterface changeManager) {
		this.changeManager = changeManager;
	}

}