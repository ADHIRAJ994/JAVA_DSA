import java.util.Scanner;

public class Stack_Using_Arrays {
    int top;
    int capacity;
    int arr[];

    public Stack_Using_Arrays(int size){
        capacity = size;
        arr = new int[capacity];
        top = -1;
    }
    public void push(int x){
        if(top==capacity-1){
            System.out.println("Overflow condition met.Cannot add");
        }else{
            top++;
            arr[top] = x;
            System.out.println(x+" pushed into the stack");
        }
    }
    public void pop(){
        if(top==-1){
            System.out.println("Underflow condition met.Cannot pop from the stack");
        }else{
            int x = arr[top];
            top--;
            System.out.println(x+" has been popped from the stack");
        }
    }
    public void peek(){
        if(top==-1){
            System.out.println("Underflow condition met.Cannot pop from the stack");
        }else{
            System.out.println("Top element is: "+arr[top]);
        }
    }
    public void display(){
        if(top==-1){
            System.out.println("Stack is Empty");
        }else{
            for (int i = 0; i <=top; i++) {
                System.out.println(arr[i]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Size: ");
        int size = sc.nextInt();

        Stack_Using_Arrays stack = new Stack_Using_Arrays(size);
        while (true) {
            System.out.println("\n--- Stack Menu ---");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int val = sc.nextInt();
                    stack.push(val);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    stack.peek();
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
    
