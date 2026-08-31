import java.util.*;

public class ArrayListDemo{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<String> cities= new ArrayList<>();

        System.out.print("How many cities do you want to add: ");
        int n= sc.nextInt();
        sc.nextLine();


        //ADD
        for(int i=1;i<=n;i++){
            System.out.print("Enter City "+i+" : ");
            String city=sc.nextLine();
            cities.add(city);
        }
        
        System.out.println("Original List: " + cities);

        //GET
        for(int i=1;i<=n;i++){
            System.out.println("City "+i+" : "+cities.get(i-1));
        }

        //UPDATE
        System.out.print("Enter Index: ");
        int index= sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Change: ");
        String update=sc.nextLine();
        cities.set(index,update);
        System.out.println("Updated List: "+ cities);

        //REMOVE
        System.out.print("Enter City to delete: ");
        String delete=sc.nextLine();
        cities.remove(delete);
        System.out.println("Updated List: "+ cities);

    }
}