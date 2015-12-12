package com.innovery.mpm.subscriber.implementations.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;
import com.innovery.mpm.connection.interfaces.util.UserLevelsInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.interfaces.gui.SubscriberInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberAssuranceInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberDataServiceVerificationInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberFeeDiscountVerificationInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberResponseManagerInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberTariffPlanInterface;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberUtilInterface;
import com.innovery.mpm.subscriber.interfaces.gui.verification.SubscriberVerifyInterface;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComboBox;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 * 
 */
public class Subscriber implements SubscriberInterface {
	
	private JFrame frame;
	
	private JPanel responseFieldsetPanel;
	private JPanel executeDetailsPanel;
	private JPanel responseFieldsetGridPanel;
	private JPanel centerPanel;
	private JPanel commandFieldsetPanel;
	private JPanel assuranceRadioPanel;
	private JPanel lineStateRadioPanel;
	private JPanel saveBalanceRadioPanel;
	private JPanel nationalPanel;
	private JPanel internationalPanel;

	private JTextField msisdnField;
	private JTextField amountField;
	private JTextField expiryDateField;
	private JTextField nationalField;
	private JTextField internationalField;
	private JTextField dataServicesField;
	private JTextField feediscountField;
	private JTextField feedelayField;
	private JTextField amountIdField;
	private JTextField dayField;
	private JTextField monthField;
	private JTextField preferentialListField;
	private JTextField msisdnNewField;
	private JTextField msisdnNewRefillField;

	private JLabel msisdnLabel;
	private JLabel marketLabel;
	private JLabel tariffPlanLabel;
	private JLabel actionOnChangeLabel;
	private JLabel lineStateLabel;
	private JLabel saveBalanceLabel;
	private JLabel amountLabel;
	private JLabel expiryDateLabel;
	private JLabel nationalLabel;
	private JLabel internationalLabel;
	private JLabel dataServiceLabel;
	private JLabel feediscountLabel;
	private JLabel feedelayLabel;
	private JLabel amountIdLabel;
	private JLabel assuranceLabel;
	private JLabel refillTypeLabel;
	private JLabel ctypeLabel;
	private JLabel dayLabel;
	private JLabel monthLabel;
	private JLabel preferentialListLabel;
	private JLabel msisdnNewLabel;
	private JLabel msisdnNewRefillLabel;
	private JLabel channelLabel;
	
	private JButton btnExecute;
	private JButton button_details;
	
	private JRadioButton rdbtnAssuranceAmount;
	private JRadioButton rdbtnAssuranceProfile;
	private JRadioButton rdbtnAssuranceDataService;
	private JRadioButton rdbtnAssuranceTariffplan;
	private JRadioButton rdbtnAssuranceBillcycle;
	private JRadioButton rdbtnCreate;
	private JRadioButton rdbtnDelete;
	private JRadioButton rdbtnGet;
	private JRadioButton rdbtnChange;
	private JRadioButton rdbtnConsumer;
	private JRadioButton rdbtnCorporate;
	private JRadioButton rdbtnPrepaid;
	private JRadioButton rdbtnPostpaid;
	private JRadioButton rdbtnLineActive;
	private JRadioButton rdbtnLineSuspend;
	private JRadioButton rdbtnSaveBalanceOn;
	private JRadioButton rdbtnSaveBalanceOff;

	private JTextArea textArea;
	
	private ButtonGroup actionButtonGroup;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private ButtonGroup assuranceButtonGroup;
	private ButtonGroup lineStateButtonGroup;
	private ButtonGroup saveBalanceButtonGroup;
	private ButtonGroup nationalButtonGroup;
	private ButtonGroup internationalButtonGroup;
	
	private JComboBox tariffPlanComboboxSelection;
	private JComboBox refillTypeComboboxSelection;
	private JComboBox changeComboboxSelection;
	private JComboBox actionOnChangeComboboxSelection;
	private JComboBox channelComboboxSelection;
	
	private JCheckBox nationalSuspendCheckButton;
	private JCheckBox internationalSuspendCheckButton;
	
	boolean unactiveNatCC_state = false;
	boolean unactiveIntCC_state = false;

	private String[] tariffPlanOption;
	
	private Logger log;
	private SessionStandardInterface sessionStandard;
	private GUICommonInterface commonGUI;
	private UserLevelsInterface userLevels;
	private AutoCompleteMsisdnInterface autocompleteMsisdn;
	
	private SubscriberUtilInterface util;
	private SubscriberTariffPlanInterface tariffPlanManager;
	private SubscriberResponseManagerInterface responseManager;
	private SubscriberAssuranceInterface assuranceManager;
	private SubscriberFeeDiscountVerificationInterface feeDiscountManager;
	private SubscriberDataServiceVerificationInterface dataServiceManager;
	private SubscriberVerifyInterface subscriberVerifier;
	
