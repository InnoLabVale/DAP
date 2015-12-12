package com.innovery.mpm.provisioning.interfaces.gui.util;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.provisioning.interfaces.gui.BsoResourceInterface;

public interface ProvisioningOptionLoaderInterface {

	void load();

	void setReference(BsoResourceInterface reference);

	public void setComponents(DAPBeanInterface components);
}