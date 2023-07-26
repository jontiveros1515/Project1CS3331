import java.util.ArrayList;
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
        boolean counter = true;
        while(counter){
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Please enter first and last name. Or type EXIT");
                String nameInput = scanner.nextLine();  // Read user input

                for (Account user : users) {
                    String name = user.customer.firstName +" "+ user.customer.lastName;
                    if(name.equals(nameInput)){
                        System.out.println("Welcome " + name);
                        System.out.println("Please Select an Option:");
                        System.out.println("A) Checking.  B) Credit.  C) Saving. D) Transfer. E) Pay To. Or Type EXIT");
                        String accountChoiceInput = scanner.nextLine();  // Read user input
                            switch(accountChoiceInput) {
                                case "A": 
                                    user.checking.checkingUI();;
                                    break;
                                case "B":
                                    user.credit.creditUI();
                                    break;
                                case "C":
                                    user.saving.savingUI();
                                    break;   
                                case "D":
                                    user.checking.transferMoney();
                                case "E":
                                    user.checking.PayMoneyTo();
                                case "EXIT":
                                    counter = false;
                              default:
                                // code block
                                System.out.println("Wrong Selection");
                            }
                    }
                }
                
                if(nameInput.equals("EXIT")){
                    counter = false;
                }
            }

        }
    }

}
