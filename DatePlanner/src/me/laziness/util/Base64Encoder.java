package me.laziness.util;

import java.util.Base64;

public class Base64Encoder {
	
	public static String encode(byte[] arr) {
		
		return new String(Base64.getEncoder().encode(arr));
		
	}
	
} //class Base64Encoder;
