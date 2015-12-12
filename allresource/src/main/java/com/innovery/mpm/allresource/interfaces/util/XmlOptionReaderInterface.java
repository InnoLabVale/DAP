package com.innovery.mpm.allresource.interfaces.util;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.OptionBeanInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface XmlOptionReaderInterface {

	public OptionBeanInterface getOptionDetails(String optPattern,
			String market, String ctype) throws JDOMException, IOException,
			SAXException, ParserConfigurationException,
			XPathExpressionException;
	
	public void setComponents(DAPBeanInterface components);

}