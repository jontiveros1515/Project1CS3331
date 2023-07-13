public class Person {
    String FirstName;
    String LastName;
    String DateOfBirth;
    String PhoneNumber;

    Person(){}

    Person(String FirstName, String LastName, String DateOfBirth, String PhoneNumber)
    {
        setFirstName(FirstName);
        setLastName(LastName);
        setDateOfBirth(DateOfBirth);
        setPhoneNumber(PhoneNumber);
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getDateOfBirth() {
        return DateOfBirth;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
    
    public void setDateOfBirth(String dateOfBirth) {
        DateOfBirth = dateOfBirth;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    
}
