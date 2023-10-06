package strings;

public class WordWrap_13 {
   public static void main(String[] args) {
      int[] arr = new int[]{3, 2, 2, 5};
      wordwrap(arr, 4, 6);
   }

   static int printSolution(int[] p, int n) {
      int k;
      if (p[n] == 1) {
         k = 1;
      } else {
         k = printSolution(p, p[n] - 1) + 1;
      }

      System.out.println("Line number " + k + ": From word no. " + p[n] + " to " + n);
      return k;
   }

   public static void wordwrap(int[] arr, int n, int tc) {
      int[][] extraspace = new int[n + 1][n + 1];

      int i;
      for(int i = 1; i <= n; ++i) {
         extraspace[i][i] = tc - arr[i - 1];

         for(i = i + 1; i <= n; ++i) {
            extraspace[i][i] = extraspace[i][i - 1] - arr[i - 1] - 1;
         }
      }

      System.out.println();
      System.out.println();
      int[][] lc = new int[n + 1][n + 1];

      for(i = 1; i < lc.length; ++i) {
         for(int j = 1; j < lc.length; ++j) {
            if (extraspace[i][j] < 0) {
               lc[i][j] = Integer.MAX_VALUE;
            } else if (j == n && extraspace[i][j] >= 0) {
               lc[i][j] = 0;
            } else {
               lc[i][j] = extraspace[i][j] * extraspace[i][j];
            }
         }
      }

      int[] c = new int[n + 1];
      int[] p = new int[n + 1];
      c[0] = 0;

      int i;
      for(i = 1; i <= n; ++i) {
         c[i] = Integer.MAX_VALUE;

         for(int j = 1; j <= i; ++j) {
            if (c[j - 1] != Integer.MAX_VALUE && lc[j][i] != Integer.MAX_VALUE && c[j - 1] + lc[j][i] < c[i]) {
               c[i] = c[j - 1] + lc[j][i];
               p[i] = j;
            }
         }
      }

      System.out.println();

      for(i = 0; i < c.length; ++i) {
         System.out.print(c[i] + " ");
      }

      System.out.println();
      System.out.println();

      for(i = 0; i < p.length; ++i) {
         System.out.print(p[i] + " ");
      }

      System.out.println();
      System.out.println();
      System.out.println(printSolution(p, n));
   }
}
