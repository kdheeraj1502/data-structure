package queue;

import java.util.ArrayDeque;

public class FirstNegativeSlideWin {
   public static void firstNegative(int[] num, int k) {
      ArrayDeque<Integer> queue = new ArrayDeque();

      for(int i = 0; i < num.length; ++i) {
         if (queue.size() > 0 && (Integer)queue.peek() <= i - k) {
            queue.remove();
         }

         if (num[i] < 0) {
            queue.add(i);
         }

         if (i >= k - 1) {
            if (queue.size() > 0) {
               System.out.println(num[(Integer)queue.peek()]);
            } else {
               System.out.println("NA");
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{13, -2, -6, 10, -14, 50, 14, 21};
      firstNegative(num, 3);
   }
}
