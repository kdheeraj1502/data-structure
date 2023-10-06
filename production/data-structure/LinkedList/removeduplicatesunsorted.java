package LinkedList;

import java.util.HashSet;

public class removeduplicatesunsorted {
   public Node removeDuplicates(Node head) {
      HashSet<Integer> map = new HashSet();
      Node temp = head;
      map.add(head.data);

      while(temp != null) {
         Node ahead;
         for(ahead = temp.next; ahead != null && map.contains(ahead.data); ahead = temp.next) {
            temp.next = ahead.next;
         }

         temp = ahead;
         if (ahead != null) {
            map.add(ahead.data);
         }
      }

      return head;
   }
}
