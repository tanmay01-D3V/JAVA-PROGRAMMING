import java.util.Scanner;

public class passwordvalidation {
    public static void main(String[] args){
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter your password: ");       
        String password = sc.nextLine();

        int attempts = 3;

        while (attempts > 0){

            System.out.print("Confirm your password: ");
            String confirmPassword = sc.nextLine();

            if (password.equals(confirmPassword)){
                System.out.println("Password confirmed successfully!");
                break;
            } else {
                attempts--;
                System.out.println("Passwords do not match. You have " + attempts + " attempts left.");
            }
        }       
    }
}
