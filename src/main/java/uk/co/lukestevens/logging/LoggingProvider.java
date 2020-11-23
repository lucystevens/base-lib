package uk.co.lukestevens.logging;

public interface LoggingProvider {
	
	Logger getLogger(String name);
	
	default Logger getLogger(Class<?> className) {
		return this.getLogger(className.getName());
	}

}
