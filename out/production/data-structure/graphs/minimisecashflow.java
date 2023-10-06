package graphs;

import java.util.PriorityQueue;

public class minimisecashflow {
   public static void main(String[] args) {
      int[][] edges = new int[][]{{0, 1, 1000}, {0, 2, 2000}, {1, 2, 5000}};
      cashflow(edges, 8);
   }

   public static void cashflow(int[][] edges, int n) {
      int[] netvaluearr = new int[]{300, 100, 700, 0, -100, -200, -400, -400};

      for(int i = 0; i < netvaluearr.length; ++i) {
         System.out.println(netvaluearr[i]);
      }

      PriorityQueue<pair> posheap = new PriorityQueue();
      PriorityQueue<pair> negheap = new PriorityQueue();

      for(int i = 0; i < netvaluearr.length; ++i) {
         if (netvaluearr[i] > 0) {
            posheap.add(new pair(i, netvaluearr[i]));
         } else if (netvaluearr[i] < 0) {
            negheap.add(new pair(i, -netvaluearr[i]));
            netvaluearr[i] *= -1;
         }
      }

      int[][] newedge = new int[n][3];
      int i = 0;

      while(!posheap.isEmpty() && !negheap.isEmpty()) {
         pair max = (pair)posheap.remove();
         pair min = (pair)negheap.remove();
         int[] arr = new int[]{min.vname, max.vname, Math.min(max.cost, min.cost)};
         newedge[i++] = arr;
         netvaluearr[arr[0]] -= arr[2];
         netvaluearr[arr[1]] -= arr[2];
         if (max.cost > min.cost) {
            posheap.add(new pair(max.vname, netvaluearr[max.vname]));
         } else if (max.cost < min.cost) {
            negheap.add(new pair(min.vname, netvaluearr[min.vname]));
         }
      }

      for(int j = 0; j < newedge.length; ++j) {
         int u = newedge[j][0];
         int v = newedge[j][1];
         int c = newedge[j][2];
         if (c != 0) {
            System.out.println(u + " - > " + v + " @ " + c);
         }
      }

   }
}
