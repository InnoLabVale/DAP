/**
 * "bean" representing the single option activated on the user. The XML file containing all ROPZ
 * released is scanned, and every ROPZ's resources are compared to resources extracted from user
 * by GET action. Every time there is a match between the option from XML and the user resources,
 * is created a new instance of this class, containing the name of option ad the related discount.
 */
package com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean;

import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptionsInterface;

public class ActivatedSubscriberOptions implements ActivatedSubscriberOptionsInterface{

	private String master;
	private String discount;

	public ActivatedSubscriberOptions() {
		this.master="-";
		this.discount="-";
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}
}
