public class leet148 {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // Find the middle
        ListNode first = head;
        ListNode second = head.next;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        // Split the list
        ListNode middle = first.next;
        first.next = null;

        // Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        // Merge both halves
        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (left != null && right != null) {

            if (left.val <= right.val) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }

            current = current.next;
        }

        // Add remaining nodes
        if (left != null) {
            current.next = left;
        }

        if (right != null) {
            current.next = right;
        }

        return dummy.next;
    }

    // Print linked list
    public static void printList(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list
        // 4 -> 2 -> 1 -> 3
        ListNode head = new ListNode(4);

        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Before sorting:");
        printList(head);

        // Sort the linked list
        head = sortList(head);

        System.out.println("After sorting:");
        printList(head);
    }
}