public class Doubly_Linked_list {
    public Node head;
    class Node{
        int data;
        Node next,prev;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public void insert_At_Beggining(int data){
        Node newNode = new Node(data);
        if(head!=null){
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }
    public void insert_At_End(int data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }
    public void deleteFirst(){
        if(head==null){
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void deleteLast(){
        if(head==null){
            return;
        }
        Node temp = head.next;
        Node previNode = head;
        while(temp.next!=null){
            temp = temp.next;
            previNode = previNode.next;
        }
        previNode.next = null;
        previNode.prev = temp;
    }
    public void PrintArray(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    public static void main(String[] args){
        Doubly_Linked_list obj = new Doubly_Linked_list();
        obj.insert_At_End(1);
        obj.insert_At_End(2);
        obj.insert_At_End(3);
        obj.insert_At_End(4);
        obj.PrintArray();

        obj.insert_At_Beggining(0);
        obj.PrintArray();
        
    }
}
