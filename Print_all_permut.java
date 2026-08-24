import java.util.*;
public class Print_all_permut {
    public static void generate(int nums[],List<List<Integer>> ans,List<Integer> list,boolean freq[]){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!freq[i]){
                freq[i] = true;
                list.add(nums[i]);
                generate(nums, ans, list, freq);
                list.remove(list.size()-1);
                freq[i] = false;
            }
        }
    }
    public static List<List<Integer>> permute(int nums[]){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean freq[] = new boolean[nums.length];
        generate(nums, ans, list, freq);
        return ans;
    }
    public static void main(String[] agrs){
        int nums[] = {1,2,3};
        List<List<Integer>> res = permute(nums);
        for(List<Integer>ans:res){
            System.out.println(ans);
        }
        
    }
}
