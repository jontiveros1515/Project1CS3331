import java.util.Scanner;
/**
 * The Saving class represents a savings account that extends the Account class.
 * It contains information about the savings account number and the starting balance of the savings account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Saving extends Account {
    protected int savingsAccountNumber;
    protected double savingsStartingBalance;

    public Saving(int savingsAccountNumber, double savingsStartingBalance){
        setSavingsAccountNumber(savingsAccountNumber);
        setSavingsStartingBalance(savingsStartingBalance);
    }


    /**
     * Retrieves the savings account number.
     *
     * @return The savings account number.
     */
    public int getSavingsAccountNumber() {
        return savingsAccountNumber;
    }

    /**
     * Sets the savings account number.
     *
     * @param savingsAccountNumber The savings account number to set.
     */
    public void setSavingsAccountNumber(int savingsAccountNumber) {
        this.savingsAccountNumber = savingsAccountNumber;
    }

    /**
     * Retrieves the starting balance of the savings account.
     *
     * @return The starting balance of the savings account.
     */
    public double getSavingsStartingBalance() {
        return savingsStartingBalance;
    }

    /**
     * Sets the starting balance of the savings account.
     *
     * @param savingsStartingBalance The starting balance to set.
     */
    public void setSavingsStartingBalance(double savingsStartingBalance) {
        this.savingsStartingBalance = savingsStartingBalance;
    }

    public void checkSavings(){
        System.out.println("You have "+this.savingsStartingBalance+" in your savings");
    }

    public void addSavings(double amount){
        this.savingsStartingBalance += amount;
    }

    public void savingUI(){
        boolean quit = false;
        while(!quit){
            Scanner scanner = new Scanner(System.in); 
            System.out.println("A) Check Savings. B) Add Savings. or type EXIT");
            String savingChoice = scanner.nextLine();  // Read user input
                switch(savingChoice) {
                    case "A": 
                        this.checkSavings();
                        break;
                    case "B":
                        System.out.println("How much would you like to add to savings?");
                        double amount = Double.parseDouble(scanner.nextLine());
                        this.addSavings(amount);
                        break;
                    case "EXIT":
                        quit = true;
                        break;   
                  default:
                    // code block
                    System.out.println("Wrong Selection");
                }
        }

    }
    
}
