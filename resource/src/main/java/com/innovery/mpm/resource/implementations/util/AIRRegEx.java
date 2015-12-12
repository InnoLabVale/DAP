package com.innovery.mpm.resource.implementations.util;

public class AIRRegEx {
	
	public final static String msisdn_pattern = "^[0-9]{1,28}$";

	public final static String zero_9_piu = "^[0-9]+$";
	public final static String zero_999 ="^[0-9]{1,3}$";
	public final static String zero_999_meno0 ="^(\\-)?[1-9]([0-9]{0,2})$";
	public final static String zero_999999999999 = "^[0-9]{0,12}$";
	public final static String zero_999999999999_meno = "^(\\-)?[0-9]{0,12}$";
	public final static String zero_9999 ="^[0-9]{1,4}$";
	
	public final static String faf_number_patt = "^[0-9]{1,81}$";
	public final static String main_account_patt = "(\\-)?[0-9]{1,12}$";
	public final static String promotion_id_patt = "^[0-9A-Za-z]{1,4}$";
	public final static String so_patt = "^(\\d\\d|\\d)+([,]+(\\d\\d|\\d))*$";
	
	public final static String date_patt = "^(19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$";
}
