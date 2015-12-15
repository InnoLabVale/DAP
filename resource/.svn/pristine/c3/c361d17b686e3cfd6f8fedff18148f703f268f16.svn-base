package com.innovery.mpm.resource.implementations.gui.grid;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JLabel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class OfferIdResponseGrid {

	private DAPBeanInterface components;
	
	private Map<Object, GridBagConstraints> gridList;
	
	public OfferIdResponseGrid(DAPBeanInterface components){
		this.components = components;
	}
	
	public Map<Object, GridBagConstraints> getGrid(String[] mpm_response_splitted){
		gridList = new HashMap<>();
		setHeader();
		setValues(mpm_response_splitted);
		return gridList;
	}
	
	private void setHeader(){
		JLabel resource_1_label = new JLabel("OFFER ID");
		JLabel resource_2_label = new JLabel("START DATE");
		JLabel resource_3_label = new JLabel("EXPIRY DATE");
		JLabel resource_4_label = new JLabel("TYPE");
		
		resource_1_label.setFont(new Font(resource_1_label.getFont().getName(), Font.BOLD, resource_1_label.getFont().getSize()));
		resource_2_label.setFont(new Font(resource_2_label.getFont().getName(), Font.BOLD, resource_2_label.getFont().getSize()));
		resource_3_label.setFont(new Font(resource_3_label.getFont().getName(), Font.BOLD, resource_3_label.getFont().getSize()));
		resource_4_label.setFont(new Font(resource_4_label.getFont().getName(), Font.BOLD, resource_4_label.getFont().getSize()));
		
		gridList.put(resource_1_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 10, 0, 0, 0));
		gridList.put(resource_2_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 10, 0, 1, 0));
		gridList.put(resource_3_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 10, 0, 2, 0));
		gridList.put(resource_4_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 10, 0, 3, 0));
	}
	
	private void setValues(String[] mpm_response_splitted){
		String[] resource_response_splitted = mpm_response_splitted[3].split(",");
		
		int y = 1;
		
		for(int i=1; i<resource_response_splitted.length-1; i++){
			
			JLabel label_temp = new JLabel(resource_response_splitted[i+1]);
			
			if(resource_response_splitted[i].equals("OFFERID")){
				gridList.put(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 0, 0, 0, y));
			}
			
			else if(resource_response_splitted[i].equals("STARTDATE")){
				gridList.put(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 0, 0, 1, y));
			}
			
			else if(resource_response_splitted[i].equals("EXPIRYDATE")){
				gridList.put(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 35, 0, 0, 2, y));
			}
			
			else if(resource_response_splitted[i].equals("OFFERTYPE")){
				gridList.put(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 0, 0, 3, y));
				y = y+1;
			}
			
		}
	}
}
