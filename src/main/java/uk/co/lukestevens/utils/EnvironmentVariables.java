package uk.co.lukestevens.utils;

import java.util.Map;

import uk.co.lukestevens.testing.mocks.EnvironmentVariableMocker;

/**
 * Utils class providing a mockable wrapper around the
 * System environment variables.
 * Use {@link EnvironmentVariableMocker} to mock these
 * @author Luke Stevens
 *
 */
public class EnvironmentVariables {
	
	private static Map<String, String> variables;
	
	/**
	 * Mockable wrapper around {@link System#getenv()}.<br/>
	 * Returns all of the system environment variables in an unmodifiable Map.
	 * @return	an unmodifiable Map containing all of the system environment variables.
	 */
	public static Map<String, String> get(){
		return variables != null? variables : System.getenv();
	}
	
	/**
	 * Mockable wrapper around {@link System#getenv(String)}.<br/>
	 * Returns an environment variable.
	 * @param var the name of the environment variable
	 * @return the value of the specified environment variable
	 */
	public static String get(String key) {
		return variables != null? variables.get(key) : System.getenv(key);
	}

}
