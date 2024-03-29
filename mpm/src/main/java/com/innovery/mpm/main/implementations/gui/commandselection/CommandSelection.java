package com.innovery.mpm.main.implementations.gui.commandselection;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import com.innovery.mpm.af.interfaces.AccountFinderInitializationInterface;
import com.innovery.mpm.allresource.interfaces.AllResourceInitializationInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.main.interfaces.gui.commandselection.CommandSelectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.AuthenticationPageInterface;
import com.innovery.mpm.option.interfaces.gui.OptionManagerInitializationInterface;
import com.innovery.mpm.provisioning.interfaces.BsoResourceInitializationInterface;
import com.innovery.mpm.resource.interfaces.AirResourceInitializationInterface;
import com.innovery.mpm.ssh.interfaces.SshResourceInitializationInterface;
import com.innovery.mpm.subscriber.interfaces.SubscriberInitializationInterface;

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
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class CommandSelection implements CommandSelectionInterface{
	
	private DAPBeanInterface rootComponents;
	
	private JFrame frame;
	private String remoteEvent;
	
	private AuthenticationPageInterface mainPage;
	
	private OptionManagerInitializationInterface optionManagment;
	private BsoResourceInitializationInterface provisioning;
	private AccountFinderInitializationInterface accountFinder;
	private AllResourceInitializationInterface allResource;
	private AirResourceInitializationInterface airResource;
	private SshResourceInitializationInterface sshResource;
	private SubscriberInitializationInterface subscriber;
	
	public CommandSelection(DAPBeanInterface rootComponents){
		this.rootComponents = rootComponents;
	}

	public void initialize() {
		frame = setFrame();
		frame.getContentPane().add(setPanelNorth(), BorderLayout.NORTH);
		frame.getContentPane().add(setPanelSouth(), BorderLayout.SOUTH);
		frame.getContentPane().add(setPanelWest(), BorderLayout.WEST);
		frame.getContentPane().add(setPanelEast(), BorderLayout.EAST);

		JPanel panel_center = setPanelCenter();
		JPanel bso_command_fieldset = setBsoCommandFieldset(panel_center);
		JPanel cai_command_fieldset = setCaiCommandFieldset(panel_center);
		JPanel all_resource_fieldset = setAllResourceFieldset(panel_center);
		JPanel option_management_fieldset = setOptionManagementFieldset(panel_center);

		JButton btnBsoCommand = setProvisioningButton(bso_command_fieldset);
		btnBsoCommand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rootComponents.getLogger().info("BSO RESOURCE PAGE SELECTED");
				
				provisioning.initialize();
				frame.setVisible(false);
				provisioning.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				provisioning.getBtnExecute().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						actionOnActiveFrameEvent();
					}
				});
			}
		});
		
		JButton btnSubscriberBso = setSubscriberButton(bso_command_fieldset);
		btnSubscriberBso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rootComponents.getLogger().info("BSO SUBSCRIBER PAGE SELECTED");
				
				subscriber.initialize();
				frame.setVisible(false);
				subscriber.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				subscriber.getBtnExecute().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						actionOnActiveFrameEvent();
					}
				});
			}
		});
		
		JButton btnAirSdp = setCaiCommandButton(cai_command_fieldset);
		btnAirSdp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rootComponents.getLogger().info("AIR RESOURCE PAGE SELECTED");
				
				airResource.initialize();
				frame.setVisible(false);
				airResource.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				airResource.getBtnExecute().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						actionOnActiveFrameEvent();
					}
				});
			}
		});
		
		JButton btnSSH = setSshButton(cai_command_fieldset);
		btnSSH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rootComponents.getLogger().info("SSH RESOURCE PAGE SELECTED");
				
				sshResource.initialize();
				frame.setVisible(false);
				sshResource.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				sshResource.getBtnExecute().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						actionOnActiveFrameEvent();
					}
				});
			}
		});
		
		JButton btnAccountFinder = setAfButton(cai_command_fieldset);
		btnAccountFinder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				rootComponents.getLogger().info("AF RESOURCE PAGE SELECTED");
				
				accountFinder.initialize();
				frame.setVisible(false);
				accountFinder.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				accountFinder.getBtnExecute().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						actionOnActiveFrameEvent();
					}
				});
			}
		});
		
		JButton btnAllResources = setAllResourcesButton(all_resource_fieldset);
		btnAllResources.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rootComponents.getLogger().info("ALL RESOURCES PAGE SELECTED");
				
				allResource.initialize();
				frame.setVisible(false);
				allResource.getFreme().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
				
				allResource.getBtnView().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						remoteEvent = e.getActionCommand();
						if(remoteEvent.equals("home")){
							actionOnActiveFrameEvent();
						}
					}
				});
			}
		});
		
		JButton btnOptionManagement = setOptionManagmentButton(option_management_fieldset);
		btnOptionManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rootComponents.getLogger().info("OPTION MANAGEMENT PAGE SELECTED");
				
				optionManagment.initialize();
				frame.setVisible(false);
				optionManagment.getFrame().addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						remoteEvent = "close";
						actionOnActiveFrameEvent();
					}
				});
			}
		});

		JButton btnDisconnect = setDisconnectButton(panel_center);
		btnDisconnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rootComponents.getLogger().info("CLIKED ON DISCONNECT.");
			    rootComponents.getConnectionManagerStandard().disconnectStandard();
				rootComponents.getConnectionManagerCai().disconnectCai();
				frame.dispose();
				mainPage.initialize();
			}
		});

		frame.setVisible(true);
	}

	private JFrame setFrame(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(400, 518);
		frame.setTitle("Dashboard Assurance Prepaid - Menu");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				UIManager.put("OptionPane.yesButtonText", "Yes!");
				UIManager.put("OptionPane.noButtonText", "No!");

				int answer = JOptionPane.showConfirmDialog(e.getWindow(),
						"Are you sure you want to close this window?",
						"Confirm close", JOptionPane.YES_NO_OPTION);
				if (answer == JOptionPane.YES_OPTION) {
					rootComponents.getConnectionManagerStandard().disconnectStandard();
					rootComponents.getConnectionManagerCai().disconnectCai();
					frame.dispose();
				}
			}
		});
		return frame;
	}
	
	private JPanel setPanelNorth(){
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout_north = (FlowLayout) panel_north.getLayout();
		flowLayout_north.setVgap(10);
		JLabel title_label = new JLabel("COMMAND TYPE SELECTION");
		panel_north.add(title_label);
		return panel_north;
	}
	
	private JPanel setPanelSouth(){
		JPanel panel_south = new JPanel();
		GridBagLayout gbl_panel_south = new GridBagLayout();
		gbl_panel_south.columnWidths = new int[]{0, 0};
		gbl_panel_south.rowHeights = new int[] {16, 0};
		gbl_panel_south.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_south.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_south.setLayout(gbl_panel_south);
		
		JLabel devByLabel = new JLabel();
		devByLabel.setText("- By Innovery S.p.A. -");
		devByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		devByLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_devByLabel = new GridBagConstraints();
		gbc_devByLabel.insets = new Insets(10, 0, 3, 0);
		gbc_devByLabel.gridx = 0;
		gbc_devByLabel.gridy = 0;
		panel_south.add(devByLabel, gbc_devByLabel);
		return panel_south;
	}
	
	private JPanel setPanelWest(){
		JPanel panel_west = new JPanel();
		FlowLayout flowLayout_west = (FlowLayout) panel_west.getLayout();
		flowLayout_west.setHgap(10);
		return panel_west;
	}
	
	private JPanel setPanelEast(){
		JPanel panel_east = new JPanel();
		FlowLayout flowLayout_east = (FlowLayout) panel_east.getLayout();
		flowLayout_east.setHgap(10);
		return panel_east;
	}
	
	private JPanel setPanelCenter(){
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{0, 0};
		gbl_panel_center.rowHeights = new int[]{55, 55, 30, 49, 0, 0, 0};
		gbl_panel_center.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		return panel_center;
	}
	
	private JPanel setBsoCommandFieldset(JPanel panel_center){
		JPanel bso_command_fieldset = new JPanel();
		bso_command_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "BSO COMMAND", TitledBorder.LEADING, TitledBorder.TOP, new Font("Euphemia", Font.BOLD, 11), null));
		GridBagConstraints gbc_bso_command_fieldset = new GridBagConstraints();
		gbc_bso_command_fieldset.fill = GridBagConstraints.BOTH;
		gbc_bso_command_fieldset.ipadx = 5;
		gbc_bso_command_fieldset.insets = new Insets(0, 0, 5, 0);
		gbc_bso_command_fieldset.gridx = 0;
		gbc_bso_command_fieldset.gridy = 0;
		GridBagLayout gbl_bso_command_fieldset = new GridBagLayout();
		gbl_bso_command_fieldset.columnWidths = new int[]{157, 0};
		gbl_bso_command_fieldset.rowHeights = new int[]{33, 0};
		gbl_bso_command_fieldset.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_bso_command_fieldset.rowWeights = new double[]{0.0, 0.0};
		bso_command_fieldset.setLayout(gbl_bso_command_fieldset);
		panel_center.add(bso_command_fieldset, gbc_bso_command_fieldset);
		return bso_command_fieldset;
	}
	
	private JPanel setCaiCommandFieldset(JPanel panel_center){
		JPanel cai_command_fieldset = new JPanel();
		cai_command_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "CAI COMMAND", TitledBorder.LEADING, TitledBorder.TOP, new Font("Euphemia", Font.BOLD, 11), null));
		GridBagConstraints gbc_cai_command_fieldset = new GridBagConstraints();
		gbc_cai_command_fieldset.insets = new Insets(10, 0, 5, 0);
		gbc_cai_command_fieldset.fill = GridBagConstraints.BOTH;
		gbc_cai_command_fieldset.gridx = 0;
		gbc_cai_command_fieldset.gridy = 1;
		GridBagLayout gbl_cai_command_fieldset = new GridBagLayout();
		gbl_cai_command_fieldset.columnWidths = new int[]{160, 0, 0};
		gbl_cai_command_fieldset.rowHeights = new int[]{0};
		gbl_cai_command_fieldset.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_cai_command_fieldset.rowWeights = new double[]{0.0};
		cai_command_fieldset.setLayout(gbl_cai_command_fieldset);
		panel_center.add(cai_command_fieldset, gbc_cai_command_fieldset);
		return cai_command_fieldset;
	}
	
	private JPanel setAllResourceFieldset(JPanel panel_center){
		JPanel all_resource_fieldset = new JPanel();
		all_resource_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "USER VIEW", TitledBorder.LEADING, TitledBorder.TOP, new Font("Euphemia", Font.BOLD, 11), null));
		GridBagConstraints gbc_all_resource_fieldset = new GridBagConstraints();
		gbc_all_resource_fieldset.insets = new Insets(10, 0, 5, 0);
		gbc_all_resource_fieldset.fill = GridBagConstraints.BOTH;
		gbc_all_resource_fieldset.gridx = 0;
		gbc_all_resource_fieldset.gridy = 2;
		GridBagLayout gbl_all_resource_fieldset = new GridBagLayout();
		gbl_all_resource_fieldset.columnWidths = new int[] {0};
		gbl_all_resource_fieldset.rowHeights = new int[] {0, 0};
		gbl_all_resource_fieldset.columnWeights = new double[]{1.0};
		gbl_all_resource_fieldset.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		all_resource_fieldset.setLayout(gbl_all_resource_fieldset);
		panel_center.add(all_resource_fieldset, gbc_all_resource_fieldset);
		return all_resource_fieldset;
	}
	
	private JPanel setOptionManagementFieldset(JPanel panel_center){
		JPanel option_management_fieldset = new JPanel();
		option_management_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "OPTION MANAGMENT", TitledBorder.LEADING, TitledBorder.TOP, new Font("Euphemia", Font.BOLD, 11), null));
		GridBagConstraints gbc_option_management_fieldset = new GridBagConstraints();
		gbc_option_management_fieldset.insets = new Insets(10, 0, 5, 0);
		gbc_option_management_fieldset.fill = GridBagConstraints.HORIZONTAL;
		gbc_option_management_fieldset.gridx = 0;
		gbc_option_management_fieldset.gridy = 3;
		panel_center.add(option_management_fieldset, gbc_option_management_fieldset);
		GridBagLayout gbl_option_management_fieldset = new GridBagLayout();
		gbl_option_management_fieldset.columnWidths = new int[]{155, 0};
		gbl_option_management_fieldset.rowHeights = new int[]{0, 0};
		gbl_option_management_fieldset.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_option_management_fieldset.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		option_management_fieldset.setLayout(gbl_option_management_fieldset);
		return option_management_fieldset;
	}
	
	private JButton setProvisioningButton(JPanel bso_command_fieldset){
		JButton btnBsoCommand = new JButton("PROVISIONING");
		GridBagConstraints gbc_btnBsoCommand = new GridBagConstraints();
		gbc_btnBsoCommand.ipadx = 42;
		gbc_btnBsoCommand.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBsoCommand.insets = new Insets(0, 0, 5, 0);
		gbc_btnBsoCommand.gridx = 0;
		gbc_btnBsoCommand.gridy = 0;
		bso_command_fieldset.add(btnBsoCommand, gbc_btnBsoCommand);
		return btnBsoCommand;
	}
	
	private JButton setSubscriberButton(JPanel bso_command_fieldset){
		JButton btnSubscriberBso = new JButton("SUBSCRIBER");
		GridBagConstraints gbc_btnSubscriberBso = new GridBagConstraints();
		gbc_btnSubscriberBso.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSubscriberBso.gridx = 0;
		gbc_btnSubscriberBso.gridy = 1;
		bso_command_fieldset.add(btnSubscriberBso, gbc_btnSubscriberBso);
		return btnSubscriberBso;
	}
	
	private JButton setCaiCommandButton(JPanel cai_command_fieldset){
		JButton btnAirSdp = new JButton("AIR/SDP");
		GridBagConstraints gbc_btnCaiCommand = new GridBagConstraints();
		gbc_btnCaiCommand.insets = new Insets(0, 0, 5, 5);
		gbc_btnCaiCommand.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCaiCommand.gridx = 0;
		gbc_btnCaiCommand.gridy = 0;
		cai_command_fieldset.add(btnAirSdp, gbc_btnCaiCommand);
		return btnAirSdp;
	}
	
	private JButton setSshButton(JPanel cai_command_fieldset){
		JButton btnSSH = new JButton("SSH");
		GridBagConstraints gbc_btnSSH = new GridBagConstraints();
		gbc_btnSSH.insets = new Insets(0, 0, 5, 5);
		gbc_btnSSH.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSSH.gridx = 0;
		gbc_btnSSH.gridy = 1;
		cai_command_fieldset.add(btnSSH, gbc_btnSSH);
		return btnSSH;
	}
	
	private JButton setAfButton(JPanel cai_command_fieldset){
		JButton btnAccountFinder = new JButton("ACCOUNT FINDER");
		GridBagConstraints gbc_btnAccountFinder = new GridBagConstraints();
		gbc_btnAccountFinder.insets = new Insets(0, 0, 0, 5);
		gbc_btnAccountFinder.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAccountFinder.gridx = 0;
		gbc_btnAccountFinder.gridy = 2;
		cai_command_fieldset.add(btnAccountFinder, gbc_btnAccountFinder);
		return btnAccountFinder;
	}
	
	private JButton setAllResourcesButton(JPanel all_resource_fieldset){
		JButton btnAllResources = new JButton("GET ALL RESOURCES");
		GridBagConstraints gbc_btnAllResources = new GridBagConstraints();
		gbc_btnAllResources.anchor = GridBagConstraints.WEST;
		gbc_btnAllResources.gridx = 0;
		gbc_btnAllResources.gridy = 0;
		all_resource_fieldset.add(btnAllResources, gbc_btnAllResources);
		return btnAllResources;
	}
	
	private JButton setOptionManagmentButton(JPanel option_management_fieldset){
		JButton btnOptionManagement = new JButton("OPTION MANAGMENT");
		GridBagConstraints gbc_btnOptionManagement = new GridBagConstraints();
		gbc_btnOptionManagement.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnOptionManagement.gridx = 0;
		gbc_btnOptionManagement.gridy = 0;
		option_management_fieldset.add(btnOptionManagement, gbc_btnOptionManagement);
		return btnOptionManagement;
	}
	
	private JButton setDisconnectButton(JPanel panel_center){
		JButton btnDisconnect = new JButton("Disconnect");
		GridBagConstraints gbc_btnDisconnect = new GridBagConstraints();
		gbc_btnDisconnect.insets = new Insets(5, 0, 0, 0);
		gbc_btnDisconnect.gridx = 0;
		gbc_btnDisconnect.gridy = 5;
		panel_center.add(btnDisconnect, gbc_btnDisconnect);
		return btnDisconnect;
	}
	
	private void actionOnActiveFrameEvent() {
		if (!remoteEvent.equals("")) {
			rootComponents.getLogger().info("EVENT:" + remoteEvent);
			if(remoteEvent.equals("home")){
				mainPage.initialize();
				rootComponents.getConnectionManagerStandard().disconnectStandard();
				rootComponents.getConnectionManagerCai().disconnectCai();
				frame.dispose();
			}
			
			else if (remoteEvent.equals("close")) {
				frame.setVisible(true);
				frame.repaint();
			}
		}
	}
	
	public void setMainPage(AuthenticationPageInterface mainPage) {
		this.mainPage = mainPage;
	}

	public void setProvisioning(BsoResourceInitializationInterface provisioning) {
		this.provisioning = provisioning;
	}

	public void setSubscriber(SubscriberInitializationInterface subscriber) {
		this.subscriber = subscriber;
	}

	public void setAirResource(AirResourceInitializationInterface airResource) {
		this.airResource = airResource;
	}

	public void setSshResource(SshResourceInitializationInterface sshResource) {
		this.sshResource = sshResource;
	}

	public void setAfResource(AccountFinderInitializationInterface accountFinder) {
		this.accountFinder = accountFinder;
	}

	public void setAllResource(AllResourceInitializationInterface allResource) {
		this.allResource = allResource;
	}

	public void setOptionManagment(OptionManagerInitializationInterface optionManagment) {
		this.optionManagment = optionManagment;
	}
}
