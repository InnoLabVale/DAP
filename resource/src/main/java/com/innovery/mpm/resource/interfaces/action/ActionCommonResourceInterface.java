package com.innovery.mpm.resource.interfaces.action;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.interfaces.bean.CommonResourceInterface;

public interface ActionCommonResourceInterface {

	public String ExecuteCaiCommand(CommonResourceInterface resourceBean);
	
	public void setComponents(DAPBeanInterface components);
}
