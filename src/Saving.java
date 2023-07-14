import java.math.BigDecimal;
/**
 * The Saving class represents a savings account that extends the Account class.
 * It contains information about the savings account number and the starting balance of the savings account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Saving extends Account {
    private int savingsAccountNumber;
    private double savingsStartingBalance;

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

    public static void savingUI(){
        
    }
}
