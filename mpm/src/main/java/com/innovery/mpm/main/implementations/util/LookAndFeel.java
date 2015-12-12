package com.innovery.mpm.main.implementations.util;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

public class LookAndFeel {
	
	private static Logger log = Logger.getLogger("mpmlogger");
	
	private final String logMessage = "UNABLE TO FIND OR LOAD \"NIMBUS\" LOOK AND FEEL FOR GUI";
	private final String notificationMessage = "Unable to load \"Nimbus\" look. Default look selected.";
	
	private NotificationInterface notification;
	
	public LookAndFeel(NotificationInterface notification){
		this.notification = notification;
	}

	public void lookAndFeelLoad(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		    
		} catch (Exception e) {
		    log.warn(logMessage);
		    notification.warning(notificationMessage);
		}
		setFont();
	}
	
	private static void setFont(){
		UIManager.getLookAndFeelDefaults().put("defaultFont",  new Font(GUICommonInterface.font, GUICommonInterface.style, GUICommonInterface.size));
	}
}
