package graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class journeytomoon {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      long n = scn.nextLong();
      int p = scn.nextInt();

      ArrayList list;
      for(list = new ArrayList(); p > 0; --p) {
         ArrayList<Integer> a = new ArrayList();
         int u = scn.nextInt();
         int v = scn.nextInt();
         a.add(u);
         a.add(v);
         list.add(a);
      }

      System.out.println(journeyToMoon(n, list));
   }

   public static long journeyToMoon(long n, ArrayList<ArrayList<Integer>> list) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList();

      int i;
      ArrayList componentsize;
      for(i = 0; (long)i < n; ++i) {
         componentsize = new ArrayList();
         adj.add(componentsize);
      }

      int i;
      int c;
      for(i = 0; i < list.size(); ++i) {
         componentsize = (ArrayList)list.get(i);
         i = (Integer)componentsize.get(0);
         c = (Integer)componentsize.get(1);
         ((ArrayList)adj.get(i)).add(c);
         ((ArrayList)adj.get(c)).add(i);
      }

      HashSet<Integer> map = new HashSet();
      componentsize = new ArrayList();

      for(i = 0; (long)i < n; ++i) {
         if (!map.contains(i)) {
            int c = false;
            c = dfs(adj, map, i);
            componentsize.add(c);
         }
      }

      long totalpairs = n * (n - 1L) / 2L;
      System.out.println(totalpairs);

      for(int i = 0; i < componentsize.size(); ++i) {
         long x = (long)(Integer)componentsize.get(i);
         totalpairs -= x * (x - 1L) / 2L;
      }

      return totalpairs;
   }

   public static int dfs(ArrayList<ArrayList<Integer>> list, HashSet<Integer> map, int src) {
      if (map.contains(src)) {
         return 0;
      } else {
         map.add(src);
         ArrayList<Integer> nbr = (ArrayList)list.get(src);
         int c = 1;

         for(int i = 0; i < nbr.size(); ++i) {
            int a = (Integer)nbr.get(i);
            if (!map.contains(a)) {
               c += dfs(list, map, a);
            }
         }

         return c;
      }
   }
}
