import java.util.ArrayList;

public class FileReader {
    
        static ArrayList<Account> users = new ArrayList<Account>(); 
        FileReader file;
        Account user;
        //read through file
        // add to user info
        // i = 0;
        // foreach (fileRow) {
        //     user.personInfo(fileRow[i]);
        //     user.personInfo(fileRow[i]);
        //     user.checkings(fileRow[checkingAccountNumber],fileRow[checkingStartingBalance]);
        //     i++;
        // }

        public static ArrayList<Account> getUsers(){
            return users;
        }
}
