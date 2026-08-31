import java.util.ArrayList;
import java.util.Scanner;

public class DuplicateDemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        ArrayList<String> names= new ArrayList<>();

        System.out.println("How many names do you want to enter?");
        int n=sc.nextInt();
        sc.nextLine();

        for(int i=0;i<n;i++){
            System.out.print("Enter name "+(i+1)+": ");
            String name=sc.nextLine();

            names.add(name);
        }

        System.out.println("Original List: "+names);

        System.out.print("\nEnter name to check for duplicate: ");
        String searchName= sc.nextLine();

        int count=0;

        for(String name:names){
            if(name.equalsIgnoreCase(searchName)){
                count++;
            }
        }

        if(count>1){
            System.out.println(searchName+" is duplicated.");
            System.out.println("It appears "+ count+" times.");
        }
        else{
            System.out.println(searchName+ " is not duplicated.");
        }

        ArrayList<String> uniqueNames= new ArrayList<>();

        for(String name:names){
            if(!uniqueNames.contains(name)){
                uniqueNames.add(name);
            }
        }

        System.out.println("\nUnique Names: "+uniqueNames);

        sc.close();
    }
}
