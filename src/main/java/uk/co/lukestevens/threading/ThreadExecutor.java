package uk.co.lukestevens.threading;

/**
 * An interface for decoupling services from thread management
 * 
 * @author luke.stevens
 *
 */
public interface ThreadExecutor {
	
	/**
	 * An executor that runs code on the same thread as the calling method.
	 */
	public static final ThreadExecutor SINGLE = Runnable::run;
	
	/**
	 * An executor that runs code concurrently on a new thread
	 */
	public static final ThreadExecutor CONCURRENT = exe -> new Thread(exe).start();
	
	/**
	 * Run this code on the threads defined by this executor
	 * @param exe The code to run
	 */
	public void run(Runnable exe);

}
