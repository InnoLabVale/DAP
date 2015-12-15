package com.innovery.mpm.option.implementations.gui;

import javax.swing.JFrame;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.option.implementations.xml.XmlReader;
import com.innovery.mpm.option.interfaces.gui.OptionManagerInitializationInterface;
import com.innovery.mpm.option.interfaces.gui.OptionManagerInterface;
import com.innovery.mpm.option.interfaces.xml.XmlReaderInterface;

public class OptionManagerInitialization implements OptionManagerInitializationInterface {
	
	private OptionManagerInterface optionManager;

	public OptionManagerInitialization(DAPBeanInterface components){
		XmlReaderInterface xmlReader = new XmlReader();
		xmlReader.setComponents(components);
		
		optionManager = new OptionManager();
		optionManager.setLog(components.getLogger());
		optionManager.setNotification(components.getNotifications());
		optionManager.setXml_reader(xmlReader);
	}
	
	public void initialize(){
		optionManager.initialize();
	}
	
	public JFrame getFrame(){
		return optionManager.getFrame();
	}
}
