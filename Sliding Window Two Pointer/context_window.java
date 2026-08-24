import java.util.*;
public class context_window{
    public static void maxLenOfSubarrayEqualToSum(int arr[],int k){
        int l = 0,r=0;
        int sum = 0;
        int maxLen = 0;
        int n = arr.length;

        while(r<n){
            sum = sum+arr[r];

            if(sum>k){
            sum = sum-arr[l];
            l+=1;
            }
            if(sum<=k){
            maxLen = Math.max(maxLen, r-l+1);
            }
            r+=1;
        }
        System.out.println(maxLen);
    }
    public static int MaximumPointsYouCanPoint(int arr[],int k){
        int n = arr.length;
        int lsum = 0,rsum=0,maxSum=0;
        for(int i =0;i<k;i++){
            lsum = lsum+arr[i];
        }
        maxSum = lsum;
        int rightIndex = n-1;
        for(int i = k-1;i>=0;i--){
            lsum = lsum-arr[i];
            rsum = rsum+arr[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum,lsum+rsum);
        }
        return maxSum;
    }
    public static int LongestSubtringWithoutRepeatingChars(String s){
        HashMap<Character,Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);

            if(map.containsKey(ch)&& map.get(ch)>=left){
                left = map.get(ch)+1;
            }
            map.put(ch,right);

            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
    public static int MaxConsecutiveOnes3(int arr[],int k){
        int zeros = 0;
        int maxLen = 0;
        int l = 0;

        for (int r = 0; r < arr.length; r++) {

            if (arr[r] == 0)
                zeros++;

            while (zeros > k) {
                if (arr[l] == 0)
                    zeros--;
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }
        return maxLen;
    }
    public static int findmaxConsecutiveOnes(int nums[]){
        int curr = 0,res=0;
        for(int num:nums){
            if(num==1){
                curr++;
            }else{
                curr=0;
            }
            res = Math.max(curr, res);
        }
        return res;
    }
    public static int fruitsIntoBasket_bruteForce(int arr[]){ // max len sub-array with atmost 2 types of numbers
        int n = arr.length;
        int maxlen = 0;
        for(int i = 0;i<n;i++){
            Set<Integer>st = new HashSet<>();
            for(int j = i;j<n;j++){
                st.add(arr[i]);
                if(st.size()<=2){
                    maxlen = Math.max(maxlen,j-i+1);
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }
    public static int fruitIntoBasket_Optimal(int arr[]) {
    int l = 0, r = 0;
    int maxLen = 0;

    Map<Integer, Integer> mpp = new HashMap<>();

    while (r < arr.length) {

        // Add current fruit
        mpp.put(arr[r], mpp.getOrDefault(arr[r], 0) + 1);

        // Shrink window if more than 2 fruit types
        while (mpp.size() > 2) {

            mpp.put(arr[l], mpp.get(arr[l]) - 1);

            if (mpp.get(arr[l]) == 0) {
                mpp.remove(arr[l]);
            }

            l++;
        }

        // Update answer
        maxLen = Math.max(maxLen, r - l + 1);

        r++;
    }

    return maxLen;
}
public static int longestSubstringwithAtmostKdisticntChars(String s,int k){
    int l=0,r=0;
    int maxlen = 0;
    if (k == 0) return 0;
    HashMap<Character,Integer> mpp = new HashMap<>();
    while(r<s.length()){
        mpp.put(s.charAt(r),mpp.getOrDefault(s.charAt(r), 0)+1);

        if(mpp.size()>k){
            mpp.put(s.charAt(l),mpp.get(s.charAt(l))-1);

            if(mpp.get(s.charAt(l))==0){
                mpp.remove(s.charAt(l));
            }
            l++;
        }
        maxlen = Math.max(maxlen,r-l+1);
        r++;
    }
    return maxlen;
}
public static int LongestRepeatingCharacterReplacement(String s, int k) {

    // Stores the frequency of each character in the current window
    HashMap<Character, Integer> mpp = new HashMap<>();

    // Left and right pointers of the sliding window
    int l = 0, r = 0;

    // Stores the highest frequency of a single character
    // seen in the current (or previous) valid window
    int maxFreq = 0;

    // Stores the answer
    int maxLen = 0;

    // Expand the window by moving the right pointer
    while (r < s.length()) {

        // Current character entering the window
        char ch = s.charAt(r);

        // Increase its frequency in the map
        mpp.put(ch, mpp.getOrDefault(ch, 0) + 1);

        // Update the maximum frequency if needed
        // Example:
        // Window = "AABA"
        // A = 3, B = 1
        // maxFreq = 3
        maxFreq = Math.max(maxFreq, mpp.get(ch));

        // Window size = (r - l + 1)
        // Characters to replace = Window Size - maxFreq
        //
        // If replacements required are greater than k,
        // the current window is invalid.
        while ((r - l + 1) - maxFreq > k) {

            // Character leaving the window
            char left = s.charAt(l);

            // Decrease its frequency
            mpp.put(left, mpp.get(left) - 1);

            // Remove the character completely if its frequency becomes 0
            if (mpp.get(left) == 0) {
                mpp.remove(left);
            }

            // Shrink the window from the left
            l++;
        }

        // At this point the window is valid.
        // Update the maximum window length.
        maxLen = Math.max(maxLen, r - l + 1);

        // Expand the window by moving right
        r++;
    }

    // Return the length of the longest valid window
    return maxLen;
}
public static int binarySubarrayWithSumAtmostEqual(int arr[],int goal){
    // No subarray can have a negative sum
    // because the array contains only 0s and 1s.
    if (goal < 0)
        return 0;

    int l = 0, r = 0;
    int sum = 0;
    int cnt = 0;

    while (r < arr.length) {

        // Expand the window
        sum += arr[r];

        // Shrink until the window becomes valid
        while (sum > goal) {
            sum -= arr[l];
            l++;
        }

        // Every subarray ending at r and starting
        // between l and r is valid.
        cnt += (r - l + 1);

        r++;
    }
    return cnt;
}
// Returns the number of subarrays having exactly k odd numbers.
public static int numberOfNiceSubarrays(int arr[], int k) {

    // Exactly(k) = AtMost(k) - AtMost(k-1)
    return atMostOdd(arr, k) - atMostOdd(arr, k - 1);
}

// Returns the number of subarrays having at most k odd numbers.
public static int atMostOdd(int arr[], int k) {

    // If k becomes negative,
    // no valid subarray can exist.
    if (k < 0)
        return 0;

    // l -> Left pointer
    // r -> Right pointer
    int l = 0, r = 0;

    // Stores the number of odd elements
    // inside the current window.
    int oddCount = 0;

    // Stores the total number of valid subarrays.
    int cnt = 0;

    // Expand the window
    while (r < arr.length) {

        // If arr[r] is odd,
        // (arr[r] % 2) = 1
        // Otherwise = 0
        oddCount += arr[r] % 2;

        // If the window has more than k odd numbers,
        // shrink it from the left.
        while (oddCount > k) {

            // Remove the contribution of arr[l]
            oddCount -= arr[l] % 2;

            l++;
        }

        // Now the window contains at most k odd numbers.
        //
        // Every subarray ending at r
        // and starting anywhere between l and r
        // is valid.
        cnt += (r - l + 1);

        // Expand the window
        r++;
    }

    return cnt;
}
public static int SubarraysWitKDifferentIntegers(int arr[],int k){
    return SubarraysWithAtmostKDifferentIntegers(arr, k) - SubarraysWithAtmostKDifferentIntegers(arr,k-1);
}
public static int SubarraysWithAtmostKDifferentIntegers(int arr[],int k){
    HashMap<Integer,Integer> mpp = new HashMap<>();
    if(k<0)return 0;
    int l=0,r=0,cnt=0;
    while(r<arr.length){
        mpp.put(arr[r],mpp.getOrDefault(arr[r], 0)+1);

        while(mpp.size()>k){

            mpp.put(arr[l],mpp.get(arr[l])-1);

            if(mpp.get(arr[l])==0){
                mpp.remove(arr[l]);
            }
            l++;
        }
        cnt+=(r-l+1);
        r++;
    }
    return cnt;
}
public static String MinimumWindowSubstring(String s,String t){
    // If t is longer than s,
    // it is impossible to find a valid window.
    if(t.length()>s.length()) return " ";

    return " ";
}
public static int FrequencyOfTheMostFrequentElement(int arr[],int k){
    Arrays.sort(arr);
    int left = 0;
    long sum = 0;
    int maxFreq = 0;

    for(int right = 0;right<arr.length;right++){
        sum+=arr[right];

        while((long)arr[right]*(right-left+1)-sum>k){ // (right-left+1) is the length of the window.
            sum-=arr[left];
            left++;
        }
        maxFreq = Math.max(maxFreq,right-left+1);
    }
    return maxFreq;
}
public static boolean isPalindrome(String s){
    int left = 0;
    int right = s.length()-1;
    while(left<right){
        while(left<right&&!Character.isLetterOrDigit(s.charAt(left))){
            left++;
        }
        while(left<right&&!Character.isLetterOrDigit(s.charAt(right))){
            right--;
        }

        if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))){
            return false;
        }
        left++;
        right--;
    }
    return true;
}
    public static void main(String[] args) {
        int arr[] = {1,1,2};
        String s = "ABAB";
        int k = 2;
        boolean point = isPalindrome(s);
        System.out.println(point);
    }
}