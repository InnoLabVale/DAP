package com.innovery.mpm.allresource.implementations.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.ServiceCodeDetails;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;
import com.innovery.mpm.allresource.interfaces.util.XmlServiceCodeReaderInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class XmlServiceCodeReader implements XmlServiceCodeReaderInterface {
	
	private DAPBeanInterface components;
	private SAXBuilder builder;
	private Document doc;
	
	public XmlServiceCodeReader(){
		this.builder = new SAXBuilder();
	}

	public ServiceCodeDetailsInterface getServiceCodeDetails(String sc_selected) throws JDOMException, IOException{

		InputStream fileResource = getClass().getResourceAsStream(components.SERVICE_CODE_LIST_PATH());
		this.doc = builder.build(fileResource);
		List<Element> tagList = doc.getRootElement().getChildren();
		
		ServiceCodeDetailsInterface service_code_fount = null;
		
		for(int i=0; i<tagList.size(); i++){
			Element e = tagList.get(i);
			if(e.getAttributeValue("id").equals(sc_selected)){
				service_code_fount = new ServiceCodeDetails();
				service_code_fount.setService_code_id(sc_selected);
				List<Element> sc_details_list = e.getChildren();
				for(int j=0; j<sc_details_list.size(); j++){
					Element detail = sc_details_list.get(j);
					if(detail.getName().equals("fee_period")){
						service_code_fount.setService_code_period(detail.getValue());
					}
					else if(detail.getName().equals("fee_amount")){
						service_code_fount.setService_code_fee_amount(detail.getValue());
					}
				}
			}
		}
		return service_code_fount;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}