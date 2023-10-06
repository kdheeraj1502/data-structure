package LinkedList;

import java.util.PriorityQueue;

public class ksortedLL {
   public static Node sortedDll(Node head, int k) {
      if (head != null && head.next != null) {
         for(Node temp2 = head.next; temp2 != null; temp2 = temp2.next) {
            for(Node j = temp2; j.prev != null && j.prev.data > j.data; j = j.prev) {
               int t = j.prev.data;
               j.prev.data = j.data;
               j.data = t;
            }
         }

         return head;
      } else {
         return head;
      }
   }

   public static Node sortedDlloptimised(Node head, int k) {
      PriorityQueue<Integer> heap = new PriorityQueue();
      Node temp = head;

      for(int i = 0; i <= k; temp = temp.next) {
         heap.add(temp.data);
         ++i;
      }

      Node temp2;
      for(temp2 = head; temp != null; temp = temp.next) {
         temp2.data = (Integer)heap.remove();
         temp2 = temp2.next;
         heap.add(temp.data);
      }

      while(heap.size() > 0) {
         temp2.data = (Integer)heap.remove();
         temp2 = temp2.next;
      }

      return head;
   }
}
