package com.innovery.mpm.main.implementations.gui.mainpage.connection;


import com.innovery.mpm.connection.interfaces.cai.bean.Bsom_3300Interface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.connection.interfaces.standard.bean.Bsom_xInterface;
import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;
import com.innovery.mpm.main.interfaces.gui.commandselection.CommandSelectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.AuthenticationPageInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.connection.PageConnectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.IndexVerifyInterface;

public class LoginPageConnection implements PageConnectionInterface {
	
	private String username;
	private String password;
	
	private boolean dispose = false;
	private boolean logged = false;
	private String notification;
	
	private DAPBeanInterface rootComponents;
	private RedirectNamesInterface redirection;
	
	private IndexVerifyInterface verify;
	
	private Bsom_xInterface bsom_x;
	private Bsom_3300Interface bsom_3300;
	
	private CommandSelectionInterface commandSelection;
	
	public LoginPageConnection(DAPBeanInterface rootComponents){
		this.rootComponents = rootComponents;
	}
	
	public void connect(){
		
		if(verify.verify_input_login(username, password)){
			bsom_x.setUser(username);
			bsom_x.setPassword(password);
			String redirect_standard = rootComponents.getConnectionManagerStandard().loginStandard(bsom_x);
			if (redirect_standard.equals(redirection.get_COMMAND_SELECTION_PAGE())) {
				
				rootComponents.getLogger().info("LOGIN SUCCESFULLY ON PORT "+bsom_x.getPort());
				
				bsom_3300.setUser(username);
				bsom_3300.setPassword(password);
				String redirect_cai = rootComponents.getConnectionManagerCai().createConnectionCai(bsom_3300);
				if (redirect_cai.equals(redirection.get_COMMAND_SELECTION_PAGE())) {
					
					rootComponents.getLogger().info("LOGIN SUCCESFULLY ON PORT 3300");
					
					rootComponents.getConnectionManagerCai().getSession().setSessionAvailable(true);
				}
				else if (redirect_cai.equals(redirection.get_LOGIN_PAGE()) || redirect_cai.equals(redirection.get_INDEX_PAGE())) {
					
					rootComponents.getLogger().warn("LOGIN FAILED ON PORT 3300");
					
					rootComponents.getConnectionManagerCai().getSession().setSessionAvailable(false);
				}
				commandSelection.initialize();
				dispose = true;
				logged = true;
			} else if (redirect_standard.equals(redirection.get_LOGIN_PAGE())) {
				
				rootComponents.getLogger().warn("LOGIN FAILED ON PORT "+bsom_x.getPort());
				rootComponents.getLogger().info("RELOADING \"LOGIN\" PAGE");
				
				notification = "Incorrect login.";
			} else if (redirect_standard.equals(redirection.get_INDEX_PAGE())) {
				
				rootComponents.getLogger().warn("CONNECTION FAILED ON PORT "+bsom_x.getPort());
				rootComponents.getLogger().info("REDIRECTING TO \"INDEX\" PAGE");
				dispose = true;
				logged = false;
			}
		}
	}

	public boolean isDispose() {
		return dispose;
	}

	public String getNotification() {
		return notification;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRedirection(RedirectNamesInterface redirection) {
		this.redirection = redirection;
	}

	public void setVerify(IndexVerifyInterface verify) {
		this.verify = verify;
	}

	public void setBsom_x(Bsom_xInterface bsom_x) {
		this.bsom_x = bsom_x;
	}

	public void setBsom_3300(Bsom_3300Interface bsom_3300) {
		this.bsom_3300 = bsom_3300;
	}
	
	public void setCommandSelection(CommandSelectionInterface commandSelection) {
		this.commandSelection = commandSelection;
	}
	
	public boolean isLogged() {
		return logged;
	}

	public void setIp(String ip) {
	}

	public void setPort(String port) {
	}

	public void setLoginPage(AuthenticationPageInterface loginPage) {
	}
}
