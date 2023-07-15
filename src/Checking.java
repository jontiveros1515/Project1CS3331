
import java.util.ArrayList;
import java.util.Scanner;

public class Checking extends Account {
    protected  int checkingAccountNumber;
    protected  double checkingStartingBalance;

    Checking(int checkingAccountNumber, double checkingStartingBalance){
        setCheckingAccountNumber(checkingAccountNumber);
        setCheckingStartingBalance(checkingStartingBalance);
    }

    public double getUserBalance(){
        return this.checkingStartingBalance;
    }

    public void depositAccount(double checkingStartingBalance, double deposit){ 
        this.checkingStartingBalance = checkingStartingBalance + deposit; 
        System.out.println(deposit + " has been deposited");
    }

    public void withdrawAccount(double checkingStartingBalance, double withdraw){
        //TODO: withdraw
        if (withdraw <= checkingStartingBalance){
            this.checkingStartingBalance -= withdraw;
            System.out.println(withdraw + " has been withdrawn");
        }
        else {
            System.out.println("invalid amount, amount must be less than " + checkingStartingBalance);
        }
        //TODO: log information
        //random
    }

    public void transferMoney(){
  
        boolean quit = false;
        ArrayList<Account> users = Account.getUsers();
        while(!quit){      
            double userBalance = this.getUserBalance();
            System.out.println("Your balance is currently "+ userBalance);
            Scanner scanner = new Scanner(System.in);
            System.out.println("who would you like to trasnfer to? or Type EXIT");
            String input = scanner.nextLine();
            if(input.equals("EXIT")){
                quit = true;
                break;
            }
            for (Account user : users) {
                if(input.equals(user.customer.firstName+" "+user.customer.lastName)){
                    System.out.println("How much would you like to transfer?");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if(this.checkingStartingBalance < amount){
                        System.out.println("this amount is not valid");
                        break;
                    }
                    this.checkingStartingBalance -= amount;
                    user.checking.checkingStartingBalance += amount;
                    System.out.println("Transfered succesful to " + input);
                }
            }
           
        }

    }

    public void PayMoneyTo(){
        boolean quit = false;
        ArrayList<Account> users = Account.getUsers();
        while(!quit){      
            double userBalance = this.getUserBalance();
            System.out.println("Your balance is currently "+ userBalance);
            Scanner scanner = new Scanner(System.in);
            System.out.println("who would you like to Pay to? or Type EXIT");
            String input = scanner.nextLine();
            if(input.equals("EXIT")){
                quit = true;
                break;
            }
            for (Account user : users) {
                if(input.equals(user.customer.firstName+" "+user.customer.lastName)){
                    System.out.println("How much would you like to Pay?");
                    double amount = Double.parseDouble(scanner.nextLine());
                    if(this.checkingStartingBalance < amount){
                        System.out.println("this amount is not valid");
                        break;
                    }
                    this.checkingStartingBalance -= amount;
                    user.checking.checkingStartingBalance += amount;
                    System.out.println("Payment succesful to " + input);
                }
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

    public  void checkingUI(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("A) Balance. B) Withdraw. C) Deposit. or type EXIT");
            String input = scanner.nextLine();

            switch(input) {
                case "A":
                    double balance = getUserBalance();
                    System.out.println("\n Your Balance is: " + balance);
                    break;
                case "B":
                    System.out.println("Enter withdraw Amount:");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    withdrawAccount(this.checkingStartingBalance,withdrawAmount);
                    break;
                case "C":
                    System.out.println("Enter deposit Amount:");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    depositAccount(this.checkingStartingBalance,depositAmount);
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
