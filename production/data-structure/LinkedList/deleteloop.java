package LinkedList;

public class deleteloop {
   public static void removeLoop(Node head) {
      Node slow = head;
      Node fast = head;

      while(fast != null && fast.next != null) {
         slow = slow.next;
         fast = fast.next.next;
         if (fast == slow) {
            if (fast == head) {
               while(slow.next != fast) {
                  slow = slow.next;
               }
            } else {
               for(fast = head; fast.next != slow.next; slow = slow.next) {
                  fast = fast.next;
               }
            }

            slow.next = null;
            break;
         }
      }

   }
}
