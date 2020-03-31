package uk.co.lukestevens.utils;

import java.util.Calendar;
import java.util.Date;

public class Dates {
	
	private static Date currentDate;

	public static Date now() {
		return currentDate == null? new Date() : currentDate;
	}
	
	public static Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		if(currentDate != null) {
			cal.setTime(currentDate);
		}
		return cal;
	}
	
	public static Long millis() {
		return now().getTime();
	}

}
