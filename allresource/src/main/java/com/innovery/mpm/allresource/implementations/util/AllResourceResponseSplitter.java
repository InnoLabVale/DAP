package com.innovery.mpm.allresource.implementations.util;

import com.innovery.mpm.allresource.interfaces.util.AllResourceResponseSplitterInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class AllResourceResponseSplitter implements AllResourceResponseSplitterInterface {
	
	private DAPBeanInterface components;
	
	public String split(String response, String pattern){
		response = response.trim().replace(";", "");
		String[] response_parts = response.split(":");
		String response_splitted = split_string(response_parts, pattern);
		
		if(response_splitted.equals("error_found")){
			
			String[] errorSplit = response.split(":");
			try {
				String errorDescription = components.getConnectionManagerStandard().getRb_errorCode().getString(errorSplit[2]);
				return response + "\n\n" + errorDescription;
			} catch (Exception e) {
				components.getLogger().warn("Error description in erroreCode.properties not found: " + e.getMessage());
				return response;
			}
		}
		return response_splitted;
			
	}
	
	private String split_string(String[] response_parts, String pattern){
		String found="";
		boolean error = true;
		
		if(response_parts[0].equals("RESP") && (response_parts[2].equals("0") || response_parts[1].equals("TRANSID,999999"))){
			error = false;
			for(int i=2; i<response_parts.length; i++){
				if(response_parts[i].contains(pattern)){
					found = ":"+response_parts[i];
				}
			}
		}
		if(error==false){
			return "RESP:0"+found+";";
		}
		return "error_found";
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
