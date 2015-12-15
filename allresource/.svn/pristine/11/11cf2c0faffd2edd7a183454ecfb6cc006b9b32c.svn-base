package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.OfferId;
import com.innovery.mpm.allresource.interfaces.bean.air.OfferIdInterface;

public class OfferModel extends AbstractTableModel {
	
	private String[] columnNames = { "Offer id", "Offer start date", "Offer end date", "Offer type"};
	private List<OfferIdInterface> offerList = new ArrayList<OfferIdInterface>();

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return offerList.size();
	}
	
	public String getColumnName(int col){
		return columnNames[col];
	}
	
	public Object getValueAt(int row, int col) {
        Object value = null;

        switch (col) {
        	case 0:
                value = offerList.get(row).getOfferId();
                break;
        	case 1:
                value = offerList.get(row).getStartDate();
                break;
        	case 2:
                value = offerList.get(row).getExpiryDate();
                break;
        	case 3:
                value = offerList.get(row).getType();
                break;
        }
        return value;
	}

	public List<OfferIdInterface> getOfferList() {
		return offerList;
	}

	public void setOfferList(List<OfferIdInterface> offerList) {
		this.offerList = offerList;
	}
	
	public void reset(){
		this.offerList = new ArrayList<OfferIdInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		OfferIdInterface default_offer = new OfferId();
		default_offer.setOfferId("-");
		default_offer.setStartDate("-");
		default_offer.setExpiryDate("-");
		default_offer.setType("-");
		offerList.add(default_offer);
	}
}
