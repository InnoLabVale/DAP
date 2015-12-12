package com.innovery.mpm.ssh.implementations.gui.util;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.ssh.implementations.util.SSHActions;
import com.innovery.mpm.ssh.implementations.util.SSHCommands;
import com.innovery.mpm.ssh.interfaces.gui.util.SshResourceResponseGridManagerInterface;

public class SshResourceResponseGridManager implements SshResourceResponseGridManagerInterface {
	
//	private SshResourceInterface reference;
	private DAPBeanInterface components;
	
	private JPanel responseFieldset;
	private JPanel responseFieldsetGrid;
	private ButtonGroup actionButtonGroup;
	
	public void setResponseGridAssurance(String response_mpm){
		if(response_mpm.equals(components.getErrorMessages().get_USER_NOT_FOUND()) ||
		   response_mpm.equals(components.getErrorMessages().get_NOT_LOGGED_WARN()) ||
		   response_mpm.equals(components.getErrorMessages().get_MPM_CONNECTION_WARN()) ||
		   response_mpm.equals(components.getErrorMessages().get_RELOGGED()) ||
		   response_mpm.equals(components.getErrorMessages().get_NOT_LOGGED_ERROR())){
			
			responseFieldsetGrid.add(new JLabel(response_mpm), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
		}
		
		else{
			String[] responsePlitted = response_mpm.trim().replace(SSHCommands.END, "").split("\\:");
			
			if(!responsePlitted[2].equals("0")){
				JLabel generic_response_msg = new JLabel(readErrorDescription(responsePlitted[2]));
				responseFieldsetGrid.add(generic_response_msg, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
			}
			
			else if(responsePlitted[2].equals("0")){
				if(actionButtonGroup.getSelection().getActionCommand().equals(SSHActions.SSH_ACTION_GET)){
					setAssuranceResponseGrid();
					setResponseGridAssuranceServiceCode(response_mpm);
				}
				
				else{
					JLabel generic_response_msg = new JLabel("DONE!");
					generic_response_msg.setFont(new Font(generic_response_msg.getFont().getName(), Font.BOLD, generic_response_msg.getFont().getSize()));
					responseFieldsetGrid.add(generic_response_msg, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
				}
			}
		}
		
		responseFieldset.validate();
		responseFieldset.repaint();
	}
	
	private void setResponseGridAssuranceServiceCode(String response_mpm){
		String[] responsePlitted = response_mpm.trim().replace(SSHCommands.END, "").split("\\:");
		
		int serviceCodeIndex = -1;
		int smartStartDateIndex = -1;
		
		for(int i=0; i<responsePlitted.length; i++){
			if(responsePlitted[i].contains("SERVICECODE,")){
				serviceCodeIndex = i;
			}
			
			else if(responsePlitted[i].contains("SMARTSTARTDATE,")){
				smartStartDateIndex = i;
			}
		}
		
		int y = 1;
		if(serviceCodeIndex!=-1){
			String responseSplittedServiceCode[] = responsePlitted[serviceCodeIndex].split(",");
			for(int i=0; i<responseSplittedServiceCode.length; i++){
				
				if(responseSplittedServiceCode[i].equals("SERVICECODEID")){
					responseFieldsetGrid.add(new JLabel(responseSplittedServiceCode[i+1]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 0, 0, 0, y));
				}
				
				else if(responseSplittedServiceCode[i].equals("SERVICEACTIVATIONDATE")){
					responseFieldsetGrid.add(new JLabel(formatDate(responseSplittedServiceCode[i+1])), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 0, 0, 1, y));
				}
				
				else if(responseSplittedServiceCode[i].equals("DATEOFNEXTCHARGING")){
					responseFieldsetGrid.add(new JLabel(formatDate(responseSplittedServiceCode[i+1])), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 0, 0, 2, y));
					y = y+1;
				}
			}
		}
		
		if(smartStartDateIndex!=-1){
			String responseSplittedSmartStartDate[] = responsePlitted[smartStartDateIndex].split(",");
			
			JLabel smartDateLabel = new JLabel("Smart Date");
			smartDateLabel.setFont(new Font(smartDateLabel.getFont().getName(), Font.BOLD, smartDateLabel.getFont().getSize()));
			
			JLabel smartDateText = new JLabel(formatDate(responseSplittedSmartStartDate[1]));
			
			responseFieldsetGrid.add(smartDateLabel, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 20, 0, 10, 0, 0, y));
			y = y+1;
			responseFieldsetGrid.add(smartDateText, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 0, 0, 0, y));
		}
		
		for(int i = 0; i<responseFieldsetGrid.getComponents().length; i++){
			responseFieldsetGrid.getComponent(i).setVisible(true);
		}
		responseFieldsetGrid.setVisible(true);
	}

	private void setAssuranceResponseGrid() {
		JLabel sc_id_label = new JLabel("Service Code Id");
		sc_id_label.setVisible(false);
		sc_id_label.setFont(new Font(sc_id_label.getFont().getName(), Font.BOLD, sc_id_label.getFont().getSize()));
		responseFieldsetGrid.add(sc_id_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 10, 0, 0, 0));
	
		JLabel sc_start_label = new JLabel("Activation Date");
		sc_start_label.setVisible(false);
		sc_start_label.setFont(new Font(sc_start_label.getFont().getName(), Font.BOLD, sc_start_label.getFont().getSize()));
		responseFieldsetGrid.add(sc_start_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 10, 0, 1, 0));
	
		JLabel sc_end_label = new JLabel("Next Fee Date");
		sc_end_label.setVisible(false);
		sc_end_label.setFont(new Font(sc_end_label.getFont().getName(), Font.BOLD, sc_end_label.getFont().getSize()));
		responseFieldsetGrid.add(sc_end_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 0, 10, 0, 2, 0));
	}

	private String readErrorDescription(String response_mpm){
		try {
			String error_message = components.getConnectionManagerStandard().getRb_errorCode().getString(response_mpm);
			return error_message;
		} catch (Exception e) {
			return response_mpm;
		}
	}

	private String formatDate(String inputDate){
		if(inputDate.equals("NULL")){
			return inputDate;
		}
		StringBuffer newDate = new StringBuffer();
		String YY = inputDate.substring(0, 4);
		String MM = inputDate.substring(4, 6);
		String DD = inputDate.substring(6, 8);
		return newDate.append(YY).append("-").append(MM).append("-").append(DD).toString();
	}
	
//	public void setReference(SshResourceInterface reference) {
//		this.reference = reference;
//	}

	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	public void setResponseFieldset(JPanel responseFieldset) {
		this.responseFieldset = responseFieldset;
	}

	public void setResponseFieldsetGrid(JPanel responseFieldsetGrid) {
		this.responseFieldsetGrid = responseFieldsetGrid;
	}

	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}
}
