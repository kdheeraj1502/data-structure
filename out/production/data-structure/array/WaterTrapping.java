package array;

import java.util.Stack;

public class WaterTrapping {
   public static int trap_book(int[] num) {
      int water = 0;
      int[] leftHeight = new int[num.length];
      int[] rightHeight = new int[num.length];
      leftHeight[0] = num[0];
      rightHeight[num.length - 1] = num[num.length - 1];
      int max = num[0];

      int i;
      for(i = 1; i < num.length; ++i) {
         if (max < num[i]) {
            max = num[i];
         }

         leftHeight[i] = max;
      }

      max = num[num.length - 1];

      for(i = num.length - 2; i >= 0; --i) {
         if (max < num[i]) {
            max = num[i];
         }

         rightHeight[i] = max;
      }

      for(i = 0; i < num.length; ++i) {
         water += Math.min(leftHeight[i], rightHeight[i]) - num[i];
      }

      return water;
   }

   public static int trap_self(int[] num) {
      int area = 0;
      Stack<Integer> stack = new Stack();

      for(int i = 0; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] < num[i]) {
            int remove = (Integer)stack.peek();
            stack.pop();
            if (stack.isEmpty()) {
               break;
            }

            int dis = i - (Integer)stack.peek() - 1;
            int h = Math.min(num[i], num[(Integer)stack.peek()]) - num[remove];
            area += h * dis;
         }

         stack.push(i);
      }

      return area;
   }

   public static int trap(int[] num) {
      Stack<Integer> stack = new Stack();
      int ans = 0;

      for(int i = 0; i < num.length; ++i) {
         while(!stack.isEmpty() && num[(Integer)stack.peek()] < num[i]) {
            int h = num[(Integer)stack.peek()];
            stack.pop();
            if (stack.isEmpty()) {
               break;
            }

            int distance = i - (Integer)stack.peek() - 1;
            int min_height = Math.min(num[(Integer)stack.peek()], num[i]) - h;
            ans += distance * min_height;
         }

         stack.push(i);
      }

      return ans;
   }

   public static int trapRainWater(int[][] heightMap) {
      int area = 0;
      if (heightMap.length >= 3 && heightMap.length >= 2 && heightMap.length >= 1) {
         for(int i = 1; i < heightMap.length - 1; ++i) {
            area += trap(heightMap[i]);
         }

         return area;
      } else {
         return 0;
      }
   }

   public static void main(String[] args) {
      int[] height = new int[]{4, 0, 1, 5};
      System.out.println(trap_book(height));
   }
}
