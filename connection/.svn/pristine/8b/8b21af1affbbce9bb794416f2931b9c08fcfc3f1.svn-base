package com.innovery.mpm.connection.implementations.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import com.innovery.mpm.connection.interfaces.util.TransIdGeneratorInterface;

public class TransIdGenerator implements TransIdGeneratorInterface {

	public String generateTransID() {
		String transid_generated;
		
		try {
			InetAddress name_ip = InetAddress.getLocalHost();
			String[] local_ip = name_ip.toString().split("/");
			String[] local_ip_components = local_ip[1].split("\\.");
			transid_generated = local_ip_components[2]+"P"+getPre()+"P"+getPost()+"P"+local_ip_components[3];
		} catch (UnknownHostException e) {
			return getPre()+"P"+getPost();
		}
		
		return transid_generated;
	}

	private String getPre() {
		String random_pre = UUID.randomUUID().toString();
		return random_pre.substring(0, 3);
	}

	private String getPost() {
		String random_pre = UUID.randomUUID().toString();
		return random_pre.substring(0, 3);
	}
}
