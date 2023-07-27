package CS3331LabProject;
/*
 * The Transaction class represents a single transaction record from the Transaction.csv
 * file. It has getter methods to retrieve the transaction details.
 */
public class Transaction {
    private String fromFirstName;
    private String fromLastName;
    private String fromWhere;
    private String action;
    private String toFirstName;
    private String toLastName;
    private String toWhere;
    private double actionAmount;

    public Transaction(String fromFirstName, String fromLastName, String fromWhere, String action,
                       String toFirstName, String toLastName, String toWhere, double actionAmount) {
        this.fromFirstName = fromFirstName;
        this.fromLastName = fromLastName;
        this.fromWhere = fromWhere;
        this.action = action;
        this.toFirstName = toFirstName;
        this.toLastName = toLastName;
        this.toWhere = toWhere;
        this.actionAmount = actionAmount;
    }

    public String getFromFirstName() {
        return fromFirstName;
    }

    public String getFromLastName() {
        return fromLastName;
    }

    public String getFromWhere() {
        return fromWhere;
    }

    public String getAction() {
        return action;
    }

    public String getToFirstName() {
        return toFirstName;
    }

    public String getToLastName() {
        return toLastName;
    }

    public String getToWhere() {
        return toWhere;
    }

    public double getActionAmount() {
        return actionAmount;
    }
}