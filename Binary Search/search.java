public class search {
    public static int searchInsert(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return mid;
        }
        else if (nums[mid] < target) {
            left = mid + 1;
        }
        else {
            right = mid - 1;
        }
    }

    return left;
}
public static int lowerBound(int[] nums, int target) {

    int left = 0;
    int right = nums.length;

    while (left < right) {

        int mid = left + (right - left) / 2;

        if (nums[mid] >= target) {
            right = mid;
        } else {
            left = mid + 1;
        }
    }

    return left;
}
public static int upperBound(int[] nums, int target) {// Helping Function in LC: 34

    int left = 0;
    int right = nums.length;

    while (left < right) {

        int mid = left + (right - left) / 2;

        if (nums[mid] > target) {
            right = mid;
        }
        else {
            left = mid+1;
        }
    }

    return left;
}
public static int[] searchRange(int nums[],int target){
    int lb = lowerBound(nums, target);
    if (lb==nums.length||nums[lb]!=target){
        return new int[]{-1,-1};
    }
    int ub = upperBound(nums, target);
    return new int[]{lb,ub-1};
}

public static int Search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
}
public static boolean Search2(int[] nums, int target) {

    int left = 0;
    int right = nums.length - 1;

    while (left <= right) {

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) {
            return true;
        }

        // Cannot determine which side is sorted
        if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
            left++;
            right--;
        }

        // Left half is sorted
        else if (nums[left] <= nums[mid]) {

            if (nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Right half is sorted
        else {

            if (nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }

    return false;
}
public static int findMin(int nums[]){
    int n = nums.length;
    int low = 0,high=n-1,ans = Integer.MAX_VALUE;
    while(low<=high){
        int mid = (low+high)/2;
        if(nums[low]<=nums[mid]){
            ans = Math.min(ans,nums[low]);
            low = mid+1;
        }else{
            ans = Math.min(ans,nums[mid]);
            high = mid-1;
        }
    }
    return ans;
}
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2};
        int ans = findMin(arr);
        System.out.println(ans);
    }
}
