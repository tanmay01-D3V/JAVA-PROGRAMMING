import java.util.HashMap;
import java.util.Scanner;

@SuppressWarnings("resource")
public class ShoppingCartMap {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> cart = new HashMap<>();

        int choice;

        do {
            System.out.println("\n=========SHOPPING CART==========");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. View Cart");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter product name: ");
                    String product = sc.nextLine();

                    System.out.println("Enter Quantity: ");
                    int Quantity = sc.nextInt();

                    if (cart.containsKey(product)) {
                        int oldQuantity = cart.get(product);

                        cart.put(product, oldQuantity + Quantity);

                        System.out.println("Product Quantity updated! ");

                    } else {
                        cart.put(product, Quantity);

                        System.out.println("Product added successfully!");
                    }
                    break;

                case 2:
                    System.out.println("Enter product name: ");
                    product = sc.nextLine();

                    if (cart.containsKey(product)) {
                        System.out.println("Enter new Quantity: ");
                        Quantity = sc.nextInt();

                        cart.put(product, Quantity);

                        System.out.println("Quantity updated successfully!");

                    } else {
                        System.out.println("Product not found! ");
                    }
                    break;

                case 3:
                    System.out.println("Enter the product name: ");
                    product = sc.nextLine();

                    if (cart.containsKey(product)) {
                        cart.remove(product);

                        System.out.println("Product Removed Successfully!");
                    } else {
                        System.out.println("Product not found!");
                    }
                    break;

                case 4:
                    System.out.println("\n======Cart=======");
                    if (cart.isEmpty()) {
                        System.out.println("Cart is Empty.");
                    } else {
                        for (String item : cart.keySet()) {
                            System.out.println(item + " " + cart.get(item));
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank you for shopping with us!");
                    break;

            }

        } while (choice != 5);
    }
}
