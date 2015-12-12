package com.innovery.mpm.allresource.implementations.bean.air;

import com.innovery.mpm.allresource.interfaces.bean.air.AccountDetailsInterface;

public class AccountDetails implements AccountDetailsInterface{

	private String account_group_id;
	private String service_offerings;
	private String language;
	private String community_id;
	private String service_class;
	private String sim_exp_date;
	private String sup_exp_date;
	private String account_status;
	
	public AccountDetails(){
		this.account_group_id = "";
		this.service_offerings = "";
		this.language = "";
		this.community_id = "";
		this.service_class = "";
		this.sim_exp_date = "";
		this.sup_exp_date = "";
		this.account_status = "";
	}

	public String getAccount_group_id() {
		return account_group_id;
	}

	public void setAccount_group_id(String account_group_id) {
		this.account_group_id = account_group_id;
	}

	public String getService_offerings() {
		return service_offerings;
	}

	public void setService_offerings(String service_offerings) {
		this.service_offerings = service_offerings;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCommunity_id() {
		return community_id;
	}

	public void setCommunity_id(String community_id) {
		this.community_id = community_id;
	}

	public String getService_class() {
		return service_class;
	}

	public void setService_class(String service_class) {
		this.service_class = service_class;
	}

	public String getSim_exp_date() {
		return sim_exp_date;
	}

	public void setSim_exp_date(String sim_exp_date) {
		this.sim_exp_date = sim_exp_date;
	}

	public String getSup_exp_date() {
		return sup_exp_date;
	}

	public void setSup_exp_date(String sup_exp_date) {
		this.sup_exp_date = sup_exp_date;
	}

	public String getAccount_status() {
		return account_status;
	}

	public void setAccount_status(String account_status) {
		this.account_status = account_status;
	}
}
