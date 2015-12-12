package com.innovery.mpm.allresource.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.innovery.mpm.allresource.implementations.bean.air.ShareAccount;
import com.innovery.mpm.allresource.implementations.bean.air.UTs;
import com.innovery.mpm.allresource.interfaces.bean.air.ShareAccountInterface;
import com.innovery.mpm.allresource.interfaces.bean.air.UTsInterface;

public class ShareAccountModel extends AbstractTableModel {
	
	private String[] columnNamesUC = { "UC id", "Value"};
	private String[] columnNamesUT = { "UT id", "UC id", "Source", "Value"};
	private List<ShareAccountInterface> shareaccountList = new ArrayList<ShareAccountInterface>();
	private List<UTsInterface> utsList = new ArrayList<UTsInterface>();
	private String share_type;

	public ShareAccountModel(String share_type){
		this.share_type = share_type;
	}
	
	public int getColumnCount() {
		if(share_type.equals("uc")){
			return columnNamesUC.length;
		}
		else if(share_type.equals("ut")){
			return columnNamesUT.length;
		}
		return 0;
	}

	public int getRowCount() {
		if(share_type.equals("uc")){
			return shareaccountList.size();
		}
		else if(share_type.equals("ut")){
			return utsList.size();
		}
		
		return 0;		
	}
	
	public String getColumnName(int col){
		if(share_type.equals("uc")){
			return columnNamesUC[col];
		}
		else if(share_type.equals("ut")){
			return columnNamesUT[col];
		}
		return null;
	}
	
	/**
	 * 
	 */
	public Object getValueAt(int row, int col) {
        Object value = null;

        if(share_type.equals("uc")){
        	
        	switch (col) {
        	case 0:
                value = shareaccountList.get(row).getUCID();
                break;
        	case 1:
                value = shareaccountList.get(row).getUCMValueNew();
                break;
        	}	
        }
        if(share_type.equals("ut")){

        	switch (col) {
        	case 0:
                value = utsList.get(row).getUTID();
                break;
        	case 1:
                value = utsList.get(row).getUCID();
                break;
        	case 2:
                value = utsList.get(row).getSource();
                break;
        	case 3:
	            value = utsList.get(row).getUTMValueNew();
	            break;
        	}
        }
        return value;
	}

	public List<ShareAccountInterface> getShareaccountList() {
		return shareaccountList;
	}

	public void setShareaccountList(List<ShareAccountInterface> shareaccountList) {
		this.shareaccountList = shareaccountList;
		
		List<UTsInterface> utsList = new ArrayList<UTsInterface>();
		
		for (int i = 0; i < shareaccountList.size(); i++) {
			utsList.addAll(shareaccountList.get(i).getUTs());
		}
		this.utsList = utsList;
	}
	

	public List<UTsInterface> getUtsList() {
		return utsList;
	}

	public void setUtsList(List<UTsInterface> utsList) {
		this.utsList = utsList;
	}

	public void reset(){
		this.shareaccountList = new ArrayList<ShareAccountInterface>();
		this.utsList = new ArrayList<UTsInterface>();
		this.fireTableDataChanged();
	}
	
	public void setDefault(){
		ShareAccountInterface default_share = new ShareAccount();
		default_share.setUCID("-");
		default_share.setUCMValueNew("-");
		UTsInterface default_ut = new UTs();
		default_ut.setUTID("-");
		default_ut.setUTMValueNew("-");
		default_ut.setUCID("-");
		default_ut.setSource("-");
		shareaccountList.add(default_share);
		utsList.add(default_ut);
	}
}
