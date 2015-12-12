/*
 * Created on Jun 18, 2005
 */
package com.innovery.mpm.connection.implementations.standard;

import com.innovery.mpm.connection.interfaces.standard.ConnectionResponseInterface;

/**
 * @author Jelte
 */
public class ConnectionResponse implements ConnectionResponseInterface{
    public static final int TYPE_RESP = 0;
    public static final int TYPE_ENTER_COMMAND = 1;
    public static final int TYPE_ERROR = 2;
    public static final int TYPE_CONNECTED_START_HANDSHAKE = 3;
    public static final int TYPE_HANDSHAKE_COMPLETE = 4;
    public static final int TYPE_DISCONNECTED = 5;
    public static final int TYPE_ECHO = 6;
    public static final int TYPE_TIME_OUT = 7;
    
    private String _message;
    private int _type;

    public ConnectionResponse(){
    }
    
    public ConnectionResponse(String message){
      _message = message;
    }
    
    public ConnectionResponse(String message, int type){
        _message = message;
        _type = type;
    }
    
    public void setType(int type){
        _type = type;
    }
    
    public int getType(){
        return _type;
    }

    public void setMessage(String message){
      _message = message;
    }

    public String getMessage(){
      return _message;
    }
}
