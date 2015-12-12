package com.innovery.mpm.connection.implementations.util;

import com.innovery.mpm.connection.interfaces.util.CompleteDateInterface;

public class CompleteDate implements CompleteDateInterface {

	private boolean first;
	private boolean second;
	
	public CompleteDate(){
		first = false;
		second = false;
	}
	
	public String complete(String inputDate){
		
		if(inputDate.length()==4 && first==false){
			first = true;
			return inputDate.concat("-");
		}
		
		else if(inputDate.length()==7 && second==false){
			second = true;
			return inputDate.concat("-");
		}

		else if((inputDate.length()>0 && inputDate.length()<4) && first==true){
			first=false;
			return inputDate;
		}
		
		else if((inputDate.length()>5 && inputDate.length()<7) && second==true){
			second=false;
			return inputDate;
		}
		
		else if(inputDate.length()==5 && first==true && !inputDate.substring(4,5).equals("-")){
			String tmp = inputDate.substring(4,5);
			return inputDate.substring(0,4).concat("-").concat(tmp);
		}
		
		else if(inputDate.length()==8 && second==true && !inputDate.substring(7,8).equals("-")){
			String tmp = inputDate.substring(7,8);
			return inputDate.substring(0,7).concat("-").concat(tmp);
		}
		
		else{
			return inputDate;
		}
	}
}
