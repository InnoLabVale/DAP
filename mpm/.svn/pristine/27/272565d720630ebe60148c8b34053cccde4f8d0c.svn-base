package com.innovery.mpm.main.implementations.gui.mainpage;


import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

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
import javax.swing.border.TitledBorder;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.SwingConstants;

/**
 * 
 * @author Valerio Boschi, Daniela R. Auricchio
 *
 */
public class LoginPage implements AuthenticationPageInterface {

	private JFrame frame;
	private JTextField user_field;
	private JPasswordField password_field;
	private JLabel notification_label;
	
	private GUICommonInterface commonGUI;
	private PageConnectionInterface connectionPage;
	
	AuthenticationPageInterface main;
	
	public LoginPage(DAPBeanInterface rootComponents) {	
		this.commonGUI = rootComponents.getCommonGUI();
	}

	public void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setSize(320, 300);
		frame.setTitle("Dashboard Assurance Prepaid - Login page");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		JPanel panel_north = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_north.getLayout();
		flowLayout_1.setVgap(10);
		frame.getContentPane().add(panel_north, BorderLayout.NORTH);
		
		JLabel title_label = new JLabel("MPM LOGIN");
		panel_north.add(title_label);
		
		JPanel panel_south = new JPanel();
		frame.getContentPane().add(panel_south, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_south = new GridBagLayout();
		gbl_panel_south.columnWidths = new int[]{0, 0};
		gbl_panel_south.rowHeights = new int[]{0, 0};
		gbl_panel_south.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_south.rowWeights = new double[]{0.0, Double.MIN_VALUE};
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
		JPanel panel_west = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_west.getLayout();
		flowLayout_3.setHgap(10);
		frame.getContentPane().add(panel_west, BorderLayout.WEST);
		
		JPanel panel_east = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_east.getLayout();
		flowLayout_2.setHgap(10);
		frame.getContentPane().add(panel_east, BorderLayout.EAST);
		
		JPanel panel_center = new JPanel();
		frame.getContentPane().add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{0};
		gbl_panel_center.rowHeights = new int[]{70, 0, 0, 0};
		gbl_panel_center.columnWeights = new double[]{1.0};
		gbl_panel_center.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		
		JPanel login_fieldset = new JPanel();
		login_fieldset.setBorder(new TitledBorder(new LineBorder(new Color(171, 173, 179)), "Log in", TitledBorder.LEADING, TitledBorder.TOP, commonGUI.setFontSize(Font.BOLD, 12), null));
		GridBagConstraints gbc_login_fieldset = new GridBagConstraints();
		gbc_login_fieldset.ipady = 2;
		gbc_login_fieldset.anchor = GridBagConstraints.NORTH;
		gbc_login_fieldset.insets = new Insets(0, 0, 5, 0);
		gbc_login_fieldset.fill = GridBagConstraints.HORIZONTAL;
		gbc_login_fieldset.gridx = 0;
		gbc_login_fieldset.gridy = 0;
		panel_center.add(login_fieldset, gbc_login_fieldset);
		GridBagLayout gbl_login_fieldset = new GridBagLayout();
		gbl_login_fieldset.columnWidths = new int[]{0, 0, 0};
		gbl_login_fieldset.rowHeights = new int[]{0, 0, 0};
		gbl_login_fieldset.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_login_fieldset.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		login_fieldset.setLayout(gbl_login_fieldset);

		JLabel user_label = new JLabel("User");
		login_fieldset.add(user_label, commonGUI.setContraints(0, 0, 5, 10, 0, 0));
		
		user_field = new JTextField();
		user_field.setColumns(10);
		login_fieldset.add(user_field, commonGUI.setContraints(0, 0, 5, 0, 1, 0));
		
		JLabel password_label = new JLabel("Password");
		login_fieldset.add(password_label, commonGUI.setContraints(0, 0, 0, 10, 0, 1));
		
		password_field = new JPasswordField();
		password_field.setColumns(10);
		login_fieldset.add(password_field, commonGUI.setContraints(1, 1));
		
		notification_label = new JLabel("");
		notification_label.setForeground(Color.RED);
		notification_label.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_notification_label = new GridBagConstraints();
		gbc_notification_label.insets = new Insets(0, 0, 5, 0);
		gbc_notification_label.gridx = 0;
		gbc_notification_label.gridy = 2;
		panel_center.add(notification_label, gbc_notification_label);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panel_center.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{140, 134};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connectionPage.setUsername(user_field.getText());
				connectionPage.setPassword(String.valueOf(password_field.getPassword()));
			    connectionPage.connect();
			    if(connectionPage.isDispose()){
					frame.dispose();
					if(!connectionPage.isLogged()){
						main.initialize();
					}
				}
				else{
					notification_label.setText(connectionPage.getNotification());
				}
			}
		});
		frame.getRootPane().setDefaultButton(btnLogin);
		btnLogin.setIconTextGap(3);
		panel.add(btnLogin, commonGUI.setContraints(0, GridBagConstraints.EAST, 0, 0, 0, 10, 0, 0));
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.initialize();
			    frame.dispose();
			}
		});
		panel.add(backButton, commonGUI.setContraints(0, GridBagConstraints.WEST, 0, 10, 0, 0, 1, 0));
		
		frame.addWindowListener(new WindowAdapter() {
		   @Override
		   public void windowClosing(WindowEvent e) {
		    int answer = JOptionPane.showConfirmDialog(e.getWindow(),  "Are you sure you want to close this window?", "Confirm close", JOptionPane.YES_NO_OPTION);
		    if (answer == JOptionPane.YES_OPTION) {
		     e.getWindow().dispose();
		    }
		   }
		  });
		
	    frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "none");
	    frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("released ENTER"), "press");
		frame.setVisible(true);
	}

	public void setRelatedPage(AuthenticationPageInterface main) {
		this.main = main;
	}
	
	public void setConnectionPage(PageConnectionInterface connectionPage) {
		this.connectionPage = connectionPage;
	}

	public void setCombo(ComboBoxManagerInterface combo) {
	}
}
