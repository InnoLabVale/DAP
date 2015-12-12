package com.innovery.mpm.main.implementations.gui.mainpage.connection;

import com.innovery.mpm.connection.interfaces.cai.bean.Bsom_3300Interface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.connection.interfaces.standard.bean.Bsom_xInterface;
import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;
import com.innovery.mpm.main.interfaces.gui.commandselection.CommandSelectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.AuthenticationPageInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.connection.PageConnectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.IndexVerifyInterface;

public class MainPageConnection implements PageConnectionInterface {
	
	private String ip;
	private String port;
	private String username;
	private String password;
	
	private boolean dispose = false;
	private String notification;
	
	private DAPBeanInterface rootComponents;
	
	private IndexVerifyInterface verify;
	private RedirectNamesInterface redirection;
	
	private Bsom_xInterface bsom_x;
	private Bsom_3300Interface bsom_3300;
	
	private AuthenticationPageInterface loginPage;
	
	private CommandSelectionInterface commandSelection;
	
	public MainPageConnection(DAPBeanInterface rootComponents){
		this.rootComponents = rootComponents;
	}
	
	public void connect(){
		rootComponents.getLogger().info("CHECKING INPUT PARAMETERS FOR CONNECTION");
		
		if (verify.verify_input_connection(ip, port, username, password)) {
			
			rootComponents.getLogger().info("INPUT PARAMETERS CHECKED");
			rootComponents.getLogger().info("INPUT IP ADDRESS: " + ip);
			rootComponents.getLogger().info("INPUT PORT: " + port);
			rootComponents.getLogger().info("INPUT USER: " + username);
			
			bsom_x.setIp(ip);
			bsom_x.setPort(Integer.parseInt(port));
			bsom_x.setUser(username);
			bsom_x.setPassword(password);
			
			bsom_3300.setIp(ip);
			bsom_3300.setUser(username);
			bsom_3300.setPassword(password);
			
			String redirect_standard = rootComponents.getConnectionManagerStandard().createConnectionStandard(bsom_x);
			if (redirect_standard.equals(redirection.get_COMMAND_SELECTION_PAGE())) {
				
				rootComponents.getLogger().info("LOGIN SUCCESFULLY ON PORT "+port);
				
				rootComponents.getConnectionManagerStandard().setUserLevel(rootComponents.getCurrentUserLevel());
				String redirect_cai = rootComponents.getConnectionManagerCai().createConnectionCai(bsom_3300);
				if (redirect_cai.equals(redirection.get_COMMAND_SELECTION_PAGE())) {
					
					rootComponents.getLogger().info("LOGIN SUCCESFULLY ON PORT 3300");
					
					rootComponents.getConnectionManagerCai().getSession().setSessionAvailable(true);
				} else if (redirect_cai.equals(redirection.get_LOGIN_PAGE()) || redirect_cai.equals(redirection.get_INDEX_PAGE())) {
					
					rootComponents.getLogger().warn("LOGIN FAILED ON PORT 3300");
					
					rootComponents.getConnectionManagerCai().getSession().setSessionAvailable(false);
				}
				commandSelection.initialize();
				dispose = true;
			} else if (redirect_standard.equals(redirection.get_LOGIN_PAGE())) {
				
				rootComponents.getLogger().warn("LOGIN FAILED ON PORT "+port);
				rootComponents.getLogger().info("REDIRECTING TO \"LOGIN\" PAGE");
				
				rootComponents.getConnectionManagerStandard().setUserLevel(rootComponents.getCurrentUserLevel());
				loginPage.initialize();
				dispose = true;
			} else if (redirect_standard.equals(redirection.get_INDEX_PAGE())) {
				rootComponents.getLogger().warn("CONNECTION FAILED ON PORT "+port);
				rootComponents.getLogger().info("RELOADING \"INDEX\" PAGE");
				notification = "Unable to connect.";
			}
		}
	}

	public boolean isDispose() {
		return dispose;
	}

	public String getNotification() {
		return notification;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setVerify(IndexVerifyInterface verify) {
		this.verify = verify;
	}

	public void setRedirection(RedirectNamesInterface redirection) {
		this.redirection = redirection;
	}

	public void setBsom_x(Bsom_xInterface bsom_x) {
		this.bsom_x = bsom_x;
	}
	
	public boolean isLogged(){
		return false;
	}

	public void setBsom_3300(Bsom_3300Interface bsom_3300) {
		this.bsom_3300 = bsom_3300;
	}

	public void setLoginPage(AuthenticationPageInterface loginPage) {
		this.loginPage = loginPage;
	}

	public void setCommandSelection(CommandSelectionInterface commandSelection) {
		this.commandSelection = commandSelection;
	}
}
