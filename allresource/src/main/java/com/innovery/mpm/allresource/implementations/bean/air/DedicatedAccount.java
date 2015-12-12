package com.innovery.mpm.allresource.implementations.bean.air;

import com.innovery.mpm.allresource.interfaces.bean.air.DedicatedAccountInterface;


public class DedicatedAccount implements DedicatedAccountInterface{
	
	private String msisdn;
	private String dedicated_account_id;
	private String dedicated_account_unit;
	private String dedicated_account_value_new;
	private String dedicated_account_value_rel;
	private String dedicated_account_expiry;
	private String dedicated_account_expiry_adj;

	public DedicatedAccount(){
		this.msisdn=null;
		this.dedicated_account_id=null;
		this.dedicated_account_unit=null;
		this.dedicated_account_value_new=null;
		this.dedicated_account_value_rel=null;
		this.dedicated_account_expiry=null;
		this.dedicated_account_expiry_adj=null;
	}
	
	public DedicatedAccount(String msisdn){
		this.msisdn=msisdn;
		this.dedicated_account_id=null;
		this.dedicated_account_unit=null;
		this.dedicated_account_value_new=null;
		this.dedicated_account_value_rel=null;
		this.dedicated_account_expiry=null;
		this.dedicated_account_expiry_adj=null;
	}
	
	public String getMSISDN(){
		return this.msisdn;
	}
	
	public String getDedicatedId(){
		return this.dedicated_account_id;
	}
	
	public String getDedicatedUnit(){
		return this.dedicated_account_unit;
	}
	
	public String getDedicatedValueNew(){
		return this.dedicated_account_value_new;
	}
	
	public String getDedicatedValueRelative(){
		return this.dedicated_account_value_rel;
	}
	
	public String getDedicatedExpiry(){
		return this.dedicated_account_expiry;
	}
	
	public String getDedicatedExpiryAdjustment(){
		return this.dedicated_account_expiry_adj;
	}
	
	public void setMSISDN(String msisdn){
		this.msisdn=msisdn;
	}
	
	public void setDedicatedId(String dedicated_account_id){
		this.dedicated_account_id=dedicated_account_id;
	}
	
	public void setDedicatedUnit(String dedicated_account_unit){
		this.dedicated_account_unit=dedicated_account_unit;
	}
	
	public void setDedicatedValueNew(String dedicated_account_value_new){
		this.dedicated_account_value_new=dedicated_account_value_new;
	}
	
	public void setDedicatedValueRelative(String dedicated_account_value_rel){
		this.dedicated_account_value_rel=dedicated_account_value_rel;
	}
	
	public void setDedicatedExpiry(String dedicated_account_expiry){
		this.dedicated_account_expiry=dedicated_account_expiry;
	}
	
	public void setDedicatedExpiryAdjustment(String dedicated_account_expiry_adj){
		this.dedicated_account_expiry_adj=dedicated_account_expiry_adj;
	}
}
