package com.innovery.mpm.allresource.implementations;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.innovery.mpm.allresource.implementations.action.ActionGetResources;
import com.innovery.mpm.allresource.implementations.gui.AllResource;
import com.innovery.mpm.allresource.implementations.gui.util.AllResourceUtil;
import com.innovery.mpm.allresource.implementations.util.AllResourceNotificationConnectionWarning;
import com.innovery.mpm.allresource.implementations.util.AllResourceResponseSplitter;
import com.innovery.mpm.allresource.interfaces.AllResourceInitializationInterface;
import com.innovery.mpm.allresource.interfaces.action.ActionGetResourcesInterface;
import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;
import com.innovery.mpm.allresource.interfaces.gui.util.AllResourceUtilInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceNotificationConnectionWarningInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceResponseSplitterInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class AllResourceInitialization implements AllResourceInitializationInterface {
	
	AllResourceInterface all_resource;

	public AllResourceInitialization(DAPBeanInterface components){
		
		AllResourceNotificationConnectionWarningInterface connectionWarning = new AllResourceNotificationConnectionWarning();
		AllResourceResponseSplitterInterface splitter = new AllResourceResponseSplitter();
		ActionGetResourcesInterface get_resources = new ActionGetResources();
		AllResourceUtilInterface util = new AllResourceUtil();
		
		all_resource = new AllResource(components);
		
		connectionWarning.setComponents(components);
		connectionWarning.setReference(all_resource);
		
		splitter.setComponents(components);
		
		get_resources.setComponents(components);
		get_resources.setSplitter(splitter);
		
		util.setComponents(components);
		util.setReference(all_resource);
		
		all_resource.setConnectionWarning(connectionWarning);
		all_resource.setUtil(util);
		all_resource.setGet_resources(get_resources);
	}
	
	public void initialize(){
		all_resource.initialize();
	}
	
	public JFrame getFreme(){
		return all_resource.getFrame();
	}
	
	public JButton getBtnView(){
		return all_resource.getBtnView();
	}
}
