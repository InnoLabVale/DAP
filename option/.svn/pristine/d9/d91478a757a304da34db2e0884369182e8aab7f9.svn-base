package com.innovery.mpm.option.interfaces.gui.tablemodel.util;

import java.util.List;

import javax.swing.JTable;

import com.innovery.mpm.option.implementations.gui.tablemodel.OptionBean;
import com.innovery.mpm.option.interfaces.gui.tablemodel.OptionBeanInterface;

public interface OptionTableModelInterface {

	int getColumnCount();

	int getRowCount();

	String getColumnName(int col);

	/**
	 * 
	 * @param row
	 * @param col
	 */
	Object getValueAt(int row, int col);

	List<OptionBeanInterface> getData();

	void setData(List<OptionBeanInterface> data);

	/**
	 * 
	 */
	void reset();

	/**
	 * 
	 * @param row
	 * @return
	 */
	String getOptionCode(int row);

	/**
	 * 
	 * @param row
	 */
	void removeRow(int row);

	/**
	 * 
	 * @param option
	 */
	void addRow(OptionBean option);

	void setColumnWidth(JTable table);

}