package uk.co.lukestevens.logging;

/**
 * An interface for defining a provider of
 * Loggers.
 * 
 * @author Luke Stevens
 */
public interface LoggingProvider {
	
	/**
	 * @param name The name of the logger
	 * @return A new logger with the given name
	 */
	Logger getLogger(String name);
	
	/**
	 * @param className The class this logger is for
	 * @return A new logger with the name of the class
	 */
	default Logger getLogger(Class<?> className) {
		return this.getLogger(className.getName());
	}

}
