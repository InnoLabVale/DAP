package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.Accumulator;
import com.innovery.mpm.allresource.interfaces.bean.air.AccumulatorInterface;

public class AccumulatorModel extends AbstractTableModel{
	
	private String[] columnNames = { "Accumulator id", "Accumulator value", "Accumulator start date", "Accumulator end date"};
	private List<AccumulatorInterface> accumulatorList = new ArrayList<AccumulatorInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return accumulatorList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = accumulatorList.get(row).getAccId();
                break;
        	case 1:
                value = accumulatorList.get(row).getAccValueAbs();
                break;
        	case 2:
                value = accumulatorList.get(row).getStartDate();
                break;
        	case 3:
	            value = accumulatorList.get(row).getEndDate();
	            break;
        }
        return value;
	}
	
	public List<AccumulatorInterface> getAccumulatorList() {
		return accumulatorList;
	}

	public void setAccumulatorList(List<AccumulatorInterface> accumulatorList) {
		this.accumulatorList = accumulatorList;
	}
	
	public void reset(){
		this.accumulatorList = new ArrayList<AccumulatorInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		AccumulatorInterface default_accoumulator = new Accumulator();
		default_accoumulator.setAccId("-");
		default_accoumulator.setAccValueAbs("-");
		default_accoumulator.setStartDate("-");
		default_accoumulator.setEndDate("-");
		accumulatorList.add(default_accoumulator);
	}
	
}
