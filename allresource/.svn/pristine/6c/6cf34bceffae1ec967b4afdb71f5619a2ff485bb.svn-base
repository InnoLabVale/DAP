package com.innovery.mpm.allresource.implementations.bean.air;

import java.util.ArrayList;
import java.util.List;

import com.innovery.mpm.allresource.interfaces.bean.air.ShareAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.UTsInterface;

public class ShareAccount implements ShareAccountInterface{
	
	private String msisdn;
	private String ucid;
	private String uc_m_value_new;
	private String uc_m_value_adj;
	private String utid;
	private String ut_m_value_new;
	private String source;
	private List<UTsInterface> UTs;
	
	public ShareAccount(){
		this.UTs = new ArrayList<UTsInterface>();
	}
		
	public ShareAccount(String msisdn){
		this.msisdn=msisdn;
		this.ucid=null;
		this.uc_m_value_new=null;
		this.uc_m_value_adj=null;
		this.utid=null;
		this.ut_m_value_new=null;
		this.UTs = new ArrayList<UTsInterface>();
	}
	
	public String getMSISDN(){
		return msisdn;
	}
	
	public String getUCID(){
		return this.ucid;
	}
	
	public String getUCMValueNew(){
		return this.uc_m_value_new;
	}
	
	public String getUCMValueAdj(){
		return this.uc_m_value_adj;
	}
	
	public String getUTID(){
		return this.utid;
	}
	
	public String getUTMValueNew(){
		return this.ut_m_value_new;
	}
	
	public void setMSISDN(String msisdn){
		this.msisdn=msisdn;
	}
	
	public void setUCID(String ucid){
		this.ucid=ucid;
	}
	
	public void setUCMValueNew(String uc_m_value_new){
		this.uc_m_value_new=uc_m_value_new;
	}
	
	public void setUCMValueAdj(String uc_m_value_adj){
		this.uc_m_value_adj=uc_m_value_adj;
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

	public List<UTsInterface> getUTs() {
		return UTs;
	}

	public void setUTs(List<UTsInterface> uTs) {
		UTs = uTs;
	}
	
	public void addUTs(UTsInterface toAdd){
		UTs.add(toAdd);
	}
}
