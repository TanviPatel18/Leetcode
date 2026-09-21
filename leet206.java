class ListNode
{
    int val;
    ListNode next;

    ListNode()
    {
    }

    ListNode(int val)
    {
        this.val = val;
    }

    ListNode(int val, ListNode next)
    {
        this.val = val;
        this.next = next;
    }
}

public class leet206 {

    // Reverse Linked List using Recursion
    public ListNode reverseList(ListNode head) {

        if(head == null || head.next == null)
        {
            return head;
        }

        ListNode newhead = reverseList(head.next);

        head.next.next = head;
        head.next = null;

        return newhead;
    }

    // Print Linked List
    public static void printList(ListNode head)
    {
        while(head != null)
        {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        leet206 obj = new leet206();

        // Create Linked List
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Original List:");
        printList(head);

        // Reverse Linked List
        head = obj.reverseList(head);

        System.out.println("Reversed List:");
        printList(head);
    }
}