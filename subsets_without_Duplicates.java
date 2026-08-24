import java.util.*;
public class subsets_without_Duplicates {
    public static void generate(int idx,int nums[],List<Integer>list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i =idx;i<nums.length;i++){
            if(i!=idx&&nums[i]==nums[i-1])continue;
            list.add(nums[i]);
            generate(i+1, nums, list, ans);
            list.remove(list.size()-1);
        }
    }
    public static List<List<Integer>> subsetWithDup(int nums[]){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        generate(0, nums, list, ans);
        return ans;
    }
    public static void main(String[] args){
        int nums[] = {1,2,3};
        List<List<Integer>> result = subsetWithDup(nums);

        for(List<Integer>x:result){
            System.out.println(x);
        }
    }
}
