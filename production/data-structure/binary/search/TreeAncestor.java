package binary.search;

public class TreeAncestor {
   int[][] binaryParents;
   int LOG;

   public TreeAncestor(int n, int[] parent) {
      int log;
      for(log = 0; 1 << log < n; ++log) {
      }

      this.LOG = log + 1;
      this.binaryParents = new int[n][log + 1];

      int j;
      for(j = 0; j < n; ++j) {
         this.binaryParents[j][0] = parent[j];
      }

      for(j = 1; j < this.LOG; ++j) {
         for(int i = 0; i < n; ++i) {
            if (this.binaryParents[i][j - 1] == -1) {
               this.binaryParents[i][j] = -1;
            } else {
               this.binaryParents[i][j] = this.binaryParents[this.binaryParents[i][j - 1]][j - 1];
            }
         }
      }

   }

   public int getKthAncestor(int node, int k) {
      for(int log = 0; log < this.LOG && node >= 0; ++log) {
         if ((k & 1 << log) != 0) {
            node = this.binaryParents[node][log];
         }
      }

      return node;
   }

   public static void main(String[] args) {
      String[] var10000 = new String[]{"TreeAncestor", "getKthAncestor", "getKthAncestor", "getKthAncestor"};
   }
}
