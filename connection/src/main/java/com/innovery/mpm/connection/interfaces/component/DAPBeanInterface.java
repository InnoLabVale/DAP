package com.innovery.mpm.connection.interfaces.component;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.cai.ConnectionManagmentCaiInterface;
import com.innovery.mpm.connection.interfaces.standard.ConnectionManagmentStandardInterface;
import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;
import com.innovery.mpm.connection.interfaces.util.CompleteDateInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.NotificationInterface;
import com.innovery.mpm.connection.interfaces.util.TransIdGeneratorInterface;
import com.innovery.mpm.connection.interfaces.util.UserLevelsInterface;

public interface DAPBeanInterface {
	
	public static final String CH1 = ":CSCHAIN,CH1";
	
	public static final String CH2 = ":CSCHAIN,CH2";
	
	public static final String PREPAID = "prepaid";
	
	public static final String POSTPAID = "postpaid";
	
	public static final String CONSUMER = "consumer";
	
	public static final String CORPORATE = "corporate";

	public int getCurrentUserLevel();

	public void setCurrentUserLevel(int currentUserLevel);

	public UserLevelsInterface getUserLevels();

	public void setUserLevels(UserLevelsInterface userLevels);

	public GUICommonInterface getCommonGUI();

	public void setCommonGUI(GUICommonInterface commonGUI);

	public TransIdGeneratorInterface getTRANSID();

	public void setTRANSID(TransIdGeneratorInterface tRANSID);

	public NotificationInterface getNotifications();

	public void setNotifications(NotificationInterface notifications);

	public CompleteDateInterface getDateCompleter();

	public void setDateCompleter(CompleteDateInterface dateCompleter);

	public AutoCompleteMsisdnInterface getMsisdnCompleter();

	public void setMsisdnCompleter(AutoCompleteMsisdnInterface msisdnCompleter);

	public ErrorMessagesInterface getErrorMessages();

	public void setErrorMessages(ErrorMessagesInterface errorMessages);

	public ConnectionManagmentStandardInterface getConnectionManagerStandard();

	public void setConnectionManagerStandard(ConnectionManagmentStandardInterface connectionManagerStandard);

	public ConnectionManagmentCaiInterface getConnectionManagerCai();

	public void setConnectionManagerCai(ConnectionManagmentCaiInterface connectionManagerCai);
	
	public String SDP_LIST_PATH();

	public String XML_LIST_CONSUMER_PREPAID_PATH();

	public String XML_LIST_CONSUMER_POSTPAID_PATH();

	public String XML_LIST_CORPORATE_PREPAID_PATH();

	public String XML_LIST_CORPORATE_POSTPAID_PATH();

	public String TARIFFPLAN_CONSUMER_PREPAID_PATH();

	public String TARIFFPLAN_CONSUMER_POSTPAID_PATH();

	public String TARIFFPLAN_CORPORATE_PREPAID_PATH();

	public String TARIFFPLAN_CORPORATE_POSTPAID_PATH();
	
	public String XML_OPTION_CONSUMER_PREPAID_PATH();

	public String XML_OPTION_CORPORATE_PREPAID_PATH();

	public String XML_OPTION_CONSUMER_POSTPAID_PATH();

	public String XML_OPTION_CORPORATE_POSTPAID_PATH();
	
	public String SERVICE_CODE_LIST_PATH();
	
	public Logger getLogger();

	public void setLogger(Logger logger);
}