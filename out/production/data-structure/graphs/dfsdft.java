package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class dfsdft {
   public static void DFT(HashMap<String, HashMap<String, Integer>> vtces) {
      LinkedList<pair> stack = new LinkedList();
      ArrayList<String> keys = new ArrayList(vtces.keySet());
      HashMap<String, Boolean> map = new HashMap();
      Iterator var4 = keys.iterator();

      label41:
      while(true) {
         String string;
         do {
            if (!var4.hasNext()) {
               return;
            }

            string = (String)var4.next();
         } while(map.containsKey(string));

         String path = "";
         stack.addFirst(new pair(string, path + string));

         while(true) {
            pair rv;
            String vname;
            do {
               if (stack.isEmpty()) {
                  continue label41;
               }

               rv = (pair)stack.removeFirst();
               vname = rv.vname;
            } while(map.containsKey(vname));

            map.put(vname, true);
            System.out.println(vname + " via " + rv.path);
            HashMap<String, Integer> nbr = (HashMap)vtces.get(vname);
            ArrayList<String> keys1 = new ArrayList(nbr.keySet());
            Iterator var11 = keys1.iterator();

            while(var11.hasNext()) {
               String string1 = (String)var11.next();
               if (!map.containsKey(string1)) {
                  stack.addFirst(new pair(string1, rv.path + string1));
               }
            }
         }
      }
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
      graph.addvertex("7");
      graph.addvertex("8");
      graph.addedge("0", "2", 1);
      graph.addedge("0", "5", 1);
      graph.addedge("1", "5", 1);
      graph.addedge("1", "6", 1);
      graph.addedge("1", "8", 1);
      graph.addedge("3", "4", 1);
      graph.addedge("3", "5", 1);
      graph.addedge("4", "7", 1);
      graph.addedge("5", "7", 1);
      graph.diplay();
      System.out.println();
      DFT(graph.vtces);
   }
}
