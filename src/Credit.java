import java.util.Scanner;

/**
 * The Credit class represents a credit account that extends the Account class.
 * It contains information about the credit account number, credit limit (ma)
 * and the starting balance of the credit account as a BigDecimal.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.1
 */

public class Credit extends Account{
    protected int creditAccountNumber;
    protected int creditMax;
    protected double creditStartingBalance;

    public Credit(int creditAccountNumber, int creditMax, double creditStartingBalance){
        setCreditAccountNumber(creditAccountNumber);
        setCreditMax(creditMax);
        setCreditStartingBalance(creditStartingBalance);
    }
    
    /**
     * Retrieves the credit account number
     * 
     * @return the credit account number (int)
     */
    public int getCreditAccountNumber(){
        return creditAccountNumber;
    }

    /**
     * Sets the credit account number.
     * 
     * @param creditAccountNumber The credit account number is set
     */
    public void setCreditAccountNumber(int creditAccountNumber){
        this.creditAccountNumber = creditAccountNumber;
    }

    /**
     * Retrieves the credit limit (maximum amount that can be charged).
     * 
     * @return The credit limit (int)
     */
    public int getCreditMax(){
        return creditMax;
    }

    /**
     * Sets the credit limit (maximum amount that can be charged).
     * 
     * @param creditMax The credit limit to set. 
     */
    public void setCreditMax(int creditMax){
        this.creditMax = creditMax;
    }

    /**
     * Retrieves the starting balance of the credit account.
     * 
     * @return The starting balance of the credit account.
     */
    public double getCreditStartingBalance(){
        return creditStartingBalance;
    }

    /**
     * Sets the starting balance of the credit account.
     * 
     * @param creditStartingBalance The starting balance to set as a monetary value with 2 decimal place accuracy.
     */
    public void setCreditStartingBalance(double creditStartingBalance){
        this.creditStartingBalance = creditStartingBalance;
    }

    public void creditBalance(){
        double balance = this.creditMax + this.creditStartingBalance;
        System.out.println("Your limit is "+ this.creditMax);
        System.out.println("current credit line is "+ balance);
    }

    public void creditPaid(double amount){
        double balance = this.creditStartingBalance + amount;
        if(balance <= this.creditMax){
            System.out.println("you have paid "+ amount);
            this.creditStartingBalance += amount;
            System.out.println("You now owe "+ this.creditStartingBalance);
        }
    }

    public void creditUI() {
        boolean quit = false;
        while (!quit) {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("A) Credit Balance B) Pay Balance or type EXIT");
                String savingChoice = scanner.nextLine();  // Read user input
                switch (savingChoice) {
                    case "A":
                        this.creditBalance();
                        break;
                    case "B":
                        System.out.println("You currently owe " + this.creditStartingBalance);
                        System.out.println("How much would you like to pay off?");
                        try {
                            double amount = Double.parseDouble(scanner.nextLine());
                            this.creditPaid(amount);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a valid number.");
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
