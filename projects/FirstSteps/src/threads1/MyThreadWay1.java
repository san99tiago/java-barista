// EXAMPLE OF THREADS BY "EXTENDING" THREAD CLASS
// Santiago Garcia Arango

package threads1;

public class MyThreadWay1 extends Thread {

	// Attributes
	private int timeBetweenMessages;
	private String threadId;
	private String threadDots;
	private int counter = 0;
	private boolean exitThread; // to stop the thread

	public MyThreadWay1(int timeBetweenMessages, String threadId, String threadDots) {
		this.timeBetweenMessages = timeBetweenMessages;
		this.threadId = threadId;
		this.threadDots = threadDots;
		exitThread = false;
	}

	// We must overwrite this method to use threads correctly
	@Override
	public void run() {
		while (!exitThread && counter < 20) {
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
