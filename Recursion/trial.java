import java.util.HashSet;

public class trial{
    public static int Factorial(int n){
        if(n==1||n==0){
            return 1;
        }

        int fact = n*Factorial(n-1);
        return fact;
    }

    public static int fibbonaci(int n){

        if(n<=1){
            return n;
        }
        return fibbonaci(n-1)+fibbonaci(n-2);

    }
    public static int powerX(int x,int n){
        if(n==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int ans = x*powerX(x, n-1);
        return ans;
    }
    public static int sumA(int arr[],int n){
        if(n==0){
            return 0;
        }
        return arr[n-1]+sumA(arr, n-1);
        
    }
    public static int findMax(int arr[],int n){
        if(n==1){
            return arr[0];
        }
        return Math.max(arr[n-1],findMax(arr, n-1));
    }
    public static boolean isSorted(int arr[],int idx){
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]<arr[idx+1]){
            return isSorted(arr, idx+1);
        }else{
            return false;
        }
    }
    public static void reverseString(String str,int idx){
        if(idx==0){
            System.out.print(str.charAt(idx));
            return;
        }
        System.out.print(str.charAt(idx));
        reverseString(str, idx-1);
    }
    // occurance of characters
    public static int first = -1;
    public static int last = -1;

    public static void findOcuurence(String str,int idx,char element){
        if(idx==str.length()){
            System.out.println(first);
            System.out.println(last);
            return;
        }
        char currChar = str.charAt(idx);
        if(currChar==element){
            if(first==-1){
                first = idx;
            }else{
                last = idx;
            }
        }
        findOcuurence(str, idx+1, element);
    }

    // Move all chars to the end
     public static void movAllChars(String str,int idx,int count,String newString){
        if(idx==str.length()){
            for(int i = 0;i<count;i++){
                newString+='x';
            }
            System.out.println(newString);
            return;
        }
        char currchar = str.charAt(idx);
        if(currchar=='x'){
            count++;
            movAllChars(str, idx+1, count, newString);
        }else{
            newString+=currchar;
            movAllChars(str, idx+1, count, newString);
        }
     }
     // Remove duplicates
     public static boolean map[] = new boolean[26];

     public static void removeDuplicates(String str,int idx,String newString){

        if(idx==str.length()){
            System.out.println(newString);
            return;
        }
        char cuurchar = str.charAt(idx);
        if(map[cuurchar-'a']==true){
            removeDuplicates(str, idx+1, newString);
        }else{
            newString+=cuurchar;
            map[cuurchar-'a'] = true;
            removeDuplicates(str, idx+1, newString);
        }
     }

    // Subsequences of string ( also contain unique Subsequences of a string)
    public static void subsequences(String str,int idx,String newString,HashSet<String> set){
        if(idx==str.length()){
            if(set.contains(newString)){
                return;
            }else{
                System.out.println(newString);
                set.add(newString);
                return;
            }
        }
        char currChar = str.charAt(idx);

        // to be
        subsequences(str, idx+1, newString+currChar,set);

        // or not to be
        subsequences(str, idx+1, newString,set);
    }
   
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {1,6,3};
        System.out.println();
        // int second_last_term = 0,last_term=1; fibbonaci
        String str = "aaa";
        
        HashSet<String> set = new HashSet<>();

        subsequences(str,0 ,"", set);

    }
}