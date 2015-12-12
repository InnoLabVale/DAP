package com.innovery.mpm.connection.interfaces.cai.session;

import com.innovery.mpm.connection.interfaces.cai.ConnectionMpmCaiInterface;

public interface SessionCaiInterface {

	public void clear();
	
	public String getIp_address();

	public void setIp_address(String ip_address);

	public int getPort();

	public void setPort(int port);

	public String getLogin();

	public void setLogin(String login);

	public String getPassword();

	public void setPassword(String password);

	public ConnectionMpmCaiInterface getConnectionCai();

	public void setConnectionCai(ConnectionMpmCaiInterface connection);
	
	public boolean isSessionAvailable() ;

	public void setSessionAvailable(boolean connectionAvailable);
}