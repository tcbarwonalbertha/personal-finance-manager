import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        displayWelcomeMessage();


        String appName = "Personal Finance Manager";
        displayMessage(appName);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name);

        System.out.print("Enter your monthly income: ");
        double income = scanner.nextDouble();

        System.out.println("Your income is: " + income);

        String incomeMessage = evaluateIncome(income);
        System.out.println(incomeMessage);

        boolean running = true;

        while (running) {




            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            double balance = income ;
            if (choice == 1) {
                System.out.println("Enter income amount: ");
                double amount = scanner.nextDouble();
                balance = income;
                income = income + amount;


                System.out.println("Updated income: " + income);

            } else if (choice == 2) {
                System.out.println("Enter expense amount: ");
                double expense = scanner.nextDouble();

                balance = balance - expense;
                System.out.println("Remaining balance: " + balance);

            } else if (choice == 3) {
                System.out.println("Current balance: " + balance);

            } else if (choice == 4) {
                System.out.println("Thank you for using Personal Finance Manager");
                running = false;

            } else {
                System.out.println("Invalid option. Please choose 1-4.");
            }
        }
    }
    private  static void displayMenu(){
        System.out.println("1. Add Income");
        System.out.println("2. Add Expense");
        System.out.println("3. View Balance");
        System.out.println("4. Exit");

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

