package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.AccountGroupIdInterface;

public class AccountGroupId implements AccountGroupIdInterface{

	private String agi_id;
	
	public String getAgi(){
		return this.agi_id;
	}
	
	public void setAgi(String agi_id){
		this.agi_id=agi_id;
	}
}
