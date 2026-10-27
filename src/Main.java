
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.File;

public class Main {

    public static void main(String[] args) {

        displayWelcomeMessage();

        String appName = "Personal Finance Manager";
        displayMessage(appName);

        Scanner scanner = new Scanner(System.in);

        // Stores all Transaction objects
        ArrayList<Transaction> transactions = new ArrayList<>();

        // VERSION 1.0 - LOAD SAVED TRANSACTIONS
        loadTransactions(transactions);

        // USERNAME
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        double income = 0;
        double balance = 0;

        // Calculate income and balance from saved transactions
        for (Transaction transaction : transactions) {

            if (transaction.getType().equals("Income")) {
                income = income + transaction.getAmount();
                balance = balance + transaction.getAmount();

            } else if (transaction.getType().equals("Expense")) {
                balance = balance - transaction.getAmount();
            }
        }

        // Ask for starting income only if no transactions exist
        if (transactions.isEmpty()) {

            System.out.print("Enter your monthly income: ");

            while (!scanner.hasNextDouble()) {
                System.out.println(
                        "Invalid input. Please enter a number:"
                );
                scanner.next();
            }

            income = scanner.nextDouble();

            while (income <= 0) {

                System.out.println(
                        "Income must be greater than 0. Please enter again:"
                );

                while (!scanner.hasNextDouble()) {
                    System.out.println(
                            "Invalid input. Please enter a number:"
                    );
                    scanner.next();
                }

                income = scanner.nextDouble();
            }

            balance = income;

            Transaction incomeTransaction =
                    new Transaction(income, "Income", "Salary");

            transactions.add(incomeTransaction);

            System.out.println("Your income is: " + income);

        } else {

            System.out.println("Saved transactions loaded.");
            System.out.println("Total income: " + income);
            System.out.println("Current balance: " + balance);
        }

        String incomeMessage = evaluateIncome(income);
        System.out.println(incomeMessage);

        boolean running = true;

        while (running) {

            displayMenu();

            // MENU INPUT VALIDATION
            System.out.print("Choose an option: ");

            while (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input. Please enter a number from 1 to 5:"
                );
                scanner.next();
            }

            int choice = scanner.nextInt();

            // OPTION 1 - ADD INCOME
            if (choice == 1) {

                System.out.print("Enter income amount: ");

                while (!scanner.hasNextDouble()) {
                    System.out.println(
                            "Invalid input. Please enter a number:"
                    );
                    scanner.next();
                }

                double amount = scanner.nextDouble();

                while (amount <= 0) {

                    System.out.println(
                            "Amount must be greater than 0. Please enter again:"
                    );

                    while (!scanner.hasNextDouble()) {
                        System.out.println(
                                "Invalid input. Please enter a number:"
                        );
                        scanner.next();
                    }

                    amount = scanner.nextDouble();
                }

                scanner.nextLine();

                System.out.print("Enter income category: ");
                String category = scanner.nextLine();

                Transaction newIncome =
                        new Transaction(amount, "Income", category);

                transactions.add(newIncome);

                income = income + amount;
                balance = balance + amount;

                System.out.println("Updated income: " + income);

                // OPTION 2 - ADD EXPENSE
            } else if (choice == 2) {

                System.out.print("Enter expense amount: ");

                while (!scanner.hasNextDouble()) {
                    System.out.println(
                            "Invalid input. Please enter a number:"
                    );
                    scanner.next();
                }

                double expense = scanner.nextDouble();

                while (expense <= 0) {

                    System.out.println(
                            "Amount must be greater than 0. Please enter again:"
                    );

                    while (!scanner.hasNextDouble()) {
                        System.out.println(
                                "Invalid input. Please enter a number:"
                        );
                        scanner.next();
                    }

                    expense = scanner.nextDouble();

                }

                // Prevent expenses exceeding balance
                while (expense > balance) {

                    System.out.println(
                            "Insufficient balance. Your current balance is: "
                                    + balance
                    );

                    System.out.println(
                            "Please enter a smaller expense amount:"
                    );

                    while (!scanner.hasNextDouble()) {
                        System.out.println(
                                "Invalid input. Please enter a number:"
                        );
                        scanner.next();
                    }

                    expense = scanner.nextDouble();

                    while (expense <= 0) {

                        System.out.println(
                                "Amount must be greater than 0. Please enter again:"
                        );

                        while (!scanner.hasNextDouble()) {
                            System.out.println(
                                    "Invalid input. Please enter a number:"
                            );
                            scanner.next();
                        }

                        expense = scanner.nextDouble();
                    }
                }

                scanner.nextLine();

                System.out.print("Enter expense category: ");
                String category = scanner.nextLine();

                Transaction newExpense =
                        new Transaction(expense, "Expense", category);

                transactions.add(newExpense);

                balance = balance - expense;

                System.out.println(
                        "Remaining balance: " + balance
                );

                // OPTION 3 - VIEW BALANCE
            } else if (choice == 3) {

                System.out.println(
                        "Current balance: " + balance
                );

                // OPTION 4 - SAVE AND EXIT
            } else if (choice == 4) {

                saveTransactions(transactions);

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

        scanner.close();
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

        System.out.println(
                "Welcome to Personal Finance Manager"
        );
    }

    // VERSION 1.0 - SAVE TRANSACTIONS
    private static void saveTransactions(
            ArrayList<Transaction> transactions) {

        try (FileWriter writer = new FileWriter("transactions.csv")) {

            for (Transaction transaction : transactions) {

                writer.write(
                        transaction.getType() + ","
                                + transaction.getAmount() + ","
                                + transaction.getCategory() + "\n"
                );
            }

            System.out.println("Transactions saved successfully.");

        } catch (IOException e) {

            System.out.println(
                    "Error saving transactions: " + e.getMessage()
            );
        }
    }

    // VERSION 1.0 - LOAD TRANSACTIONS
    private static void loadTransactions(
            ArrayList<Transaction> transactions) {

        File file = new File("transactions.csv");

        // If no saved file exists, start with an empty list
        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(file))) {

            String line;

            // Read one transaction per line
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",", 3);

                if (data.length == 3) {

                    try {
                        String type = data[0];
                        double amount = Double.parseDouble(data[1]);
                        String category = data[2];

                        if ((type.equals("Income") ||
                                type.equals("Expense"))
                                && Double.isFinite(amount)
                                && amount > 0) {

                            Transaction transaction =
                                    new Transaction(amount, type, category);

                            transactions.add(transaction);
                        }

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Skipping invalid transaction: " + line
                        );
                    }
                }
            }

        } catch (IOException e) {

            System.out.println(
                    "Error loading transactions: " + e.getMessage()
            );
        }
    }
}
