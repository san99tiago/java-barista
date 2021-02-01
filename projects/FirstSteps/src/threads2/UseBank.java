// MAIN FILE TO "USE" BANK ACCOUNTS AND SHOW THREAD FUNCTIONALITIES
// Santiago Garcia Arango

package threads2;

public class UseBank {

	// Attributes
	private static int totalAccounts = 500;
	private static double initialMoneyInAccounts = 100;

	public static void main(String[] args) {
		// To test bank with multiple threads (problem and solution), change...
		// ...parameter of hasReentrantLock to activate this functionality
		simulateBank(true); // (true/false) to test
	}

	public static void simulateBank(boolean hasReentrantLock) {
		Bank bankOfSanti = new Bank(totalAccounts, initialMoneyInAccounts, hasReentrantLock);

		// Start all threads for each account (to transfer money in a random way)
		for (int i = 0; i < totalAccounts; i++) {
			ExecuteMoneyTransfers currentTransfer = new ExecuteMoneyTransfers(bankOfSanti, i, initialMoneyInAccounts);
			Thread transferThread = new Thread(currentTransfer);
			transferThread.start();
		}
	}

}
