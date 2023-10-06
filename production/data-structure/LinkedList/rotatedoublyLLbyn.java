package LinkedList;

public class rotatedoublyLLbyn {
   Node rotateP(Node head, int p) {
      Node tail;
      for(tail = head; tail.next != null; tail = tail.next) {
      }

      while(p > 0) {
         tail.next = head;
         head.prev = tail;
         head = head.next;
         head.prev = null;
         tail = tail.next;
         tail.next = null;
         --p;
      }

      return head;
   }
}
