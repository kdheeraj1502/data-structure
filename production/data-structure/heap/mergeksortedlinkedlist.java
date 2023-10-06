package heap;

import java.util.PriorityQueue;

public class mergeksortedlinkedlist {
   public static void main(String[] args) {
   }

   public static Node mergeKList(Node[] arr, int K) {
      PriorityQueue<pair> heap = new PriorityQueue();

      for(int i = 0; i < arr.length; ++i) {
         heap.add(new pair(i, arr[i]));
      }

      pair rv = (pair)heap.remove();
      Node head = rv.node;
      Node tail = head;
      if (rv.node.next != null) {
         heap.add(new pair(rv.llname, rv.node.next));
      }

      while(heap.size() > 0) {
         rv = (pair)heap.remove();
         Node temp = rv.node;
         tail.next = temp;
         tail = tail.next;
         if (rv.node.next != null) {
            heap.add(new pair(rv.llname, rv.node.next));
         }
      }

      return head;
   }
}
