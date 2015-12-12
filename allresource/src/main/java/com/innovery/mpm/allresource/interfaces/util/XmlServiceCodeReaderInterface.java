package com.innovery.mpm.allresource.interfaces.util;

import java.io.IOException;

import org.jdom2.JDOMException;

import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface XmlServiceCodeReaderInterface {

	public ServiceCodeDetailsInterface getServiceCodeDetails(String sc_selected)
			throws JDOMException, IOException;
	
	public void setComponents(DAPBeanInterface components);

}