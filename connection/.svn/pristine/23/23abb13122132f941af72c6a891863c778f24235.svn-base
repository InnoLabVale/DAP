package com.innovery.mpm.connection.interfaces.standard;

import java.util.ResourceBundle;

import com.innovery.mpm.connection.interfaces.standard.bean.Bsom_xInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;

public interface ConnectionManagmentStandardInterface {

	public String createConnectionStandard(Bsom_xInterface bsom_bean);

	public void disconnectStandard();
	
	public String loginStandard(Bsom_xInterface bsom_bean);
	
	public String reconnectionStandard(String status);
	
	public SessionStandardInterface getSession();
	
	public ResourceBundle getRb_errorCode();
	
	public int getUserLevel();
	
	public void setUserLevel(int level);
}
