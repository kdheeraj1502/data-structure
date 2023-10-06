package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class bipertite {
   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addedge("0", "1", 1);
      graph.addedge("0", "2", 1);
      System.out.println(bipertite(graph.vtces));
   }

   public static boolean bipertite(HashMap<String, HashMap<String, Integer>> vtces) {
      LinkedList<pair> queue = new LinkedList();
      HashMap<String, Integer> map = new HashMap();
      ArrayList<String> vnamelist = new ArrayList(vtces.keySet());
      Iterator var4 = vnamelist.iterator();

      label46:
      while(true) {
         String string;
         do {
            if (!var4.hasNext()) {
               return true;
            }

            string = (String)var4.next();
         } while(map.containsKey(string));

         queue.addFirst(new pair(string, 1));

         int oc;
         int nc;
         do {
            while(true) {
               if (queue.isEmpty()) {
                  continue label46;
               }

               pair rv = (pair)queue.removeFirst();
               if (map.containsKey(rv.vname)) {
                  oc = (Integer)map.get(rv.vname);
                  nc = rv.color;
                  break;
               }

               map.put(rv.vname, rv.color);
               HashMap<String, Integer> nbr = (HashMap)vtces.get(rv.vname);
               ArrayList<String> nbrvnamelist = new ArrayList(nbr.keySet());
               Iterator var9 = nbrvnamelist.iterator();

               while(var9.hasNext()) {
                  String string2 = (String)var9.next();
                  int nc = 1;
                  if (rv.color == 1) {
                     nc = 2;
                  }

                  if (!map.containsKey(string2)) {
                     queue.addLast(new pair(string2, nc));
                  }
               }
            }
         } while(oc == nc);

         return false;
      }
   }
}
