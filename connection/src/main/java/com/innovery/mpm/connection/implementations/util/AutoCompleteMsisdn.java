package com.innovery.mpm.connection.implementations.util;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import com.innovery.mpm.connection.interfaces.util.AutoCompleteMsisdnInterface;

public class AutoCompleteMsisdn implements AutoCompleteMsisdnInterface {
	
	private final Logger log = Logger.getLogger("mpmlogger");
	
	private static final Integer DEFAULT_RETENTION = 9;
	private static final Integer NOT_FOUND_CODE = -1;
	private static final String SETTINGS_PATH = "./settings/settings.properties";
	private static final String MSISDN_LIST_PATH = "./settings/msisdnList.properties";
	private static final String RETENTION_KEY = "MsisdnRetention";
	private static final Integer UPPER_VALUE = 1000000000;
	
	private List<String> items;
	
	public AutoCompleteMsisdn(){
		items = getStoredMsisdn();
	}

	public JComboBox setupAutoComplete(final JTextField txtInput) {
		final DefaultComboBoxModel model = new DefaultComboBoxModel();
		final JComboBox cbInput = new JComboBox(model) {
			private static final long serialVersionUID = 1L;

			public Dimension getPreferredSize() {
				return new Dimension(super.getPreferredSize().width, 0);
			}
		};
		cbInput.setMaximumRowCount(5);

		setAdjusting(cbInput, false);
		for (String item : items) {
			model.addElement(item);
		}
		cbInput.setSelectedItem(null);
		cbInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!isAdjusting(cbInput)) {
					if (cbInput.getSelectedItem() != null) {
						txtInput.setText(cbInput.getSelectedItem().toString());
					}
				}
			}
		});

		txtInput.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				setAdjusting(cbInput, true);
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (cbInput.isPopupVisible()) {
						e.setKeyCode(KeyEvent.VK_ENTER);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_UP
						|| e.getKeyCode() == KeyEvent.VK_DOWN) {
					e.setSource(cbInput);
					cbInput.dispatchEvent(e);
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						try {
							txtInput.setText(cbInput.getSelectedItem().toString());
							cbInput.setPopupVisible(false);
						} catch (Exception e2) {
						}
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					cbInput.setPopupVisible(false);
				}
				setAdjusting(cbInput, false);
			}
		});
		txtInput.getDocument().addDocumentListener(new DocumentListener() {
			public void insertUpdate(DocumentEvent e) {
				updateList();
			}

			public void removeUpdate(DocumentEvent e) {
				updateList();
			}

			public void changedUpdate(DocumentEvent e) {
				updateList();
			}

			private void updateList() {
				setAdjusting(cbInput, true);
				model.removeAllElements();
				String input = txtInput.getText();
				if (!input.isEmpty()) {
					for (String item : items) {
						if (item.toLowerCase().startsWith(input.toLowerCase())) {
							model.addElement(item);
						}
					}
				}
				cbInput.setPopupVisible(model.getSize() > 0);
				setAdjusting(cbInput, false);
			}
		});
		txtInput.setLayout(new BorderLayout());
		txtInput.add(cbInput, BorderLayout.SOUTH);

		return cbInput;
	}

	private boolean isAdjusting(JComboBox cbInput) {
		if (cbInput.getClientProperty("is_adjusting") instanceof Boolean) {
			return (Boolean) cbInput.getClientProperty("is_adjusting");
		}
		return false;
	}

	private void setAdjusting(JComboBox cbInput, boolean adjusting) {
		cbInput.putClientProperty("is_adjusting", adjusting);
	}
	
	private List<String> getStoredMsisdn(){
		log.info("READING FROM MSISDN LIST");
		Properties pr = new Properties();

		try {
			pr.load(new FileInputStream(MSISDN_LIST_PATH));
			Set<Object> setKeyCurrentList = pr.keySet();
			
			List<String> storedList = new ArrayList<String>();
			for(int i=0; i<setKeyCurrentList.size(); i++){
				storedList.add(i, "");
			}
			
			Iterator<Object> step1 = setKeyCurrentList.iterator();
			while(step1.hasNext()){
				Object currentKeyExtracted = step1.next();
				Integer currentKeyExtractedInteger = Integer.parseInt((String) currentKeyExtracted);
				String currentValueExtracted = (String) pr.get(currentKeyExtracted);
				storedList.set(((storedList.size()-1)-currentKeyExtractedInteger), currentValueExtracted);
			}
			return storedList;
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
			return new ArrayList<String>();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return new ArrayList<String>();
	}
	
	public void store(String msisdn){
		
		Properties pr = new Properties();
		Object retention = null;
		try {
			log.info("READING CONFIGURATION FROM SETTINGS FILE");
			pr.load(new FileInputStream(SETTINGS_PATH));
			log.info("EXTRACTING MAX MSISDN TO STORE");
			retention = pr.get(RETENTION_KEY);
		} catch (FileNotFoundException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		}
		
		Integer retentionNumber = DEFAULT_RETENTION;
		if(retention != null){
			retentionNumber = Integer.parseInt((String) retention);
			if(retentionNumber==0){
				log.error("ERROR STORING NEW MSISDN ON FILE");
				retentionNumber = DEFAULT_RETENTION-1;
			}
		}
		
		Map<Object, Object> current_list = getListElementsPrerequisite();
		
		if(current_list.size()>retentionNumber){
			current_list = trunkList(current_list, (current_list.size()-retentionNumber));
		}
		
		Integer indexRemoved = checkExsistingMsisdn(current_list, msisdn);
			
		if(indexRemoved>=0){
			current_list = rebuildSpecificIndex(current_list, indexRemoved);
		}
		
		if(current_list.size()>=retentionNumber){
			removeOldest(current_list);
			current_list = rebuildIndex(current_list);
		}
		
		
		insertNewMsisdnInCurrentList(current_list, msisdn);
		insertCompleteListInFile(current_list);
		
		items = getStoredMsisdn();
	}

	private Map<Object, Object> trunkList(Map<Object, Object> current_list, Integer elementsToDelete){
		List<Object> indexToDelete = new ArrayList<Object>();
		Set<Object> setKeyCurrentList = current_list.keySet();
		Iterator<Object> step1 = setKeyCurrentList.iterator();
		while(step1.hasNext()){
			Object currentKeyExtracted = step1.next();
			Integer currentKeyExtractedInteger = Integer.parseInt((String) currentKeyExtracted);
			if(currentKeyExtractedInteger<elementsToDelete){
				indexToDelete.add(currentKeyExtracted);
			}
		}
		Iterator<Object> step2 = indexToDelete.iterator();
		while(step2.hasNext()){
			Object currentKeyExtracted = step2.next();
			current_list.remove(currentKeyExtracted);
		}
		
		return rebuildIndexAfterTrunk(current_list);
	}
	
	private Map<Object, Object> rebuildIndexAfterTrunk(Map<Object, Object> current_list){
		Integer min = UPPER_VALUE;
		Set<Object> setKeyCurrentList = current_list.keySet();
		Iterator<Object> step1 = setKeyCurrentList.iterator();
		while(step1.hasNext()){
			Object currentKeyExtracted = step1.next();
			Integer currentKeyExtractedInteger = Integer.parseInt((String) currentKeyExtracted);
			if(currentKeyExtractedInteger<min){
				min = currentKeyExtractedInteger;
			}
		}
		
		Map<Object, Object> reindexList = new HashMap<Object, Object>();
		Iterator<Object> step2 = setKeyCurrentList.iterator();
		while(step2.hasNext()){
			Object currentKeyExtracted = step2.next();
			Integer currentKeyExtractedInteger = Integer.parseInt((String) currentKeyExtracted);
			Object currentValueExtracted = current_list.get(currentKeyExtracted);
			Integer nextKeyInteger = (currentKeyExtractedInteger-min);
			String nextKeyString = nextKeyInteger.toString();
			reindexList.put(nextKeyString, currentValueExtracted);
		}
		
		return reindexList;
	}
	
	private Map<Object, Object> getListElementsPrerequisite() {
		Map<Object, Object> exsistingListExtracted = new HashMap<Object, Object>();
		Properties pr = new Properties();
		try {
			pr.load(new FileInputStream(MSISDN_LIST_PATH));
			Set<Entry<Object, Object>> entryListExtracted = pr.entrySet();
			Iterator<Entry<Object, Object>> step1 = entryListExtracted.iterator();
			while (step1.hasNext()) {
				Entry<Object, Object> currentEntityExtracted = step1.next();
				exsistingListExtracted.put(currentEntityExtracted.getKey(), currentEntityExtracted.getValue());
			}
		} catch (IOException e) {
			return null;
		}
		return exsistingListExtracted;
	}
	
	private void removeOldest(Map<Object, Object> currentList){
		Set<Object> setKeyCurrentList = currentList.keySet();
		Integer min = setKeyCurrentList.size();
		Object minKey = null;
		Iterator<Object> step1 = setKeyCurrentList.iterator();
		while (step1.hasNext()) {
			Object currentKeyExtracted = step1.next();
			Integer currentIndexInteger = Integer.parseInt((String) currentKeyExtracted);
			if(currentIndexInteger<min){
				minKey = currentKeyExtracted;
				min = currentIndexInteger;
			}
		}
		currentList.remove(minKey);
	}
	
	private Map<Object, Object> rebuildIndex(Map<Object, Object> currentList){
		Map<Object, Object> reindexList = new HashMap<Object, Object>();
		Set<Object> setKeyCurrentList = currentList.keySet();
		Iterator<Object> it2 = setKeyCurrentList.iterator();
		while (it2.hasNext()) {
			Object currentKeyExtracted = it2.next();
			Integer currentKeyExtractedInteger = Integer.parseInt((String) currentKeyExtracted)-1;
			String currentKeyExtractedString = currentKeyExtractedInteger.toString();
			Object reindexValue = currentList.get(currentKeyExtracted);
			reindexList.put(currentKeyExtractedString, reindexValue);
		}
		return reindexList;
	}
	
	private void insertNewMsisdnInCurrentList(Map<Object, Object> currentList, String msisdn){
		Integer key_num = currentList.size();
		String key_string = key_num.toString();
		currentList.put(key_string, msisdn);
	}
	
	private void insertCompleteListInFile(Map<Object, Object> newElement){
		Properties prop = new Properties();
		OutputStream output = null;
		try {
			output = new FileOutputStream(MSISDN_LIST_PATH);
				
			prop.putAll(newElement);
			prop.store(output, null);
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (output != null) {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Integer checkExsistingMsisdn(Map<Object, Object> currentList, String msisdn){
		Object index = null;
		if(currentList.containsValue(msisdn)){
			Set<Object> setKeyCurrentList = currentList.keySet();
			Iterator<Object> step1 = setKeyCurrentList.iterator();
			while(step1.hasNext()){
				Object currentKeyExtracted = step1.next();
				String currentMsisdnExtracted = (String) currentList.get(currentKeyExtracted);
				if(currentMsisdnExtracted.equals(msisdn)){
					index = currentKeyExtracted;
				}
			}
			if(index!=null){
				currentList.remove(index);
				return Integer.parseInt((String) index) ;
			}
		}
		return NOT_FOUND_CODE;
	}
	
	private static Map<Object, Object> rebuildSpecificIndex(Map<Object, Object> currentList, int removedIndex){
		Integer localRemovedIndex = removedIndex;
		Map<Object, Object> reindexList = new HashMap<Object, Object>();
		Set<Object> setKeyCurrentList = currentList.keySet();
		Iterator<Object> it2 = setKeyCurrentList.iterator();
		while (it2.hasNext()) {
			Object currentKey = it2.next();
			Integer currentIndex = Integer.parseInt((String) currentKey);
			if(currentIndex-1 >= localRemovedIndex){
				Object valueToMove = currentList.get(currentKey);
				Integer tempIndex = currentIndex-1;
				String tempIndexString = (tempIndex).toString();
				reindexList.put(tempIndexString, valueToMove);
			}
			
			else {
				String currentIndexString = currentIndex.toString();
				Object valueToMove = currentList.get(currentKey);
				reindexList.put(currentIndexString, valueToMove);
			}
		}
		return reindexList;
	}
	
	public void checkFile(){
		Properties prop = new Properties();
	 
		prop = new Properties();
		try {
			prop.load(new FileInputStream(MSISDN_LIST_PATH));
		} catch (IOException e) {
			log.warn("MSISDN LIST FILE NOT FOUND");
		}
	}
}
