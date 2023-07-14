import java.util.ArrayList;
import java.util.List;

/**
 * The Customer class represents a customer who has personal information and can interact with their accounts.
 * It extends the Person class and contains a list of accounts associated with the customer.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Customer extends Person {
    private int identificationNumber;
    private List<Account> accounts;

    /**
     * The default constructor initializes the personal information fields (inherited from the Person class) 
     * with default values using the super() call. It also initializes the identification number to 0 and 
     * creates an empty ArrayList for the accounts.
     */
    public Customer() {
        super();
        identificationNumber = 0;
        accounts = new ArrayList<>();
    }

    /**
    * Constructs a Customer object with a person object and an identificationNumber.
    */
    public Customer(Person person, int identificationNumber){
        super(person.getFirstName(), person.getLastName(), person.getDateOfBirth(), person.getPhoneNumber());
        this.identificationNumber = identificationNumber;
        this.accounts = new ArrayList<>();
    }

    /**
    * Constructs a Customer object with a person object and an identificationNumber defaulted at 0.
    */
    public Customer(Person person){
        super(person.getFirstName(), person.getLastName(), person.getDateOfBirth(), person.getPhoneNumber());
        identificationNumber = 0;
        this.accounts = new ArrayList<>();
    }

    /**
     * Constructs a Customer object with the specified personal information and identification number.
     *
     * @param firstName           The first name of the customer.
     * @param lastName            The last name of the customer.
     * @param dateOfBirth         The date of birth of the customer.
     * @param phoneNumber         The phone number of the customer.
     * @param identificationNumber The identification number of the customer.
     */
    public Customer(String firstName, String lastName, String dateOfBirth, String phoneNumber, int identificationNumber) {
        super(firstName, lastName, dateOfBirth, phoneNumber);
        this.identificationNumber = identificationNumber;
        this.accounts = new ArrayList<>();
    }

    /**
     * Retrieves the identification number of the customer.
     *
     * @return The identification number.
     */
    public int getIdentificationNumber() {
        return identificationNumber;
    }

    /**
     * Retrieves the list of accounts associated with the customer.
     *
     * @return The list of accounts.
     */
    public List<Account> getAccounts() {
        return accounts;
    }

    /**
     * Adds an account to the customer's list of accounts.
     *
     * @param account The account to add.
     */
    public void addAccount(Account account) {
        accounts.add(account);
    }
}
