package uk.co.lukestevens.logging;

public interface LoggerFactory {
	
	public Logger getLogger(Class<?> c);
	
	public Logger getLogger(String s);

}
