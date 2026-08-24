import java.util.ArrayList;

class subsequences{
    public static void fun(int i,int arr[],ArrayList<Integer>list){
        int n = arr.length;
        if(i>=n){
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        fun(i+1, arr, list);
        list.remove(list.size()-1);
        fun(i+1, arr, list);
    }
    public static void main(String[] args){
        int arr[] = {3,1,2};
        ArrayList<Integer> list = new ArrayList<>();
        fun(0, arr, list);
    }
}