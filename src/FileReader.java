import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The FileReader class is responsible for reading bank information from a CSV file.
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
                
                // Create the account and person objects

                // Set the account and person details

                users.add(account);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file reading exception as needed
        }
        return users;
    } 
}
