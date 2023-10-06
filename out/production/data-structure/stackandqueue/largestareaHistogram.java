package stackandqueue;

import java.util.Stack;

public class largestareaHistogram {
   public static void main(String[] args) {
   }

   public static long getMaxArea(long[] hist, long n) {
      int[] rb = new int[hist.length];
      Stack<Integer> rst = new Stack();
      rb[rb.length - 1] = rb.length;
      rst.push(rb.length - 1);

      for(int i = rb.length - 2; i >= 0; --i) {
         while(rst.size() > 0 && hist[i] <= hist[(Integer)rst.peek()]) {
            rst.pop();
         }

         if (rst.size() == 0) {
            rb[i] = hist.length;
         } else {
            rb[i] = (Integer)rst.peek();
         }

         rst.push(i);
      }

      int[] lb = new int[hist.length];
      Stack<Integer> lst = new Stack();
      lb[0] = -1;
      lst.push(0);

      for(int i = 1; i < lb.length; ++i) {
         while(lst.size() > 0 && hist[i] <= hist[(Integer)lst.peek()]) {
            lst.pop();
         }

         if (lst.size() == 0) {
            lb[i] = -1;
         } else {
            lb[i] = (Integer)lst.peek();
         }

         lst.push(i);
      }

      long maxarea = 0L;

      for(int i = 0; i < hist.length; ++i) {
         int width = rb[i] - lb[i] - 1;
         Long area = hist[i] * (long)width;
         if (maxarea < area) {
            maxarea = area;
         }
      }

      return maxarea;
   }
}
