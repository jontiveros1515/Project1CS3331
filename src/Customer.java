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


}
