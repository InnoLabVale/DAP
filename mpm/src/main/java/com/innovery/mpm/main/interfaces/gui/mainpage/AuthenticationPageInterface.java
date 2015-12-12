package com.innovery.mpm.main.interfaces.gui.mainpage;

import com.innovery.mpm.main.interfaces.gui.mainpage.connection.PageConnectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.ComboBoxManagerInterface;

public interface AuthenticationPageInterface {
	
	public final String COMBO = "COMBO";
	
	public final String FIELD = "FIELD";
	
	public void initialize();

	public void setConnectionPage(PageConnectionInterface initConnection);

	public void setRelatedPage(AuthenticationPageInterface loginPage);
	
	public void setCombo(ComboBoxManagerInterface combo);
}