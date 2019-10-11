package uk.co.lukestevens.logging;

/**
 * An enum for the levels of severity
 * that logs can have
 * 
 * @author luke.stevens
 */
public enum LoggerLevel {
	
	INFO(1),
	DEBUG(2),
	WARNING(3),
	ERROR(4);
	
	private int value;

	private LoggerLevel(int value) {
		this.value = value;
	}
	
	/**
	 * @return The severity value of this level, with 1 being lowest and 4 being highest
	 */
	public int value() {
		return value;
	}
}
