package linked.list.singly;

import java.util.HashSet;

public class DetectLoop {
   public boolean hasCycle(ListNode head) {
      if (head == null) {
         return false;
      } else {
         ListNode fast = head.next;

         for(ListNode slow = head; fast != null && fast.next != null; slow = slow.next) {
            if (fast == slow) {
               return true;
            }

            fast = fast.next.next;
         }

         return false;
      }
   }

   public static void detectLoop(Node node) {
      HashSet set;
      for(set = new HashSet(); node.next != null; node = node.next) {
         if (set.contains(node)) {
            System.out.println("loop found");
            break;
         }

         set.add(node);
      }

      if (set.contains(node)) {
         System.out.println("loop found");
      } else {
         set.add(node);
         System.out.println("loop not found");
      }

   }

   public static Node detectLoop_SPFP(Node node) {
      Node slow = node;
      Node fast = node;

      while(true) {
         if (slow.next != null && fast.next.next != null) {
            if (node != slow.next && node != fast.next.next) {
               slow = slow.next;
               fast = fast.next.next;
               if (slow == fast) {
                  System.out.println("loop found");
                  return fast;
               }
               continue;
            }

            System.out.println("circular loop");
            return node;
         }

         System.out.println("loop not found");
         return null;
      }
   }
}
