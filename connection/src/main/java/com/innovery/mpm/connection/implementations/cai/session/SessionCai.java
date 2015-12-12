package com.innovery.mpm.connection.implementations.cai.session;

import com.innovery.mpm.connection.interfaces.cai.ConnectionMpmCaiInterface;
import com.innovery.mpm.connection.interfaces.cai.session.SessionCaiInterface;

public class SessionCai implements SessionCaiInterface{

	private String ip_address;
	private int port;
	private String login;
	private String password;
	private ConnectionMpmCaiInterface connection;
	
	private boolean sessionAvailable;
	
	public void clear(){
		this.ip_address = null;
		this.port = -1;
		this.login = null;
		this.password = null;
		this.connection = null;
		this.sessionAvailable = false;
	}
	
	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ConnectionMpmCaiInterface getConnectionCai() {
		return connection;
	}

	public void setConnectionCai(ConnectionMpmCaiInterface connection) {
		this.connection = connection;
	}

	public boolean isSessionAvailable() {
		return sessionAvailable;
	}

	public void setSessionAvailable(boolean connectionAvailable) {
		this.sessionAvailable = connectionAvailable;
	}
}
