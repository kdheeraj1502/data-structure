package backtracking;

public class mcolouring {
   public static void main(String[] args) {
      int[][] adj = new int[][]{{0, 1, 1}, {1, 0, 1}, {1, 1, 0}};
      System.out.println(color(adj, 0, 4, new int[adj.length]));
   }

   public static boolean color(int[][] adj, int src, int m, int[] nbrcolr) {
      if (src == adj.length) {
         return true;
      } else {
         for(int i = 1; i <= m; ++i) {
            if (check(adj, src, i, nbrcolr)) {
               nbrcolr[src] = i;
               if (color(adj, src + 1, m, nbrcolr)) {
                  return true;
               }

               nbrcolr[src] = 0;
            }
         }

         return false;
      }
   }

   private static boolean check(int[][] adj, int src, int col, int[] nbrcolr) {
      for(int j = 0; j < adj.length; ++j) {
         if (adj[src][j] == 1 && nbrcolr[j] == col) {
            return false;
         }
      }

      return true;
   }
}
