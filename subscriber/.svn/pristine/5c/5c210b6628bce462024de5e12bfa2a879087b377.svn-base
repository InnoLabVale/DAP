package com.innovery.mpm.subscriber.implementations.gui.verification.util;

import javax.swing.ButtonGroup;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class LineStateVerification{

	private DAPBeanInterface components;
	
	private ButtonGroup lineStateButtonGroup;
	
	public boolean execute() {
		if(lineStateButtonGroup.getSelection()==null){
			components.getNotifications().error("Select an action for line state.");
			return false;
		}
		return true;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setLineStateButtonGroup(ButtonGroup lineStateButtonGroup) {
		this.lineStateButtonGroup = lineStateButtonGroup;
	}
}
