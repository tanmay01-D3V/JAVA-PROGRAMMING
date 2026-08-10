import java.util.Scanner;

public class area {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the radius of the circle: ");
        String radiusInput = sc.nextLine();
        double radius = Double.parseDouble(radiusInput);
        System.out.println("The area of the circle with radius " + radius + " is: " + (Math.PI * radius * radius));


        System.out.print("Enter the length of the rectangle: ");
        String lengthInput = sc.nextLine();
        double length = Double.parseDouble(lengthInput);
        System.out.print("Enter the width of the rectangle: ");
        String widthInput = sc.nextLine();
        double width = Double.parseDouble(widthInput);
        System.out.println("The area of the rectangle with length " + length + " and width " + width + " is: " + (length * width));

        System.out.print("Enter the height of the square: ");
        String heightInput = sc.nextLine();
        double height = Double.parseDouble(heightInput);
        System.out.print("Enter the width of the square: ");
        String squareWidthInput = sc.nextLine();
        double squareWidth = Double.parseDouble(squareWidthInput);
        System.out.println("The area of the square with height " + height + " and width " + squareWidth + " is: " + (height * squareWidth));    

    }
}