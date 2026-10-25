import java.util.*;
public class java_strings {
    public static String removeOuterParenthesis(String s){
    StringBuilder result = new StringBuilder();
    int depth = 0;

    for(char c:s.toCharArray()){
        if(c=='('){
            if(depth>0){
                result.append(c);
            }
            depth++;
        }else{
            depth--;
            if(depth>0){
                result.append(c);
            }
        }
    }
    return result.toString();
}
public static int expand(String s,int left,int right){// used in longestPalindrome
    while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
        left--;right++;
    }
    return right-left-1;
}
public static String longestPalindrome(String s){
    int start = 0;
    int maxlen = 0;

    for(int i = 0;i<s.length();i++){
        int oddlength = expand(s, i, i);

        int evenLength = expand(s, i, i+1);

        int length = Math.max(oddlength,evenLength);

        if(length>maxlen){
            maxlen = length;
            start = i-(length-1)/2;
        }
    }
    return s.substring(start, start+maxlen);
}
public static int beautySum(String s){
    int n = s.length();
    int answer = 0;

    for(int i = 0;i<n;i++){
        int[]freq = new int[26];

        for(int j = i;j<n;j++){
            freq[s.charAt(j)-'a']++;

            int maxFreq = 0;
            int minFreq = Integer.MAX_VALUE;

            for(int k = 0;k<26;k++){
                if(freq[k]>0){
                    maxFreq = Math.max(maxFreq,freq[k]);
                    minFreq = Math.min(minFreq,freq[k]);
                }
            }
            answer+=maxFreq-minFreq;
        }
    }
    return answer;
}

    public static void main(String[] args){
        String s = "(()())(())";
        System.out.println(removeOuterParenthesis(s));
    }
}
