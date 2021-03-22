package uk.co.lukestevens.logging

/**
 * An interface for defining a provider of
 * Loggers.
 *
 * @author Luke Stevens
 */
interface LoggingProvider {
	/**
	 * @param name The name of the logger
	 * @return A new logger with the given name
	 */
	fun getLogger(name: String): Logger

	/**
	 * @param className The class this logger is for
	 * @return A new logger with the name of the class
	 */
	fun getLogger(className: Class<*>): Logger {
		return this.getLogger(className.getName())
	}
}