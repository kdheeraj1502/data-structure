package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class travellingsalesman {
   public static void main(String[] args) {
      HashMap<String, Boolean> map = new HashMap();
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addedge("0", "1", 20);
      graph.addedge("0", "2", 42);
      graph.addedge("0", "3", 25);
      graph.addedge("1", "0", 20);
      graph.addedge("1", "2", 30);
      graph.addedge("1", "3", 34);
      graph.addedge("2", "0", 42);
      graph.addedge("2", "1", 30);
      graph.addedge("2", "3", 10);
      graph.addedge("3", "0", 25);
      graph.addedge("3", "1", 34);
      graph.addedge("3", "2", 10);
      graph.diplay();
      hc(graph.vtces, map, "0", "0", "0", 0);
   }

   public static void hc(HashMap<String, HashMap<String, Integer>> vtces, HashMap<String, Boolean> map, String src, String psf, String osrc, int wt) {
      HashMap nbr;
      ArrayList nbrlist;
      if (map.size() != vtces.size() - 1) {
         map.put(src, true);
         nbr = (HashMap)vtces.get(src);
         nbrlist = new ArrayList(nbr.keySet());
         Iterator var11 = nbrlist.iterator();

         while(var11.hasNext()) {
            String string = (String)var11.next();
            if (!map.containsKey(string)) {
               hc(vtces, map, string, psf + string, osrc, wt + (Integer)nbr.get(string));
            }
         }

         map.remove(src);
      } else {
         nbr = (HashMap)vtces.get(src);
         nbrlist = new ArrayList(nbr.keySet());
         boolean flag = false;
         Iterator var9 = nbrlist.iterator();

         while(var9.hasNext()) {
            String string = (String)var9.next();
            if (string == osrc) {
               flag = true;
               break;
            }
         }

         System.out.print(psf);
         if (flag) {
            System.out.println(" * @" + (wt + (Integer)nbr.get(osrc)));
         } else {
            System.out.println(".");
         }

      }
   }
}
