import java.util.ArrayList;
import java.util.Scanner;  // Import the Scanner class
/**
 * The Checking class represents a checking account that extends the Account class.
 * It contains information about the checking account number and the starting balance of the checking account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.1
 */
public class RunBank {

    public static void main(String[] args) throws Exception {
      Account.setUsers();

     ArrayList<Account> users = Account.getUsers();
      boolean quit = false;
      while(!quit){
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("A: Individual Person");
        System.out.println("B: Bank Account Manager");
        System.out.println("Or you can Type EXIT");

        String accountChoice = scanner.nextLine();  // Read user input

        switch(accountChoice) {
          case "A":
            Customer.customerUI(users);
            break;
          case "B":
            // code block
            bankManagerUI();
            break;
          case "EXIT":
            quit = true;
            break;
          default:
            System.out.println("Wrong Selection");
        }

      }
      CSVReader.updateUsers(users);
    }

    public static void bankManagerUI(){
      
    }
}

// a. Inquire about a balance.
// b. Deposit money to an account.
// c. Withdraw money from an account.
// d. Transfer money between accounts.
// e. Pay someone (i.e., Mickey pays Donald).
// f. Pick an informative response for all the mentioned tasks (i.e., Deposit
// of $XX successful, etc.)
// i. Credit accounts should not be able to accept more than the
// balance