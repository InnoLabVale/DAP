package com.innovery.mpm.subscriber.interfaces.gui.util;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

public interface SubscriberTypeInterface {

	void setChangeComboboxSelection(JComboBox changeComboboxSelection);

	void setChange(SubscriberChangeInterface change);

	void setAssuranceManager(SubscriberAssuranceInterface assuranceManager);

	void setCreateManager(SubscriberCreateInterface createManager);

	void setMarketButtonGroup(ButtonGroup marketButtonGroup);

	void setActionButtonGroup(ButtonGroup actionButtonGroup);

	void actionOnPostpaid();

	void actionOnPrepaid();

}