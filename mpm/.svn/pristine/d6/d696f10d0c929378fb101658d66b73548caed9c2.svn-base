package com.innovery.mpm.main.implementations.util;

import java.io.File;

import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

public class SettingFilesControl {
	
	private final String path = "./settings/sdpList.properties";
	private final String notificationMessage = "SDP configuration file missing.";
	
	private NotificationInterface notification;
	
	public SettingFilesControl(NotificationInterface notification){
		this.notification = notification;
	}

	public boolean verifySdpTestListFile() {
		File sdp_file = new File(path);
		if(sdp_file.exists()){
			return true;
		}
		notification.error(notificationMessage);
		return false;
	}
}
