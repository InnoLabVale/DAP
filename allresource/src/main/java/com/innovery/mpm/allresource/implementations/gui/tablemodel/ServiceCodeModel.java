package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.ssh.ServiceCode;
import com.innovery.mpm.allresource.interfaces.bean.ssh.ServiceCodeInterface;
import com.innovery.mpm.allresource.interfaces.gui.util.AllResourceUtilInterface;

public class ServiceCodeModel extends AbstractTableModel {
	
	private String[] columnNames = { "Service code id", "Service code activation date", "Service code next fee date"};
	private List<ServiceCodeInterface> serviceCodeList = new ArrayList<ServiceCodeInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return serviceCodeList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = serviceCodeList.get(row).getServiceCodeId();
                break;
        	case 1:
                value = serviceCodeList.get(row).getActivationDate();
                break;
        	case 2:
                value = serviceCodeList.get(row).getNextFeeDate();
                break;
        }
        return value;
	}

	public List<ServiceCodeInterface> getServiceCodeList() {
		return serviceCodeList;
	}
	
	public String getOptionCode(int rowSelected){
		return serviceCodeList.get(rowSelected).getServiceCodeId();
	}

	public void setServiceCodeList(List<ServiceCodeInterface> serviceCodeList, AllResourceUtilInterface util) {
		List<ServiceCodeInterface> serviceCodeList_tmp = serviceCodeList;
		for(int i=0; i<serviceCodeList_tmp.size(); i++){
			ServiceCodeInterface tmp_service_code = serviceCodeList_tmp.get(i);
			ServiceCodeInterface new_service_code = new ServiceCode();
			new_service_code.setServiceCodeId(tmp_service_code.getServiceCodeId());
			new_service_code.setActivationDate(util.formatDate(tmp_service_code.getActivationDate()));
			new_service_code.setNextFeeDate(util.formatDate(tmp_service_code.getNextFeeDate()));
			this.serviceCodeList.add(new_service_code);
		}
	}
	
	public void reset(){
		this.serviceCodeList = new ArrayList<ServiceCodeInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		ServiceCodeInterface default_sc = new ServiceCode();
		default_sc.setServiceCodeId("-");
		default_sc.setActivationDate("-");
		default_sc.setNextFeeDate("-");
		serviceCodeList.add(default_sc);
	}
}
