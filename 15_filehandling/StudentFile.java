import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Studentfile {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            FileWriter writer = new FileWriter("student.txt", true);

            System.out.println("Enter student name: ");
            String name = sc.nextLine();

            System.out.println("Enter Course name: ");
            String course = sc.nextLine();

            System.out.println("Enter Marks: ");
            int marks = sc.nextInt();

            writer.write("Name : " + name + "\n");
            writer.write("Course : " + course + "\n");
            writer.write("Marks : " + marks + "\n");
            writer.write("------------------------\n");
            writer.close();

            System.out.println("Student details saved successfully.");

        } catch (IOException e) {
            System.out.println("An error occurred while saving student details.");
        }
    }
}
