// MAIN THREAD PROGRAM TO ILUSTRATE THREADS IN JAVA
// Santiago Garcia Arango

package threads1;

public class UseThreads {

	// Main method will be always executed as "main thread"
	public static void main(String[] args) {
		// Test threads for programs in two ways ("series"/"parallel")
		testThreads("series"); // Change parameter to: "series"/"parallel"
	}

	public static void testThreads(String wayToRunThreads) {

		System.out.println("-----STARTED PROGRAM-----");

		// Create thread by "MyThreadWay1" which extends from Thread class
		MyThreadWay1 thread1 = new MyThreadWay1(250, "1", ".");

		// Create thread by "MyThreadWay1" which extends from Thread class
		MyThreadWay1 thread2 = new MyThreadWay1(500, "2", ".....");

		// Create thread by "MyThreadWay2" which implements from Runnable interface
		MyThreadWay2 myThread3 = new MyThreadWay2(750, "3", "...............");
		Thread thread3 = new Thread(myThread3);

		if (wayToRunThreads.equals("parallel")) {
			thread1.start();
			thread2.start();
			thread3.start();
			try {
				Thread.sleep(9000);
				thread1.stopThread();
				thread2.stopThread();
				myThread3.stopThread();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else if (wayToRunThreads.equals("series")) {
			thread1.start();
			try {
				thread1.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread2.start();
			try {
				thread2.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			thread3.start();
		}
	}

}
