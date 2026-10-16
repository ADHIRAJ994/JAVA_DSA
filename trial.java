import java.util.*;
public class trial {
    public static void simpleSieve(int limit){
        boolean[] prime = new boolean[limit+1];
        for(int i = 2;i<=limit;i++){
            prime[i] =true;
        }
        for(int p = 2;p*p<=limit;p++){
            if(prime[p]==true){
                for(int i = p*p;i<=limit;i+=p){
                    prime[i] = false;
                }
            }
        }
        for (int p = 2; p <= limit; p++) {

                if (prime[p] == true) {

                    System.out.print(p + " ");

                }
        }
}
public static void SegSieve(int l,int h){
    boolean[]prime = new boolean[h+1];

    for(int p = 2;p*p<=h;p++){
        int sm = (l/p)*p;
        if(sm<l) sm+=p;

        for(int i = sm;i<=h;i+=p){
            prime[i] = true;
        }
    }
    for(int p = l;p<=h;p++){
        if(prime[p]==false){
            System.out.print(p+" ");
        }
    }
}
public static int EulersTotient (int N){
int ans = N;
    for (int i=2; i*i <= N; i++) {

        if (N % i == 0) {

            ans = ans - ans/i;

        }

    while (N % i == 0) {

        N = N/i;

    }
}
    if (N > 1)
       ans = ans - ans/N;
    return ans;
}

public static boolean isStrobogrammatic(String num) {
    int i = 0;
    int j = num.length() - 1;

    while (i <= j) {
        char a = num.charAt(i);
        char b = num.charAt(j);

        if (!((a == '0' && b == '0') ||
              (a == '1' && b == '1') ||
              (a == '8' && b == '8') ||
              (a == '6' && b == '9') ||
              (a == '9' && b == '6'))) {
            return false;
        }

        i++;
        j--;
    }

    return true;
}
public static int CRT(int[] num, int[] rem) {
    int x = 1;

    while (true) {
        boolean found = true;

        for (int i = 0; i < num.length; i++) {
            if (x % num[i] != rem[i]) {
                found = false;
                break;
            }
        }

        if (found)
            return x;

        x++;
    }
}
public static int toggleSwitch(int n) {
    int count = 0;

    for (int i = 1; i * i <= n; i++) {
        count++;
    }

    return count;
}
public static int aliceAppleTree(int apple) {
    int cnt = 0;
    int sum = 0;

    while (sum < apple) {
        cnt++;
        sum += 12 * cnt * cnt;
    }

    return 8 * cnt;
}
public static boolean binaryPalindrome(int n) {
    String s = Integer.toBinaryString(n);

    int i = 0;
    int j = s.length() - 1;

    while (i < j) {
        if (s.charAt(i) != s.charAt(j))
            return false;

        i++;
        j--;
    }

    return true;
}
public static void MaxPalinDromeStringlen(String s){
    int []freq = new int[26];
    for(char ch:s.toCharArray()){
        freq[ch-'a']++;
    }
    StringBuilder left = new StringBuilder();
    for(int i = 0;i<26;i++){
        int pairs = freq[i]/2;
        for(int j = 0;j<pairs;j++){
            left.append((char)('a'+i));
        }
    }
    char center = 0;
    for(int i = 0;i<26;i++){
        if(freq[i]%2==1){
            center = (char)('a'+i);
            break;
        }
    }
    String right = new StringBuilder(left).reverse().toString();
    String res = left.toString()+(center==0?"":String.valueOf(center))+right;
    System.out.println(res.length());
    System.out.println(res);
}
public static int MinimumDifferencePair(int[]arr){
    Arrays.sort(arr);
    int min = Integer.MAX_VALUE;
    for(int i = 1;i<arr.length;i++){
        int diff = arr[i]-arr[i-1];
        min = Math.min(diff,min);
    }
    return  min;

}
public static int LongestSubarrayWithAtMostKZeroes(int arr[],int k){
    int n = arr.length;
    int left = 0,right = 0;
    int ZeroCount = 0;
    int MaxLen = 0;
    for(right = 0;right<n;right++){
        if(arr[right]==0) ZeroCount++;
        while(ZeroCount>k){
            if(arr[left]==0){
                ZeroCount--;
            }
            left++;
        }
        MaxLen = Math.max(MaxLen,right-left+1);
    }
    return MaxLen;
}
public static boolean isPalin(String s,int left,int right){
    while(left<right){
        if(s.charAt(left)!=s.charAt(right)){
            return false;
        }
        left++;right--;
    }
    return true;
}
public static boolean PartialPalin(String s){
    int left = 0;
    int right = s.length()-1;
    while(left<right){
        if(s.charAt(left)==s.charAt(right)){
            left++;right--;
        }else{
            return isPalin(s, left+1, right)||isPalin(s, left, right-1);
        }
    }
    return true;
}
public static int multiply(int m, int q) {

        int A = 0;
        int M = m;
        int Q = q;
        int Q1 = 0;

        // 32-bit integers
        for (int i = 0; i < 32; i++) {

            int Q0 = Q & 1;

            // 01 -> A = A + M
            if (Q0 == 0 && Q1 == 1) {
                A = A + M;
            }

            // 10 -> A = A - M
            else if (Q0 == 1 && Q1 == 0) {
                A = A - M;
            }

            // Arithmetic right shift of A and Q
            Q1 = Q & 1;
            Q = (Q >>> 1) | ((A & 1) << 31);
            A = A >> 1;
        }

        return Q;
    }

    public static int gcd(int a,int b){
        while(b!=0){
            int temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public static long karatsuba(long x,long y){
        if(x<10||y<10){
            return x*y;
        }
        int n = Math.max(Long.toString(x).length(),
                         Long.toString(y).length());
        int half = n/2;
        long power = (long)Math.pow(10,half);

        long a = x/power;
        long b = x%power;

        long c = y/power;
        long d = y%power;

        long ac  = karatsuba(a, c);
        long bd  = karatsuba(b, d);
        long abcd = karatsuba(a+b, c+d);

        long middle = abcd-ac-bd;
        return ac*power*power+middle*power+bd;
    }
    public static void main(String[] args){
        int arr[] = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(multiply(3,5));
    }
}
