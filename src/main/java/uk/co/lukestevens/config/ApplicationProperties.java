package uk.co.lukestevens.config;

/**
 * An interface for retrieving properties
 * about the application itself like name and version.
 * 
 * @author Luke Stevens
 */
public interface ApplicationProperties {
	
	/**
	 * @return The version of this application
	 */
	String getApplicationVersion();
	
	/**
	 * @return The name of this application
	 */
	String getApplicationName();

	/**
	 * @return The group id of this application
	 */
	String getApplicationGroup();
}
