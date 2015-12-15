package com.innovery.mpm.provisioning.implementations.gui.util.options;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JComboBox;

import com.innovery.mpm.connection.interfaces.component.DAPBeanInterface;
import com.innovery.mpm.provisioning.implementations.util.PROVISIONINGActions;
import com.innovery.mpm.provisioning.implementations.xml.XmlListReader;
import com.innovery.mpm.provisioning.interfaces.gui.util.options.ProvisioningOptionLoaderInterface;
import com.innovery.mpm.provisioning.interfaces.xml.XmlListReaderInterface;

public class ProvisioningOptionLoader implements ProvisioningOptionLoaderInterface {
	
	private DAPBeanInterface components;
	
	private JComboBox optionComboboxSelection;
	private ButtonGroup marketButtonGroup;
	private ButtonGroup ctypeButtonGroup;

	@Override
	@SuppressWarnings("null")
	public void load(){
		
		/**
		 * LEGGE DAGLI XML LA LISTA DI TUTTE LE OPZIONI SUDDIVISE PER SEGMENTO, CONSUMER/CORPORATE, PREPAGATO/POSTPAGATO
		 */
		XmlListReaderInterface listReader = new XmlListReader();
		listReader.setComponents(components);
		List<String> folderContent = listReader.getList(marketButtonGroup.getSelection().getActionCommand(), ctypeButtonGroup.getSelection().getActionCommand());

		if(folderContent==null){
			optionComboboxSelection.addItem(PROVISIONINGActions.PROVISIONING_ACTION_DEFAULT);
			return;
		}
		
		List<String> folderContentSorted = null;
		if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CONSUMER)){
			/**
			 * SE E' CONSUMER, ORDINA LE OPZIONI PER ORDINE CRESCENTE DI CODICE
			 */
			folderContentSorted = folderContentSortConsumer(folderContent);
		}
		else if(marketButtonGroup.getSelection().getActionCommand().equals(DAPBeanInterface.CORPORATE)){
			folderContentSorted = folderContentSortCorporate(folderContent);
			
		}
		
		optionComboboxSelection.addItem(PROVISIONINGActions.PROVISIONING_ACTION_DEFAULT);
		for(int i=0; i<folderContentSorted.size(); i++){
			optionComboboxSelection.addItem(folderContentSorted.get(i));
		}
	}
	
	/**
	 * METODO PER L'ORDINAMENTO DELLE OPZIONI CONSUMER
	 * @param folderContent
	 * @return
	 */
	private List<String> folderContentSortConsumer(List<String> folderContent){
		List<Integer> originalInteger = new ArrayList<Integer>();
		List<Integer> notStandardIndex = new ArrayList<Integer>();
		List<String> outputList = new ArrayList<String>();
		
		for(int i=0; i<folderContent.size(); i++){
			if(folderContent.get(i).contains("ROPZ")){
				originalInteger.add(Integer.parseInt(folderContent.get(i).substring("ROPZ".length(), folderContent.get(i).length())));
			}
			else{
				notStandardIndex.add(i);
			}
		}
	
		for(int j=0; j<originalInteger.size(); j++){
			for(int i=0; i<(originalInteger.size()-1)-j; i++){
				
				int currentOption = originalInteger.get(i);
				int nextOption = originalInteger.get(i+1);
					
				if(currentOption > nextOption){
					originalInteger.set(i+1, currentOption);
					originalInteger.set(i, nextOption);					
				}
			}
		}
		
		for(int i=0; i<originalInteger.size(); i++){
			outputList.add(i, "ROPZ"+originalInteger.get(i).toString());
		}

		for(int i=0; i<notStandardIndex.size(); i++){
			outputList.add(outputList.size()-i, folderContent.get(notStandardIndex.get(i)));
		}
		
		return outputList;
	}
	
	/**
	 * METODO PER L'ORDINAMENTO DELLE OPZIONI CORPORATE
	 * @param folderContent
	 * @return
	 */
	private List<String> folderContentSortCorporate(List<String> folderContent){
		List<Integer> originalIntegerOPT = new ArrayList<Integer>();
		List<Integer> originalIntegerOPTBE = new ArrayList<Integer>();
		List<Integer> notStandardIndex = new ArrayList<Integer>();
		List<String> outputList = new ArrayList<String>();
		
		for(int i=0; i<folderContent.size(); i++){
			
			if(folderContent.get(i).contains("OPTBE")){
				originalIntegerOPTBE.add(Integer.parseInt(folderContent.get(i).substring("OPTBE".length(), folderContent.get(i).length())));
			}
			
			else if(folderContent.get(i).contains("OPT")){
				originalIntegerOPT.add(Integer.parseInt(folderContent.get(i).substring("OPT".length(), folderContent.get(i).length())));
			}
			
			else{
				notStandardIndex.add(i);
			}
		}
	
		for(int j=0; j<originalIntegerOPTBE.size(); j++){
			for(int i=0; i<(originalIntegerOPTBE.size()-1)-j; i++){
				
				int currentOption = originalIntegerOPTBE.get(i);
				int nextOption = originalIntegerOPTBE.get(i+1);
					
				if(currentOption > nextOption){
					originalIntegerOPTBE.set(i+1, currentOption);
					originalIntegerOPTBE.set(i, nextOption);					
				}
			}
		}
		
		for(int j=0; j<originalIntegerOPT.size(); j++){
			for(int i=0; i<(originalIntegerOPT.size()-1)-j; i++){
				
				int currentOption = originalIntegerOPT.get(i);
				int nextOption = originalIntegerOPT.get(i+1);
					
				if(currentOption > nextOption){
					originalIntegerOPT.set(i+1, currentOption);
					originalIntegerOPT.set(i, nextOption);					
				}
			}
		}
		
		for(int i=0; i<originalIntegerOPT.size(); i++){
			outputList.add(i, "OPT"+originalIntegerOPT.get(i).toString());
		}
		
		for(int i=0; i<originalIntegerOPTBE.size(); i++){
			if(originalIntegerOPTBE.get(i)<10){
				outputList.add("OPTBE000"+originalIntegerOPTBE.get(i).toString());
			}
			
			else if(originalIntegerOPTBE.get(i)>=10 && originalIntegerOPTBE.get(i)<100){
				outputList.add("OPTBE00"+originalIntegerOPTBE.get(i).toString());
			}
			
			else if(originalIntegerOPTBE.get(i)>=100 && originalIntegerOPTBE.get(i)<1000){
				outputList.add("OPTBE0"+originalIntegerOPTBE.get(i).toString());
			}
			
			else{
				outputList.add("OPTBE"+originalIntegerOPTBE.get(i).toString());
			}
			
		}

		for(int i=0; i<notStandardIndex.size(); i++){
			outputList.add(outputList.size()-i, folderContent.get(notStandardIndex.get(i)));
		}
		
		return outputList;
	}

	@Override
	public void setComponents(DAPBeanInterface components) {
		this.components = components;
	}

	@Override
	public void setOptionComboboxSelection(JComboBox optionComboboxSelection) {
		this.optionComboboxSelection = optionComboboxSelection;
	}

	@Override
	public void setMarketButtonGroup(ButtonGroup marketButtonGroup) {
		this.marketButtonGroup = marketButtonGroup;
	}

	@Override
	public void setCtypeButtonGroup(ButtonGroup ctypeButtonGroup) {
		this.ctypeButtonGroup = ctypeButtonGroup;
	}
}