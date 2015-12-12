package com.innovery.mpm.allresource.interfaces.util;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;

import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptionsInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SubscriberOptionFinderInterface {

	public List<ActivatedSubscriberOptionsInterface> executeSubscriberOptionFinder(ActivatedSubscriberResourceInterface value_extracted_from_user, String market, String ctype) throws JDOMException, IOException;
	
	public void setComponents(DAPBeanInterface components);
}
