package uk.co.lukestevens.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import uk.co.lukestevens.testing.mocks.DateMocker;

/**
 * Utils class providing a mockable wrapper around Date and Calendar instantiation. 
 * Use {@link DateMocker} to mock these
 * @author Luke Stevens
 *
 */
public class Dates {
	
	private static LocalDateTime currentDate;

	/**
	 * Mockable wrapper around {@link LocalDateTime#now()}.<br/>
	 */
	public static LocalDateTime now() {
		return currentDate == null?
				LocalDateTime.now() :
				currentDate;
	}

	public static Instant instant(){
		return now().toInstant(ZoneOffset.UTC);
	}
	
	/**
	 * Mockable wrapper around {@link System#currentTimeMillis()}.<br/>
	 * Answers the current time expressed as milliseconds since
	 * the time 00:00:00 UTC on January 1, 1970.
	 * @return the time in milliseconds.
	 */
	public static Long millis() {
		return instant().toEpochMilli();
	}

}
