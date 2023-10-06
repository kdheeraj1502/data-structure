package mattrix;

public class rotate {
   public static void main(String[] args) {
      int[][] m = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
      rotate(m);
   }

   public static void rotate(int[][] m) {
      int i;
      int k;
      for(i = 0; i < m.length; ++i) {
         int l;
         for(k = i; k < m[0].length; ++k) {
            l = m[i][k];
            m[i][k] = m[k][i];
            m[k][i] = l;
         }

         k = 0;

         for(l = m[0].length - 1; k <= l; --l) {
            int temp = m[i][k];
            m[i][k] = m[i][l];
            m[i][l] = temp;
            ++k;
         }
      }

      for(i = 0; i < m.length; ++i) {
         for(k = 0; k < m[0].length; ++k) {
            System.out.print(m[i][k] + " ");
         }

         System.out.println();
      }

   }
}
