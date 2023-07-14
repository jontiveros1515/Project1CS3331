/**
 * The Person class represents a person with personal information such as their first name,
 * last name, date of birth, and phone number.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Person {
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;
    protected String address;
    protected String phoneNumber;
    
    /**
     * Constructs a Person object with the specified first name, last name, date of birth, and phone number.
     *
     * @param firstName   The first name of the person.
     * @param lastName    The last name of the person.
     * @param dateOfBirth The date of birth of the person.
     * @param phoneNumber The phone number of the person.
     */
    public Person(String firstName, String lastName, String dateOfBirth, String address ,String phoneNumber) {
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
        setPhoneNumber(phoneNumber);
    }

    /**
     * Retrieves the first name of the person.
     *
     * @return The first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the person.
     *
     * @param firstName The first name to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Retrieves the last name of the person.
     *
     * @return The last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the person.
     *
     * @param lastName The last name to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Retrieves the date of birth of the person.
     *
     * @return The date of birth.
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the date of birth of the person.
     *
     * @param dateOfBirth The date of birth to set.
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Retrieves the phone number of the person.
     *
     * @return The phone number.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The phone number to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
