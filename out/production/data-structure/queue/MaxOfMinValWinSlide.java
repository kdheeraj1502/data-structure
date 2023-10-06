package queue;

import java.util.ArrayDeque;

public class MaxOfMinValWinSlide {
   public static int maxOfMinValWinSlide(int[] num, int k) {
      ArrayDeque<Integer> queue = new ArrayDeque();
      int max_value = Integer.MIN_VALUE;

      for(int i = 0; i < num.length; ++i) {
         if (queue.size() > 0 && (Integer)queue.peek() <= i - k) {
            queue.remove();
         }

         while(queue.size() > 0 && num[(Integer)queue.peekLast()] >= num[i]) {
            queue.removeLast();
         }

         queue.add(i);
         if (i >= k - 1 && num[(Integer)queue.peek()] > max_value) {
            max_value = num[(Integer)queue.peek()];
         }
      }

      return max_value;
   }

   public static void main(String[] args) {
      int[] num = new int[]{11, 2, 75, 92, 59, 90, 55};
      int k = 3;
      System.out.println(maxOfMinValWinSlide(num, k));
   }
}
