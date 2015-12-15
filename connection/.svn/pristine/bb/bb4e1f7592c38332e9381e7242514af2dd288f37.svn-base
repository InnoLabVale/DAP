package com.innovery.mpm.connection.implementations.cai;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.cai.session.SessionCai;
import com.innovery.mpm.connection.implementations.util.ErrorMessages;
import com.innovery.mpm.connection.implementations.util.RedirectNames;
import com.innovery.mpm.connection.interfaces.cai.ConnectionManagmentCaiInterface;
import com.innovery.mpm.connection.interfaces.cai.ConnectionMpmCaiInterface;
import com.innovery.mpm.connection.interfaces.cai.bean.Bsom_3300Interface;
import com.innovery.mpm.connection.interfaces.cai.session.SessionCaiInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class ConnectionManagmentCai implements ConnectionManagmentCaiInterface{

	public static final Logger _LOG = Logger.getLogger("connection");
	
	private ErrorMessagesInterface message;
	private SessionCaiInterface sessionCai;
	private RedirectNamesInterface redirectTo;
	
	public ConnectionManagmentCai(){
		this.sessionCai = new SessionCai();
		this.message = new ErrorMessages();
		this.redirectTo = new RedirectNames();
	}
	
	public String createConnectionCai(Bsom_3300Interface bsom_bean){
		String redirect;
		
		_LOG.info("CONNECTING...");
		_LOG.info("IP ADDRESS: " + bsom_bean.getIp());
		_LOG.info("PORT NUMBER: "+ bsom_bean.getPort());
		_LOG.info("LOGIN: " + bsom_bean.getUser());
		
		ConnectionMpmCaiInterface connection = new ConnectionMpmCai(this);
		connection.connectCai(bsom_bean.getIp(), bsom_bean.getPort());
		
		if (connection.isConnectedCai()) {
			sessionCai.setConnectionCai(connection);
			sessionCai.setIp_address(bsom_bean.getIp());
			sessionCai.setPort(bsom_bean.getPort());
				
			String response_mpm = connection.send("LOGIN:" + bsom_bean.getUser() + ":"+ bsom_bean.getPassword() + ";");

			if (response_mpm.contains("RESP:0")) {
				sessionCai.setLogin(bsom_bean.getUser());
				sessionCai.setPassword(bsom_bean.getPassword());
				
				_LOG.info("LOGIN SUCCESFULLY");
				
				redirect = redirectTo.get_COMMAND_SELECTION_PAGE();
			} else {
				_LOG.warn("LOGIN FAILED");
				redirect = redirectTo.get_LOGIN_PAGE();
			}
		} 
		else {
			_LOG.warn("CONNECTION FAILED.");
			redirect = redirectTo.get_INDEX_PAGE();
		}	
		return redirect;
	}
		
	public void disconnectCai(){
		
		ConnectionMpmCaiInterface connection = sessionCai.getConnectionCai();
		
		if(connection!=null && connection.isConnectedCai()){
			_LOG.info("LOGOUT");
			connection.send("LOGOUT;");
			try {
				connection.disconnectCai();
				_LOG.info("DISCONNECTED");
			} catch (Exception e) {
				_LOG.error("EXCEPTION IN DISCONNECTION: "+ e.toString());
			} finally{
				sessionCai.clear();
				_LOG.info("--------------------- SESSION DELETED ---------------------");
			}
		}
		else{
			_LOG.info("--------------------- SESSION DELETED ---------------------");
		}
	}

	public String loginCai(Bsom_3300Interface bsom_bean){
		_LOG.info("EXECUTING LOGIN");
		String redirect;
		
		_LOG.info("USER ID: " + bsom_bean.getUser());
		_LOG.info("GETTING CONNECTION FROM SESSION");
		
		ConnectionMpmCaiInterface connection = sessionCai.getConnectionCai();
		if(connection!=null && connection.isConnectedCai()){
			
			_LOG.info("CONNECTED");
			
			String response_mpm = connection.send("LOGIN:"+bsom_bean.getUser()+":"+bsom_bean.getPassword()+";");
			if(response_mpm.contains("RESP:0")){
				
				_LOG.info("LOGIN SUCCESFULLY");
				
				sessionCai.setLogin(bsom_bean.getUser());
				sessionCai.setPassword(bsom_bean.getPassword());
				redirect = redirectTo.get_COMMAND_SELECTION_PAGE();		
			}
			else{
				_LOG.warn("LOGIN FAILED");
				redirect = redirectTo.get_LOGIN_PAGE();
			}
		}
		else {
			_LOG.warn("NOT CONNECTED");
			redirect = redirectTo.get_INDEX_PAGE();
		}
		return redirect;
	}
	
	public String reconnectionCai(String status){
		
		_LOG.info("RECONNETION");
		_LOG.info("GETTING PARAMETERS FROM SESSION");
		
		String returnMessage;
		ConnectionMpmCaiInterface connection = sessionCai.getConnectionCai();
		
		if(sessionCai.getIp_address()==null || sessionCai.getPort()==-1 || sessionCai.getLogin()==null || sessionCai.getPassword()==null){
			returnMessage = message.get_MPM_ERROR();
		}
		else{
			
			ConnectionMpmCaiInterface connectionNew = connection;
			connectionNew.connectCai(sessionCai.getIp_address(), sessionCai.getPort());
			sessionCai.setConnectionCai(connectionNew);
			String response_mpm = executeLoginOnReconnection(connectionNew);
			
			if(response_mpm.contains(message.get_RELOGGED())){
				returnMessage = message.get_RELOGGED();
			}
			
			else {
				
				if(status.equals("Execute")){
					_LOG.error("MPM CONNECTION WARNING");
					returnMessage = message.get_MPM_CONNECTION_WARN();
				}
				else if(status.equals("reconnect")){
					_LOG.error("MPM CONNECTION ERROR");
					returnMessage = message.get_NOT_LOGGED_ERROR();
				}
				else {
					returnMessage = null;
				}
			}
		}
		return returnMessage;
	}
	
	private String executeLoginOnReconnection(ConnectionMpmCaiInterface connection){
		
		_LOG.info("TRYING LOGIN...");
		
		String returnMessage;
		String response_mpm = connection.send("LOGIN:" + sessionCai.getLogin() + ":"+ sessionCai.getPassword()+ ";");
		if (response_mpm.contains("RESP:0;")) {
			_LOG.info("LOGIN SUCCESFULLY");
			returnMessage = message.get_RELOGGED();
		}
		else{
			_LOG.warn("LOGIN FAILED");
			returnMessage = message.get_NOT_LOGGED_ERROR();
		}
		return returnMessage;
	}
	
	public SessionCaiInterface getSession() {
		return sessionCai;
	}
}