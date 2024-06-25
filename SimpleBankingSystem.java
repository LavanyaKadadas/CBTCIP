import java.util.Scanner;

// BankAccount class represents a bank account
class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor to initialize a bank account
    public BankAccount(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit of $" + amount + " successful.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal of $" + amount + " successful.");
        } else {
            System.out.println("Insufficient funds or invalid withdrawal amount.");
        }
    }

    // Method to transfer money from this account to another account
    public void transfer(BankAccount receiver, double amount) {
        if (amount > 0 && balance >= amount) {
            this.withdraw(amount);
            receiver.deposit(amount);
            System.out.println("$" + amount + " transferred to account " + receiver.getAccountNumber() + ".");
        } else {
            System.out.println("Transfer failed. Insufficient funds or invalid amount.");
        }
    }

    // Method to get account number
    public String getAccountNumber() {
        return accountNumber;
    }

    // Method to get account holder name
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Method to get account balance
    public double getBalance() {
        return balance;
    }
}

// Main class to demonstrate BankAccount functionalities
public class SimpleBankingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating two bank accounts for demonstration
        BankAccount account1 = new BankAccount("101", "Alice", 1000.0);
        BankAccount account2 = new BankAccount("102", "Bob", 500.0);

        // Display initial account information
        displayAccountInfo(account1);
        displayAccountInfo(account2);

        // Perform transactions
        performDeposit(scanner, account1);
        performWithdraw(scanner, account1);
        performTransfer(scanner, account1, account2);

        // Display final account information
        displayAccountInfo(account1);
        displayAccountInfo(account2);

        scanner.close();
    }

    // Method to display account information
    public static void displayAccountInfo(BankAccount account) {
        System.out.println("\nAccount Number: " + account.getAccountNumber());
        System.out.println("Account Holder: " + account.getAccountHolderName());
        System.out.println("Balance: $" + account.getBalance());
    }

    // Method to perform deposit into an account
    public static void performDeposit(Scanner scanner, BankAccount account) {
        System.out.print("\nEnter deposit amount for " + account.getAccountHolderName() + ": $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    // Method to perform withdrawal from an account
    public static void performWithdraw(Scanner scanner, BankAccount account) {
        System.out.print("\nEnter withdrawal amount for " + account.getAccountHolderName() + ": $");
        double amount = scanner.nextDouble();
        account.withdraw(amount);
    }

    // Method to perform transfer between two accounts
    public static void performTransfer(Scanner scanner, BankAccount sender, BankAccount receiver) {
        System.out.print("\nEnter transfer amount from " + sender.getAccountHolderName() + " to " + receiver.getAccountHolderName() + ": $");
        double amount = scanner.nextDouble();
        sender.transfer(receiver, amount);
    }
}
