package uk.co.lukestevens.utils;

import java.io.PrintWriter;
import java.io.StringWriter;

public class StringUtils {

	public static String parseStackTrace(Exception e) {
        StringWriter sw = new StringWriter();
        e.printStackTrace(new PrintWriter(sw));
        return sw.toString();
	}

}
