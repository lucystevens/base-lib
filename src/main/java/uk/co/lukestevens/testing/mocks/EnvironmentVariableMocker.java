package uk.co.lukestevens.testing.mocks;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

import uk.co.lukestevens.utils.EnvironmentVariables;

/**
 * Mocking class for {@link EnvironmentVariables}
 * @author Luke Stevens
 *
 */
public class EnvironmentVariableMocker {
	
	/**
	 * @return A new mock builder using an empty set of environment variables
	 */
	public static EnvironmentVariableMocker build() {
		return build(new HashMap<>());
	}
	
	/**
	 * @param variables A map of variables to use as mocked environment variables
	 * @return A new mock builder using a specified set of environment variables
	 */
	public static EnvironmentVariableMocker build(Map<String, String> variables) {
		return new EnvironmentVariableMocker(variables);
	}
	
	/**
	 * Remove the current mocked environment variables.
	 * {@link EnvironmentVariables#get()} and {@link EnvironmentVariables#get(String)} will now call
	 * the System methods
	 */
	public static void clear() {
		build(null).mock();
	}
	
	private final Map<String, String> variables;

	private EnvironmentVariableMocker(Map<String, String> variables) {
		this.variables = variables;
	}
	
	/**
	 * Add a new key-value to the environment variables mock being built
	 * @param key
	 * @param value
	 * @return This EnvironmentVariableMocker instance
	 */
	public EnvironmentVariableMocker with(String key, String value) {
		this.variables.put(key, value);
		return this;
	}
	
	/**
	 * Add a new map of variables to the environment variables mock being built
	 * @param variables
	 * @return This EnvironmentVariableMocker instance
	 */
	public EnvironmentVariableMocker with(Map<String, String> variables) {
		this.variables.putAll(variables);
		return this;
	}
	
	/**
	 * Add variables from a Properties object to the environment variables mock being built
	 * @param props
	 * @return This EnvironmentVariableMocker instance
	 */
	public EnvironmentVariableMocker with(Properties props) {
		props.entrySet()
			 .forEach(e -> this.variables.put(
					 Objects.toString(e.getKey()),
					 Objects.toString(e.getValue())));
		return this;
	}
	
	/**
	 * Mock the environment variables methods using the defined values
	 */
	public void mock() {
		try {
			Field f = EnvironmentVariables.class.getDeclaredField("variables");
			f.setAccessible(true);
			f.set(null, this.variables);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
