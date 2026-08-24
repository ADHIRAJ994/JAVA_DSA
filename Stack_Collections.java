import java.util.*;
public class Stack_Collections {
    public static void PRintStack(Stack<Integer>s){
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
    public static void pushAtBottom(int data,Stack<Integer>s){
        if(s.empty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(data, s);
        s.push(top);// This  gets called after the base case hits.
    }
    public static void Reverse(Stack<Integer>s){
        if(s.empty()){
            return;
        }
        int top = s.pop();
        Reverse(s);
        pushAtBottom(top, s);// This function gets called after the base case hits.
    }
    public static void main(String args[]){
        Stack<Integer> s= new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);

        Reverse(s);
        PRintStack(s);
        
        //pushAtBottom(5, s);
        
    }
}
