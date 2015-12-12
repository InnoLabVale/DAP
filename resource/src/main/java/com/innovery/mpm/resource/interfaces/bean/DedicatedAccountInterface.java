package com.innovery.mpm.resource.interfaces.bean;

public interface DedicatedAccountInterface {

	public String getDedicatedId();
	
	public String getDedicatedUnit();
	
	public String getDedicatedValueNew();
	
	public String getDedicatedValueRelative();
	
	public String getDedicatedExpiry();
	
	public String getDedicatedExpiryAdjustment();
	
	public void setDedicatedId(String dedicated_account_id);
	
	public void setDedicatedUnit(String dedicated_account_unit);
	
	public void setDedicatedValueNew(String dedicated_account_value_new);
	
	public void setDedicatedValueRelative(String dedicated_account_value_rel);
	
	public void setDedicatedExpiry(String dedicated_account_expiry);
	
	public void setDedicatedExpiryAdjustment(String dedicated_account_expiry_adj);
}
