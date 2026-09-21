public class leet143 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        // 1. Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. Split the list
        ListNode second = slow.next;
        slow.next = null;

        // 3. Reverse second half
        ListNode prev = null;

        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        second = prev;

        // 4. Merge both halves
        ListNode first = head;

        while (second != null) {

            ListNode firstNext = first.next;
            ListNode secondNext = second.next;

            first.next = second;
            second.next = firstNext;

            first = firstNext;
            second = secondNext;
        }
    }

    // Print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val);

            if (temp.next != null) {
                System.out.print(" -> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before:");
        printList(head);

        reorderList(head);

        System.out.println("After:");
        printList(head);
    }
}

