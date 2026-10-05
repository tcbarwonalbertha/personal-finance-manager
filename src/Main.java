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

        // Create and store the starting income transaction
        Transaction incomeTransaction =
                new Transaction(income, "Income", "Salary");

        transactions.add(incomeTransaction);

        System.out.println("Your income is: " + income);

        String incomeMessage = evaluateIncome(income);
        System.out.println(incomeMessage);

        boolean running = true;

        while (running) {

            displayMenu();

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            // OPTION 1 - ADD INCOME
            if (choice == 1) {

                System.out.print("Enter income amount: ");
                double amount = scanner.nextDouble();

                // Clear the Enter left behind by nextDouble()
                scanner.nextLine();

                System.out.print("Enter income category: ");
                String category = scanner.nextLine();

                // Create and store the income transaction
                Transaction newIncome =
                        new Transaction(amount, "Income", category);

                transactions.add(newIncome);

                income = income + amount;
                balance = balance + amount;

                System.out.println("Updated income: " + income);

                // OPTION 2 - ADD EXPENSE
            } else if (choice == 2) {

                System.out.print("Enter expense amount: ");
                double expense = scanner.nextDouble();

                // Clear the Enter left behind by nextDouble()
                scanner.nextLine();

                System.out.print("Enter expense category: ");
                String category = scanner.nextLine();

                // Create and store the expense transaction
                Transaction newExpense =
                        new Transaction(expense, "Expense", category);

                transactions.add(newExpense);

                balance = balance - expense;

                System.out.println("Remaining balance: " + balance);

                // OPTION 3 - VIEW BALANCE
            } else if (choice == 3) {

                System.out.println("Current balance: " + balance);

                // OPTION 4 - EXIT
            } else if (choice == 4) {

                System.out.println(
                        "Thank you for using Personal Finance Manager"
                );

                running = false;

                // OPTION 5 - VIEW TRANSACTIONS
            } else if (choice == 5) {

                System.out.println("Transaction History:");

                for (Transaction transaction : transactions) {

                    System.out.println(
                            transaction.getType() + ": "
                                    + transaction.getAmount()
                                    + " - Category: "
                                    + transaction.getCategory()
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