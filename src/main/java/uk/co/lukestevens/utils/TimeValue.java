package uk.co.lukestevens.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * A class to represent a time value as a unit, and a value of that unit
 * 
 * e.g. 10 days, 35 minutes
 * 
 * @author luke.stevens
 */
public class TimeValue {
	
	private final TimeUnit unit;
	private final long value;
	
	/**
	 * Parse a TimeValue from a string. The string should represent
	 * some number preceding one of the following<br>
	 * <ul>
	 * 	<li>MILLISECOND(S)</li>
	 *  <li>SECOND(S)</li>
	 *  <li>MINUTE(S)</li>
	 *  <li>HOUR(S)</li>
	 *  <li>DAY(S)</li>
	 * </ul>
	 * @param value The string to parse
	 * @return A new TimeValue instance
	 */
	public static TimeValue parse(String value) {
		String processed = value.trim().toUpperCase();
		processed += processed.endsWith("S")? "" : "S";
		
		if(!processed.matches("\\d+ *(MILLISECONDS|SECONDS|MINUTES|HOURS|DAYS)")) {
			throw new RuntimeException("Could not parse TimeValue: '" + value  +"'");
		}
		
		long timeValue = Long.parseLong(processed.replaceAll("[^0-9]", ""));
		TimeUnit unit = TimeUnit.valueOf(processed.replaceAll("[^A-Z]", ""));
		return new TimeValue(unit, timeValue);
	}
	
	/**
	 * Create a new TimeValue
	 * @param unit The unit of time
	 * @param value The number of that unit this represents
	 */
	public TimeValue(TimeUnit unit, long value) {
		this.unit = unit;
		this.value = value;
	}
	
	/**
	 * Add the amount of time this object represents to a given date
	 * @param date The date to add to
	 * @return A date representing this amount of time ahead of the given date
	 */
	public Date addToDate(Date date) {
		long dateMillis = date.getTime();
		long newMillis = dateMillis += unit.toMillis(value);
		return new Date(newMillis);
	}
	
	/**
	 * Convert this TimeValue to a different time unit
	 * @param unit The time unit to convert to
	 * @return A new TimeValue object, representing the new unit
	 */
	public TimeValue convert(TimeUnit unit) {
		return new TimeValue(unit, unit.convert(value, this.unit));
	}

	/**
	 * @return The unit of this time value
	 */
	public TimeUnit getUnit() {
		return unit;
	}

	/**
	 * @return The value of this time value
	 */
	public long getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == null) {
			return false;
		}
		else if(obj instanceof TimeValue) {
			TimeValue other = (TimeValue) obj;
			return other.unit.toMillis(other.value) == this.unit.toMillis(this.value);
		}
		else {
			return false;
		}
	}

}
