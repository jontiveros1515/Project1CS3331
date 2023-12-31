package CS3331LabProject;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * The Checking class represents a checking account that extends the Account class.
 * It contains information about the checking account number and the starting balance of the checking account.
 * It also provides functionality for depositing, withdrawing, transferring money, and making payments.
 * 
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Checking extends Account {
    protected  int checkingAccountNumber;
    protected  double checkingStartingBalance;

    /**
     * Constructs a Checking object with the specified checking account number and starting balance.
     *
     * @param checkingAccountNumber    The checking account number.
     * @param checkingStartingBalance The starting balance of the checking account.
     */
    public Checking(int checkingAccountNumber, double checkingStartingBalance){
        setCheckingAccountNumber(checkingAccountNumber);
        setCheckingStartingBalance(checkingStartingBalance);
    }

    /**
     * Retrieves the user's balance from the checking account.
     *
     * @return The user's balance.
     */
    public double getUserBalance(){
        return this.checkingStartingBalance;
    }

    /**
     * Deposits the specified amount into the checking account.
     *
     * @param checkingStartingBalance The current balance of the checking account.
     * @param deposit                 The amount to deposit.
     */
    public void depositAccount(double checkingStartingBalance, double deposit){ 
        this.checkingStartingBalance = checkingStartingBalance + deposit; 
        System.out.println(deposit + " has been deposited");
    }

    /**
     * Withdraws the specified amount from the checking account.
     *
     * @param checkingStartingBalance The current balance of the checking account.
     * @param withdraw                The amount to withdraw.
     */
    public void withdrawAccount(double checkingStartingBalance, double withdraw){
        if (withdraw <= checkingStartingBalance){
            this.checkingStartingBalance -= withdraw;
            System.out.println(withdraw + " has been withdrawn");
            // Log the transaction
            String log = "Withdrawal: $" + withdraw + " from checking account. New balance: $" + this.checkingStartingBalance;
            CSVReader.textLog(log); // Call the textLog method from the CSVReader class to log the transaction
        }
        else {
            System.out.println("invalid amount, amount must be less than " + checkingStartingBalance);
        }
    }

    /**
     * Transfers money from the checking account to another account.
     * The user can choose the recipient and the amount to transfer.
     */
    public void transferMoney() {
        boolean quit = false;
        ArrayList<Account> users = Account.getUsers();
        while (!quit) {
            double userBalance = this.getUserBalance();
            System.out.println("Your balance is currently " + userBalance);
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Who would you like to transfer to? or Type EXIT");
                String input = scanner.nextLine();
                if (input.equals("EXIT")) {
                    quit = true;
                    break;
                }
                for (Account user : users) {
                    if (input.equals(user.customer.firstName + " " + user.customer.lastName)) {
                        System.out.println("How much would you like to transfer?");
                        double amount = Double.parseDouble(scanner.nextLine());
                        if (this.checkingStartingBalance < amount) {
                            System.out.println("This amount is not valid");
                            break;
                        }
                        this.checkingStartingBalance -= amount;
                        user.checking.checkingStartingBalance += amount;
                        System.out.println("Transfer successful to " + input);
    
                        // Log the transaction
                        String log = "Transfer: $" + amount + " from checking account to " + input + "'s checking account.";
                        CSVReader.textLog(log); // Call the textLog method from the CSVReader class to log the transaction
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle any number format exception if necessary
            }
        }
    }

    /**
     * Pays money from the checking account to another account.
     * The user can choose the recipient and the amount to pay.
     */
    public void PayMoneyTo() {
        boolean quit = false;
        ArrayList<Account> users = Account.getUsers();
        while (!quit) {
            double userBalance = this.getUserBalance();
            System.out.println("Your balance is currently " + userBalance);
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Who would you like to Pay to? or Type EXIT");
                String input = scanner.nextLine();
                if (input.equals("EXIT")) {
                    quit = true;
                    break;
                }
                for (Account user : users) {
                    if (input.equals(user.customer.firstName + " " + user.customer.lastName)) {
                        System.out.println("How much would you like to Pay?");
                        double amount = Double.parseDouble(scanner.nextLine());
                        if (this.checkingStartingBalance < amount) {
                            System.out.println("This amount is not valid");
                            break;
                        }
                        this.checkingStartingBalance -= amount;
                        user.checking.checkingStartingBalance += amount;
                        System.out.println("Payment successful to " + input);
    
                        // Log the transaction
                        String log = "Payment: $" + amount + " from checking account to " + input + "'s checking account.";
                        CSVReader.textLog(log); // Call the textLog method from the CSVReader class to log the transaction
                    }
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // Handle any number format exception if necessary
            }
        }
    }

    /**
     * Retrieves the checking account number.
     *
     * @return The checking account number.
     */
    public int getCheckingAccountNumber() {
        return checkingAccountNumber;
    }

    /**
     * Sets the checking account number.
     *
     * @param checkingAccountNumber The checking account number to set.
     */
    public void setCheckingAccountNumber(int checkingAccountNumber) {
        this.checkingAccountNumber = checkingAccountNumber;
    }

    /**
     * Retrieves the starting balance of the checking account.
     *
     * @return The starting balance of the checking account.
     */
    public double getCheckingStartingBalance() {
        return checkingStartingBalance;
    }
    
    /**
     * Sets the starting balance of the checking account.
     *
     * @param checkingStartingBalance The starting balance to set.
     */
    public void setCheckingStartingBalance(double checkingStartingBalance) {
        this.checkingStartingBalance = checkingStartingBalance;
    }

    /**
     * Displays the checking account user interface.
     * The user can choose options to check balance, withdraw, deposit, or exit.
     */
    public void checkingUI() {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean quit = false;
            while (!quit) {
                System.out.println("A) Balance. B) Withdraw. C) Deposit. or type EXIT");
                String input = scanner.nextLine();
    
                switch (input) {
                    case "A":
                        double balance = getUserBalance();
                        System.out.println("\n Your Balance is: " + balance);
                        break;
                    case "B":
                        System.out.println("Enter withdraw Amount:");
                        try {
                            double withdrawAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character after reading the double
                            withdrawAccount(this.checkingStartingBalance, withdrawAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear the input buffer
                        }
                        break;
                    case "C":
                        System.out.println("Enter deposit Amount:");
                        try {
                            double depositAmount = scanner.nextDouble();
                            scanner.nextLine(); // Consume the newline character after reading the double
                            depositAccount(this.checkingStartingBalance, depositAmount);
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
                            scanner.nextLine(); // Clear the input buffer
                        }
                        break;
                    case "EXIT":
                        quit = true;
                        break;
                    default:
                        System.out.println("Wrong Selection");
                }
            }
        }
    }
}
