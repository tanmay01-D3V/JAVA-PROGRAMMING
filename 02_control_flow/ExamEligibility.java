import java.util.Scanner;

public class ExamEligibility {
    public static void main(String[] args){
        java.util.Scanner sc = new Scanner(System.in);

        System.out.print("Enter attendance percentage: ");
        int attendance = sc.nextInt();

        System.out.print("Enter internal marks: ");
        int marks = sc.nextInt();

        System.out.print("Assignment Submmited ? (true/false)");
        boolean assignment = sc.nextBoolean();

        if(attendance >= 70 && marks >= 35 && assignment){
            System.out.println("Eligible for Exam");
        }else{
            System.out.println("Not Eligible for Exam");
        }

        sc.close();
    }
}
