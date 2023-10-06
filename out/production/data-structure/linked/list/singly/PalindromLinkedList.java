package linked.list.singly;

import java.util.Stack;

public class PalindromLinkedList {
   public boolean isPalindrome(ListNode head) {
      Stack<ListNode> stack = new Stack();

      ListNode curr;
      for(curr = head; curr != null; curr = curr.next) {
         stack.push(curr);
      }

      for(curr = head; curr != null; curr = curr.next) {
         ListNode node = (ListNode)stack.pop();
         if (curr.val != node.val) {
            return false;
         }
      }

      return true;
   }

   public static boolean isPalindrome_1(ListNode head) {
      if (head != null && head.next != null) {
         ListNode curr = head;
         ListNode temp = new ListNode();

         ListNode dummy;
         for(dummy = temp; curr.next != null; curr = curr.next) {
            dummy.next = new ListNode(curr.val);
            dummy = dummy.next;
         }

         dummy.next = new ListNode(curr.val);
         temp = temp.next;
         ListNode prev = reverse(head);

         for(curr = temp; curr != null && prev != null; prev = prev.next) {
            if (curr.val != prev.val) {
               return false;
            }

            System.out.print("curr " + curr.val + " prev " + prev.val);
            curr = curr.next;
         }

         System.out.println();
         return curr == null && prev == null;
      } else {
         return true;
      }
   }

   private static ListNode reverse(ListNode head) {
      ListNode curr = head;
      ListNode prev = null;

      for(ListNode next = null; curr != null; curr = next) {
         next = curr.next;
         curr.next = prev;
         prev = curr;
      }

      return prev;
   }

   public static void main(String[] args) {
      ListNode node = new ListNode(1);
      node.next = new ListNode(2);
      node.next.next = new ListNode(2);
      node.next.next.next = new ListNode(1);
      PalindromLinkedList pll = new PalindromLinkedList();
      System.out.println(pll.isPalindrome(node));
      System.out.println(isPalindrome_1(node));
   }
}
