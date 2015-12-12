package com.innovery.mpm.resource.implementations.gui.grid;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class ServiceOfferingsResponseGrid {

	private DAPBeanInterface components;
	
	private Map<Object, GridBagConstraints> gridList;
	
	public ServiceOfferingsResponseGrid(DAPBeanInterface components){
		this.components = components;
	}
	
	public Map<Object, GridBagConstraints> getGrid(String[] mpm_response_splitted){
		
		gridList = new HashMap<>();
		
		String[] resource_response_splitted = mpm_response_splitted[3].split(",");
		int x = 0;
		int y = 0;
		
		for(int i=0; i<resource_response_splitted.length; i++){
			
			JLabel resource_label = null;
			if(resource_response_splitted[i].equals("SERVICEOFFERINGID")){
				resource_label = new JLabel(resource_response_splitted[i+1]);
				resource_label.setFont(new Font(resource_label.getFont().getName(), Font.BOLD, resource_label.getFont().getSize()));
				resource_label.setVisible(true);
				
				gridList.put(resource_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, x, y));
				x = x+1;
			}
			
			else if(resource_response_splitted[i].equals("SERVICEOFFERINGFLAG")){
				JCheckBox offer_flag = new JCheckBox();
				
				if(resource_response_splitted[i+1].equals("TRUE")){
					offer_flag.setSelected(true);
				}
				
				gridList.put(offer_flag, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 30, 0, 0, x, y));
				y = y+1;
				
				if(y>=16){
					x = 2;
					y = 0;
				}
				
				else if(x<2){
					x = 0;
					
				}
				
				else if(x>=2){
					x = 2;
				}
			}
		}
		
		disableCheckBox();
		return gridList;
	}
	
	
	private void disableCheckBox(){
		
		
		Iterator<Map.Entry<Object,GridBagConstraints>> iterator = gridList.entrySet().iterator();
		while(iterator.hasNext()){
			Entry thisEntry = iterator.next();
			if(thisEntry.getKey() instanceof JCheckBox){
				final JCheckBox checkbox = (JCheckBox) thisEntry.getKey();
				checkbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(checkbox.isSelected()){
							checkbox.setSelected(false);
						}
						else {
							checkbox.setSelected(true);
						}
					}
				});
			}
		}
	}
}
