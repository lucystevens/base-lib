package uk.co.lukestevens.utils

import java.io.BufferedReader
import java.io.Closeable
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.UncheckedIOException

/**
 * A utils class to easily read files from
 * internal locations within the application
 *
 * @author luke.stevens
 */
class InternalFileReader
/**
 * Constructs a new file reader with a given path
 * @param path The internal path to the file
 */
	(val path: String) {


	/**
	 * Constructs a new file reader for a file with a directory structure
	 * @param dir The internal directory structure
	 * @param file The file name
	 */
	constructor(dir: String, file: String) : this("/$dir/$file") 

	/**
	 * Reads the file line by line to a stream, before joining
	 * the lines with the default system line separator
	 * @return The string content of the file
	 * @throws IOException If there is an exception reading from the file
	 */
	@Throws(IOException::class)
	fun readFile(joiner: String = System.lineSeparator()): String {
		val input = InternalFileReader::class.java.getResourceAsStream(this.path)
		BufferedReader(InputStreamReader(input)).use {
			val builder = StringBuilder()
			it.lines().forEach({ builder.append(it + joiner) })
			return builder.toString()
		}
	}

}