package strings;

public class Word_Wrap {
   final int MAX = Integer.MAX_VALUE;

   int printSolution(int[] p, int n) {
      int k;
      if (p[n] == 1) {
         k = 1;
      } else {
         k = this.printSolution(p, p[n] - 1) + 1;
      }

      System.out.println("Line number " + k + ": From word no. " + p[n] + " to " + n);
      return k;
   }

   void solveWordWrap(int[] words, int len, int maxSize) {
      int[][] extras = new int[len + 1][len + 1];
      int[][] lineCost = new int[len + 1][len + 1];
      int[] totalCost = new int[len + 1];

      int i;
      int j;
      for(i = 1; i <= len; ++i) {
         extras[i][i] = maxSize - words[i - 1];

         for(j = i + 1; j <= len; ++j) {
            extras[i][j] = extras[i][j - 1] - words[j - 1] - 1;
         }
      }

      for(i = 1; i <= len; ++i) {
         for(j = i; j <= len; ++j) {
            if (extras[i][j] < 0) {
               lineCost[i][j] = Integer.MAX_VALUE;
            } else if (j == len && extras[i][j] >= 0) {
               lineCost[i][j] = 0;
            } else {
               lineCost[i][j] = extras[i][j] * extras[i][j];
            }
         }
      }

      int[] result = new int[len + 1];
      totalCost[0] = 0;

      for(j = 1; j <= len; ++j) {
         totalCost[j] = Integer.MAX_VALUE;

         for(int i = 1; i <= j; ++i) {
            if (totalCost[i - 1] != Integer.MAX_VALUE && lineCost[i][j] != Integer.MAX_VALUE && totalCost[i - 1] + lineCost[i][j] < totalCost[j]) {
               totalCost[j] = totalCost[i - 1] + lineCost[i][j];
               result[j] = i;
            }
         }
      }

      this.printSolution(result, len);
   }

   public static void main(String[] args) {
      Word_Wrap w = new Word_Wrap();
      int[] l = new int[]{3, 2, 2, 5};
      int n = l.length;
      int M = 6;
      w.solveWordWrap(l, n, M);
   }
}
