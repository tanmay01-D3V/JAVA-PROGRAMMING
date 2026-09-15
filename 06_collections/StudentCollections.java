import java.util.*;

public class StudentCollections{
    public static void main(String[] args){
        HashSet<String> students= new HashSet<>();

        students.add("Rahul");
        students.add("Priya");
        students.add("Amit");
        students.add("Rahul");

        LinkedList<String> subject= new LinkedList<>();
        subject.add("Java");
        subject.add("Science");
        subject.add("English");

        TreeMap<Integer, Integer> marks = new TreeMap<>();
        marks.put(103, 85);
        marks.put(101, 90);
        marks.put(102, 85);

        System.out.println("Students: " + students);
        System.out.println("\nSubjects: " + subject);
        System.out.println("\nStudent Marks: " + marks);

    }
}