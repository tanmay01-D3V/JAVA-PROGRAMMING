import java.util.HashMap;
import java.util.HashSet;

public class librarysystem {
    public static void main(String[] args) {
        HashMap<Integer, String> Authors = new HashMap<>();

        Authors.put(101, "shakespeare");
        Authors.put(102, "APJ Abdul Kalam");
        Authors.put(103, "J.K Rowling");
        Authors.put(104, "Stephen King");
        Authors.put(105, "Stan lee");

        System.out.println("Book Authors: ");
        System.out.println(Authors);

        HashSet<String> books = new HashSet<>();

        books.add("Java");
        books.add("Backend");
        books.add("Computer Network");
        books.add("DBMS");

        HashMap<Integer, HashSet<String>> readerBooks = new HashMap<>();

        readerBooks.put(101, new HashSet<>());
        readerBooks.put(102, new HashSet<>());
        readerBooks.put(103, new HashSet<>());
        readerBooks.put(104, new HashSet<>());
        readerBooks.put(105, new HashSet<>());

        readerBooks.get(101).add("Java");
        readerBooks.get(101).add("Backend");
        readerBooks.get(101).add("Computer Network");

        readerBooks.get(102).add("Java");
        readerBooks.get(102).add("Computer Network");

        readerBooks.get(103).add("DBMS");
        readerBooks.get(103).add("Backend");

        readerBooks.get(104).add("Java");
        readerBooks.get(104).add("Computer Network");

        readerBooks.get(105).add("Java");

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

        System.out.println("Reader ID: " + studentId);
        System.out.println("Reader's Author Record: " + Authors.get(studentId));

        System.out.println("Borrowed Books: ");

        int total = 0;
        for (String book : readerBooks.get(studentId)) {
            int mark = marks.get(studentId).get(book);
            total += mark;
            System.out.println(book + "-" + mark);
        }

        double averagemark = (double) total / readerBooks.get(studentId).size();
        System.out.println("\nTotal Marks: " + total);
        System.out.println("Average Marks: " + averagemark);

    }
}
