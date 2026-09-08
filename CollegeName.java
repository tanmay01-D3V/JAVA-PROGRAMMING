import java.util.TreeMap;

public class CollegeName {
  public static void main(String[] args) {
    TreeMap<Integer, String> books = new TreeMap<>();

    books.put(106,"Java Programming");
    books.put(102,"Data Structures");
    books.put(105,"Operating Systems");
    books.put(101,"Computer Networks");
    books.put(104,"Database Management");
    books.put(103,"Software Engineering");

    
    System.out.println("=====COLLEHE LIBRARY=====");
    System.out.println("All books:");

    for (Integer bookID : books.keySet()){
      System.out.println(bookID +" -> "+ books.get(bookID));
    }

    System.out.println("\nFirst book ID: " + books.firstKey());

    System.out.println("\nLast book ID" + books.lastKey());

    System.out.println("\nBooks before ID 105");

    for (Integer bookID : books.headMap(105).keySet()) {
      System.out.println(bookID + " -> " + books.get(bookID));
    }

    System.out.println("\nBooks from ID 103 onwards: ");

    for (Integer bookID : books.tailMap(103).keySet()){
      System.out.println(bookID + " -> " + books.get(bookID));
    }

    int searchID = 104;

    System.out.println("\nSearching for Book ID: " + searchID);
    if (books.containsKey(searchID)) {
      System.out.println("Book Found!!");
      System.out.println("Book name: " + books.get(searchID));
    }else {
      System.out.println("Book not found with the id: " + searchID + " !!!!");
    }

    System.out.println("\n Books after removal: ");
    for (Integer bookId : books.keySet()){
      System.out.println(bookId + " → " + books.get(bookId));
    }


  }
}
