package stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class StockAnalystProblem {
   public static List<Integer> nextLargerEle(int[] num) {
      List<Integer> result = new ArrayList();
      Stack<Integer> stack = new Stack();
      int i = 1;
      stack.push(num[0]);

      for(; i < num.length; ++i) {
         if ((Integer)stack.peek() <= num[i]) {
            stack.push(num[i]);
         }
      }

      Iterator<Integer> it = stack.iterator();

      while(it.hasNext()) {
         result.add(it.next());
      }

      return result;
   }

   public static void nextLargestElement(int[] num) {
      int[] output = new int[num.length];
      int index = 0;

      int j;
      for(int i = 0; i < num.length; ++i) {
         int next = -1;

         for(j = i + 1; j < num.length; ++j) {
            if (num[i] < num[j]) {
               next = num[j];
               break;
            }
         }

         output[index++] = next;
      }

      int[] var8 = output;
      j = output.length;

      for(int var6 = 0; var6 < j; ++var6) {
         int val = var8[var6];
         System.out.print(val + " ");
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{20, 19, 10, 21, 40, 35, 39, 50, 45, 42};
      nextLargestElement(num);
   }
}
