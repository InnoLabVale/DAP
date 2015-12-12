package com.innovery.mpm.subscriber.interfaces.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;
import com.innovery.mpm.connection.interfaces.util.UserLevelsInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberAssuranceInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberDataServiceVerificationInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberFeeDiscountVerificationInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberResponseManagerInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.gui.verification.SubscriberVerifyInterface;

public interface SubscriberInterface {

	public final String APLICATION_TITLE = "Dashboard Assurance Prepaid - SUBSCRIBER MANAGMENT";
	public final String PAGE_TITLE = "SUBSCRIBER MANAGMENT";
	public final String COPYRIGHT = "- By Innovery S.p.A. -";
	public final String PANEL_LEFT_TITLE = "BSO Command";
	public final String PANEL_RIGHT_TITLE = "Response";
	public final String MORE_BUTTON = "+";
	public final String LESS_BUTTON = "-";
	public final String EXECUTE_BUTTON = "Execute";
	public void setSubscriberVerifier(SubscriberVerifyInterface subscriberVerifier);
	public void setDataServiceManager(SubscriberDataServiceVerificationInterface dataServiceManager);
	public void setFeeDiscountManager(SubscriberFeeDiscountVerificationInterface feeDiscountManager);
	public void setAssuranceManager(SubscriberAssuranceInterface assuranceManager);
	public void setResponseManager(SubscriberResponseManagerInterface responseManager);
	public void setTariffPlanManager(SubscriberTariffPlanInterface tariffPlanManager);
	public void setUtil(SubscriberUtilInterface util);
	public void resetResponseGrid();
	public void initialize();
	public JButton getBtnExecute();
	public JFrame getFrame();
	void setUserLevels(UserLevelsInterface userLevels);
	void setAutocompleteMsisdn(AutoCompleteMsisdnInterface autocompleteMsisdn);
	void setCommonGUI(GUICommonInterface commonGUI);
	void setSessionStandard(SessionStandardInterface sessionStandard);
	void setLog(Logger log);
}