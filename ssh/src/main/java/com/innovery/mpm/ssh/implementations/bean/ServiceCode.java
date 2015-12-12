package com.innovery.mpm.ssh.implementations.bean;

import com.innovery.mpm.ssh.interfaces.bean.ServiceCodeInterface;

public class ServiceCode implements ServiceCodeInterface{

	private String action;
	private String msisdn;
	private String serviceCodeId;
	private String activationDate;
	private String nextFeeDate;
	private String smartStartDate_text;
	private boolean smartStartDate_check;

	public String getMsisdn() {
		return msisdn;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getServiceCodeId() {
		return serviceCodeId;
	}

	public void setServiceCodeId(String serviceCodeId) {
		this.serviceCodeId = serviceCodeId;
	}

	public String getActivationDate() {
		return activationDate;
	}

	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}

	public String getNextFeeDate() {
		return nextFeeDate;
	}

	public void setNextFeeDate(String nextFeeDate) {
		this.nextFeeDate = nextFeeDate;
	}

	public String getSmartStartDate_text() {
		return smartStartDate_text;
	}

	public void setSmartStartDate_text(String smartStartDate_text) {
		this.smartStartDate_text = smartStartDate_text;
	}

	public boolean isSmartStartDate_check() {
		return smartStartDate_check;
	}

	public void setSmartStartDate_check(boolean smartStartDate_check) {
		this.smartStartDate_check = smartStartDate_check;
	}
}
