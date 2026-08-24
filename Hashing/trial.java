import java.util.HashMap;
import java.util.HashSet;

public class trial{
    public static int[] twoSum(int[] arr,int target){
        HashMap<Integer,Integer>mpp = new HashMap<>();

        for(int i = 0;i<arr.length;i++){
            int compliment = target-arr[i];

            if(mpp.containsKey(compliment)){
                return new int[]{mpp.get(compliment),i};
            }
            mpp.put(arr[i],i);
        }
        return new int[] {};
    }
    public static int LongestConsecutive(int nums[]){
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
    public static int NumberOfSubarraysWithSumK(int arr[],int k){
        HashMap<Integer,Integer>mpp = new HashMap<>();
        mpp.put(0,1);
        int presum = 0,cnt=0;
        for(int i = 0;i<arr.length;i++){
            presum+=arr[i];
            int remove = presum-k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(presum,mpp.getOrDefault(presum, 0)+1);
        }
        return cnt;

    }
    public static void main(String args[]){
        int nums[] = {1,1,1};
        int target = 9;
        int k = 2;
        int ans = NumberOfSubarraysWithSumK(nums,k);
        System.out.println(ans);
    }
}