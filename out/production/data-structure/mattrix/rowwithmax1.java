package mattrix;

public class rowwithmax1 {
   public static void main(String[] args) {
      int[][] m = new int[][]{{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
      System.out.println(maxone(m));
   }

   public static int maxone(int[][] m) {
      int r = 0;
      int c = 0;

      while(c < m[0].length) {
         if (m[r][c] == 1) {
            return r;
         }

         ++r;
         if (r == m.length) {
            r = 0;
            ++c;
         }
      }

      return -1;
   }
}
