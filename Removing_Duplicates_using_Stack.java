import java.util.Stack;

public class Removing_Duplicates_using_Stack {
    public Stack<Character> removeDuplicates(Stack<Character> s, String abc) {
        for (int i = 0; i < abc.length(); i++) {
            char currChar = abc.charAt(i);
            if (!s.isEmpty() && s.peek() == currChar) {
                s.pop(); 
            } else {
                s.push(currChar);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String abc = "ababbac";
        Stack<Character> s = new Stack<>();
        Removing_Duplicates_using_Stack obj = new Removing_Duplicates_using_Stack();
        Stack<Character> result = obj.removeDuplicates(s, abc);


        for (char c : result) {
            System.out.print(c);
        }
    }
}
