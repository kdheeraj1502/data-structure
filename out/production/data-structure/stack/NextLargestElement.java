package stack;

import java.util.Stack;

public class NextLargestElement {
   public static void nextLargestElement_stack(int[] num) {
      Stack<Integer> stack = new Stack();
      int index = true;
      int[] result = new int[num.length];

      int index;
      for(int i = 0; i < num.length; ++i) {
         for(int curr = num[i]; !stack.isEmpty() && num[(Integer)stack.peek()] <= curr; result[index] = curr) {
            index = (Integer)stack.pop();
         }

         stack.push(i);
      }

      while(!stack.isEmpty()) {
         index = (Integer)stack.pop();
         result[index] = -1;
      }

      int[] var10 = result;
      int var6 = result.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         int val = var10[var7];
         System.out.print(val + " ");
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{20, 19, 10, 21, 40, 35, 39, 50, 45, 42};
      nextLargestElement_stack(num);
   }
}
