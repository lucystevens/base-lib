package uk.co.lukestevens.logging

/**
 * An enum for the levels of severity
 * that logs can have
 *
 * @author luke.stevens
 */
enum class LoggerLevel private constructor(val value: Int) {
	DEBUG(1),
	INFO(2),
	WARNING(3),
	ERROR(4);

	/**
	 * @return The severity value of this level, with 1 being lowest and 4 being highest
	 */
	fun value(): Int {
		return value
	}
}