package com.innovery.mpm.resource.implementations.gui.util.bean;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GuiCommunityIdPanel extends GuiResourcePanelInterface{

	private DAPBeanInterface components;
	
	private JRadioButton rdbtnDelete;
	private JRadioButton rdbtnGet;
	private JRadioButton rdbtnUpdate;
	
	private JLabel community_id_label_1;
	private JLabel community_id_label_2;
	private JLabel community_id_label_3;
	
	private JLabel community_new_label;
	
	private JTextField community_id_new_text_1;
	private JTextField community_id_new_text_2;
	private JTextField community_id_new_text_3;
	
	public GuiCommunityIdPanel(DAPBeanInterface components, JRadioButton rdbtnDelete, JRadioButton rdbtnGet, JRadioButton rdbtnUpdate){
		this.components = components;
		this.rdbtnDelete = rdbtnDelete;
		this.rdbtnGet = rdbtnGet;
		this.rdbtnUpdate = rdbtnUpdate;
		initialize();
		
	}
	
	private void setPanelDimension() {
		setSize(711, 450);
		GridBagLayout gbl_resources_panel = new GridBagLayout();
		gbl_resources_panel.columnWidths = new int[] { 260, 10, 10, 10, 0};
		gbl_resources_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0 };
		gbl_resources_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_resources_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0,	0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		setLayout(gbl_resources_panel);
	}
	
	private void initialize() {
		
		setPanelDimension();
		
		setIdLabel_1();
		setIdLabel_2();
		setIdLabel_3();
		
		setCommunityIdNewIdLabel();
		
		setCommunityIdNewText_1();
		setCommunityIdNewText_2();
		setCommunityIdNewText_3();
		
		setEvents();
		
		setAction();
	}
	
	private void setAction(){
		rdbtnDelete.setEnabled(true);
		rdbtnGet.setEnabled(true);
		rdbtnUpdate.setEnabled(true);
	}
	
	private void setIdLabel_1(){
		community_id_label_1 = new JLabel("ID 1");
		community_id_label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		community_id_label_1.setVisible(false);
		add(community_id_label_1, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 8, 5, 0, 5, 1, 0));
	}
	
	private void setIdLabel_2(){
		community_id_label_2 = new JLabel("ID 2");
		community_id_label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		community_id_label_2.setVisible(false);
		add(community_id_label_2, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 8, 5, 0, 5, 2, 0));
	}
	
	private void setIdLabel_3(){
		community_id_label_3 = new JLabel("ID 3");
		community_id_label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		community_id_label_3.setVisible(false);
		add(community_id_label_3, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 8, 5, 0, 5, 3, 0));
	}
	
	private void setCommunityIdNewIdLabel(){
		community_new_label = new JLabel("Community");
		community_new_label.setHorizontalAlignment(SwingConstants.RIGHT);
		community_new_label.setVisible(false);
		add(community_new_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 5, 0, 5, 0, 1));
	}
	
	private void setCommunityIdNewText_1(){
		community_id_new_text_1 = new JTextField();
		community_id_new_text_1.setColumns(3);
		community_id_new_text_1.setVisible(false);
		add(community_id_new_text_1, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 1, 1));
	}
	
	private void setCommunityIdNewText_2(){
		community_id_new_text_2 = new JTextField();
		community_id_new_text_2.setColumns(3);
		community_id_new_text_2.setVisible(false);
		add(community_id_new_text_2, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 2, 1));
	}
	
	private void setCommunityIdNewText_3(){
		community_id_new_text_3 = new JTextField();
		community_id_new_text_3.setColumns(3);
		community_id_new_text_3.setVisible(false);
		add(community_id_new_text_3, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 3, 1));
	}
	
	public JTextField getIdNewText_1(){
		return community_id_new_text_1;
	}
	
	public JTextField getIdNewText_2(){
		return community_id_new_text_2;
	}
	
	public JTextField getIdNewText_3(){
		return community_id_new_text_3;
	}

	public void setPanelAction(String action){

		if(action.equals(AIRActions.AIR_ACTION_GET)){
			this.actionGet();
		}
		
		else if(action.equals(AIRActions.AIR_ACTION_SET)){
			this.actionUpdate();
		}
		
		else if(action.equals(AIRActions.AIR_ACTION_DELETE)){
			this.actionDelete();
		}
	}
	
	private void actionGet(){
		community_new_label.setText("Community new");
		
		setVisibilityLabel(0);
		
		setVisibilityIdLabels(0, 0, 0);
		
		this.resetId_1();
		this.resetId_2();
		this.resetId_3();
		
		setVisibilityCommunityNew(0, 0, 0);
	}
	
	private void actionUpdate(){
		community_new_label.setText("Community*");
		
		setVisibilityLabel(1);
		
		setVisibilityIdLabels(1, 0, 0);
		
		this.resetId_1();
		this.resetId_2();
		this.resetId_3();
		
		setVisibilityCommunityNew(1, 0, 0);
		
	}
	
	private void actionDelete(){
		setVisibilityLabel(0);
		
		setVisibilityIdLabels(0, 0, 0);
		
		this.resetId_1();
		this.resetId_2();
		this.resetId_3();
		
		setVisibilityCommunityNew(0, 0, 0);
		
	}
	
	private void setVisibilityIdLabels(int id_1, int id_2, int id_3){
		if(id_1==0){
			community_id_label_1.setVisible(false);
		}
		else if(id_1==1){
			community_id_label_1.setVisible(true);
		}
		
		if(id_2==0){
			community_id_label_2.setVisible(false);
		}
		else if(id_2==1){
			community_id_label_2.setVisible(true);
		}
		
		if(id_3==0){
			community_id_label_3.setVisible(false);
		}
		else if(id_3==1){
			community_id_label_3.setVisible(true);
		}
	}
	
	private void setVisibilityCommunityNew(int id_1, int id_2, int id_3){
		if(id_1==0){
			community_id_new_text_1.setVisible(false);
		}
		else if(id_1==1){
			community_id_new_text_1.setVisible(true);
		}
		
		if(id_2==0){
			community_id_new_text_2.setVisible(false);
		}
		else if(id_2==1){
			community_id_new_text_2.setVisible(true);
		}
		
		if(id_3==0){
			community_id_new_text_3.setVisible(false);
		}
		else if(id_3==1){
			community_id_new_text_3.setVisible(true);
		}
	}
	
	private void setVisibilityLabel(int label){
		if(label==0){
			community_new_label.setVisible(false);
		}
		else if(label==1){
			community_new_label.setVisible(true);
		}
	}
	
	private void resetId_1(){
		community_id_new_text_1.setText("");
	}
	
	private void resetId_2(){
		community_id_new_text_2.setText("");
	}

	private void resetId_3(){
		community_id_new_text_3.setText("");
	}
	
	private void setEvents(){
		community_id_new_text_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!community_id_new_text_1.getText().equals("") && community_id_new_text_2.getText().equals("")){
					setVisibilityIdLabels(1, 1, 0);
					setVisibilityCommunityNew(1, 1, 0);
				}
				
				else if(community_id_new_text_1.getText().equals("")){
					setVisibilityIdLabels(1, 0, 0);
					setVisibilityCommunityNew(1, 0, 0);
					community_id_new_text_2.setText("");
					community_id_new_text_3.setText("");
				}
			}
		});
		
		community_id_new_text_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(!community_id_new_text_2.getText().equals("")){
					setVisibilityIdLabels(1, 1, 1);
					setVisibilityCommunityNew(1, 1, 1);
				}
				
				else {
					setVisibilityIdLabels(1, 1, 0);
					setVisibilityCommunityNew(1, 1, 0);
					community_id_new_text_3.setText("");
				}
			}
		});
	}
}
