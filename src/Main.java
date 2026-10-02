import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        displayWelcomeMessage();

        String appName = "Personal Finance Manager";
        displayMessage(appName);

        Scanner scanner = new Scanner(System.in);

        // Stores all Transaction objects
        ArrayList<Transaction> transactions = new ArrayList<>();

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();

        // Starting balance is the user's starting income
        double balance = income;

        // Create a Transaction object for the starting income
        Transaction incomeTransaction = new Transaction(income, "Income");

        // Store the starting transaction in the ArrayList
        transactions.add(incomeTransaction);

        System.out.println("Your income is: " + income);

        String incomeMessage = evaluateIncome(income);
        System.out.println(incomeMessage);

        boolean running = true;

        while (running) {

            // Display the menu each time the loop runs
            displayMenu();

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 1) {

                System.out.print("Enter income amount: ");
                double amount = scanner.nextDouble();

                // Create and store the new income transaction
                Transaction newIncome = new Transaction(amount, "Income");
                transactions.add(newIncome);

                for (Transaction transaction : transactions) {
                    System.out.println(
                            transaction.getType() + ": " + transaction.getAmount()
                    );
                }

                // Increase both total income and available balance
                income = income + amount;
                balance = balance + amount;

                System.out.println("Updated income: " + income);

            } else if (choice == 2) {

                System.out.print("Enter expense amount: ");
                double expense = scanner.nextDouble();

                // Create and store the new expense transaction
                Transaction newExpense = new Transaction(expense, "Expense");
                transactions.add(newExpense);

                // Expenses reduce the available balance
                balance = balance - expense;

                System.out.println("Remaining balance: " + balance);

            } else if (choice == 3) {

                System.out.println("Current balance: " + balance);

            } else if (choice == 4) {

                System.out.println(
                        "Thank you for using Personal Finance Manager"
                );

                running = false;

            } else if (choice == 5) {

                System.out.println("Transaction History:");

                // Go through every Transaction stored in the ArrayList
                for (Transaction transaction : transactions) {

                    System.out.println(
                            transaction.getType() + ": "
                                    + transaction.getAmount()
                    );
                }

            } else {

                System.out.println(
                        "Invalid option. Please choose 1-5."
                );
            }
        }
    }

    private static void displayMenu() {
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");
        System.out.println("5. View Transactions");
    }

    private static void displayMessage(String message) {
        System.out.println(message);
    }

    private static String evaluateIncome(double income) {

        if (income > 5000) {
            return "High income";
        } else if (income > 2500) {
            return "Income is Good";
        } else {
            return "Income needs improvement";
        }
    }

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to Personal Finance Manager");
    }
}