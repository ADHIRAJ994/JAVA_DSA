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
    public static void main(String[] args){
        System.out.println(binaryPalindrome(232));
    }
}
