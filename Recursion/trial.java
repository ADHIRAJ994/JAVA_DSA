import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

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
public static void backtrack(List<String>result,StringBuilder currrent,int open,int close,int n){
    if(open==n&&close==n){
        result.add(currrent.toString());
        return;
    }
    if(open<n){
        currrent.append('(');
        backtrack(result, currrent, open+1, close, n);
        currrent.deleteCharAt(currrent.length()-1);
    }
    if(close<open){
        currrent.append(')');
        backtrack(result, currrent, open, close+1, n);
        currrent.deleteCharAt(currrent.length()-1);
    }
}
public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer>current = new ArrayList<>();
        solve(0,nums,ans,current);
        return ans;
    }
public static void solve(int index,int[]nums,List<List<Integer>> ans,List<Integer>current){
        if(index==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        current.add(nums[index]);
        solve(index+1,nums,ans,current);
        current.remove(current.size()-1);
        solve(index,nums,ans,current);
    }
public List<String>generateParen(int n){
    List<String>result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
}
public static final long MOD = 1_000_000_007L;

    public int countGoodNumbers(long n) {
        long odd = n / 2;
        long even = n / 2 + n % 2;

        return (int) ((pow(5, even) * pow(4, odd)) % MOD);
    }
    public static long pow(long x, long n) {
        long res = 1;

        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % MOD;
            }

            x = (x * x) % MOD;
            n = n / 2;
        }

        return res;
    }
public static void PrintSubsequencesEqualToSumK(int i,List<Integer>ans,int s,int arr[],int sum){
    int n = arr.length;
    if(i==n){
        if(s==sum){
            for(int x:ans){
                System.out.println(x);
            }
            return;
        }
        ans.add(arr[i]);
        s+=arr[i];
        // Pick condition
        PrintSubsequencesEqualToSumK(i+1, ans, s, arr, sum);

        s-=arr[i];
        ans.remove(arr[i]);
        //Not Pick condition
        PrintSubsequencesEqualToSumK(i+1, ans, s, arr, sum);
    }
}
public static List<List<Integer>>CombinationSum(int nums[],int target){
    List<List<Integer>>ans =new ArrayList<>();
    List<Integer>curr = new ArrayList<>();
    findCombi(0,nums,target,ans,curr);
    return ans;
}
public static void findCombi(int index,int[]nums,int target,List<List<Integer>>ans,List<Integer>curr){
    if(index==nums.length){
        if(target==0){
            ans.add(new ArrayList<>(curr));
        }
        return;
    }
    if(nums[index]<=target){
        curr.add(nums[index]);
        findCombi(index, nums, target-nums[index], ans, curr);
        curr.remove(curr.size()-1);
    }
    findCombi(index+1, nums, target, ans, curr);
}
public static void backtrack(String digits,int index,StringBuilder curr,List<String> res,Map<Character,String> digitToLetters){
        if(index==digits.length()){
            res.add(curr.toString());
            return;
        }
        String letters = digitToLetters.get(digits.charAt(index));
        for(char letter:letters.toCharArray()){
            curr.append(letter);
            backtrack(digits,index+1,curr,res,digitToLetters);
            curr.deleteCharAt(curr.length()-1);
        }
    }

public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        if(digits==null||digits.length()==0){
            return res;
        }
        Map<Character,String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits,0,curr,res,digitToLetters);
        return res;
    }
    
public static List<List<String>> partition(String s){
    List<List<String>> res = new ArrayList<>();
    List<String>curr = new ArrayList<>();
    func(0,s,curr,res);
    return res;
}
public static void func(int index,String s,List<String>curr,List<List<String>> res){
    if(index==s.length()){
        res.add(new ArrayList<>(curr));
        return;
    }
    for(int i=index;i<s.length();i++){
        if(isPalin(s,index,i)){
            curr.add(s.substring(index, i+1));
            func(i+1,s,curr,res);
            curr.remove(curr.size()-1);
        }
    }
}
public static boolean isPalin(String s,int start,int end){
    while(start<=end){
        if(s.charAt(start++)!=s.charAt(end--)){
            return false;
        }
    }
    return true;
}

    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        generate(board, 0,res);
        return res;
    }

