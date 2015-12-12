package com.innovery.mpm.connection.implementations.cai;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.implementations.standard.ConnectionResponse;
import com.innovery.mpm.connection.implementations.util.ErrorMessages;
import com.innovery.mpm.connection.interfaces.cai.ConnectionMpmCaiInterface;
import com.innovery.mpm.connection.interfaces.cai.session.SessionCaiInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class ConnectionMpmCai implements ConnectionMpmCaiInterface{
	private final String LOCAL_NOT_LOGGED_ERROR = "RESP:3007;";
	private final String LOCAL_MSISDN_NOT_FOUND_ERROR_CH1 = ":17051;";
	private final String LOCAL_MSISDN_NOT_FOUND_ERROR_CH2 = ":17001;";
	
	private Socket _clientSocketCai;
	private BufferedReader _inputStream;
	private PrintWriter _outputStream;
	private static final boolean AUTOFLUSH = true;
	private final Logger log = ConnectionManagmentCai._LOG;
	private ErrorMessagesInterface message;
	
	private SessionCaiInterface session;
	
	public ConnectionMpmCai(ConnectionManagmentCai connection_managment){
		this.session = connection_managment.getSession();
		this.message = new ErrorMessages();
	}

	public void connectCai(String ip_address, int port) {
		@SuppressWarnings("unused")
		String message = null;
		try {
			_clientSocketCai = new Socket(ip_address, port);
			log.info("CREATING NEW CONNECTION. SOCKET ID: " + _clientSocketCai.toString());
			new ConnectionResponse("Connected, handshaking", ConnectionResponse.TYPE_CONNECTED_START_HANDSHAKE);
			_outputStream = new PrintWriter(_clientSocketCai.getOutputStream(), AUTOFLUSH);
			_outputStream.flush();
			_inputStream = new BufferedReader(new InputStreamReader(_clientSocketCai.getInputStream()));

			StringBuffer handshake = new StringBuffer();
			String line = "";
			char c;
			while (!handshake.toString().toLowerCase().endsWith("enter command:")) {
				c = (char) _inputStream.read();
				handshake.append(c);
			}
			line = handshake.toString();
			new ConnectionResponse(line, ConnectionResponse.TYPE_ECHO);
			new ConnectionResponse("CONNECTED, HANDSHAKE COMPLETE.",	ConnectionResponse.TYPE_HANDSHAKE_COMPLETE);

		} catch (Exception e) {
			String problem = e.getMessage();
			if (problem == null) {
				problem = "UNKNOWN ERROR IN COMMUNICATION TO THE SERVER.";
			}
			new ConnectionResponse(problem, ConnectionResponse.TYPE_ERROR);
			log.error(problem);
		}
	}

	public void disconnectCai() throws Exception {		
		log.info("DISCONNECTIONG SOCKET.");
		if(_inputStream!=null){
			_inputStream.close();
		}
		if(_outputStream!=null){
			_outputStream.close();
		}
		if(_clientSocketCai!=null){
			_clientSocketCai.close();
		}
		log.info("DISCONNECTED.");
		new ConnectionResponse("DISCONNECTED.",	ConnectionResponse.TYPE_DISCONNECTED);

	}

	public boolean isConnectedCai() {
		if (_clientSocketCai == null) {
			log.info("NOT CONNECTED");
			return false;
		}
		log.info("CONNECTED");
		return (_clientSocketCai.isConnected() && !_clientSocketCai.isClosed() && _clientSocketCai.isBound());
	}

	private void readCompleteBuffer() throws IOException {
		StringBuffer line;
		int token = 0;
		char c;
		line = new StringBuffer();
		while (!line.toString().toLowerCase().equals("enter command:")) {
			token = _inputStream.read();
			c = (char) token;
			if (token == -1) {
				_clientSocketCai = null;
				new ConnectionResponse("Error: TIME OUT to the Server\n",
						ConnectionResponse.TYPE_TIME_OUT);
				break;
			}
			line.append(c);
		}
	}

	public String send(String message) {
		String lineToSend = message;
		if(!message.contains("LOGIN:")){
			log.info("COMMAND SENT: "+lineToSend);
		}
		String lineReceived = new String();
		try {
			_outputStream.println(lineToSend);
			_outputStream.flush();
			lineReceived = _inputStream.readLine();
			readCompleteBuffer();
		} catch (SocketTimeoutException e) {
			_clientSocketCai = null;
		} catch (Exception e) {

		}
		log.info("MPM RESPONSE: " + lineReceived);
		return getStatus(lineReceived);
	}
	
	private String getStatus(String response_mpm){

		if(session.getConnectionCai()!=null){
			log.info("CONNECTED.");
			log.info("MPM RESPONSE ON CONNECTION STATUS: "+response_mpm);
			if(response_mpm.contains(LOCAL_NOT_LOGGED_ERROR) || response_mpm.trim().equals("") || response_mpm.trim().equals("Enter command:")){
				log.info("NOT LOGGED.");
				response_mpm = message.get_NOT_LOGGED_WARN();
			}
			else if(response_mpm.endsWith(LOCAL_MSISDN_NOT_FOUND_ERROR_CH1) || response_mpm.endsWith(LOCAL_MSISDN_NOT_FOUND_ERROR_CH2)){
				log.info("LOGGED AND MSISDN NOT FOUND.");
				response_mpm = message.get_USER_NOT_FOUND();
			}
		}
		else{
			log.info("NOT CONNECTED.");
			response_mpm = message.get_MPM_CONNECTION_WARN();
		}
		return response_mpm;
	}
}