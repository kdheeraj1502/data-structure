package mattrix;

import java.util.Stack;

public class maxsizerectangle {
   public static void main(String[] args) {
      int[][] m = new int[][]{{0, 1, 1, 0}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 0, 0}};
      maxrectanglearea(m);
   }

   public static void maxrectanglearea(int[][] m) {
      int[] arr = m[0];
      int maxarea = maxhistogramarea(arr);

      for(int i = 1; i < m.length; ++i) {
         int area;
         for(area = 0; area < m[0].length; ++area) {
            if (m[i][area] == 0) {
               arr[area] = 0;
            } else {
               int var10002 = arr[area]++;
            }
         }

         area = maxhistogramarea(arr);
         if (area > maxarea) {
            maxarea = area;
         }
      }

      System.out.println(maxarea);
   }

   public static int maxhistogramarea(int[] arr) {
      Stack<Integer> stackleft = new Stack();
      stackleft.push(0);
      int[] left = new int[arr.length];
      left[0] = -1;

      for(int i = 1; i < arr.length; ++i) {
         while(stackleft.size() > 0 && arr[i] <= arr[(Integer)stackleft.peek()]) {
            stackleft.pop();
         }

         if (stackleft.size() == 0) {
            left[i] = -1;
         } else {
            left[i] = (Integer)stackleft.peek();
         }

         stackleft.push(i);
      }

      Stack<Integer> stackright = new Stack();
      stackright.push(arr.length - 1);
      int[] right = new int[arr.length];
      right[right.length - 1] = right.length;

      int maxarea;
      for(maxarea = right.length - 2; maxarea >= 0; --maxarea) {
         while(stackright.size() > 0 && arr[maxarea] <= arr[(Integer)stackright.peek()]) {
            stackright.pop();
         }

         if (stackright.size() == 0) {
            right[maxarea] = arr.length;
         } else {
            right[maxarea] = (Integer)stackright.peek();
         }

         stackright.push(maxarea);
      }

      maxarea = 0;

      for(int i = 0; i < right.length; ++i) {
         int width = right[i] - left[i] - 1;
         int area = arr[i] * width;
         if (maxarea < area) {
            maxarea = area;
         }
      }

      return maxarea;
   }
}
