import java.util.Deque;
import java.util.LinkedList;

public class Deques {
    public static void main(String args[]){
        Deque<Integer> queue = new LinkedList<>();
        queue.addFirst(1);
        queue.addFirst(2);
        queue.addFirst(3);
        queue.addFirst(7);
        queue.addFirst(6);
        queue.addFirst(5);

        queue.addLast(0);
        System.out.println(queue.getLast());
        System.out.println(queue);
    }
}
