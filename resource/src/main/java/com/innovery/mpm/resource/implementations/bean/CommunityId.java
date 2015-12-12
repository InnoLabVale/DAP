package com.innovery.mpm.resource.implementations.bean;

import com.innovery.mpm.resource.interfaces.bean.CommunityIdInterface;

public class CommunityId implements CommunityIdInterface{
	
	private String communityNew_1;
	private String communityOld_1;
	
	private String communityNew_2;
	private String communityOld_2;
	
	private String communityNew_3;
	private String communityOld_3;
	
	public String getCommNew_1(){
		return communityNew_1;
	}
	
	public String getCommOld_1(){
		return communityOld_1;
	}
	
	public String getCommNew_2(){
		return communityNew_2;
	}
	
	public String getCommOld_2(){
		return communityOld_2;
	}
	
	public String getCommNew_3(){
		return communityNew_3;
	}
	
	public String getCommOld_3(){
		return communityOld_3;
	}
	
	public void setCommNew_1(String communityNew_1){
		this.communityNew_1=communityNew_1;
	}
	
	public void setCommOld_1(String communityOld_1){
		this.communityOld_1=communityOld_1;
	}
	
	public void setCommNew_2(String communityNew_2){
		this.communityNew_2=communityNew_2;
	}
	
	public void setCommOld_2(String communityOld_2){
		this.communityOld_2=communityOld_2;
	}
	
	public void setCommNew_3(String communityNew_3){
		this.communityNew_3=communityNew_3;
	}
	
	public void setCommOld_3(String communityOld_3){
		this.communityOld_3=communityOld_3;
	}
}
