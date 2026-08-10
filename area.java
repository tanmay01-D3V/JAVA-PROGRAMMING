public class area {
    public static void main(String[] args) {
        double radius = 5.0;
        double area = Math.PI * radius * radius;
        System.out.println("The area of the circle with radius " + radius + " is: " + area);

        double length = 10.0;
        double width = 5.0;
        double rectangleArea = length * width;
        System.out.println("The area of the rectangle with length " + length + " and width " + width + " is: " + rectangleArea);

        double base = 8.0;
        double height = 6.0;
        double triangleArea = 0.5 * base * height;
        System.out.println("The area of the triangle with base " + base + " and height " + height + " is: " + triangleArea);

        double side = 4.0;
        double squareArea = side * side;
        System.out.println("The area of the square with side " + side + " is: " + squareArea);
    }

    
}