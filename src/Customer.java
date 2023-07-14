import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The Customer class represents a customer who has personal information and can interact with their accounts.
 * It extends the Person class and contains a list of accounts associated with the customer.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Customer extends Person {
    protected int identificationNumber;

    /**
     * Constructs a Customer object with the specified personal information and identification number.
     *
     * @param firstName           The first name of the customer.
     * @param lastName            The last name of the customer.
     * @param dateOfBirth         The date of birth of the customer.
     * @param phoneNumber         The phone number of the customer.
     * @param identificationNumber The identification number of the customer.
     */
    public Customer(Person person, int identificationNumber) {
        super(person.firstName, person.lastName, person.dateOfBirth, person.address, person.phoneNumber);
        setIdentificationNumber(identificationNumber);
    }

    public int getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(int identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public static void customerUI(ArrayList<Account> users){
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Please enter first and last name");
        String nameInput = scanner.nextLine();  // Read user input

        boolean counter = true;
        while(counter){

            for (Account user : users) {
                String name = user.customer.firstName +" "+ user.customer.lastName;
                if(name.equals(nameInput)){
                    System.out.println("Welcome " + name);
                    System.out.println("Please Select an Option:");
                    System.out.println("A) Checking.  B) Credit.  C) Saving.");
                    String accountChoiceInput = scanner.nextLine();  // Read user input
                        switch(accountChoiceInput) {
                            case "A":
                                Checking.checkingUI();;
                                break;
                            case "B":
                                Credit.creditUI();
                                break;
                            case "C":
                                Saving.savingUI();
                                break;                           
                          default:
                            // code block
                            System.out.println("Wrong Selection");
                        }
                    break;
                }
                else {
                    System.out.println("Account does not exist, Try Again");
                    break;
                }
            }
            System.out.println();

        }
    }

}
