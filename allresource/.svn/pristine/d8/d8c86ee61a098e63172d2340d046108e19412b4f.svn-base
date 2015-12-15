package com.innovery.mpm.allresource.implementations.gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

//import com.innovery.mpm.allresource.implementations.action.ActionGetResources;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.AccumulatorModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ActiveOptionModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.DedicatedModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.FafModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.OfferModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.PAMModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.PromotionModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ServiceCodeModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.ShareAccountModel;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.OptionBean;
import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.ServiceCodeDetails;
import com.innovery.mpm.allresource.implementations.gui.util.Task;
import com.innovery.mpm.allresource.implementations.util.AllResourceServiceOfferingConverter;
import com.innovery.mpm.allresource.implementations.util.XmlOptionReader;
import com.innovery.mpm.allresource.implementations.util.XmlServiceCodeReader;
import com.innovery.mpm.allresource.implementations.util.bean.ActivatedSubscriberResource;
import com.innovery.mpm.allresource.interfaces.action.ActionGetResourcesInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.AccountDetailsInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.BalanceAndDateInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.DedicatedAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.OfferIdInterface;
import com.innovery.mpm.allresource.interfaces.gui.AllResourceInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.OptionBeanInterface;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ServiceCodeDetailsInterface;
import com.innovery.mpm.allresource.interfaces.gui.util.AllResourceUtilInterface;
import com.innovery.mpm.allresource.interfaces.util.AllResourceNotificationConnectionWarningInterface;
import com.innovery.mpm.allresource.interfaces.util.XmlOptionReaderInterface;
import com.innovery.mpm.allresource.interfaces.util.XmlServiceCodeReaderInterface;
import com.innovery.mpm.allresource.interfaces.util.bean.ActivatedSubscriberResourceInterface;
import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.NotificationInterface;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.JRadioButton;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 * 
 */
public class AllResource implements AllResourceInterface{
	
	private JFrame frame;

	private JPanel panel_center;
	private JPanel upper_panel;
	
	private JTextField txtMsisdn;
	private JButton btnView;
	
	private JRadioButton rdbtnConsumer;
	private JRadioButton rdbtnCorporate;
	
	private JRadioButton rdbtnPrepaid;
	private JRadioButton rdbtnPostpaid;
	
	private JPanel panel_dedicated_account_accumulator;
	private JPanel panel_life_cycle;
	
	private JScrollPane scrollPane_dedicated;
	private JScrollPane scrollPane_accumulator;
	private JScrollPane panel_faf;
	private JScrollPane panel_promotion;
	private JScrollPane panel_offer;
	private JScrollPane panel_pam;
	private JScrollPane scrollPane_uc;
	private JScrollPane scrollPane_ut;
	private JScrollPane scrollPane_service_code_list;
	private JScrollPane scrollPane_service_code_details;
	private JScrollPane scrollPane_ropz_list;
	private JScrollPane scrollPane_ropz_details;
	
	private JTable table_faf;
	private JTable table_promotion;
	private JTable table_offer;
	private JTable table_pam;
	private JTable table_list_ropz;
	private JTable table_dedicated;
	private JTable table_accumulator;
	private JTable table_uc;
	private JTable table_ut;
	private JTable table_service_code_list;
	
	private JPanel panel_share_account;
	private JPanel panel_service_code;
	private JPanel panel_service_code_details;
	private JPanel panel_options;
	private JPanel panel_ropz_details;
	
	private JLabel lblSimExpiryDateResp;
	private JLabel lblSupervisionExpiryDateResp;
	private JLabel lblAccountStatusResp;
	private JLabel lblAccountGroupIdResp;
	private JLabel lblServiceClassResp;
	private JLabel lblServiceOfferingsResp;
	private JLabel lblServiceOfferingsDecResp;
	private JLabel lblLanguageIdResp;
	private JLabel lblCommunityIdsResp;
	private JLabel lblMainAccountBalanceResp;
	private JPanel smart_start_date_panel;

	private ButtonGroup radioGroupMarket;
	private ButtonGroup radioGroupCtype;
	private JTabbedPane tabbedPane;
	
	private AllResource reference;
	private AllResourceNotificationConnectionWarningInterface connectionWarning;
		
	private int[] tabs_flags;
	private boolean view = false;
	private JProgressBar progressBar;
	
	private AccountDetailsInterface details_info;
	private BalanceAndDateInterface balance_date_info;
	private ActivatedSubscriberResourceInterface subscriber_resource;
	
	private JLabel lblOptionncode_value;
	private JLabel lblServiceCode_value;
	private JLabel lblServiceCode_2_value;
	private JLabel lblDedicatedAccount_value;
	private JLabel lblDedicatedAccount_2_value;
	private JLabel lblDedicatedAccount_3_value;
	private JLabel lblAccumulator_value;
	private JLabel lblAccumulator_2_value;
	private JLabel lblAccumulator_3_value;
	private JLabel lblOfferId_value;
	private JLabel lblOfferId_2_value;
	private JLabel lblOfferId_3_value;
	private JLabel lblCommunityId_value;
	private JLabel lblFaf_value;
	private JLabel lblFaf_2_value;
	private JLabel lblFaf_3_value;
	private JLabel lblServiceOffering_value;
	private JLabel lblPromotionPlan_value;
	private JLabel lblAccountGroup_value;
	private JLabel lblUc_value;
	private JLabel lblUc_2_value;
	private JLabel lblUc_3_value;
	private JLabel lblUt_value;
	private JLabel lblUt_2_value;
	private JLabel lblUt_3_value;
	
	private JLabel lblSCId_name;
	private JLabel lblSCPeriod_name;
	private JLabel lblSCAmount_name;
	private JLabel lblSCId;
	private JLabel lblSCPeriod;
	private JLabel lblSCAmount;
	private JLabel smart_start_date_field;
	
	
	private List<JLabel> details_service_code_list;
	private List<JLabel> details_dedicated_account_list;
	private List<JLabel> details_accumulator_list;
	private List<JLabel> details_offer_id_list;
	private List<JLabel> details_faf_list;
	private List<JLabel> details_uc_list;
	private List<JLabel> details_ut_list;
	private List<JLabel> details_discount_list;
	private List<JLabel> details_service_code_discount_list;
	
	private AllResourceUtilInterface util;
	
	private DAPBeanInterface components;
	private ActionGetResourcesInterface get_resources;
	private SessionStandardInterface sessionStandard;
	
	private NotificationInterface notification;
	private ErrorMessagesInterface errorMessages;
	private GUICommonInterface commonGUI;
	
