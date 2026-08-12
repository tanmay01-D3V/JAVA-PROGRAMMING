import java.util.Scanner;

public class Switch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter nth day of week: ");
        int num = sc.nextInt(); 

        String Day;

        switch(num) {
            case 1:
                Day = "Monday";
                break;
            case 2:
                Day = "Tuesday";
                break;
            case 3:     
                Day = "Wednesday";
                break;
            case 4:
                Day = "Thursday";
                break;
            case 5:
                Day = "Friday";
                break;
            case 6:
                Day = "Saturday";
                break;
            case 7:
                Day = "Sunday";
                break;
            default:
                Day = "Invalid day";        
        }
        System.out.println("The day corresponding to the number " + num + " is: " + Day);

        sc.close();
    }
}
