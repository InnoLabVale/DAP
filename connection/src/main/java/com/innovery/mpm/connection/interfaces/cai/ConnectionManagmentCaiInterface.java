package com.innovery.mpm.connection.interfaces.cai;

import com.innovery.mpm.connection.interfaces.cai.bean.Bsom_3300Interface;
import com.innovery.mpm.connection.interfaces.cai.session.SessionCaiInterface;

public interface ConnectionManagmentCaiInterface {

	public String createConnectionCai(Bsom_3300Interface bsom_bean);

	public void disconnectCai();
	
	public String loginCai(Bsom_3300Interface bsom_bean);
	
	public String reconnectionCai(String status);
	
	public SessionCaiInterface getSession();
}
