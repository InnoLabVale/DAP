package com.innovery.mpm.allresource.implementations.bean.air;

import com.innovery.mpm.allresource.interfaces.bean.air.PromotionPlanInterface;

public class PromotionPlan implements PromotionPlanInterface{

	private String msisdn;
	private String promotion_plan;
	private String start_date;
	private String end_date;
	
	public PromotionPlan(){
		this.promotion_plan=null;
		this.start_date=null;
		this.end_date=null;
	}
	
	public PromotionPlan(String msisdn){
		this.msisdn=msisdn;
		this.promotion_plan=null;
		this.start_date=null;
		this.end_date=null;
	}

	public String getMSISDN() {
		return msisdn;
	}

	public String getPromotionPlan() {
		return promotion_plan;
	}

	public String getStartDate() {
		return start_date;
	}

	public String getEndDate() {
		return end_date;
	}
	
	public void setMSISDN(String msisdn) {
		this.msisdn = msisdn;
	}
	
	public void setPromotionPlan(String promotion_plan) {
		this.promotion_plan = promotion_plan;
	}
	
	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public void setEndDate(String end_date) {
		this.end_date = end_date;
	}
}
