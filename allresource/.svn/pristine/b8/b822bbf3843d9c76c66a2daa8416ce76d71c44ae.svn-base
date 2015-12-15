package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.Faf;
import com.innovery.mpm.allresource.interfaces.bean.air.FafInterface;

public class FafModel extends AbstractTableModel {
	
	private String[] columnNames = { "Faf number", "K indicator"};
	private List<FafInterface> fafList = new ArrayList<FafInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return fafList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = fafList.get(row).getNumber();
                break;
        	case 1:
                value = fafList.get(row).getKindicator();
                break;
        }
        return value;
	}

	public List<FafInterface> getFafList() {
		return fafList;
	}

	public void setFafList(List<FafInterface> fafList) {
		this.fafList = fafList;
	}
	
	public void reset(){
		this.fafList = new ArrayList<FafInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		FafInterface default_faf = new Faf();
		default_faf.setNumber("-");
		default_faf.setKindicator("-");
		fafList.add(default_faf);
	}
}
