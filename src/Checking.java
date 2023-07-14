import java.math.BigDecimal;
/**
 * The Checking class represents a checking account that extends the Account class.
 * It contains information about the checking account number and the starting balance of the checking account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.1
 */
public class Checking extends Account {
    private int checkingAccountNumber;
    private BigDecimal checkingStartingBalance;

    Checking(int checkingAccountNumber, BigDecimal checkingStartingBalance){
        setCheckingAccountNumber(checkingAccountNumber);
        setCheckingStartingBalance(checkingStartingBalance);
    }

    public void getUserBalance(){
        //TODO: Inquire about a balance
    }

    public void depositAccount(){
        //TODO: deposit 
        //TODO: log information
    }

    public void withdrawAccount(){
        //TODO: withdraw
        //TODO: log information
        //random
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
    public BigDecimal getCheckingStartingBalance() {
        return checkingStartingBalance;
    }
    
    /**
     * Sets the starting balance of the checking account.
     *
     * @param checkingStartingBalance The starting balance to set.
     */
    public void setCheckingStartingBalance(BigDecimal checkingStartingBalance) {
        this.checkingStartingBalance = checkingStartingBalance;
    }
}
