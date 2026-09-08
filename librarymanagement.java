import java.util.Scanner;
import java.util.TreeMap;

public class librarymanagement {
    static TreeMap<Integer, String> books = new TreeMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void addBook() {
        System.out.println("Enter Book ID: ");
        int bookId = Integer.parseInt(sc.nextLine());

        sc.nextLine();

        if (books.containsKey(bookId)) {
            System.out.println("Book ID already exists! ");
            return;
        }

        System.out.println("Enter Book Name: ");
        String bookName = sc.nextLine();

        books.put(bookId, bookName);

        System.out.println("Book Added Successfully: ");
    }

    public static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Library is empty");
            return;
        }

        System.out.println("\n===============================");
        System.out.println("          ALL BOOKS");
        System.out.println("================================");

        for (Integer bookId : books.keySet()) {
            System.out.println("Book ID: " + bookId + " | Book Name: " + books.get(bookId));
        }

        System.out.println("===============================");
    }

    public static void searchBook() {
        System.out.println("Enter Book ID to search: ");
        int bookId = Integer.parseInt(sc.nextLine());

        if (books.containsKey(bookId)) {
            System.out.println("\nBook found!");
            System.out.println("Book ID: " + bookId + " | Book Name: " + books.get(bookId));
        } else {
            System.out.println("Book not found!");
        }
    }

    public static void removeBook() {
        System.out.println("Enter Book ID to remove: ");
        int bookId = sc.nextInt();

        if (books.containsKey(bookId)) {
            String bookName = books.remove(bookId);
            System.out.println("Book removed successfully!" + bookName);
        } else {
            System.out.println("Book not found!");
        }
    }

    public static void firstBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty!");
            return;
        }
        int firstId = books.firstKey();
        System.out.println("\n First Book:");
        System.out.println("Book ID: " + firstId);
        System.out.println("Book Name: " + books.get(firstId));
    }

    public static void lastBook() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty!");
            return;
        }
        int lastId = books.lastKey();
        System.out.println("\n Last Book:");
        System.out.println("Book ID: " + lastId);
        System.out.println("Book Name: " + books.get(lastId));
    }

    public static void booksbefore() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty!");
            return;
        }

        System.out.println("Enter Book ID to find books before it: ");
        int id = Integer.parseInt(sc.nextLine());

        boolean found = false;
        System.out.println("\nBooks before ID " + id + ":");

        for (Integer bookId : books.keySet()) {
            if (bookId < id) {
                found = true;
                System.out.println("Book ID: " + bookId + " | Book Name: " + books.get(bookId));
            }
        }

        if (!found) {
            System.out.println("No books found before ID " + id);
        }
    }

    public static void booksfrom() {
        if (books.isEmpty()) {
            System.out.println("Library is Empty");
            return;
        }
        System.out.println("Enter Book ID: ");
        int id = sc.nextInt();

        TreeMap<Integer, String> result = new TreeMap<>(books.tailMap(id));

        if (books.isEmpty()) {
            System.out.println("No books found from ID: " + id);
            return;
        }
        System.out.println("\n Books from ID: " + id + "onwards");

        for (Integer bookId : result.keySet()) {
            System.out.println(
                    bookId + "→" + result.get(bookId));
        }

    }

    public static void main(String[] args) {
        books.put(106, "Java Programming");
        books.put(101, "Data Structures");
        books.put(102, "Operating Systems");
        books.put(103, "Computer Networks");
        books.put(104, "Database Management");
        books.put(105, "Software Engineering");

        int choice;
        do {
            System.out.println("\n============================");
            System.out.println("       COLLEGE LIBRARY MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. Add Book");
            System.out.println("2. Display All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Remove Book");
            System.out.println("5. Display First Book");
            System.out.println("6. Display Last Book");
            System.out.println("7. Display Books Before Given ID");
            System.out.println("8. Display Books From Given ID");
            System.out.println("9. Exit");

            System.out.println("\n Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    removeBook();
                    break;

                case 5:
                    firstBook();
                    break;

                case 6:
                    lastBook();
                    break;

                case 7:
                    booksbefore();
                    break;

                case 8:
                    booksfrom();
                    break;

                case 9:
                    System.out.println("Thank you");
                    break;

                default:
                    System.out.println("Invalid choice: Please try again.");
            }

        } while (choice != 9);
        sc.close();
    }
}