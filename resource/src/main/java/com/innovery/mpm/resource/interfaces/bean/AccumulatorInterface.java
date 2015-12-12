package com.innovery.mpm.resource.interfaces.bean;

public interface AccumulatorInterface {

	public String getAccId();
	
	public String getAccValueAbs();
	
	public String getAccValueRel();
	
	public String getStartDate();
	
	public String getEndDate();
	
	public void setAccId(String acc_id);
	
	public void setAccValueAbs(String acc_value_abs);
	
	public void setAccValueRel(String acc_value_rel);
	
	public void setStartDate(String start_date);
	
	public void setEndDate(String end_date);
}
