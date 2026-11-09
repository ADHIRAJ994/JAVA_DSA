class Node{
    int x;
    Node next;
    Node(int x){
        this.x = x;
        this.next = null;
    }
}
public class ListNode{
    public static Node DeleteFromStartingHead(Node head){
        if(head==null){
            return head;
        }
        Node temp = head;
        head = head.next;
        return head;
    }
    public static Node DeleteFromEnd(Node head){
        if(head==null) return head;
        Node prev = head;
        Node curr = head.next;
        while(curr.next!=null){
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }
    public static Node DeleteKthElement(Node head,int index){
        if(head==null) return head;
        Node prev = head;
        Node temp = head.next;
        for(int i = 0;i<index-1;i++){
            temp = temp.next;
            prev = prev.next;
        }
        prev.next = temp.next;
        return head;
    }
    public static Node InsertAtTheKthPosistion(Node head,int index,int value){
        if(head==null)return head;
        Node newNode = new Node(value);
        Node temp = head;
        Node curr = head.next;

        for(int i =0;i<index-1;i++){
            temp = temp.next;
            curr = curr.next;
        }
        temp.next=newNode;
        newNode.next=curr;
        return head;
    }
    public static Node DeleteElementWithValueX(Node head,int x){
        if(head==null) return head;
        if(head.x==x){
            head = head.next;
            return head;
        }
        Node temp = head;
        while(temp.next!=null){
            if(temp.next.x==x){
                temp.next = temp.next.next;
                return head;
            }
            temp = temp.next;
        }
        return head;
    }
    public static Node InsertAtTheBeggining(Node head,int value){
       Node newnode = new Node(value);
       newnode.next = head;
       head = newnode;
       return head;
        
    }
    public static Node InsertAtTheEnd(Node head,int value){
       Node newnode = new Node(value);
       Node temp = head;
       while(temp.next!=null){
        temp = temp.next;
       }
        temp.next = newnode;
        newnode.next = null;
        return head;
    }
    public static Node addElement(Node head,int value){
        Node newNode = new Node(value);
        if(head==null){
            return  newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next=newNode;
        return head;
    }
    public static void PrintList(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.x+" -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }
    public static int LengthLL(Node head){
        Node temp = head;
        int count = 0;
        while(temp.next!=null){
            count++;
            temp = temp.next;
        }
        return count;
    }
    public static boolean Search(Node head,int value){
        Node temp = head;
        int len = LengthLL(head);
        Node newNode = new Node(value);
        for(int i = 0;i<len;i++){
            if(temp.x==newNode.x){
                return true;
            }
            temp = temp.next;
        }
        return  false;
    }
    public static void main(String[] args){
        Node head = null;
        head = addElement(head, 10);
        head = addElement(head, 20);
        head = addElement(head, 40);
        head = addElement(head, 50);
        head = addElement(head, 60);
        head = addElement(head, 80);
        PrintList(head);
        head=InsertAtTheKthPosistion(head, 2, 0);
        System.out.println();
        PrintList(head);
        System.out.println();
        int len = LengthLL(head);
        System.out.println("length of The Linked List Is: "+len);
        boolean isPresent = Search(head, 0);
        if(isPresent){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }
    }
}
