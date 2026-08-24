import java.util.*;
public class Hash_Map {
    public static void main(String args[]){
        HashMap<String,Integer> map = new HashMap<>();
        // Here String is the type of the key and Integer is the type of value.
        
        map.put("India", 120);
        map.put("USA", 30);
        map.put("China", 150);

        // System.out.println(map);

        // map.put("China", 30);
        // System.out.println(map);
        // if(map.containsKey("England")){
        //     System.out.println("Yes");
        // }else{
        //     System.out.println("No");
        // }

        // System.out.println(map.get("China"));
        // System.out.println(map.get("Indonesia")); 
        // Will give null if not present.

        // for(Map.Entry<String,Integer>e:map.entrySet()){
        //     System.out.println(e.getKey());
        //     System.out.println(e.getValue());
        // }

        // The above loop gives all the contents in the HashMap.

        // map.remove("China");
        // System.out.println(map);

        
    }
}
