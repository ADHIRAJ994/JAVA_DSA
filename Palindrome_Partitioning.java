import java.util.*;
public class Palindrome_Partitioning {
    public static List<List<String>> partition(String s){
        List<List<String>> res = new ArrayList<>();
        List<String>path = new ArrayList<>();
        func(0, res, path, s);
        return res;
    }
    public static void func(int idx,List<List<String>>res,List<String>path,String s){
        if(idx==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = idx;i<s.length();i++){
            if(isPalin(s,idx,i)){
                path.add(s.substring(idx, i+1));
                func(idx+1, res, path, s);
                path.remove(path.size()-1);
            }
        }
    }
    public static boolean isPalin(String s,int start,int end){
        while(start<=end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;end--;
        }
         return true;
    }
    public static void main(String[] agrs){
        String s = "adab";
        List<List<String>> res = partition(s);
        for(List<String>list:res){
            System.out.println(list);
        }
        System.out.println();
    }
}
