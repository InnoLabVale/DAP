package com.innovery.mpm.allresource.interfaces.action;

import com.innovery.mpm.allresource.interfaces.util.AllResourceResponseSplitterInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface ActionGetResourcesInterface {
	
	public Object getAccountDetails(String msisdn, String market, String ctype);

	public Object getAccumulators(String msisdn, String market, String ctype);

	public Object[] getBalanceAndDate(String msisdn, String market, String ctype);

	public Object getFaf(String msisdn, String market, String ctype);

	public Object getPam(String msisdn, String market, String ctype);

	public Object getPromotionPlan(String msisdn, String market, String ctype);

	public Object getShareAccount(String msisdn, String market, String ctype);

	public Object getServiceCode(String msisdn);

	public void setComponents(DAPBeanInterface components);
	
	public void setSplitter(AllResourceResponseSplitterInterface splitter);
}