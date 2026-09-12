
import java.util.Scanner;

public class example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] marks = {80, 75, 90, 65, 88};

        try {
            System.out.println("Enter student index: ");
            int index = sc.nextInt();

            System.out.println("Marks = " + marks(index));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid student index: ");
        }

        sc.close();
    }
}
