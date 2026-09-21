   
//  * Definition for singly-linked list.
class ListNode 
{
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
public class leet2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode();
        ListNode curr=l3;
        int carry=0;
        while(l1!=null&&l2!=null&&carry!=0)
        {
            int sum=carry;
            if(l1!=null)
            {
                sum= sum+l1.val;
                l1=l1.next;
            }
            if(l2!=null)
            {
                sum=sum+l2.val;
                l2=l2.next;
            }

            carry=sum/10;

            int digit=sum%10;

            curr.next=new ListNode(digit);

            curr = curr.next;
        }
        return l3.next;
    }
    public static void main(String[] args) {
        // Create first list
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // Create second list
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        leet2 s = new leet2();

        ListNode result = s.addTwoNumbers(l1, l2);

        // Print result
        while(result != null) {
            System.out.print(result.val + " -> ");
            result = result.next;
        }

        System.out.println("null");
        
    }
}

