package uk.co.lukestevens.utils

import uk.co.lukestevens.testing.mocks.EnvironmentVariableMocker

/**
 * Utils class providing a mockable wrapper around the
 * System environment variables.
 * Use {@link EnvironmentVariableMocker} to mock these
 * @author Luke Stevens
 *
 */
object EnvironmentVariables {
	private var variables: MutableMap<String, String>? = null

	/**
	 * Mockable wrapper around {@link System#getenv()}.<br/>
	 * Returns all of the system environment variables in an unmodifiable Map.
	 * @return    an unmodifiable Map containing all of the system environment variables.
	 */
	fun get(): MutableMap<String, String> {
		return variables ?: System.getenv()
	}

	/**
	 * Mockable wrapper around {@link System#getenv(String)}.<br/>
	 * Returns an environment variable.
	 * @param key the name of the environment variable
	 * @return the value of the specified environment variable
	 */
	fun get(key: String): String? {
		return variables?.get(key)?: System.getenv(key)
	}
}