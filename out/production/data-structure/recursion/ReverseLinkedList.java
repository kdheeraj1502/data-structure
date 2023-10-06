package recursion;

public class ReverseLinkedList {
   ListNode result = new ListNode(-1);
   ListNode prev = null;

   public ListNode reverseList(ListNode head) {
      ListNode curr = this.result;
      int val = this.reverse(head);
      if (head.val == val) {
         while(true) {
            if (this.result.next == null) {
               this.result.next = new ListNode(this.reverse(head));
               break;
            }

            this.result = this.result.next;
         }
      }

      return curr.next;
   }

   public int reverse(ListNode head) {
      if (head.next == null) {
         return head.val;
      } else {
         int rightSide = this.reverse(head.next);
         this.result.next = new ListNode(rightSide);
         this.result = this.result.next;
         return head.val;
      }
   }

   public ListNode reverseList_recursion(ListNode head) {
      if (head != null && head.next != null) {
         ListNode next = head.next;
         head.next = this.prev;
         this.prev = head;
         head = this.reverseList(next);
         head.next = this.prev;
         return head;
      } else {
         return head;
      }
   }

   public static void main(String[] args) {
      ListNode node = new ListNode(1);
      node.next = new ListNode(2);
      node.next.next = new ListNode(3);
      node.next.next.next = new ListNode(4);
      node.next.next.next.next = new ListNode(5);
      ReverseLinkedList rl = new ReverseLinkedList();

      for(ListNode result = rl.reverseList(node); result != null; result = result.next) {
         System.out.print(result + " ");
      }

   }
}
