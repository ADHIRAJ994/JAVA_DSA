public class Queue_Using_Linked_list {
    public static Node head = null;
    public static Node tail = null;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static boolean isEmpty(){
        return head==null&&tail==null;
    }
    public static void add(int data){
        Node newNode = new Node(data);
        if(tail==null){
            tail=head=newNode;
            return;
        }
        tail.next = newNode;
        tail=newNode;
    }
    public static int remove(){
        if(isEmpty()){
            System.out.println("Empty Queue");
            return -1;
        }
        int front = head.data;
        if(head==tail){
            tail=null;
        }
        head = head.next;
        return front;
    }
    public static int peek(){
        if(isEmpty()){
            System.out.println("Empty queue");
            return -1;
        }
        return head.data;
    }
    public static void main(String args[]){
        Queue_Using_Linked_list obj = new Queue_Using_Linked_list();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        obj.add(5);

        obj.remove();

        while(!obj.isEmpty()){
            System.out.println(obj.peek());
            obj.remove();
        }
    }
}
