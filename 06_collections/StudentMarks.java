import java.util.HashMap;

public class StudentMarks {
    public static void main(String[] args) {
        HashMap<String, Integer> marks = new HashMap<>();
            marks.put("Raul", 35);
             marks.put("soham", 45);
            marks.put("Arav", 90);
            marks.put("Rahul", 55);

        System.out.println("Marks: " + marks);

        System.out.println("Rahul marks: " + marks.get("Rahul"));

        if(marks.containsKey("Arav")) {
            System.out.println("Arav is present");
        }
    }
}
