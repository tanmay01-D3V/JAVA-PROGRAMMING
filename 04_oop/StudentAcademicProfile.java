import java.util.Scanner;

class Student {
    private String name;
    private long rollNo;
    private int[] marks;

    public Student(String name, long rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public long getRollNo() {
        return rollNo;
    }

    public int calculateTotal() {
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        return total;
    }

    public double calculatePercentage() {
        return (calculateTotal() / (double) (marks.length * 100)) * 100;
    }

    public boolean isPassed() {
        for (int mark : marks) {
            if (mark < 40) {
                return false;
            }
        }

        return true;
    }

    public String calculateGrade() {
        double percentage = calculatePercentage();

        if (!isPassed()) {
            return "F";
        } else if (percentage >= 90) {
            return "A+";
        } else if (percentage >= 80) {
            return "A";
        } else if (percentage >= 70) {
            return "B";
        } else if (percentage >= 60) {
            return "C";
        } else {
            return "D";
        }
    }

    public void displayDetails() {
        System.out.println("\n----- Student Academic Profile -----");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.printf("Percentage: %.2f%%\n", calculatePercentage());
        System.out.println("Grade: " + calculateGrade());
        System.out.println("Status: " + (isPassed() ? "Pass" : "Fail"));
    }
}

class AcademicProfile {
    private Student student;

    public AcademicProfile(Student student) {
        this.student = student;
    }

    public void showProfile() {
        student.displayDetails();
    }
}

public class StudentAcademicProfile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Roll No: ");
        long rollNo = sc.nextLong();

        System.out.print("Enter Number of Subjects: ");
        int numberOfSubjects = sc.nextInt();

        int[] marks = new int[numberOfSubjects];

        for (int i = 0; i < numberOfSubjects; i++) {
            System.out.print("Enter Marks for Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }

        Student student = new Student(name, rollNo, marks);

        AcademicProfile profile = new AcademicProfile(student);

        profile.showProfile();

        sc.close();
    }
}