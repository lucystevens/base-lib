package uk.co.lukestevens.config

/**
 * A functional interface representing a method used
 * to parse a String value into any other type
 * of value
 *
 * @author luke.stevens
 *
 * @param <T> The type to parse a String value into
 */
@FunctionalInterface
interface KeyParser<T> {
	/**
	 * Parses a String value into a given type
	 * @param value The String value to parse
	 * @return An instance of the given type, parsed from the String value
	 * @throws Exception If there is an error parsing the value
	 */
	@Throws(Exception::class)
	fun parse(value: String): T
}