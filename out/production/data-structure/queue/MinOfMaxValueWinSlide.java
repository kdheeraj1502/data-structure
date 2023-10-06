package queue;

import java.util.ArrayDeque;

public class MinOfMaxValueWinSlide {
   public static void main(String[] args) {
      int[] num = new int[]{11, 2, 75, 92, 59, 90, 55};
      int k = 3;
      System.out.println(minOfMaxValue(num, k));
   }

   private static int minOfMaxValue(int[] num, int k) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      int minVal = Integer.MAX_VALUE;

      for(int i = 0; i < num.length; ++i) {
         if (queue.size() > 0 && (Integer)queue.peek() <= i - k) {
            queue.remove();
         }

         while(queue.size() > 0 && num[(Integer)queue.peekLast()] < num[i]) {
            queue.removeLast();
         }

         queue.add(i);
         if (i >= k - 1 && num[(Integer)queue.peek()] < minVal) {
            minVal = num[(Integer)queue.peek()];
         }
      }

      return minVal;
   }
}
