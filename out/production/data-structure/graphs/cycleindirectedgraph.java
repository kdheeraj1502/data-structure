package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class cycleindirectedgraph {
   private static boolean isCyclicUtil(HashMap<String, HashMap<String, Integer>> vtces, String vname, boolean[] visited, boolean[] recStack) {
      int i = Integer.parseInt(vname);
      if (recStack[i]) {
         return true;
      } else if (visited[i]) {
         return false;
      } else {
         visited[i] = true;
         recStack[i] = true;
         HashMap<String, Integer> nbrv = (HashMap)vtces.get(vname);
         ArrayList<String> nbrsvlist = new ArrayList(nbrv.keySet());
         Iterator var7 = nbrsvlist.iterator();

         String c;
         do {
            if (!var7.hasNext()) {
               recStack[i] = false;
               return false;
            }

            c = (String)var7.next();
         } while(!isCyclicUtil(vtces, c, visited, recStack));

         return true;
      }
   }

   public static boolean DFT(HashMap<String, HashMap<String, Integer>> vtces) {
      boolean[] visited = new boolean[vtces.size()];
      boolean[] recStack = new boolean[vtces.size()];
      ArrayList<String> nbrs = new ArrayList(vtces.keySet());
      Iterator var4 = nbrs.iterator();

      String string;
      do {
         if (!var4.hasNext()) {
            return false;
         }

         string = (String)var4.next();
      } while(!isCyclicUtil(vtces, string, visited, recStack));

      return true;
   }

   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addvertex("5");
      graph.addvertex("6");
      graph.addedge("0", "3", 1);
      graph.addedge("0", "1", 1);
      graph.addedge("3", "2", 1);
      graph.addedge("2", "1", 1);
      graph.addedge("4", "5", 1);
      graph.addedge("5", "6", 1);
      graph.addedge("6", "4", 1);
      graph.diplay();
      System.out.println(DFT(graph.vtces));
   }
}
