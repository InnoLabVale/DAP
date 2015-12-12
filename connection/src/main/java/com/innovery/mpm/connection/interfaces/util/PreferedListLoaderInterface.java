package com.innovery.mpm.connection.interfaces.util;

import java.util.List;

public interface PreferedListLoaderInterface {

	List<String> getStoredMsisdn();

	void store(String msisdn);

	void checkFile();

}