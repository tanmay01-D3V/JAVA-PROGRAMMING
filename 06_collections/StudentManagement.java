import java.util.*;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, String> students = new HashMap<>();
        LinkedList<String> courses = new LinkedList<>();
        TreeMap<Integer, Double> marks = new TreeMap<>();
        int choice;

        do {
            System.out.println("\n=====Student Management System=====");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Add Student Marks");
            System.out.println("4. Display Students");
            System.out.println("5. Display Courses");
            System.out.println("6. Display Marks");
            System.out.println("7. Search Student");
            System.out.println("8. Delete Student");
            System.out.println("9. Exit");

            System.out.println("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    if (students.containsKey(id)) {
                        System.out.println("Student ID already exists.");
                    } else {
                        System.out.println("Enter Student Name: ");
                        String name = sc.nextLine();
                        students.put(id, name);
                    }
                    break;
                case 2:
                    sc.nextLine();

                    System.out.println("Enter Course Name:");
                    String courseName = sc.nextLine();

                    courses.add(courseName);
                    System.out.println("Course added successfully!");
                    break;
                case 3:
                    System.out.println("Enter the Student ID: ");
                    int markId = sc.nextInt();

                    if (!students.containsKey(markId)) {
                        System.out.println("Students does not exist.");
                    } else {
                        System.out.println("Enter the Marks: ");
                        double mark = sc.nextDouble();

                        marks.put(markId, mark);
                    }
                    break;
                case 4:
                    System.out.println("\n---- Student Records ---");

                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 9);
    }
}