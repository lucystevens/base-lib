package uk.co.lukestevens.testing.mocks

import java.lang.reflect.Field
import java.util.HashMap
import java.util.Objects
import java.util.Properties
import uk.co.lukestevens.utils.EnvironmentVariables

/**
 * Mocking class for {@link EnvironmentVariables}
 * @author Luke Stevens
 *
 */
class EnvironmentVariableMocker
	private constructor(val variables: MutableMap<String, String>) {

	/**
	 * Add a new key-value to the environment variables mock being built
	 * @param key
	 * @param value
	 * @return This EnvironmentVariableMocker instance
	 */
	fun with(key: String, value: String): EnvironmentVariableMocker {
		this.variables.put(key, value)
		return this
	}

	/**
	 * Add a new map of variables to the environment variables mock being built
	 * @param variables
	 * @return This EnvironmentVariableMocker instance
	 */
	fun with(variables: Map<String, String> = mapOf()): EnvironmentVariableMocker {
		this.variables.putAll(variables)
		return this
	}

	/**
	 * Add variables from a Properties object to the environment variables mock being built
	 * @param props
	 * @return This EnvironmentVariableMocker instance
	 */
	fun with(props: Properties = Properties()): EnvironmentVariableMocker {
		props.forEach( { 
					this.variables.put(
						Objects.toString(it.key),
						Objects.toString(it.value))
				})
		return this
	}

	/**
	 * Mock the environment variables methods using the defined values
	 */
	fun mock() {
		mock(this.variables)
	}
	
		/**
	 * Mock the environment variables methods using provided, nullable values
	 */
	private fun mock(variables: MutableMap<String, String>?) {
		val f = EnvironmentVariables::class.java.getDeclaredField("variables")
		f.setAccessible(true)
		f.set(null, variables)
	}

	companion object {
		/**
		 * @param variables A map of variables to use as mocked environment variables
		 * @return A new mock builder using a specified set of environment variables
		 */
		fun build(variables: MutableMap<String, String> = mutableMapOf()): EnvironmentVariableMocker {
			return EnvironmentVariableMocker(variables)
		}

		/**
		 * Remove the current mocked environment variables.
		 * {@link EnvironmentVariables#get()} and {@link EnvironmentVariables#get(String)} will now call
		 * the System methods
		 */
		fun clear() {
			build().mock(null)
		}
	}
}