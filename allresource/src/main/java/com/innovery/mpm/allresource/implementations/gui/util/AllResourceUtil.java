package com.innovery.mpm.allresource.implementations.gui.util;

import java.io.IOException;
import java.util.List;

import org.jdom2.JDOMException;

import com.innovery.mpm.allresource.implementations.gui.tablemodel.AccumulatorModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ActiveOptionModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.DedicatedModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.FafModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.OfferModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.PAMModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.PromotionModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ServiceCodeModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ShareAccountModel;
import com.innovery.mpm.allresource.implementations.util.SubscriberOptionFinder;
import com.innovery.mpm.allresource.interfaces.bean.air.AccumulatorInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.FafInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.PamInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.PromotionPlanInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.ShareAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.ssh.ServiceCodeInterface;
import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptionsInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.OptionBeanInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;
import com.innovery.mpm.allresource.interfaces.gui.util.AllResourceUtilInterface;
import com.innovery.mpm.allresource.interfaces.util.SubscriberOptionFinderInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class AllResourceUtil implements AllResourceUtilInterface {
	
	private AllResourceInterface reference;
	private DAPBeanInterface components;
	
	public void resetFields(){
		reference.getLblAccountGroupIdResp().setText("-");
		reference.getLblServiceClassResp().setText("-");
		reference.getLblServiceOfferingsResp().setText("-");
		reference.getLblServiceOfferingsDecResp().setText("-");
		reference.getLblLanguageIdResp().setText("-");
		reference.getLblCommunityIdsResp().setText("-");
		reference.getLblMainAccountBalanceResp().setText("-");
		reference.getLblSimExpiryDateResp().setText("-");
		reference.getLblSupervisionExpiryDateResp().setText("-");
		reference.getLblAccountStatusResp().setText("-");
		resetOptionDetailsOnClick();
	}
	
	public void resetOptionDetailsOnClick(){
		reference.getLblOptionncode_value().setText("-");
		
		for(int i=0; i<reference.getDetails_service_code_list().size(); i++){
			reference.getDetails_service_code_list().get(i).setText("");
		}
		reference.getDetails_service_code_list().get(0).setText("-");

		for(int i=0; i<reference.getDetails_dedicated_account_list().size(); i++){
			reference.getDetails_dedicated_account_list().get(i).setText("");
		}
		reference.getDetails_dedicated_account_list().get(0).setText("-");
		
		for(int i=0; i<reference.getDetails_accumulator_list().size(); i++){
			reference.getDetails_accumulator_list().get(i).setText("");
		}
		reference.getDetails_accumulator_list().get(0).setText("-");
		
		for(int i=0; i<reference.getDetails_offer_id_list().size(); i++){
			reference.getDetails_offer_id_list().get(i).setText("");
		}
		reference.getDetails_offer_id_list().get(0).setText("-");
		
		reference.getLblCommunityId_value().setText("-");
		
		for(int i=0; i<reference.getDetails_faf_list().size(); i++){
			reference.getDetails_faf_list().get(i).setText("");
		}
		reference.getDetails_faf_list().get(0).setText("-");
		
		reference.getLblServiceOffering_value().setText("-");

		reference.getLblPromotionPlan_value().setText("-");

		reference.getLblAccountGroup_value().setText("-");
		
		for(int i=0; i<reference.getDetails_uc_list().size(); i++){
			reference.getDetails_uc_list().get(i).setText("");
		}
		reference.getDetails_uc_list().get(0).setText("-");

		for(int i=0; i<reference.getDetails_ut_list().size(); i++){
			reference.getDetails_ut_list().get(i).setText("");
		}
		
		for(int i=0; i<reference.getDetails_discount_list().size(); i++){
			reference.getDetails_discount_list().get(i).setText("");
			reference.getDetails_service_code_discount_list().get(i).setText("");
		}
		reference.getDetails_discount_list().get(0).setText("-");
		reference.getDetails_service_code_discount_list().get(0).setText("-");
		
	}
	
	public void resetServiceCodeDetailsOnClick(){
		reference.getLblSCId().setText("-");
		reference.getLblSCPeriod().setText("-");
		reference.getLblSCAmount().setText("-");
		reference.getSmart_start_date_field().setText("-");
	}

	public void showOptionDetailsOnClick(OptionBeanInterface selected_option_details){
		reference.getLblOptionncode_value().setText(selected_option_details.getDescription());
		
		if(selected_option_details.getSc().size()!=0){
			for(int i=0; i<selected_option_details.getSc().size(); i++){
				reference.getDetails_service_code_list().get(i).setText(selected_option_details.getSc().get(i));
			}
		}
		
		if(selected_option_details.getDaList().size()!=0){
			for(int i=0; i<selected_option_details.getDaList().size(); i++){
				reference.getDetails_dedicated_account_list().get(i).setText(selected_option_details.getDaList().get(i));
			}
		}
		
		if(selected_option_details.getAccumulatorList().size()!=0){
			for(int i=0; i<selected_option_details.getAccumulatorList().size(); i++){
				reference.getDetails_accumulator_list().get(i).setText(selected_option_details.getAccumulatorList().get(i));
			}
		}
		
		if(selected_option_details.getOfferIdList().size()!=0){
			for(int i=0; i<selected_option_details.getOfferIdList().size(); i++){
				reference.getDetails_offer_id_list().get(i).setText(selected_option_details.getOfferIdList().get(i));
			}
		}
		
		if(!selected_option_details.getCommunity().equals("")){
			reference.getLblCommunityId_value().setText(selected_option_details.getCommunity());
		}
		
		
		if(selected_option_details.getFafList().size()!=0){
			for(int i=0; i<selected_option_details.getFafList().size(); i++){
				reference.getDetails_faf_list().get(i).setText(selected_option_details.getFafList().get(i));
			}
		}
		
		if(!selected_option_details.getSo().equals("")){
			reference.getLblServiceOffering_value().setText(selected_option_details.getSo());
		}
		
		if(!selected_option_details.getPplan().equals("")){
			reference.getLblPromotionPlan_value().setText(selected_option_details.getPplan());
		}

		if(!selected_option_details.getAgi().equals("")){
			reference.getLblAccountGroup_value().setText(selected_option_details.getAgi());
		}

		if(selected_option_details.getUC().size()!=0){
			for(int i=0; i<selected_option_details.getUC().size(); i++){
				reference.getDetails_uc_list().get(i).setText(selected_option_details.getUC().get(i));
			}
		}

		if(selected_option_details.getUT().size()!=0){
			for(int i=0; i<selected_option_details.getUT().size(); i++){
				reference.getDetails_ut_list().get(i).setText(selected_option_details.getUC().get(i));
			}
		}
		
		if(selected_option_details.getDiscounts().size()!=0){
			for(int i=0; i<selected_option_details.getDiscounts().size(); i++){
				reference.getDetails_discount_list().get(i).setText(selected_option_details.getDiscounts().get(i));
				reference.getDetails_service_code_discount_list().get(i).setText(selected_option_details.getSc_discounts().get(i));
			}
		}
	}

	public void showServiceCodeDetailsOnClick(ServiceCodeDetailsInterface selected_option_details){
		reference.getLblSCId().setText(selected_option_details.getService_code_id());
		reference.getLblSCPeriod().setText(selected_option_details.getService_code_period());
		reference.getLblSCAmount().setText(selected_option_details.getService_code_fee_amount());
	}

	public void resetTableModel(){
		((AccumulatorModel) reference.getTable_accumulator().getModel()).reset();
		((DedicatedModel) reference.getTable_dedicated().getModel()).reset();
		((FafModel) reference.getTable_faf().getModel()).reset();
		((OfferModel) reference.getTable_offer().getModel()).reset();
		((PAMModel) reference.getTable_pam().getModel()).reset();
		((PromotionModel) reference.getTable_promotion().getModel()).reset();
		((ShareAccountModel) reference.getTable_uc().getModel()).reset();
		((ShareAccountModel) reference.getTable_ut().getModel()).reset();
		((ServiceCodeModel) reference.getTable_service_code_list().getModel()).reset();
		((ActiveOptionModel) reference.getTable_list_ropz().getModel()).reset();
	}

	public String tabAccumulatorManagment(int tab_index){
		Object response_action_accumulator = reference.getGet_resources().getAccumulators(reference.getTxtMsisdn().getText(), reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		
		if(response_action_accumulator instanceof String){
			return (String) response_action_accumulator;
		}
		List<AccumulatorInterface> action_accumulator = (List<AccumulatorInterface>) response_action_accumulator;
		if(action_accumulator!=null){
			if(action_accumulator.size()==0){
				((AccumulatorModel) reference.getTable_accumulator().getModel()).setDefault();
			}
			else{
				((AccumulatorModel) reference.getTable_accumulator().getModel()).setAccumulatorList(action_accumulator);
				for(int i=0; i<action_accumulator.size(); i++){
					reference.getSubscriber_resource().addAccumulator(action_accumulator.get(i).getAccId());
				}
			}
			((AccumulatorModel) reference.getTable_accumulator().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	public String tabFafManagment(int tab_index){
		Object response_action_faf = reference.getGet_resources().getFaf(reference.getTxtMsisdn().getText(), reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		if(response_action_faf instanceof String){
			return (String) response_action_faf;
		}
		List<FafInterface> action_faf = (List<FafInterface>) response_action_faf;
		if(action_faf!=null){
			if(action_faf.size()==0){
				((FafModel) reference.getTable_faf().getModel()).setDefault();
			}
			else{
				((FafModel) reference.getTable_faf().getModel()).setFafList(action_faf);
				for(int i=0; i<action_faf.size(); i++){
					reference.getSubscriber_resource().addFaf(action_faf.get(i).getKindicator());
				}
			}
			((FafModel) reference.getTable_faf().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	public String tabPromotionPlanManagment(int tab_index){
		Object response_action_pplan = reference.getGet_resources().getPromotionPlan(reference.getTxtMsisdn().getText(), reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		if(response_action_pplan instanceof String){
			return (String) response_action_pplan;
		}
		List<PromotionPlanInterface> action_pplan = (List<PromotionPlanInterface>) response_action_pplan;
		if(action_pplan!=null){
			if(action_pplan.size()==0){
				((PromotionModel) reference.getTable_promotion().getModel()).setDefault();
			}
			else{
				((PromotionModel) reference.getTable_promotion().getModel()).setPplanList(action_pplan);
				for(int i=0; i<action_pplan.size(); i++){
					reference.getSubscriber_resource().addPromotionPlan(action_pplan.get(i).getPromotionPlan());
				}
			}
			((PromotionModel) reference.getTable_promotion().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	public String tabPamManagment(int tab_index){
		Object response_action_pam = reference.getGet_resources().getPam(reference.getTxtMsisdn().getText(), reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		if(response_action_pam instanceof String){
			return (String) response_action_pam;
		}
		List<PamInterface> action_pam = (List<PamInterface>) response_action_pam;
		if(action_pam!=null){
			if(action_pam.size()==0){
				((PAMModel) reference.getTable_pam().getModel()).setDefault();
			}
			else{
				((PAMModel) reference.getTable_pam().getModel()).setPamList(action_pam);
			}
			((PAMModel) reference.getTable_pam().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	public String tabShareAccoutManagment(int tab_index){
		Object response_action_share_account = reference.getGet_resources().getShareAccount(reference.getTxtMsisdn().getText(), reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		if(response_action_share_account instanceof String){
			return (String) response_action_share_account;
		}
		List<ShareAccountInterface> action_share_account = (List<ShareAccountInterface>) response_action_share_account;
		if(action_share_account!=null){
			if(action_share_account.size()==0){
				((ShareAccountModel) reference.getTable_uc().getModel()).setDefault();
				((ShareAccountModel) reference.getTable_ut().getModel()).setDefault();
			}
			else{
				((ShareAccountModel) reference.getTable_uc().getModel()).setShareaccountList(action_share_account);
				((ShareAccountModel) reference.getTable_ut().getModel()).setUtsList(((ShareAccountModel) reference.getTable_uc().getModel()).getUtsList());
				for(int i=0; i<action_share_account.size(); i++){
					ShareAccountInterface tmp = action_share_account.get(i);
					reference.getSubscriber_resource().addUC(tmp.getUCID());
					for(int j=0; j<tmp.getUTs().size(); j++){
						reference.getSubscriber_resource().addUT(tmp.getUTs().get(i).getUTID());
					}
				}
			}
			((ShareAccountModel) reference.getTable_uc().getModel()).fireTableDataChanged();
			((ShareAccountModel) reference.getTable_ut().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String tabServiceCodeManagment(int tab_index){
		Object response_action_service_code_list_smart_date = reference.getGet_resources().getServiceCode(reference.getTxtMsisdn().getText());
		if(response_action_service_code_list_smart_date instanceof String){
			return (String) response_action_service_code_list_smart_date;
		}
		List<Object> action_service_code_list_smart_date = (List<Object>) response_action_service_code_list_smart_date;
		if(action_service_code_list_smart_date.get(0)==null && action_service_code_list_smart_date.get(0)==null){
			return "-"; 
		}
		
		List<ServiceCodeInterface> action_service_code = null;
		String action_smart_date = null;
		
		if(action_service_code_list_smart_date.get(0)!=null && action_service_code_list_smart_date.get(0) instanceof String){
			action_smart_date = (String) action_service_code_list_smart_date.get(0);
			if(action_service_code_list_smart_date.get(1)!=null && action_service_code_list_smart_date.get(1) instanceof List<?>){
				action_service_code = (List<ServiceCodeInterface>) action_service_code_list_smart_date.get(1);
				
			}
		}
		
		else if(action_service_code_list_smart_date.get(0)!=null && action_service_code_list_smart_date.get(0) instanceof List<?>){
			action_service_code = (List<ServiceCodeInterface>) action_service_code_list_smart_date.get(0);
			if(action_service_code_list_smart_date.get(1)!=null && action_service_code_list_smart_date.get(1) instanceof String){
				action_smart_date = (String) action_service_code_list_smart_date.get(1);
			}
		}
		
		if(action_service_code!=null){
			if(action_service_code.size()==0){
				((ServiceCodeModel) reference.getTable_service_code_list().getModel()).setDefault();
			}
			else{
				((ServiceCodeModel) reference.getTable_service_code_list().getModel()).setServiceCodeList(action_service_code, this);
				for(int i=0; i<action_service_code.size(); i++){
					reference.getSubscriber_resource().addServiceCode(action_service_code.get(i).getServiceCodeId());
				}
			}
			((ServiceCodeModel) reference.getTable_service_code_list().getModel()).fireTableDataChanged();
			reference.getTabs_flags()[tab_index]=1;
		}
		
		if(action_smart_date!=null){
			reference.getSmart_start_date_field().setText(formatDate(action_smart_date));
			reference.getTabs_flags()[tab_index]=1;
		}
		return null;
	}

	@SuppressWarnings("null")
	public void tabOptionManagment(ActivatedSubscriberResourceInterface subscriber_resource, int tab_index){
		SubscriberOptionFinderInterface subscriber_option_finder = new SubscriberOptionFinder();
		subscriber_option_finder.setComponents(components);
		List<ActivatedSubscriberOptionsInterface> option_activated_list_on_account = null;
		try {
			option_activated_list_on_account = subscriber_option_finder.executeSubscriberOptionFinder(subscriber_resource, reference.getRadioGroupMarket().getSelection().getActionCommand(), reference.getRadioGroupCtype().getSelection().getActionCommand());
		} catch (JDOMException e) {
			components.getLogger().error(e);
		} catch (IOException e) {
			components.getLogger().error(e);
		}
		
		if(option_activated_list_on_account.size()==0){
			((ActiveOptionModel) reference.getTable_list_ropz().getModel()).setDefault();
		}
		else{
			((ActiveOptionModel) reference.getTable_list_ropz().getModel()).setOptionList(option_activated_list_on_account);
		}
		((ActiveOptionModel) reference.getTable_list_ropz().getModel()).fireTableDataChanged();
		reference.getTabs_flags()[tab_index]=1;
	}
	
	public String formatDate(String inputDate){
		if(!inputDate.equals("NULL")){
			StringBuffer newDate = new StringBuffer();
			String YY = inputDate.substring(0, 4);
			String MM = inputDate.substring(4, 6);
			String DD = inputDate.substring(6, 8);
			return newDate.append(YY).append("-").append(MM).append("-").append(DD).toString();
		}
		return inputDate;
	}

	public void setReference(AllResourceInterface reference) {
		this.reference = reference;
	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}
}
