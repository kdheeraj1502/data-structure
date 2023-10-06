package binary.search;

import java.util.Stack;

public class WaterTrapping {
   public static int waterTrapping(int[] num) {
      Stack<Integer> stack = new Stack();
      int currMax = 0;

      for(int i = 0; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] < num[i]) {
            int minus = num[(Integer)stack.peek()];
            stack.pop();
            if (stack.isEmpty()) {
               break;
            }

            int dis = i - (Integer)stack.peek() - 1;
            int height = Math.min(num[(Integer)stack.peek()], num[i]) - minus;
            currMax += height * dis;
         }

         stack.push(i);
      }

      return currMax;
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, 0, 1, 5};
      System.out.println(waterTrapping(num));
   }
}
