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

            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Balance");
            System.out.println("4. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            if (choice == 4) {
                running = false;
            }
        }
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