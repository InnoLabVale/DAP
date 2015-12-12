package com.innovery.mpm.resource.interfaces.bean;

public interface OfferIdInterface {

	public String getOfferId();

	public String getStartDate();
	
	public String getStartDateRelative();

	public String getExpiryDate();
	
	public String getExpiryDateRelative();
	
	public String getType();
	
	public void setOfferId(String offerid);
	
	public void setStartDate(String start_date);
	
	public void setStartDateRelative(String start_date_rel);
	
	public void setExpiryDate(String expiry_date);
	
	public void setExpiryDateRelative(String expiry_date_rel);
	
	public void setType(String type);
}
