import java.util.Scanner;

/**
 * The BankManager class provides functionality for a bank manager to interact with the bank's accounts.
 * It allows the bank manager to inquire about account details by name or account number.
 * The bank manager can also handle transactions such as transfers and generate bank statements for specific users.
 * This class serves as the interface for the bank manager to perform various operations.
 * It interacts with the Account class to access account information and perform transactions.
 * The BankManager class focuses on managing bank-related operations for the manager.
 * 
 * @author Juan Moreno, Javier Ontiveros, Alejandro Gonzalez
 * @version 1.0.0
 */
public class BankManager {

    /**
     * Displays the bank manager user interface.
     * The bank manager can choose options to inquire about account details, perform transactions, or generate bank statements.
     */
    public static void bankManagerUI() {
        boolean quit = false;
        while (!quit) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("A) Inquire account by name. B) Inquire account by type/number or type EXIT");
            String choice = scanner.nextLine();  // Read user input

            switch (choice) {
                case "A":
                    System.out.println("What is the account Name?");
                    String name = scanner.nextLine();  // Read user input
                    Account.getUserAccountByName(name);
                    break;
                case "B":
                    System.out.println("What is the account number?");
                    int id = Integer.parseInt(scanner.nextLine());
                    Account.getUserAccountByAccount(id);
                    break;
                case "EXIT":
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong Selection");
                    break;
            }
        }
    }

    // Other methods related to Bank Manager functionality can be added here
    // For example, handling transactions, generating bank statements, etc.

    // Methods to handle transactions (transfer, inquire, etc.) can be moved here
    // to keep the Account class focused on representing individual accounts.
    // This will make the Account class more maintainable and easier to understand.

    // Implement other Bank Manager related functionalities as required.

}