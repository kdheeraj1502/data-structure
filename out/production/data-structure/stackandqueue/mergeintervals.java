package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class mergeintervals {
   public static void main(String[] args) {
      int[][] intv = new int[][]{{1, 3}, {2, 4}, {5, 7}, {6, 8}};
      merge(intv);
   }

   public static void merge(int[][] intv) {
      pair[] arr = new pair[intv.length];

      for(int i = 0; i < intv.length; ++i) {
         arr[i] = new pair(intv[i][0], intv[i][1]);
      }

      Arrays.parallelSort(arr);
      Stack<pair> st = new Stack();

      pair rv;
      for(int i = 0; i < arr.length; ++i) {
         rv = arr[i];
         if (i == 0) {
            st.push(rv);
         } else {
            pair top = (pair)st.peek();
            if (top.end >= rv.start) {
               if (top.end < rv.end) {
                  top.end = rv.end;
               }
            } else {
               st.push(rv);
            }
         }
      }

      while(st.size() > 0) {
         rv = (pair)st.pop();
         System.out.println(rv.start + " - " + rv.end);
      }

   }

   public static int[][] mergeintervals(int[][] arr) {
      Arrays.sort(arr, (a, b) -> {
         return a[0] - b[0];
      });
      int start = false;
      int end = true;
      ArrayList<int[]> ans = new ArrayList();
      int[] arrres = arr[0];

      for(int i = 1; i < arr.length; ++i) {
         if (arrres[1] >= arr[i][0]) {
            if (arrres[1] <= arr[i][1]) {
               arrres[1] = arr[i][1];
            }
         } else {
            ans.add(arrres);
            arrres = arr[i];
         }
      }

      ans.add(arrres);
      return (int[][])ans.toArray(new int[0][]);
   }
}
