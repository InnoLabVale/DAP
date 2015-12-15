package com.innovery.mpm.allresource.interfaces.gui.util;

import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.OptionBeanInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface AllResourceUtilInterface {

	public abstract void resetFields();

	public abstract void resetOptionDetailsOnClick();

	public abstract void resetServiceCodeDetailsOnClick();

	public abstract void showOptionDetailsOnClick(OptionBeanInterface selected_option_details);

	public abstract void showServiceCodeDetailsOnClick(ServiceCodeDetailsInterface selected_option_details);

	public abstract void resetTableModel();

	public abstract String tabAccumulatorManagment(int tab_index);

	public abstract String tabFafManagment(int tab_index);

	public abstract String tabPromotionPlanManagment(int tab_index);

	public abstract String tabPamManagment(int tab_index);

	public abstract String tabShareAccoutManagment(int tab_index);

	public abstract String tabServiceCodeManagment(int tab_index);

	public abstract void tabOptionManagment(ActivatedSubscriberResourceInterface subscriber_resource, int tab_index);
	
	public String formatDate(String inputDate);
	
	public void setReference(AllResourceInterface reference);
	
	public void setComponents(DAPBeanInterface components);
}