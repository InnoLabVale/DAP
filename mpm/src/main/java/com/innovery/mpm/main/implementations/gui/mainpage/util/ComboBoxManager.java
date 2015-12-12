package com.innovery.mpm.main.implementations.gui.mainpage.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import com.innovery.mpm.connection.interfaces.util.NotificationInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.ComboBoxManagerInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.MpmBeanInterface;

public class ComboBoxManager implements ComboBoxManagerInterface {
	
	private List<MpmBeanInterface> mpm_bean_list;
	private Properties pr;
	private final String DEFAULT = "Select";
	
	private final String path = "./settings/addresses.properties";
	private final String notificationMessage = "Missing MPM address configuration file!";
	
	private String ip;
	private String port;
	private String user;
	
	private NotificationInterface notification;
	
	public ComboBoxManager(NotificationInterface notification){
		this.notification = notification;
	}
	
	public String[] compileComboBox(){
		String[] mpmSelectElements;
		mpm_bean_list = new ArrayList<MpmBeanInterface>();
		pr = new Properties();
		try {
			pr.load(new FileInputStream(path));
		} catch (IOException e) {
			notification.warning(notificationMessage);
		}
		
		Set<Entry<Object, Object>> mpm_list = pr.entrySet();
		int element_number = mpm_list.size()/3;
		
		mpmSelectElements = new String[(element_number+1)];
		mpmSelectElements[0]=DEFAULT;
		
		for(int i=0; i<element_number; i++){
			
			MpmBeanInterface temp_bean = new MpmBean();
			
			String selected_index = "address"+(i+1)+".";
			temp_bean.setName(pr.getProperty(selected_index+"name"));
			temp_bean.setIp(pr.getProperty(selected_index+"ip"));
			temp_bean.setPort(pr.getProperty(selected_index+"port"));
			temp_bean.setUser(pr.getProperty(selected_index+"user"));
			
			mpm_bean_list.add(temp_bean);
			
		}
		
		for(int i=0; i<mpm_bean_list.size(); i++){
			mpmSelectElements[i+1] = mpm_bean_list.get(i).getName();
		}
		
		return mpmSelectElements;
	}
	
	public void chooseMpm(String selectedMpm){
		for(int i=0; i<mpm_bean_list.size(); i++){
			MpmBeanInterface temp_bean = mpm_bean_list.get(i);
			if(temp_bean.getName().equals(selectedMpm)){
				ip = temp_bean.getIp();
				port = temp_bean.getPort();
				user = temp_bean.getUser();
			}
		}
	}

	public String getIp() {
		return ip;
	}

	public String getPort() {
		return port;
	}

	public String getUser() {
		return user;
	}
}
