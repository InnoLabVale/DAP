package com.innovery.mpm.connection.implementations.component;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.cai.ConnectionManagmentCaiInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.connection.interfaces.standard.ConnectionManagmentStandardInterface;
import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;
import com.innovery.mpm.connection.interfaces.util.CompleteDateInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.NotificationInterface;
import com.innovery.mpm.connection.interfaces.util.TransIdGeneratorInterface;
import com.innovery.mpm.connection.interfaces.util.UserLevelsInterface;

public class DAPBean implements DAPBeanInterface {
	
	private final static String SDP_LIST_PATH = "./settings/sdpList.properties";
	
	private final static String XML_LIST_CONSUMER_PREPAID_PATH="/resources/XMLresource/ropz_prepaid.xml";
	private final static String XML_LIST_CONSUMER_POSTPAID_PATH="/resources/XMLresource/ropz_postpaid.xml";
	private final static String XML_LIST_CORPORATE_PREPAID_PATH="/resources/XMLresource/opt_prepaid.xml";
	private final static String XML_LIST_CORPORATE_POSTPAID_PATH="/resources/XMLresource/opt_postpaid.xml";
	
	private final static String TARIFFPLAN_CONSUMER_PREPAID_PATH = "/resources/tariff_plan/consumer/prepaid/tariff_plan_consumer_prepaid.xml";
	private final static String TARIFFPLAN_CONSUMER_POSTPAID_PATH = "/resources/tariff_plan/consumer/postpaid/tariff_plan_consumer_postpaid.xml";
	private final static String TARIFFPLAN_CORPORATE_PREPAID_PATH = "/resources/tariff_plan/corporate/prepaid/tariff_plan_corporate_prepaid.xml";
	private final static String TARIFFPLAN_CORPORATE_POSTPAID_PATH = "/resources/tariff_plan/corporate/postpaid/tariff_plan_corporate_postpaid.xml";
	
	public static final String XML_OPTION_CONSUMER_PREPAID_PATH = "/resources/xml/consumer_prepaid/";
	public static final String XML_OPTION_CORPORATE_PREPAID_PATH = "/resources/xml/corporate_prepaid/";
	public static final String XML_OPTION_CONSUMER_POSTPAID_PATH = "/resources/xml/consumer_postpaid/";
	public static final String XML_OPTION_CORPORATE_POSTPAID_PATH = "/resources/xml/corporate_postpaid/";
	
	public static final String SERVICE_CODE_LIST_PATH = "/resources/sc_resource/sc_amount.xml";
	
	private ConnectionManagmentStandardInterface connectionManagerStandard;
	private ConnectionManagmentCaiInterface connectionManagerCai;
	private int currentUserLevel;
	private UserLevelsInterface userLevels;
	private GUICommonInterface commonGUI;
	private TransIdGeneratorInterface TRANSID;
	private NotificationInterface notifications;
	private CompleteDateInterface dateCompleter;
	private AutoCompleteMsisdnInterface msisdnCompleter;
	private ErrorMessagesInterface errorMessages;
	
	private Logger logger;
	
	public int getCurrentUserLevel() {
		return currentUserLevel;
	}

	public void setCurrentUserLevel(int currentUserLevel) {
		this.currentUserLevel = currentUserLevel;
	}
	 
	public UserLevelsInterface getUserLevels() {
		return userLevels;
	}
	 
	public void setUserLevels(UserLevelsInterface userLevels) {
		this.userLevels = userLevels;
	}
	
	public GUICommonInterface getCommonGUI() {
		return commonGUI;
	}
	
	public void setCommonGUI(GUICommonInterface commonGUI) {
		this.commonGUI = commonGUI;
	}
	
	public TransIdGeneratorInterface getTRANSID() {
		return TRANSID;
	}
	
	public void setTRANSID(TransIdGeneratorInterface tRANSID) {
		TRANSID = tRANSID;
	}
	
	public NotificationInterface getNotifications() {
		return notifications;
	}
	
	public void setNotifications(NotificationInterface notifications) {
		this.notifications = notifications;
	}
	
	public CompleteDateInterface getDateCompleter() {
		return dateCompleter;
	}
	
	public void setDateCompleter(CompleteDateInterface dateCompleter) {
		this.dateCompleter = dateCompleter;
	}
	
	public AutoCompleteMsisdnInterface getMsisdnCompleter() {
		return msisdnCompleter;
	}
	
	public void setMsisdnCompleter(AutoCompleteMsisdnInterface msisdnCompleter) {
		this.msisdnCompleter = msisdnCompleter;
	}
	
	public ErrorMessagesInterface getErrorMessages() {
		return errorMessages;
	}
	
	public void setErrorMessages(ErrorMessagesInterface errorMessages) {
		this.errorMessages = errorMessages;
	}

	public ConnectionManagmentStandardInterface getConnectionManagerStandard() {
		return connectionManagerStandard;
	}

	public void setConnectionManagerStandard(
			ConnectionManagmentStandardInterface connectionManagerStandard) {
		this.connectionManagerStandard = connectionManagerStandard;
	}

	public ConnectionManagmentCaiInterface getConnectionManagerCai() {
		return connectionManagerCai;
	}

	public void setConnectionManagerCai(
			ConnectionManagmentCaiInterface connectionManagerCai) {
		this.connectionManagerCai = connectionManagerCai;
	}
	
	public String SDP_LIST_PATH() {
		return SDP_LIST_PATH;
	}

	public String XML_LIST_CONSUMER_PREPAID_PATH() {
		return XML_LIST_CONSUMER_PREPAID_PATH;
	}

	public String XML_LIST_CONSUMER_POSTPAID_PATH() {
		return XML_LIST_CONSUMER_POSTPAID_PATH;
	}

	public String XML_LIST_CORPORATE_PREPAID_PATH() {
		return XML_LIST_CORPORATE_PREPAID_PATH;
	}

	public String XML_LIST_CORPORATE_POSTPAID_PATH() {
		return XML_LIST_CORPORATE_POSTPAID_PATH;
	}

	public String TARIFFPLAN_CONSUMER_PREPAID_PATH() {
		return TARIFFPLAN_CONSUMER_PREPAID_PATH;
	}

	public String TARIFFPLAN_CONSUMER_POSTPAID_PATH() {
		return TARIFFPLAN_CONSUMER_POSTPAID_PATH;
	}

	public String TARIFFPLAN_CORPORATE_PREPAID_PATH() {
		return TARIFFPLAN_CORPORATE_PREPAID_PATH;
	}

	public String TARIFFPLAN_CORPORATE_POSTPAID_PATH() {
		return TARIFFPLAN_CORPORATE_POSTPAID_PATH;
	}

	public String XML_OPTION_CONSUMER_PREPAID_PATH() {
		return XML_OPTION_CONSUMER_PREPAID_PATH;
	}

	public String XML_OPTION_CORPORATE_PREPAID_PATH() {
		return XML_OPTION_CORPORATE_PREPAID_PATH;
	}

	public String XML_OPTION_CONSUMER_POSTPAID_PATH() {
		return XML_OPTION_CONSUMER_POSTPAID_PATH;
	}

	public String XML_OPTION_CORPORATE_POSTPAID_PATH() {
		return XML_OPTION_CORPORATE_POSTPAID_PATH;
	}
	
	public String SERVICE_CODE_LIST_PATH(){
		return SERVICE_CODE_LIST_PATH;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
}
