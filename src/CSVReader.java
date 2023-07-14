import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


/**
 * The FileReader class is responsible for reading bank information from a CSV file.
 * BigDecimal is a class from java.math used for precise decimal calculations. This ensures
 * accurate representation when calculating monetary values, incase calculation features are 
 * needed in the future.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.3
 */

public class CSVReader {

    static File file = new File("src/CS 3331 - Bank Users.csv");

    /**
     * Reads the bank user information from the CSV file and returns a list of Account objects.
     *
     * @return The list of Account objects containing the bank user information.
     */
    public static ArrayList<Account> getUsers(){
        ArrayList<Account> users = new ArrayList<>();


        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);  
            String line;
            boolean headerLine = true;
            String address = ""; 

            while ((line = reader.readLine()) != null) {

                if (headerLine) {
                    headerLine = false;
                    continue; //Skips the header line
                }

                //Split the CSV line into an array of values
                address = line.substring(line.indexOf("\""), line.indexOf("\"", line.indexOf("\"") + 2));

                String[] data = line.split(",");

                // Extract the bank user information from the data array
                Person person = new Person(data[1], data[2], data[3], address, data[7]);
                Customer customer = new Customer(person, Integer.parseInt(data[0]));
                Checking checking = new Checking(Integer.parseInt(data[8]), Double.parseDouble(data[9]));
                Saving savings = new Saving(Integer.parseInt(data[10]),Double.parseDouble(data[11]));
                Credit credit = new Credit(Integer.parseInt(data[12]), Integer.parseInt(data[13]), Double.parseDouble(data[14]));

                Account user = new Account(customer, checking, savings, credit);

                users.add(user);
            
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file reading exception as needed
        }
        return users;
    }

    /**
    * Updates the bank user information and writes it to the CSV file.
     *
     * @param users The list of Account objects containing the updated bank user information.
     */
    public static void updateUsers(ArrayList<Account> users) {
        File updatedFile = new File("src/Updated Bank Users.csv");

        try {
            FileWriter fw = new FileWriter(updatedFile);
            BufferedWriter writer = new BufferedWriter(fw);

            // Write the header line
            writer.write("Identification Number,First Name,Last Name,Date of Birth,Address,Phone Number,Checking Account Number,Checking Starting Balance,Savings Account Number,Savings Starting Balance,Credit Account Number,Credit Max,Credit Starting Balance");
            writer.newLine();

            // Write the user information
            for (Account user : users) {
                Customer customer = user.getCustomer();
                Checking checking = user.getChecking();
                Saving saving = user.getSaving();
                Credit credit = user.getCredit();

                String line = customer.getIdentificationNumber() + ","
                    + customer.getFirstName() + ","
                    + customer.getLastName() + ","
                    + customer.getDateOfBirth() + ","
                    + customer.getAddress() + ","
                    + customer.getPhoneNumber() + ","
                    + checking.getCheckingAccountNumber() + ","
                    + checking.getCheckingStartingBalance() + ","
                    + saving.getSavingsAccountNumber() + ","
                    + saving.getSavingsStartingBalance() + ","
                    + credit.getCreditAccountNumber() + ","
                    + credit.getCreditMax() + ","
                    + credit.getCreditStartingBalance();

                writer.write(line);
                writer.newLine();
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }
    
    /**
     * Writes the log string to a text file named "TextLog.txt".
     *
     * @param log The log string to be written into text file.
     */
    public static void textLog(String log) {
        try {
            FileWriter fw = new FileWriter("TextLog.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(log);
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }

    public static void main(String[] args) {
        
    }
}
