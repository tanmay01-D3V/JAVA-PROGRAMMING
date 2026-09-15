import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double balance = 1000.0; // Initial balance

        System.out.println("====Welcome to the ATM!=====");
        System.out.println("     1. Check Balance");
        System.out.println("     2. Deposit Money");
        System.out.println("     3. Withdraw Money");
        System.out.print("Please select an option (1-3): ");
        int option = sc.nextInt();

        switch (option) {
            case 1:
                System.out.println("Your current balance is: $" + balance);
                break;
            case 2:
                System.out.print("Enter the amount to deposit: $");
                double depositAmount = sc.nextDouble();
                if (depositAmount > 0) {
                    balance += depositAmount;
                    System.out.println("You have successfully deposited $" + depositAmount);
                    System.out.println("Your new balance is: $" + balance);
                } else {
                    System.out.println("Invalid deposit amount.");
                }
                break;
            case 3:
                System.out.print("Enter the amount to withdraw: $");
                double withdrawAmount = sc.nextDouble();
                if (withdrawAmount > 0 && withdrawAmount <= balance) {
                    balance -= withdrawAmount;
                    System.out.println("You have successfully withdrawn $" + withdrawAmount);
                    System.out.println("Your new balance is: $" + balance);
                } else {
                    System.out.println("Invalid withdrawal amount or insufficient funds.");
                }
                break;
            default:
                System.out.println("Invalid option selected.");
        }

        sc.close();
    }
}
