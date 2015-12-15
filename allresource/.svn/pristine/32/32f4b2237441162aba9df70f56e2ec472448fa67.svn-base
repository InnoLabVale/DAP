package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptions;
import com.innovery.mpm.allresource.interfaces.gui.tablemodel.optionmodelbean.ActivatedSubscriberOptionsInterface;

public class ActiveOptionModel extends AbstractTableModel {
	
	private String[] columnNames = { "Master", "Discount"};
	private List<ActivatedSubscriberOptionsInterface> option_list = new ArrayList<ActivatedSubscriberOptionsInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return option_list.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = option_list.get(row).getMaster();
                break;
        	case 1:
                value = option_list.get(row).getDiscount();
                break;

        }
        return value;
	}
	
	public List<ActivatedSubscriberOptionsInterface> getOptionList() {
		return option_list;
	}
	
	public String getOptionCode(int rowSelected){
		return option_list.get(rowSelected).getMaster();
	}

	public void setOptionList(List<ActivatedSubscriberOptionsInterface> option_list) {
		this.option_list = option_list;
	}
	
	public void reset(){
		this.option_list = new ArrayList<ActivatedSubscriberOptionsInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		ActivatedSubscriberOptions default_option = new ActivatedSubscriberOptions();
		default_option.setMaster("-");
		default_option.setDiscount("-");
	}
	
}
