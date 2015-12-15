package com.innovery.mpm.subscriber.implementations.gui.verification;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.ChangeBillCycleVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.ChangeDataServicesVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.ChangeMsisdn;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.ChangePreferentialList;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.ChangeTariffPlanVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.CostControlVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.CreateVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.DiscountVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.GetVerification;
import com.innovery.mpm.subscriber.implementations.gui.verification.util.LineStateVerification;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.verification.SubscriberVerifyInterface;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 * 
 */
public class SubscriberVerify implements SubscriberVerifyInterface {
	
	private DAPBeanInterface components;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JTextField msisdnField;
	private ButtonGroup getButtonGroup;
	private JTextField amountIdField;
	private JTextField msisdnNewField;
	private JTextField msisdnNewRefillField;
	private JTextField expiryDateField;
	private JTextField amountField;
	private ButtonGroup saveBalanceButtonGroup;
	private JComboBox tariffPlanComboboxSelection;
	private JComboBox refillTypeComboboxSelection;
	private ButtonGroup lineStateButtonGroup;
	private JTextField feediscountField;
	private JTextField feedelayField;
	private JTextField dataServicesField;
	private JComboBox actionComboboxSelection;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField preferentialList;
	private JTextField nationalField;
	private JTextField internationalField;
	private ButtonGroup nationalButtonGroup;
	private ButtonGroup internationalButtonGroup;
	private JComboBox chanelComboboxSelection;
	
	public boolean verify_input() {
		
		if (actionButtonGroup.getSelection() == null) {
			components.getNotifications().error("Select an action.");
			return false;
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG)) {
			components.getNotifications().error("Select and option for action change.");
			return false;
		}

		else if (!isMsisdn(msisdnField.getText())) {
			components.getNotifications().error("MSISDN is mandatory. Must be numeric, from 1 to 28 digits.");
			return false;
		}

		else if (marketButtonGroup.getSelection() == null) {
			components.getNotifications().error("Select a market.");
			return false;
		}

		else if (ctypeButtonGroup.getSelection() == null) {
			components.getNotifications().error("Select a line type.");
			return false;
		}

