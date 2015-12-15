package com.innovery.mpm.af.implementations.gui.util;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.innovery.mpm.af.implementations.util.AFActions;
import com.innovery.mpm.af.implementations.util.AFCommands;
import com.innovery.mpm.af.interfaces.gui.util.AccountFinderResponseGridManagerInterface;
import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;

public class AccountFinderResponseGridManager implements AccountFinderResponseGridManagerInterface {
	
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
			String[] responsePlitted = response_mpm.replace(AFCommands.END, "").trim().split("\\:");
			String responseCode = responsePlitted[2];
			if(!responseCode.equals("0")){
				JLabel errorResponseMsg = new JLabel(readErrorDescription(responsePlitted[2]));
				responseFieldsetGrid.add(errorResponseMsg, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
			}
			
			else if(responseCode.equals("0")){
				if(actionButtonGroup.getSelection().getActionCommand().equals(AFActions.AF_ACTION_GET)){
					setAssuranceResponseGrid();
					setResponseGridAssuranceAccountFinder(response_mpm);
				}
				
				else{
					JLabel genericResponseMsg = new JLabel("DONE!");
					genericResponseMsg.setFont(new Font(genericResponseMsg.getFont().getName(), Font.BOLD, genericResponseMsg.getFont().getSize()));
					responseFieldsetGrid.add(genericResponseMsg, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
				}
			}
		}
		responseFieldset.validate();
		responseFieldset.repaint();
	}
	
	private void setResponseGridAssuranceAccountFinder(String response_mpm){
		String[] responsePlitted = response_mpm.replace(AFCommands.END, "").trim().split("\\:");
		
		int y = 0;
		
		for(int i=3; i<responsePlitted.length; i++){
			
			String parameterName = (responsePlitted[i].split(","))[0];
			String parameterValue = (responsePlitted[i].split(","))[1].replace("\"", "");
			
			JLabel af_parameter_value = new JLabel(parameterValue);
			if(parameterName.equals("SDPHOSTNAME")){
				responseFieldsetGrid.add(af_parameter_value, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, 0));
			}
			
			else if(parameterName.equals("SDPID")){
				responseFieldsetGrid.add(af_parameter_value, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 10, 20, 0, 0, 1, 1));
			}
			y = y+1;
		}
		
		for(int i = 0; i<responseFieldsetGrid.getComponents().length; i++){
			responseFieldsetGrid.getComponent(i).setVisible(true);
		}
	}
	
	private void setAssuranceResponseGrid() {
		JLabel sc_id_label = new JLabel("SDP host name:");
		sc_id_label.setVisible(false);
		sc_id_label.setFont(new Font(sc_id_label.getFont().getName(), Font.BOLD, sc_id_label.getFont().getSize()));
		responseFieldsetGrid.add(sc_id_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, 0));
	
		JLabel sc_start_label = new JLabel("SDP IP:");
		sc_start_label.setVisible(false);
		sc_start_label.setFont(new Font(sc_start_label.getFont().getName(), Font.BOLD, sc_start_label.getFont().getSize()));
		responseFieldsetGrid.add(sc_start_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, 1));
	}
	
	private String readErrorDescription(String response_mpm){
		try {
			String error_message = components.getConnectionManagerStandard().getRb_errorCode().getString(response_mpm);
			return error_message;
		} catch (Exception e) {
			return response_mpm;
		}
	}

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
