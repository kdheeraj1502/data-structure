package LinkedList;

public class reverseLL {
   public ListNode reverseList(ListNode head) {
      if (head == null) {
         return head;
      } else {
         ListNode prev = head;

         ListNode ahead;
         for(ListNode curr = head.next; curr != null; curr = ahead) {
            ahead = curr.next;
            curr.next = prev;
            prev = curr;
         }

         head.next = null;
         return prev;
      }
   }

   public ListNode reverseListrecursive(ListNode head) {
      if (head != null && head.next != null) {
         ListNode temp = this.reverseList(head.next);
         head.next.next = head;
         head.next = null;
         return temp;
      } else {
         return head;
      }
   }
}
