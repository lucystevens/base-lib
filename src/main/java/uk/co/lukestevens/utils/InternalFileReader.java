package uk.co.lukestevens.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;

/**
 * A utils class to easily read files from
 * internal locations within the application
 * 
 * @author luke.stevens
 */
public class InternalFileReader implements Closeable {
	
	private String path;
	private BufferedReader reader;

	/**
	 * Constructs a new file reader with a given path
	 * @param path The internal path to the file
	 */
	public InternalFileReader(String path) {
		this.path = path;
	}
	
	/**
	 * Constructs a new file reader for a file with a directory structure
	 * @param dir The internal directory structure
	 * @param file The file name
	 */
	public InternalFileReader(String dir, String file) {
		this("/" + dir + "/" + file);
	}
	
	/**
	 * Reads the file line by line to a stream, before joining
	 * the lines with the default system line separator
	 * @return The string content of the file
	 * @throws IOException If there is an exception reading from the file
	 */
	public String readFile() throws IOException {
		try {
			InputStream input = InternalFileReader.class.getResourceAsStream(this.path);
			this.reader = new BufferedReader(new InputStreamReader(input));
			
			StringBuilder builder = new StringBuilder();
			reader.lines().forEach(line -> builder.append(line + System.lineSeparator()));
			return builder.toString();
		} catch(UncheckedIOException io) {
			throw io.getCause();
		}
	}

	@Override
	public void close() throws IOException {
		this.reader.close();
	}

}
