package com.innovery.mpm.connection.implementations.standard;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.standard.session.SessionStandard;
import com.innovery.mpm.connection.implementations.util.ErrorMessages;
import com.innovery.mpm.connection.implementations.util.RedirectNames;
import com.innovery.mpm.connection.interfaces.standard.ConnectionManagmentStandardInterface;
import com.innovery.mpm.connection.interfaces.standard.ConnectionMpmStandardInterface;
import com.innovery.mpm.connection.interfaces.standard.bean.Bsom_xInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class ConnectionManagmentStandard implements ConnectionManagmentStandardInterface{

	public static final Logger _LOG = Logger.getLogger("connection");
	private static ResourceBundle rb_errorCode;
	
	private ErrorMessagesInterface message;
	private RedirectNamesInterface redirectTo;
	private SessionStandardInterface sessionStandard;
	
	public ConnectionManagmentStandard(){
		this.sessionStandard = new SessionStandard();
		this.redirectTo = new RedirectNames();
		this.message = new ErrorMessages();
		rb_errorCode = ResourceBundle.getBundle("errorCode");
	}
	
	public String createConnectionStandard(Bsom_xInterface bsom_bean){
		String redirect;
		
		_LOG.info("CONNECTING...");
		_LOG.info("IP ADDRESS: " + bsom_bean.getIp());
		_LOG.info("PORT NUMBER: "+ bsom_bean.getPort());
		_LOG.info("LOGIN: " + bsom_bean.getUser());
		
		ConnectionMpmStandardInterface connection = new ConnectionMpmStandard(this);
		connection.connectStandard(bsom_bean.getIp(), bsom_bean.getPort());
		
		if (connection.isConnectedStandard()) {
			_LOG.info("MPM CONNECTION SUCCESFULLY");
			sessionStandard.setConnection(connection);
			sessionStandard.setIp_address(bsom_bean.getIp());
			sessionStandard.setPort(bsom_bean.getPort());
			sessionStandard.setCurrent_msisdn("");
			sessionStandard.setCurrent_market("");
			sessionStandard.setCurrent_ctype("");
				
			String response_mpm = connection.send("LOGIN:" + bsom_bean.getUser() + ":"+ bsom_bean.getPassword() + ";");

			if (response_mpm.contains("RESP:0")) {
				sessionStandard.setLogin(bsom_bean.getUser());
				sessionStandard.setPassword(bsom_bean.getPassword());
				
				_LOG.info("LOGIN SUCCESFULLY");
				
				redirect = redirectTo.get_COMMAND_SELECTION_PAGE();
			} else {
				_LOG.warn("LOGIN FAILED");
				redirect = redirectTo.get_LOGIN_PAGE();
			}
		} 
		else {
			_LOG.warn("CONNECTION FAILED. REDIRECTIIN TO \"INDEX\" PAGE");
			redirect = redirectTo.get_INDEX_PAGE();
		}	
		return redirect;
	}
		
	public void disconnectStandard(){
		
		ConnectionMpmStandardInterface connection = sessionStandard.getConnection();
		
		if(connection!=null && connection.isConnectedStandard()){
			_LOG.info("LOGOUT");
			connection.send("LOGOUT;");
			try {
				connection.disconnectStandard();
				_LOG.info("DISCONNECTED");
			} catch (Exception e) {
				_LOG.error("EXCEPTION IN DISCONNECTION: "+ e.toString());
			} finally{
				sessionStandard.clear();
				_LOG.info("--------------------- SESSION DELETED ---------------------");	
			}
		}
		else{
			_LOG.info("--------------------- SESSION DELETED ---------------------");
		}
	}

	public String loginStandard(Bsom_xInterface bsom_bean){
		_LOG.info("EXECUTING LOGIN");
		String redirect;
		
		_LOG.info("USER ID: " + bsom_bean.getUser());
		_LOG.info("GETTING CONNECTION FROM SESSION");
		
		ConnectionMpmStandardInterface connection = sessionStandard.getConnection();
		if(connection!=null && connection.isConnectedStandard()){
			
			_LOG.info("CONNECTED");
			
			String response_mpm = connection.send("LOGIN:"+bsom_bean.getUser()+":"+bsom_bean.getPassword()+";");
			if(response_mpm.contains("RESP:0")){
				
				_LOG.info("LOGIN SUCCESFULLY");
				
				sessionStandard.setLogin(bsom_bean.getUser());
				sessionStandard.setPassword(bsom_bean.getPassword());
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
	
	public String reconnectionStandard(String status){
		
		_LOG.info("RECONNETION");
		_LOG.info("GETTING PARAMETERS FROM SESSION");
		
		String returnMessage;
		ConnectionMpmStandardInterface connection = sessionStandard.getConnection();
		
		if(sessionStandard.getIp_address()==null || sessionStandard.getPort()==-1 || sessionStandard.getLogin()==null || sessionStandard.getPassword()==null){
			returnMessage = message.get_MPM_ERROR();
		}
		else{
			
			ConnectionMpmStandardInterface connectionNew = connection;
			connectionNew.connectStandard(sessionStandard.getIp_address(), sessionStandard.getPort());
			sessionStandard.setConnection(connectionNew);
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
	
	private String executeLoginOnReconnection(ConnectionMpmStandardInterface connection){
		
		_LOG.info("TRYING LOGIN...");
		
		String returnMessage;
		String response_mpm = connection.send("LOGIN:" + sessionStandard.getLogin() + ":"+ sessionStandard.getPassword()+ ";");
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
	
	public SessionStandardInterface getSession() {
		return sessionStandard;
	}

	public ResourceBundle getRb_errorCode() {
		return rb_errorCode;
	}
	
	public ErrorMessagesInterface getMessage() {
		return message;
	}
	
	public int getUserLevel(){
		return sessionStandard.getUser_level();
	}
	
	public void setUserLevel(int level){
		sessionStandard.setUser_level(level);
	}
}