package uk.co.lukestevens.threading

/**
 * An interface for decoupling services from thread management
 *
 * @author luke.stevens
 *
 */
fun interface ThreadExecutor {
	/**
	 * Run this code on the threads defined by this executor
	 * @param exe The code to run
	 */
	fun run(exe: Runnable)

	companion object {
		/**
		 * An executor that runs code on the same thread as the calling method.
		 */
		val SINGLE: ThreadExecutor = ThreadExecutor({ it.run() })

		/**
		 * An executor that runs code concurrently on a new thread
		 */
		val CONCURRENT: ThreadExecutor = ThreadExecutor({ Thread(it).start() })
	}
}