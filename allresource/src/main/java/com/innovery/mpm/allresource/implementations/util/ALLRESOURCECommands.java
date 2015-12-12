package com.innovery.mpm.allresource.implementations.util;

public class ALLRESOURCECommands{

	public final static String AIR_COMMAND_GET = "GET:AIRSUB";
	
	public final static String SSH_COMMAND_GET = "GET:SSHSUB:TRANSID,999999";
	
	public final static String TRANSID = ":TRANSID,";
	public final static String MSISDN = ":MSISDN,";
	
	public final static String START = "RESP:";
	public final static String END = ";";
	
	public final static String PROMOTIONPLANS = ":RETURNDATA,PROMOTIONPLANS";
	public final static String PAM = ":RETURNDATA,ACCOUNTDETAILS:REQUESTPAMINFORMATIONFLAG,1";
	public final static String BALANCEANDDATE = ":RETURNDATA,BALANCEANDDATE";
	public final static String ACCUMULATORS = ":RETURNDATA,ACCUMULATORS";
	public final static String ACCOUNTDETAILS = ":RETURNDATA,ACCOUNTDETAILS";
	public final static String SHAREACCOUNT = ":RETURNDATA,SHAREACCOUNT";
}
