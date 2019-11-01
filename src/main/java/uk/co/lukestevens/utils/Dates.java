package uk.co.lukestevens.utils;

import java.util.Date;

public class Dates {
	
	private static Date currentDate;

	public static Date now() {
		return currentDate == null? new Date() : currentDate;
	}
	
	public static Long millis() {
		return now().getTime();
	}

}
