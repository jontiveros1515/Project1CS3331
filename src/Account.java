/**
 * The Account class represents a bank account associated with a customer.
 * It contains information about the customer, checking account, savings account, and credit account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Account {
    private Customer customer;
    private Checking checking;
    private Saving saving;
    private Credit credit;

    /**
     * Retrieves the customer associated with the account.
     *
     * @return The customer.
     */
    public Customer getCustomer() {
        return customer;
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
     * Retrieves the checking account associated with the account.
     *
     * @return The checking account.
     */
    public Checking getChecking() {
        return checking;
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
     * Retrieves the savings account associated with the account.
     *
     * @return The savings account.
     */
    public Saving getSaving() {
        return saving;
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
     * Retrieves the credit account associated with the account.
     *
     * @return The credit account.
     */
    public Credit getCredit() {
        return credit;
    }

    /**
     * Sets the credit account associated with the account.
     *
     * @param credit The credit account to set.
     */
    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public Object getPersonInformation() {
        return null;
    }
}