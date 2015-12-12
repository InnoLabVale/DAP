package com.innovery.mpm.resource.interfaces.gui;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.innovery.mpm.resource.interfaces.gui.util.AirResourceResponseManagerInterface;
import com.innovery.mpm.resource.interfaces.gui.util.AirResourceUtilInterface;
import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;
import com.innovery.mpm.resource.interfaces.gui.util.AirResourceResponseGridManagerInterface;
import com.innovery.mpm.resource.interfaces.gui.verification.AirResourceVerifyInterface;

public interface AirResourceInterface {

	public void setCommonGUI(GUICommonInterface commonGUI);

	public void setAutocompleteMsisdn(AutoCompleteMsisdnInterface autocompleteMsisdn);

	public void setSessionStandard(SessionStandardInterface sessionStandard);

	public void setResourceVerifier(AirResourceVerifyInterface resourceVerifier);

	public void setResponseGridManager(AirResourceResponseGridManagerInterface responseGridManager);

	public void setResponseManager(AirResourceResponseManagerInterface responseManager);

	public void setUtil(AirResourceUtilInterface util);

	public JButton getBtnExecute();

	public JFrame getFrame();

	void initialize();
}