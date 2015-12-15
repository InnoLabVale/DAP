package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberCreateInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;

public class SubscriberCreate implements SubscriberCreateInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup marketButtonGroup;
	
	private JComboBox changeComboboxSelection;
	
	private JTextField msisdnNewField;
	
	private JLabel msisdnNewLabel;
	
	private JLabel tariffPlanLabel;
	private JComboBox tariffPlanComboboxSelection;
	private SubscriberTariffPlanInterface tariffPlan;
	
	private JLabel refillTypeLabel;
	private JComboBox refillTypeComboboxSelection;
	
	private JLabel feediscountLabel;
	private JTextField feediscountField;
	
	private JLabel feedelayLabel;
	private JTextField feedelayField;
	
	private JLabel amountLabel;
	private JTextField amountField;
	
	private JLabel dataServicesLabel;
	private JTextField dataServicesField;
	
	private JLabel dayLabel;
	private JTextField dayField;
	
	private JLabel monthLabel;
	private JTextField monthField;
	
	private JLabel nationalLabel;
	private JTextField nationalField;
	
	private JLabel internationalLabel;
	private JTextField internationalField;
	
	@Override
	public void showCreateOnPrepaid(){
		
		changeComboboxSelection.setEnabled(false);
		
		tariffPlanLabel.setVisible(true);
		tariffPlanComboboxSelection.setVisible(true);
		tariffPlan.updateTariffPlanComboList();
		
		msisdnNewLabel.setVisible(false);
		msisdnNewField.setVisible(false);
		
		amountLabel.setText(components.getCommonGUI().mandatory(amountLabel.getText()));
		amountLabel.setVisible(true);
		amountField.setVisible(true);
		
		if (marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
			refillTypeLabel.setText(components.getCommonGUI().optional(refillTypeLabel.getText()));
			refillTypeLabel.setVisible(false);
			refillTypeComboboxSelection.setVisible(false);
		}
		
		else if (marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)) {
			refillTypeLabel.setText(components.getCommonGUI().mandatory(refillTypeLabel.getText()));
			refillTypeLabel.setVisible(true);
			refillTypeComboboxSelection.setSelectedIndex(0);
			refillTypeComboboxSelection.setVisible(true);
		}
		
		nationalLabel.setText(components.getCommonGUI().mandatory(nationalLabel.getText()));
		nationalLabel.setVisible(true);
		nationalField.setVisible(true);
		
		internationalLabel.setText(components.getCommonGUI().mandatory(internationalLabel.getText()));
		internationalLabel.setVisible(true);
		internationalField.setVisible(true);
		
		dataServicesLabel.setText(components.getCommonGUI().optional(dataServicesLabel.getText()));
		dataServicesLabel.setVisible(true);
		dataServicesField.setVisible(true);
		dataServicesField.setEnabled(true);
		
		feediscountLabel.setText(components.getCommonGUI().optional(feediscountLabel.getText()));
		feediscountLabel.setVisible(true);
		feediscountField.setVisible(true);
		
		feedelayLabel.setText(components.getCommonGUI().optional(feedelayLabel.getText()));
		feedelayLabel.setVisible(true);
		feedelayField.setVisible(true);
	}
	
	@Override
	public void showCreateOnPostpaid(){
		
		changeComboboxSelection.setEnabled(false);
			
		tariffPlanLabel.setVisible(true);
		tariffPlanComboboxSelection.setVisible(true);
		tariffPlan.updateTariffPlanComboList();
		
		dayLabel.setText(components.getCommonGUI().mandatory(dayLabel.getText()));
		dayLabel.setVisible(true);
		dayField.setVisible(true);
		monthLabel.setText(components.getCommonGUI().mandatory(monthLabel.getText()));
		monthLabel.setVisible(true);
		monthField.setVisible(true);
		
		internationalLabel.setVisible(true);
		internationalLabel.setText(components.getCommonGUI().optional(internationalLabel.getText()));
		internationalField.setVisible(true);
		
		dataServicesLabel.setVisible(true);	
		dataServicesLabel.setText(components.getCommonGUI().optional(dataServicesLabel.getText()));
		dataServicesField.setVisible(true);
		dataServicesField.setEnabled(true);
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setChangeComboboxSelection(JComboBox changeComboboxSelection) {
		this.changeComboboxSelection = changeComboboxSelection;
	}

	@Override
	public void setMsisdnNewField(JTextField msisdnNewField) {
		this.msisdnNewField = msisdnNewField;
	}

	@Override
	public void setMsisdnNewLabel(JLabel msisdnNewLabel) {
		this.msisdnNewLabel = msisdnNewLabel;
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
	public void setTariffPlan(SubscriberTariffPlanInterface tariffPlan) {
		this.tariffPlan = tariffPlan;
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
	public void setAmountLabel(JLabel amountLabel) {
		this.amountLabel = amountLabel;
	}

	@Override
	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
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
}
