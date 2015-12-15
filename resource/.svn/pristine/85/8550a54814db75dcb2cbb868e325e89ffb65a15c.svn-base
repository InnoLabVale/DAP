package com.innovery.mpm.resource.implementations.gui.util.bean;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;

public class GuiServiceClassPanel extends GuiResourcePanelInterface{
	
	private DAPBeanInterface components;
	
	private JRadioButton rdbtnGet;
	private JRadioButton rdbtnUpdate;
	
	private JLabel sc_label;
	private JTextField sc_text;

	public GuiServiceClassPanel(DAPBeanInterface components, JRadioButton rdbtnGet, JRadioButton rdbtnUpdate){
		this.components = components;
		this.rdbtnGet = rdbtnGet;
		this.rdbtnUpdate = rdbtnUpdate;
		initialize();
		
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
	
	private void initialize() {
		setPanelDimension();
		setServiceClassLabel();
		setServiceClassText();
		setAction();
	}
	
	private void setAction(){
		rdbtnGet.setEnabled(true);
		rdbtnUpdate.setEnabled(true);
	}
	
	private void setServiceClassLabel(){
		sc_label = new JLabel("Service class");
		sc_label.setHorizontalAlignment(SwingConstants.RIGHT);
		sc_label.setVisible(false);
		add(sc_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 5, 0, 5, 0, 0));
	}
	
	private void setServiceClassText(){
		sc_text = new JTextField();
		sc_text.setColumns(10);
		sc_text.setVisible(false);
		add(sc_text, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 1, 0));
	}
	
	public JTextField getScText(){
		return sc_text;
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
		/*No action*/
	}
	
	private void actionDelete(){
		/*No action*/
	}
	
	private void actionGet(){
		sc_label.setText("Service class");
		
		sc_label.setVisible(false);
		
		this.reset();
		
		sc_text.setVisible(false);
	}
	
	private void actionUpdate(){
		sc_label.setText("Service class*");
		
		sc_label.setVisible(true);
		
		this.reset();
		
		sc_text.setVisible(true);
	}
	
	private void reset(){
		sc_text.setText("");
	}
}