	@Override
	public void initialize() {
		setFrameInitialSettings();

		setPanelNorth();
		setPanelSouth();
		setPanelWest();
		setPanelEast();
		setPanelCenter();
		
		setPanelCommand();
		
		rdbtnCreate = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE);
		rdbtnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnCreate.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CREATE);
				util.commonActionOnActionRadioButton();
				util.actionOnCType();
			}
		});

		rdbtnDelete = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE);
		rdbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnDelete.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_DELETE);
				util.commonActionOnActionRadioButton();
			}
		});

		rdbtnGet = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET);
		rdbtnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnGet.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET);
				util.commonActionOnActionRadioButton();
				util.actionOnCType();
			}
		});

		rdbtnChange = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG);
		rdbtnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnChange.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG);
				util.commonActionOnActionRadioButton();
				util.actionOnCType();
				
			}
		});
	
		setActionLabel();
		setRadioActionPanel();
		setRadioActionGroup();

		changeComboboxSelection = new JComboBox(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT);
		changeComboboxSelection.setPrototypeDisplayValue("*****************");
		changeComboboxSelection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				util.actionOnChangeCombo();
			}
		});
		
		setAccountChangeComboLayout();
		
		setMsisdnLabel();
		setMsisdnText();
		
		tariffPlanComboboxSelection = new JComboBox(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT);
		setTariffPlanLabel();
		setTariffPlanCombo();
		
		setPreferentialListLabel();
		setPreferentialListText();
		
		setMsisdnNewLabel();
		setMsisdnNewText();
		setMsisdnNewRefillLabel();
		setMsisdnNewRefillText();
		
		setDayLabel();
		setDayText();
		setMonthLabel();
		setMonthText();
		
		rdbtnLineActive = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_LINESTATE_ACTIVE);
		rdbtnLineActive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLineActive.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_LINESTATE_ACTIVE);
			}
		});
		
		rdbtnLineSuspend = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_LINESTATE_SUSPEND);
		rdbtnLineSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnLineSuspend.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_LINESTATE_SUSPEND);
			}
		});
		
		setLineStateLabel();
		setRadioLineStatePanel();
		setRadioLineStateGroup();
		
		actionOnChangeComboboxSelection = new JComboBox(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT);
		actionOnChangeComboboxSelection.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (actionOnChangeComboboxSelection.getSelectedIndex()!=0) {
					
					if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
						if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_BILL_CYCLE)
						||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE)
						||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE)
						||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILL_CYCLE)){
							
							dayLabel.setVisible(false);
							dayField.setText("");
							dayField.setVisible(false);
							
							if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILLCYCLE_COMBO)){
								actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_BILL_CYCLE);
								
								dayLabel.setText(commonGUI.mandatory(dayLabel.getText()));
								dayLabel.setVisible(true);
								dayField.setVisible(true);
							}
							
							else if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILLCYCLE_COMBO)){
								actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_BILL_CYCLE);
								dayLabel.setVisible(true);
								dayLabel.setText(commonGUI.optional(dayLabel.getText()));
								dayField.setVisible(true);
							}
							
							else if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILLCYCLE_COMBO)){
								actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_BILL_CYCLE);
								dayLabel.setVisible(false);
								dayField.setVisible(false);
							}
						}
								
						else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DISCOUNT)
						||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT)
						||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT)){
							
							feediscountField.setText("");
							feediscountLabel.setText(commonGUI.optional(feediscountLabel.getText()));
							feedelayLabel.setText(commonGUI.optional(feedelayLabel.getText()));
							
							feediscountLabel.setText(commonGUI.mandatory(feediscountLabel.getText()));
							feediscountLabel.setVisible(true);
							feediscountField.setVisible(true);
							
							if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT_COMBO)){
								actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DISCOUNT);
								feedelayLabel.setVisible(true);
								
								feedelayField.setVisible(true);
								feedelayField.setEnabled(false);
							}
							
							else if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT_COMBO)){
								actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DISCOUNT);
								
								feedelayLabel.setVisible(false);
								feedelayField.setVisible(false);
								feedelayField.setEnabled(false);
							}
						}
					}

					if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG_DATASERVICES)
							||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATA_SERVICE)
							||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATA_SERVICE)
							||actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATA_SERVICE)){
						if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATASERVICE_COMBO)){
							actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_SET_DATA_SERVICE);
						}
						
						else if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATASERVICE_COMBO)){
							actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_ADD_DATA_SERVICE);
							
						}
						
						else if(((String) actionOnChangeComboboxSelection.getSelectedItem()).equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATASERVICE_COMBO)){
							actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_DEL_DATA_SERVICE);
						}
						
						dataServiceLabel.setText(commonGUI.mandatory(dataServiceLabel.getText()));
						dataServiceLabel.setVisible(true);
						dataServicesField.setVisible(true);
					}
				}
				
				else {
					
					if(rdbtnChange.isSelected()){
						actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_CHG);
					}
					
					dayLabel.setVisible(false);
					dayField.setVisible(false);
					
					feediscountLabel.setVisible(false);
					feediscountField.setVisible(false);
					feedelayLabel.setVisible(false);
					feedelayField.setVisible(false);
					feedelayField.setEnabled(false);
					
					dataServiceLabel.setVisible(false);
					dataServicesField.setVisible(false);
				}
			}
		});
		
		
		channelComboboxSelection = new JComboBox(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT);
		setUnblockChannelLabel();
		setUnblockChannelCombo();
		
		
		setActionComboOnChangeLabel();
		setActionComboOnChangeCombo();
		
		rdbtnSaveBalanceOn = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_SAVEBALANCE_ON);
		rdbtnSaveBalanceOn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSaveBalanceOn.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_SAVEBALANCE_ON);
			}
		});
		
		rdbtnSaveBalanceOff = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_SAVEBALANCE_OFF);
		rdbtnSaveBalanceOff.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSaveBalanceOff.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_SAVEBALANCE_OFF);
			}
		});
		
		setSaveBalanceLabel();
		setRadioSaveBalancePanel();
		setRadioSaveBalanceGroup();
		
		refillTypeComboboxSelection = new JComboBox(SUBSCRIBERActions.SUBSCRIBER_OPTION_COMBO_DEFAULT);
		setRefillTypeCombo();
		setRefillTypeLabel();

		setAmountLabel();
		setAmountText();

		setExpiryDateLabel();
		setExpiryDateText();

		nationalSuspendCheckButton = new JCheckBox(SUBSCRIBERActions.SUBSCRIBER_ACTION_UNBLOCK_LABEL);
		nationalSuspendCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!unactiveNatCC_state){
					nationalSuspendCheckButton.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_UNBLOCK);
					unactiveNatCC_state = true;
				}
				else{
					nationalButtonGroup.clearSelection();
					unactiveNatCC_state = false;
				}
			}
		});
		
		setNationalCCLabel();
		setNationalCCText();
		setRadioNationalCCPanel();
		setRadionNationalGroup();

		internationalSuspendCheckButton = new JCheckBox(SUBSCRIBERActions.SUBSCRIBER_ACTION_UNBLOCK_LABEL);
		internationalSuspendCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!unactiveIntCC_state){
					internationalSuspendCheckButton.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_UNBLOCK);
					unactiveIntCC_state = true;
				}
				else{
					internationalButtonGroup.clearSelection();
					unactiveIntCC_state = false;
				}
			}
		});
		
		setInternationalCCLabel();
		setInternationalCCText();
		setRadioInternationalCCPanel();
		setRadioInternationalCCGroup();
		
		setDataServiceLabel();
		setDataServiceText();
		
		setFeediscountLabel();
		setFeediscountText();
		
		setFeedelayLabel();
		setFeedelayText();

		rdbtnAssuranceAmount = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT);
		rdbtnAssuranceAmount.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT);
		rdbtnAssuranceAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assuranceManager.showAssuranceAmount();
				actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT);
			}
		});

		rdbtnAssuranceProfile = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE);
		rdbtnAssuranceProfile.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE);
		rdbtnAssuranceProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assuranceManager.showAssuranceProfile();
				actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE);
			}
		});

		rdbtnAssuranceDataService = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES);
		rdbtnAssuranceDataService.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES);
		rdbtnAssuranceDataService.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assuranceManager.showAssuranceDataServices();
				actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES);
			}
		});
		
		rdbtnAssuranceTariffplan = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN);
		rdbtnAssuranceTariffplan.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN);
		rdbtnAssuranceTariffplan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assuranceManager.showAssuranceTariffPlan();
				actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN);
			}
		});
		
		rdbtnAssuranceBillcycle = new JRadioButton(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE);
		rdbtnAssuranceBillcycle.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE);
		rdbtnAssuranceBillcycle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				assuranceManager.showAssuranceBillCycle();
				actionButtonGroup.getSelection().setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE);
			}
		});
		
		setAssuranceLabel();
		setRadioAssurancePanel();
		setRadioAssuranceGroup();
		
		setAmountIdsLabel();
		setAmountIdsText();

		setPanelResponse();
		setRespondeFieldComponents();
		
		rdbtnConsumer = new JRadioButton(DAPBeanInterface.CONSUMER);
		rdbtnConsumer.setActionCommand(DAPBeanInterface.CONSUMER);
		rdbtnConsumer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnConsumer.setActionCommand(DAPBeanInterface.CONSUMER);
				util.resetAssuranceActionOnMarketCtypeChange();
				util.resetChangeCombo();
				util.actionOnCType();
			}
		});
		
		rdbtnCorporate = new JRadioButton(DAPBeanInterface.CORPORATE);
		rdbtnCorporate.setActionCommand(DAPBeanInterface.CORPORATE);
		rdbtnCorporate.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				rdbtnCorporate.setActionCommand(DAPBeanInterface.CORPORATE);
				util.resetAssuranceActionOnMarketCtypeChange();
				util.resetChangeCombo();
				util.actionOnCType();
			}
		});
		
		setMarketLabel();
		setRadioMarketPanel();
		setRadioMarketGroup();
		
		rdbtnPrepaid = new JRadioButton(DAPBeanInterface.PREPAID);
		rdbtnPrepaid.setActionCommand(DAPBeanInterface.PREPAID);
		rdbtnPrepaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPrepaid.setActionCommand(DAPBeanInterface.PREPAID);
				util.resetAssuranceActionOnMarketCtypeChange();
				util.resetChangeCombo();
				util.actionOnCType();
			}
		});
		
		rdbtnPostpaid = new JRadioButton(DAPBeanInterface.POSTPAID);
		rdbtnPostpaid.setActionCommand(DAPBeanInterface.POSTPAID);
		rdbtnPostpaid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnPostpaid.setActionCommand(DAPBeanInterface.POSTPAID);
				util.resetAssuranceActionOnMarketCtypeChange();
				util.resetChangeCombo();
				util.actionOnCType();
			}
		});
		
		setCtypeLabel();
		setRadioCTypePanel();
		setRadioCTypeGroup();
		
		if (sessionStandard.getCurrent_market()!=null && !sessionStandard.getCurrent_market().equals("") && marketButtonGroup.getSelection()!=null) {
			if(sessionStandard.getCurrent_ctype()!=null && !sessionStandard.getCurrent_ctype().equals("") && ctypeButtonGroup.getSelection()!=null){
				tariffPlanOption = tariffPlanManager.compileTariffPlanComboBox(marketButtonGroup.getSelection().getActionCommand(), ctypeButtonGroup.getSelection().getActionCommand());
				tariffPlanComboboxSelection.setModel(new DefaultComboBoxModel(tariffPlanOption));
			}
		}
		
		setButtonAccess();
		
		setButtonDetails();
		setButtonExecute();
		
		setSubscriberUtilClass();
		setSubscriberTariffPlanClass();
		setSubscriberAssuranceClass();
		
		util.hideAll();
		util.clearAll();
		
		frame.setVisible(true);
	}

	private void setFrameInitialSettings(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(1190, 700);
		frame.setTitle(APLICATION_TITLE);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "none");
		frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("released ENTER"), "press");
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				frame.dispose();
			}
		});
	}
	
	private void setPanelNorth(){
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout_north = (FlowLayout) panel_north.getLayout();
		flowLayout_north.setVgap(5);
		JLabel title_label = new JLabel(PAGE_TITLE);
		title_label.setFont(commonGUI.setFontSize(18));
		panel_north.add(title_label);
		frame.getContentPane().add(panel_north, BorderLayout.NORTH);
	}

	private void setPanelSouth(){
		JPanel panel_south = new JPanel();
		GridBagLayout gbl_panel_south = new GridBagLayout();
		gbl_panel_south.columnWidths = new int[] { 0, 0 };
		gbl_panel_south.rowHeights = new int[] { 16, 0 };
		gbl_panel_south.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_south.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_south.setLayout(gbl_panel_south);
		JLabel devByLabel = new JLabel();
		devByLabel.setText(COPYRIGHT);
		devByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		devByLabel.setForeground(Color.DARK_GRAY);
		devByLabel.setFont(commonGUI.setFontSize(Font.BOLD, 11));
		panel_south.add(devByLabel, commonGUI.setContraints(5, 0, 3, 0, 0, 0));
		frame.getContentPane().add(panel_south, BorderLayout.SOUTH);
	}
	
	private void setPanelWest(){
		JPanel panel_west = new JPanel();
		FlowLayout flowLayout_west = (FlowLayout) panel_west.getLayout();
		flowLayout_west.setHgap(10);
		frame.getContentPane().add(panel_west, BorderLayout.WEST);
	}
	
	private void setPanelEast(){
		JPanel panel_east = new JPanel();
		FlowLayout flowLayout_east = (FlowLayout) panel_east.getLayout();
		flowLayout_east.setHgap(10);
		frame.getContentPane().add(panel_east, BorderLayout.EAST);
	}
	
	private void setPanelCenter(){
		centerPanel = new JPanel();
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[] { 711, 0 };
		gbl_panel_center.rowHeights = new int[] { 628, 0 };
		gbl_panel_center.columnWeights = new double[] { 0.0, 1.0 };
		gbl_panel_center.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		centerPanel.setLayout(gbl_panel_center);
		frame.getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	private void setPanelCommand(){
		commandFieldsetPanel = new JPanel();
		commandFieldsetPanel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), PANEL_LEFT_TITLE, TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 13), null));
		GridBagLayout gbl_command_fieldset = new GridBagLayout();
		gbl_command_fieldset.columnWidths = new int[] {183, 300, 130};
		gbl_command_fieldset.rowHeights = new int[] { 22, 0, 0, 0, 0, 0, 0,	0, 0, 0, 0, 0, 22, 22, 0, 0 };
		gbl_command_fieldset.columnWeights = new double[] { 0.0, 0.0, 1.0};
		gbl_command_fieldset.rowWeights = new double[] { 0.0, 0.0, 0.0,	0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		commandFieldsetPanel.setLayout(gbl_command_fieldset);
		centerPanel.add(commandFieldsetPanel, commonGUI.setContraints(GridBagConstraints.BOTH, 5, 0, 5, 5, 0, 0));
	}
	
	private void setPanelResponse(){
		responseFieldsetPanel = new JPanel();
		responseFieldsetPanel.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), PANEL_RIGHT_TITLE, TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 13), null));
		GridBagLayout gbl_response_fieldset = new GridBagLayout();
		gbl_response_fieldset.columnWidths = new int[]{0, 0};
		gbl_response_fieldset.rowHeights = new int[] { 450, 0 };
		gbl_response_fieldset.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_response_fieldset.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		responseFieldsetPanel.setLayout(gbl_response_fieldset);
		centerPanel.add(responseFieldsetPanel, commonGUI.setContraints(GridBagConstraints.BOTH, 5, 0, 5, 0, 1, 0));
	}
	
	@Override
	public void resetResponseGrid(){
		responseFieldsetPanel.remove(responseFieldsetGridPanel);
		responseFieldsetPanel.validate();
		responseFieldsetPanel.repaint();
		setResponseFieldGrid();
		responseFieldsetPanel.validate();
		responseFieldsetPanel.repaint();
	}
	
	private void setRespondeFieldComponents(){
		setResponseFieldGrid();
		setExecuteDetailsPanel();
		setTextArea();
	}
	
	private void setResponseFieldGrid(){
		responseFieldsetGridPanel = new JPanel();
		GridBagLayout gbl_response_fieldset_grid = new GridBagLayout();
		gbl_response_fieldset_grid.columnWidths = new int[] {70, 110, 110, 0};
		gbl_response_fieldset_grid.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_response_fieldset_grid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_response_fieldset_grid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		responseFieldsetGridPanel.setLayout(gbl_response_fieldset_grid);
		responseFieldsetPanel.add(responseFieldsetGridPanel, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 0, 5, 0, 0, 0));
	}
	
	private void setExecuteDetailsPanel() {
		executeDetailsPanel = new JPanel();
		GridBagLayout gbl_execute_details_panel = new GridBagLayout();
		gbl_execute_details_panel.columnWidths = new int[] { 0, 0, 0 };
		gbl_execute_details_panel.rowHeights = new int[] { 0, 0 };
		gbl_execute_details_panel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_execute_details_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		executeDetailsPanel.setLayout(gbl_execute_details_panel);
		responseFieldsetPanel.add(executeDetailsPanel, commonGUI.setContraints(GridBagConstraints.BOTH, 0, 0, 5, 0, 0, 1));
	}
	
	private void setTextArea(){
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setVisible(false);
		textArea.setLineWrap(true);
		responseFieldsetPanel.add(textArea, commonGUI.setContraints(GridBagConstraints.BOTH, 5, 0, 5, 0, 0, 0));
	}
	
	private void setButtonDetails(){
		button_details = new JButton(MORE_BUTTON);
		button_details.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(textArea.isVisible()){
					textArea.setVisible(false);
					responseFieldsetGridPanel.setVisible(true);
					button_details.setText(MORE_BUTTON);
				}
				else{
					textArea.setVisible(true);
					responseFieldsetGridPanel.setVisible(false);
					button_details.setText(LESS_BUTTON);
				}
			}
		});
		executeDetailsPanel.add(button_details, commonGUI.setContraints(GridBagConstraints.CENTER, GridBagConstraints.EAST, 0, 0, 5, 0, 1, 0));
	}
	
	private void setActionLabel(){
		JLabel action_label = new JLabel("Action*");
		action_label.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(action_label, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 0));
	}
	
	private void setRadioActionPanel(){
		JPanel radioGroupAction_panel = new JPanel();
		commandFieldsetPanel.add(radioGroupAction_panel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 0));
		
		GroupLayout gl_radioGroupAction_panel = new GroupLayout(radioGroupAction_panel);
		gl_radioGroupAction_panel.setHorizontalGroup(
			gl_radioGroupAction_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupAction_panel.createSequentialGroup()
					.addComponent(rdbtnCreate)
					.addGap(20)
					.addComponent(rdbtnDelete)
					.addGap(20)
					.addComponent(rdbtnGet)
					.addGap(20)
					.addComponent(rdbtnChange)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupAction_panel.setVerticalGroup(
			gl_radioGroupAction_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupAction_panel.createSequentialGroup()
					.addGroup(gl_radioGroupAction_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnCreate)
						.addComponent(rdbtnDelete)
						.addComponent(rdbtnGet)
						.addComponent(rdbtnChange))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupAction_panel.setAutoCreateContainerGaps(true);
		radioGroupAction_panel.setLayout(gl_radioGroupAction_panel);
	}
	
	private void setRadioActionGroup(){
		actionButtonGroup = new ButtonGroup();
		actionButtonGroup.add(rdbtnCreate);
		actionButtonGroup.add(rdbtnDelete);
		actionButtonGroup.add(rdbtnGet);
		actionButtonGroup.add(rdbtnChange);
	}
	
	private void setAccountChangeComboLayout(){
		changeComboboxSelection.setEnabled(false);
		commandFieldsetPanel.add(changeComboboxSelection, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 0, 2, 0));
	}
	
	private void setMsisdnLabel(){
		msisdnLabel = new JLabel("Msisdn*");
		msisdnLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(msisdnLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 1));
	}
	
	private void setMsisdnText(){
		msisdnField = new JTextField();
		msisdnField.setColumns(10);
		msisdnField.setText(sessionStandard.getCurrent_msisdn());
		commandFieldsetPanel.add(msisdnField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 1));
		
		JComboBox msisdn_combo = autocompleteMsisdn.setupAutoComplete(msisdnField);
		msisdnField.setLayout(new BorderLayout());
		msisdnField.add(msisdn_combo, BorderLayout.SOUTH);
	}
	
	private void setMarketLabel(){
		marketLabel = new JLabel("Market*");
		marketLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(marketLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 2));
	}
	
	private void setRadioMarketPanel(){
		JPanel radioGroupMarket_panel = new JPanel();
		commandFieldsetPanel.add(radioGroupMarket_panel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 2));

		GroupLayout gl_radioGroupMarket_panel = new GroupLayout(radioGroupMarket_panel);
		gl_radioGroupMarket_panel.setHorizontalGroup(
			gl_radioGroupMarket_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupMarket_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnConsumer, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(rdbtnCorporate, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupMarket_panel.setVerticalGroup(
			gl_radioGroupMarket_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupMarket_panel.createSequentialGroup()
					.addGroup(gl_radioGroupMarket_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnConsumer)
						.addComponent(rdbtnCorporate))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupMarket_panel.setAutoCreateContainerGaps(true);
		radioGroupMarket_panel.setLayout(gl_radioGroupMarket_panel);
	}
	
	private void setRadioMarketGroup(){
		marketButtonGroup = new ButtonGroup();
		marketButtonGroup.add(rdbtnConsumer);
		marketButtonGroup.add(rdbtnCorporate);
		
		if (sessionStandard.getCurrent_market().equals(DAPBeanInterface.CONSUMER)) {
			rdbtnConsumer.setSelected(true);
			marketButtonGroup.getSelection().setActionCommand(DAPBeanInterface.CONSUMER);
		}
		else if(sessionStandard.getCurrent_market().equals(DAPBeanInterface.CORPORATE)){
			rdbtnCorporate.setSelected(true);
			marketButtonGroup.getSelection().setActionCommand(DAPBeanInterface.CORPORATE);
		}
	}
		
	private void setCtypeLabel(){
		ctypeLabel = new JLabel("Type*");
		commandFieldsetPanel.add(ctypeLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 3));
	}
	
	private void setRadioCTypePanel(){
		JPanel radioGroupCtype_panel = new JPanel();
		commandFieldsetPanel.add(radioGroupCtype_panel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 3));

		GroupLayout gl_radioGroupCtype_panel = new GroupLayout(radioGroupCtype_panel);
		gl_radioGroupCtype_panel.setHorizontalGroup(
			gl_radioGroupCtype_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupCtype_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnPrepaid, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(rdbtnPostpaid, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupCtype_panel.setVerticalGroup(
			gl_radioGroupCtype_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_radioGroupCtype_panel.createSequentialGroup()
					.addGroup(gl_radioGroupCtype_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPrepaid)
						.addComponent(rdbtnPostpaid))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_radioGroupCtype_panel.setAutoCreateContainerGaps(true);

		radioGroupCtype_panel.setLayout(gl_radioGroupCtype_panel);
	}
	
	private void setRadioCTypeGroup(){
		ctypeButtonGroup = new ButtonGroup();
		ctypeButtonGroup.add(rdbtnPrepaid);
		ctypeButtonGroup.add(rdbtnPostpaid);
		
		if (sessionStandard.getCurrent_ctype().equals(DAPBeanInterface.PREPAID)) {
			rdbtnPrepaid.setSelected(true);
			ctypeButtonGroup.getSelection().setActionCommand(DAPBeanInterface.PREPAID);
		}
		else if(sessionStandard.getCurrent_ctype().equals(DAPBeanInterface.POSTPAID)){
			rdbtnPostpaid.setSelected(true);
			ctypeButtonGroup.getSelection().setActionCommand(DAPBeanInterface.POSTPAID);
		}
	}
	
	private void setTariffPlanLabel(){
		tariffPlanLabel = new JLabel("Tariff Plan*");
		commandFieldsetPanel.add(tariffPlanLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 4));
	}
	
	private void setTariffPlanCombo(){
		tariffPlanComboboxSelection.setMaximumRowCount(6);
		tariffPlanComboboxSelection.setPrototypeDisplayValue("LIS0000");
		commandFieldsetPanel.add(tariffPlanComboboxSelection, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 4, 52));
	}
	
	private void setPreferentialListLabel(){
		preferentialListLabel = new JLabel("Community id*");
		commandFieldsetPanel.add(preferentialListLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 4));
	}

	private void setPreferentialListText(){
		preferentialListField = new JTextField();
		preferentialListField.setColumns(10);
		commandFieldsetPanel.add(preferentialListField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 4));
	}
	
	private void setMsisdnNewLabel(){
		msisdnNewLabel = new JLabel("Msisdn new*");
		commandFieldsetPanel.add(msisdnNewLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 4));
	}

	private void setMsisdnNewText(){
		msisdnNewField = new JTextField();
		msisdnNewField.setColumns(10);
		commandFieldsetPanel.add(msisdnNewField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 4));
	}
	
	private void setMsisdnNewRefillLabel(){
		msisdnNewRefillLabel = new JLabel("Refill");
		commandFieldsetPanel.add(msisdnNewRefillLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 5));
	}

	private void setMsisdnNewRefillText(){
		msisdnNewRefillField = new JTextField();
		msisdnNewRefillField.setColumns(10);
		commandFieldsetPanel.add(msisdnNewRefillField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 5));
	}
	
	private void setDayLabel(){
		dayLabel = new JLabel("Day");
		commandFieldsetPanel.add(dayLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 6));
	}

	private void setDayText(){
		dayField = new JTextField();
		dayField.setColumns(10);
		commandFieldsetPanel.add(dayField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 6));
	}
	
	private void setMonthLabel(){
		monthLabel = new JLabel("Month");
		commandFieldsetPanel.add(monthLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 7));
	}

	private void setMonthText(){
		monthField = new JTextField();
		monthField.setColumns(10);
		commandFieldsetPanel.add(monthField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 7));
	}
	
	private void setRefillTypeLabel(){
		refillTypeLabel = new JLabel("Refill type");
		refillTypeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(refillTypeLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 5));
	}

	private void setRefillTypeCombo(){
		refillTypeComboboxSelection.setModel(new DefaultComboBoxModel(SUBSCRIBERActions.SUBSCRIBER_REFILLTYPE_OPTION_LIST));
		refillTypeComboboxSelection.setMaximumRowCount(6);
		refillTypeComboboxSelection.setPrototypeDisplayValue("LIS0000");
		commandFieldsetPanel.add(refillTypeComboboxSelection, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 5, 52));
	}
	
	private void setAmountLabel(){
		amountLabel = new JLabel("Amount Value");
		amountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(amountLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 6));
	}

	private void setAmountText(){
		amountField = new JTextField();
		amountField.setColumns(10);
		commandFieldsetPanel.add(amountField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 6));
	}
	
	private void setLineStateLabel(){
		lineStateLabel = new JLabel("Line state*");
		commandFieldsetPanel.add(lineStateLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 4));
	}
	
	private void setDataServiceLabel(){
		dataServiceLabel = new JLabel("Data Services*");
		dataServiceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(dataServiceLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 9));
	}

	private void setDataServiceText(){
		dataServicesField = new JTextField();
		dataServicesField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				dataServiceManager.setDataServicesField(dataServicesField);
				dataServiceManager.verify();
			}
		});
		dataServicesField.setColumns(10);
		commandFieldsetPanel.add(dataServicesField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 9));
	}
	
	private void setActionComboOnChangeLabel(){
		actionOnChangeLabel = new JLabel("");
		commandFieldsetPanel.add(actionOnChangeLabel,	commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 4));
	}

	private void setActionComboOnChangeCombo(){
		actionOnChangeComboboxSelection.setPrototypeDisplayValue("LIS000");
		commandFieldsetPanel.add(actionOnChangeComboboxSelection, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 4, 52));
	}
	
	private void setSaveBalanceLabel(){
		saveBalanceLabel = new JLabel("Save balance");
		saveBalanceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(saveBalanceLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 5));
	}
	
	private void setExpiryDateLabel(){
		expiryDateLabel = new JLabel("Expiry date");
		expiryDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(expiryDateLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 6));
	}

	private void setExpiryDateText(){
		expiryDateField = new JTextField();
		expiryDateField.setColumns(10);
		commandFieldsetPanel.add(expiryDateField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 6));
	}
	
	private void setNationalCCLabel(){
		nationalLabel = new JLabel("Nat. cost control");
		nationalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(nationalLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 7));
	}
	
	private void setNationalCCText(){
		nationalField = new JTextField();
		nationalField.setColumns(10);
		commandFieldsetPanel.add(nationalField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 7));
	}
	
	private void setInternationalCCLabel(){
		internationalLabel = new JLabel("Int. cost control");
		internationalLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(internationalLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 8));
	}
	
	private void setInternationalCCText(){
		internationalField = new JTextField();
		internationalField.setColumns(10);
		commandFieldsetPanel.add(internationalField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 8));
	}
	
	private void setUnblockChannelLabel(){
		channelLabel = new JLabel("Channel");
		channelLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(channelLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 9));
	}
	
	private void setUnblockChannelCombo(){
		channelComboboxSelection.setMaximumRowCount(6);
		channelComboboxSelection.setPrototypeDisplayValue("LIS0000");
		commandFieldsetPanel.add(channelComboboxSelection, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 9, 52));
	}

	private void setFeediscountLabel(){
		feediscountLabel = new JLabel("Fee Discount");
		feediscountLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(feediscountLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 10));
	}
	private void setFeediscountText(){
		feediscountField = new JTextField();
		feediscountField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				feeDiscountManager.setFeediscountField(feediscountField);
				feeDiscountManager.setFeedelayField(feedelayField);
				feeDiscountManager.verify();
			}
		});
		feediscountField.setColumns(10);
		commandFieldsetPanel.add(feediscountField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 10));
	}

	private void setFeedelayLabel(){
		feedelayLabel = new JLabel("Fee Delay");
		feedelayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(feedelayLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 11));
	}

	private void setFeedelayText(){
		feedelayField = new JTextField();
		feedelayField.setText("0");
		feedelayField.setColumns(10);
		commandFieldsetPanel.add(feedelayField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 11));
	}
	
	private void setAssuranceLabel(){
		assuranceLabel = new JLabel("Assurance*");
		assuranceLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		commandFieldsetPanel.add(assuranceLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 12));
	}
	
	private void setAmountIdsLabel(){
		amountIdLabel = new JLabel("IDs*");
		commandFieldsetPanel.add(amountIdLabel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 5, 0, 5, 0, 13));
	}
	
	private void setAmountIdsText(){
		amountIdField = new JTextField();
		amountIdField.setText("0");
		commandFieldsetPanel.add(amountIdField, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 13));
		amountIdField.setColumns(10);
	}

	private void setRadioLineStatePanel(){
		lineStateRadioPanel = new JPanel();
		commandFieldsetPanel.add(lineStateRadioPanel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 4));

		GroupLayout gl_lineState_panel = new GroupLayout(lineStateRadioPanel);
		gl_lineState_panel.setHorizontalGroup(
			gl_lineState_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lineState_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnLineActive, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(rdbtnLineSuspend, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_lineState_panel.setVerticalGroup(
			gl_lineState_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_lineState_panel.createSequentialGroup()
					.addGroup(gl_lineState_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnLineActive)
						.addComponent(rdbtnLineSuspend))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_lineState_panel.setAutoCreateContainerGaps(true);
		lineStateRadioPanel.setLayout(gl_lineState_panel);
	}
	
	private void setRadioLineStateGroup(){
		lineStateButtonGroup = new ButtonGroup();
		lineStateButtonGroup.add(rdbtnLineActive);
		lineStateButtonGroup.add(rdbtnLineSuspend);
	}

	private void setRadioSaveBalancePanel(){
		saveBalanceRadioPanel = new JPanel();
		commandFieldsetPanel.add(saveBalanceRadioPanel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 5));
		
		GroupLayout gl_saveBalance_panel = new GroupLayout(saveBalanceRadioPanel);
		gl_saveBalance_panel.setAutoCreateGaps(true);
		gl_saveBalance_panel.setHorizontalGroup(
			gl_saveBalance_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveBalance_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnSaveBalanceOn, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addComponent(rdbtnSaveBalanceOff, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_saveBalance_panel.setVerticalGroup(
			gl_saveBalance_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_saveBalance_panel.createSequentialGroup()
					.addGroup(gl_saveBalance_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnSaveBalanceOn)
						.addComponent(rdbtnSaveBalanceOff))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_saveBalance_panel.setAutoCreateContainerGaps(true);
		saveBalanceRadioPanel.setLayout(gl_saveBalance_panel);
	}

	private void setRadioSaveBalanceGroup(){
		saveBalanceButtonGroup = new ButtonGroup();
		saveBalanceButtonGroup.add(rdbtnSaveBalanceOn);
		saveBalanceButtonGroup.add(rdbtnSaveBalanceOff);
	}
	
	private void setRadioNationalCCPanel(){
		nationalPanel = new JPanel();
		commandFieldsetPanel.add(nationalPanel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 7));
		
		GroupLayout gl_natCCGroup_panel = new GroupLayout(nationalPanel);
		gl_natCCGroup_panel.setHorizontalGroup(
			gl_natCCGroup_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_natCCGroup_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(nationalSuspendCheckButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(18))
		);
		gl_natCCGroup_panel.setVerticalGroup(
			gl_natCCGroup_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_natCCGroup_panel.createSequentialGroup()
					.addGroup(gl_natCCGroup_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(nationalSuspendCheckButton))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_natCCGroup_panel.setAutoCreateContainerGaps(true);
		nationalPanel.setLayout(gl_natCCGroup_panel);
	}
	private void setRadionNationalGroup(){
		nationalButtonGroup = new ButtonGroup();
		nationalButtonGroup.add(nationalSuspendCheckButton);
	}
	
	private void setRadioInternationalCCPanel(){
		internationalPanel = new JPanel();
		commandFieldsetPanel.add(internationalPanel, commonGUI.setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 0, 0, 0, 1, 8));

		GroupLayout gl_intCCGroup_panel = new GroupLayout(internationalPanel);
		gl_intCCGroup_panel.setHorizontalGroup(
			gl_intCCGroup_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_intCCGroup_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(internationalSuspendCheckButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addGap(18))
		);
		gl_intCCGroup_panel.setVerticalGroup(
			gl_intCCGroup_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_intCCGroup_panel.createSequentialGroup()
					.addGroup(gl_intCCGroup_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(internationalSuspendCheckButton, GroupLayout.PREFERRED_SIZE, 16, Short.MAX_VALUE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_intCCGroup_panel.setAutoCreateContainerGaps(true);
		internationalPanel.setLayout(gl_intCCGroup_panel);
	}
	
	private void setRadioInternationalCCGroup(){
		internationalButtonGroup = new ButtonGroup();
		internationalButtonGroup.add(internationalSuspendCheckButton);
	}
	
	private void setRadioAssurancePanel(){
		assuranceRadioPanel = new JPanel();
		commandFieldsetPanel.add(assuranceRadioPanel, commonGUI.setContraintsGridWidth(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 2, 5, 0, 0, 0, 1, 12));

		GroupLayout radioGroupAssurance_grid = new GroupLayout(
				assuranceRadioPanel);
		radioGroupAssurance_grid.setHorizontalGroup(
			radioGroupAssurance_grid.createParallelGroup(Alignment.LEADING)
				.addGroup(radioGroupAssurance_grid.createSequentialGroup()
					.addContainerGap()
					.addComponent(rdbtnAssuranceDataService, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(rdbtnAssuranceProfile, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(rdbtnAssuranceAmount, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(0)
					.addComponent(rdbtnAssuranceTariffplan, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(rdbtnAssuranceBillcycle, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					
					
					
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		radioGroupAssurance_grid.setVerticalGroup(
			radioGroupAssurance_grid.createParallelGroup(Alignment.LEADING)
				.addGroup(radioGroupAssurance_grid.createSequentialGroup()
					.addGroup(radioGroupAssurance_grid.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnAssuranceDataService)
						.addComponent(rdbtnAssuranceProfile)
						.addComponent(rdbtnAssuranceAmount)
						.addComponent(rdbtnAssuranceTariffplan)
						.addComponent(rdbtnAssuranceBillcycle)
						)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		radioGroupAssurance_grid.setAutoCreateContainerGaps(true);

		assuranceRadioPanel.setLayout(radioGroupAssurance_grid);
	}
	
	private void setRadioAssuranceGroup(){
		assuranceButtonGroup = new ButtonGroup();
		assuranceButtonGroup.add(rdbtnAssuranceProfile);
		assuranceButtonGroup.add(rdbtnAssuranceAmount);
		assuranceButtonGroup.add(rdbtnAssuranceDataService);
		assuranceButtonGroup.add(rdbtnAssuranceTariffplan);
		assuranceButtonGroup.add(rdbtnAssuranceBillcycle);
	}

	private void setButtonExecute(){
		btnExecute = new JButton(EXECUTE_BUTTON);
		btnExecute.setActionCommand(SUBSCRIBERActions.SUBSCRIBER_ACTION_EXECUTE);
		executeDetailsPanel.add(btnExecute, commonGUI.setContraints(GridBagConstraints.CENTER, GridBagConstraints.WEST, 0, 0, 5, 0, 0, 0));
		frame.getRootPane().setDefaultButton(btnExecute);
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExecute.setEnabled(false);
				if (btnExecute.getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_EXECUTE)) {
					setSubscriberVerificationClass();
					if (subscriberVerifier.verify_input()) {
						resetResponseGrid();
						Thread thread = new Thread(new Runnable() {
							public void run() {
								textArea.setText("Waiting for MPM response ..");
								try {
									Thread.sleep(100); // to give time for users
														// to
														// read
								} catch (InterruptedException e) {
									log.warn("Unable to sleep.");
								} finally {
									resetResponseGrid();
									setSubscriberResponseManagerClass();
									responseManager.getResponse();
								}
							}
						});
						thread.start();
					}
					else{
						btnExecute.setEnabled(true);
					}
				} else {
					resetResponseGrid();
					util.backButtonActionPerformed();
					btnExecute.setEnabled(true);
				}
			}
		});
	}
	
	private void setButtonAccess(){
		if (sessionStandard.getUser_level() != userLevels.getRoot()) {
			rdbtnCreate.setEnabled(false);
			rdbtnDelete.setEnabled(false);
			rdbtnChange.setEnabled(false);
			changeComboboxSelection.setEnabled(false);
		}
	}
	
	private void setSubscriberUtilClass(){
		util.setActionButtonGroup(actionButtonGroup);
		util.setMarketButtonGroup(marketButtonGroup);
		util.setCtypeButtonGroup(ctypeButtonGroup);
		util.setBtnExecute(btnExecute);
		util.setFrame(frame);
		util.setTextArea(textArea);
		util.setRdbtnGet(rdbtnGet);
		util.setChangeComboboxSelection(changeComboboxSelection);
		util.setAssuranceManager(assuranceManager);
		util.setMsisdnNewField(msisdnNewField);
		util.setMsisdnNewLabel(msisdnNewLabel);
		util.setMsisdnNewRefillField(msisdnNewRefillField);
		util.setMsisdnNewRefillLabel(msisdnNewRefillLabel);
		util.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		util.setTariffPlanLabel(tariffPlanLabel);
		util.setTariffPlanManager(tariffPlanManager);
		util.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
		util.setRefillTypeLabel(refillTypeLabel);
		util.setSaveBalanceLabel(saveBalanceLabel);
		util.setSaveBalancePanel(saveBalanceRadioPanel);
		util.setExpiryDateField(expiryDateField);
		util.setExpiryDateLabel(expiryDateLabel);
		util.setFeediscountField(feediscountField);
		util.setFeediscountLabel(feediscountLabel);
		util.setFeedelayField(feedelayField);
		util.setFeedelayLabel(feedelayLabel);
		util.setActionOnChangeLabel(actionOnChangeLabel);
		util.setActionOnChangeComboboxSelection(actionOnChangeComboboxSelection);
		util.setAmountField(amountField);
		util.setAmountLabel(amountLabel);
		util.setDayField(dayField);
		util.setDayLabel(dayLabel);
		util.setMonthField(monthField);
		util.setMonthLabel(monthLabel);
		util.setLineStateLabel(lineStateLabel);
		util.setLineStatePanel(lineStateRadioPanel);
		util.setNationalField(nationalField);
		util.setNationalLabel(nationalLabel);
		util.setNationalPanel(nationalPanel);
		util.setInternationalField(internationalField);
		util.setInternationalLabel(internationalLabel);
		util.setInternationalPanel(internationalPanel);
		util.setPreferentialListField(preferentialListField);
		util.setPreferentialListLabel(preferentialListLabel);
		util.setChannelLabel(channelLabel);
		util.setChannelComboboxSelection(channelComboboxSelection);
		util.setDataServicesLabel(dataServiceLabel);
		util.setDataServicesField(dataServicesField);
		util.setAssuranceLabel(assuranceLabel);
		util.setAssurancePanel(assuranceRadioPanel);
		util.setAmountIdLabel(amountIdLabel);
		util.setAmountIdField(amountIdField);
		util.setNationalButtonGroup(nationalButtonGroup);
		util.setInternationalButtonGroup(internationalButtonGroup);
		util.setMsisdnField(msisdnField);
		util.setRdbtnConsumer(rdbtnConsumer);
		util.setRdbtnCorporate(rdbtnCorporate);
		util.setRdbtnPrepaid(rdbtnPrepaid);
		util.setRdbtnPostpaid(rdbtnPostpaid);
		util.setSaveBalanceButtonGroup(saveBalanceButtonGroup);
		util.setLineStateButtonGroup(lineStateButtonGroup);
	}
	
	private void setSubscriberVerificationClass(){
		subscriberVerifier.setMsisdnField(msisdnField);
		subscriberVerifier.setMsisdnNewField(msisdnNewField);
		subscriberVerifier.setMsisdnNewRefillField(msisdnNewRefillField);
		subscriberVerifier.setActionButtonGroup(actionButtonGroup);
		subscriberVerifier.setMarketButtonGroup(marketButtonGroup);
		subscriberVerifier.setCtypeButtonGroup(ctypeButtonGroup);
		subscriberVerifier.setGetButtonGroup(assuranceButtonGroup);
		subscriberVerifier.setActionComboboxSelection(actionOnChangeComboboxSelection);
		subscriberVerifier.setNationalField(nationalField);
		subscriberVerifier.setInternationalField(internationalField);
		subscriberVerifier.setNationalButtonGroup(nationalButtonGroup);
		subscriberVerifier.setInternationalButtonGroup(internationalButtonGroup);
		subscriberVerifier.setChanelComboboxSelection(channelComboboxSelection);
		subscriberVerifier.setPreferentialList(preferentialListField);
		subscriberVerifier.setDataServicesField(dataServicesField);
		subscriberVerifier.setDayField(dayField);
		subscriberVerifier.setMonthField(monthField);
		subscriberVerifier.setFeediscountField(feediscountField);
		subscriberVerifier.setFeedelayField(feedelayField);
		subscriberVerifier.setLineStateButtonGroup(lineStateButtonGroup);
		subscriberVerifier.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
		subscriberVerifier.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		subscriberVerifier.setSaveBalanceButtonGroup(saveBalanceButtonGroup);
		subscriberVerifier.setAmountField(amountField);
		subscriberVerifier.setAmountIdField(amountIdField);
		subscriberVerifier.setExpiryDateField(expiryDateField);
	}
	
	private void setSubscriberResponseManagerClass(){
		responseManager.setMsisdnField(msisdnField);
		responseManager.setMsisdnNewField(msisdnNewField);
		responseManager.setMsisdnNewRefillField(msisdnNewRefillField);
		responseManager.setActionButtonGroup(actionButtonGroup);
		responseManager.setMarketButtonGroup(marketButtonGroup);
		responseManager.setCtypeButtonGroup(ctypeButtonGroup);
		responseManager.setNationalField(nationalField);
		responseManager.setInternationalField(internationalField);
		responseManager.setNationalButtonGroup(nationalButtonGroup);
		responseManager.setInternationalButtonGroup(internationalButtonGroup);
		responseManager.setChannelComboboxSelection(channelComboboxSelection);
		responseManager.setPreferentialList(preferentialListField);
		responseManager.setDataServicesField(dataServicesField);
		responseManager.setDayField(dayField);
		responseManager.setMonthField(monthField);
		responseManager.setFeediscountField(feediscountField);
		responseManager.setFeedelayField(feedelayField);
		responseManager.setLineStateButtonGroup(lineStateButtonGroup);
		responseManager.setRefillTypeComboboxSelection(refillTypeComboboxSelection);
		responseManager.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		responseManager.setSaveBalanceButtonGroup(saveBalanceButtonGroup);
		responseManager.setAmountField(amountField);
		responseManager.setAmountIdField(amountIdField);
		responseManager.setExpiryDateField(expiryDateField);
		responseManager.setBtnExecute(btnExecute);
		responseManager.setTextArea(textArea);
		responseManager.setResponseFieldsetPanel(responseFieldsetPanel);
		responseManager.setResponseFieldsetGridPanel(responseFieldsetGridPanel);
		responseManager.setFrame(frame);
	}
	
	private void setSubscriberTariffPlanClass(){
		tariffPlanManager.setMarketaButtonGroup(marketButtonGroup);
		tariffPlanManager.setCtypeButtonGroup(ctypeButtonGroup);
		tariffPlanManager.setTariffPlanComboboxSelection(tariffPlanComboboxSelection);
		tariffPlanManager.setTariffPlanList(tariffPlanOption);
	}
	
	private void setSubscriberAssuranceClass(){
		assuranceManager.setAmountIdField(amountIdField);
		assuranceManager.setAmountIdLabel(amountIdLabel);
		assuranceManager.setChangeComboboxSelection(changeComboboxSelection);
		assuranceManager.setMarketButtonGroup(marketButtonGroup);
		assuranceManager.setActionButtonGroup(assuranceButtonGroup);
		assuranceManager.setAssuranceButtonGroup(assuranceButtonGroup);
		assuranceManager.setRdbtnAssuranceAmount(rdbtnAssuranceAmount);
		assuranceManager.setRdbtnAssuranceTariffPlan(rdbtnAssuranceTariffplan);
		assuranceManager.setRdbtnAssuranceBillCycle(rdbtnAssuranceBillcycle);
		assuranceManager.setAssuranceLabel(assuranceLabel);
		assuranceManager.setAssurancePanel(assuranceRadioPanel);
	}
	
	
	
	@Override
	public JFrame getFrame() {
		return frame;
	}

	@Override
	public JButton getBtnExecute() {
		return btnExecute;
	}

	@Override
	public void setUtil(SubscriberUtilInterface util) {
		this.util = util;
	}

	@Override
	public void setTariffPlanManager(SubscriberTariffPlanInterface tariffPlanManager) {
		this.tariffPlanManager = tariffPlanManager;
	}

	@Override
	public void setResponseManager(SubscriberResponseManagerInterface responseManager) {
		this.responseManager = responseManager;
	}

	@Override
	public void setAssuranceManager(SubscriberAssuranceInterface assuranceManager) {
		this.assuranceManager = assuranceManager;
	}

	@Override
	public void setFeeDiscountManager(SubscriberFeeDiscountVerificationInterface feeDiscountManager) {
		this.feeDiscountManager = feeDiscountManager;
	}

	@Override
	public void setDataServiceManager(SubscriberDataServiceVerificationInterface dataServiceManager) {
		this.dataServiceManager = dataServiceManager;
	}

	@Override
	public void setSubscriberVerifier(SubscriberVerifyInterface subscriberVerifier) {
		this.subscriberVerifier = subscriberVerifier;
	}

	@Override
	public void setLog(Logger log) {
		this.log = log;
	}

	@Override
	public void setSessionStandard(SessionStandardInterface sessionStandard) {
		this.sessionStandard = sessionStandard;
	}

	@Override
	public void setCommonGUI(GUICommonInterface commonGUI) {
		this.commonGUI = commonGUI;
	}

	@Override
	public void setAutocompleteMsisdn(AutoCompleteMsisdnInterface autocompleteMsisdn) {
		this.autocompleteMsisdn = autocompleteMsisdn;
	}

	@Override
	public void setUserLevels(UserLevelsInterface userLevels) {
		this.userLevels = userLevels;
	}
}
