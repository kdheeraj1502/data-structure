package stack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class NextSmallestElement {
   public static int[] nextSmallestELement(int[] num) {
      Stack<Integer> stack = new Stack();
      int i = false;
      int[] result = new int[num.length];

      int val;
      for(int i = 0; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] >= num[i]) {
            val = (Integer)stack.pop();
            result[val] = num[i];
         }

         stack.push(i);
      }

      while(!stack.isEmpty()) {
         val = (Integer)stack.pop();
         result[val] = -1;
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{20, 19, 10, 21, 40, 35, 39, 50, 45, 34};
      int[] result = nextSmallestELement(num);
      Map<Integer, Integer> map = new LinkedHashMap();

      for(int i = 0; i < num.length; ++i) {
         map.put(num[i], result[i]);
      }

      System.out.println(map);
   }
}
