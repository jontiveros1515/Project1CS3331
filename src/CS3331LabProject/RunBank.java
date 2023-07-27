package CS3331LabProject;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * The Checking class represents a checking account that extends the Account class.
 * It contains information about the checking account number and the starting balance of the checking account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.1
 */
public class RunBank {

    /**
     * The main method that starts the banking application.
     *
     * @param args Command-line arguments (not used in this application).
     * @throws Exception If there is an issue with reading or writing the CSV file.
     */
    public static void main(String[] args) throws Exception {
      Account.setUsers();

     ArrayList<Account> users = Account.getUsers();
      boolean quit = false;
      while(!quit){
        try (Scanner scanner = new Scanner(System.in)) {
          System.out.println("A: Individual Person");
          System.out.println("B: Bank Account Manager");
          System.out.println("Or you can Type EXIT");

          String accountChoice = scanner.nextLine();  // Read user input

          switch(accountChoice) {
            case "A":
              Customer.customerUI(users);
              break;
            case "B":
              BankManager.bankManagerUI();// Call the bank manager UI method
              break;
            case "EXIT":
              quit = true;
              break;
            default:
              System.out.println("Wrong Selection");
          }
        }

      }
      CSVReader.updateUsers(users);
    }
}
