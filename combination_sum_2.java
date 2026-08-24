import java.util.*;

public class combination_sum_2 {

    public static void generate(List<List<Integer>> ans, ArrayList<Integer> list, int i, int target, int nums[]) {
        int n = nums.length;

        
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == n || target < 0) {
            return;
        }

        for(int idx = i;idx<n;idx++){
            if(idx>i&&nums[idx]==nums[idx-1]) continue;// To skips the duplicates.
            if(nums[idx]>target)break;

            list.add(nums[idx]);
            generate(ans, list, idx+1, target - nums[idx], nums);
            list.remove(list.size() - 1);
        } 
    }

    public static List<List<Integer>> sum(int nums[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        generate(ans, list, 0, target, nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2};
        int target = 4;
        List<List<Integer>> result = sum(nums, target);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
