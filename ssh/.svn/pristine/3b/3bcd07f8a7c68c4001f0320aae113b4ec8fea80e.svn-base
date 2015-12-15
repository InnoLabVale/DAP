package com.innovery.mpm.ssh.implementations.gui.verification;

import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.ssh.implementations.util.SSHActions;
import com.innovery.mpm.ssh.implementations.util.SSHMessages;
import com.innovery.mpm.ssh.interfaces.gui.verification.SshResourceVerifyInterface;

public class SshResourceVerify implements SshResourceVerifyInterface {

	private DAPBeanInterface components;
	
	private JTextField msisdnField;
	private JTextField serviceCodeField;
	private JTextField serviceCodeDateField;
	private JTextField smartDateField;
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;

	public boolean sshVerify() {

		String msisdn_pattern = "^[0-9]{1,28}$";
		String sc_pattern = "^[0-9]{2,3}$";
		String date_pattern = "^(19|20)\\d\\d(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$";

		if (actionButtonGroup.getSelection() == null) {
			components.getNotifications().error(SSHMessages.SSH_ACTION_WARNING);
			return false;
		} else if (marketButtonGroup.getSelection() == null) {
			components.getNotifications().error(SSHMessages.SSH_MARKET_WARNING);
			return false;
		} else if (!Pattern.matches(msisdn_pattern, msisdnField.getText())) {
			components.getNotifications().error(SSHMessages.SSH_MSISDN_WARNING);
			return false;
		}

		if (actionButtonGroup.getSelection().getActionCommand().equals(SSHActions.SSH_ACTION_CREATE)) {
			if (smartDateField.getText().equals("") && serviceCodeField.getText().equals("")	&& serviceCodeDateField.getText().equals("")) {
				components.getNotifications().error(SSHMessages.SSH_SERVICECODE_SMARTDATE_WARNING);
				return false;
			}

			else if (!serviceCodeField.getText().equals("") && !Pattern.matches(sc_pattern, serviceCodeField.getText())) {
				components.getNotifications().error(SSHMessages.SSH_SERVICECODE_WARNING);
				return false;
			}

			else if (!serviceCodeField.getText().equals("")) {
				if (serviceCodeDateField.getText().equals("") || !Pattern.matches(date_pattern, serviceCodeDateField.getText())) {
					components.getNotifications().error(SSHMessages.SSH_SERVICECODE_DATE_WARNING);
					return false;
				}
			}

			else if (!smartDateField.getText().equals("")	&& !Pattern.matches(date_pattern, smartDateField.getText())) {
				components.getNotifications().error(SSHMessages.SSH_SMARTDATE_DATE_WARNING);
				return false;
			}

		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SSHActions.SSH_ACTION_DELETE)) {
			if (!serviceCodeField.getText().equals("")	&& !Pattern.matches(sc_pattern, serviceCodeField.getText())) {
				components.getNotifications().error(SSHMessages.SSH_SERVICECODE_WARNING);
				return false;
			}
		}

		else if (actionButtonGroup.getSelection().getActionCommand().equals(SSHActions.SSH_ACTION_GET)) {
			if (!Pattern.matches(sc_pattern, serviceCodeField.getText()) && !serviceCodeField.getText().equals("")) {
				components.getNotifications().error(SSHMessages.SSH_SERVICECODE_WARNING);
				return false;
			}
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setMsisdnField(JTextField msisdnField) {
		this.msisdnField = msisdnField;
	}

	public void setServiceCodeField(JTextField serviceCodeField) {
		this.serviceCodeField = serviceCodeField;
	}

	public void setServiceCodeDateField(JTextField serviceCodeDateField) {
		this.serviceCodeDateField = serviceCodeDateField;
	}

	public void setSmartDateField(JTextField smartDateField) {
		this.smartDateField = smartDateField;
	}

	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}
}
