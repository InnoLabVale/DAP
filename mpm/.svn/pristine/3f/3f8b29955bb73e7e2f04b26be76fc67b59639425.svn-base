package com.innovery.mpm.main.implementations.gui.mainpage.util;

import java.util.regex.Pattern;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.IndexVerifyInterface;

/**
 * 
 * @author Daniela R. Auricchio
 * called by com.innovery.mpm.gui.MainPage
 */
public class IndexVerify implements IndexVerifyInterface {
	
	private DAPBeanInterface rootComponents;
	
	public IndexVerify(DAPBeanInterface rootComponents){
		this.rootComponents = rootComponents;
	}
	
	public boolean verify_input_connection(String ip, String port, String username, String password){
		
		String ipRegEx = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
		
		if(ip!=null && !Pattern.matches(ipRegEx, ip)){
			rootComponents.getNotifications().error("Ip address not valid.");
			return false;
		}
		if (port!=null && !isNumber(port)) {
			rootComponents.getNotifications().error("Port number not valid.");
			return false;
		}
		
		if(username!=null && username.equals("")){
			rootComponents.getNotifications().error("Username is mandatory.");
			return false;
		}
		
		if(password!=null && password.equals("")){
			rootComponents.getNotifications().error("Password is mandatory.");
			return false;
		}
		
		return true;
	}
	
	public boolean verify_input_login(String username, String password){
		if(username!=null && username.equals("")){
			rootComponents.getNotifications().error("Username is mandatory.");
			return false;
		}
		
		if(password!=null && password.equals("")){
			rootComponents.getNotifications().error("Password is mandatory.");
			return false;
		}
		
		return true;
	}
	
	private boolean isNumber(String number){
		
		try {
			Integer.parseInt(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}