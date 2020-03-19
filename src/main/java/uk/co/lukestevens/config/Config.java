package uk.co.lukestevens.config;

import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @author luke.stevens
 */
public interface Config {
	
	/**
	 * @return The unique name of this application
	 */
	public String getApplicationName();
	
	/**
	 * @return The running version of this application
	 */
	public String getApplicationVersion();
	
	/**
	 * Gets a set of config entries. If this config is loaded
	 * from the database, this will return only the currently
	 * loaded entries, and will not update from the database.
	 * @return A set of entries in this config
	 */
	public Set<Entry<Object, Object>> entrySet();
	
	
	/**
	 * Gets a mandatory property as a String
	 * @param key The property key for which to return the configured value
	 * @return The string value associated with the given key
	 * @throws ConfigException if the given key does not exist
	 */
	public String getAsString(String key);
	
	/**
	 * Gets an optional property as a String
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The string value associated with the given key, or the default value
	 * if a configured value has not been set
	 */
	public String getAsStringOrDefault(String key, String def);
	
	/**
	 * Gets a mandatory property, parsed to a given type
	 * @param key The property key for which to return the configured value
	 * @param parser The parser function used to convert the string representation
	 * of the property value to the expected type
	 * @return The value associated with the given key, parsed to the required type
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed
	 */
	public <T> T getParsedValue(String key, KeyParser<T> parser);
	
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
	public <T> T getParsedValueOrDefault(String key, KeyParser<T> parser, T def);
	
	/**
	 * Gets the unencrypted value of an encrypted, mandatory property
	 * @param key The property key for which to return the configured value
	 * @return The unencrypted value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be decrypted
	 */
	public String getEncrypted(String key);
	
	/**
	 * Gets the value of a mandatory property parsed as an integer
	 * @param key The property key for which to return the configured value
	 * @return The integer value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an integer
	 */
	public int getAsInt(String key);
	
	/**
	 * Gets the value of an optional property parsed as an integer
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The integer value associated with the given key, or the default value
	 * if a configured value does not exist.
	 * @throws ConfigException if the given key exists but cannot be parsed to an integer
	 */
	public int getAsIntOrDefault(String key, int def);
	
	/**
	 * Gets the value of a mandatory property parsed as a double
	 * @param key The property key for which to return the configured value
	 * @return The double value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an double
	 */
	public double getAsDouble(String key);
	
	/**
	 * Gets the value of an optional property parsed as a double
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The double value associated with the given key, or the default value
	 * if a configured value does not exist.
	 * @throws ConfigException if the given key exists but cannot be parsed to a double
	 */
	public double getAsDoubleOrDefault(String key, double def);
	
	/**
	 * Gets the value of a mandatory property parsed as a boolean.
	 * The boolean value is considered <i>true</i> if it is equal to
	 * the word "true", ignoring case.
	 * @param key The property key for which to return the configured value
	 * @return The boolean value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to an boolean
	 */
	public boolean getAsBoolean(String key);
	
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
	public boolean getAsBooleanOrDefault(String key, boolean def);
	
	/**
	 * Gets the value of a mandatory property parsed as a list of strings.
	 * The list of strings is parsed by comma separated values
	 * @param key The property key for which to return the configured value
	 * @return The list value associated with the given key
	 * @throws ConfigException if the given key does not exist, or if it cannot
	 * be parsed to a list
	 */
	public List<String> getAsList(String key);
	
	/**
	 * Gets the value of a optional property parsed as a list of strings.
	 * The list of strings is parsed by comma separated values
	 * @param key The property key for which to return the configured value
	 * @param def The default value to return if the value has not been configured
	 * @return The list value associated with the given key
	 * @throws ConfigException if the given key exists but cannot
	 * be parsed to a list
	 */
	public List<String> getAsListOrDefault(String key, List<String> def);
	
}
