import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileReader class is responsible for reading bank information from a CSV file.
 * BigDecimal is a class from java.math used for precise decimal calculations. This ensures
 * accurate representation when calculating monetary values, incase calculation features are 
 * needed in the future.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.3
 */

public class FileReader {

    private static final String CSV_FILE_PATH = "CS 3331 - Bank Users.csv";

    /**
     * Reads the bank user information from the CSV file and returns a list of Account objects.
     *
     * @return The list of Account objects containing the bank user information.
     */
    public static List<Account> getUsers(){
        List<Account> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))){
            String line;
            boolean headerLine = true;

            while ((line = reader.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue; //Skips the header line
                }
                //Split the CSV line into an array of values
                String[] data = line.split(",");

                // Extract the bank user information from the data array
                int identificationNumber = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String dateOfBirth = data[3];
                String address = data[4];
                String phoneNumber = data[5];
                int checkingAccountNumber = Integer.parseInt(data[6]);
                BigDecimal checkingStartingBalance = new BigDecimal(data[7]);
                int savingsAccountNumber = Integer.parseInt(data[8]);
                BigDecimal savingsStartingBalance = new BigDecimal(data[9]);
                int creditAccountNumber = Integer.parseInt(data[10]);
                int creditMax = Integer.parseInt(data[11]);
                BigDecimal creditStartingBalance = new BigDecimal(data[12]);
                
                // Create the account and person objects
                Account account = new Account();
                Person person = new Person(firstName, lastName, dateOfBirth, phoneNumber);

                // Set the account and person details
                account.setCustomer(person);
                account.getPersonInformation().setAddress(address);
                account.getChecking().setCheckingAccountNumber(checkingAccountNumber);
                account.getChecking().setCheckingStartingBalance(checkingStartingBalance);
                account.getSaving().setSavingsAccountNumber(savingsAccountNumber);
                account.getSaving().setSavingsStartingBalance(savingsStartingBalance);
                account.getCredit().setCreditAccountNumber(creditAccountNumber);
                account.getCredit().setCeditMax(creditMax);
                account.getCredit().setCreditStartingBalance(creditStartingBalance);

                users.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file reading exception as needed
        }
        return users;
    } 
}
