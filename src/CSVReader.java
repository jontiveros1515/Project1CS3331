import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    


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

    public static ArrayList<String> readTransactionsForUser(String name) {
        File textFile = new File("TextLog.txt");
        ArrayList<String> logs = new ArrayList<>();
        ArrayList<String> logsForUser = new ArrayList<>();

        try {
            FileReader fr = new FileReader(textFile);
            BufferedReader reader = new BufferedReader(fr);  
            String line;

            while ((line = reader.readLine()) != null) {
                logs.add(line);
            }

            reader.close();

            for (String log : logs){
                if(log.contains(name)){
                    logsForUser.add(log);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
        return logsForUser;
    }

       public static void BankStatementFile(String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();   

        try {
            FileWriter fw = new FileWriter("USERTRANSACTIONSFILE.txt", true);
            BufferedWriter writer = new BufferedWriter(fw);

            ArrayList<Account> users = Account.getUsers();
            for (Account user : users) {
                String userName = user.customer.firstName+" "+user.customer.lastName;
                if(name.equals(userName)){
                    writer.write(" ");
                    writer.write("Current Information on : "+userName);
                    writer.write(" ");
                    writer.newLine();                    
                
                    writer.write("User Identification Number : ");
                    writer.write(user.customer.identificationNumber);
                    writer.write(" ");
                    writer.newLine();                     
                
                    writer.write("Full Name : ");
                    writer.write(user.customer.firstName+ " " + user.customer.lastName);
                    writer.write(" ");                
                    writer.newLine();                 
                
                    writer.write("Date of Birth : ");
                    writer.write(user.customer.dateOfBirth);
                    writer.write(" ");   
                    writer.newLine();                     
                
                    writer.write("Address : ");
                    writer.write(user.customer.address);
                    writer.write(" "); 
                    writer.newLine();                       
                
                    writer.write("Phone Number : ");
                    writer.write(user.customer.phoneNumber);
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Checking Information : ");
                    writer.newLine(); 
                    writer.write("Checking Account Number" +user.checking.checkingAccountNumber);
                    writer.newLine(); 
                    writer.write("Checking Starting Balance " +user.checking.checkingStartingBalance);
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                     
                
                    writer.write("Credit Information : ");
                    writer.newLine(); 
                    writer.write("Credit Account Number "+user.credit.creditAccountNumber);
                    writer.newLine(); 
                    writer.write("Credit Starting Balance "+user.credit.creditStartingBalance);
                    writer.newLine(); 
                    writer.write("Credit Max "+user.credit.creditMax);
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Saving Information : ");
                    writer.newLine(); 
                    writer.write("Saving Account Number "+user.saving.savingsAccountNumber);
                    writer.newLine(); 
                    writer.write("Saving Starting Balance "+user.saving.savingsStartingBalance);
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Listing All Of Users Transactions : "); 
                    writer.newLine();                
                    ArrayList<String> userLogs = CSVReader.readTransactionsForUser(userName);
                        for(String log : userLogs){
                            writer.write(log);
                            writer.newLine(); 
                        }
                    writer.newLine();                           
                    writer.write("Date :"+dtf.format(now));
                    writer.write(" ");                
                    
                }
            }
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }


        public static void BankStatementFileCSV(String name){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();   

        try {
            FileWriter fw = new FileWriter("USERTRANSACTIONSFILE.csv", true);
            BufferedWriter writer = new BufferedWriter(fw);

            ArrayList<Account> users = Account.getUsers();
            for (Account user : users) {
                String userName = user.customer.firstName+" "+user.customer.lastName;
                if(name.equals(userName)){
                    writer.write(" ");
                    writer.write("Current Information on : ");
                                        writer.newLine(); 
                    writer.write(userName);
                                        writer.newLine(); 
                    writer.newLine();                    
                
                    writer.write("User Identification Number : ");
                                        writer.newLine(); 
                    writer.write(Integer.toString(user.customer.identificationNumber));
                                        writer.newLine(); 
                    writer.write(" ");
                    writer.newLine();                     
                
                    writer.write("Full Name : ");
                                        writer.newLine(); 
                    writer.write(user.customer.firstName+ " " + user.customer.lastName);
                                        writer.newLine(); 
                    writer.write(" ");                
                    writer.newLine();                 
                
                    writer.write("Date of Birth : ");
                                        writer.newLine(); 
                    writer.write(user.customer.dateOfBirth);
                                        writer.newLine(); 
                    writer.write(" ");   
                    writer.newLine();                     
                
                    writer.write("Address : ");
                                        writer.newLine(); 
                    writer.write(user.customer.address);
                                        writer.newLine(); 
                    writer.write(" "); 
                    writer.newLine();                       
                
                    writer.write("Phone Number : ");
                                        writer.newLine(); 
                    writer.write(user.customer.phoneNumber);
                                        writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Checking Information : ");
                    writer.newLine(); 
                    writer.write("Checking Account Number" );
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.checking.checkingAccountNumber));
                    writer.newLine(); 
                    writer.write("Checking Starting Balance ");
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.checking.checkingStartingBalance));
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                     
                
                    writer.write("Credit Information : ");
                    writer.newLine(); 
                    writer.write("Credit Account Number ");
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.credit.creditAccountNumber));
                    writer.newLine(); 
                    writer.write("Credit Starting Balance ");
                                        writer.newLine(); 
                                        writer.write( Double.toString(user.credit.creditStartingBalance));
                    writer.newLine(); 
                    writer.write("Credit Max ");
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.credit.creditMax));
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Saving Information : ");
                    writer.newLine(); 
                    writer.write("Saving Account Number ");
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.saving.savingsAccountNumber));
                    writer.newLine(); 
                    writer.write("Saving Starting Balance ");
                                        writer.newLine(); 
                                        writer.write(Double.toString(user.saving.savingsStartingBalance));
                    writer.newLine(); 
                    writer.write(" ");  
                    writer.newLine();                 
                
                    writer.write("Listing All Of Users Transactions : "); 
                    writer.newLine();                
                    ArrayList<String> userLogs = CSVReader.readTransactionsForUser(userName);
                        for(String log : userLogs){
                            writer.write(log);
                            writer.newLine(); 
                        }
                    writer.newLine();                           
                    writer.write("Date :"+dtf.format(now));
                    writer.write(" ");                
                    
                }
            }
            writer.newLine();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            // Handle the file writing exception as needed
        }
    }


    //     public static  ReadTransactions(){
    //     ArrayList<Account> users = new ArrayList<>();


    //     try {
    //         FileReader fr = new FileReader(file);
    //         BufferedReader reader = new BufferedReader(fr);  
    //         String line;
    //         boolean headerLine = true;
    //         String address = ""; 

    //         while ((line = reader.readLine()) != null) {

    //             if (headerLine) {
    //                 headerLine = false;
    //                 continue; //Skips the header line
    //             }

    //             //Split the CSV line into an array of values
    //             address = line.substring(line.indexOf("\""), line.indexOf("\"", line.indexOf("\"") + 2));

    //             String[] data = line.split(",");

    //             // Extract the bank user information from the data array
    //             Person person = new Person(data[1], data[2], data[3], address, data[7]);
    //             Customer customer = new Customer(person, Integer.parseInt(data[0]));
    //             Checking checking = new Checking(Integer.parseInt(data[8]), Double.parseDouble(data[9]));
    //             Saving savings = new Saving(Integer.parseInt(data[10]),Double.parseDouble(data[11]));
    //             Credit credit = new Credit(Integer.parseInt(data[12]), Integer.parseInt(data[13]), Double.parseDouble(data[14]));

    //             Account user = new Account(customer, checking, savings, credit);

    //             users.add(user);
            
    //         }
    //         reader.close();
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //         // Handle the file reading exception as needed
    //     }
    //     return users;
    // }

    public static void logging(String log){
        //TODO: create file 
        // Example of dynamic : file.append(log);
    }
}
