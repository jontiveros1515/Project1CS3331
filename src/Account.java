/**
 * The Account class represents a bank account associated with a customer.
 * It contains information about the customer, checking account, savings account, and credit account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Account {
    protected Customer customer;
    protected Checking checking;
    protected Saving saving;
    protected Credit credit;

    public Account(){

    }

    public Account(Customer customer, Checking checking, Saving saving, Credit credit){
        setChecking(checking);
        setCustomer(customer);
        setCredit(credit);
        setSaving(saving);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Checking getChecking() {
        return checking;
    }
    
    public Credit getCredit() {
        return credit;
    }

    public Saving getSaving() {
        return saving;
    }

    public void setChecking(Checking checking) {
        this.checking = checking;
    }

    public void setCredit(Credit credit) {
        this.credit = credit;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSaving(Saving saving) {
        this.saving = saving;
    }

}