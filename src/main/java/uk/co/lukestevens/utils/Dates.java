package uk.co.lukestevens.utils;

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
	
	private static Date currentDate;

	/**
	 * Mockable wrapper around {@link Date#Date()}.<br/>
     * Allocates a <code>Date</code> object and initializes it so that
     * it represents the time at which it was allocated, measured to the
     * nearest millisecond.
	 */
	public static Date now() {
		return currentDate == null? new Date() : currentDate;
	}
	
	/**
	 * Mockable wrapper around {@link Calendar#getInstance()}.<br/>
     * Gets a calendar using the default time zone and locale. The
     * <code>Calendar</code> returned is based on the current time
     * in the default time zone with the default
     * {@link Locale.Category#FORMAT FORMAT} locale.
	 * @return a Calendar
	 */
	public static Calendar getCalendar() {
		Calendar cal = Calendar.getInstance();
		if(currentDate != null) {
			cal.setTime(currentDate);
		}
		return cal;
	}
	
	/**
	 * Mockable wrapper around {@link System#currentTimeMillis()}.<br/>
	 * Answers the current time expressed as milliseconds since
	 * the time 00:00:00 UTC on January 1, 1970.
	 * @return the time in milliseconds.
	 */
	public static Long millis() {
		return now().getTime();
	}

}
