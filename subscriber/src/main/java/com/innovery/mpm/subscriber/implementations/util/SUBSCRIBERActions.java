package com.innovery.mpm.subscriber.implementations.util;

public class SUBSCRIBERActions {

	public static final String SUBSCRIBER_ACTION_CREATE = "create";
	public static final String SUBSCRIBER_ACTION_DELETE = "delete";
	public static final String SUBSCRIBER_ACTION_GET = "assurance";
	public static final String SUBSCRIBER_ACTION_CHG = "change";
	public static final String SUBSCRIBER_ACTION_SET = "set";
	
	public static final String SUBSCRIBER_ACTION_GET_AMOUNT = "amount";
	public static final String SUBSCRIBER_ACTION_GET_PROFILE  = "profile";
	public static final String SUBSCRIBER_ACTION_GET_DATASERVICES = "data services";
	public static final String SUBSCRIBER_ACTION_GET_TARIFF_PLAN = "tariff plan";
	public static final String SUBSCRIBER_ACTION_GET_BILL_CYCLE = "bill cycle";
	
	public static final String SUBSCRIBER_ACTION_CHG_MSISDN = "Msisdn";
	public static final String SUBSCRIBER_ACTION_CHG_TARIFF_PLAN = "Tariff plan";
	public static final String SUBSCRIBER_ACTION_CHG_BILL_CYCLE = "Bill cycle";
	public static final String SUBSCRIBER_ACTION_CHG_LINE_STATE = "Line state";
	public static final String SUBSCRIBER_ACTION_CHG_DISCOUNT = "Discount";
	public static final String SUBSCRIBER_ACTION_CHG_DATASERVICES = "Data services";
	public static final String SUBSCRIBER_ACTION_CHG_PREFERENTIAL_LIST = "Preferential list";
	public static final String SUBSCRIBER_ACTION_CHG_CC = "Cost control";
	public static final String SUBSCRIBER_ACTION_CC_UNBLOCK = "Unblock CC";
	public static final String SUBSCRIBER_ACTION_CC_UNBLOCK_CRM = "Unblock CC CRM";
	public static final String SUBSCRIBER_ACTION_CC_UNBLOCK_NIS = "Unblock CC NIS";
	
	
	public static final String SUBSCRIBER_ACTION_SET_DATASERVICE_COMBO = SUBSCRIBER_ACTION_SET;
	public static final String SUBSCRIBER_ACTION_ADD_DATASERVICE_COMBO = "add";
	public static final String SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO = "del";
	
	public static final String SUBSCRIBER_ACTION_ADD_BILL_CYCLE = SUBSCRIBER_ACTION_ADD_DATASERVICE_COMBO+" bill cycle";
	public static final String SUBSCRIBER_ACTION_SET_BILL_CYCLE = SUBSCRIBER_ACTION_SET+" bill cycle";
	public static final String SUBSCRIBER_ACTION_DEL_BILL_CYCLE = SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO+" Bill cycle";
	
	public static final String SUBSCRIBER_ACTION_SET_DISCOUNT = SUBSCRIBER_ACTION_SET+" discount";
	public static final String SUBSCRIBER_ACTION_DEL_DISCOUNT = SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO+" discount";
	
	public static final String SUBSCRIBER_ACTION_SET_DATA_SERVICE = SUBSCRIBER_ACTION_SET+" Data service";
	public static final String SUBSCRIBER_ACTION_ADD_DATA_SERVICE = SUBSCRIBER_ACTION_ADD_DATASERVICE_COMBO+" Data service";
	public static final String SUBSCRIBER_ACTION_DEL_DATA_SERVICE = SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO+" Data service";
	
	public static final String SUBSCRIBER_ACTION_EXECUTE = "execute";
	
	
	public static final String DEFAULT = "select...";
	
	public static final String[] SUBSCRIBER_OPTION_COMBO_DEFAULT = {DEFAULT };
	
	
	
	public static final String SUBSCRIBER_ACTION_ADD_BILLCYCLE_COMBO = "activation";
	public static final String SUBSCRIBER_ACTION_SET_BILLCYCLE_COMBO = "change";
	public static final String SUBSCRIBER_ACTION_DEL_BILLCYCLE_COMBO = "deactivation";
	
	public static final String SUBSCRIBER_ACTION_SMS = "sms";
	public static final String SUBSCRIBER_ACTION_SPLASH = "splash";
	
	public static final String SUBSCRIBER_ACTION_SET_DISCOUNT_COMBO = SUBSCRIBER_ACTION_ADD_BILLCYCLE_COMBO;
	public static final String SUBSCRIBER_ACTION_DEL_DISCOUNT_COMBO = SUBSCRIBER_ACTION_DEL_BILLCYCLE_COMBO;
	
	public static final String IA = "IA";
	public static final String IC = "IC";
	public static final String IR = "IR";
	
	public static final String SUBSCRIBER_ACTION_LINESTATE_ACTIVE = "active";
	public static final String SUBSCRIBER_ACTION_LINESTATE_SUSPEND = "suspend";
	public static final String SUBSCRIBER_ACTION_SAVEBALANCE_ON = "on";
	public static final String SUBSCRIBER_ACTION_SAVEBALANCE_OFF = "off";
	public static final String SUBSCRIBER_ACTION_UNBLOCK = "1";
	public static final String SUBSCRIBER_ACTION_UNBLOCK_LABEL = "unblock";
	
