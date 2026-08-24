import java.util.*;
public class Array_List {
    public static void main(String args[]){
        ArrayList<Integer>list = new ArrayList<>();

        list.add(0);
        list.add(10);
        list.add(5);
        list.add(4);
        
        System.out.println(list);

        // int element = list.get(3);
        // System.out.println(element);
        // list.add(1,4);
        // System.out.println(list);

        // list.set(0, 5);
        // System.out.println(list);

        // list.remove(3);
        // System.out.println(list);

        // System.out.println(list.size());

        // for(int i = 0;i<list.size();i++){
        //     System.out.print(list.get(i));
        // }
        Collections.sort(list);
        System.out.println(list);
    }
}
