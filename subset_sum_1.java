import java.util.*;

public class subset_sum_1 {
    public static void generate(int i, List<Integer> nums, int sum, List<Integer> ans, int size) {
        if (i == size) {
            ans.add(sum);
            return;
        }

        // include current element
        generate(i + 1, nums, sum + nums.get(i), ans, size);

        // exclude current element
        generate(i + 1, nums, sum, ans, size);
    }

    public static List<Integer> subsetSum(List<Integer> nums, int size) {
        List<Integer> ans = new ArrayList<>();
        generate(0, nums, 0, ans, size);
        //Collections.sort(ans); // Optional
        return ans;
    }

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 3, 2);
        List<Integer> result = subsetSum(nums, nums.size()); 
        System.out.println(result);
    }
}
