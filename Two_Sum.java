import java.util.*;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int st = i + 1, end = nums.length - 1;
            int temp = target - nums[i];

            
            while (st <= end) {
                int mid = st + (end - st) / 2;

                if (nums[mid] == temp) {
                    return new int[]{i + 1, mid + 1}; 
                } else if (nums[mid] < temp) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return new int[0]; 
    }

    public static void main(String args[]) {
        int nums[] = {1, 2, 3, 4};  
        int ans[] = twoSum(nums, 3);
        System.out.println(Arrays.toString(ans)); // 
    }
}
