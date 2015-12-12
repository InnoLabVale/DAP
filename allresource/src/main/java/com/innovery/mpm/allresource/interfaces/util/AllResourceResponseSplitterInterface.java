package com.innovery.mpm.allresource.interfaces.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface AllResourceResponseSplitterInterface {

	public String split(String response, String pattern);

	public void setComponents(DAPBeanInterface components);

}