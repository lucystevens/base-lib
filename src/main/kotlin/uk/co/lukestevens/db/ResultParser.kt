package uk.co.lukestevens.db

import java.io.IOException
import java.sql.ResultSet
import java.sql.SQLException

/**
 * A function interface to define a method to
 * parse a result set into some given type
 *
 * @author luke.stevens
 *
 * @param <T> The type to parse the result set into
 */
fun interface ResultParser<T> {
	@Throws(IOException::class, SQLException::class)
	fun parse(rs: ResultSet): T
}