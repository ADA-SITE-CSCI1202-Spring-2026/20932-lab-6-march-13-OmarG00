class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class Account {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public Account(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            throw new InvalidAmountException("Insufficient balance. Tried to withdraw " + amount + " but balance is " + balance);
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Account #" + accountNumber + " | Holder: " + accountHolderName + " | Balance: " + balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1001, "John Doe", 500.0);

        System.out.println("Initial: " + account);

        account.deposit(200.0);
        System.out.println("After depositing 200: " + account);

        try {
            account.withdraw(100.0);
            System.out.println("After withdrawing 100: " + account);

       
            account.withdraw(1000.0);
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("Final: " + account);
    }
}
