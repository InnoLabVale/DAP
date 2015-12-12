package com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean;

import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;

public class ServiceCodeDetails implements ServiceCodeDetailsInterface {

	private String service_code_id;
	private String service_code_period;
	private String service_code_fee_amount;

	public String getService_code_id() {
		return service_code_id;
	}

	public void setService_code_id(String service_code_id) {
		this.service_code_id = service_code_id;
	}
	 
	public String getService_code_period() {
		return service_code_period;
	}
	 
	public void setService_code_period(String service_code_period) {
		this.service_code_period = service_code_period;
	}
	 
	public String getService_code_fee_amount() {
		return service_code_fee_amount;
	}
	 
	public void setService_code_fee_amount(String service_code_fee_amount) {
		this.service_code_fee_amount = service_code_fee_amount;
	}
	
	
}
