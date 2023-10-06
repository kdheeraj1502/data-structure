package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class chromaticnumber {
   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addedge("0", "1", 1);
      graph.addedge("0", "3", 1);
      graph.addedge("2", "1", 1);
      graph.addedge("2", "3", 1);
      graph.addedge("4", "3", 1);
      graph.addedge("4", "1", 1);
      graph.addedge("4", "0", 1);
      graph.diplay();
      cn(graph.vtces);
   }

   public static void cn(HashMap<String, HashMap<String, Integer>> vtces) {
      int[] vtcescolor = new int[vtces.size()];
      vtcescolor[0] = 0;

      int cn;
      for(cn = 1; cn < vtcescolor.length; ++cn) {
         vtcescolor[cn] = -1;
      }

      cn = 0;

      int i;
      for(i = 1; i < vtces.size(); ++i) {
         boolean[] colornotavail = new boolean[vtces.size()];
         HashMap<String, Integer> nbr = (HashMap)vtces.get(i + "");
         ArrayList<String> nbrv = new ArrayList(nbr.keySet());
         Iterator var7 = nbrv.iterator();

         while(var7.hasNext()) {
            String s = (String)var7.next();
            int n = Integer.parseInt(s);
            if (vtcescolor[n] > -1) {
               colornotavail[n] = true;
            }
         }

         for(int j = 0; j < colornotavail.length; ++j) {
            if (!colornotavail[j]) {
               vtcescolor[i] = j;
               cn = Math.max(cn, j + 1);
               break;
            }
         }
      }

      for(i = 0; i < vtcescolor.length; ++i) {
         System.out.println(vtcescolor[i]);
      }

      System.out.println("cn-----" + cn);
   }
}
