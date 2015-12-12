package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public interface SubscriberTariffPlanInterface {

	public void setTariffPlanList(String[] tariffPlanList);

	public void setTariffPlanComboboxSelection(JComboBox tariffPlanComboboxSelection);

	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup);

	public void setMarketaButtonGroup(ButtonGroup marketaButtonGroup);

	public void setComponents(DAPBeanInterface components);

	public void updateTariffPlanComboList();

	public String[] compileTariffPlanComboBox(String current_market, String current_ctype);

}