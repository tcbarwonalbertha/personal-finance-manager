import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String appName = "Personal Finance Manager";
        System.out.println(appName);

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

    }