		if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE)) {
			CreateVerification create = new CreateVerification();
			create.setComponents(components);
			create.setMarketButtonGroup(marketButtonGroup);
			create.setCtypeButtonGroup(ctypeButtonGroup);
			create.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
			create.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
			create.setNationalField(nationalField);
			create.setInternationalField(internationalField);
			create.setDataServicesField(dataServicesField);
			create.setDayField(dayField);
			create.setMonthField(monthField);
			create.setFeediscountField(feediscountField);
			create.setFeedelayField(feedelayField);
			create.setAmountField(amountField);
			
			
			return create.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE)) {
			return true;
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET)|| 
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT)) {
			GetVerification assurance = new GetVerification();
			assurance.setComponents(components);
			assurance.setCtypeButtonGroup(ctypeButtonGroup);
			assurance.setGetButtonGroup(getButtonGroup);
			assurance.setAmountIdField(amountIdField);
			
			return assurance.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_MSISDN)) {
			ChangeMsisdn changeMsisdn = new ChangeMsisdn();
			changeMsisdn.setComponents(components);
			changeMsisdn.setCtypeButtonGroup(ctypeButtonGroup);
			changeMsisdn.setMsisdnNewField(msisdnNewField);
			changeMsisdn.setMsisdnNewRefillField(msisdnNewRefillField);
			return changeMsisdn.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_TARIFF_PLAN)) {
			ChangeTariffPlanVerification changeTariffPlan = new ChangeTariffPlanVerification();
			changeTariffPlan.setComponents(components);
			changeTariffPlan.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
			changeTariffPlan.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
			changeTariffPlan.setFeediscountField(feediscountField);
			changeTariffPlan.setFeedelayField(feedelayField);
			changeTariffPlan.setMarketButtonGroup(marketButtonGroup);
			changeTariffPlan.setSaveBalanceButtonGroup(saveBalanceButtonGroup);
			changeTariffPlan.setExpiryDateField(expiryDateField);
			changeTariffPlan.setAmountField(amountField);
			return changeTariffPlan.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_LINE_STATE)) {
			LineStateVerification lineState = new LineStateVerification();
			lineState.setComponents(components);
			lineState.setLineStateButtonGroup(lineStateButtonGroup);
			return lineState.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DISCOUNT)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT)) {
			DiscountVerification discount = new DiscountVerification();
			discount.setComponents(components);
			discount.setActionComboboxSelection(actionComboboxSelection);
			discount.setMarketButtonGroup(marketButtonGroup);
			discount.setFeediscountField(feediscountField);
			discount.setFeedelayField(feedelayField);
			return discount.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DATASERVICES)|| 
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATA_SERVICE)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATA_SERVICE)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATA_SERVICE)) {
			ChangeDataServicesVerification changeDataServices = new ChangeDataServicesVerification();
			changeDataServices.setComponents(components);
			changeDataServices.setMarketButtonGroup(marketButtonGroup);
			changeDataServices.setActionComboboxSelection(actionComboboxSelection);
			changeDataServices.setDataServicesField(dataServicesField);
			return changeDataServices.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_BILL_CYCLE)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILL_CYCLE)) {
			ChangeBillCycleVerification changeBillCycle = new ChangeBillCycleVerification();
			changeBillCycle.setComponents(components);
			changeBillCycle.setActionButtonGroup(actionButtonGroup);
			changeBillCycle.setMarketButtonGroup(marketButtonGroup);
			changeBillCycle.setCtypeButtonGroup(ctypeButtonGroup);
			changeBillCycle.setActionComboboxSelection(actionComboboxSelection);
			changeBillCycle.setDayField(dayField);
			changeBillCycle.setMonthField(monthField);
			return changeBillCycle.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_PREFERENTIAL_LIST)) {
			ChangePreferentialList changePreferentialList = new ChangePreferentialList();
			changePreferentialList.setComponents(components);
			changePreferentialList.setPreferentialList(preferentialList);
			return changePreferentialList.execute();
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_CC)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_CRM)||
				 actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CC_UNBLOCK_NIS)) {
			CostControlVerification costControl = new CostControlVerification();
			costControl.setComponents(components);
			costControl.setActionButtonGroup(actionButtonGroup);
			costControl.setCtypeButtonGroup(ctypeButtonGroup);
			costControl.setNationaField(nationalField);
			costControl.setInternationalField(internationalField);
			costControl.setNationalButtonGroup(nationalButtonGroup);
			costControl.setInternationalButtonGroup(internationalButtonGroup);
			costControl.setChanelComboBoxSelection(chanelComboboxSelection);
			return costControl.execute();
		}
		return true;
	}

	private boolean isMsisdn(String msisdn) {
		return Pattern.matches("^[0-9]{1,28}$", msisdn);
	}

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
	public void setMsisdnField(JTextField msisdnField) {
		this.msisdnField = msisdnField;
	}

	@Override
	public void setGetButtonGroup(ButtonGroup getButtonGroup) {
		this.getButtonGroup = getButtonGroup;
	}

	@Override
	public void setAmountIdField(JTextField amountIdField) {
		this.amountIdField = amountIdField;
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
	public void setExpiryDateField(JTextField expiryDateField) {
		this.expiryDateField = expiryDateField;
	}

	@Override
	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	@Override
	public void setSaveBalanceButtonGroup(ButtonGroup saveBalanceButtonGroup) {
		this.saveBalanceButtonGroup = saveBalanceButtonGroup;
	}

	@Override
	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection) {
		this.tariffPlanComboboxSelection = tariffPlanComboboxSelection;
	}

	@Override
	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection) {
		this.refillTypeComboboxSelection = refillTypeComboboxSelection;
	}

	@Override
	public void setLineStateButtonGroup(ButtonGroup lineStateButtonGroup) {
		this.lineStateButtonGroup = lineStateButtonGroup;
	}

	@Override
	public void setFeediscountField(JTextField feediscountField) {
		this.feediscountField = feediscountField;
	}

	@Override
	public void setFeedelayField(JTextField feedelayField) {
		this.feedelayField = feedelayField;
	}

	@Override
	public void setDataServicesField(JTextField dataServicesField) {
		this.dataServicesField = dataServicesField;
	}

	@Override
	public void setActionComboboxSelection(JComboBox actionComboboxSelection) {
		this.actionComboboxSelection = actionComboboxSelection;
	}

	@Override
	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}

	@Override
	public void setMonthField(JTextField monthField) {
		this.monthField = monthField;
	}

	@Override
	public void setPreferentialList(JTextField preferentialList) {
		this.preferentialList = preferentialList;
	}

	@Override
	public void setNationalField(JTextField nationalField) {
		this.nationalField = nationalField;
	}

	@Override
	public void setInternationalField(JTextField internationalField) {
		this.internationalField = internationalField;
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
	public void setChanelComboboxSelection(JComboBox chanelComboboxSelection) {
		this.chanelComboboxSelection = chanelComboboxSelection;
	}
}