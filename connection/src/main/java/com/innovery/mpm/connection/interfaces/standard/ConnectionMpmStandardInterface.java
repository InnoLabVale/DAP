package com.innovery.mpm.connection.interfaces.standard;

public interface ConnectionMpmStandardInterface {

	public void connectStandard(String ip_address, int port);
	
	public void disconnectStandard() throws Exception;
	
	public boolean isConnectedStandard();
	
	public String send(String message);
}
