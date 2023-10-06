package stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpanProblem {
   public static int[] stockSpanProb(int[] num) {
      int j = false;
      int index = 0;
      int[] result = new int[num.length];

      for(int i = 0; i < num.length; ++i) {
         int count = 0;

         for(int j = i; j >= 0; --j) {
            if (num[j] <= num[i]) {
               ++count;
            }
         }

         result[index++] = count;
      }

      return result;
   }

   public static int[] stockSpanProbStack(int[] num) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[num.length];
      result[0] = 1;
      stack.push(0);
      int index = 1;

      for(int i = 1; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] <= num[i]) {
            stack.pop();
         }

         result[index++] = stack.isEmpty() ? i + 1 : i - (Integer)stack.peek();
         stack.push(i);
      }

      return result;
   }

   public static int[] stockSpanProbStack_self(int[] num) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[num.length];
      result[0] = 1;
      stack.push(0);
      int index = 1;

      for(int i = 1; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] <= num[i]) {
            stack.pop();
         }

         result[index++] = stack.isEmpty() ? i + 1 : i - (Integer)stack.peek();
         stack.push(i);
      }

      return result;
   }

   public static int[] stockSpanProb_without_stack(int[] num) {
      int j = false;
      int[] result = new int[num.length];
      int index = 0;

      for(int i = 0; i < num.length; ++i) {
         int j = i;

         int count;
         for(count = 0; j >= 0 && num[j] <= num[i]; --j) {
            ++count;
         }

         result[index++] = count;
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{6, 5, 4, 3, 2, 4, 5, 7, 9};
      int[] val1 = stockSpanProbStack(num);
      int[] val2 = stockSpanProbStack_self(num);
      int[] val3 = stockSpanProb_without_stack(num);
      System.out.println(Arrays.toString(val1));
      System.out.println(Arrays.toString(val2));
      System.out.println(Arrays.toString(val3));
   }
}
