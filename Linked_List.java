public class Linked_List {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void AddFirst(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void AddLast(String data){
        Node newNode = new Node(data);
        if(head==null){
            head = newNode;
            return;
        }
        Node currNode = head;
        while(currNode.next!=null){
            currNode = currNode.next;
        }
        currNode.next = newNode;
    }
    public void deleteFirst(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        head = head.next;
    }
    public void deleteLast(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        if(head.next==null){
            head = null;
            return;
        }
        Node secondLast = head;
        Node LastNode = head.next;
        while(LastNode.next!=null){
            LastNode = LastNode.next;
            secondLast = secondLast.next;
        }
        secondLast.next = null;
    }
    public void printList(){
        if(head==null){
            System.out.println("List is empty");
        }
        Node currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
        
    }
    public static void main(String args[]){
        Linked_List list = new Linked_List();
        list.AddFirst("a");
        list.AddFirst("is");
        list.AddLast("List");
        list.printList();

        // list.deleteFirst();
        // list.printList();

        list.deleteLast();
        list.printList();
    }
}
