import java.util.ArrayList;
import java.util.Scanner;

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

    public static void bankManagerUI(){
        boolean quit = false;
        while(!quit){
            Scanner scanner = new Scanner(System.in); 
            System.out.println("A) Inquire account by name. B) Inquire account by type/number or type EXIT");
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