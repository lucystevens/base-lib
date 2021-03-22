package uk.co.lukestevens.utils

import java.security.SecureRandom

/**
 * Static utilities class for generating random variables
 *
 * @author luke.stevens
 */
object RandomUtils {
	/**
	 * Generates a random string with a defined length consisting
	 * of the ASCII characters 33 - 126 (!-~) inclusive
	 * @param length The length of the random string
	 * @return A random string
	 */
	fun generateRandomString(length: Long): String {
		return generateRandomString(33, 127, length)
	}

	/**
	 * Generates a random string with of a certain length consisting
	 * of the ASCII characters within a defined range. Useful ranges are:<br>
	 * <ul>
	 * 	<li><b>Numbers</b>: 48,58</li>
	 * <li><b>Lowercase</b>: 97,123</li>
	 * <li><b>Uppercase</b>: 65,91</li>
	 * </ul>
	 * @param asciiStart The start of the ASCII range (inclusive)
	 * @param asciiEnd The end of the ASCII range (exclusive)
	 * @param length The length of the string
	 * @return A random string
	 */
	fun generateRandomString(asciiStart: Int, asciiEnd: Int, length: Long): String {
		val secureRandom = SecureRandom()
		return secureRandom.ints(asciiStart, asciiEnd)
			.limit(length)
			.mapToObj({ it.toChar() })
			.toString()
	}
}