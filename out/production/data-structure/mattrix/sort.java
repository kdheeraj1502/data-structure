package mattrix;

import java.util.Arrays;

public class sort {
   public static void main(String[] args) {
      int[][] m = new int[][]{{1, 5, 3}, {2, 8, 7}, {4, 6, 9}};
      sort(m);
   }

   public static void sort(int[][] m) {
      int[] temp = new int[m.length * m.length];
      int k = 0;

      int i;
      int j;
      for(i = 0; i < m.length; ++i) {
         for(j = 0; j < m[0].length; ++j) {
            temp[k++] = m[i][j];
         }
      }

      Arrays.sort(temp);
      k = 0;

      for(i = 0; i < m.length; ++i) {
         for(j = 0; j < m[0].length; ++j) {
            m[i][j] = temp[k++];
            System.out.print(m[i][j] + " ");
         }

         System.out.println();
      }

   }
}
