package array;

import java.util.Stack;

public class NextGreatNumberInArray {
   public static void nextGreatNumber(int[] num) {
      Stack<Integer> stack = new Stack();
      int[] result = new int[num.length];

      int i;
      for(i = num.length - 1; i >= 0; --i) {
         if (!stack.empty()) {
            while(!stack.empty() && (Integer)stack.peek() <= num[i]) {
               stack.pop();
            }
         }

         result[i] = stack.empty() ? -1 : (Integer)stack.peek();
         stack.push(num[i]);
      }

      for(i = 0; i < num.length; ++i) {
         System.out.println(num[i] + " --> " + result[i]);
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{11, 13, 21, 3};
      nextGreatNumber(num);
   }
}
