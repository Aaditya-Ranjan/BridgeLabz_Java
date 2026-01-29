package level2;

/*
 * This class simulates basic ATM operations.
 * It uses a parameterized constructor to initialize
 * account details and perform banking transactions.
 */

class BankATM {

    String accountHolder;
    long accountNumber;
    double balance;

    // Initializes account details using parameterized constructor
    BankATM(String accountHolder, long accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Adds amount to account balance
    void deposit(double amt) {
        balance += amt;
    }

    // Withdraws amount if sufficient balance is available
    void withdraw(double amt) {
        if (amt <= balance)
            balance -= amt;
        else
            System.out.println("Insufficient Balance");
    }

    // Displays account holder name and current balance
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Current Balance: " + balance);
    }

    // Main method to test ATM operations
    public static void main(String[] args) {
        BankATM acc = new BankATM("Rohit", 123456, 5000);

        acc.deposit(2000);
        acc.withdraw(1000);
        acc.displayBalance();
    }
}
