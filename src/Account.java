import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    

/**
 * The Account class represents a bank account associated with a customer.
 * It contains information about the customer, checking account, savings account, and credit account.
 * @author Juan Moreno, Javier Ontiveros
 * @version 1.0.0
 */
public class Account implements AccountInterface {
    protected Customer customer;
    protected Checking checking;
    protected Saving saving;
    protected Credit credit;
    protected static ArrayList<Account> users = new ArrayList<>();

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
    
    public static void setUsers(){
        users = CSVReader.getUsers();
    }

    public static ArrayList<Account> getUsers(){
        return users;
    }

    public static void getUserAccountByName(String name){
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName+" "+user.customer.lastName;
            if(name.equals(userName)){
                System.out.println("information on "+name);
                System.out.println(user.customer.identificationNumber);
                System.out.println(user.customer.firstName+ " " + user.customer.lastName);
                System.out.println(user.customer.dateOfBirth);
                System.out.println(user.customer.address);
                System.out.println(user.customer.phoneNumber);
                System.out.println("checking account number" +user.checking.checkingAccountNumber);
                System.out.println("checking starting balance " +user.checking.checkingStartingBalance);
                System.out.println("credit account number "+user.credit.creditAccountNumber);
                System.out.println("credit starting balance "+user.credit.creditStartingBalance);
                System.out.println("credit max "+user.credit.creditMax);
                System.out.println("saving account number "+user.saving.savingsAccountNumber);
                System.out.println("saving starting balance "+user.saving.savingsStartingBalance);
            }
        }
    }

    public static void getUserAccountByAccount(int id){
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName+" "+user.customer.lastName;
            if(id == user.customer.identificationNumber){
                System.out.println("information on "+userName);
                System.out.println(user.customer.identificationNumber);
                System.out.println(user.customer.firstName+ " " + user.customer.lastName);
                System.out.println(user.customer.dateOfBirth);
                System.out.println(user.customer.address);
                System.out.println(user.customer.phoneNumber);
                System.out.println("checking account number" +user.checking.checkingAccountNumber);
                System.out.println("checking starting balance " +user.checking.checkingStartingBalance);
                System.out.println("credit account number "+user.credit.creditAccountNumber);
                System.out.println("credit starting balance "+user.credit.creditStartingBalance);
                System.out.println("credit max "+user.credit.creditMax);
                System.out.println("saving account number "+user.saving.savingsAccountNumber);
                System.out.println("saving starting balance "+user.saving.savingsStartingBalance);
            }
        }
    }

    public static void userTransactions(String name){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();    

        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName+" "+user.customer.lastName;
            if(name.equals(userName)){
                System.out.println("information on "+userName);
                System.out.println("Full Name : " + user.customer.firstName+ " " + user.customer.lastName);
                System.out.println("DOB : " +user.customer.dateOfBirth);
                System.out.println("Address : " +user.customer.address);
                System.out.println("Phone Number : " +user.customer.phoneNumber);
                System.out.println("checking balance :" +user.checking.checkingStartingBalance);
                System.out.println("credit balance :"+user.credit.creditStartingBalance);
                System.out.println("credit max :"+user.credit.creditMax);
                System.out.println("saving balance :"+user.saving.savingsStartingBalance);
                System.out.println("All Transactions ---------");
                ArrayList<String> userLogs = CSVReader.readTransactionsForUser(name);
                    for(String log : userLogs){
                        System.out.println(log);
                    }
                System.out.println("END Transactions ---------");
                System.out.println("Date :"+dtf.format(now));
                CSVReader.BankStatementFile(name);
            }
        }
    }

    public static void addNewUser(){
                int userID = 0;
                int creditMax = 0;
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter Users First and Last name:");
                String[] name = scanner.nextLine().split(" ");  

                System.out.println("Enter date of birth");
                String dateOfBirth = scanner.nextLine();

                System.out.println("Enter address");
                String address = scanner.nextLine();

                System.out.println("Enter phoneNumber");
                String phoneNumber = scanner.nextLine();    

                Person person = new Person(name[0],name[1], dateOfBirth, address, phoneNumber);
                
                for (Account user : users) {
                    if(user.customer.identificationNumber > userID){
                        userID = user.customer.identificationNumber;
                    }
                }

                userID += 1;
                
                Random random = new Random();
                Customer customer = new Customer(person, userID);
                Checking checking = new Checking( random.nextInt(3000 - 2000 + 1) + 2000, 0);
                Saving savings = new Saving(random.nextInt(3000 - 2000 + 1) + 2000,0);

                System.out.println("Enter Credit Score");
                int creditScore = Integer.parseInt(scanner.nextLine());  
                
                if(creditScore <= 580){
                 creditMax =  random.nextInt(699 - 100 + 1) + 100;
                }
                else if(creditScore >= 581 && creditScore <= 669){
                 creditMax =  random.nextInt(4999 - 700 + 1) + 700;
                }
                else if(creditScore >= 670 && creditScore <= 739){
                 creditMax =  random.nextInt(7499 - 5000 + 1) + 5000;
                }
                else if(creditScore >= 740 && creditScore <= 799){
                 creditMax =  random.nextInt(15999 - 7500 + 1) + 7500;
                }
                else if(creditScore >= 800 ){
                 creditMax =  random.nextInt(25000 - 16000 + 1) + 16000;
                }

                Credit credit = new Credit(random.nextInt(3000 - 2000 + 1) + 2000, creditMax, 0);

                Account user = new Account(customer, checking, savings, credit);
                Account.users.add(user);
                System.out.println(name[0]+" "+name[1]+" has been added!");
    }

    public static void BankStatementUserUI(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("A) Search By Name. B) Search By ID. or type EXIT");
            String input = scanner.nextLine();

            switch(input) {
                case "A":
                    System.out.println("Enter Users name");
                    String name = scanner.nextLine();                  
                    Account.BankStatementUserByName(name);
                    break;
                case "B":
                    System.out.println("Enter Users ID");
                    int id = Integer.parseInt(scanner.nextLine()); 
                    Account.BankStatementUserByID(id);
                    break;
                case "EXIT":
                    quit = true;
                    break;                        
              default:
                System.out.println("Wrong Selection");
            }
        }
    }

    public static void BankStatementUserByName(String name){
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName+" "+user.customer.lastName;
            if(name.equals(userName)){
                System.out.println(" ");                
                System.out.println("Current Information on : "+name);
                System.out.println(" ");

                System.out.println("User Identification Number : ");
                System.out.println(user.customer.identificationNumber);
                System.out.println(" ");
                

                System.out.println("Full Name : ");
                System.out.println(user.customer.firstName+ " " + user.customer.lastName);
                System.out.println(" ");                


                System.out.println("Date of Birth : ");
                System.out.println(user.customer.dateOfBirth);
                System.out.println(" ");   

                 System.out.println("Address : ");
                System.out.println(user.customer.address);
                System.out.println(" ");   
               
                System.out.println("Phone Number : ");
                System.out.println(user.customer.phoneNumber);
                System.out.println(" ");  


                System.out.println("Checking Information : ");
                System.out.println("Checking Account Number" +user.checking.checkingAccountNumber);
                System.out.println("Checking Starting Balance " +user.checking.checkingStartingBalance);
                System.out.println(" ");  

                System.out.println("Credit Information : ");
                System.out.println("Credit Account Number "+user.credit.creditAccountNumber);
                System.out.println("Credit Starting Balance "+user.credit.creditStartingBalance);
                System.out.println("Credit Max "+user.credit.creditMax);
                System.out.println(" ");  


                System.out.println("Saving Information : ");
                System.out.println("Saving Account Number "+user.saving.savingsAccountNumber);
                System.out.println("Saving Starting Balance "+user.saving.savingsStartingBalance);
                System.out.println(" ");  


                System.out.println("Listing All Of Users Transactions : ");                
                ArrayList<String> userLogs = CSVReader.readTransactionsForUser(name);
                    for(String log : userLogs){
                        System.out.println(log);
                    }
                System.out.println(" ");
                System.out.println(" ");

                CSVReader.BankStatementFileCSV(userName);
                return;
            }
        }
        System.out.print("User Not Found");
    }

    public static void BankStatementUserByID(int id){
        ArrayList<Account> users = Account.getUsers();
        for (Account user : users) {
            String userName = user.customer.firstName+" "+user.customer.lastName;
            if(id == user.customer.identificationNumber){
                System.out.println(" ");
                System.out.println("Current Information on : "+userName);
                System.out.println(" ");

                System.out.println("User Identification Number : ");
                System.out.println(user.customer.identificationNumber);
                System.out.println(" ");
                

                System.out.println("Full Name : ");
                System.out.println(user.customer.firstName+ " " + user.customer.lastName);
                System.out.println(" ");                


                System.out.println("Date of Birth : ");
                System.out.println(user.customer.dateOfBirth);
                System.out.println(" ");   

                 System.out.println("Address : ");
                System.out.println(user.customer.address);
                System.out.println(" ");   
               
                System.out.println("Phone Number : ");
                System.out.println(user.customer.phoneNumber);
                System.out.println(" ");  


                System.out.println("Checking Information : ");
                System.out.println("Checking Account Number" +user.checking.checkingAccountNumber);
                System.out.println("Checking Starting Balance " +user.checking.checkingStartingBalance);
                System.out.println(" ");  

                System.out.println("Credit Information : ");
                System.out.println("Credit Account Number "+user.credit.creditAccountNumber);
                System.out.println("Credit Starting Balance "+user.credit.creditStartingBalance);
                System.out.println("Credit Max "+user.credit.creditMax);
                System.out.println(" ");  


                System.out.println("Saving Information : ");
                System.out.println("Saving Account Number "+user.saving.savingsAccountNumber);
                System.out.println("Saving Starting Balance "+user.saving.savingsStartingBalance);
                System.out.println(" ");  


                System.out.println("Listing All Of Users Transactions : ");                
                ArrayList<String> userLogs = CSVReader.readTransactionsForUser(userName);
                    for(String log : userLogs){
                        System.out.println(log);
                    }
                System.out.println(" ");
                System.out.println(" ");                

                CSVReader.BankStatementFileCSV(userName);
                return;
            }
        }
        System.out.print("User Not Found");
    }


    public static void bankManagerUI(){
        boolean quit = false;
        while(!quit){
            Scanner scanner = new Scanner(System.in); 
            System.out.println("A) Inquire account by name. B) Inquire account by type/number. C) Run Transaction reader. D) Create a Account. E) Bank Statement For User. or type EXIT");
            String choice = scanner.nextLine();  // Read user input
                switch(choice) {
                    case "A": 
                        System.out.println("What is the account Name?"); 
                        String name = scanner.nextLine();  // Read user input                   
                        Account.getUserAccountByName(name);
                        break;
                    case "B":
                        System.out.println("what is the account number?");
                        int id = Integer.parseInt(scanner.nextLine());
                        Account.getUserAccountByAccount(id);
                        break;
                    case "C":
                        System.out.println("Running transaction reader");
                        // int id = Integer.parseInt(scanner.nextLine());
                        // Account.getUserAccountByAccount(id);
                        break;
                    case "D":
                        Account.addNewUser();
                        break;
                    case "E":
                        Account.BankStatementUserUI();
                        break;                       
                    case "EXIT":
                        quit = true;
                        break;   
                  default:
                    // code block
                    System.out.println("Wrong Selection");
                }
        }
    }
}

interface AccountInterface{
    public Customer getCustomer();

    public Checking getChecking();
    
    public Credit getCredit();

    public Saving getSaving();

    public void setChecking(Checking checking);

    public void setCredit(Credit credit);

    public void setCustomer(Customer customer);

    public void setSaving(Saving saving);

}