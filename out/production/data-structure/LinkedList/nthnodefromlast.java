package LinkedList;

public class nthnodefromlast {
   int getNthFromLast(Node head, int n) {
      Node slow = head;
      Node fast = head;

      int k;
      for(k = 0; fast != null && k < n; ++k) {
         fast = fast.next;
      }

      if (k != n) {
         return -1;
      } else {
         while(fast != null) {
            slow = slow.next;
            fast = fast.next;
         }

         return slow.data;
      }
   }
}
