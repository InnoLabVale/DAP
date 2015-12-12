package com.innovery.mpm.connection.interfaces.cai;

public interface ConnectionMpmCaiInterface {

	public void connectCai(String ip_address, int port);
	
	public void disconnectCai() throws Exception;
	
	public boolean isConnectedCai();
	
	public String send(String message);
}
