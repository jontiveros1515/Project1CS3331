import java.util.Scanner;  // Import the Scanner class


public class RunBank {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("A: Individual Person");
        System.out.println("B: Bank Account Manager");

        String accountChoice = scanner.nextLine();  // Read user input
        System.out.println(accountChoice);  // Output user input fjsdjfjd


        switch(accountChoice) {
          case "A":
            Customer.customerUI();
            break;
          case "B":
            // code block
            bankManagerUI();
            break;
          default:
            // code block
            System.out.println("Wrong Selection");
        }

        scanner.close();
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