package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SubscriberChangeInterface {

	public void setTariffPlan(SubscriberTariffPlanInterface tariffPlan);

	public void setChannelComboboxSelection(JComboBox channelComboboxSelection);

	public void setUnblockLabel(JLabel unblockLabel);

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

	public void setActionLabelOnChange(JLabel actionLabelOnChange);

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

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup);

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	public void setComponents(DAPBeanInterface components);

	public void showChengeMsisdn();

	public void actionOnSubscriberChangePostpaid(int index);

	public void actionOnSubscriberChangeCorporatePrepaid(int index);

	public void actionOnSubscriberChangeConsumerPrepaid(int index);

}