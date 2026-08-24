import java.util.*;
public class Arrays_ {
    public static int removeDuplicates(int arr[]){
    int j = 1;
    for(int i = 1;i<arr.length;i++){
        if(arr[i]!=arr[i-1]){
            arr[j] = arr[i];
            j++;
        }
    }
    return j;
}

public static void rotateArrayByKPlaces(int nums[],int k){
    int n = nums.length;
    k = k%n;
    reverseArray(nums,0,n-1);
    reverseArray(nums,0,k-1);
    reverseArray(nums,k,n-1);

}
public static void reverseArray(int nums[],int start,int end){
    while(start<end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
public static void moveAllZerosToEnd(int arr[]){
    int j = 0;
    for(int i = 0;i<arr.length;i++){
        if(arr[i]!=0){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j++;
        }
    }
}
public static int MaxConsecutiveOnes(int arr[]){
    int maxlen = 0,res=0;
    for(int i = 0;i<arr.length;i++){
        if(arr[i]==1){
            maxlen++;
        }else{
            maxlen = 0;
        }
        res = Math.max(res,maxlen);
    }
    return res;
}
public static int SingleNumber(int nums[]){
    HashMap<Integer,Integer>mpp = new HashMap<>();
    for(int num:nums){
        mpp.put(num,mpp.getOrDefault(num,0)+1);
    }
    for(int num:nums){
        if(mpp.get(num)==1){
            return num;
        }
    }
    return -1;
}
public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>mpp = new HashMap<>();
        for(int i = 0;i<nums.length;i++){

            int comp = target-nums[i];
            if(mpp.containsKey(comp)){
                return new int[]{mpp.get(comp),i};
            }
            mpp.put(nums[i],i);
        }
        return new int[] {};
}
public static void SortArrayof012Inplace__BIG_O_2N_(int arr[]){
    int cnt0=0,cnt1=0,cnt2=0;
    for(int i = 0;i<arr.length;i++){
        if(arr[i]==0) cnt0++;
        else if(arr[i]==1) cnt1++;
        else cnt2++;
    }
    for(int i = 0;i<cnt0;i++) arr[i] = 0;
    for(int i = cnt0;i<cnt0+cnt1;i++) arr[i] = 1;
    for(int i = cnt0+cnt1;i<cnt0+cnt1+cnt2;i++) arr[i] = 2;
}
public static void SortArrayof012Inplace__Optimal(int nums[]){
    int low = 0;
    int mid = 0;
    int high = nums.length - 1;

    while (mid <= high) {

        if (nums[mid] == 0) {

            int temp = nums[low];
            nums[low] = nums[mid];
            nums[mid] = temp;

            low++;
            mid++;
        }
        else if (nums[mid] == 1) {

            mid++;
        }
        else {

            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;

            high--;
        }
    }
}
public static int MajorityElement(int arr[]){
    int cnt = 0;
    int el = 0;
    for(int i = 0;i<arr.length;i++){
        if(cnt==0){
            cnt=1;
            el = arr[i];
        }else if(arr[i]==el){
            cnt++;
        }else{
            cnt--;
        }
    }
    return el;
}
public static int maxProfit(int prices[]){
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    for(int price:prices){
        minPrice = Math.min(minPrice,price);
        int profit = price-minPrice;
        maxProfit = Math.max(maxProfit,profit);
    }
    return maxProfit;
}
public static int[] ReaarangeArrays(int nums[]){
    int n = nums.length;
    int ans[] = new int[n];
    int pos = 0,neg = 1;
    for(int i = 0;i<n;i++){
        if(nums[i]<0){
            ans[neg] = nums[i];
            neg+=2;
        }else{
            ans[pos] = nums[i];
            pos+=2;
        }
    }
    return ans;
}
public static int LongestCnsecutiveSequence(int nums[]){
     if(nums.length==0) return 0;

        HashSet<Integer>set = new HashSet<>();

        for(int num:nums){
            set.add(num);
        }
        int longest = 0;

        for(int num:set){
            if(!set.contains(num-1)){
                int currnum = num;
                int currentlen = 1;

                while(set.contains(currnum+1)){
                    currnum++;
                    currentlen++;
                }
                longest = Math.max(longest,currentlen);
            }
        }
        return longest;
}
public static void setZeroes(int[][] matrix) {

    int m = matrix.length;
    int n = matrix[0].length;

    boolean firstRow = false;
    boolean firstCol = false;

    // Check if first row contains zero
    for (int j = 0; j < n; j++) {
        if (matrix[0][j] == 0) {
            firstRow = true;
        }
    }

    // Check if first column contains zero
    for (int i = 0; i < m; i++) {
        if (matrix[i][0] == 0) {
            firstCol = true;
        }
    }

    // Use first row and first column as markers
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {

            if (matrix[i][j] == 0) {
                matrix[i][0] = 0;
                matrix[0][j] = 0;
            }
        }
    }

    // Set marked rows to zero
    for (int i = 1; i < m; i++) {
        if (matrix[i][0] == 0) {

            for (int j = 1; j < n; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    // Set marked columns to zero
    for (int j = 1; j < n; j++) {
        if (matrix[0][j] == 0) {

            for (int i = 1; i < m; i++) {
                matrix[i][j] = 0;
            }
        }
    }

    // Finally handle first row
    if (firstRow) {
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 0;
        }
    }

    // Finally handle first column
    if (firstCol) {
        for (int i = 0; i < m; i++) {
            matrix[i][0] = 0;
        }
    }
}
public static void rotateMatrix(int matrix[][]){
    int n = matrix.length;
    for(int i = 0;i<n-1;i++){
        for(int j = i+1;j<n;j++){
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }
    for(int i = 0;i<n;i++){
        reverseArray(matrix[i],0,n-1);
    }
}
    public static void main(String[] args){
        int arr[] = {7,1,5,3,6,4};
        int k = 3;
        int x[] = ReaarangeArrays(arr);
        int matrix[][] =  {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(matrix);
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                System.out.println(matrix[i][j]);
            }
        }
        // SortArrayof012Inplace__Optimal(arr);
        // System.out.println();
        // for(int i = 0;i<arr.length;i++){
        //     System.out.print(arr[i]+" ");
        // }
        
    }
}
