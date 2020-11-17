package uk.co.lukestevens.utils;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamUtils {
	
	@SuppressWarnings("unchecked")
	public static <T> Stream<T> asStream(T...objects){
		return Arrays.asList(objects).stream();
	}

}
