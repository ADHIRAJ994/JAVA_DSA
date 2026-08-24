import java.util.*;

public class Menu_Driven_Deque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> queue = new LinkedList<>();
        int choice;
        while(true){
            System.out.println("\n--- VIT-AP Bank Queue ---");
            System.out.println("1. Student joins at end");
            System.out.println("2. Student served and leaves from front");
            System.out.println("3. Student leaves from end");
            System.out.println("4. Returning student joins at front");
            System.out.println("5. Display queue");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            if(choice==0){
                System.out.println("Exiting......");
                break;
            }
            if(choice==1){
                System.out.println("Enter student name: ");
                String s1 = sc.nextLine();
                queue.addLast(s1);
                System.out.println(s1+" joined at he end of the line.");
            }
            else if(choice==2){
                if(queue.isEmpty()){
                    System.out.println("The Queue is empty");
                }else{
                    String served = queue.removeFirst();
                    System.out.println(served+" served and left from front.");
                }
            }else if(choice==3){
                if(queue.isEmpty()){
                    System.out.println("The Queue is empty");
                }else{
                    String end = queue.removeLast();
                    System.out.println(end+" leaves from the last.");
                }
            }else if(choice==4){
                System.out.println("Enter returning studentt name: ");
                String s2 = sc.nextLine();
                queue.addFirst(s2);
                System.out.println(s2+" joined at the first of the line.");
            }else if(choice==5){
                System.out.println("Cureent Queue"+queue);
            }else{
                System.out.println("Invalid Choice");
            }
        }

    }
}
