package uk.co.lukestevens.config

import java.io.IOException
import kotlin.collections.Map.Entry

/**
 * An interface for a configuration class with methods
 * to get properties parsed as various primitive
 * values
 *
 * @author luke.stevens
 */
interface Config {
	/**
	 * Gets a set of config entries. If this config is loaded
	 * from the database, this will return only the currently
	 * loaded entries, and will not update from the database.
	 * @return A set of entries in this config
	 */
	fun entrySet(): Set<Entry<Any, Any>>

	/**
	 * Gets a mandatory property as a String
	 * @param key The property key for which to return the configured value
	 * @return The string value associated with the given key
	 * @throws ConfigException if the given key does not exist
	 */
	fun getAsString(key: String): String

	/**
	 * Gets an optional property as a String
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The string value associated with the given key, or the default value
	 * if a configured value has not been set
	 */
	fun getAsStringOrDefault(key: String, def: String): String

	/**
	 * Gets a mandatory property, parsed to a given type
	 * @param key The property key for which to return the configured value
	 * @param parser The parser function used to convert the string representation
	 * of the property value to the expected type
	 * @return The value associated with the given key, parsed to the required type
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed
	 */
	fun <T> getParsedValue(key: String, parser: KeyParser<T>): T

	/**
	 * Gets an optional property, parsed to a given type
	 * @param key The property key for which to return the configured value
	 * @param parser The parser function used to convert the string representation
	 * of the property value to the expected type
	 * @param def The default value to return if the value has not been configured
	 * @return The value associated with the given key parsed to the required type,
	 * or the default value if a configured value has not been set.
	 * @throws ConfigException if the given key exists but cannot be parsed
	 */
	fun <T> getParsedValueOrDefault(key: String, parser: KeyParser<T>, def: T): T

	/**
	 * Gets the value of a mandatory property parsed as an integer
	 * @param key The property key for which to return the configured value
	 * @return The integer value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an integer
	 */
	fun getAsInt(key: String): Int

	/**
	 * Gets the value of an optional property parsed as an integer
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The integer value associated with the given key, or the default value
	 * if a configured value does not exist.
	 * @throws ConfigException if the given key exists but cannot be parsed to an integer
	 */
	fun getAsIntOrDefault(key: String, def: Int): Int

	/**
	 * Gets the value of a mandatory property parsed as a double
	 * @param key The property key for which to return the configured value
	 * @return The double value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an double
	 */
	fun getAsDouble(key: String): Double

	/**
	 * Gets the value of an optional property parsed as a double
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The double value associated with the given key, or the default value
	 * if a configured value does not exist.
	 * @throws ConfigException if the given key exists but cannot be parsed to a double
	 */
	fun getAsDoubleOrDefault(key: String, def: Double): Double

	/**
	 * Gets the value of a mandatory property parsed as a boolean.
	 * The boolean value is considered <i>true</i> if it is equal to
	 * the word "true", ignoring case.
	 * @param key The property key for which to return the configured value
	 * @return The boolean value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an boolean
	 */
	fun getAsBoolean(key: String): Boolean

	/**
	 * Gets the value of an optional property parsed as a boolean.
	 * The boolean value is considered <i>true</i> if it is equal to
	 * the word "true", ignoring case.
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The boolean value associated with the given key, or the default value
	 * if a configured value does not exist.
	 * @throws ConfigException if the given key exists but cannot be parsed to a boolean
	 */
	fun getAsBooleanOrDefault(key: String, def: Boolean): Boolean

	/**
	 * Gets the value of a mandatory property parsed as a list of strings.
	 * The list of strings is parsed by comma separated values
	 * @param key The property key for which to return the configured value
	 * @return The list value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to a list
	 */
	fun getAsList(key: String): List<String>

	/**
	 * Gets the value of a optional property parsed as a list of strings.
	 * The list of strings is parsed by comma separated values
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The list value associated with the given key
	 * @throws ConfigException if the given key exists but cannot
	 * be parsed to a list
	 */
	fun getAsListOrDefault(key: String, def: List<String>): List<String>

	/**
	 * Loads current configuration from the source
	 * @throws IOException
	 */
	@Throws(IOException::class)
	fun load()
}