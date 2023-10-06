package graphs;

import java.util.Iterator;
import java.util.List;

public class mcoluringproblem {
   public static void main(String[] args) {
   }

   public static boolean graphColoring(List<Integer>[] G, int[] color, int i, int C) {
      int[] vtcescolor = new int[G.length];
      vtcescolor[0] = 0;

      int cn;
      for(cn = 0; cn < vtcescolor.length; ++cn) {
         vtcescolor[cn] = -1;
      }

      cn = 0;

      for(int i1 = 0; i1 < G.length; ++i1) {
         boolean[] colornotavail = new boolean[G.length];
         List<Integer> nbrv = G[i1];
         Iterator var9 = nbrv.iterator();

         while(var9.hasNext()) {
            Integer s = (Integer)var9.next();
            if (vtcescolor[s] > -1) {
               colornotavail[s] = true;
            }
         }

         for(int j = 0; j < colornotavail.length; ++j) {
            if (!colornotavail[j]) {
               vtcescolor[i1] = j;
               cn = Math.max(cn, j + 1);
               break;
            }
         }
      }

      if (cn <= C) {
         return true;
      } else {
         return false;
      }
   }
}
