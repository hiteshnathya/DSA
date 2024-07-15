package Assignment.Day13;

class BankAccount {

    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        TransactionThread depositThread1 = new TransactionThread(account, 1000, true);
        TransactionThread depositThread2 = new TransactionThread(account, 2000, true);
        TransactionThread withdrawThread1 = new TransactionThread(account, 500, false);
        TransactionThread withdrawThread2 = new TransactionThread(account, 1500, false);

        depositThread1.start();
        depositThread2.start();
        withdrawThread1.start();
        withdrawThread2.start();

        try {
            depositThread1.join();
            depositThread2.join();
            withdrawThread1.join();
            withdrawThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final Balance: " + account.getBalance());
    }
    private int balance = 0;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", Balance: " + balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }

    public synchronized int getBalance() {
        return balance;
    }
}

class TransactionThread extends Thread {
    private BankAccount account;
    private int amount;
    private boolean isDeposit;

    public TransactionThread(BankAccount account, int amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}


