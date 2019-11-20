package uk.co.lukestevens.utils;

/**
 * Utils class providing several lambda functions for ease of use
 * 
 * @author Luke
 */
public class Functions {
	
	/**
	 * A BinaryOperator function which returns the first of two arguments
	 * @param opt1 The argument that will be returned
	 * @param opt2 The second argument that will be ignored
	 * @return The first argument
	 */
	public static <U> U pickFirst(U opt1, U opt2) {
		return opt1;
	}
	
	/**
	 * A BinaryOperator function which returns the second of two arguments
	 * @param opt1 The first argument that will be ignored
	 * @param opt2 The second argument that will be returned
	 * @return The second argument
	 */
	public static <U> U pickLast(U opt1, U opt2) {
		return opt2;
	}

}
