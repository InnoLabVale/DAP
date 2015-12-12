package com.innovery.mpm.resource.interfaces.gui.verification;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.gui.util.bean.GuiResourcePanelInterface;

public interface AirResourceBeanVerifyInterface {

	public void setComponents(DAPBeanInterface components);

	public void setActionButtonGroup(ButtonGroup actionButtonGroup);

	public void setGuiPanel(GuiResourcePanelInterface guiPanel);
	
	public boolean verify();
}
