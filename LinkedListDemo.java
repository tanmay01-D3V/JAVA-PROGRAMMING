import java.util.LinkedList;
import java.util.Scanner;

public class LinkedListDemo {
    public static void main(String[] args) {
        Scanner sc =new Scanner (System.in);
        
        LinkedList<String> playList = new LinkedList<>();

        System.out.println("1. Give the playlist");
        System.out.println("2. Add a song in the start");
        System.out.println("3. Add a song in the end");
        System.out.println("4. Check if the song exists");
        System.out.println("5. Remove a song from playlist");

        System.out.print("Enter your choice : ");
        int choice = sc.nextInt();


        switch (choice) {
            case 1 -> {
                System.out.print("Enter the no. songs  : ");
                int no = sc.nextInt();
                sc.nextLine();

                for(int i=0; i<no ; i++){
                System.out.print("Song "+(i+1 )+" : ");
                String song = sc.nextLine();

                playList.add(song);
                }
                System.out.println("Original List : "+playList);
            }

            case 2 -> {

                System.out.print("song you want to add at first :");
                String firstadd = sc.nextLine();
                playList.addFirst(firstadd);
                System.out.println("New List : "+playList);
            }

            case 3 -> {

                System.out.print("song you want to add at end: " );
                String lastAdd = sc.nextLine();
                playList.addLast(lastAdd);
                System.out.println("New List : "+playList);
            }

            case 4 -> {
                System.out.print("Which song you want to check: ");
                String Checkcity= sc.nextLine();
                if(playList.contains(Checkcity)){
                    System.out.println(" "+Checkcity+" exits in the list ");
                }
                else{
                    System.out.println("Does not exists");
                }
            }

            case 5 -> {

                System.err.println("Which song you want to remove : ");
                String songdelete= sc.nextLine();
                playList.remove(songdelete);
                System.out.println("New List : "+playList);
            }


            default -> {
                System.out.println("Input no valid");
            }


        }    
    }
}