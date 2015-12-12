package com.innovery.mpm.connection.implementations.util;

import com.innovery.mpm.connection.interfaces.util.RedirectNamesInterface;

public class RedirectNames implements RedirectNamesInterface {
	
	public final String _INDEX_PAGE = "indexPage";
	
	public final String _LOGIN_PAGE = "loginPage";
	
	public final String _COMMAND_SELECTION_PAGE = "commandSelectionPage";

	public String get_INDEX_PAGE() {
		return _INDEX_PAGE;
	}

	public String get_LOGIN_PAGE() {
		return _LOGIN_PAGE;
	}

	public String get_COMMAND_SELECTION_PAGE() {
		return _COMMAND_SELECTION_PAGE;
	}
	
}
