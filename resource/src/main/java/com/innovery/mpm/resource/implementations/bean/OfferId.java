package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.OfferIdInterface;

public class OfferId implements OfferIdInterface{
	
	private String offerid;
	private String start_date;
	private String start_date_rel;
	private String expiry_date;
	private String expiry_date_rel;
	private String type;
	
	public String getOfferId(){
		return offerid;
	}

	public String getStartDate(){
		return start_date;
	}
	
	public String getStartDateRelative(){
		return start_date_rel;
	}

	public String getExpiryDate(){
		return expiry_date;
	}
	
	public String getExpiryDateRelative(){
		return expiry_date_rel;
	}
	
	public String getType(){
		return type;
	}
	
	public void setOfferId(String offerid){
		this.offerid=offerid;
	}
	
	public void setStartDate(String start_date){
		this.start_date=start_date;
	}
	
	public void setStartDateRelative(String start_date_rel){
		this.start_date_rel=start_date_rel;
	}
	
	public void setExpiryDate(String expiry_date){
		this.expiry_date=expiry_date;
	}
	
	public void setExpiryDateRelative(String expiry_date_rel){
		this.expiry_date_rel=expiry_date_rel;
	}
	
	public void setType(String type){
		this.type=type;
	}
}
