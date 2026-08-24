import java.util.HashSet;
import java.util.Iterator;

public class Hash_set {
    public static void main(String args[]){
        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(1);
        //System.out.println(set);
        // if(set.contains(5)){
        //     System.out.println("Yes");
        // }else{
        //     System.out.println("No");
        // }
        // set.remove(1);
        // if(set.contains(1)){
        //     System.out.println("Yes");
        // }else{
        //     System.out.println("No");
        // }

        //System.out.println(set.size());

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        
    }
}
