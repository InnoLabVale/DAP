package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class CreateVerification{

	private final static String cons_patt = "^(ROPZ)[0-9]{3,7}[A-Za-z]{0,1}$";
	private final static String corp_patt = "^(OPTBE|OPT)[0-9]{2,7}$";
	private final static String main_account_patt = "[0-9]{1,12}$";
	private final static String day_patt = "^1|11|21$";
	private final static String month_patt = "^(pari|dispari)$";

	private DAPBeanInterface components;
	
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JComboBox tariffPlanComboboxSelection;
	private JTextField amountField;
	
	private JTextField nationalField;
	private JTextField internationalField;
	
	private JTextField dataServicesField;
	
	private JTextField dayField;
	private JTextField monthField;
	
	private JComboBox refillTypeComboboxSelection;
	
	private JTextField feediscountField;
	private JTextField feedelayField;
	
	public boolean execute() {
		boolean create_verification = false;
		if ((ctypeButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.PREPAID)) {
			create_verification = verify_create_prepaid();
		} 
		
		else if ((ctypeButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.POSTPAID)) {
			create_verification = verify_create_postpaid();
		}
		return create_verification;
	}

	private boolean verify_create_prepaid() {

		if (tariffPlanComboboxSelection.getSelectedIndex() == 0) {
			components.getNotifications().error("Tariff plan is mandatory!");
			return false;
		}

		if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE) && refillTypeComboboxSelection.getSelectedIndex()==0) {
			components.getNotifications().error("Select refill type.");
			return false;
		}

		if (!Pattern.matches(main_account_patt, amountField.getText())) {
			components.getNotifications().error("Main account balance value not valid. It must be numeric, from -999999999999 to 999999999999.");
			return false;
		}

		else if (!isNumber(nationalField.getText())) {
			components.getNotifications().error("National threshold must be numeric.");
			return false;
		}

		else if (!isNumber(internationalField.getText())) {
			components.getNotifications().error("International threshold must be numeric.");
			return false;
		}

		else if (!dataServicesField.getText().equals("")) {
			if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CONSUMER)	&& !Pattern.matches(cons_patt, dataServicesField.getText())) {
				components.getNotifications().error("Data service for \"consumer\" must be ROPZxxxx.");
				return false;
			} else if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE) && !Pattern.matches(corp_patt, dataServicesField.getText())) {
				components.getNotifications().error("Data service for \"corporate\" must be OPTxxxx.");
				return false;
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
				components.getNotifications().error("Feedelay not valid. It must be positive number or 0.");
				return false;
			}
		}

		return true;
	}

	private boolean verify_create_postpaid() {
		if (tariffPlanComboboxSelection.getSelectedIndex() == 0) {
			components.getNotifications().error("Tariff plan is mandatory!");
			return false;
		}

		if (!Pattern.matches(day_patt, dayField.getText())) {
			components.getNotifications().error("Day is mandatory and must be 1, 11 or 21.");
			return false;
		}

		if (!Pattern.matches(month_patt, monthField.getText())) {
			components.getNotifications().error("Month is mandatory and must be \"pari\" or \"dispari\".");
			return false;
		}

		if ((!dayField.getText().equals("") && monthField.getText().equals(""))	|| (dayField.getText().equals("") && !monthField.getText().equals(""))) {
			components.getNotifications().error("Day and month must be provided together");
			return false;
		}

		if (!internationalField.equals("") && !isNumber(internationalField.getText())) {
			components.getNotifications().error("International threshold must be numeric.");
			return false;
		}

		if (!dataServicesField.getText().equals("")) {
			if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CONSUMER)	&& !Pattern.matches(cons_patt, dataServicesField.getText())) {
				components.getNotifications().error("Data service for \"consumer\" must be ROPZxxxx.");
				return false;
			} else if ((marketButtonGroup.getSelection().getActionCommand()).equals(DAPBeanInterface.CORPORATE) && !Pattern.matches(corp_patt, dataServicesField.getText())) {
				components.getNotifications().error("Data service for \"corporate\" must be OPTxxxx.");
				return false;
			}
		}
		return true;
	}

	private boolean isNumber(String number) {

		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection) {
		this.tariffPlanComboboxSelection = tariffPlanComboboxSelection;
	}

	public void setAmountField(JTextField amountField) {
		this.amountField = amountField;
	}

	public void setNationalField(JTextField nationalField) {
		this.nationalField = nationalField;
	}

	public void setInternationalField(JTextField internationalField) {
		this.internationalField = internationalField;
	}

	public void setDataServicesField(JTextField dataServicesField) {
		this.dataServicesField = dataServicesField;
	}

	public void setDayField(JTextField dayField) {
		this.dayField = dayField;
	}

	public void setMonthField(JTextField monthField) {
		this.monthField = monthField;
	}

	public void setRefillTypeComboboxSelection(JComboBox refillTypeComboboxSelection) {
		this.refillTypeComboboxSelection = refillTypeComboboxSelection;
	}

	public void setFeediscountField(JTextField feediscountField) {
		this.feediscountField = feediscountField;
	}

	public void setFeedelayField(JTextField feedelayField) {
		this.feedelayField = feedelayField;
	}
}
