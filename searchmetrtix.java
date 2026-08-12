import java.util.Scanner;

public class searchmetrtix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 4 number for the 2x2 metrics: ");
        double[][] matrix = new double[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        System.out.println("The 2x2 matrix is:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println();   
        }

        System.out.print("Enter the number to search for: ");
        double target = sc.nextDouble();

        boolean found = false;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (matrix[i][j] == target) {
                    System.out.println("The number " + target + " is found at position (" + i + ", " + j + ").");
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }

        boolean notFound = !found;
        if (notFound) {
            System.out.println("The number " + target + " is not found in the matrix.");    
        }
    }
}
