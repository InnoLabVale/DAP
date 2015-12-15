package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ChangeTariffPlanVerification{

	private DAPBeanInterface components;

	private JComboBox tariffPlanComboboxSelection;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup saveBalanceButtonGroup;
	
	private JTextField expiryDateField;
	
	private JComboBox refillTypeComboboxSelection;
	
	private JTextField amountField;
	
	private JTextField feediscountField;
	private JTextField feedelayField;
	
	public boolean execute() {
		
		String cons_patt = "^(ROPZ)[0-9]{3,7}[A-Za-z]{0,1}$";
		String corp_patt = "^(OPTBE|OPT)[0-9]{2,7}$";

		if (tariffPlanComboboxSelection.getSelectedIndex() == 0) {
			components.getNotifications().error("Tariff plan is mandatory!");
			return false;
		}

		if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CONSUMER)) {
			if (saveBalanceButtonGroup.getSelection() != null) {
				if (!saveBalanceButtonGroup.getSelection().getActionCommand().equals("on")	&& !saveBalanceButtonGroup.getSelection().getActionCommand().equals("off")) {
					components.getNotifications().error("Save balance not valid. It must be \"on\" or \"off\".");
					return false;
				}
				if (expiryDateField.getText().equals("")) {
					components.getNotifications().error("Save balance and expiry date must be provided together");
					return false;
				}
			}

			if (!expiryDateField.getText().equals("")) {
				if (!isValidDateBso(expiryDateField.getText())) {
					components.getNotifications().error("Expiry date not valid. Start date format must be YYYYMMDD.");
					return false;
				}
				if (saveBalanceButtonGroup.getSelection() == null) {
					components.getNotifications().error("Save balance and expiry date must be provided together");
					return false;
				}
			}
		} else if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE)) {
			if (refillTypeComboboxSelection.getSelectedIndex()!=0) {
				if (amountField.getText().equals("")) {
					components.getNotifications().error("Refill type and amount value must be provided together.");
					return false;
				}
			}

			if (!amountField.getText().equals("")) {
				if (!isNumber(amountField.getText())) {
					components.getNotifications().error("Amount value not valid. Start date format must be YYYYMMDD.");
					return false;
				}
				if (refillTypeComboboxSelection.getSelectedIndex()==0) {
					components.getNotifications().error("Refill type and amount value must be provided together.");
					return false;
				}
			}
		}
		if (!feediscountField.getText().equals("")) {
			if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CONSUMER) && !Pattern.matches(cons_patt, feediscountField.getText())) {
				components.getNotifications().error("Feediscount not valid for \"consumer\".It must be ROPZxxxx.");
				return false;
			} else if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE) && !Pattern.matches(corp_patt, feediscountField.getText())) {
				components.getNotifications().error("Feediscount not valid for \"corporate\".It must be OPTxxxx.");
				return false;
			} else if (!isNumber(feedelayField.getText())) {
				components.getNotifications().error("Feedelay not valid. It must be positive number. or 0.");
				return false;
			}
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection) {
		this.tariffPlanComboboxSelection = tariffPlanComboboxSelection;
	}

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	public void setSaveBalanceButtonGroup(ButtonGroup saveBalanceButtonGroup) {
		this.saveBalanceButtonGroup = saveBalanceButtonGroup;
	}

	public void setExpiryDateField(JTextField expiryDateField) {
		this.expiryDateField = expiryDateField;
	}

	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection) {
		this.refillTypeComboboxSelection = refillTypeComboboxSelection;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public void setFeediscountField(JTextField feediscountField) {
		this.feediscountField = feediscountField;
	}

	public void setFeedelayField(JTextField feedelayField) {
		this.feedelayField = feedelayField;
	}

	private boolean isValidDateBso(String date) {
		return Pattern.matches(
				"^(19|20)\\d\\d(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$", date);
	}

	private boolean isNumber(String number) {
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
