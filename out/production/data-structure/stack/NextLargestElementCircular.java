package stack;

import java.util.Arrays;
import java.util.Stack;

public class NextLargestElementCircular {
   public static int[] nextLargestElementCircular(int[] num) {
      Stack<Integer> stack = new Stack();
      int i = 0;
      int[] result = new int[num.length];

      int index;
      for(int n = num.length; i < 2 * n - 1; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] < num[i % n]) {
            index = (Integer)stack.pop();
            result[index] = num[i % n];
         }

         stack.push(i % n);
      }

      while(!stack.isEmpty()) {
         index = (Integer)stack.pop();
         result[index] = -1;
      }

      return result;
   }

   public static int[] nextLargestElementCircularBook(int[] num) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[num.length];
      int n = num.length;

      for(int i = 2 * n - 1; i >= 0; --i) {
         int curr = num[i % n];

         while(!stack.isEmpty() && num[(Integer)stack.peek()] <= curr) {
            stack.pop();
         }

         if (i < n) {
            if (!stack.isEmpty()) {
               result[i] = num[(Integer)stack.peek()];
            } else {
               result[i] = -1;
            }
         }

         stack.push(i % n);
      }

      return result;
   }

   public static int[] printNGE(int[] arr) {
      Stack<Integer> stack = new Stack();
      int n = arr.length;
      int[] result = new int[n];

      for(int i = 2 * n - 1; i >= 0; --i) {
         while(!stack.isEmpty() && arr[i % n] >= (Integer)stack.peek()) {
            stack.pop();
         }

         if (i < n) {
            if (!stack.isEmpty()) {
               result[i] = (Integer)stack.peek();
            } else {
               result[i] = -1;
            }
         }

         stack.push(arr[i % n]);
      }

      return result;
   }

   public static int[] nextLargestElementCircular_self(int[] num) {
      Stack<Integer> stack = new Stack();
      int n = num.length;
      int[] result = new int[n];

      for(int i = 2 * n - 1; i >= 0; --i) {
         while(!stack.empty() && num[(Integer)stack.peek()] <= num[i % n]) {
            stack.pop();
         }

         if (i < n) {
            if (!stack.isEmpty()) {
               result[i % n] = num[(Integer)stack.peek()];
            } else {
               result[i % n] = -1;
            }
         }

         stack.push(i % n);
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{20, 19, 10, 21, 40, 35, 39, 50, 45, 42};
      System.out.println(Arrays.toString(nextLargestElementCircular_self(num)));
   }
}
