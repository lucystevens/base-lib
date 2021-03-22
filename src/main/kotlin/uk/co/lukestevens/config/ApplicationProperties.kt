package uk.co.lukestevens.config

/**
 * An interface for retrieving properties
 * about the application itself like name and version.
 *
 * @author Luke Stevens
 */
interface ApplicationProperties {
	/**
	 * @return The version of this application
	 */
	val applicationVersion: String

	/**
	 * @return The name of this application
	 */
	val applicationName: String

	/**
	 * @return The group id of this application
	 */
	val applicationGroup: String
}