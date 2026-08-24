public class palindrome_of_Linked_list {
    ListNode head;

    class ListNode {
        String data;
        ListNode next;

        ListNode(String data) {
            this.data = data;
            this.next = null;
        }
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode findMiddle(ListNode head) {
        ListNode hare = head;
        ListNode turtle = head;

        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            turtle = turtle.next;
        }
        return turtle;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middle = findMiddle(head);
        ListNode secondHalfStart = reverse(middle.next);
        ListNode firstHalfStart = head;

        while (secondHalfStart != null) {
            if (!firstHalfStart.data.equals(secondHalfStart.data)) {
                return false;
            }
            firstHalfStart = firstHalfStart.next;
            secondHalfStart = secondHalfStart.next;
        }
        return true;
    }

    public void AddFirst(String data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
        }
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + " -> ");
            currNode = currNode.next;
        }
        System.out.println("NULL");
    }

    public static void main(String args[]) {
        palindrome_of_Linked_list obj = new palindrome_of_Linked_list();
        obj.AddFirst("1");
        obj.AddFirst("2");
        obj.AddFirst("2");
        obj.AddFirst("1");

        obj.printList();

        System.out.println("Is Palindrome? " + obj.isPalindrome(obj.head));
    }
}