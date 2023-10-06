package graphs;

public class floydwarshall {
   public static void floydwarshall() {
      int[][] graph = new int[][]{{0, 3, 10000, 7}, {8, 0, 2, 10000}, {10000, 10000, 0, 1}, {2, 10000, 10000, 0}};
      int V = 4;
      int[][] dist = new int[V][V];

      int i;
      int i;
      for(i = 0; i < dist.length; ++i) {
         for(i = 0; i < dist[0].length; ++i) {
            dist[i][i] = graph[i][i];
         }
      }

      for(i = 0; i < V; ++i) {
         for(i = 0; i < V; ++i) {
            for(int j = 0; j < V; ++j) {
               int oc = dist[i][j];
               int nc = dist[i][i] + dist[i][j];
               if (nc < oc) {
                  dist[i][j] = nc;
               }
            }
         }
      }

      for(i = 0; i < dist.length; ++i) {
         for(i = 0; i < dist.length; ++i) {
            System.out.print(dist[i][i] + " ");
         }

         System.out.println();
      }

   }

   public static void main(String[] args) {
      floydwarshall();
   }
}
