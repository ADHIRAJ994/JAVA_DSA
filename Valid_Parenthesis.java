import java.util.HashMap;
import java.util.Stack;

public class Valid_Parenthesis{
    public static boolean isValid(String s){
        HashMap<Character,Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        for(char ch:s.toCharArray()){
            if(map.containsKey(ch)){
                if(!stack.isEmpty()&&stack.peek()==map.get(ch)){
                    stack.pop();
                }else{
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
    public static void main(String args[]){
        String abc = "[{}]";
        System.out.println(isValid(abc));
    }
}