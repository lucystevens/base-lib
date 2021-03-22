package uk.co.lukestevens.logging

/**
 * An interface to define a simple logger
 *
 * @author luke.stevens
 */
interface Logger {
	/**
	 * Logs a message under the INFO LoggerLevel
	 * @param message The message to log
	 */
	fun info(message: String)

	/**
	 * Logs an exception under the INFO LoggerLevel
	 * @param e The exception to log
	 */
	fun info(e: Exception)

	/**
	 * Logs a message under the DEBUG LoggerLevel
	 * @param message The message to log
	 */
	fun debug(message: String)

	/**
	 * Logs an exception under the DEBUG LoggerLevel
	 * @param e The exception to log
	 */
	fun debug(e: Exception)

	/**
	 * Logs a message under the WARNING LoggerLevel
	 * @param message The message to log
	 */
	fun warning(message: String)

	/**
	 * Logs an exception under the WARNING LoggerLevel
	 * @param e The exception to log
	 */
	fun warning(e: Exception)

	/**
	 * Logs a message under the ERROR LoggerLevel
	 * @param message The message to log
	 */
	fun error(message: String)

	/**
	 * Logs an exception under the ERROR LoggerLevel
	 * @param e The exception to log
	 */
	fun error(e: Exception)

	/**
	 * Logs a message under a given LoggerLevel
	 * @param message The message to log
	 * @param level The level to log under
	 */
	fun log(message: String, level: LoggerLevel)

	/**
	 * Logs a message under a given LoggerLevel
	 * @param e The exception to log
	 * @param level The level to log under
	 */
	fun log(e: Exception, level: LoggerLevel)
}