package uk.co.lukestevens.db

import java.io.Closeable
import java.io.IOException
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

interface DatabaseResult : Closeable {
	/**
	 * @return The underlying database connection
	 */
	val connection: Connection

	/**
	 * @return The underlying database result set
	 */
	val resultSet: ResultSet

	/**
	 * Processes this result by executing the given
	 * action on each element of the database result set.
	 * @param action The action to execute
	 * @throws SQLException if the result set has already been closed
	 * @throws IOException if there is an error during the action's execution
	 */
	@Throws(SQLException::class, IOException::class)
	fun processResultSet(action: ResultSetAction)

	/**
	 * Parses this result using the given parser to convert
	 * each result set element into an object
	 * @param parser The parser to use to parse the result set
	 * @return A list of parsed objects
	 * @throws SQLException if the result set has already been closed
	 * @throws IOException if there is an error during the parser's execution
	 */
	@Throws(SQLException::class, IOException::class)
	fun <T> parseResultSet(parser: ResultParser<T>): List<T>
}