package recursion;

import java.util.Stack;

public class ListNodePalindrom {
   public boolean isPalindrome(ListNode head) {
      ListNode curr = head;

      Stack stack;
      for(stack = new Stack(); curr != null; curr = curr.next) {
         stack.push(curr.val);
      }

      for(curr = head; curr != null; curr = curr.next) {
         int val = (Integer)stack.pop();
         if (curr.val != val) {
            return false;
         }
      }

      return true;
   }
}
