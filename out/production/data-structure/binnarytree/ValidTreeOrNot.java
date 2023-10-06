package binnarytree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidTreeOrNot {
   public boolean validTree(int n, int[][] edges) {
      List<List<Integer>> list = new ArrayList();

      for(int i = 0; i < n; ++i) {
         list.add(new ArrayList());
      }

      int[][] var10 = edges;
      int var5 = edges.length;

      int id;
      for(id = 0; id < var5; ++id) {
         int[] edge = var10[id];
         ((List)list.get(edge[0])).add(edge[1]);
         ((List)list.get(edge[1])).add(edge[0]);
      }

      boolean[] visited = new boolean[n];
      Queue<Integer> queue = new LinkedList();
      queue.offer(0);

      int neighbor;
      while(!queue.isEmpty()) {
         id = (Integer)queue.poll();
         if (visited[id]) {
            return false;
         }

         visited[id] = true;
         Iterator var14 = ((List)list.get(id)).iterator();

         while(var14.hasNext()) {
            neighbor = (Integer)var14.next();
            if (!visited[neighbor]) {
               queue.offer(neighbor);
            }
         }
      }

      boolean[] var13 = visited;
      int var15 = visited.length;

      for(neighbor = 0; neighbor < var15; ++neighbor) {
         boolean b = var13[neighbor];
         if (!b) {
            return false;
         }
      }

      return true;
   }
}
