import java.math.BigDecimal;

public class Checking extends Account {
    protected int checkingAccountNumber;
    protected double checkingStartingBalance;

    Checking(int checkingAccountNumber, double checkingStartingBalance){
        setCheckingAccountNumber(checkingAccountNumber);
        setCheckingStartingBalance(checkingStartingBalance);
    }

    public void getUserBalance(){
        System.out.println("Your Balance is: " + checkingStartingBalance);
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

    public static void checkingUI(){
        
    }
}
