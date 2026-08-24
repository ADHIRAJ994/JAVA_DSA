import java.util.*;
public class Linked_list_collections {

    public static void main(String args[]){
        LinkedList<String>list = new LinkedList<String>();
        list.addFirst("a");// this and list.add("") is same which adds at the first.
        list.addFirst("is");
        

        list.addFirst("this");
        list.addLast("list");
        // System.out.println(list);
        // System.out.println(list.size());

        for(int i = 0;i<list.size();i++){
            System.out.print(list.get(i)+"->");
        }
        System.out.println("NULL");
        
        list.remove(0);// this and list.removeFirst("") is same which deletes at the first.
        list.removeLast();
        System.out.println(list);
    }
}
