package com.innovery.mpm.subscriber.implementations.gui.util;

import java.awt.Font;
import java.awt.GridBagConstraints;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERActions;
import com.innovery.mpm.subscriber.implementations.util.SUBSCRIBERCommands;
import com.innovery.mpm.subscriber.interfaces.gui.util.SubscriberResponseGridManagerInterface;

public class SubscriberResponseGridManager implements SubscriberResponseGridManagerInterface {

	private DAPBeanInterface components;
	
	private JPanel responseFieldset;
	private JPanel responseFieldsetGrid;
	private ButtonGroup actionButtonGroup;
	private ButtonGroup ctypeButtonGroup;
	private JFrame frame;
	
	@Override
	public void setResponseGridAssurance(String response_mpm){
		
		if(response_mpm.equals(components.getErrorMessages().get_USER_NOT_FOUND()) ||
				   response_mpm.equals(components.getErrorMessages().get_NOT_LOGGED_WARN()) ||
				   response_mpm.equals(components.getErrorMessages().get_MPM_CONNECTION_WARN()) ||
				   response_mpm.equals(components.getErrorMessages().get_RELOGGED()) ||
				   response_mpm.equals(components.getErrorMessages().get_NOT_LOGGED_ERROR())){
			
			responseFieldsetGrid.add(new JLabel(response_mpm), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
		}
		
		else {
			String[] responsePlitted = response_mpm.trim().replace(SUBSCRIBERCommands.END, "").split("\\:");
			if(!responsePlitted[2].equals("0")){
				JLabel generic_response_msg = new JLabel(readErrorDescription(responsePlitted[2]));
				responseFieldsetGrid.add(generic_response_msg, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 0, 0));
			}
			
			else if(responsePlitted[2].equals("0")){
					if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_AMOUNT)){
						setAssuranceAmountDaIdLabel();
						setAssuranceAmountDaValueLabel();
						setAssuranceAmountDaUnitLabel();
						setAssuranceAmountDaExpiryDateLabel();
						setResponseGridAssuranceAmount(response_mpm);
					}
					
					else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_PROFILE)){
						if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.PREPAID)){
							setResponseGridAssuranceProfilePrepaid(response_mpm);
						}
						
						else if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
							setResponseGridAssuranceProfilePostpaid(response_mpm);
						}
					}
					
					else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_DATASERVICES)){
						setResponseGripAssuranceDataServices(response_mpm);
					}
					
					else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_TARIFF_PLAN)){
						setResponseGridAssuranceTariffPlan(response_mpm);
					}
					
					else if(actionButtonGroup.getSelection().getActionCommand().equals(SUBSCRIBERActions.SUBSCRIBER_ACTION_GET_BILL_CYCLE)){
						setResponseGripAssuranceBillCycle(response_mpm);
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
		
		for(int i = 0; i<responseFieldsetGrid.getComponents().length; i++){
			responseFieldsetGrid.getComponent(i).setVisible(true);
		}
		
		frame.repaint();
		frame.validate();
	}
	
	private void setResponseGridAssuranceAmount(String response_mpm){
		String[] responsePlitted = response_mpm.trim().replace(SUBSCRIBERCommands.END, "").split("\\:");
		
		String[] da_splitted = responsePlitted[4].split(",");

		int x = 0;
		int y = 1;
		
		for(int i=1; i<da_splitted.length-1; i++){
			
			JLabel label_temp = new JLabel(da_splitted[i+1]);
			label_temp.setVisible(true);
			
			if(da_splitted[i].equals("ID")){
				responseFieldsetGrid.add(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 0, 0, x, y));
				x = x+1;
			}
			
			else if(da_splitted[i].equals("VALUE")){
				responseFieldsetGrid.add(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 0, 0, x, y));
				x = x+1;
			}
			
			else if(da_splitted[i].equals("UNIT")){
				responseFieldsetGrid.add(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 0, 0, x, y));
				x = x+1;
			}
			
			else if(da_splitted[i].equals("EXPIRYDATE")){
				responseFieldsetGrid.add(label_temp, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 20, 0, 0, x, y));
				x = 0;
				y = y+1;
			}
		}
	}
	
	private void setResponseGridAssuranceProfilePrepaid(String response_mpm){
		String[] responsePlitted = response_mpm.replace(SUBSCRIBERCommands.END, "").split("\\:");
		String responseSplittedElement[];
		int y = 0;
		for(int i=4; i<responsePlitted.length; i++){
			responseSplittedElement = responsePlitted[i].split(",");
				
			String parameter_name = responseSplittedElement[0];
			String parameter_value = responseSplittedElement[1];
			JLabel parameter_name_label = new JLabel();
			parameter_name_label.setFont(new Font(parameter_name_label.getFont().getName(), Font.BOLD, parameter_name_label.getFont().getSize()));
			
			if(parameter_name.equals("TARIFFPLAN")){
				parameter_name_label.setText("TARIFF PLAN:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 0, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 0, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("STATE")){
				parameter_name_label.setText("STATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("LANGUAGE")){
				parameter_name_label.setText("LANGUAGE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("SIMEXPIRYDATE")){
				parameter_name_label.setText("SIM EXPIRY DATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("SIMSUPERVISIONEXPIRYDATE")){
				parameter_name_label.setText("SUPERVISION EXPIRY DATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("IVRSTATE")){
				parameter_name_label.setText("IVR STATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("DAILYFEE")){
				parameter_name_label.setText("DAILY FEE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("COMMUNITYID")){
				parameter_name_label.setText("COMMUNITY ID:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("DATACCINT")){
				parameter_name_label.setText("DATA CC INT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("DATACCNAT")){
				parameter_name_label.setText("DATA CC NAT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("NEXTFEEDATE")){
				parameter_name_label.setText("NEXT FEE DATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 10, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("FEEDISCOUNT")){
				parameter_name_label.setText("FEE DISCOUNT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
		}
	}
	
	private void setResponseGridAssuranceProfilePostpaid(String response_mpm){
		String[] responseSplitted = response_mpm.replace(SUBSCRIBERCommands.END, "").split("\\:");
		String responseSplittedElement[];
		int y = 0;
		for(int i=4; i<responseSplitted.length; i++){
			responseSplittedElement = responseSplitted[i].split(",");

			String parameter_name = responseSplittedElement[0];
			String parameter_value = responseSplittedElement[1];
			JLabel parameter_name_label = new JLabel();
			parameter_name_label.setFont(new Font(parameter_name_label.getFont().getName(), Font.BOLD, parameter_name_label.getFont().getSize()));
			
			if(parameter_name.equals("DAY")){
				parameter_name_label.setText("DAY:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("MONTH")){
				parameter_name_label.setText("MONTH:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("TARIFFPLAN")){
				parameter_name_label.setText("TARIFF PLAN:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("COMMUNITYID")){
				parameter_name_label.setText("COMMUNITY ID:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("VOICE")){
				parameter_name_label.setText("VOICE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("VOICE_ITZ")){
				parameter_name_label.setText("VOICE ITZ:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("SMS")){
				parameter_name_label.setText("SMS:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("DATA")){
				parameter_name_label.setText("DATA:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("VOLUME")){
				parameter_name_label.setText("VOLUME:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("MSG")){
				parameter_name_label.setText("MSG:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("DATASERVICES")){
				parameter_name_label.setText("DATA SERVICES:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("DATASHAPINGNAT")){
				parameter_name_label.setText("DATA SHAPING NAT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("DATACCINT")){
				parameter_name_label.setText("DATA CC INT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));

				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("TEMPUNBLOCKDATE")){
				parameter_name_label.setText("UNBLOCK DATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
		}
	}
	
	private void setResponseGripAssuranceDataServices(String response_mpm){
		String[] responsePlitted = response_mpm.replace(SUBSCRIBERCommands.END, "").split("\\:");
		String[] data_services_splitted = responsePlitted[4].split(",");
		int y = 0;
		if(data_services_splitted[0].equals("DATASERVICES")){
			JLabel parameter_name_label = new JLabel("DATA SERVICES:");
			parameter_name_label.setFont(new Font(parameter_name_label.getFont().getName(), Font.BOLD, parameter_name_label.getFont().getSize()));
			
			responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
			for(int k=1; k<data_services_splitted.length; k++){
				responseFieldsetGrid.add(new JLabel(data_services_splitted[k]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
		}
	}
	
	private void setResponseGripAssuranceBillCycle(String response_mpm){
		String[] responsePlitted = response_mpm.replace(SUBSCRIBERCommands.END, "").split("\\:");
		
		
		String[] bill_cycle_day_splitted = responsePlitted[4].split(",");
		
		JLabel parameter_day_label = new JLabel(bill_cycle_day_splitted[0]+":");
		parameter_day_label.setFont(new Font(parameter_day_label.getFont().getName(), Font.BOLD, parameter_day_label.getFont().getSize()));
			
		responseFieldsetGrid.add(parameter_day_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, 0));
		responseFieldsetGrid.add(new JLabel(bill_cycle_day_splitted[1]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, 0));
	
		if(ctypeButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.POSTPAID)){
			
			String[] bill_cycle_month_splitted = responsePlitted[5].split(",");
			
			JLabel parameter_month_label = new JLabel(bill_cycle_month_splitted[0]+":");
			parameter_month_label.setFont(new Font(parameter_month_label.getFont().getName(), Font.BOLD, parameter_month_label.getFont().getSize()));
				
			responseFieldsetGrid.add(parameter_month_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, 1));
			responseFieldsetGrid.add(new JLabel(bill_cycle_month_splitted[1]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, 1));
		}
	
	}
	
	private void setResponseGridAssuranceTariffPlan(String response_mpm){
		String[] responsePlitted = response_mpm.replace(SUBSCRIBERCommands.END, "").split("\\:");
		String responseSplittedElement[];
		int y = 0;
		for(int i=4; i<responsePlitted.length; i++){
			responseSplittedElement = responsePlitted[i].split(",");
				
			String parameter_name = responseSplittedElement[0];
			String parameter_value = responseSplittedElement[1];
			JLabel parameter_name_label = new JLabel();
			parameter_name_label.setFont(new Font(parameter_name_label.getFont().getName(), Font.BOLD, parameter_name_label.getFont().getSize()));
			
			if(parameter_name.equals("TARIFFPLAN")){
				parameter_name_label.setText("TARFF PLAN:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("VOICE")){
				parameter_name_label.setText("VOICE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("VOICE_ITZ")){
				parameter_name_label.setText("VOICE ITZ:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("SMS")){
				parameter_name_label.setText("SMS:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("DATA")){
				parameter_name_label.setText("DATA:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("VOLUME")){
				parameter_name_label.setText("VOLUME:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("MSG")){
				parameter_name_label.setText("MSG:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
			
			else if(parameter_name.equals("EXPIRYDATE")){
				parameter_name_label.setText("EXPIRY DATE:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				responseFieldsetGrid.add(new JLabel(parameter_value), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
				y=y+1;
			}
			
			else if(parameter_name.equals("DATASHAPINGNAT")){
				parameter_name_label.setText("DATA SHAPING NAT:");
				responseFieldsetGrid.add(parameter_name_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.EAST, 5, 30, 0, 0, 0, y));
				for(int j=1; j<responseSplittedElement.length; j++){
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 1, y));
					j=j+1;
					responseFieldsetGrid.add(new JLabel(responseSplittedElement[j]), components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.WEST, 5, 20, 0, 0, 2, y));
					y=y+1;
				}
			}
		}
	}
	
	private void setAssuranceAmountDaIdLabel() {
		JLabel da_id_label = new JLabel("DA Id");
		da_id_label.setVisible(false);
		da_id_label.setFont(new Font(da_id_label.getFont().getName(), Font.BOLD, da_id_label.getFont().getSize()));
		responseFieldsetGrid.add(da_id_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 10, 0, 0, 0));
	}

	private void setAssuranceAmountDaValueLabel() {
		JLabel da_value_label = new JLabel("DA Value");
		da_value_label.setVisible(false);
		da_value_label.setFont(new Font(da_value_label.getFont().getName(), Font.BOLD, da_value_label.getFont().getSize()));
		responseFieldsetGrid.add(da_value_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 10, 0, 1, 0));
	}

	private void setAssuranceAmountDaUnitLabel() {
		JLabel da_unit_label = new JLabel("DA Unit");
		da_unit_label.setVisible(false);
		da_unit_label.setFont(new Font(da_unit_label.getFont().getName(), Font.BOLD, da_unit_label.getFont().getSize()));
		responseFieldsetGrid.add(da_unit_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 10, 0, 2, 0));
	}

	private void setAssuranceAmountDaExpiryDateLabel() {
		JLabel da_exp_date_label = new JLabel("DA Expiry Date");
		da_exp_date_label.setVisible(false);
		da_exp_date_label.setFont(new Font(da_exp_date_label.getFont().getName(), Font.BOLD, da_exp_date_label.getFont().getSize()));
		responseFieldsetGrid.add(da_exp_date_label, components.getCommonGUI().setContraints(GridBagConstraints.VERTICAL, GridBagConstraints.CENTER, 5, 10, 10, 0, 3, 0));
	}
	
	private String readErrorDescription(String response_mpm){
		try {
			String error_message;
			if(response_mpm.length()==4){
				error_message = components.getConnectionManagerStandard().getRb_errorCode().getString(response_mpm);
			}
			
			else {
				error_message = components.getConnectionManagerStandard().getRb_errorCode().getString(response_mpm.substring(0,3));
			}
			return error_message;
		} catch (Exception e) {
			return response_mpm;
		}
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setResponseFieldset(JPanel responseFieldset) {
		this.responseFieldset = responseFieldset;
	}

	@Override
	public void setResponseFieldsetGrid(JPanel responseFieldsetGrid) {
		this.responseFieldsetGrid = responseFieldsetGrid;
	}

	@Override
	public void setActionButtonGroup(ButtonGroup actionButtonGroup) {
		this.actionButtonGroup = actionButtonGroup;
	}

	@Override
	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}

	@Override
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
