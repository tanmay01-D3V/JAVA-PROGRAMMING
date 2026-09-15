import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("resource")
public class CharacterFrequency {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            HashMap<Character, Integer> frequency = new HashMap<>();

            System.out.println("Enter a String: ");
            String text = sc.nextLine();

            for (char ch : text.toCharArray()) {
                if (frequency.containsKey(ch)) {
                    frequency.put(ch, frequency.get(ch) + 1);
                } else {
                    frequency.put(ch, 1);
                }
            }

            System.out.println("\nCharacter Frequency: ");

            for (Character ch : frequency.keySet()) {
                System.out.println(ch + "→" + frequency.get(ch));
            }
        }
    }
}
