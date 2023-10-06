package array;

import java.util.Stack;

public class NextGreaterNumberInCircularArray {
   public static void nextGreatNumber(int[] num, int len) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[len];
      int i = false;

      int i;
      for(i = 0; i < len; ++i) {
         result[i] = -1;
      }

      for(i = 0; i < 2 * len; ++i) {
         while(!stack.isEmpty() && num[i % len] > num[(Integer)stack.peek()]) {
            result[(Integer)stack.peek()] = num[i % len];
            stack.pop();
         }

         stack.push(i % len);
      }

      for(i = 0; i < len; ++i) {
         System.out.print(result[i] + " ");
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{11, 13, 21, 3};
      int N = num.length;
      nextGreatNumber(num, N);
   }

   public static void nextGreatNumberSelf(int[] num, int len) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[num.length];
      int i = false;

      int i;
      for(i = 0; i < num.length; ++i) {
         result[i] = -1;
      }

      while(i < 2 * num.length) {
         while(!stack.isEmpty() && num[i % num.length] > num[(Integer)stack.peek()]) {
            result[i % num.length] = num[(Integer)stack.peek()];
         }

         stack.push(i % num.length);
         ++i;
      }

      for(i = 0; i < len; ++i) {
         System.out.print(result[i] + " ");
      }

   }
}
