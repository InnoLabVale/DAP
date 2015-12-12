package com.innovery.mpm.subscriber.implementations.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberAssuranceInterface;

public class SubscriberAssurance implements SubscriberAssuranceInterface {
	
	private JTextField amountIdField;
	private JLabel amountIdLabel;
	
	private JComboBox changeComboboxSelection;
	
	private ButtonGroup marketButtonGroup;
	private ButtonGroup actionButtonGroup;
	private ButtonGroup assuranceButtonGroup;
	
	private JRadioButton rdbtnAssuranceAmount;
	private JRadioButton rdbtnAssuranceTariffPlan;
	private JRadioButton rdbtnAssuranceBillCycle;
	
	private JLabel assuranceLabel;
	private JPanel assurancePanel;
	
	private void commonAssurance(){
		changeComboboxSelection.setEnabled(false);
		
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		amountIdField.setEnabled(false);
		amountIdField.setText("0");
		
		rdbtnAssuranceAmount.setVisible(false);
		rdbtnAssuranceTariffPlan.setVisible(false);
		
		assuranceLabel.setVisible(true);
		assurancePanel.setVisible(true);
	}
	
	@Override
	public void showAssurancePrepaid(){
		commonAssurance();
		rdbtnAssuranceTariffPlan.setVisible(false);
		if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
			rdbtnAssuranceBillCycle.setVisible(true);
		}
		else if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
			rdbtnAssuranceBillCycle.setVisible(false);
		}
		rdbtnAssuranceAmount.setVisible(true);
		assuranceButtonGroup.clearSelection();
	}
	
	@Override
	public void showAssurancePostpaid(){
		commonAssurance();
		rdbtnAssuranceTariffPlan.setVisible(true);
		rdbtnAssuranceBillCycle.setVisible(true);
		rdbtnAssuranceAmount.setVisible(false);
		assuranceButtonGroup.clearSelection();
	}
	
	@Override
	public void showAssuranceProfile() {
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		amountIdField.setEnabled(false);
		actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE);
	}

	@Override
	public void showAssuranceDataServices() {
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		amountIdField.setEnabled(false);
		actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES);
	}
	
	@Override
	public void showAssuranceTariffPlan() {
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		amountIdField.setEnabled(false);
		actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN);
	}
	
	@Override
	public void showAssuranceAmount() {
		amountIdLabel.setVisible(true);
		amountIdField.setVisible(true);
		amountIdField.setEnabled(true);
		actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT);
	}
	
	@Override
	public void showAssuranceBillCycle() {
		amountIdLabel.setVisible(false);
		amountIdField.setVisible(false);
		amountIdField.setEnabled(false);
		actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE);
	}

	@Override
	public void setAmountIdField(JTextField amountIdField) {
		this.amountIdField = amountIdField;
	}

	@Override
	public void setAmountIdLabel(JLabel amountIdLabel) {
		this.amountIdLabel = amountIdLabel;
	}

	@Override
	public void setChangeComboboxSelection(JComboBox changeComboboxSelection) {
		this.changeComboboxSelection = changeComboboxSelection;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	@Override
	public void setAssuranceButtonGroup(ButtonGroup assuranceButtonGroup) {
		this.assuranceButtonGroup = assuranceButtonGroup;
	}

	@Override
	public void setRdbtnAssuranceAmount(JRadioButton rdbtnAssuranceAmount) {
		this.rdbtnAssuranceAmount = rdbtnAssuranceAmount;
	}

	@Override
	public void setRdbtnAssuranceTariffPlan(JRadioButton rdbtnAssuranceTariffPlan) {
		this.rdbtnAssuranceTariffPlan = rdbtnAssuranceTariffPlan;
	}

	@Override
	public void setRdbtnAssuranceBillCycle(JRadioButton rdbtnAssuranceBillCycle) {
		this.rdbtnAssuranceBillCycle = rdbtnAssuranceBillCycle;
	}

	@Override
	public void setAssuranceLabel(JLabel assuranceLabel) {
		this.assuranceLabel = assuranceLabel;
	}

	@Override
	public void setAssurancePanel(JPanel assurancePanel) {
		this.assurancePanel = assurancePanel;
	}
}
