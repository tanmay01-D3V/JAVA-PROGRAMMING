
import java.io.File;
import java.util.Scanner;

public class Searchword {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter word to search:");
        String search = input.nextLine();

        boolean found = false;

        try {
            File file = new File("Data.txt");
            file.createNewFile();
            Scanner sc = new Scanner(file);
            int lineNumber = 0;

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lineNumber++;

                if (line.toLowerCase().contains(search.toLowerCase())) {
                    System.out.println("Found on line " + lineNumber + ": " + line);
                    found = true;
                }
            }

            sc.close();
            if (!found) {
                System.out.println("Word not found.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        input.close();
    }
}
