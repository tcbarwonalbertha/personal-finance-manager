import java.util.Scanner;


public  class Main {

    public static void main(String[] args) {

        String appName = "Personal Finance Manager";
        System.out.println(appName);

        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter your Name") ;
        String name = scanner.nextLine();
        System.out.println("Hello + Name");
        System.out.println("Enter your Monthly income");
        double income = scanner.nextDouble();
        System.out.println("Your income is:" +income);


    }
}
