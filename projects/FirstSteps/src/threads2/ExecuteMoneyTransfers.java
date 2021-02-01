package threads2;

public class ExecuteMoneyTransfers implements Runnable {

	// Attributes
	private Bank bank;
	private int originAccount;
	private double maxMoneyToTransfer;

	public ExecuteMoneyTransfers(Bank bank, int originAccount, double maxMoneyToTransfer) {
		this.bank = bank;
		this.originAccount = originAccount;
		this.maxMoneyToTransfer = maxMoneyToTransfer;
	}

	@Override
	public void run() {
		while (true) {
			int finalAccount = (int) (bank.getTotalAccounts() * Math.random());
			double amount = maxMoneyToTransfer * Math.random();

			bank.transferMoney(originAccount, finalAccount, amount);

			try {
				// Generate random time for money transfers (0-10 seconds)
				Thread.sleep((int) (10 * Math.random()));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
