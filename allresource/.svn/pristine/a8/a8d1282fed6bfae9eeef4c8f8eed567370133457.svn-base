package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.PromotionPlan;
import com.innovery.mpm.allresource.interfaces.bean.air.PromotionPlanInterface;

public class PromotionModel extends AbstractTableModel {
	
	private String[] columnNames = { "Promotion plan id", "Promotion plan start date", "Promotion plan end date"};
	private List<PromotionPlanInterface> pplanList = new ArrayList<PromotionPlanInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return pplanList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = pplanList.get(row).getPromotionPlan();
                break;
        	case 1:
                value = pplanList.get(row).getStartDate();
                break;
        	case 2:
                value = pplanList.get(row).getEndDate();
                break;
        }
        return value;
	}

	public List<PromotionPlanInterface> getPplanList() {
		return pplanList;
	}

	public void setPplanList(List<PromotionPlanInterface> pplanList) {
		this.pplanList = pplanList;
	}
	
	public void reset(){
		this.pplanList = new ArrayList<PromotionPlanInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		PromotionPlanInterface default_promotion = new PromotionPlan();
		default_promotion.setPromotionPlan("-");
		default_promotion.setStartDate("-");
		default_promotion.setEndDate("-");
		pplanList.add(default_promotion);
	}
}
