package com.innovery.mpm.af.interfaces.action;

import com.innovery.mpm.af.interfaces.bean.AFinderInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface ActionAccountFinderInterface {

	public String executeAfCommand(AFinderInterface af);
	
	public void setComponents(DAPBeanInterface components);

}
