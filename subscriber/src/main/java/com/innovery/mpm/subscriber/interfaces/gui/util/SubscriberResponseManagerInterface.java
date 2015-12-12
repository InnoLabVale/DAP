package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.interfaces.action.ActionSubscriberInterface;

public interface SubscriberResponseManagerInterface {

	public void getResponse();

	public void setComponents(DAPBeanInterface components);

	public void setTextArea(JTextArea textArea);

	public void setResponseGridManager(SubscriberResponseGridManagerInterface responseGridManager);

	public void setActionCommandSubscriber(ActionSubscriberInterface actionCommandSubscriber);

	public void setBtnExecute(JButton btnExecute);

	public void setChannelComboboxSelection(JComboBox channelComboboxSelection);

	public void setInternationalButtonGroup(ButtonGroup internationalButtonGroup);

	public void setNationalButtonGroup(ButtonGroup nationalButtonGroup);

	public void setInternationalField(JTextField internationalField);

	public void setNationalField(JTextField nationalField);

	public void setPreferentialList(JTextField preferentialList);

	public void setMonthField(JTextField monthField);

	public void setDayField(JTextField dayField);

	public void setDataServicesField(JTextField dataServicesField);

	public void setFeedelayField(JTextField feedelayField);

	public void setFeediscountField(JTextField feediscountField);

	public void setLineStateButtonGroup(ButtonGroup lineStateButtonGroup);

	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection);

	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection);

	public void setSaveBalanceButtonGroup(ButtonGroup saveBalanceButtonGroup);

	public void setAmountField(JTextField amountField);

	public void setExpiryDateField(JTextField expiryDateField);

	public void setMsisdnNewRefillField(JTextField msisdnNewRefillField);

	public void setMsisdnNewField(JTextField msisdnNewField);

	public void setAmountIdField(JTextField amountIdField);

	public void setMsisdnField(JTextField msisdnField);

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup);

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	void setFrame(JFrame frame);

	void setResponseFieldsetGridPanel(JPanel responseFieldsetGridPanel);

	void setResponseFieldsetPanel(JPanel responseFieldsetPanel);
}