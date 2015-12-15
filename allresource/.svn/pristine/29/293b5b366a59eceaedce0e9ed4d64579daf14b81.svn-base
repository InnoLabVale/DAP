package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.DedicatedAccount;
import com.innovery.mpm.allresource.interfaces.bean.air.DedicatedAccountInterface;

public class DedicatedModel extends AbstractTableModel {
	
	private String[] columnNames = { "Dedicated Account id", "Dedicated Account unit", "Dedicated Account unit code", "Dedicated Account value", "Dedicated Account expiry date"};
	private List<DedicatedAccountInterface> dedicatedList = new ArrayList<DedicatedAccountInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return dedicatedList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = dedicatedList.get(row).getDedicatedId();
                break;
        	case 1:
        		if(dedicatedList.get(row).getDedicatedUnit().equals("-")){
        			value = "-";
        		}
        		else if(dedicatedList.get(row).getDedicatedUnit().equals("0")){
        			value = "TIME";
        		}
        		else if(dedicatedList.get(row).getDedicatedUnit().equals("1")){
        			value = "MONEY";
        		}
        		else if(dedicatedList.get(row).getDedicatedUnit().equals("6")){
        			value = "VOLUME";
        		}
                break;
        	case 2:
                value = dedicatedList.get(row).getDedicatedUnit();
                break;
        	case 3:
                value = dedicatedList.get(row).getDedicatedValueNew();
                break;
        	case 4:
	            value = dedicatedList.get(row).getDedicatedExpiry();
	            break;
        }
        return value;
	}

	public List<DedicatedAccountInterface> getDedicatedList() {
		return dedicatedList;
	}

	public void setDedicatedList(List<DedicatedAccountInterface> dedicatedList) {
		this.dedicatedList = dedicatedList;
	}
	
	public void reset(){
		this.dedicatedList = new ArrayList<DedicatedAccountInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		DedicatedAccountInterface default_dedicated = new DedicatedAccount();
		default_dedicated.setDedicatedId("-");
		default_dedicated.setDedicatedUnit("-");
		default_dedicated.setDedicatedValueNew("-");
		default_dedicated.setDedicatedExpiry("-");
		dedicatedList.add(default_dedicated);
	}
}
