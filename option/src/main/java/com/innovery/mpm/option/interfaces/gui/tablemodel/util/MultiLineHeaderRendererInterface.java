package com.innovery.mpm.option.interfaces.gui.tablemodel.util;

import java.awt.Component;

import javax.swing.JTable;

public interface MultiLineHeaderRendererInterface {

	Component getTableCellRendererComponent(JTable table, Object value,
			boolean isSelected, boolean hasFocus, int row, int column);

}