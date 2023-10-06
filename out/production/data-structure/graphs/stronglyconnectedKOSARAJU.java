package graphs;

import java.util.Arrays;
import java.util.LinkedList;

public class stronglyconnectedKOSARAJU {
   public static void main(String[] args) {
      int[][] adj = new int[][]{{0, 1, 1}, {0, 0, 1}, {0, 0, 0}};
      kosaraju(adj);
   }

   public static void kosaraju(int[][] adj) {
      int[] vis = new int[adj.length];
      LinkedList<Integer> st = new LinkedList();

      int c;
      for(c = 0; c < adj.length; ++c) {
         if (vis[c] == 0) {
            dfs(vis, adj, c, st);
         }
      }

      int src;
      for(c = 0; c < adj.length; ++c) {
         for(src = c + 1; src < adj[0].length; ++src) {
            int temp = adj[c][src];
            adj[c][src] = adj[src][c];
            adj[src][c] = temp;
         }
      }

      Arrays.fill(vis, 0);
      c = 0;

      while(!st.isEmpty()) {
         src = (Integer)st.removeFirst();
         if (vis[src] == 0) {
            ++c;
            dfs2(vis, adj, src);
         }
      }

      System.out.println(c);
   }

   public static void dfs(int[] visited, int[][] adj, int src, LinkedList<Integer> st) {
      visited[src] = 1;
      int[] nbr = adj[src];

      for(int i = 0; i < nbr.length; ++i) {
         if (nbr[i] == 1 && visited[i] == 0) {
            dfs(visited, adj, i, st);
         }
      }

      st.addFirst(src);
   }

   public static void dfs2(int[] visited, int[][] adj, int src) {
      visited[src] = 1;
      int[] nbr = adj[src];

      for(int i = 0; i < nbr.length; ++i) {
         if (nbr[i] == 1 && visited[i] == 0) {
            dfs2(visited, adj, i);
         }
      }

   }
}
