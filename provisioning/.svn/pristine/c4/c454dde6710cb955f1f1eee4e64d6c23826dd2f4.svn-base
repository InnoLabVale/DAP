package com.innovery.mpm.provisioning.implementations.xml;

import java.io.IOException;
import java.io.InputStream;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.provisioning.interfaces.xml.XmlNameComposerInterface;

public class XmlNameComposer implements XmlNameComposerInterface{
	
	private DAPBeanInterface components;
	
	public Document getName(String service, String market, String ctype) throws JDOMException, IOException{
		SAXBuilder builder = new SAXBuilder();
		
		InputStream fileResource = null;
		String fileName = service+".xml";
		if(market.equals(DAPBeanInterface.CONSUMER)){
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				fileResource = getClass().getResourceAsStream(components.XML_OPTION_CONSUMER_PREPAID_PATH()+fileName);
			}
			
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				fileResource = getClass().getResourceAsStream(components.XML_OPTION_CONSUMER_POSTPAID_PATH()+fileName);
			}
		}
		else if(market.equals(DAPBeanInterface.CORPORATE)){
			if(ctype.equals(DAPBeanInterface.PREPAID)){
				fileResource = getClass().getResourceAsStream(components.XML_OPTION_CORPORATE_PREPAID_PATH()+fileName);
			}
			
			else if(ctype.equals(DAPBeanInterface.POSTPAID)){
				fileResource = getClass().getResourceAsStream(components.XML_OPTION_CORPORATE_POSTPAID_PATH()+fileName);
			}
		}
		return builder.build(fileResource);
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
