package recursion;

public class MergeTwoSortedListsNode {
   public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null && l2 == null) {
         return null;
      } else if (l1 == null) {
         return l2;
      } else if (l2 == null) {
         return l1;
      } else {
         ListNode result;
         for(result = new ListNode(-1); l1 != null && l2 != null; result = result.next) {
            if (l1.val <= l2.val) {
               result.next = new ListNode(l1.val);
               l1 = l1.next;
            } else {
               result.next = new ListNode(l2.val);
               l2 = l2.next;
            }
         }

         if (l1 == null) {
            result.next = l2;
         }

         if (l2 == null) {
            result.next = l1;
         }

         return result.next;
      }
   }

   public static void main(String[] args) {
      ListNode l1 = new ListNode(1);
      l1.next = new ListNode(2);
      l1.next.next = new ListNode(4);
      ListNode l2 = new ListNode(1);
      l2.next = new ListNode(3);
      l2.next.next = new ListNode(4);

      for(ListNode result = mergeTwoLists(l1, l2); result != null; result = result.next) {
         System.out.print(result.val + ", ");
      }

   }
}
