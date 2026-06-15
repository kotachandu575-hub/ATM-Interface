import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(double balance) {
        this.balance = balance;
        transactionHistory = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        transactionHistory.add("Deposited: ₹" + amount);
        System.out.println("Amount Deposited Successfully!");
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrawn: ₹" + amount);
            System.out.println("Please collect your cash.");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void transfer(double amount, String receiver) {
        if (amount <= balance) {
            balance -= amount;
            transactionHistory.add(
                    "Transferred ₹" + amount + " to " + receiver);
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    public void showHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No Transactions Yet.");
        } else {
            System.out.println("\nTransaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class ATMInterface {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "admin";
        String pin = "1234";

        BankAccount account = new BankAccount(10000);

        System.out.println("===== ATM SYSTEM =====");

        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (enteredId.equals(userId) &&
                enteredPin.equals(pin)) {

            System.out.println("\nLogin Successful!");

            while (true) {

                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Quit");

                System.out.print("Choose Option: ");
                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        account.showHistory();
                        break;

                    case 2:
                        System.out.print("Enter Amount: ₹");
                        double withdrawAmount = sc.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;

                    case 3:
                        System.out.print("Enter Amount: ₹");
                        double depositAmount = sc.nextDouble();
                        account.deposit(depositAmount);
                        break;

                    case 4:
                        sc.nextLine();
                        System.out.print("Enter Receiver Name: ");
                        String receiver = sc.nextLine();

                        System.out.print("Enter Amount: ₹");
                        double transferAmount = sc.nextDouble();

                        account.transfer(transferAmount, receiver);
                        break;

                    case 5:
                        System.out.println(
                                "Available Balance: ₹" +
                                        account.getBalance());
                        break;

                    case 6:
                        System.out.println(
                                "Thank You For Using ATM!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice!");
                }
            }

        } else {
            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}