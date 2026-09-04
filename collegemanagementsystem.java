import java.util.HashMap;
import java.util.HashSet;

public class collegemanagementsystem {
    public static void main(String[] args) {
        HashMap<Integer, String> studentNames = new HashMap<>();

        studentNames.put(101, "John");
        studentNames.put(102, "banega");
        studentNames.put(103, "don");
        studentNames.put(104, "daksh");
        studentNames.put(105, "peter");

        System.out.println("Student Names: ");
        System.out.println(studentNames);

        HashSet<String> courses = new HashSet<>();

        courses.add("Java");
        courses.add("Backend");
        courses.add("Computer Network");
        courses.add("DBMS");

        HashMap<Integer, HashSet<String>> StudentCourses = new HashMap<>();

        StudentCourses.put(101, new HashSet<>());
        StudentCourses.put(102, new HashSet<>());
        StudentCourses.put(103, new HashSet<>());
        StudentCourses.put(104, new HashSet<>());
        StudentCourses.put(105, new HashSet<>());

        StudentCourses.get(101).add("Java");
        StudentCourses.get(101).add("Backend");
        StudentCourses.get(101).add("Computer Network");

        StudentCourses.get(102).add("Java");
        StudentCourses.get(102).add("Computer Network");

        StudentCourses.get(103).add("DBMS");
        StudentCourses.get(103).add("backend");

        StudentCourses.get(104).add("Java");
        StudentCourses.get(104).add("Computer Network");

        StudentCourses.get(105).add("Java");

        HashMap<Integer, HashMap<String, Integer>> marks = new HashMap<>();

        marks.put(101, new HashMap<>());
        marks.put(102, new HashMap<>());
        marks.put(103, new HashMap<>());
        marks.put(104, new HashMap<>());
        marks.put(105, new HashMap<>());

        marks.get(101).put("Java", 85);
        marks.get(101).put("Backend", 90);
        marks.get(101).put("Computer Network", 80);

        marks.get(102).put("Java", 75);
        marks.get(102).put("Computer Network", 70);

        marks.get(103).put("DBMS", 95);
        marks.get(103).put("Backend", 88);

        marks.get(104).put("Java", 60);
        marks.get(104).put("Computer Network", 65);

        marks.get(105).put("Java", 55);

        int studentId = 101;

        System.out.println("Student ID: " + (studentId));
        System.out.println("Student Name: " + studentNames.get(studentId));

        System.out.println("Registered Courses: ");

        int total = 0;
        for (String course : StudentCourses.get(studentId)) {
            int mark = marks.get(studentId).get(course);
            total += mark;
            System.out.println(course + "-" + mark);
        }

        double averagemark = (double) total / marks.size();
        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Marks: " + averagemark);

    }
}
