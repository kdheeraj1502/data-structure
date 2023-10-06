package stack;

import java.util.Stack;

public class MaxAreaHistogramStack {
   public static int maxArea(int[] num) {
      Stack<Integer> stack = new Stack();
      int size = num.length;
      int i = 0;
      int maxArea = 0;

      while(true) {
         while(i < size) {
            if (!stack.isEmpty() && num[(Integer)stack.peek()] > num[i]) {
               int top = (Integer)stack.peek();
               stack.pop();
               int currArea = num[top] * (stack.isEmpty() ? i : i - (Integer)stack.peek() - 1);
               maxArea = Math.max(currArea, maxArea);
            } else {
               stack.push(i);
               ++i;
            }
         }

         return maxArea;
      }
   }

   public static int maxAreaSelf(int[] num) {
      Stack<Integer> stack = new Stack();
      int currArea = false;
      int maxArea = 0;
      int i = 0;
      int top = true;

      while(true) {
         while(i < num.length) {
            if (!stack.isEmpty() && (Integer)stack.peek() > num[i]) {
               int top = (Integer)stack.peek();
               stack.pop();
               int currArea = num[top] * (stack.isEmpty() ? i : i - (Integer)stack.peek() - 1);
               maxArea = Math.max(maxArea, currArea);
            } else {
               stack.push(i++);
            }
         }

         return maxArea;
      }
   }

   public static int maxArea_self(int[] num) {
      Stack<Integer> stack = new Stack();
      int currArea = false;
      int maxArea = 0;
      int top = true;

      for(int i = 0; i < num.length; ++i) {
         if (!stack.isEmpty() && (Integer)stack.peek() > num[i]) {
            int top = (Integer)stack.peek();
            int currArea = num[top] * (stack.isEmpty() ? i : i - (Integer)stack.peek() - 1);
            maxArea = Math.max(maxArea, currArea);
         } else {
            stack.push(i);
         }
      }

      return maxArea;
   }

   public static void main(String[] args) {
      int[] num = new int[]{7, 6, 5, 44, 1, 6, 3, 1};
      System.out.println(maxAreaSelf(num));
      System.out.println(maxArea_self(num));
   }
}
