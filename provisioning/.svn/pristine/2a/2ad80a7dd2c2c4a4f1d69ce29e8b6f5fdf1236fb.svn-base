package com.innovery.mpm.provisioning.interfaces.gui;

import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.innovery.mpm.connection.implementations.util.gui.GUICommonInterface;
import com.innovery.mpm.connection.interfaces.standard.ConnectionManagmentStandardInterface;
import com.innovery.mpm.connection.interfaces.standard.session.SessionStandardInterface;
import com.innovery.mpm.connection.interfaces.util.ErrorMessagesInterface;
import com.innovery.mpm.connection.interfaces.util.NotificationInterface;
import com.innovery.mpm.connection.interfaces.util.TransIdGeneratorInterface;
import com.innovery.mpm.connection.interfaces.util.UserLevelsInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningUtilInterface;
import com.innovery.mpm.provisioning.interfaces.gui.verification.BsoResourcesVerifyInterface;
import com.innovery.mpm.provisioning.interfaces.gui.util.ProvisioningResponseManagmentInterface;

public interface BsoResourceInterface {
	
	public void initialize();

	public ErrorMessagesInterface getErrorMessages();
	
	public NotificationInterface getNotification();

	public JFrame getFrame();

	public JTextArea getTextArea();

	public JButton getBtnExecute();

	public JTextField getMsisdn_field();

	public ButtonGroup getRadioGroupAction();

	public ButtonGroup getRadioGroupMarket();
	
	public ButtonGroup getRadioGroupCtype();

	public JRadioButton getRdbtnConsumer();

	public JRadioButton getRdbtnCorporate();

	public JRadioButton getRdbtnIn();

	public JRadioButton getRdbtnOut();

	public JRadioButton getRdbtnBookOut();

	public JRadioButton getRdbtnChange();

	public JRadioButton getRdbtnGet();

	public JComboBox getSelectOptionCombo();

	public JComboBox getSelectDiscountCombo();

	public String[] getParametersList();
	
	public void setParametersList(String[] parametersList);

	public JLabel getDiscount_label();

	public JLabel getParameter_1_label();

	public JTextField getParameter_1_field();

	public JLabel getParameter_2_label();

	public JTextField getParameter_2_field();

	public JLabel getParameter_3_label();

	public JTextField getParameter_3_field();

	public JLabel getParameter_4_label();

	public JTextField getParameter_4_field();

	public JLabel getParameter_5_label();

	public JTextField getParameter_5_field();

	public JLabel getParameter_6_label();

	public JTextField getParameter_6_field();

	public List<JLabel> getLabelList();

	public List<JTextField> getFieldList();

	public List<String> getInputParametersRegex();

	public String getDEFAULT();

	public ConnectionManagmentStandardInterface getConnectionManagmentStandard();

	public SessionStandardInterface getSessionStandard();

	public JPanel getResponse_fieldset_grid();

	public JPanel getResponse_fieldset();
	
	public void setResponse_fieldset_grid(JPanel response_fieldset_grid);
	
	public BsoResponseGridManagmentInterface getGrid_managment();
	
	public GUICommonInterface getCommonGUI();
	
	public JLabel getGeneric_response_msg();

	public void setGeneric_response_msg(JLabel generic_response_msg);
	
	public JLabel getCug_action_label();

	public ButtonGroup getRadioGroupChangeCug();

	public JPanel getRadioGroupChangeCug_panel();
	
	public TransIdGeneratorInterface getTRANSID();

	public UserLevelsInterface getUser_levels();
	
	public void setResponseManagment(ProvisioningResponseManagmentInterface responseManagment);

	public void setInputVerifier(BsoResourcesVerifyInterface inputVerifier);

	public void setUtil(ProvisioningUtilInterface util);

	public void setGrid_managment(BsoResponseGridManagmentInterface grid_managment);
}
