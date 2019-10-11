package uk.co.lukestevens.logging;

/**
 * An interface to define a simple logger
 * 
 * @author luke.stevens
 * @see LogManager
 */
public interface Logger {
	
	/**
	 * Logs a message under the INFO LoggerLevel
	 * @param message The message to log
	 */
	public void info(String message);
	
	/**
	 * Logs an exception under the INFO LoggerLevel
	 * @param e The exception to log
	 */
	public void info(Exception e);
	
	/**
	 * Logs a message under the DEBUG LoggerLevel
	 * @param message The message to log
	 */
	public void debug(String message);
	
	/**
	 * Logs an exception under the DEBUG LoggerLevel
	 * @param e The exception to log
	 */
	public void debug(Exception e);
	
	/**
	 * Logs a message under the WARNING LoggerLevel
	 * @param message The message to log
	 */
	public void warning(String message);
	
	/**
	 * Logs an exception under the WARNING LoggerLevel
	 * @param e The exception to log
	 */
	public void warning(Exception e);
	
	/**
	 * Logs a message under the ERROR LoggerLevel
	 * @param message The message to log
	 */
	public void error(String message);
	
	/**
	 * Logs an exception under the ERROR LoggerLevel
	 * @param e The exception to log
	 */
	public void error(Exception e);
	
	/**
	 * Logs a message under a given LoggerLevel
	 * @param message The message to log
	 * @param level The level to log under
	 */
	public void log(String message, LoggerLevel level);
	
	/**
	 * Logs a message under a given LoggerLevel
	 * @param e The exception to log
	 * @param level The level to log under
	 */
	public void log(Exception e, LoggerLevel level);

}
