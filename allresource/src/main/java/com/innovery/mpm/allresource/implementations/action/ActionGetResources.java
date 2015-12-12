package com.innovery.mpm.allresource.implementations.action;

import java.util.ArrayList;
import java.util.List;

import com.innovery.mpm.allresource.implementations.action.air.ActionAccountDetails;
import com.innovery.mpm.allresource.implementations.action.air.ActionAccumulator;
import com.innovery.mpm.allresource.implementations.action.air.ActionBalanceAndDate;
import com.innovery.mpm.allresource.implementations.action.air.ActionFaf;
import com.innovery.mpm.allresource.implementations.action.air.ActionPam;
import com.innovery.mpm.allresource.implementations.action.air.ActionPromotionPlan;
import com.innovery.mpm.allresource.implementations.action.air.ActionShareAccount;
import com.innovery.mpm.allresource.implementations.action.ssh.ActionServiceCode;
import com.innovery.mpm.allresource.implementations.bean.air.AccountDetails;
import com.innovery.mpm.allresource.implementations.bean.air.Accumulator;
import com.innovery.mpm.allresource.implementations.bean.air.BalanceAndDate;
import com.innovery.mpm.allresource.implementations.bean.air.DedicatedAccount;
import com.innovery.mpm.allresource.implementations.bean.air.Faf;
import com.innovery.mpm.allresource.implementations.bean.air.OfferId;
import com.innovery.mpm.allresource.implementations.bean.air.Pam;
import com.innovery.mpm.allresource.implementations.bean.air.PromotionPlan;
import com.innovery.mpm.allresource.implementations.bean.air.ShareAccount;
import com.innovery.mpm.allresource.implementations.bean.air.UTs;
import com.innovery.mpm.allresource.implementations.bean.ssh.ServiceCode;
import com.innovery.mpm.allresource.implementations.util.ALLRESOURCECommands;
import com.innovery.mpm.allresource.interfaces.action.ActionGetResourcesInterface;
import com.innovery.mpm.allresource.interfaces.action.air.SpecificActionGetResources;
import com.innovery.mpm.allresource.interfaces.action.ssh.ActionServiceCodeInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.AccountDetailsInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.AccumulatorInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.BalanceAndDateInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.DedicatedAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.FafInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.OfferIdInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.PamInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.PromotionPlanInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.ShareAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.UTsInterface;
import com.innovery.mpm.allresource.interfaces.bean.ssh.ServiceCodeInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceResponseSplitterInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ActionGetResources implements ActionGetResourcesInterface {
	
	private DAPBeanInterface components;
	
	private AllResourceResponseSplitterInterface splitter;
	
	private String response_mpm;
	
	public Object getAccountDetails(String msisdn, String market, String ctype){
		SpecificActionGetResources action_account_details = new ActionAccountDetails();
		action_account_details.setComponents(components);
		response_mpm = action_account_details.get(msisdn, market, ctype);
		return createAccountDetailsBean(response_mpm);
	}
	
	public Object getAccumulators(String msisdn, String market, String ctype){
		SpecificActionGetResources action_accumulator = new ActionAccumulator();
		action_accumulator.setComponents(components);
		response_mpm = action_accumulator.get(msisdn, market, ctype);
		return createAccumulatorsList(response_mpm);
	}
	
	public Object[] getBalanceAndDate(String msisdn, String market, String ctype){
		SpecificActionGetResources action_balance_and_date = new ActionBalanceAndDate();
		action_balance_and_date.setComponents(components);
		response_mpm = action_balance_and_date.get(msisdn, market, ctype);
		BalanceAndDateInterface local_balance_and_date = createMainBalanceBean(response_mpm);
		Object local_offerid_list = createOfferIdList(response_mpm);
		Object[] balance_and_date_offerlist_response = new Object[2];
		balance_and_date_offerlist_response[0] = local_balance_and_date;
		balance_and_date_offerlist_response[1] = local_offerid_list;
		return balance_and_date_offerlist_response;
	}
	
	public Object getFaf(String msisdn, String market, String ctype){
		SpecificActionGetResources action_faf = new ActionFaf();
		action_faf.setComponents(components);
		response_mpm = action_faf.get(msisdn, market, ctype);
		return createFafsList(response_mpm);
	}
	
	public Object getPam(String msisdn, String market, String ctype){
		SpecificActionGetResources action_pam = new ActionPam();
		action_pam.setComponents(components);
		response_mpm = action_pam.get(msisdn, market, ctype);
		return createPAM(response_mpm);
	}
	
	public Object getPromotionPlan(String msisdn, String market, String ctype){
		SpecificActionGetResources action_promotion_plan = new ActionPromotionPlan();
		action_promotion_plan.setComponents(components);
		response_mpm = action_promotion_plan.get(msisdn, market, ctype);
		return createPromotionPlanList(response_mpm);
	}
	
	public Object getShareAccount(String msisdn, String market, String ctype){
		SpecificActionGetResources action_share_account = new ActionShareAccount();
		action_share_account.setComponents(components);
		response_mpm = action_share_account.get(msisdn, market, ctype);
		return createShareAccountList(response_mpm);
	}
	
	public Object getServiceCode(String msisdn){
		ActionServiceCodeInterface action_service_code = new ActionServiceCode();
		action_service_code.setComponents(components);
		response_mpm = action_service_code.get(msisdn);
		return createServiceCodeList(response_mpm);
	}
	
	private Object createAccountDetailsBean(String response_mpm){
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		AccountDetailsInterface account_details = new AccountDetails();
		String[] parametersList = response_mpm.trim().replace(";", "").split(":");
		for(int i=0; i<parametersList.length; i++){
			if(parametersList[i].startsWith("ACCOUNTGROUPID")){
				account_details.setAccount_group_id(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("LANGUAGE")){
				account_details.setLanguage(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("SERVICECLASS")){
				account_details.setService_class(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("COMMUNITYIDLIST")){
				
				
				StringBuffer community_list_string = new StringBuffer();
				String community_list[] = parametersList[i].split(",");
				for(int j=1; j<community_list.length; j++){
					community_list_string.append(community_list[j]).append(" ");
				}
				
				for(int k=community_list.length; k<=3; k++){
					community_list_string.append(" -").append(" ");
				}
				
				account_details.setCommunity_id(community_list_string.toString());
			}
			else if(parametersList[i].startsWith("SFEEEXPDATE")){
				account_details.setSim_exp_date(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("SUPEXPDATE")){
				account_details.setSup_exp_date(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("SERVICEOFFERINGS")){
				account_details.setService_offerings(createServiceOfferings(parametersList[i]));
			}
			else if(parametersList[i].startsWith("ACTIVATIONSTATUSFLAG")){
				account_details.setAccount_status(parametersList[i].split(",")[1]);
			}
		}
		return account_details;
	}
	
	private String createServiceOfferings(String so){
		String[] so_value = so.split(",");
		StringBuffer result = new StringBuffer();
		for(int i=0; i<so_value.length; i++){
			if(so_value[i].equals("TRUE")){
				result.append("1");
			}
			else if(so_value[i].equals("FALSE")){
				result.append("0");
			}
		}
		return result.reverse().toString();
	}
	
	@SuppressWarnings("null")
	private Object createAccumulatorsList(String response_mpm){
		
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		response_mpm = splitter.split(response_mpm, "ACCUMULATOR");
		response_mpm = response_mpm.replace(";", "");
		String[] accumlator_list_splitted = response_mpm.split(",");
		
		List<AccumulatorInterface> extracted_accumulators_list = new ArrayList<AccumulatorInterface>();
		AccumulatorInterface tmp = null;
		boolean created = false;
		for (int i = 1; i < accumlator_list_splitted.length; i=i+2) {
			accumlator_list_splitted[i].replace(";", "");
			
			if(accumlator_list_splitted[i].equals("ACCUMULATOR")){
				tmp = new Accumulator();
				tmp.setAccId(accumlator_list_splitted[i+1]);
				created = true;
			}
			else if(accumlator_list_splitted[i].equals("ACCUMULATORVALUE") && created==true){
				tmp.setAccValueAbs(accumlator_list_splitted[i+1]);
			}
			else if(accumlator_list_splitted[i].equals("ACCUMULATORSTARTDATE") && created==true){
				tmp.setStartDate(accumlator_list_splitted[i+1]);
			}
			else if(accumlator_list_splitted[i].equals("ACCUMULATORENDDATE") && created==true){
				tmp.setEndDate(accumlator_list_splitted[i+1]);
				extracted_accumulators_list.add(tmp);
				created = false;
			}
		}
		return extracted_accumulators_list;
	}
	
	private BalanceAndDateInterface createMainBalanceBean(String response_mpm){
		BalanceAndDateInterface balance_date = new BalanceAndDate();
		
		String[] parametersList = response_mpm.trim().replace(";", "").split(":");
		for(int i=0; i<parametersList.length; i++){
			if(parametersList[i].startsWith("ACCOUNTVALUE1,")){
				balance_date.setMain_balance(parametersList[i].split(",")[1]);
			}
			else if(parametersList[i].startsWith("DEDICATEDACCOUNT,")){
				balance_date.setDedicated_accounts(createDedicatedAccountList(parametersList[i]));
			}
			
		}
		return balance_date;
	}
	
	@SuppressWarnings("null")
	private List<DedicatedAccountInterface> createDedicatedAccountList(String ded_list){
		String[] ded_list_splitted = ded_list.split(",");
		List<DedicatedAccountInterface> extracted_dedicated_account_list = new ArrayList<DedicatedAccountInterface>();
		DedicatedAccountInterface tmp = null;
		boolean create_ded = false;
		
		for (int i = 0; i < ded_list_splitted.length; i++) {
			ded_list_splitted[i].replace(";", "");
			
			if(ded_list_splitted[i].equals("DEDICATEDACCOUNTID")){
				tmp = new DedicatedAccount();
				tmp.setDedicatedId(ded_list_splitted[i+1]);
				create_ded = true;
			}
			else if(ded_list_splitted[i].equals("DEDICATEDEXPIRYDATE") && create_ded==true){
				tmp.setDedicatedExpiry(ded_list_splitted[i+1]);
			}
			else if(ded_list_splitted[i].equals("DEDICATEDACCOUNTVALUE1") && create_ded==true){
				tmp.setDedicatedValueNew(ded_list_splitted[i+1]);
			}
			else if(ded_list_splitted[i].equals("DEDICATEDACCOUNTUNIT") && create_ded==true){
				tmp.setDedicatedUnit(ded_list_splitted[i+1]);
				extracted_dedicated_account_list.add(tmp);
				create_ded = false;
			}
		}
		return extracted_dedicated_account_list;
	}
	
	@SuppressWarnings("null")
	private Object createFafsList(String response_mpm){
		
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		response_mpm = splitter.split(response_mpm, "FAF");
		response_mpm = response_mpm.replace(";", "");
		String[] faf_list_splitted = response_mpm.split(",");
		
		List<FafInterface> extracted_fafs_list = new ArrayList<FafInterface>();
		FafInterface tmp = null;
		FafInterface tmp_2 = null;
		
		boolean created = false;
		
		for (int i = 1; i < faf_list_splitted.length; i=i+2) {
			faf_list_splitted[i].replace(";", "");
			
			if(faf_list_splitted[i].equals("FAFNUMBER")){
				tmp = new Faf();
				tmp.setNumber(faf_list_splitted[i+1]);
				created = true;
			}
			else if(faf_list_splitted[i].equals("KINDICATOR") && created==true){
				tmp.setKindicator(faf_list_splitted[i+1]);
				extracted_fafs_list.add(tmp);
				int j=2;
				if(!faf_list_splitted[i+j].equals("OWNER")){
					do{
						tmp_2 = new Faf();
						tmp_2.setNumber(tmp.getNumber());
						tmp_2.setKindicator(faf_list_splitted[i+j]);
						extracted_fafs_list.add(tmp_2);
						j++;
					}while(!faf_list_splitted[i+j].equals("OWNER"));
					
				}
				created = false;
			}
		}
		return extracted_fafs_list;
	}
	
	@SuppressWarnings("null")
	private List<OfferIdInterface> createOfferIdList(String response_mpm){
		response_mpm = splitter.split(response_mpm, "OFFER");
		response_mpm = response_mpm.replace(";", "");
		String[] offers_list_splitted = response_mpm.split(",");
		
		List<OfferIdInterface> extracted_offers_list = new ArrayList<OfferIdInterface>();
		OfferIdInterface tmp = null;
		boolean created = false;
		for (int i = 1; i < offers_list_splitted.length; i=i+2) {
			offers_list_splitted[i].replace(";", "");
			
			if(offers_list_splitted[i].equals("OFFERID")){
				tmp = new OfferId();
				tmp.setOfferId(offers_list_splitted[i+1]);
				created = true;
			}
			else if(offers_list_splitted[i].equals("STARTDATE") && created==true){
				tmp.setStartDate(offers_list_splitted[i+1]);
			}
			else if(offers_list_splitted[i].equals("EXPIRYDATE") && created==true){
				tmp.setExpiryDate(offers_list_splitted[i+1]);
			}
			else if(offers_list_splitted[i].equals("OFFERTYPE") && created==true){
				tmp.setType(offers_list_splitted[i+1]);
				extracted_offers_list.add(tmp);
				created = false;
			}
		}
		return extracted_offers_list;
	}
	
	@SuppressWarnings("null")
	private Object createPAM(String response_mpm){
		
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		response_mpm = splitter.split(response_mpm, "PAM");
		response_mpm = response_mpm.replace(";", "");
		String[] pam_list_splitted = response_mpm.split(",");
		
		PamInterface tmp = null;
		List<PamInterface> pamInterfaceList = new ArrayList<PamInterface>();
		boolean created = false;
		
		for (int i = 1; i < pam_list_splitted.length; i=i+2) {
			pam_list_splitted[i].replace(";", "");
			
			if(pam_list_splitted[i].equals("PAMSERVICEID")){
				tmp = new Pam();
				tmp.setPamServiceId(pam_list_splitted[i+1]);
				created = true;
			}
			else if(pam_list_splitted[i].equals("PAMCLASSID") && created==true){
				tmp.setPamClassId(pam_list_splitted[i+1]);
			}
			else if(pam_list_splitted[i].equals("SCHEDULEID") && created==true){
				tmp.setPamSchedulId(pam_list_splitted[i+1]);
			}
			else if(pam_list_splitted[i].equals("CURRENTPAMPERIOD") && created==true){
				tmp.setCurrentPamPeriod(pam_list_splitted[i+1]);
			}
			else if(pam_list_splitted[i].equals("LASTEVALUATIONDATE") && created==true){
				tmp.setLast_eval_date(pam_list_splitted[i+1]);
			}
			else if(pam_list_splitted[i].equals("PAMSERVICEPRIORITY") && created==true){
				tmp.setService_priority(pam_list_splitted[i+1]);
				pamInterfaceList.add(tmp);
				created = false;
			}
		}		
		return pamInterfaceList;
	}
	
	@SuppressWarnings("null")
	private Object createPromotionPlanList(String response_mpm){
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		response_mpm = splitter.split(response_mpm, "PROMOTIONPLAN");
		response_mpm = response_mpm.replace(";", "");
		String[] pplan_list_splitted = response_mpm.split(",");
		
		List<PromotionPlanInterface> extracted_pplan_list = new ArrayList<PromotionPlanInterface>();
		PromotionPlanInterface tmp = null;
		
		boolean created = false;
		
		for (int i = 1; i < pplan_list_splitted.length; i=i+2) {
			pplan_list_splitted[i].replace(";", "");
			
			if(pplan_list_splitted[i].equals("PROMOTIONPLANID")){
				tmp = new PromotionPlan();
				tmp.setPromotionPlan(pplan_list_splitted[i+1]);
				created = true;
			}
			else if(pplan_list_splitted[i].equals("PROMOTIONSTARTDATE") && created==true){
				tmp.setStartDate(pplan_list_splitted[i+1]);
			}
			else if(pplan_list_splitted[i].equals("PROMOTIONENDDATE") && created==true){
				tmp.setEndDate(pplan_list_splitted[i+1]);
				extracted_pplan_list.add(tmp);
				created = false;
			}
		}
		return extracted_pplan_list;
	}
	
	@SuppressWarnings("null")
	private Object createShareAccountList(String response_mpm){
		
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		response_mpm = splitter.split(response_mpm, "SHAREACCOUNT");
		response_mpm = response_mpm.replace(";", "");
		String[] share_list_splitted = response_mpm.split(",");
		
		List<ShareAccountInterface> extracted_share_list = new ArrayList<ShareAccountInterface>();
		
		ShareAccountInterface share_tmp = null;
		UTsInterface ut_tmp = null;
		
		for (int i = 1; i < share_list_splitted.length; i=i+2) {
			share_list_splitted[i].replace(";", "");
			
			if(share_list_splitted[i].equals("UCID")){
				share_tmp = new ShareAccount();
				share_tmp.setUCID(share_list_splitted[i+1]);
			}
			else if(share_list_splitted[i].equals("UCMVALUE1")){
				share_tmp.setUCMValueNew(share_list_splitted[i+1]);
			}
			else if(share_list_splitted[i].equals("UTID")){
				ut_tmp = new UTs();
				ut_tmp.setUCID(share_tmp.getUCID());
				ut_tmp.setUTID(share_list_splitted[i+1]);
			}
			else if(share_list_splitted[i].equals("UTMVALUE1")){
				ut_tmp.setUTMValueNew(share_list_splitted[i+1]);
			}
			else if(share_list_splitted[i].equals("UTSOURCE")){
				ut_tmp.setSource(share_list_splitted[i+1]);
				share_tmp.addUTs(ut_tmp);
				if((i+2)>=share_list_splitted.length || share_list_splitted[i+2].equals("UCID")){
					extracted_share_list.add(share_tmp);
				}
			}
		}
		return extracted_share_list;
	}
	
	@SuppressWarnings("null")
	private Object createServiceCodeList(String response_mpm){
		
		if(!response_mpm.startsWith(ALLRESOURCECommands.START) && !response_mpm.endsWith(ALLRESOURCECommands.END)){
			return response_mpm;
		}
		String[] response_splitted = response_mpm.trim().replace(";", "").split(":");
		int index_service_code = -1;
		int index_smart_start_date = -1;
		
		for(int i=0; i<response_splitted.length; i++){
			if(response_splitted[i].startsWith("SERVICECODE,")){
				index_service_code = i;
			}
			
			else if(response_splitted[i].startsWith("SMARTSTARTDATE,")){
				index_smart_start_date = i;
			}
		}
		
		List<Object> service_code_smart_date = new ArrayList<Object>();
		
		if(index_service_code==-1 && index_smart_start_date==-1){
			service_code_smart_date.add(0,null);
			service_code_smart_date.add(1,null);
			return service_code_smart_date;
		}
		
		List<ServiceCodeInterface> extracted_sc_list = new ArrayList<ServiceCodeInterface>();
		
		ServiceCodeInterface tmp = null;
		
		String[] service_code_list_string = response_splitted[index_service_code].split(",");
		
		boolean created = false;
		for (int i = 1; i < service_code_list_string.length; i=i+2) {
			if(service_code_list_string[i].equals("SERVICECODEID")){
				tmp = new ServiceCode();
				tmp.setServiceCodeId(service_code_list_string[i+1]);
				created = true;
			}
			else if(service_code_list_string[i].equals("SERVICEACTIVATIONDATE") && created==true){
				tmp.setActivationDate(service_code_list_string[i+1]);
			}
			else if(service_code_list_string[i].equals("DATEOFNEXTCHARGING") && created==true){
				tmp.setNextFeeDate(service_code_list_string[i+1]);
				extracted_sc_list.add(tmp);
				created = false;
			}
		}
		
		String smart_start_date_string = (response_splitted[index_smart_start_date].split(","))[1];
		
		service_code_smart_date.add(smart_start_date_string);
		service_code_smart_date.add(extracted_sc_list);
		return service_code_smart_date;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setSplitter(AllResourceResponseSplitterInterface splitter) {
		this.splitter = splitter;
	}
}
