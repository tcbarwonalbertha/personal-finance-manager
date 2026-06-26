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

        if (income > 5000) {
            System.out.println("High income");
        } else  if (income > 2500){
            System.out.println("Income is Good");

        } else {
            System.out.println("income needs improvement");

        }
        }

    private static void displayMessage(String message) {
        System.out.println("Message");
    }

    public static  void displayWelcomeMessage(){
        System.out.println("welcome to Personal Finance Manger");

        }

    }
