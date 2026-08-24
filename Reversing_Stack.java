import java.util.*;

public class Reversing_Stack {
    public static void ReverseStack(Stack<Integer> stack){
        Queue<Integer> queue = new LinkedList<>();

        while(!stack.isEmpty()){// First we take the elements from the stack and then add it to a queue.
            queue.add(stack.pop());
        }
        while(!queue.isEmpty()){// Now we remove the elelemts from the queue and them to the stack.
            stack.push(queue.remove());
        }
    }
    public static void main(String args[]){
        Reversing_Stack obj = new Reversing_Stack();
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Original stack is: "+stack);
        obj.ReverseStack(stack);

        System.out.println("Reversed stacke: "+stack);
        
    }
}
