public class Transaction {
    private double amount;
    private String type;


    // Constructor used to create a new Transaction object
    public Transaction(double amount, String type) {
        this.amount = amount; // Store the amount passed into the constructor in this object's amount field
        this.type = type;// Store the type passed into the constructor in this object's type field


    }
    // Returns the amount stored in this Transaction object
    public double getAmount() {
        return amount;

    }
    // Returns the type stored in this Transaction object
    public String getType() {
        return type;
    }
}
