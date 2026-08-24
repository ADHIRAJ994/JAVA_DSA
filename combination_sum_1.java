import java.util.*;

public class combination_sum_1 {

    public static void generate(List<List<Integer>> ans, ArrayList<Integer> list, int i, int target, int nums[]) {
        int n = nums.length;
        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (i == n || target < 0) {
            return;
        }
        
        list.add(nums[i]);
        generate(ans, list, i, target - nums[i], nums);
        list.remove(list.size() - 1);        
        generate(ans, list, i + 1, target, nums);
    }

    public static List<List<Integer>> sum(int nums[], int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generate(ans, list, 0, target, nums);
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3};
        int target = 7;
        List<List<Integer>> result = sum(nums, target);

        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }
}
