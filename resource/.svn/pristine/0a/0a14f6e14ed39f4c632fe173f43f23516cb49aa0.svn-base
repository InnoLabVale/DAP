package com.innovery.mpm.resource.implementations.gui.util.bean;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;

public class GuiAccountGroupPanel extends GuiResourcePanelInterface {

	private DAPBeanInterface components;
	
	private JRadioButton rdbtnGet;
	private JRadioButton rdbtnUpdate;

	private JLabel account_group_id_label;
	private JTextField account_group_id_text;
	
	public GuiAccountGroupPanel(DAPBeanInterface components, JRadioButton rdbtnGet, JRadioButton rdbtnUpdate) {
		this.components = components;
		this.rdbtnGet = rdbtnGet;
		this.rdbtnUpdate = rdbtnUpdate;
		initialize();
	}
	
	private void initialize() {
		setPanelDimension();
		setAccountGroupIdLabel();
		setAccountGroupIdText();
		setAction();
	}
	
	private void setPanelDimension() {
		setSize(711, 450);
		GridBagLayout gbl_resources_panel = new GridBagLayout();
		gbl_resources_panel.columnWidths = new int[] { 260, 278, 0};
		gbl_resources_panel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_resources_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_resources_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,	0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_resources_panel);
	}
	
	private void setAction(){
		rdbtnGet.setEnabled(true);
		rdbtnUpdate.setEnabled(true);
	}
	
	
	private void setAccountGroupIdLabel(){
		account_group_id_label = new JLabel("Account Group id");
		account_group_id_label.setVisible(false);
		account_group_id_label.setHorizontalAlignment(SwingConstants.RIGHT);
		add(account_group_id_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 5, 0, 5, 0, 0));
	}
	
	private void setAccountGroupIdText(){
		account_group_id_text = new JTextField();
		account_group_id_text.setColumns(10);
		account_group_id_text.setVisible(false);
		add(account_group_id_text, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 1, 0));
	}
	
	public JTextField getText(){
		return account_group_id_text;
	}
	
	public void setPanelAction(String action){
		if(action.equals(AIRActions.AIR_ACTION_CREATE)){
			this.actionCreate();
		}
		
		else if(action.equals(AIRActions.AIR_ACTION_DELETE)){
			this.actionDelete();
		}
		
		else if(action.equals(AIRActions.AIR_ACTION_GET)){
			this.actionGet();
		}
		
		else if(action.equals(AIRActions.AIR_ACTION_SET)){
			this.actionUpdate();
		}
	}
	
	private void actionCreate(){
		/* Empty method */
	}
	
	private void actionDelete(){
		/* Empty method */
	}
	
	private void actionGet(){
		account_group_id_label.setText("Account Group id");
		this.reset();
		account_group_id_label.setVisible(false);
		account_group_id_text.setVisible(false);
	}
	
	private void actionUpdate(){
		account_group_id_label.setText("Account group id*");
		this.reset();
		account_group_id_label.setVisible(true);
		account_group_id_text.setVisible(true);
	}
	
	private void reset(){
		account_group_id_text.setText("");
	}

}
