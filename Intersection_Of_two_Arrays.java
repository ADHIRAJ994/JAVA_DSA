import java.util.ArrayList;
import java.util.HashMap;

public class Intersection_Of_two_Arrays {
    public static ArrayList<Integer> Uninon(int arr1[],int arr2[]){
    HashMap<Integer,Integer> map = new HashMap<>();
    ArrayList<Integer> list = new ArrayList<>();
    int n1 = arr1.length;
    int n2 = arr2.length;
    for(int i = 0;i<n1;i++){
        map.put(arr1[i], 1);
    }
    for(int j = 0;j<n2;j++){
        if(map.containsKey(arr2[j])){
            map.put(arr2[j], map.get(arr2[j])+1);
        }else{
            map.put(arr2[j], 1);
        }
    }
        for( int key:map.keySet()){
            if(map.get(key)>=2){
                list.add(key);
            }
        }
        return list;
   }
    public static void main(String args[]){
        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println(Uninon(arr1, arr2));
    }
}
