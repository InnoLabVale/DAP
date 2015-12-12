package com.innovery.mpm.allresource.interfaces.action.ssh;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface ActionServiceCodeInterface {

	public String get(String msisdn);
	
	public void setComponents(DAPBeanInterface components);

}