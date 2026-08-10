import java.util.Scanner;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String name, grade, result;
        double m1, m2, m3, m4, m5;
        System.out.print("Enter your name: ");
        name = sc.nextLine();
        System.out.print("\n");
        System.out.print("Enter marks for JAVA: ");
        m1 = sc.nextDouble();
        System.out.print("Enter marks for Backend: ");
        m2 = sc.nextDouble();
        System.out.print("Enter marks for DBMS: ");
        m3 = sc.nextDouble();
        System.out.print("Enter marks for Computer Network: ");
        m4 = sc.nextDouble();
        System.out.print("Enter marks for Physical health: ");
        m5 = sc.nextDouble();
        System.out.print("\n");
        double total = m1 + m2 + m3 + m4 + m5;
        double percentage = (total / 500) * 100;
        if (percentage >= 90)
            grade = "A";
        else if (percentage >= 75)
            grade = "B";
        else if (percentage >= 60)
            grade = "C";
        else if (percentage >= 40)
            grade = "D";
        else
            grade = "F";
        if (percentage >= 40)
            result = "Pass";
        else
            result = "Fail";
        System.out.println("===== Report Card =====");
        System.out.println("Name: " + name);
        System.out.println("Total Marks: " + total);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);
        System.out.println("Result: " + result);
        System.out.print("\n");
    }
}