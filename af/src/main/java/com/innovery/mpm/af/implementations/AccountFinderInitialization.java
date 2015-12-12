package com.innovery.mpm.af.implementations;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.innovery.mpm.af.implementations.gui.AccountFinder;
import com.innovery.mpm.af.implementations.gui.util.AccountFinderResponseGridManager;
import com.innovery.mpm.af.implementations.gui.util.AccountFinderResponseManager;
import com.innovery.mpm.af.implementations.gui.util.AccountFinderUtil;
import com.innovery.mpm.af.implementations.gui.verification.AccountFinderVerify;
import com.innovery.mpm.af.interfaces.AccountFinderInitializationInterface;
import com.innovery.mpm.af.interfaces.gui.AccountFinderInterface;
import com.innovery.mpm.af.interfaces.gui.util.AccountFinderResponseGridManagerInterface;
import com.innovery.mpm.af.interfaces.gui.util.AccountFinderResponseManagerInterface;
import com.innovery.mpm.af.interfaces.gui.util.AccountFinderUtilInterface;
import com.innovery.mpm.af.interfaces.gui.verification.AccountFinderVerifyInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class AccountFinderInitialization implements AccountFinderInitializationInterface {
	
	AccountFinderInterface account_finder;

	public AccountFinderInitialization(DAPBeanInterface components){
		
		AccountFinderUtilInterface util = new AccountFinderUtil();
		AccountFinderVerifyInterface verification = new AccountFinderVerify();
		AccountFinderResponseManagerInterface response_manager = new AccountFinderResponseManager();
		AccountFinderResponseGridManagerInterface grid_managment = new AccountFinderResponseGridManager();
		
		util.setComponents(components);
		verification.setComponents(components);
		response_manager.setComponents(components);
		grid_managment.setComponents(components);
		
		account_finder = new AccountFinder();
		
		account_finder.setCommonGUI(components.getCommonGUI());
		account_finder.setSessionStandard(components.getConnectionManagerStandard().getSession());
		account_finder.setLogger(components.getLogger());
		account_finder.setMsisdnCompleter(components.getMsisdnCompleter());
		
		account_finder.setUtil(util);
		account_finder.setVerification(verification);
		account_finder.setResponseManager(response_manager);
		account_finder.setResponseGridManager(grid_managment);
	}

	public void initialize(){
		account_finder.initialize();
	}
	
	public JFrame getFrame(){
		return account_finder.getFrame();
	}
	
	public JButton getBtnExecute(){
		return account_finder.getBtnExecute();
	}
}
