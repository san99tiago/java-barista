// BANK WHERE ACCOUNTS AND MONEY WILL BE STORED
// Santiago Garcia Arango

package threads2;

import java.util.concurrent.locks.ReentrantLock;

public class Bank {

	// Attributes
	private final double[] accounts;
	// Special attribute for locking threads and avoiding concurrency problems:
	private boolean hasReentrantLock;
	private ReentrantLock bankCurrentlyInactive = new ReentrantLock();

	public Bank(int totalAccounts, double initialAccountsMoney, boolean hasReentrantLock) {
		accounts = new double[totalAccounts];
		this.hasReentrantLock = hasReentrantLock;

		for (int i = 0; i < accounts.length; i++) {
			accounts[i] = initialAccountsMoney;
		}
	}

	public void transferMoney(int originAccount, int finalAccount, double amount) {
		// This method can decide to lock thread until finishes or not (to show...
		// ...an example of when we should implement a thread lock
		if (hasReentrantLock) {
			// Main variable to lock current thread until it finishes
			bankCurrentlyInactive.lock();

			try {
				doRawMoneyTransfer(originAccount, finalAccount, amount);
			} finally {
				// After thread finishes (no matter what happens), unlock thread
				bankCurrentlyInactive.unlock();
			}
		} else {
			doRawMoneyTransfer(originAccount, finalAccount, amount);
		}
	}

	public void doRawMoneyTransfer(int originAccount, int finalAccount, double amount) {
		// Check that originAccount has enough money to transfer
		if (accounts[originAccount] < amount) {
			System.err.println(">>Acount " + String.valueOf(originAccount) + " doesn't have enough money.");
			return;
		}

		// Check that originAccount and finalAccount are different
		if (originAccount == finalAccount) {
			System.err.println(">>Origin and Final accounts must be different.");
			return;
		}

		// Check that originAccount and finalAccount exist
		if (originAccount > accounts.length || finalAccount > accounts.length) {
			System.err.println(">>One of the accounts is not registered in the bank.");
			return;
		}

		System.out.println("--------" + Thread.currentThread() + "--------");

		// Change the account values for the originAccount and the finalAccount
		accounts[originAccount] = accounts[originAccount] - amount;

		System.out.printf("-->Transfering (%5.2f) from :%d to :%d.\n", amount, originAccount, finalAccount);

		accounts[finalAccount] = accounts[finalAccount] + amount;

		System.out.printf("<<<<< Total Bank Money is: %10.2f >>>>>\n", getTotalBankMoney());
	}

	public double getTotalBankMoney() {
		double totalMoney = 0;
		for (int i = 0; i < accounts.length; i++) {
			totalMoney = totalMoney + accounts[i];
		}
		return totalMoney;
	}

	public int getTotalAccounts() {
		return accounts.length;
	}
}