	/**
	 * Create the application.
	 */
	public AllResource(DAPBeanInterface components)  {
		
		this.reference = this;
		this.components = components;
		sessionStandard = components.getConnectionManagerStandard().getSession();
		
		commonGUI = components.getCommonGUI();
		notification = components.getNotifications();
		errorMessages = components.getErrorMessages();
		
		tabs_flags = new int[9];
		
		details_service_code_list = new ArrayList<JLabel>();
		details_dedicated_account_list = new ArrayList<JLabel>();
		details_accumulator_list = new ArrayList<JLabel>();
		details_offer_id_list = new ArrayList<JLabel>();
		details_faf_list = new ArrayList<JLabel>();
		details_uc_list = new ArrayList<JLabel>();
		details_ut_list = new ArrayList<JLabel>();
		details_discount_list = new ArrayList<JLabel>();
		details_service_code_discount_list = new ArrayList<JLabel>();
		
		UIManager.put("nimbusOrange",new ColorUIResource(Color.green.darker()));
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		setFrameInitialSettings();
		setPanelNorth();
		setPanelSouth();
		setPanelCenter();
		
		setUpperPanel();
		
		setMsisdnLabel();
		setMsisdnText();
		
		setRadioButtonConsumer();
		setRadioButtonCorporate();
		setRadioGroupMarket();
		
		setRadioButtonPrepaid();
		setRadioButtonPostpaid();
		setRadioGroupCtype();
	    
	    setProgressBar();
	    
	    setAccountGroupIdLabel();
	    setAccountGroupIdLabelResponse();
		
	    setServiceClassLabel();
	    setServiceClassLabelResponse();

	    setServiceOfferingsLabel();
	    setServiceOfferingsLabelResponse();
	    setServiceOfferingsDecimalLabelResponse();
	    
	    setLanguageLabel();
	    setLanguageLabelResponse();

		setCommunityIdLabel();
		setCommunityIdLabelResponse();

		setMainAccountLabel();
		setMainAccountLabelReponse();
		
		setViewButton();
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnView.getActionCommand().equals("home")){
					frame.dispose();
				}
				else{
					for(int i=0; i<tabs_flags.length; i++){
						tabs_flags[i]=0;
					}
					util.resetTableModel();
					util.resetFields();
					frame.validate();
					view = false;
					if(!isMsisdn(getTxtMsisdn().getText())){
						notification.error("MSISDN is mandatory. Must be numeric, from 1 to 28 digits.");
					}
					else if (radioGroupMarket.getSelection() == null) {
						notification.error("Select a market for msisdn selected.");
					}
					
					else if (radioGroupCtype.getSelection() == null) {
						notification.error("Select a type for msisdn selected.");
					}
					
					else {
						progressBar.setVisible(true);
						progressBar.setIndeterminate(true);
						final Task task = new Task(reference, -1);
						task.addPropertyChangeListener(new PropertyChangeListener() {
							public void propertyChange(PropertyChangeEvent evt) {
							 if (!task.isDone()) {
							        int progress = task.getProgress();
							        if (progress == 0) {
							            progressBar.setIndeterminate(true);
							        } else {
							            progressBar.setIndeterminate(false); 
							            progressBar.setString(null);
							            progressBar.setValue(progress);

							        }
							    }
							}
						});
						task.execute();
					}
				}
			}
		});
		
		setTabbedPane();
		
		setDedicatedAccountAccumulatorPanel();
		
		setScrollAccumulator();
		setScrollDedicatedAccount();
		
		setDedicatedAccountTable();
		setAccumulatorTable();
		
		setLifeCyclePanel();
		
		setSimExpDateLabel();
		setSimExpDateLabelResponse();
		
		setSupExpLabel();
		setSupExpLabelResponse();
		
		setAccountStateLabel();
		setAccountStateLabelResponse();
		
		setScrollFaf();
		setFafTable();
		
		setScrollPromotion();
		setPromotionTable();
		
		setScrollOfferId();
		setOfferIdTable();
		
		setScrollPam();
		setPamTable();
		
		setShareAccountPanel();
		
		setScrollUsageCounter();
		setUsageCounterTable();
		
		setScrollUsageThreshold();
		setUsageThresholdTable();
		
		setServiceCodePanel();
		
		setServiceCodeListScroll();
		setServiceCodeListTable();
		setSmartStartDatePanel();
		
		setServiceCodeDetailsScroll();
		setServiceCodeDetailsPanel();
		
		setServiceCodeIdLabel();
		setServiceCodeFeePeriodLabel();
		setServiceCodeAmountLabel();
		
		setServiceCodeIdLabelResponse();
		setServiceCodeFeePeriodLabelResponse();
		setServiceCodeAmountLabelResponse();
		
		setOptionsPanel();
		
		setRopzListScroll();
		
		setRopzDetailsScroll();
		
		setRopzListTable();

		setRopzDetailsPanel();
		
		setRopzDescriptionLabel();
		setRopzDescriptionLabelResponse();
		
		setRopzServiceCodeLabel();
		setRopzServiceCodeLabelResponse();
		
		setRopzDedicatedAccountLabel();
		setRopzDedicatedAccountLabelResponse();
		
		setRopzAccumulatorLabel();
		setRopzAccumulatorLabelResponse();
		
		setRopzOfferIdLabel();
		setRopzOfferIdLabelResponse();
		
		setRopzCommunityIdLabel();
		setRopzCommunityIdLabelResponse();
		
		setRopzFafLabel();
		setRopzFafLabelResponse();
		
		setRopzServiceOfferingsLabel();
		setRopzServiceOfferingsLabelResponse();
		
		setRopzPromotionPlanLabel();
		setRopzPromotionPlanLabelResponse();
		
		setRopzAccountGroupIdLabel();
		setRopzAccountGroupIdLabelResponse();
		
		setRopzUcLabel();
		setRopzUcLabelResponse();
		
		setRopzUtLabel();
		setRopzUtLabelResponse();
		
		setRopzRelatedLabel();
		
		setRopzServiceCodeRelatedLabel();
		
		setDiscountsListLabelResponse();
		setServiceCodeDiscountsLabelResponse();
		
		panel_dedicated_account_accumulator.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[0]==0 && view==true){
					componentShownAux(0);
				}
			}
		});
		
		panel_life_cycle.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				tabs_flags[1]=1;
			}
		});
		
		panel_faf.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[2]==0 && view==true){
					componentShownAux(2);
				}
			}
		});
	
		panel_promotion.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[3]==0 && view==true){
					componentShownAux(3);
				}
			}
		});
		
		panel_offer.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				tabs_flags[4]=1;
			}
