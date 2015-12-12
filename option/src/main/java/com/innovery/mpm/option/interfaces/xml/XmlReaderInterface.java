package com.innovery.mpm.option.interfaces.xml;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.option.interfaces.gui.tablemodel.OptionBeanInterface;

public interface XmlReaderInterface {

	public List<OptionBeanInterface> readXml(String market, String ctype) throws JDOMException,
			IOException, SAXException, ParserConfigurationException;

	public List<OptionBeanInterface> readXml(String optPattern, String market, String ctype)
			throws JDOMException, IOException, SAXException,
			ParserConfigurationException, XPathExpressionException;

	public OptionBeanInterface getOptionDetails(String optPattern, String market, String ctype)
			throws JDOMException, IOException, SAXException,
			ParserConfigurationException, XPathExpressionException;
	
	public void setComponents(DAPBeanInterface components);
}
