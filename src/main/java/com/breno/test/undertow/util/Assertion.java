package com.breno.test.undertow.util;

public final class Assertion {

	private Assertion(){

	}
	
	public static <T> T assertNotNull(String message, T obj){
		if (obj != null){
			return obj;	
		}

		throw new IllegalArgumentException(message);
	}
	
	public static Integer assertInt(String message, String obj){
		try {
			return Integer.parseInt(obj);
		} catch (NumberFormatException e){
			throw new IllegalArgumentException(message, e);
		}
	}

}
