import java.util.Scanner;

@SuppressWarnings("resource")
public class DayOfWeekSwitch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            System.out.print("Enter nth day of week: ");
            int num = sc.nextInt();

            String day = switch (num) {
                case 1 -> "Monday";
                case 2 -> "Tuesday";
                case 3 -> "Wednesday";
                case 4 -> "Thursday";
                case 5 -> "Friday";
                case 6 -> "Saturday";
                case 7 -> "Sunday";
                default -> "Invalid day";
            };
            System.out.println("The day corresponding to the number " + num + " is: " + day);
        }
    }
}
