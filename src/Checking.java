public class Checking extends Account{
    int checkingAccountNumber;
    double checkingStartingBalance;

    Checking(int checkingAccountNumber, double checkingStartingBalance){
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

    public int getCheckingAccountNumber() {
        return checkingAccountNumber;
    }

    public void setCheckingAccountNumber(int checkingAccountNumber) {
        this.checkingAccountNumber = checkingAccountNumber;
    }

    public double getCheckingStartingBalance() {
        return checkingStartingBalance;
    }
    
    public void setCheckingStartingBalance(double checkingStartingBalance) {
        this.checkingStartingBalance = checkingStartingBalance;
    }
}
