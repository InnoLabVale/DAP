package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.ServiceOfferingsInterface;

public class ServiceOfferings implements ServiceOfferingsInterface{

	private String serviceoffering;
	private String[] serviceofferingsList;
	boolean bit;
	
	public ServiceOfferings(){
		this.serviceoffering = "";
		this.bit=true;
	}
	
	public String getServiceOffering(){
		return this.serviceoffering;
	}
	
	public void setServiceOffering(String serviceoffering){
		this.serviceoffering=serviceoffering;
	}

	public String[] getServiceofferingsList() {
		return serviceofferingsList;
	}

	public void setServiceofferingsList(String[] serviceofferingsList) {
		this.serviceofferingsList = serviceofferingsList;
	}

	public boolean isBit() {
		return bit;
	}

	public void setBit(boolean bit) {
		this.bit = bit;
	}
}
