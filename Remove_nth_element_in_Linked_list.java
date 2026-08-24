public class Remove_nth_element_in_Linked_list {
    ListNode head;
    class ListNode{
        String data;
        ListNode next;
        ListNode(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void AddFirst(String data){
        ListNode newNode = new ListNode(data);
        if(head==null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;             
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        // Calculating Size.
        int size = 0;
        ListNode curr = head;
        while(curr!=null){
            curr = curr.next;
            size++;
        }
        if(n==size){
            return head.next;
        }
        // taking the index before nth element.
        int indexToSearch = size-n;
        ListNode prev = head;
        int i = 1;
        while(i<indexToSearch){
            prev = prev.next;
            i++;
        }
          prev.next = prev.next.next;// Skips the node therefore deleting it.
          return head;
    }
    public void printList(){
        if(head==null){
            System.out.println("List is empty");
        }
        ListNode currNode = head;
        while(currNode!=null){
            System.out.print(currNode.data+"->");
            currNode = currNode.next;
        }
        System.out.println("NULL");
        
    }

    public static void main(String args[]){
        Remove_nth_element_in_Linked_list obj = new Remove_nth_element_in_Linked_list();
        obj.AddFirst("1");
        obj.AddFirst("2");
        obj.AddFirst("3");
        obj.AddFirst("4");
        obj.AddFirst("5");
        obj.removeNthFromEnd(obj.head, 2);
        obj.printList();
    }
}
