package com.innovery.mpm.main.implementations.util;

import java.io.File;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

public class PackagesControl {
	
	private Logger log;
	
	private NotificationInterface notification;
	
	private final String notificationMessage = "One ore more file missing. Appliation will be closed!";
	
	private static ResourceBundle rb_jarList_bundle;
	private List<String> jar_name_list_read_from_properties;
	private List<String> file_list_read_from_dir;
	
	public PackagesControl(NotificationInterface notification, Logger log){
		this.log = log;
		this.notification = notification;
		this.jar_name_list_read_from_properties = new ArrayList<String>();
		this.file_list_read_from_dir = new ArrayList<String>();
	}
	
	public boolean verifyPackagesList() throws GeneralSecurityException{
		
		getJarListFromFile();
		getJarListFromDirectory();
		
		verify();
		return true;
	}
	
	private void verify(){
		if(jar_name_list_read_from_properties.size()>file_list_read_from_dir.size()){
			notification.error(notificationMessage);
			System.exit(-1);
		}
		else{
			for(int i=0; i<jar_name_list_read_from_properties.size(); i++){
				String extracted_jar_name = jar_name_list_read_from_properties.get(i);
				if(!file_list_read_from_dir.contains(extracted_jar_name)){
					notification.error(notificationMessage);
					System.exit(-1);
				}
			}
		}
	}
	
	private void getJarListFromFile() throws GeneralSecurityException{
		try {
			rb_jarList_bundle = ResourceBundle.getBundle("jarList");
		} catch (MissingResourceException e) {
			notification.error(notificationMessage);
			log.error(notificationMessage);
			log.error(e);
		}
		Enumeration<String> list= rb_jarList_bundle.getKeys();
		while(list.hasMoreElements()){
			jar_name_list_read_from_properties.add(new JarReader().get(list.nextElement()));
		}
	}
	
	private void getJarListFromDirectory(){
		File file = null;
		try {
			file = new File("DAP_lib");
			File[] readFileList = file.listFiles();
			for(int i=0; i<readFileList.length; i++){
				String name = readFileList[i].getName();
				file_list_read_from_dir.add(name);
			}
		} 
		
		catch (Exception e) {
			notification.error(notificationMessage);
			log.error(notificationMessage);
			log.error(e);
		}	
	}
}
