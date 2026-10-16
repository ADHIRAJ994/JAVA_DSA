import java.util.Stack;

public class stacks {
    public static boolean isValidParen(String s){
        Stack<Character>stack = new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(')');
            }else if(ch=='['){
                stack.push(']');
            }else if(ch=='{'){
                stack.push('}');
            }else{
                if(stack.isEmpty()||stack.pop()!=ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static int[] dailyTemperatures(int[] temperatures){
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer>stack = new Stack<>();
        for(int right=0;right<temperatures.length;right++){
            while(stack.size()>0&&temperatures[right]>temperatures[stack.peek()]){
                int prev = stack.pop();
                ans[prev] = right-prev;
            }
            stack.push(right);
        }
        return ans;
    }
    public static void main(String args[]){
        String s = "(]";
        int arr[] = {73,74,75,71,69,72,76,73};
        // System.out.println(dailyTemperatures(arr));
        for(int x:dailyTemperatures(arr)){
            System.out.print(x+" ");
        }
    }
}
