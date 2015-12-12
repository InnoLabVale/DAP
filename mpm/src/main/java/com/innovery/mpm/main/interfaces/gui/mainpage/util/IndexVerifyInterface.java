package com.innovery.mpm.main.interfaces.gui.mainpage.util;

public interface IndexVerifyInterface {

	public boolean verify_input_connection(String ip, String port, String username, String passowrd);
	
	public boolean verify_input_login(String username, String passowrd);
}