package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SubscriberUtilInterface {

	public void setType(SubscriberTypeInterface type);

	public void setRdbtnGet(JRadioButton rdbtnGet);

	public void setChangeComboboxSelection(JComboBox changeComboboxSelection);

	public void setTextArea(JTextArea textArea);

	public void setFrame(JFrame frame);

	public void setBtnExecute(JButton btnExecute);

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup);

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	public void setComponents(DAPBeanInterface components);

	public void backButtonActionPerformed();

	public void resetAssuranceActionOnMarketCtypeChange();

	public void resetChangeCombo();

	public void actionOnChangeCombo();

	public void actionOnCType();

	public void setAssuranceManager(SubscriberAssuranceInterface assuranceManager);

	public void setCreateManager(SubscriberCreateInterface createManager);

	public void setTariffPlanManager(SubscriberTariffPlanInterface tariffPlanManager);

	public void setChannelComboboxSelection(JComboBox channelComboboxSelection);

	public void setChannelLabel(JLabel channelLabel);

	public void setPreferentialListField(JTextField preferentialListField);

	public void setPreferentialListLabel(JLabel preferentialListLabel);

	public void setInternationalPanel(JPanel internationalPanel);

	public void setNationalPanel(JPanel nationalPanel);

	public void setInternationalField(JTextField internationalField);

	public void setInternationalLabel(JLabel internationalLabel);

	public void setNationalField(JTextField nationalField);

	public void setNationalLabel(JLabel nationalLabel);

	public void setLineStatePanel(JPanel lineStatePanel);

	public void setLineStateLabel(JLabel lineStateLabel);

	public void setActionOnChangeComboboxSelection(JComboBox actionOnChangeComboboxSelection);

	public void setMonthField(JTextField monthField);

	public void setMonthLabel(JLabel monthLabel);

	public void setDayField(JTextField dayField);

	public void setDayLabel(JLabel dayLabel);

	public void setAmountField(JTextField amountField);

	public void setAmountLabel(JLabel amountLabel);

	public void setActionOnChangeLabel(JLabel actionOnChangeLabel);

	public void setFeedelayField(JTextField feedelayField);

	public void setFeedelayLabel(JLabel feedelayLabel);

	public void setFeediscountField(JTextField feediscountField);

	public void setFeediscountLabel(JLabel feediscountLabel);

	public void setExpiryDateField(JTextField expiryDateField);

	public void setExpiryDateLabel(JLabel expiryDateLabel);

	public void setSaveBalancePanel(JPanel saveBalancePanel);

	public void setSaveBalanceLabel(JLabel saveBalanceLabel);

	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection);

	public void setRefillTypeLabel(JLabel refillTypeLabel);

	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection);

	public void setTariffPlanLabel(JLabel tariffPlanLabel);

	public void setMsisdnNewRefillLabel(JLabel msisdnNewRefillLabel);

	public void setMsisdnNewLabel(JLabel msisdnNewLabel);

	public void setMsisdnNewRefillField(JTextField msisdnNewRefillField);

	public void setMsisdnNewField(JTextField msisdnNewField);

	public void commonActionOnActionRadioButton();

	public void setLineStateButtonGroup(ButtonGroup lineStateButtonGroup);

	public void setSaveBalanceButtonGroup(ButtonGroup saveBalanceButtonGroup);

	public void setRdbtnCorporate(JRadioButton rdbtnCorporate);

	public void setRdbtnConsumer(JRadioButton rdbtnConsumer);

	public void setRdbtnPostpaid(JRadioButton rdbtnPostpaid);

	public void setRdbtnPrepaid(JRadioButton rdbtnPrepaid);

	public void setMsisdnField(JTextField msisdnField);

	public void setInternationalButtonGroup(ButtonGroup internationalButtonGroup);

	public void setNationalButtonGroup(ButtonGroup nationalButtonGroup);

	public void setAmountIdField(JTextField amountIdField);

	public void setAmountIdLabel(JLabel amountIdLabel);

	public void setAssurancePanel(JPanel assurancePanel);

	public void setAssuranceLabel(JLabel assuranceLabel);

	public void setDataServicesField(JTextField dataServicesField);

	public void setDataServicesLabel(JLabel dataServicesLabel);

	public void enableCommonFields();

	public void clearAll();

	public void hideAll();

	public void setChangeManager(SubscriberChangeInterface changeManager);
}