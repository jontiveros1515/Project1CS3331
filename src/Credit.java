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
        setCreditStartingBalance(getCreditStartingBalance());
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

    public static void creditUI(){
        boolean quit = true;
        // while(quit){
        //     Scanner scanner = new Scanner(System.in); 
        //     System.out.println("A) Credit Balance B) Pay Balance or type EXIT");
        //     String savingChoice = scanner.nextLine();  // Read user input
        //         switch(savingChoice) {
        //             case "A": 
        //                 this.checkSavings();
        //                 break;
        //             case "B":
        //                 System.out.println("How much would you like to add to savings?");
        //                 double amount = Double.parseDouble(scanner.nextLine());
        //                 this.addSavings(amount);
        //                 break;
        //             case "EXIT":
        //                 quit = true;
        //                 break;   
        //           default:
        //             // code block
        //             System.out.println("Wrong Selection");
        //         }
        //     break;
        // }
    }
}
