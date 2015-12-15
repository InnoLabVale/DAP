package com.innovery.mpm.main.interfaces.gui.mainpage.connection;

import com.innovery.mpm.connection.interfaces.cai.bean.Bsom_3300Interface;
import com.innovery.mpm.connection.interfaces.standard.bean.Bsom_xInterface;
import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;
import com.innovery.mpm.main.interfaces.gui.commandselection.CommandSelectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.AuthenticationPageInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.IndexVerifyInterface;

public interface PageConnectionInterface {

	public void connect();
	
	public boolean isDispose();

	public String getNotification();

	public void setIp(String ip);

	public void setPort(String port);

	public void setUsername(String username);

	public void setPassword(String password);

	public void setVerify(IndexVerifyInterface verify);

	public void setRedirection(RedirectNamesInterface redirection);
	
	public void setBsom_x(Bsom_xInterface bsom_x);

	public void setBsom_3300(Bsom_3300Interface bsom_3300);
	
	public boolean isLogged();
	
	public void setLoginPage(AuthenticationPageInterface loginPage);
	
	public void setCommandSelection(CommandSelectionInterface commandSelection);
}