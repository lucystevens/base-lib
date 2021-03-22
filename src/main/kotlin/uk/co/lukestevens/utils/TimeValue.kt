package uk.co.lukestevens.utils

import java.util.Date
import java.util.concurrent.TimeUnit
import java.text.ParseException

/**
 * A class to represent a time value as a unit, and a value of that unit
 *
 * e.g. 10 days, 35 minutes
 *
 * @author luke.stevens
 */
class TimeValue
/**
 * Create a new TimeValue
 * @param unit The unit of time
 * @param value The number of that unit this represents
 */
	(val unit: TimeUnit, val value: Long) {

	/**
	 * Add the amount of time this object represents to a given date
	 * @param date The date to add to
	 * @return A date representing this amount of time ahead of the given date
	 */
	fun addToDate(date: Date): Date {
		return Date(date.getTime() + unit.toMillis(value))
	}

	/**
	 * Convert this TimeValue to a different time unit
	 * @param unit The time unit to convert to
	 * @return A new TimeValue object, representing the new unit
	 */
	fun convert(unit: TimeUnit): TimeValue {
		return TimeValue(unit, unit.convert(value, this.unit))
	}

	@Override
	override fun equals(other: Any?): Boolean {
		return when(other) {
			null -> false
			is TimeValue -> other.convert(TimeUnit.MILLISECONDS) == this.convert(TimeUnit.MILLISECONDS)
			else -> false
		}
	}

	companion object {
		
		private val timeValueRegex = """\d+ *(MILLISECONDS|SECONDS|MINUTES|HOURS|DAYS)"""
				
		/**
		 * Parse a TimeValue from a string. The string should represent
		 * some number preceding one of the following<br>
		 * <ul>
		 * 	<li>MILLISECOND(S)</li>
		 * <li>SECOND(S)</li>
		 * <li>MINUTE(S)</li>
		 * <li>HOUR(S)</li>
		 * <li>DAY(S)</li>
		 * </ul>
		 * @param value The string to parse
		 * @return A new TimeValue instance
		 */
		fun parse(value: String): TimeValue {
			var processed = value.trim().toUpperCase()
			if(!processed.endsWith("S")) { processed += "S" }
			if (!processed.matches(Regex(timeValueRegex))) {
				throw ParseException("Could not parse TimeValue: '$value'", 0)
			}
			
			val timeValue = processed.replace(Regex("[^0-9]"), "").toLong()
			val unit = TimeUnit.valueOf(value = processed.replace(Regex("[^A-Z]"), ""))
			return TimeValue(unit, timeValue)
		}
	}
}