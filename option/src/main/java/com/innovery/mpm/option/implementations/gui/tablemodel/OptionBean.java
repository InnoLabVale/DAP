package com.innovery.mpm.option.implementations.gui.tablemodel;

import java.util.ArrayList;
import java.util.List;

import com.innovery.mpm.option.interfaces.gui.tablemodel.OptionBeanInterface;

/**
 * 
 * @author Daniela R. Auricchio
 * class used to represent an option released and showed in OptionModel tabs, in AllResource page.
 * This bean is also used in XmlReader and XmlWriter to represent the option to read o write in XML list of options.
 *
 */
public class OptionBean implements OptionBeanInterface{

	private String description;
	private String master;
	private List<String> sc;
	private List<String> discounts;
	private List<String> sc_discounts;
	private List<String> daList;
	private List<String> accumulatorList;
	private List<String> offerIdList;
	private String community;
	private List<String> fafList;
	private String so;
	private String pplan;
	private String agi;
	private List<String> UC;
	private List<String> UT;


	public OptionBean() {
		sc = new ArrayList<String>();
		discounts = new ArrayList<String>(14);
		sc_discounts = new ArrayList<String>(14);
		daList = new ArrayList<String>();
		accumulatorList = new ArrayList<String>();
		offerIdList = new ArrayList<String>();
		fafList = new ArrayList<String>();
		UC = new ArrayList<String>();
		UT = new ArrayList<String>();
		description = "";
		master = "";
		community = "";
		so = "";
		pplan = "";
		agi = "";
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMaster() {
		return master;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public List<String> getSc() {
		return sc;
	}

	public void setSc(List<String> sc) {
		this.sc = sc;
	}

	public List<String> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<String> discounts) {
		this.discounts = discounts;
	}
	
	public List<String> getSc_discounts() {
		return sc_discounts;
	}

	public void setSc_discounts(List<String> sc_discounts) {
		this.sc_discounts = sc_discounts;
	}

	public List<String> getDaList() {
		return daList;
	}

	public void setDaList(List<String> daList) {
		this.daList = daList;
	}

	public List<String> getAccumulatorList() {
		return accumulatorList;
	}

	public void setAccumulatorList(List<String> accumulatorList) {
		this.accumulatorList = accumulatorList;
	}

	public List<String> getOfferIdList() {
		return offerIdList;
	}

	public void setOfferIdList(List<String> offerIdList) {
		this.offerIdList = offerIdList;
	}

	public String getCommunity() {
		return community;
	}

	public void setCommunity(String community) {
		this.community = community;
	}

	public List<String> getFafList() {
		return fafList;
	}

	public void setFafList(List<String> fafList) {
		this.fafList = fafList;
	}

	public String getSo() {
		return so;
	}

	public void setSo(String so) {
		this.so = so;
	}

	public String getPplan() {
		return pplan;
	}

	public void setPplan(String pplan) {
		this.pplan = pplan;
	}

	public String getAgi() {
		return agi;
	}

	public void setAgi(String agi) {
		this.agi = agi;
	}

	public List<String> getUC() {
		return UC;
	}

	public void setUC(List<String> uC) {
		UC = uC;
	}

	public List<String> getUT() {
		return UT;
	}

	public void setUT(List<String> uT) {
		UT = uT;
	}

	/**
	 * 
	 * @return
	 */
	public String getSctoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : sc) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getDiscountstoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : discounts) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	public String getScDiscountstoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : sc_discounts) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getDaListtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : daList) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getAccumulatorListtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : accumulatorList) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}


	/**
	 * 
	 * @return
	 */
	public String getOfferIdListtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : offerIdList) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getFafListtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : fafList) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getUCtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : UC) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

	/**
	 * 
	 * @return
	 */
	public String getUTtoString() {
		StringBuilder sb = new StringBuilder();
		for (String string : UT) {
			sb.append(string).append("\n");
		}
  		if (sb.length()!=0) {
  			//delete last occurrence of ,
  			sb.deleteCharAt(sb.lastIndexOf("\n"));
		}
  		return sb.toString();
	}

}
