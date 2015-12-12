package com.innovery.mpm.allresource.implementations.bean.air;

import com.innovery.mpm.allresource.interfaces.bean.air.UTsInterface;

public class UTs implements UTsInterface{
	

	private String ucid;
	private String utid;
	private String ut_m_value_new;
	private String source;
	
	public UTs(){
	}
		
	public String getUCID(){
		return this.ucid;
	}
	
	public String getUTID(){
		return this.utid;
	}
	
	public String getUTMValueNew(){
		return this.ut_m_value_new;
	}

	
	public void setUCID(String ucid){
		this.ucid=ucid;
	}
	
	public void setUTID(String utid){
		this.utid=utid;
	}
	
	public void setUTMValueNew(String ut_m_value_new){
		this.ut_m_value_new=ut_m_value_new;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
