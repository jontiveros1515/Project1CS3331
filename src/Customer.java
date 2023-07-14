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
