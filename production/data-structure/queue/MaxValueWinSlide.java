package queue;

import java.util.ArrayDeque;

public class MaxValueWinSlide {
   public static void maxSlidingWin(int[] num, int k) {
      ArrayDeque<Integer> queue = new ArrayDeque();

      for(int i = 0; i < num.length; ++i) {
         if (queue.size() > 0 && (Integer)queue.peek() <= i - k) {
            queue.remove();
         }

         while(queue.size() > 0 && num[(Integer)queue.peekLast()] <= num[i]) {
            queue.removeLast();
         }

         queue.add(i);
         if (i >= k - 1) {
            System.out.println("i is :" + i + " and (k - 1) is " + k + " - " + 1 + " Hence " + (i >= k - 1) + " " + i + " >= " + (k - 1));
            System.out.println(num[(Integer)queue.peek()]);
         }
      }

   }

   public static void maxSlidingWin_self(int[] num, int k) {
      ArrayDeque<Integer> queue = new ArrayDeque();

      for(int i = 0; i < num.length; ++i) {
         if (queue.size() > 0 && (Integer)queue.peek() <= i - k) {
            queue.remove();
         }

         while(queue.size() > 0 && num[(Integer)queue.peekLast()] <= num[i]) {
            queue.removeLast();
         }

         queue.add(i);
         if (i >= k - 1) {
            System.out.println(num[(Integer)queue.peek()]);
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{11, 2, 75, 92, 59, 90, 55};
      int k = 3;
      maxSlidingWin_self(num, k);
   }
}
