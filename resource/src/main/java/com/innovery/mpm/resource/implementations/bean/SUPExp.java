package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.SUPExpInterface;

public class SUPExp implements SUPExpInterface{

	private String sup_exp_date;
	private String sup_exp_date_adj;
	
	public void setSupExpDate(String sup_exp_date){
		this.sup_exp_date=sup_exp_date;
	}	
	
	
	public String getSupExpDate(){
		return this.sup_exp_date;
	}
	
	public void setSupExpDateAdj(String sup_exp_date_adj){
		this.sup_exp_date_adj = sup_exp_date_adj;
	}
	
	public String getSupExpDateAdj(){
		return this.sup_exp_date_adj;
	}
}
