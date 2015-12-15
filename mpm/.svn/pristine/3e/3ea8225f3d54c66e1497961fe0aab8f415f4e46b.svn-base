package com.innovery.mpm.main.implementations.gui.mainpage;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.AuthenticationPageInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.connection.PageConnectionInterface;
import com.innovery.mpm.main.interfaces.gui.mainpage.util.ComboBoxManagerInterface;

import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class MainPage implements AuthenticationPageInterface{
	
	private static final String VERSION = "v.25.44.15.11.30";
	
	private JFrame frame;
	
	private JComboBox mpmSelect;
	private String[] mpmSelectElements;
	
	private JPanel panel_center;
	private JPanel param_fieldset;
	private JPanel login_fieldset;
	
	private JTextField ip_field;
	private JTextField port_field;
	private JTextField user_field;
	private JPasswordField password_field;
	
	private JButton button;
	
	private JLabel notification_label;
	
	private String source;
	
	private DAPBeanInterface rootComponents;
	private GUICommonInterface commonGUI;
	private ComboBoxManagerInterface combo;
	private AuthenticationPageInterface loginPage;
	private PageConnectionInterface connectionPage;

	public MainPage(DAPBeanInterface rootComponents) {
		this.rootComponents = rootComponents;
		commonGUI = rootComponents.getCommonGUI();
	}

	public void initialize() {
		setFrame();
		setPanelNorth();
		setPanelSouth();
		setPanelWest();
		setPanelEast();
		setPanelCenter();

		setMpmSelectCheckBox();
		
		setParametersFieldset();
		setLoginFieldset();
		
		setIpLabel();		
		setIpField();
		
		setPortLabel();	
		setPortField();
		
		setUserLabel();
		setLoginField();
		
		setPasswordLabel();
		setPasswordField();
		
		setVersionLabel();
		setNotificationLabel();
		
		setButton();
		
		frame.setVisible(true);
	}

	private void setFrame(){
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(320, 400);
		frame.setTitle("Dashboard Assurance Prepaid");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		frame.addWindowListener(new WindowAdapter() {
		   public void windowClosing(WindowEvent e) {
			     e.getWindow().dispose();
		   }
		  });
		frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "none");
	    frame.getRootPane().getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("released ENTER"), "press");
	}
	
	private void setPanelNorth(){
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout_north = (FlowLayout) panel_north.getLayout();
		flowLayout_north.setVgap(10);
		JLabel title_label = new JLabel("MPM CONNECTION AND LOGIN");
		panel_north.add(title_label);
		frame.getContentPane().add(panel_north, BorderLayout.NORTH);
	}
	
	private void setPanelSouth() {
		JPanel panel_south = new JPanel();

		GridBagLayout gbl_panel_south = new GridBagLayout();
		gbl_panel_south.columnWidths = new int[] { 143, 0 };
		gbl_panel_south.rowHeights = new int[] { 16, 0 };
		gbl_panel_south.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_south.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_south.setLayout(gbl_panel_south);

		JLabel devByLabel = new JLabel();
		devByLabel.setText("- By Innovery S.p.A. -");
		devByLabel.setHorizontalAlignment(SwingConstants.CENTER);
		devByLabel.setForeground(Color.DARK_GRAY);
		GridBagConstraints gbc_devByLabel = new GridBagConstraints();
		gbc_devByLabel.insets = new Insets(5, 0, 3, 0);
		gbc_devByLabel.gridx = 0;
		gbc_devByLabel.gridy = 0;
		panel_south.add(devByLabel, gbc_devByLabel);
		
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
		panel_center = new JPanel();
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{0, 0};
		gbl_panel_center.rowHeights = new int[]{39, 70, 70, 0, 0, 0, 0};
		gbl_panel_center.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
	}
	
	private void setMpmSelectCheckBox(){
		mpmSelectElements = combo.compileComboBox();
		mpmSelect = new JComboBox(mpmSelectElements);
		source = COMBO;
		
		mpmSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(source.equals(COMBO)){
					if(mpmSelect.getSelectedIndex()==0){
						ip_field.setText("");
						port_field.setText("");
						user_field.setText("");
						password_field.setText("");
					}
					else{
						combo.chooseMpm((String) mpmSelect.getSelectedItem());
						ip_field.setText(combo.getIp());
						port_field.setText(combo.getPort());
						user_field.setText(combo.getUser());
					}
				}
				else if(source.equals(FIELD)){
					port_field.setText("");
					user_field.setText("");
					password_field.setText("");
					source = COMBO;
				}
			}
		});
		
		mpmSelect.setMaximumRowCount(5);
		GridBagConstraints gbc_mpmSelect = new GridBagConstraints();
		gbc_mpmSelect.insets = new Insets(0, 0, 5, 0);
		gbc_mpmSelect.fill = GridBagConstraints.HORIZONTAL;
		gbc_mpmSelect.ipady = 5;
		gbc_mpmSelect.gridx = 0;
		gbc_mpmSelect.gridy = 0;
		panel_center.add(mpmSelect, gbc_mpmSelect);
	}
	
	private void setParametersFieldset(){
		param_fieldset = new JPanel();
		param_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "MPM parameters", TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 12), null));
		GridBagConstraints gbc_param_fieldset = new GridBagConstraints();
		gbc_param_fieldset.ipadx = 5;
		gbc_param_fieldset.anchor = GridBagConstraints.NORTH;
		gbc_param_fieldset.insets = new Insets(0, 0, 5, 0);
		gbc_param_fieldset.fill = GridBagConstraints.HORIZONTAL;
		gbc_param_fieldset.gridx = 0;
		gbc_param_fieldset.gridy = 1;
		
		GridBagLayout gbl_param_fieldset = new GridBagLayout();
		gbl_param_fieldset.columnWidths = new int[]{0, 0, 0};
		gbl_param_fieldset.rowHeights = new int[]{0, 0, 0};
		gbl_param_fieldset.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_param_fieldset.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		param_fieldset.setLayout(gbl_param_fieldset);
		panel_center.add(param_fieldset, gbc_param_fieldset);
	}
	
	private void setLoginFieldset(){
		login_fieldset = new JPanel();
		login_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Log in", TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 12), null));
		GridBagConstraints gbc_login_fieldset = new GridBagConstraints();
		gbc_login_fieldset.anchor = GridBagConstraints.NORTH;
		gbc_login_fieldset.insets = new Insets(0, 0, 5, 0);
		gbc_login_fieldset.fill = GridBagConstraints.HORIZONTAL;
		gbc_login_fieldset.gridx = 0;
		gbc_login_fieldset.gridy = 2;
		GridBagLayout gbl_login_fieldset = new GridBagLayout();
		gbl_login_fieldset.columnWidths = new int[]{0, 0, 0};
		gbl_login_fieldset.rowHeights = new int[]{0, 0, 0};
		gbl_login_fieldset.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_login_fieldset.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		login_fieldset.setLayout(gbl_login_fieldset);
		panel_center.add(login_fieldset, gbc_login_fieldset);
	}
	
	private void setIpLabel(){
		JLabel ip_label = new JLabel("IP address");
		param_fieldset.add(ip_label, commonGUI.setContraints(0, 0, 5, 10, 0, 0));
	}
	
	private void setPortLabel(){
		JLabel port_label = new JLabel("Port");
		param_fieldset.add(port_label, commonGUI.setContraints(0, 0, 0, 10, 0, 1));
	}
	
	private void setUserLabel(){
		JLabel user_label = new JLabel("User");
		login_fieldset.add(user_label, commonGUI.setContraints(0, 0, 5, 10, 0, 0));
	}
	
	private void setPasswordLabel(){
		JLabel password_label = new JLabel("Password");
		login_fieldset.add(password_label, commonGUI.setContraints(0, 0, 0, 10, 0, 1));
	}
	
	private void setIpField(){
		ip_field = new JTextField();
		ip_field.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				source = FIELD;
				mpmSelect.setSelectedIndex(0);
			}
		});
		ip_field.setColumns(10);
		param_fieldset.add(ip_field, commonGUI.setContraints(0, 0, 5, 0, 1, 0));
		
	}
	
	private void setPortField(){
		port_field = new JTextField();
		port_field.setColumns(10);
		param_fieldset.add(port_field, commonGUI.setContraints(1, 1));
	}
	
	private void setLoginField(){
		user_field = new JTextField();
		user_field.setColumns(10);
		login_fieldset.add(user_field, commonGUI.setContraints(0, 0, 5, 0, 1, 0));
	}
	
	private void setPasswordField(){
		password_field = new JPasswordField();
		password_field.setColumns(10);
		login_fieldset.add(password_field, commonGUI.setContraints(1, 1));
	}
	
	private void setNotificationLabel(){
		notification_label = new JLabel("");
		notification_label.setForeground(Color.RED);
		panel_center.add(notification_label, commonGUI.setContraintsFill(GridBagConstraints.HORIZONTAL, 0, 0, 5, 0, 0, 3, 5));
	}
	
	private void setButton(){
		button = new JButton("Connect");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rootComponents.getLogger().info("REQUESTED CONNECTION TO MPM.");
				connectionPage.setIp(ip_field.getText());
				connectionPage.setPort(port_field.getText());
				connectionPage.setUsername(user_field.getText());
				connectionPage.setPassword(String.valueOf(password_field.getPassword()));
				connectionPage.setLoginPage(loginPage);
				connectionPage.connect();
				if(connectionPage.isDispose()){
					frame.dispose();
				}
				else{
					notification_label.setText(connectionPage.getNotification());
				}
			}
		});
		frame.getRootPane().setDefaultButton(button);
		panel_center.add(button, commonGUI.setContraints(5, 0, 5, 0, 0, 4));
	}
	
	private JLabel setVersionLabel(){
		JLabel lblV = new JLabel(VERSION);
		panel_center.add(lblV, commonGUI.setContraintsAnchor(GridBagConstraints.WEST, 0, 5));
		return lblV;
	}
	
	public void setRelatedPage(AuthenticationPageInterface loginPage) {
		this.loginPage = loginPage;
	}

	public void setConnectionPage(PageConnectionInterface connectionPage) {
		this.connectionPage = connectionPage;
	}

	public void setCombo(ComboBoxManagerInterface combo) {
		this.combo = combo;
	}
}