	public static final String SUBSCRIBER_ACTION_GET_OPTION_LIST[] = {SUBSCRIBER_ACTION_GET_AMOUNT,
																		SUBSCRIBER_ACTION_GET_PROFILE,
																		SUBSCRIBER_ACTION_GET_DATASERVICES,
																		SUBSCRIBER_ACTION_GET_TARIFF_PLAN,
																		SUBSCRIBER_ACTION_GET_BILL_CYCLE};
	
	public static final String[] SUBSCRIBER_ACTION_CHG_OPTION_LIST = {SUBSCRIBER_ACTION_CHG_MSISDN,
																		SUBSCRIBER_ACTION_CHG_TARIFF_PLAN,
																		SUBSCRIBER_ACTION_CHG_BILL_CYCLE,
																		SUBSCRIBER_ACTION_CHG_LINE_STATE,
																		SUBSCRIBER_ACTION_CHG_DISCOUNT,
																		SUBSCRIBER_ACTION_CHG_DATASERVICES,
																		SUBSCRIBER_ACTION_CHG_PREFERENTIAL_LIST,
																		SUBSCRIBER_ACTION_CHG_CC,
																		SUBSCRIBER_ACTION_CC_UNBLOCK,
																		SUBSCRIBER_ACTION_CC_UNBLOCK_CRM,
																		SUBSCRIBER_ACTION_CC_UNBLOCK_NIS,
																		SUBSCRIBER_ACTION_ADD_BILL_CYCLE,
																		SUBSCRIBER_ACTION_SET_BILL_CYCLE,
																		SUBSCRIBER_ACTION_DEL_BILL_CYCLE,
																		SUBSCRIBER_ACTION_SET_DISCOUNT,
																		SUBSCRIBER_ACTION_DEL_DISCOUNT,
																		SUBSCRIBER_ACTION_SET_DATA_SERVICE,
																		SUBSCRIBER_ACTION_ADD_DATA_SERVICE,
																		SUBSCRIBER_ACTION_DEL_DATA_SERVICE};

	
	
	
	
	
	
	public static final String[] SUBSCRIBER_CONSUMER_PREPAID_CAHNGE_OPTIONS_LIST = {DEFAULT, 
																					SUBSCRIBER_ACTION_CHG_MSISDN,
																					SUBSCRIBER_ACTION_CHG_TARIFF_PLAN,
																					SUBSCRIBER_ACTION_CHG_BILL_CYCLE,
																					SUBSCRIBER_ACTION_CHG_DATASERVICES,
																					SUBSCRIBER_ACTION_CHG_CC, 
																					SUBSCRIBER_ACTION_CC_UNBLOCK,
																					SUBSCRIBER_ACTION_CHG_DISCOUNT, 
																					SUBSCRIBER_ACTION_CHG_LINE_STATE};
	
	public static final String[] SUBSCRIBER_CORPORATE_PREPAID_CAHNGE_OPTIONS_LIST = {DEFAULT, 
																					SUBSCRIBER_ACTION_CHG_MSISDN,
																					SUBSCRIBER_ACTION_CHG_TARIFF_PLAN,
																					SUBSCRIBER_ACTION_CHG_DATASERVICES,
																					SUBSCRIBER_ACTION_CHG_CC, 
																					SUBSCRIBER_ACTION_CC_UNBLOCK,
																					SUBSCRIBER_ACTION_CHG_DISCOUNT, 
																					SUBSCRIBER_ACTION_CHG_LINE_STATE};
	
	public static final String[] SUBSCRIBER_POSTPAID_CHANGE_OPTIONS_LIST = {DEFAULT, 
																			SUBSCRIBER_ACTION_CHG_MSISDN,
																			SUBSCRIBER_ACTION_CHG_TARIFF_PLAN,
																			SUBSCRIBER_ACTION_CHG_BILL_CYCLE,
																			SUBSCRIBER_ACTION_CHG_DATASERVICES,
																			SUBSCRIBER_ACTION_CHG_CC,
																			SUBSCRIBER_ACTION_CC_UNBLOCK_CRM,
																			SUBSCRIBER_ACTION_CC_UNBLOCK_NIS,
																			SUBSCRIBER_ACTION_CHG_PREFERENTIAL_LIST};
	
	public static final String[] SUBSCRIBER_DATASERVICES_ACTION_LIST = {DEFAULT, 
																		SUBSCRIBER_ACTION_SET_DATASERVICE_COMBO, 
																		SUBSCRIBER_ACTION_ADD_DATASERVICE_COMBO, 
																		SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO };
	
	
	
	public static final String[] SUBSCRIBER_BILLCYCLE_ACTION_LIST = {DEFAULT,
																	SUBSCRIBER_ACTION_ADD_BILLCYCLE_COMBO,
																	SUBSCRIBER_ACTION_SET_BILLCYCLE_COMBO, 
																	SUBSCRIBER_ACTION_DEL_BILLCYCLE_COMBO };
	
	
	
	public static final String[] SUBSCRIBER_CHANNEL_OPTION_LIST = {DEFAULT,SUBSCRIBER_ACTION_SMS,SUBSCRIBER_ACTION_SPLASH};
	
	
	
	
	
	public static final String[] SUBSCRIBER_DISCOUNT_ACTION_LIST = {DEFAULT, 
																	SUBSCRIBER_ACTION_SET_DISCOUNT_COMBO, 
																	SUBSCRIBER_ACTION_DEL_DISCOUNT_COMBO };

	
	
	public static final String[] SUBSCRIBER_REFILLTYPE_OPTION_LIST = {DEFAULT,
																	   IA,
																	   IC,
																	   IR};
	
	public static final String SUBSCRIBER_ACTION_HOME = "home";
	public static final String SUBSCRIBER_ACTION_RECONNECT = "reconnect";
	
}