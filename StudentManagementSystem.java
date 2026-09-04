import java.util.HashMap;
import java.util.HashSet;

public class StudentManagementSystem {
    public static void main(String[] args) {
        HashSet<Integer> presentstudents = new HashSet<>();

            presentstudents.add(101);
            presentstudents.add(102);
            presentstudents.add(103);
            presentstudents.add(101);

        System.out.println("Present Students IDs: " + presentstudents);

        System.out.println("--------------------------");
       
        HashMap<Integer, Integer> marks = new HashMap<>();
            marks.put(101, 35);
            marks.put(102, 45);
            marks.put(103, 90);
            marks.put(104, 55);

        System.out.println("Student Marks: ");
        System.out.println(marks);

        System.out.println("-------------------");

        int studentId = 101;

        if (presentstudents.contains(studentId)) {
            System.out.println("Student" + studentId + "is present"); 

            System.out.println("Marks: " + marks.get(studentId));
        }else {
            System.out.println("Student: " + studentId + "is absent");
            System.out.println();
        }
    }
}
