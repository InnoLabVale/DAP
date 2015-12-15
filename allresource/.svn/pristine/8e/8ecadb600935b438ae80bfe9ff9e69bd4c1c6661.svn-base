package com.innovery.mpm.allresource.implementations.util;

public class AllResourceServiceOfferingConverter {

	public static String fromBitToDecimal(String bit_sequence){
		StringBuffer bit_sequence_reverse = new StringBuffer(bit_sequence);
		bit_sequence_reverse.reverse();
		char[] bit_array = bit_sequence_reverse.toString().toCharArray();
		Integer index = 0;
		for(int i=0; i<bit_array.length; i++){
			if(bit_array[i]=='1'){
				index = index+((int)Math.pow(2, i));
			}
		}
		return index.toString();
	}
}
