// EXAMPLE OF THREADS BY "IMPLMENTING" RUNNABLE INTERFACE
// Santiago Garcia Arango

package threads1;

// We use the interface implementation, when our class needs multiple inheritance
public class MyThreadWay2 implements Runnable {

	// Attributes
	private int timeBetweenMessages;
	private String threadId;
	private String threadDots;
	private int counter = 0;
	private boolean exitThread; // to stop the thread

	public MyThreadWay2(int timeBetweenMessages, String threadId, String threadDots) {
		this.timeBetweenMessages = timeBetweenMessages;
		this.threadId = threadId;
		this.threadDots = threadDots;
		exitThread = false;
	}

	// We must overwrite this method to use threads correctly
	public void run() {
		while (!exitThread && counter<20) {
			counter++;
			System.out.println(threadDots + " Thread: " + threadId + " " + threadDots);
			try {
				Thread.sleep(timeBetweenMessages);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// Main method to stop our thread
	public void stopThread() {
		exitThread = true;
		System.out.println(">>Finishing thread " + threadId);
	}
}