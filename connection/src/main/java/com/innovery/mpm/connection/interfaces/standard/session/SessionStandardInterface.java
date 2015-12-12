package com.innovery.mpm.connection.interfaces.standard.session;

import com.innovery.mpm.connection.interfaces.standard.ConnectionMpmStandardInterface;

public interface SessionStandardInterface {

	public void clear();
	
	public String getIp_address();

	public void setIp_address(String ip_address);

	public int getPort();

	public void setPort(int port);

	public String getLogin();

	public void setLogin(String login);

	public String getPassword();

	public void setPassword(String password);

	public ConnectionMpmStandardInterface getConnection();

	public void setConnection(ConnectionMpmStandardInterface connection);

	public String getCurrent_msisdn();

	public void setCurrent_msisdn(String current_msisdn);

	public int getUser_level();

	public void setUser_level(int user_level);
	
	public String getCurrent_market();

	public void setCurrent_market(String current_market);
	
	public String getCurrent_ctype();
	
	public void setCurrent_ctype(String current_ctype);
}
