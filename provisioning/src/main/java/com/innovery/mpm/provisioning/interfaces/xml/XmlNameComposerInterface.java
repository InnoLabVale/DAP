package com.innovery.mpm.provisioning.interfaces.xml;

import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.JDOMException;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface XmlNameComposerInterface {

	public Document getName(String service, String market, String ctype) throws JDOMException, IOException;
	
	public void setComponents(DAPBeanInterface components);
}
