package uk.co.lukestevens.db;

import java.io.Closeable;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseResult extends Closeable {
	
	/**
	 * @return The underlying database connection
	 */
	public Connection getConnection();
	
	/**
	 * @return The underlying database result set
	 */
	public ResultSet getResultSet();
	
	/**
	 * Processes this result by executing the given
	 * action on each element of the database result set.
	 * @param action The action to execute
	 * @throws SQLException if the result set has already been closed
	 * @throws IOException if there is an error during the action's execution
	 */
	public void processResultSet(ResultSetAction action) throws SQLException, IOException;
	
	/**
	 * Parses this result using the given parser to convert
	 * each result set element into an object
	 * @param parser The parser to use to parse the result set
	 * @return A list of parsed objects
	 * @throws SQLException if the result set has already been closed
	 * @throws IOException if there is an error during the parser's execution
	 */
	public <T> List<T> parseResultSet(ResultParser<T> parser) throws SQLException, IOException;

}
