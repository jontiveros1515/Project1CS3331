import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The CSVReader class is responsible for reading and writing bank user information from and to a CSV file.
 * It provides methods for reading user information from the CSV file and updating the CSV file with new information.
 * It also includes a method to log information to a text file.
 * 
 * This class uses the Account, Customer, Checking, Saving, and Credit classes to store and represent the bank user information.
 * The bank user information is read from the CSV file and stored in a list of Account objects.
 * The updated user information is written back to the CSV file.
 * 
 * The CSV file should have the following columns:
 * "Identification Number,First Name,Last Name,Date of Birth,Address,Phone Number,
 * Checking Account Number,Checking Starting Balance,
 * Savings Account Number,Savings Starting Balance,
 * Credit Account Number,Credit Max,Credit Starting Balance"
 * 
 * The text log file will store logged information.
 * 
 * @author Juan Moreno, Javier Ontiveros, Alejandro Gonzalez
 * @version 2.1.0
 */
public class CSVReader {
    private static File file = new File("BankUsers.csv");
    private static File logFile = new File("TextLog.txt");

    /**
     * Reads the bank user information from the CSV file and returns a list of Account objects.
     *
     * @return The list of Account objects containing the bank user information.
     */
    public static ArrayList<Account> getUsers() {
        ArrayList<Account> users = new ArrayList<>();

        try {
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line;
            boolean headerLine = true;

            while ((line = reader.readLine()) != null) {
                if (headerLine) {
                    headerLine = false;
                    continue; // Skip the header line
                }

                String[] data = line.split(",");

                // Extract the bank user information from the data array
                int identificationNumber = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                String dateOfBirth = data[3];
                String address = data[4];
                String phoneNumber = data[5];

                int checkingAccountNumber = Integer.parseInt(data[6]);
                double checkingStartingBalance = Double.parseDouble(data[7]);
                Checking checking = new Checking(checkingAccountNumber, checkingStartingBalance);

                int savingsAccountNumber = Integer.parseInt(data[8]);
                double savingsStartingBalance = Double.parseDouble(data[9]);
                Saving saving = new Saving(savingsAccountNumber, savingsStartingBalance);

                int creditAccountNumber = Integer.parseInt(data[10]);
                int creditMax = Integer.parseInt(data[11]);
                double creditStartingBalance = Double.parseDouble(data[12]);
                Credit credit = new Credit(creditAccountNumber, creditMax, creditStartingBalance);

                Person person = new Person(firstName, lastName, dateOfBirth, address, phoneNumber)
                Customer customer = new Customer(person, identificationNumber);
                Account user = new Account(customer, checking, saving, credit);

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
        File updatedFile = new File("UpdatedBankUsers.csv");

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
     * @param log The log string to be written into the text file.
     */
    public static void textLog(String log) {
        try {
            FileWriter fw = new FileWriter(logFile, true);
            BufferedWriter writer = new BufferedWriter(fw);

            writer.write(log);
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }
    /**
     * Creates a user transactions file (.txt) with the specified information.
     *
     * @param account  The user's account information.
     * @param startingBalance  The starting balance of the account (at the beginning of the session).
     * @param endingBalance  The ending balance of the account (at the time requested).
     * @param transactions  The list of transactions for the user.
     */
    public static void createUserTransactionsFile(Account account, double startingBalance, double endingBalance, String transactions) {
        Customer customer = account.getCustomer();
        String firstName = customer.getFirstName();
        String lastName = customer.getLastName();
        String fileName = firstName + "_" + lastName + "_Transactions.txt";

        try {
            FileWriter fw = new FileWriter(fileName);
            fw.write("User Transactions for: " + firstName + " " + lastName);
            fw.write(System.lineSeparator());
            fw.write("Account Information:");
            fw.write(System.lineSeparator());
            fw.write(customerInformationToString(customer));
            fw.write(System.lineSeparator());
            fw.write("Starting Balance: " + startingBalance);
            fw.write(System.lineSeparator());
            fw.write(transactions);
            fw.write(System.lineSeparator());
            fw.write("Ending Balance: " + endingBalance);
            fw.write(System.lineSeparator());
            fw.write("Date of Statement: " + getCurrentDateTime());
            fw.write(System.lineSeparator());

            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }

    /**
     * Converts customer information to a string representation.
     *
     * @param customer The customer object containing the user's personal information.
     * @return The string representation of the customer information.
     */
    private static String customerInformationToString(Customer customer) {
        return "Identification Number: " + customer.getIdentificationNumber() + ", " +
                "Date of Birth: " + customer.getDateOfBirth() + ", " +
                "Address: " + customer.getAddress() + ", " +
                "Phone Number: " + customer.getPhoneNumber();
    }

    /**
     * Retrieves the current date and time in the format "yyyy-MM-dd HH:mm:ss".
     *
     * @return The current date and time.
     */
    private static String getCurrentDateTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }

    public static ArrayList<Transaction> readTransactions(String fileName) {
        ArrayList<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String fromFirstName = data[0].trim();
                String fromLastName = data[1].trim();
                String fromWhere = data[2].trim();
                String action = data[3].trim();
                String toFirstName = data[4].trim();
                String toLastName = data[5].trim();
                String toWhere = data[6].trim();
                double actionAmount = Double.parseDouble(data[7].trim());

                Transaction transaction = new Transaction(fromFirstName, fromLastName, fromWhere, action,
                        toFirstName, toLastName, toWhere, actionAmount);

                transactions.add(transaction);
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file reading exception as needed
        }

        return transactions;
    }
}