public static void generate(char[][] board, int row,List<List<String>> res) {
        if (row == board.length) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                list.add(new String(board[i]));
            }
            res.add(list);
            return;
        }
        for (int col = 0; col < board[row].length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                generate(board, row + 1,res);
                board[row][col] = '.'; 
            }
        }
    }
public static boolean isSafe(char[][] board, int row, int col) {
        //top row
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        //left diagonal
        // This approach is standard, you can remember this
        int maxLeft=Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(board[row-i][col-i]=='Q') return false;
        }
        int maxRight=Math.min(row,board.length-1-col);
        for(int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]=='Q') return false;
        }
        return true;
    }
public static List<List<Integer>> combine(int n,int k){
    List<List<Integer>> res = new ArrayList<>();
    List<Integer>curr = new ArrayList<>();
    helper(1,res,curr,n,k);
    return res;
}
public static void helper(int start,List<List<Integer>> res,List<Integer>curr,int n,int k){
    if(curr.size()==k){
        res.add(new ArrayList<>(curr));
        return;
    }
    for(int i = start;i<=n;i++){
        curr.add(i);
        helper(i+1, res, curr, n, k);
        curr.remove(curr.size()-1);
    }
}
// Rat in a Maze Problem - I

// Consider a rat placed at (0, 0) in a square matrix of order N * N. It has to reach the destination at (N - 1, N
// - 1). Find all possible paths that the rat can take to reach from source to destination. The directions in
// which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix
// represents that it is blocked and rat cannot move to it while value 1 at a cell in the matrix represents
// that rat can be travel through it.
// Note: In a path, no cell can be visited more tham one time.

// Example 1:

// Input:
// N = 4
// m[][] = 
// {{1, 0, 0, 0},
// {1, 1, 0, 1},
// {1, 1, 0, 0},
// {0,1,1, 1}}

// Output:
// DDRDRR DRDDRR

public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;

        if (n == 0 || mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];
        StringBuilder path = new StringBuilder();

        // D, L, R, U gives lexicographical order
        dfs(0, 0, mat, visited, path, ans, n);

        return ans;
    }

public static void dfs(int r, int c, int[][] mat,
                     boolean[][] visited, StringBuilder path,
                     ArrayList<String> ans, int n) {

        if (r == n - 1 && c == n - 1) {
            ans.add(path.toString());
            return;
        }

        visited[r][c] = true;

        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < n &&
                mat[nr][nc] == 1 &&
                !visited[nr][nc]) {

                path.append(dir[i]);

                dfs(nr, nc, mat, visited, path, ans, n);

                // Backtrack
                path.deleteCharAt(path.length() - 1);
            }
        }

        visited[r][c] = false;
    }

//Graph Coloring 
// M-Coloring Problem

// Given an undirected graph and an integer M. The task is to determine if the graph can be colored with at
// most M colors such that no two adjacent vertices of the graph are colored with the same coldr. Here
// coloring of a graph means the assignment of colors to all vertices. Print 1 if it is possible to colour
// vertices and 0 otherwise.

// Example 1:

// Input:
// N = 4
// M = 3
// E = 5
// Edges[] = {(1,2),(2,3), (3,4), (4,1), (1,3)}
// Output: 1

// Submissions: 6921 Points: 4
public static boolean isSafe(int node,List<Integer>[]G,int[]color,int n,int col){
    for(int it:G[node]){
        if(color[it]==col) return false;
    }
    return true;
}
public static boolean solve(int node,List<Integer>[]G,int[]color,int n,int m){
    if(node==n) return true;
    for(int i = 1;i<=m;i++){
       if(isSafe(node, G, color, n, i)){
            color[node] = i;
            if(solve(node+1, G, color, n, m)==true)return true;
            color[node] = 0;
        }
    }
    return false;
}
public static boolean graphColoring(List<Integer>[]G,int[]color,int i,int m){
    int n = G.length;
    if(solve(0, G, color, n, m)==true) return true;
    return false;
}
    public static void main(String[] args) {
        int n = 5;
        int arr[] = {2,3,6,7};
        System.out.println();
        // int second_last_term = 0,last_term=1; fibbonaci
        String str = "abc";
        
        HashSet<String> set = new HashSet<>();

        System.out.println(combine(4,2));

    }
}