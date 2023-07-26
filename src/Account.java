import java.util.ArrayList;

/**
 * The Account class represents a bank account associated with a customer.
 * It contains information about the customer, checking account, savings account, and credit account.
 * This class provides methods for managing and retrieving account information.
 * 
 * It serves as a container for the customer's banking-related information,
 * including checking, savings, and credit accounts.
 * 
 * This class is used to interact with the user's account, inquire about balances,
 * make deposits, withdrawals, transfers, and payments.
 * 
 * The Account class uses a Customer object to represent the user's personal information,
 * Checking object to represent the checking account, Saving object to represent the savings account,
 * and Credit object to represent the credit account.
 * 
 * @author Juan Moreno, Javier Ontiveros, Alejandro Gonzalez
 * @version 2.0.0
 */
public class Account {
    protected Customer customer;
    protected Checking checking;
    protected Saving saving;
    protected Credit credit;
    protected static ArrayList<Account> users = new ArrayList<>();

    /**
     * Default constructor for the Account class.
     */
    public Account() {

    }

    /**
     * Constructs an Account object with the specified customer, checking, savings, and credit accounts.
     *
     * @param customer The customer associated with the account.
     * @param checking The checking account associated with the account.
     * @param saving   The savings account associated with the account.
     * @param credit   The credit account associated with the account.
     */
    public Account(Customer customer, Checking checking, Saving saving, Credit credit) {
        setChecking(checking);
        setCustomer(customer);
        setCredit(credit);
        setSaving(saving);
    }

    /**
     * Retrieves the customer associated with the account.
     *
     * @return The customer associated with the account.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * Retrieves the checking account associated with the account.
     *
     * @return The checking account associated with the account.
     */
    public Checking getChecking() {
        return checking;
    }

    /**
     * Retrieves the credit account associated with the account.
     *
     * @return The credit account associated with the account.
     */
    public Credit getCredit() {
        return credit;
    }

    /**
     * Retrieves the savings account associated with the account.
     *
     * @return The savings account associated with the account.
     */
    public Saving getSaving() {
        return saving;
    }

    /**
     * Sets the checking account associated with the account.
     *
     * @param checking The checking account to set.
     */
    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    /**
     * Sets the credit account associated with the account.
     *
     * @param credit The credit account to set.
     */
    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    /**
     * Sets the customer associated with the account.
     *
     * @param customer The customer to set.
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * Sets the savings account associated with the account.
     *
     * @param saving The savings account to set.
     */
    public void setSaving(Saving saving) {
        this.saving = saving;
    }

    /**
     * Sets the list of user accounts for the application.
     * This method is typically used to initialize the list of user accounts from a CSV file.
     */
    public static void setUsers() {
        users = CSVReader.getUsers();
    }

    /**
     * Retrieves the list of user accounts in the application.
     *
     * @return The list of user accounts.
     */
    public static ArrayList<Account> getUsers() {
        return users;
    }

    /**
     * Displays account information for a user based on their name.
     *
     * @param name The name of the user to retrieve account information for.
     */
    public static void getUserAccountByName(String name) {
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName + " " + user.customer.lastName;
            if (name.equals(userName)) {
                displayUserInfo(user);
                break; // Exit the loop once the user's information is found
            }
        }
    }

    /**
     * Displays account information for a user based on their identification number.
     *
     * @param id The identification number of the user to retrieve account information for.
     */
    public static void getUserAccountByAccount(int id) {
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            if (id == user.customer.identificationNumber) {
                displayUserInfo(user);
                break; // Exit the loop once the user's information is found
            }
        }
    }

    private static void displayUserInfo(Account user) {
        System.out.println("Information on " + user.customer.firstName + " " + user.customer.lastName);
        System.out.println("Identification Number: " + user.customer.identificationNumber);
        System.out.println("Date of Birth: " + user.customer.dateOfBirth);
        System.out.println("Address: " + user.customer.address);
        System.out.println("Phone Number: " + user.customer.phoneNumber);
        System.out.println("Checking Account Number: " + user.checking.checkingAccountNumber);
        System.out.println("Checking Starting Balance: " + user.checking.checkingStartingBalance);
        System.out.println("Credit Account Number: " + user.credit.creditAccountNumber);
        System.out.println("Credit Starting Balance: " + user.credit.creditStartingBalance);
        System.out.println("Credit Max: " + user.credit.creditMax);
        System.out.println("Savings Account Number: " + user.saving.savingsAccountNumber);
        System.out.println("Savings Starting Balance: " + user.saving.savingsStartingBalance);
    }
}