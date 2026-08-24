import java.util.Scanner;
import java.util.Stack;

public class Infix_TO_Postfix {

    // Method to return precedence of operators
    static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    public static String convertToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {
                // Operand goes directly to output
                result.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                // Pop until '(' is found
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                stack.pop(); // Remove '(' from stack
            } else {
                // Operator encountered
                while (!stack.isEmpty() &&
                       precedence(ch) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        // Pop any remaining operators
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String exp = sc.nextLine();
        sc.close();

        String postfix = convertToPostfix(exp);
        System.out.println("Postfix expression: " + postfix);
    }
}
