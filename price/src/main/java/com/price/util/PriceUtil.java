package com.price.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PriceUtil {

	private PriceUtil() {
	}

	public static Boolean validateNumber(String value) {
		return value.matches(Constants.CONSTANT_PATTERN_NUMBER);
	}

	public static Boolean validateDate(String obj) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.CUSTOM_PATTERN);
		sdf.setLenient(false);
		try {
			sdf.parse(obj);
		} catch (ParseException e) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}
	
	public static Date toDate(String obj) {
		SimpleDateFormat sdf = new SimpleDateFormat(Constants.CUSTOM_PATTERN);
		sdf.setLenient(false);
		try {
			return sdf.parse(obj);
		} catch (ParseException e) {
			return null;
		}
	}

}
