import java.util.Arrays;
import java.util.HashSet;

public class HashSetOperations {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Apple"); // ignored (duplicate)
        set.add("Banana");

        System.out.println(set.contains("Apple")); // true
        set.remove("Banana");
        set.retainAll(Arrays.asList("Apple", "Orange")); // keeps only "Apple"

        String[] arr = set.toArray(String[]::new);
        System.out.println(Arrays.toString(arr));
    }
}
