package array;

import java.util.ArrayList;
import java.util.Arrays;

public class mergeintervals {
   public static void main(String[] args) {
      int[][] arr = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}, {2, 4}};
      int[][] ans = mergeintervals(arr);

      for(int i = 0; i < ans.length; ++i) {
         for(int j = 0; j < ans[0].length; ++j) {
            System.out.print(ans[i][j]);
            System.out.print(" ");
         }

         System.out.println();
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
