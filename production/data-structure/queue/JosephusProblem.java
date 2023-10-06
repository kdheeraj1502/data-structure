package queue;

import java.util.ArrayDeque;

public class JosephusProblem {
   public static int josephusProb(ArrayDeque<Integer> queue, int k) {
      for(int i = 1; i <= k; ++i) {
         int val = (Integer)queue.remove();
         if (i == k) {
            break;
         }

         queue.add(val);
      }

      return (Integer)queue.getFirst();
   }

   public static int josephusProb(ArrayDeque<Integer> queue) {
      josephusProb(queue, 2, 0, 1);
      return (Integer)queue.getFirst();
   }

   public static void josephusProb(ArrayDeque<Integer> queue, int k, int val, int i) {
      if (i == 2) {
         queue.add(val);
         i = 1;
         queue.remove();
      }

      if (queue.size() != 1) {
         int ele = (Integer)queue.remove();
         josephusProb(queue, k, ele, i + 1);
      }
   }

   public static void main(String[] args) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      queue.add(1);
      queue.add(2);
      queue.add(3);
      queue.add(4);
      queue.add(5);
      int val = josephusProb(queue);
      System.out.println(val);
   }
}
