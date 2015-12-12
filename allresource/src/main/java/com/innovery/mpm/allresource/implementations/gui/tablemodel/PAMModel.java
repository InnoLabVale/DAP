package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.Pam;
import com.innovery.mpm.allresource.interfaces.bean.air.PamInterface;

public class PAMModel extends AbstractTableModel {
	
	private String[] columnNames = { "PAM service id", "PAM class id", "PAM schedule id", "Current PAM period", "Last evaluation date", "Service priority"};
	private List<PamInterface> pamList = new ArrayList<PamInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return pamList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = pamList.get(row).getPamServiceId();
                break;
        	case 1:
                value = pamList.get(row).getPamClassId();
                break;
        	case 2:
                value = pamList.get(row).getPamSchedulId();
                break;
        	case 3:
                value = pamList.get(row).getCurrentPamPeriod();
                break;
        	case 4:
                value = pamList.get(row).getLast_eval_date();
                break;
        	case 5:
                value = pamList.get(row).getService_priority();
                break;
        }
        return value;
	}

	public List<PamInterface> getPamList() {
		return pamList;
	}

	public void setPamList(List<PamInterface> pam) {
		this.pamList = pam;
	}
	
	public void reset(){
		this.pamList = new ArrayList<PamInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		PamInterface default_pam = new Pam();
		default_pam.setPamServiceId("-");
		default_pam.setPamClassId("-");
		default_pam.setPamSchedulId("-");
		default_pam.setCurrentPamPeriod("-");
		default_pam.setLast_eval_date("-");
		default_pam.setService_priority("-");
		pamList.add(default_pam);
	}
}
