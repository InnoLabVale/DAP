package com.innovery.mpm.allresource.interfaces.gui;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.innovery.mpm.allresource.interfaces.action.ActionGetResourcesInterface;
import com.innovery.mpm.allresource.interfaces.gui.util.AllResourceUtilInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceNotificationConnectionWarningInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;

public interface AllResourceInterface {
	
	public void initialize();

	public abstract void executeGet();

	public abstract void executeGetTabs(int tab_index);

	public abstract void disponeOnErrorConnection();

	public abstract JFrame getFrame();

	public abstract JTextField getTxtMsisdn();

	public abstract JButton getBtnView();

	public abstract JTable getTable_faf();

	public abstract JTable getTable_promotion();

	public abstract JTable getTable_offer();

	public abstract JTable getTable_pam();

	public abstract JTable getTable_list_ropz();

	public abstract JTable getTable_dedicated();

	public abstract JTable getTable_accumulator();

	public abstract JTable getTable_uc();

	public abstract JTable getTable_ut();

	public abstract JTable getTable_service_code_list();

	public abstract JLabel getLblSimExpiryDateResp();

	public abstract JLabel getLblSupervisionExpiryDateResp();

	public abstract JLabel getLblAccountStatusResp();

	public abstract JLabel getLblAccountGroupIdResp();

	public abstract JLabel getLblServiceClassResp();

	public abstract JLabel getLblServiceOfferingsResp();

	public abstract JLabel getLblServiceOfferingsDecResp();

	public abstract JLabel getLblLanguageIdResp();

	public abstract JLabel getLblCommunityIdsResp();

	public abstract JLabel getLblMainAccountBalanceResp();

	public abstract ButtonGroup getRadioGroupMarket();

	public abstract JTabbedPane getTabbedPane();

	public abstract int[] getTabs_flags();

	public abstract JProgressBar getProgressBar();

	public abstract ActivatedSubscriberResourceInterface getSubscriber_resource();

	public abstract JLabel getLblOptionncode_value();

	public abstract JLabel getLblServiceCode_value();

	public abstract JLabel getLblServiceCode_2_value();

	public abstract JLabel getLblDedicatedAccount_value();

	public abstract JLabel getLblDedicatedAccount_2_value();

	public abstract JLabel getLblDedicatedAccount_3_value();

	public abstract JLabel getLblAccumulator_value();

	public abstract JLabel getLblAccumulator_2_value();

	public abstract JLabel getLblAccumulator_3_value();

	public abstract JLabel getLblOfferId_value();

	public abstract JLabel getLblOfferId_2_value();

	public abstract JLabel getLblOfferId_3_value();

	public abstract JLabel getLblCommunityId_value();

	public abstract JLabel getLblFaf_value();

	public abstract JLabel getLblFaf_2_value();

	public abstract JLabel getLblFaf_3_value();

	public abstract JLabel getLblServiceOffering_value();

	public abstract JLabel getLblPromotionPlan_value();

	public abstract JLabel getLblAccountGroup_value();

	public abstract JLabel getLblUc_value();

	public abstract JLabel getLblUc_2_value();

	public abstract JLabel getLblUc_3_value();

	public abstract JLabel getLblUt_value();

	public abstract JLabel getLblUt_2_value();

	public abstract JLabel getLblUt_3_value();

	public abstract List<JLabel> getDetails_service_code_list();

	public abstract List<JLabel> getDetails_dedicated_account_list();

	public abstract List<JLabel> getDetails_accumulator_list();

	public abstract List<JLabel> getDetails_offer_id_list();

	public abstract List<JLabel> getDetails_faf_list();

	public abstract List<JLabel> getDetails_uc_list();

	public abstract List<JLabel> getDetails_ut_list();

	public abstract List<JLabel> getDetails_discount_list();

	public abstract List<JLabel> getDetails_service_code_discount_list();
	
	public JLabel getLblSCId_name();

	public JLabel getLblSCPeriod_name();

	public JLabel getLblSCAmount_name();

	public JLabel getLblSCId();

	public JLabel getLblSCPeriod();

	public JLabel getLblSCAmount();
	
	public ActionGetResourcesInterface getGet_resources();

	public JLabel getSmart_start_date_field();

	public ButtonGroup getRadioGroupCtype();
	
	public void setConnectionWarning(AllResourceNotificationConnectionWarningInterface connectionWarning);

	public void setUtil(AllResourceUtilInterface util);
	
	public void setGet_resources(ActionGetResourcesInterface get_resources);
}