//				if(tabs_flags[4]==0 && view==true){
//					componentShownAux(4);
//				}
			
		});
	
		panel_pam.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[5]==0 && view==true){
					componentShownAux(5);
				}
			}
		});

		panel_share_account.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[6]==0 && view==true){
					componentShownAux(6);
				}
			}
		});
		
		panel_service_code.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[7]==0 && view==true){
					componentShownAux(7);
				}
			}
		});
		
		tabbedPane.addTab("ROPZ", null, panel_options, null);
		panel_options.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent arg0) {
				if(tabs_flags[8]==0 && view==true){
					componentShownAux(8);
				}
			}
		});
		
		table_service_code_list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				util.resetServiceCodeDetailsOnClick();
				
				int rowSelected = table_service_code_list.getSelectedRow();
				
				String scSelected = ((ServiceCodeModel) table_service_code_list.getModel()).getOptionCode(rowSelected);
				findServiceCodeDetailsOnClick(scSelected);
			}
		});
		
		table_list_ropz.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				util.resetOptionDetailsOnClick();
				int rowSelected = table_list_ropz.getSelectedRow();
				String optionSelected = ((ActiveOptionModel) table_list_ropz.getModel()).getOptionCode(rowSelected);
				findOptionDetailsOnClick(optionSelected);
			}
		});
		
		frame.setVisible(true);
	}
	
	private void componentShownAux(int local_tab_index) {
		
		if(tabs_flags[local_tab_index]==0 && view==true){
			progressBar.setVisible(true);
			progressBar.setIndeterminate(true);
			final Task task = new Task(reference, local_tab_index);
			task.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					 if (!task.isDone()) {
					        int progress = task.getProgress();
					        if (progress == 0) {
					            progressBar.setIndeterminate(true);
					        } else {
					            progressBar.setIndeterminate(false); 
					            progressBar.setString(null);
					            progressBar.setValue(progress);

					        }
					    }
				}
			});
			task.execute();
		}
	}
		
	public void executeGet(){
		if (sessionStandard.getCurrent_msisdn().equals("") || !sessionStandard.getCurrent_msisdn().equals(txtMsisdn.getText())) {
			sessionStandard.setCurrent_msisdn(txtMsisdn.getText());
			components.getMsisdnCompleter().store(txtMsisdn.getText());
			components.getLogger().info("MSISDN ADDED TO SESSION.");
		}
		
		Object response_send = get_resources.getAccountDetails(txtMsisdn.getText(), radioGroupMarket.getSelection().getActionCommand(), getRadioGroupCtype().getSelection().getActionCommand());

		if(response_send instanceof String){
			connectionStatusManagment((String) response_send);
		}
		
		else{
			
			Object[] balance_and_date_offerid_resp = get_resources.getBalanceAndDate(txtMsisdn.getText(), radioGroupMarket.getSelection().getActionCommand(), getRadioGroupCtype().getSelection().getActionCommand());
			
			subscriber_resource = new ActivatedSubscriberResource();
			details_info = (AccountDetailsInterface) response_send;
			
			balance_date_info = (BalanceAndDateInterface) balance_and_date_offerid_resp[0];
			
			view = true;
			String extracted_account_group_id = details_info.getAccount_group_id();
			String extracted_service_class = details_info.getService_class();
			String extracted_service_offerings = details_info.getService_offerings();
			String extracted_language = details_info.getLanguage();
			String extracted_community_id = details_info.getCommunity_id();
			String extracted_main_balance = balance_date_info.getMain_balance();
			String extracted_sim_expiry_date = details_info.getSim_exp_date();
			String extracted_sup_expiry_date = details_info.getSup_exp_date();
			String extracted_account_status = details_info.getAccount_status();
			
			if(!extracted_account_group_id.equals("")){
				lblAccountGroupIdResp.setText(extracted_account_group_id);
				subscriber_resource.setAgi(extracted_account_group_id);				
			}
			if(!extracted_service_class.equals("")){
				lblServiceClassResp.setText(extracted_service_class);
			}
			if(!extracted_service_offerings.equals("")){
				lblServiceOfferingsResp.setText(extracted_service_offerings);
				subscriber_resource.setSo(extracted_service_offerings);
				lblServiceOfferingsDecResp.setText(AllResourceServiceOfferingConverter.fromBitToDecimal(lblServiceOfferingsResp.getText()));
			}
			if(!extracted_language.equals("")){
				lblLanguageIdResp.setText(extracted_language);
			}
			if(!extracted_community_id.equals("")){
				lblCommunityIdsResp.setText(extracted_community_id);
				subscriber_resource.setCommunity(extracted_community_id);
			}
			if(!extracted_sim_expiry_date.equals("")){
				lblSimExpiryDateResp.setText(extracted_sim_expiry_date);
			}
			if(!extracted_sup_expiry_date.equals("")){
				lblSupervisionExpiryDateResp.setText(extracted_sup_expiry_date);
			}
			if(!extracted_sup_expiry_date.equals("")){
				if(extracted_account_status.equals("TRUE")){
					lblAccountStatusResp.setText("ACTIVE");
				}
				else if(extracted_account_status.equals("FALSE")){
					lblAccountStatusResp.setText("UNACTIVE");
				}
			}
			if(!extracted_main_balance.equals("")){
				lblMainAccountBalanceResp.setText(String.valueOf((Double.parseDouble(extracted_main_balance))/100));
			}

			if(balance_date_info.getDedicated_accounts().size()==0){
				((DedicatedModel) table_dedicated.getModel()).setDefault();
			}
			else{
				List<DedicatedAccountInterface> da_list = balance_date_info.getDedicated_accounts();
				((DedicatedModel) table_dedicated.getModel()).setDedicatedList(da_list);
				for(int i=0; i<da_list.size(); i++){
					subscriber_resource.addDa(da_list.get(i).getDedicatedId());
				}
				((DedicatedModel) table_dedicated.getModel()).fireTableDataChanged();
			}
			
			@SuppressWarnings("unchecked")
			List<OfferIdInterface> action_offer = (List<OfferIdInterface>) balance_and_date_offerid_resp[1]; 
			
			if(action_offer!=null){
				if(action_offer.size()==0){
					((OfferModel) table_offer.getModel()).setDefault();
				}
				else{
					((OfferModel) table_offer.getModel()).setOfferList(action_offer);
					for(int i=0; i<action_offer.size(); i++){
						subscriber_resource.addOffer(action_offer.get(i).getOfferId());
					}
				}
				((OfferModel) table_offer.getModel()).fireTableDataChanged();
			}
			
			switch (tabbedPane.getSelectedIndex()) {
			case 0:
				util.tabAccumulatorManagment(0);
				break;
				
			case 2:
				util.tabFafManagment(2);
				break;
				
			case 3:
				util.tabPromotionPlanManagment(3);
				break;
			
			case 5:
				util.tabPamManagment(5);
				break;
				
			case 6:
				util.tabShareAccoutManagment(6);
				break;
				
			case 7:
				util.tabServiceCodeManagment(7);
				break;
				
			case 8:
					if(tabs_flags[0] == 0){
						util.tabAccumulatorManagment(0);
					}
					if(tabs_flags[2] == 0){
						util.tabFafManagment(2);
					}
					if(tabs_flags[3] == 0){
						util.tabPromotionPlanManagment(3);
					}
					if(tabs_flags[6] == 0){
						util.tabShareAccoutManagment(6);
					}
					if(tabs_flags[7] == 0){
						util.tabServiceCodeManagment(7);
					}
				util.tabOptionManagment(subscriber_resource, 8);
				break;
			}
		}
	}
	
	private void connectionStatusManagment(String response_send){
		
		if(response_send!=null){
			
			if(response_send.equals(errorMessages.get_NOT_LOGGED_WARN()) || 
			   response_send.equals(errorMessages.get_MPM_CONNECTION_WARN()) || 
			   response_send.equals(errorMessages.get_USER_NOT_FOUND())){
				
				if(response_send.equals(errorMessages.get_NOT_LOGGED_WARN())){
					connectionWarning.notify(errorMessages.get_NOT_LOGGED_WARN());
				}
				
				else if(response_send.equals(errorMessages.get_MPM_CONNECTION_WARN())){
					connectionWarning.notify(errorMessages.get_MPM_CONNECTION_WARN());
				}
				
				else if(response_send.equals(errorMessages.get_USER_NOT_FOUND())){
					notification.warning(errorMessages.get_USER_NOT_FOUND());
				}
			}
		}
	}
	
	public void executeGetTabs(int tab_index){
		String response_mpm_status = null;
		
		switch (tab_index) {
			case 0:
				response_mpm_status = util.tabAccumulatorManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
			
		case 2:
				response_mpm_status = util.tabFafManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
			
		case 3:
				response_mpm_status = util.tabPromotionPlanManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
		
		case 5:
				response_mpm_status = util.tabPamManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
			
		case 6:
				response_mpm_status = util.tabShareAccoutManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
			
		case 7:
				response_mpm_status = util.tabServiceCodeManagment(tab_index);
				connectionStatusManagment(response_mpm_status);
			break;
			
		case 8:
			
			if(tabs_flags[0] == 0){
				util.tabAccumulatorManagment(tab_index);
			}
			if(tabs_flags[2] == 0){
				util.tabFafManagment(tab_index);
			}
			if(tabs_flags[3] == 0){
				util.tabPromotionPlanManagment(tab_index);
			}
			if(tabs_flags[6] == 0){
				util.tabShareAccoutManagment(tab_index);
			}
			if(tabs_flags[7] == 0){
				util.tabServiceCodeManagment(tab_index);
			}
			util.tabOptionManagment(subscriber_resource, tab_index);
		break;
		}
	}
	
	private void findOptionDetailsOnClick(String optionSelected) {
		XmlOptionReaderInterface xmlor = new XmlOptionReader();
		xmlor.setComponents(components);
		OptionBeanInterface selected_option_details = new OptionBean();
		try {
			selected_option_details = xmlor.getOptionDetails(optionSelected, radioGroupMarket.getSelection().getActionCommand(), radioGroupCtype.getSelection().getActionCommand());
			if (selected_option_details != null) {
				util.showOptionDetailsOnClick(selected_option_details);
			}

		} catch (XPathExpressionException e) {
			components.getLogger().error(e.toString());

		} catch (JDOMException e) {
			components.getLogger().error(e.toString());

		} catch (IOException e) {
			components.getLogger().error(e.toString());

		} catch (SAXException e) {
			components.getLogger().error(e.toString());

		} catch (ParserConfigurationException e) {
			components.getLogger().error(e.toString());
		}
	}
	
	private void findServiceCodeDetailsOnClick(String scSelected){
		XmlServiceCodeReaderInterface xmlscr = new XmlServiceCodeReader();
		xmlscr.setComponents(components);
		ServiceCodeDetailsInterface selected_service_code = new ServiceCodeDetails();
		try {
			selected_service_code = xmlscr.getServiceCodeDetails(scSelected);
			if(selected_service_code!=null){
				util.showServiceCodeDetailsOnClick(selected_service_code);
			}
		} catch (JDOMException e) {
			components.getLogger().error(e.toString());
		} catch (IOException e) {
			components.getLogger().error(e.toString());
		}
	}
	
	private boolean isMsisdn(String msisdn){
		return Pattern.matches("^[0-9]{1,28}$", msisdn);
	}	

	public void disponeOnErrorConnection(){
		this.btnView.setText("Home");
		this.btnView.setActionCommand("home");
		frame.dispose();
	}

	private void setFrameInitialSettings(){
		frame = new JFrame();
		frame.setSize(1240, 700);
		frame.setTitle("Dashboard Assurance Prepaid- SUBSCRIBER DETAILS");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);

		/* Event on close frame */
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				getFrame().dispose();
			}
		});
	}
	
	private void setPanelNorth(){
		
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout_north = (FlowLayout) panel_north.getLayout();
		flowLayout_north.setVgap(5);
		frame.getContentPane().add(panel_north, BorderLayout.NORTH);
		JLabel title_label = new JLabel("SUBSCRIBER DETAILS");
		title_label.setFont(commonGUI.setFontSize(18));
		panel_north.add(title_label);
	}

	private void setPanelSouth(){
		JPanel panel_south = new JPanel();
		frame.getContentPane().add(panel_south, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_south = new GridBagLayout();
		gbl_panel_south.columnWidths = new int[]{1234, 0};
		gbl_panel_south.rowHeights = new int[]{16, 0};
		gbl_panel_south.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_south.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_south.setLayout(gbl_panel_south);
		
		JLabel devByLabel = new JLabel();
		devByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		devByLabel.setForeground(Color.DARK_GRAY);
		devByLabel.setFont(commonGUI.setFontSize(Font.BOLD, 11));
		devByLabel.setText("- By Innovery S.p.A. -");
		panel_south.add(devByLabel, commonGUI.setContraints(5, 0, 3, 0, 0, 0));
	}
	
	private void setPanelCenter(){
		panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{0, 0};
		gbl_panel_center.rowHeights = new int[]{241, 0, 0};
		gbl_panel_center.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
	}
	
	private void setUpperPanel(){
		upper_panel = new JPanel();
		upper_panel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "", TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 13), null));
		panel_center.add(upper_panel, commonGUI.setContraints(GridBagConstraints.BOTH, 15, 10, 5, 10, 0, 0));
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 270, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		upper_panel.setLayout(gbl_panel);
	}
	
	private void setMsisdnLabel(){
		JLabel lblMsisdn = new JLabel("MSISDN*");
		upper_panel.add(lblMsisdn, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 25, 5, 5, 0, 0));

	}
	
	private void setMsisdnText(){
		txtMsisdn = new JTextField();
		txtMsisdn.setColumns(10);
		txtMsisdn.setText(sessionStandard.getCurrent_msisdn());
		upper_panel.add(txtMsisdn, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 30, 5, 5, 1, 0));
		
		JComboBox msisdn_combo = components.getMsisdnCompleter().setupAutoComplete(txtMsisdn);
		txtMsisdn.setLayout(new BorderLayout());
		txtMsisdn.add(msisdn_combo, BorderLayout.SOUTH);
	}
	
	private void setRadioButtonConsumer(){
		rdbtnConsumer = new JRadioButton(DAPBeanInterface.CONSUMER);
		rdbtnConsumer.setActionCommand(DAPBeanInterface.CONSUMER);
		upper_panel.add(rdbtnConsumer, commonGUI.setContraints(GridBagConstraints.VERTICAL,GridBagConstraints.WEST,5, 20, 5, 5, 2, 0));
		
		rdbtnConsumer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioGroupMarket.getSelection().getActionCommand().equals(sessionStandard.getCurrent_market())){
					sessionStandard.setCurrent_market(radioGroupMarket.getSelection().getActionCommand());
				}
			}
		});
	}
	
	private void setRadioButtonCorporate(){
		rdbtnCorporate = new JRadioButton(DAPBeanInterface.CORPORATE);
		rdbtnCorporate.setActionCommand(DAPBeanInterface.CORPORATE);
		upper_panel.add(rdbtnCorporate, commonGUI.setContraints(GridBagConstraints.VERTICAL,GridBagConstraints.WEST, 5, 20, 5, 5, 3, 0));
		
		rdbtnCorporate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioGroupMarket.getSelection().getActionCommand().equals(sessionStandard.getCurrent_market())){
					sessionStandard.setCurrent_market(radioGroupMarket.getSelection().getActionCommand());
				}
			}
		});
	}
	
	private void setRadioButtonPrepaid(){
		rdbtnPrepaid = new JRadioButton(DAPBeanInterface.PREPAID);
		rdbtnPrepaid.setActionCommand(DAPBeanInterface.PREPAID);
		upper_panel.add(rdbtnPrepaid, commonGUI.setContraints(GridBagConstraints.VERTICAL,GridBagConstraints.WEST,5, 20, 5, 5, 2, 1));
		
		rdbtnPrepaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioGroupCtype.getSelection().getActionCommand().equals(sessionStandard.getCurrent_ctype())){
					sessionStandard.setCurrent_ctype(radioGroupCtype.getSelection().getActionCommand());
				}
			}
		});
	}
	
	private void setRadioButtonPostpaid(){
		rdbtnPostpaid = new JRadioButton(DAPBeanInterface.POSTPAID);
		rdbtnPostpaid.setActionCommand(DAPBeanInterface.POSTPAID);
		upper_panel.add(rdbtnPostpaid, commonGUI.setContraints(GridBagConstraints.VERTICAL,GridBagConstraints.WEST,5, 20, 5, 5, 3, 1));
		
		rdbtnPostpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!radioGroupCtype.getSelection().getActionCommand().equals(sessionStandard.getCurrent_ctype())){
					sessionStandard.setCurrent_ctype(radioGroupCtype.getSelection().getActionCommand());
				}
			}
		});
	}
	
	private void setRadioGroupMarket(){
		radioGroupMarket = new ButtonGroup();
		radioGroupMarket.add(rdbtnConsumer);
		radioGroupMarket.add(rdbtnCorporate);
		
		if (sessionStandard.getCurrent_market().equals(DAPBeanInterface.CONSUMER)) {
			radioGroupMarket.setSelected(rdbtnConsumer.getModel(), true);
		}
		else if(sessionStandard.getCurrent_market().equals(DAPBeanInterface.CORPORATE)){
			radioGroupMarket.setSelected(rdbtnCorporate.getModel(), true);
		}
	}
	
	
	private void setRadioGroupCtype(){
		radioGroupCtype = new ButtonGroup();
		radioGroupCtype.add(rdbtnPrepaid);
		radioGroupCtype.add(rdbtnPostpaid);
		
		if (sessionStandard.getCurrent_ctype().equals(DAPBeanInterface.PREPAID)) {
			radioGroupCtype.setSelected(rdbtnPrepaid.getModel(), true);
		}
		else if(sessionStandard.getCurrent_ctype().equals(DAPBeanInterface.POSTPAID)){
			radioGroupCtype.setSelected(rdbtnPostpaid.getModel(), true);
		}
	}
	
	private void setProgressBar(){
		progressBar = new JProgressBar();
		progressBar.setVisible(false);
		upper_panel.add(progressBar, commonGUI.setContraints(GridBagConstraints.BASELINE, GridBagConstraints.CENTER, 5, 20, 5, 0, 5, 0));
	}

	private void setAccountGroupIdLabel(){
		JLabel lblAccountGroupId = new JLabel("Account group id");
		upper_panel.add(lblAccountGroupId, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 15, 25, 5, 5, 0, 1));
		
	}
	
	private void setServiceClassLabel(){
		JLabel lblServiceClass = new JLabel("Service class");
		upper_panel.add(lblServiceClass, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 8, 25, 5, 5, 0, 2));
	}
	
	private void setServiceOfferingsLabel(){
		JLabel lblServiceOfferings = new JLabel("Service offerings");
		upper_panel.add(lblServiceOfferings, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 8, 25, 5, 5, 0, 3));
	}
	
	private void setLanguageLabel() {
		JLabel lblLanguageId = new JLabel("Language id");
		upper_panel.add(lblLanguageId, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 8, 25, 5, 5, 0, 4));
	}

	private void setCommunityIdLabel() {
		JLabel lblCommunityIds = new JLabel("Community IDs");
		upper_panel.add(lblCommunityIds, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 8, 25, 5, 5, 0, 5));
	}

	private void setMainAccountLabel() {
		JLabel lblMainAccountBalance = new JLabel("Main Account balance");
		upper_panel.add(lblMainAccountBalance, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHEAST, 8, 25, 5, 5, 0, 6));
	}
	
	private void setAccountGroupIdLabelResponse(){
		lblAccountGroupIdResp = new JLabel("-");
		upper_panel.add(lblAccountGroupIdResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 15, 35, 5, 5, 1, 1));
    }
	
	private void setServiceClassLabelResponse(){
    	lblServiceClassResp = new JLabel("-");
		upper_panel.add(lblServiceClassResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 35, 5, 5, 1, 2));
    }
	
	private void setServiceOfferingsLabelResponse(){
    	lblServiceOfferingsResp = new JLabel("-");
		upper_panel.add(lblServiceOfferingsResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 35, 5, 5, 1, 3));
    }
    
	private void setServiceOfferingsDecimalLabelResponse(){
    	lblServiceOfferingsDecResp = new JLabel();
		upper_panel.add(lblServiceOfferingsDecResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 40, 5, 5, 2, 3));
    }
	
	private void setLanguageLabelResponse(){
    	lblLanguageIdResp = new JLabel("-");
		upper_panel.add(lblLanguageIdResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 35, 5, 5, 1, 4));
    }

	private void setCommunityIdLabelResponse(){
		lblCommunityIdsResp = new JLabel("-");
		upper_panel.add(lblCommunityIdsResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 35, 5, 5, 1, 5));
	}
	
	private void setMainAccountLabelReponse(){
		lblMainAccountBalanceResp = new JLabel("-");
		upper_panel.add(lblMainAccountBalanceResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.SOUTHWEST, 8, 35, 5, 5, 1, 6));
	}
    
	private void setViewButton(){
		btnView = new JButton("View");
		upper_panel.add(btnView, commonGUI.setContraints(5, 20, 5, 5, 4, 0));
		
		frame.getRootPane().setDefaultButton(btnView);
	    frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "none");
	    frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("released ENTER"), "press");
	}
	
	private void setTabbedPane(){
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		panel_center.add(tabbedPane, commonGUI.setContraintsFill(GridBagConstraints.BOTH, 0, 1));
	}
	
	private void setDedicatedAccountAccumulatorPanel(){
		panel_dedicated_account_accumulator = new JPanel();
		tabbedPane.addTab("Accounts & Accumulators", null, panel_dedicated_account_accumulator, null);
		
		GridBagLayout gbl_panel_account_accumulato = new GridBagLayout();
		gbl_panel_account_accumulato.columnWidths = new int[]{0, 0};
		gbl_panel_account_accumulato.rowHeights = new int[]{165, 165, 0};
		gbl_panel_account_accumulato.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_account_accumulato.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_dedicated_account_accumulator.setLayout(gbl_panel_account_accumulato);
	}
	
	private void setScrollAccumulator(){
		scrollPane_dedicated = new JScrollPane();
		panel_dedicated_account_accumulator.add(scrollPane_dedicated, commonGUI.setContraintsFill(GridBagConstraints.BOTH, 0, 0));
	}
	
	private void setScrollDedicatedAccount(){
		scrollPane_accumulator = new JScrollPane();
		panel_dedicated_account_accumulator.add(scrollPane_accumulator, commonGUI.setContraintsFill(GridBagConstraints.BOTH, 0, 1));
	}
	
	private void setDedicatedAccountTable(){
		table_dedicated = new JTable(new DedicatedModel());
		scrollPane_dedicated.setViewportView(table_dedicated);
	}
	
	private void setAccumulatorTable(){
		table_accumulator = new JTable(new AccumulatorModel());
		scrollPane_accumulator.setViewportView(table_accumulator);
	}
	
	private void setLifeCyclePanel(){
		panel_life_cycle = new JPanel();
		tabbedPane.addTab("Life Cycle date", null, panel_life_cycle, null);
		
		GridBagLayout gbl_panel_life_cycle = new GridBagLayout();
		gbl_panel_life_cycle.columnWidths = new int[]{0, 128, 0};
		gbl_panel_life_cycle.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_life_cycle.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_life_cycle.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_life_cycle.setLayout(gbl_panel_life_cycle);
	}
	
	private void setSimExpDateLabel(){
		JLabel lblSimExpiryDate = new JLabel("SIM expiry date");
		panel_life_cycle.add(lblSimExpiryDate, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 30, 15, 5, 5, 0, 0));
	}
	
	private void setSupExpLabel(){
		JLabel lblSupervisionExpiryDate = new JLabel("Supervision expiry date");
		panel_life_cycle.add(lblSupervisionExpiryDate, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 30, 15, 5, 5, 0, 1));
	}
	
	private void setAccountStateLabel(){
		JLabel lblAccountStatus = new JLabel("Account status");
		panel_life_cycle.add(lblAccountStatus, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 30, 15, 5, 5, 0, 2));
	}
	
	private void setSimExpDateLabelResponse(){
		lblSimExpiryDateResp = new JLabel("-");
		panel_life_cycle.add(lblSimExpiryDateResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 30, 35, 5, 0, 1, 0));
	}
	
	private void setSupExpLabelResponse(){
		lblSupervisionExpiryDateResp = new JLabel("-");
		panel_life_cycle.add(lblSupervisionExpiryDateResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 30, 35, 5, 0, 1, 1));
	}
	
	private void setAccountStateLabelResponse(){
		lblAccountStatusResp = new JLabel("-");
		panel_life_cycle.add(lblAccountStatusResp, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 30, 35, 5, 0, 1, 2));
	}
	
	private void setScrollFaf(){
		panel_faf = new JScrollPane();
		panel_faf.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Family and Friends", null, panel_faf, null);
	}
	
	private void setFafTable(){
		table_faf = new JTable(new FafModel());
		panel_faf.setViewportView(table_faf);
	}
	
	private void setScrollPromotion(){
		panel_promotion = new JScrollPane();
		panel_promotion.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Refill & Promotion", null, panel_promotion, null);
	}
	
	private void setPromotionTable(){
		table_promotion = new JTable(new PromotionModel());
		panel_promotion.setViewportView(table_promotion);
	}
	
	private void setScrollOfferId(){
		panel_offer = new JScrollPane();
		panel_offer.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("Offers", null, panel_offer, null);
	}
	
	private void setOfferIdTable(){
		table_offer = new JTable(new OfferModel());
		panel_offer.setViewportView(table_offer);
	}
	
	private void setScrollPam(){
		panel_pam = new JScrollPane();
		panel_pam.setViewportBorder(new EmptyBorder(0, 0, 0, 0));
		tabbedPane.addTab("PAM", null, panel_pam, null);
	}
	
	private void setPamTable(){
		table_pam = new JTable(new PAMModel());
		panel_pam.setViewportView(table_pam);
	}
	
	private void setShareAccountPanel(){
		panel_share_account = new JPanel();
		tabbedPane.addTab("Usage Counters and Thresholds", null, panel_share_account, null);
		
		GridBagLayout gbl_panel_share_account = new GridBagLayout();
		gbl_panel_share_account.columnWidths = new int[]{0, 0};
		gbl_panel_share_account.rowHeights = new int[]{0, 0, 0};
		gbl_panel_share_account.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_share_account.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_share_account.setLayout(gbl_panel_share_account);
	}
	
	private void setScrollUsageCounter(){
		scrollPane_uc = new JScrollPane();
		panel_share_account.add(scrollPane_uc, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 5, 5, 5, 0, 0));
	}
	
	private void setUsageCounterTable(){
		table_uc = new JTable(new ShareAccountModel("uc"));
		scrollPane_uc.setViewportView(table_uc);
	}
	
	private void setScrollUsageThreshold(){
		scrollPane_ut = new JScrollPane();
		panel_share_account.add(scrollPane_ut, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 5, 0, 5, 0, 1));			
	}
	
	private void setUsageThresholdTable(){
		table_ut = new JTable(new ShareAccountModel("ut"));
		scrollPane_ut.setViewportView(table_ut);
	}

	private void setServiceCodePanel(){
		panel_service_code = new JPanel();
		GridBagLayout gbl_panel_service_code = new GridBagLayout();
		gbl_panel_service_code.columnWidths = new int[]{0, 0};
		gbl_panel_service_code.rowHeights = new int[]{0, 0, 0};
		gbl_panel_service_code.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_service_code.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_service_code.setLayout(gbl_panel_service_code);
		tabbedPane.addTab("Service Code", null, panel_service_code, null);
	}
	
	private void setServiceCodeListScroll(){
		scrollPane_service_code_list = new JScrollPane();
		panel_service_code.add(scrollPane_service_code_list, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 0, 5, 0, 0, 0));
	}
	
	private void setServiceCodeDetailsScroll(){
		scrollPane_service_code_details = new JScrollPane();
		scrollPane_service_code_details.setColumnHeaderView(panel_service_code_details);
		panel_service_code.add(scrollPane_service_code_details, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 1, 2));
	}
	
	private void setSmartStartDatePanel(){
		smart_start_date_panel = new JPanel();
		GridBagLayout gbl_smart_start_date_panel = new GridBagLayout();
		gbl_smart_start_date_panel.columnWidths = new int[]{150, 0};
		gbl_smart_start_date_panel.rowHeights = new int[]{0, 0, 0};
		gbl_smart_start_date_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_smart_start_date_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		smart_start_date_panel.setLayout(gbl_smart_start_date_panel);
		
		JLabel smart_start_date_label = new JLabel("SMART RECHARGE");
		smart_start_date_field = new JLabel("-");
		smart_start_date_panel.add(smart_start_date_label, commonGUI.setContraints(GridBagConstraints.CENTER, 5, 0, 0, 0, 0, 0));
		smart_start_date_panel.add(smart_start_date_field, commonGUI.setContraints(GridBagConstraints.CENTER, 10, 0, 0, 0, 0, 1));
		panel_service_code.add(smart_start_date_panel, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 0, 5, 0, 1, 0));
	}
	
	private void setServiceCodeListTable(){
		table_service_code_list = new JTable(new ServiceCodeModel());
		scrollPane_service_code_list.setViewportView(table_service_code_list);
	}
	
	private void setServiceCodeDetailsPanel(){
		panel_service_code_details = new JPanel();
		GridBagLayout gbl_panel_service_code_details = new GridBagLayout();
		gbl_panel_service_code_details.columnWidths = new int[]{200, 200, 200, 0};
		gbl_panel_service_code_details.rowHeights = new int[]{0, 0, 0};
		gbl_panel_service_code_details.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_service_code_details.rowWeights = new double[]{0.0, 0.0, 1.0};
		panel_service_code_details.setLayout(gbl_panel_service_code_details);
		
		scrollPane_service_code_details.setColumnHeaderView(panel_service_code_details);
	}
	
	private void setServiceCodeIdLabel(){
		lblSCId_name = new JLabel("Service code ID");
		panel_service_code_details.add(lblSCId_name, commonGUI.setContraints(5, 0, 5, 5, 0, 0));
	}
	
	private void setServiceCodeFeePeriodLabel(){
		lblSCPeriod_name = new JLabel("Fee period");
		panel_service_code_details.add(lblSCPeriod_name, commonGUI.setContraints(5, 0, 5, 5, 1, 0));
	}
	
	private void setServiceCodeAmountLabel(){
		lblSCAmount_name = new JLabel("Fee amount");
		panel_service_code_details.add(lblSCAmount_name, commonGUI.setContraints(5, 0, 5, 5, 2, 0));
	}
	
	private void setServiceCodeIdLabelResponse(){
		lblSCId = new JLabel("-");
		panel_service_code_details.add(lblSCId, commonGUI.setContraints(5, 0, 5, 5, 0, 1));
	}
	
	private void setServiceCodeFeePeriodLabelResponse(){
		lblSCPeriod = new JLabel("-");
		panel_service_code_details.add(lblSCPeriod, commonGUI.setContraints(5, 0, 5, 5, 1, 1));
	}
	
	private void setServiceCodeAmountLabelResponse(){
		lblSCAmount = new JLabel("-");
		panel_service_code_details.add(lblSCAmount, commonGUI.setContraints(5, 0, 5, 5, 2, 1));
	}
	
	private void setOptionsPanel(){
		panel_options = new JPanel();
		GridBagLayout gbl_panel_options = new GridBagLayout();
		gbl_panel_options.columnWidths = new int[]{0, 0};
		gbl_panel_options.rowHeights = new int[]{165, 180, 0};
		gbl_panel_options.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_options.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_options.setLayout(gbl_panel_options);
	}
	
	private void setRopzListScroll(){
		scrollPane_ropz_list = new JScrollPane();
		panel_options.add(scrollPane_ropz_list, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 0, 5, 0, 0, 0));
	}
	
	private void setRopzDetailsScroll(){
		scrollPane_ropz_details = new JScrollPane();
		panel_options.add(scrollPane_ropz_details, commonGUI.setContraintsFill(GridBagConstraints.BOTH, 0, 1));
	}
	
	private void setRopzListTable(){
	
		table_list_ropz = new JTable(new ActiveOptionModel());
		scrollPane_ropz_list.setViewportView(table_list_ropz);
	
	}
	
	private void setRopzDetailsPanel(){
		panel_ropz_details = new JPanel();
		scrollPane_ropz_details.setViewportView(panel_ropz_details);
		GridBagLayout gbl_panel_ropz_details = new GridBagLayout();
		gbl_panel_ropz_details.columnWidths = new int[]{196, 0, 0, 0, 59, 0, 56, 0, 106, 105, 33, 33, 90, 67, 0};
		gbl_panel_ropz_details.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_ropz_details.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_ropz_details.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
		panel_ropz_details.setLayout(gbl_panel_ropz_details);
	}
	
	private void setRopzDescriptionLabel(){
		JLabel lblOptionncode_name = new JLabel("Description");
		panel_ropz_details.add(lblOptionncode_name, commonGUI.setContraints(0, 5, 5, 5, 0, 0));
	}
	
	private void setRopzServiceCodeLabel(){
		JLabel lblServiceCode_name = new JLabel("Service Code");
		panel_ropz_details.add(lblServiceCode_name, commonGUI.setContraints(0, 5, 5, 5, 1, 0));
	}
	
	private void setRopzDedicatedAccountLabel(){
		JLabel lblDedicatedAccount_name = new JLabel("Dedicated Account");
		panel_ropz_details.add(lblDedicatedAccount_name, commonGUI.setContraints(0, 5, 5, 5, 2, 0));
	}
	
	private void setRopzAccumulatorLabel(){
		JLabel lblAccumulator_name = new JLabel("Accumulator");
		panel_ropz_details.add(lblAccumulator_name, commonGUI.setContraints(0, 5, 5, 5, 3, 0));
	}
	
	private void setRopzOfferIdLabel(){
		JLabel lblOfferId_name = new JLabel("Offer Id");
		panel_ropz_details.add(lblOfferId_name, commonGUI.setContraints(0, 5, 5, 5, 4, 0));
	}
	
	private void setRopzCommunityIdLabel(){
		JLabel lblCommunityId_name = new JLabel("Community Id");
		panel_ropz_details.add(lblCommunityId_name, commonGUI.setContraints(0, 5, 5, 5, 5, 0));
	}
	
	private void setRopzFafLabel(){
		JLabel lblFaf_name = new JLabel("Faf");
		panel_ropz_details.add(lblFaf_name, commonGUI.setContraints(0, 5, 5, 5, 6, 0));
	}
	
	private void setRopzServiceOfferingsLabel(){
		JLabel lblServiceOffering_name = new JLabel("Service Offering");
		panel_ropz_details.add(lblServiceOffering_name, commonGUI.setContraints(0, 5, 5, 5, 7, 0));
	}
	
	private void setRopzPromotionPlanLabel(){
		JLabel lblPromotionPlan_name = new JLabel("Promotion Plan");
		panel_ropz_details.add(lblPromotionPlan_name, commonGUI.setContraints(0, 5, 5, 5, 8, 0));
	}
	
	private void setRopzAccountGroupIdLabel(){
		JLabel lblAccountGroup_name = new JLabel("Account Group");
		panel_ropz_details.add(lblAccountGroup_name, commonGUI.setContraints(0, 5, 5, 5, 9, 0));
	}
	
	private void setRopzUcLabel(){
		JLabel lblUc_name = new JLabel("UC");
		panel_ropz_details.add(lblUc_name, commonGUI.setContraints(0, 5, 5, 5, 10, 0));
	}
	
	private void setRopzUtLabel(){
		JLabel lblUt_name = new JLabel("UT");
		panel_ropz_details.add(lblUt_name, commonGUI.setContraints(0, 5, 5, 5, 11, 0));
	}
	
	private void setRopzRelatedLabel(){
		JLabel lblDiscount_name = new JLabel("Related to");
		panel_ropz_details.add(lblDiscount_name, commonGUI.setContraints(0, 5, 5, 5, 12, 0));
	}
	
	private void setRopzServiceCodeRelatedLabel(){
		JLabel lbl_Sc_Discount_name = new JLabel("Service Code");
		panel_ropz_details.add(lbl_Sc_Discount_name, commonGUI.setContraints(0, 0, 5, 0, 13, 0));
	}
	
	private void setRopzDescriptionLabelResponse(){
		lblOptionncode_value = new JLabel("-");
		panel_ropz_details.add(lblOptionncode_value, commonGUI.setContraints(0, 0, 5, 5, 0, 1));
	}
	
	private void setRopzServiceCodeLabelResponse(){
		lblServiceCode_value = new JLabel("-");
		lblServiceCode_2_value = new JLabel();
		
		panel_ropz_details.add(lblServiceCode_value, commonGUI.setContraints(0, 0, 5, 5, 1, 1));
		panel_ropz_details.add(lblServiceCode_2_value, commonGUI.setContraints(0, 0, 5, 5, 1, 2));
		
		details_service_code_list.add(lblServiceCode_value);
		details_service_code_list.add(lblServiceCode_2_value);
	}
	
	private void setRopzDedicatedAccountLabelResponse(){
		lblDedicatedAccount_value = new JLabel("-");
		lblDedicatedAccount_2_value = new JLabel();
		lblDedicatedAccount_3_value = new JLabel();
		
		panel_ropz_details.add(lblDedicatedAccount_value, commonGUI.setContraints(0, 0, 5, 5, 2, 1));
		panel_ropz_details.add(lblDedicatedAccount_2_value, commonGUI.setContraints(0, 0, 5, 5, 2, 2));
		panel_ropz_details.add(lblDedicatedAccount_3_value, commonGUI.setContraints(0, 0, 5, 5, 2, 3));
		
		details_dedicated_account_list.add(lblDedicatedAccount_value);
		details_dedicated_account_list.add(lblDedicatedAccount_2_value);
		details_dedicated_account_list.add(lblDedicatedAccount_3_value);
	}
	
	private void setRopzAccumulatorLabelResponse(){
		lblAccumulator_value = new JLabel("-");
		lblAccumulator_2_value = new JLabel();
		lblAccumulator_3_value = new JLabel();
		
		panel_ropz_details.add(lblAccumulator_value, commonGUI.setContraints(0, 0, 5, 5, 3, 1));
		panel_ropz_details.add(lblAccumulator_2_value, commonGUI.setContraints(0, 0, 5, 5, 3, 2));
		panel_ropz_details.add(lblAccumulator_3_value, commonGUI.setContraints(0, 0, 5, 5, 3, 3));
		
		details_accumulator_list.add(lblAccumulator_value);
		details_accumulator_list.add(lblAccumulator_2_value);
		details_accumulator_list.add(lblAccumulator_3_value);
	}
	
	private void setRopzOfferIdLabelResponse(){
		lblOfferId_value = new JLabel("-");
		lblOfferId_2_value = new JLabel();
		lblOfferId_3_value = new JLabel();

		panel_ropz_details.add(lblOfferId_value, commonGUI.setContraints(0, 0, 5, 5, 4, 1));
		panel_ropz_details.add(lblOfferId_2_value, commonGUI.setContraints(0, 0, 5, 5, 4, 2));
		panel_ropz_details.add(lblOfferId_3_value, commonGUI.setContraints(0, 0, 5, 5, 4, 3));
		
		details_offer_id_list.add(lblOfferId_value);
		details_offer_id_list.add(lblOfferId_2_value);
		details_offer_id_list.add(lblOfferId_3_value);
	}
	
	private void setRopzCommunityIdLabelResponse(){
		lblCommunityId_value = new JLabel("-");
		panel_ropz_details.add(lblCommunityId_value, commonGUI.setContraints(0, 0, 5, 5, 5, 1));
	}
	
	private void setRopzFafLabelResponse(){
		lblFaf_value = new JLabel("-");
		lblFaf_2_value = new JLabel();
		lblFaf_3_value = new JLabel();
		
		panel_ropz_details.add(lblFaf_value, commonGUI.setContraints(0, 0, 5, 5, 6, 1));
		panel_ropz_details.add(lblFaf_2_value, commonGUI.setContraints(0, 0, 5, 5, 6, 2));
		panel_ropz_details.add(lblFaf_3_value, commonGUI.setContraints(0, 0, 5, 5, 6, 3));
		
		details_faf_list.add(lblFaf_value);
		details_faf_list.add(lblFaf_2_value);
		details_faf_list.add(lblFaf_3_value);
	}
	
	private void setRopzServiceOfferingsLabelResponse(){
		lblServiceOffering_value = new JLabel("-");
		panel_ropz_details.add(lblServiceOffering_value, commonGUI.setContraints(0, 0, 5, 5, 7, 1));
	}
	
	private void setRopzPromotionPlanLabelResponse(){
		lblPromotionPlan_value = new JLabel("-");
		panel_ropz_details.add(lblPromotionPlan_value, commonGUI.setContraints(0, 0, 5, 5, 8, 1));
	}
	
	private void setRopzAccountGroupIdLabelResponse(){
		lblAccountGroup_value = new JLabel("-");
		panel_ropz_details.add(lblAccountGroup_value, commonGUI.setContraints(0, 0, 5, 5, 9, 1));
	}
	
	private void setRopzUcLabelResponse(){
		lblUc_value = new JLabel("-");
		lblUc_2_value = new JLabel();
		lblUc_3_value = new JLabel();
		
		panel_ropz_details.add(lblUc_value, commonGUI.setContraints(0, 0, 5, 5, 10, 1));
		panel_ropz_details.add(lblUc_2_value, commonGUI.setContraints(0, 0, 5, 5, 10, 2));
		panel_ropz_details.add(lblUc_3_value, commonGUI.setContraints(0, 0, 5, 5, 10, 3));
		
		details_uc_list.add(lblUc_value);
		details_uc_list.add(lblUc_2_value);
		details_uc_list.add(lblUc_3_value);
	}
	
	private void setRopzUtLabelResponse(){
		lblUt_value = new JLabel("-");
		lblUt_2_value = new JLabel();
		lblUt_3_value = new JLabel();
		
		panel_ropz_details.add(lblUt_value, commonGUI.setContraints(0, 0, 5, 5, 11, 1));
		panel_ropz_details.add(lblUt_2_value, commonGUI.setContraints(0, 0, 5, 5, 11, 2));
		panel_ropz_details.add(lblUt_3_value, commonGUI.setContraints(0, 0, 5, 5, 11, 3));
		
		details_ut_list.add(lblUt_value);
		details_ut_list.add(lblUt_2_value);
		details_ut_list.add(lblUt_3_value);
	}
	
	private void setDiscountsListLabelResponse(){
		JLabel label_discount_1 = new JLabel("-");
		GridBagConstraints gbc_label_discount_1 = new GridBagConstraints();
		gbc_label_discount_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_1.gridx = 12;
		gbc_label_discount_1.gridy = 1;
		panel_ropz_details.add(label_discount_1, gbc_label_discount_1);
		
		JLabel label_discount_2 = new JLabel();
		GridBagConstraints gbc_label_discount_2 = new GridBagConstraints();
		gbc_label_discount_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_2.gridx = 12;
		gbc_label_discount_2.gridy = 2;
		panel_ropz_details.add(label_discount_2, gbc_label_discount_2);
		
		JLabel label_discount_3 = new JLabel();
		GridBagConstraints gbc_label_discount_3 = new GridBagConstraints();
		gbc_label_discount_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_3.gridx = 12;
		gbc_label_discount_3.gridy = 3;
		panel_ropz_details.add(label_discount_3, gbc_label_discount_3);
		
		JLabel label_discount_4 = new JLabel();
		GridBagConstraints gbc_label_discount_4 = new GridBagConstraints();
		gbc_label_discount_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_4.gridx = 12;
		gbc_label_discount_4.gridy = 4;
		panel_ropz_details.add(label_discount_4, gbc_label_discount_4);
		
		JLabel label_discount_5 = new JLabel();
		GridBagConstraints gbc_label_discount_5 = new GridBagConstraints();
		gbc_label_discount_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_5.gridx = 12;
		gbc_label_discount_5.gridy = 5;
		panel_ropz_details.add(label_discount_5, gbc_label_discount_5);
		
		JLabel label_discount_6 = new JLabel();
		GridBagConstraints gbc_label_discount_6 = new GridBagConstraints();
		gbc_label_discount_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_6.gridx = 12;
		gbc_label_discount_6.gridy = 6;
		panel_ropz_details.add(label_discount_6, gbc_label_discount_6);
		
		JLabel label_discount_7 = new JLabel();
		GridBagConstraints gbc_label_discount_7 = new GridBagConstraints();
		gbc_label_discount_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_7.gridx = 12;
		gbc_label_discount_7.gridy = 7;
		panel_ropz_details.add(label_discount_7, gbc_label_discount_7);
		
		JLabel label_discount_8 = new JLabel();
		GridBagConstraints gbc_label_discount_8 = new GridBagConstraints();
		gbc_label_discount_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_8.gridx = 12;
		gbc_label_discount_8.gridy = 8;
		panel_ropz_details.add(label_discount_8, gbc_label_discount_8);
		
		JLabel label_discount_9 = new JLabel();
		GridBagConstraints gbc_label_discount_9 = new GridBagConstraints();
		gbc_label_discount_9.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_9.gridx = 12;
		gbc_label_discount_9.gridy = 9;
		panel_ropz_details.add(label_discount_9, gbc_label_discount_9);
		
		JLabel label_discount_10 = new JLabel();
		GridBagConstraints gbc_label_discount_10 = new GridBagConstraints();
		gbc_label_discount_10.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_10.gridx = 12;
		gbc_label_discount_10.gridy = 10;
		panel_ropz_details.add(label_discount_10, gbc_label_discount_10);
		
		JLabel label_discount_11 = new JLabel();
		GridBagConstraints gbc_label_discount_11 = new GridBagConstraints();
		gbc_label_discount_11.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_11.gridx = 12;
		gbc_label_discount_11.gridy = 11;
		panel_ropz_details.add(label_discount_11, gbc_label_discount_11);
		
		JLabel label_discount_12 = new JLabel();
		GridBagConstraints gbc_label_discount_12 = new GridBagConstraints();
		gbc_label_discount_12.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_12.gridx = 12;
		gbc_label_discount_12.gridy = 12;
		panel_ropz_details.add(label_discount_12, gbc_label_discount_12);
		
		JLabel label_discount_13 = new JLabel();
		GridBagConstraints gbc_label_discount_13 = new GridBagConstraints();
		gbc_label_discount_13.insets = new Insets(0, 0, 5, 5);
		gbc_label_discount_13.gridx = 12;
		gbc_label_discount_13.gridy = 12;
		panel_ropz_details.add(label_discount_13, gbc_label_discount_13);
		
		details_discount_list.add(label_discount_1);	
		details_discount_list.add(label_discount_2);	
		details_discount_list.add(label_discount_3);	
		details_discount_list.add(label_discount_4);	
		details_discount_list.add(label_discount_5);	
		details_discount_list.add(label_discount_6);	
		details_discount_list.add(label_discount_7);	
		details_discount_list.add(label_discount_8);	
		details_discount_list.add(label_discount_9);	
		details_discount_list.add(label_discount_10);	
		details_discount_list.add(label_discount_11);	
		details_discount_list.add(label_discount_12);	
		details_discount_list.add(label_discount_13);
	}
	
	private void setServiceCodeDiscountsLabelResponse(){
		JLabel label_sc_discount_1 = new JLabel("-");
		GridBagConstraints gbc_label_sc_discount_1 = new GridBagConstraints();
		gbc_label_sc_discount_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_1.gridx = 13;
		gbc_label_sc_discount_1.gridy = 1;
		panel_ropz_details.add(label_sc_discount_1, gbc_label_sc_discount_1);
		
		JLabel label_sc_discount_2 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_2 = new GridBagConstraints();
		gbc_label_sc_discount_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_2.gridx = 13;
		gbc_label_sc_discount_2.gridy = 2;
		panel_ropz_details.add(label_sc_discount_2, gbc_label_sc_discount_2);
		
		JLabel label_sc_discount_3 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_3 = new GridBagConstraints();
		gbc_label_sc_discount_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_3.gridx = 13;
		gbc_label_sc_discount_3.gridy = 3;
		panel_ropz_details.add(label_sc_discount_3, gbc_label_sc_discount_3);
		
		JLabel label_sc_discount_4 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_4 = new GridBagConstraints();
		gbc_label_sc_discount_4.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_4.gridx = 13;
		gbc_label_sc_discount_4.gridy = 4;
		panel_ropz_details.add(label_sc_discount_4, gbc_label_sc_discount_4);
		
		JLabel label_sc_discount_5 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_5 = new GridBagConstraints();
		gbc_label_sc_discount_5.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_5.gridx = 13;
		gbc_label_sc_discount_5.gridy = 5;
		panel_ropz_details.add(label_sc_discount_5, gbc_label_sc_discount_5);
		
		JLabel label_sc_discount_6 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_6 = new GridBagConstraints();
		gbc_label_sc_discount_6.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_6.gridx = 13;
		gbc_label_sc_discount_6.gridy = 6;
		panel_ropz_details.add(label_sc_discount_6, gbc_label_sc_discount_6);
		
		JLabel label_sc_discount_7 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_7 = new GridBagConstraints();
		gbc_label_sc_discount_7.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_7.gridx = 13;
		gbc_label_sc_discount_7.gridy = 7;
		panel_ropz_details.add(label_sc_discount_7, gbc_label_sc_discount_7);
		
		JLabel label_sc_discount_8 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_8 = new GridBagConstraints();
		gbc_label_sc_discount_8.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_8.gridx = 13;
		gbc_label_sc_discount_8.gridy = 8;
		panel_ropz_details.add(label_sc_discount_8, gbc_label_sc_discount_8);
		
		JLabel label_sc_discount_9 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_9 = new GridBagConstraints();
		gbc_label_sc_discount_9.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_9.gridx = 13;
		gbc_label_sc_discount_9.gridy = 9;
		panel_ropz_details.add(label_sc_discount_9, gbc_label_sc_discount_9);
		
		JLabel label_sc_discount_10 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_10 = new GridBagConstraints();
		gbc_label_sc_discount_10.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_10.gridx = 13;
		gbc_label_sc_discount_10.gridy = 10;
		panel_ropz_details.add(label_sc_discount_10, gbc_label_sc_discount_10);
		
		
		JLabel label_sc_discount_11 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_11 = new GridBagConstraints();
		gbc_label_sc_discount_11.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_11.gridx = 13;
		gbc_label_sc_discount_11.gridy = 11;
		panel_ropz_details.add(label_sc_discount_11, gbc_label_sc_discount_11);
		
		JLabel label_sc_discount_12 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_12 = new GridBagConstraints();
		gbc_label_sc_discount_12.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_12.gridx = 13;
		gbc_label_sc_discount_12.gridy = 12;
		panel_ropz_details.add(label_sc_discount_12, gbc_label_sc_discount_12);
		
		JLabel label_sc_discount_13 = new JLabel();
		GridBagConstraints gbc_label_sc_discount_13 = new GridBagConstraints();
		gbc_label_sc_discount_13.insets = new Insets(0, 0, 5, 0);
		gbc_label_sc_discount_13.gridx = 13;
		gbc_label_sc_discount_13.gridy = 12;
		panel_ropz_details.add(label_sc_discount_13, gbc_label_sc_discount_13);
		
		details_service_code_discount_list.add(label_sc_discount_1);
		details_service_code_discount_list.add(label_sc_discount_2);
		details_service_code_discount_list.add(label_sc_discount_3);
		details_service_code_discount_list.add(label_sc_discount_4);
		details_service_code_discount_list.add(label_sc_discount_5);
		details_service_code_discount_list.add(label_sc_discount_6);
		details_service_code_discount_list.add(label_sc_discount_7);
		details_service_code_discount_list.add(label_sc_discount_8);
		details_service_code_discount_list.add(label_sc_discount_9);
		details_service_code_discount_list.add(label_sc_discount_10);
		details_service_code_discount_list.add(label_sc_discount_11);
		details_service_code_discount_list.add(label_sc_discount_12);
		details_service_code_discount_list.add(label_sc_discount_13);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JTextField getTxtMsisdn() {
		return txtMsisdn;
	}

	public JButton getBtnView() {
		return btnView;
	}

	public JTable getTable_faf() {
		return table_faf;
	}

	public JTable getTable_promotion() {
		return table_promotion;
	}

	public JTable getTable_offer() {
		return table_offer;
	}

	public JTable getTable_pam() {
		return table_pam;
	}

	public JTable getTable_list_ropz() {
		return table_list_ropz;
	}

	public JTable getTable_dedicated() {
		return table_dedicated;
	}

	public JTable getTable_accumulator() {
		return table_accumulator;
	}

	public JTable getTable_uc() {
		return table_uc;
	}

	public JTable getTable_ut() {
		return table_ut;
	}

	public JTable getTable_service_code_list() {
		return table_service_code_list;
	}

	public JLabel getLblSimExpiryDateResp() {
		return lblSimExpiryDateResp;
	}

	public JLabel getLblSupervisionExpiryDateResp() {
		return lblSupervisionExpiryDateResp;
	}

	public JLabel getLblAccountStatusResp() {
		return lblAccountStatusResp;
	}

	public JLabel getLblAccountGroupIdResp() {
		return lblAccountGroupIdResp;
	}

	public JLabel getLblServiceClassResp() {
		return lblServiceClassResp;
	}

	public JLabel getLblServiceOfferingsResp() {
		return lblServiceOfferingsResp;
	}

	public JLabel getLblServiceOfferingsDecResp() {
		return lblServiceOfferingsDecResp;
	}

	public JLabel getLblLanguageIdResp() {
		return lblLanguageIdResp;
	}

	public JLabel getLblCommunityIdsResp() {
		return lblCommunityIdsResp;
	}

	public JLabel getLblMainAccountBalanceResp() {
		return lblMainAccountBalanceResp;
	}

	public ButtonGroup getRadioGroupMarket() {
		return radioGroupMarket;
	}
	
	public ButtonGroup getRadioGroupCtype() {
		return radioGroupCtype;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public int[] getTabs_flags() {
		return tabs_flags;
	}

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public ActivatedSubscriberResourceInterface getSubscriber_resource() {
		return subscriber_resource;
	}

	public JLabel getLblOptionncode_value() {
		return lblOptionncode_value;
	}

	public JLabel getLblServiceCode_value() {
		return lblServiceCode_value;
	}

	public JLabel getLblServiceCode_2_value() {
		return lblServiceCode_2_value;
	}

	public JLabel getLblDedicatedAccount_value() {
		return lblDedicatedAccount_value;
	}

	public JLabel getLblDedicatedAccount_2_value() {
		return lblDedicatedAccount_2_value;
	}

	public JLabel getLblDedicatedAccount_3_value() {
		return lblDedicatedAccount_3_value;
	}

	public JLabel getLblAccumulator_value() {
		return lblAccumulator_value;
	}

	public JLabel getLblAccumulator_2_value() {
		return lblAccumulator_2_value;
	}

	public JLabel getLblAccumulator_3_value() {
		return lblAccumulator_3_value;
	}

	public JLabel getLblOfferId_value() {
		return lblOfferId_value;
	}

	public JLabel getLblOfferId_2_value() {
		return lblOfferId_2_value;
	}

	public JLabel getLblOfferId_3_value() {
		return lblOfferId_3_value;
	}

	public JLabel getLblCommunityId_value() {
		return lblCommunityId_value;
	}

	public JLabel getLblFaf_value() {
		return lblFaf_value;
	}

	public JLabel getLblFaf_2_value() {
		return lblFaf_2_value;
	}

	public JLabel getLblFaf_3_value() {
		return lblFaf_3_value;
	}

	public JLabel getLblServiceOffering_value() {
		return lblServiceOffering_value;
	}

	public JLabel getLblPromotionPlan_value() {
		return lblPromotionPlan_value;
	}

	public JLabel getLblAccountGroup_value() {
		return lblAccountGroup_value;
	}

	public JLabel getLblUc_value() {
		return lblUc_value;
	}

	public JLabel getLblUc_2_value() {
		return lblUc_2_value;
	}

	public JLabel getLblUc_3_value() {
		return lblUc_3_value;
	}

	public JLabel getLblUt_value() {
		return lblUt_value;
	}

	public JLabel getLblUt_2_value() {
		return lblUt_2_value;
	}

	public JLabel getLblUt_3_value() {
		return lblUt_3_value;
	}

	public List<JLabel> getDetails_service_code_list() {
		return details_service_code_list;
	}

	public List<JLabel> getDetails_dedicated_account_list() {
		return details_dedicated_account_list;
	}

	public List<JLabel> getDetails_accumulator_list() {
		return details_accumulator_list;
	}

	public List<JLabel> getDetails_offer_id_list() {
		return details_offer_id_list;
	}

	public List<JLabel> getDetails_faf_list() {
		return details_faf_list;
	}

	public List<JLabel> getDetails_uc_list() {
		return details_uc_list;
	}

	public List<JLabel> getDetails_ut_list() {
		return details_ut_list;
	}

	public List<JLabel> getDetails_discount_list() {
		return details_discount_list;
	}

	public List<JLabel> getDetails_service_code_discount_list() {
		return details_service_code_discount_list;
	}

	public JLabel getLblSCId_name() {
		return lblSCId_name;
	}

	public JLabel getLblSCPeriod_name() {
		return lblSCPeriod_name;
	}

	public JLabel getLblSCAmount_name() {
		return lblSCAmount_name;
	}

	public JLabel getLblSCId() {
		return lblSCId;
	}

	public JLabel getLblSCPeriod() {
		return lblSCPeriod;
	}

	public JLabel getLblSCAmount() {
		return lblSCAmount;
	}
	
	public ActionGetResourcesInterface getGet_resources() {
		return get_resources;
	}
	
	public JLabel getSmart_start_date_field() {
		return smart_start_date_field;
	}

	public void setConnectionWarning(AllResourceNotificationConnectionWarningInterface connectionWarning) {
		this.connectionWarning = connectionWarning;
	}

	public void setUtil(AllResourceUtilInterface util) {
		this.util = util;
	}

	public void setGet_resources(ActionGetResourcesInterface get_resources) {
		this.get_resources = get_resources;
	}
}