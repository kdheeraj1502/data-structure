package LinkedList;

public class reverseLLingroups {
   public static Node reverse(Node head, int k) {
      if (head == null) {
         return head;
      } else {
         Node prev = head;
         Node curr = head.next;

         Node temp;
         for(int i = 0; i <= k - 2 && curr != null; ++i) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
         }

         temp = reverse(curr, k);
         head.next = temp;
         return prev;
      }
   }
}
