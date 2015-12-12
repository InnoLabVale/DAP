package com.innovery.mpm.resource.implementations.gui.util.bean;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.resource.implementations.util.AIRActions;

public class GuiSUPExpPanel extends GuiResourcePanelInterface{

	private static final long serialVersionUID = 1L;
	
	private DAPBeanInterface components;
	
	private JRadioButton rdbtnGet;
	private JRadioButton rdbtnUpdate;
	
	private JLabel sup_label;
	private JTextField sup_text;
	
	private JLabel sup_adj_label;
	private JTextField sup_adj_text;
		
	public GuiSUPExpPanel(DAPBeanInterface components, JRadioButton rdbtnGet, JRadioButton rdbtnUpdate){
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
		setSupExpiryDateAbsLabel();
		setSupExpiryDateAbsText();
		setSupExpiryDateRelLabel();
		setSupExpiryDateRelText();
		setAction();
	}
	
	private void setAction(){
		rdbtnGet.setEnabled(true);
		rdbtnUpdate.setEnabled(true);
	}
	
	private void setSupExpiryDateAbsLabel(){
		sup_label = new JLabel("Supervision expiry date (YYYY-MM-DD)");
		sup_label.setHorizontalAlignment(SwingConstants.RIGHT);
		sup_label.setVisible(false);
		add(sup_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 5, 0, 5, 0, 0));
	}
	
	private void setSupExpiryDateAbsText(){
		sup_text = new JTextField();
		sup_text.setColumns(10);
		sup_text.setVisible(false);
		
		sup_text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				sup_text.setText(components.getDateCompleter().complete(sup_text.getText()));
			}
		});
		
		add(sup_text, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 1, 0));
	}
	
	private void  setSupExpiryDateRelLabel(){
		sup_adj_label = new JLabel("Supervision expiry date adjustment");
		sup_adj_label.setHorizontalAlignment(SwingConstants.RIGHT);
		sup_adj_label.setVisible(false);
		add(sup_adj_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 5, 0, 5, 0, 1));
	}
	
	private void  setSupExpiryDateRelText(){
		sup_adj_text = new JTextField();
		sup_adj_text.setColumns(10);
		sup_adj_text.setVisible(false);
		add(sup_adj_text, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 8, 0, 0, 0, 1, 1));
	}

	public JTextField getSupExpText(){
		return sup_text;
	}
	
	public JTextField getSupExpAdjText(){
		return sup_adj_text;
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
		sup_label.setText("Supervision expiry date (YYYY-MM-DD)");
		sup_adj_label.setText("Supervision expiry date adjustment");
		
		sup_label.setVisible(false);
		sup_adj_label.setVisible(false);
		
		this.reset();
		
		sup_text.setVisible(false);
		sup_adj_text.setVisible(false);
	}
	
	private void actionUpdate(){
		sup_label.setText("Supervision expiry date (YYYY-MM-DD)*");
		sup_adj_label.setText("Supervision expiry date adjustment*");
		
		sup_label.setVisible(true);
		sup_adj_label.setVisible(true);
		
		this.reset();
		
		sup_text.setVisible(true);
		sup_adj_text.setVisible(true);
		
		sup_text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				verifyUpdateDate();
			}
		});
		
		
		sup_adj_text.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e){
				verifyUpdateDateAdj();
			}
		});
	}
	
	private void verifyUpdateDate(){
		if(sup_text.getText().length()>0){
			sup_adj_label.setText("Supervision expiry date adjustment");
			sup_adj_text.setText("");
			sup_adj_label.setVisible(false);
			sup_adj_text.setVisible(false);
		}
		else{
			sup_adj_label.setText("Supervision expiry date adjustment*");
			sup_adj_label.setVisible(true);
			sup_adj_text.setVisible(true);
		}
	}
	
	private void verifyUpdateDateAdj(){
		if(sup_adj_text.getText().length()>0){
			sup_label.setText("Supervision expiry date");
			sup_text.setText("");
			sup_label.setVisible(false);
			sup_text.setVisible(false);
		}
		else{
			sup_label.setText("Supervision expiry date*");
			sup_label.setVisible(true);
			sup_text.setVisible(true);
		}
	}
	
	private void reset(){
		sup_text.setText("");
		sup_adj_text.setText("");
	}
}