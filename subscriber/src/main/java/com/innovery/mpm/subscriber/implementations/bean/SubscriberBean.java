package com.innovery.mpm.subscriber.implementations.bean;

import com.innovery.mpm.subscriber.interfaces.bean.SubscriberBeanInterface;

public class SubscriberBean implements SubscriberBeanInterface {

	private String msisdn = null;
	private String action = null;
	private String market = null;
	private String ctype = null;
	private String refill_type = null;
	private String line_state = null;
	private String tariff_plan = null;
	private String amount = null;
	private String national = null;
	private String international = null;
	private String data_services = null;
	private String save_balance = null;
	private String expiry_date = null;
	private String feediscount = null;
	private String feedelay = null;
	private String amount_ids = null;
	private String channel = null;
	private String communityId = null;
	private String msisdn_new = null;
	private String msisdn_new_refill = null;
	private String day = null;
	private String month = null;
	
	@Override
	public String getMsisdn() {
		return msisdn;
	}
	@Override
	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}
	@Override
	public String getAction() {
		return action;
	}
	@Override
	public void setAction(String action) {
		this.action = action;
	}
	@Override
	public String getMarket() {
		return market;
	}
	@Override
	public void setMarket(String market) {
		this.market = market;
	}
	@Override
	public String getCtype() {
		return ctype;
	}
	@Override
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@Override
	public String getRefill_type() {
		return refill_type;
	}
	@Override
	public void setRefill_type(String refill_type) {
		this.refill_type = refill_type;
	}
	@Override
	public String getLine_state() {
		return line_state;
	}
	@Override
	public void setLine_state(String line_state) {
		this.line_state = line_state;
	}
	@Override
	public String getTariff_plan() {
		return tariff_plan;
	}
	@Override
	public void setTariff_plan(String tariff_plan) {
		this.tariff_plan = tariff_plan;
	}
	@Override
	public String getAmount() {
		return amount;
	}
	@Override
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String getNational() {
		return national;
	}
	@Override
	public void setNational(String national) {
		this.national = national;
	}
	@Override
	public String getInternational() {
		return international;
	}
	@Override
	public void setInternational(String international) {
		this.international = international;
	}
	@Override
	public String getData_services() {
		return data_services;
	}
	@Override
	public void setData_services(String data_services) {
		this.data_services = data_services;
	}
	@Override
	public String getSave_balance() {
		return save_balance;
	}
	@Override
	public void setSave_balance(String save_balance) {
		this.save_balance = save_balance;
	}
	@Override
	public String getExpiry_date() {
		return expiry_date;
	}
	@Override
	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}
	@Override
	public String getFeediscount() {
		return feediscount;
	}
	@Override
	public void setFeediscount(String feediscount) {
		this.feediscount = feediscount;
	}
	@Override
	public String getFeedelay() {
		return feedelay;
	}
	@Override
	public void setFeedelay(String feedelay) {
		this.feedelay = feedelay;
	}
	@Override
	public String getAmount_ids() {
		return amount_ids;
	}
	@Override
	public void setAmount_ids(String amount_ids) {
		this.amount_ids = amount_ids;
	}
	@Override
	public String getChannel() {
		return channel;
	}
	@Override
	public void setChannel(String channel) {
		this.channel = channel;
	}
	@Override
	public String getMsisdn_new() {
		return msisdn_new;
	}
	@Override
	public void setMsisdn_new(String msisdn_new) {
		this.msisdn_new = msisdn_new;
	}
	@Override
	public String getMsisdn_new_refill() {
		return msisdn_new_refill;
	}
	@Override
	public void setMsisdn_new_refill(String msisdn_new_refill) {
		this.msisdn_new_refill = msisdn_new_refill;
	}
	@Override
	public String getDay() {
		return day;
	}
	@Override
	public void setDay(String day) {
		this.day = day;
	}
	@Override
	public String getMonth() {
		return month;
	}
	@Override
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String getCommunityId() {
		return communityId;
	}
	@Override
	public void setCommunityId(String communityId) {
		this.communityId = communityId;
	}
}
