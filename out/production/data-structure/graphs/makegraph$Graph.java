package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class makegraph$Graph {
   HashMap<String, HashMap<String, Integer>> vtces = new HashMap();

   makegraph$Graph() {
   }

   public void addvertex(String vname) {
      HashMap<String, Integer> nbr = new HashMap();
      this.vtces.put(vname, nbr);
   }

   public void removevertex(String vname) {
      this.vtces.remove(vname);
   }

   public void addedge(String vname1, String vname2, int cost) {
      HashMap<String, Integer> nbr1 = (HashMap)this.vtces.get(vname1);
      HashMap<String, Integer> nbr2 = (HashMap)this.vtces.get(vname2);
      if (nbr1 != null && nbr2 != null && !nbr1.containsKey(vname2)) {
         nbr1.put(vname2, cost);
      } else {
         System.out.println("vertex not present or edge alrady present");
      }
   }

   public boolean containsedge(String v1, String v2) {
      if (this.vtces.containsKey(v1) && this.vtces.containsKey(v2)) {
         HashMap<String, Integer> nbr = (HashMap)this.vtces.get(v1);
         return nbr == null ? false : nbr.containsKey(v2);
      } else {
         return false;
      }
   }

   public void diplay() {
      ArrayList<String> vertex = new ArrayList(this.vtces.keySet());
      System.out.println("--------------------------------");
      Iterator var2 = vertex.iterator();

      while(var2.hasNext()) {
         String string = (String)var2.next();
         HashMap<String, Integer> nbr = (HashMap)this.vtces.get(string);
         System.out.println(string + " : " + nbr);
      }

      System.out.println("--------------------------------");
   }

   public void bfs(String src, String dest) {
      LinkedList<makegraph.Graph.pair> queue = new LinkedList();
      String path = "";
      HashMap<String, Boolean> map = new HashMap();
      queue.addLast(new makegraph.Graph.pair(this, src, path + src));

      while(!queue.isEmpty()) {
         makegraph.Graph.pair rv = (makegraph.Graph.pair)queue.removeFirst();
         if (!map.containsKey(rv.vname)) {
            map.put(rv.vname, true);
            if (this.containsedge(rv.vname, dest)) {
               System.out.println(rv.path + dest);
               break;
            }

            ArrayList<String> nbr = new ArrayList(((HashMap)this.vtces.get(rv.vname)).keySet());
            Iterator var8 = nbr.iterator();

            while(var8.hasNext()) {
               String string = (String)var8.next();
               queue.addLast(new makegraph.Graph.pair(this, string, rv.path + string));
            }
         }
      }

   }

   public void BFT() {
      LinkedList<makegraph.Graph.pair> queue = new LinkedList();
      ArrayList<String> keys = new ArrayList(this.vtces.keySet());
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
         queue.addLast(new makegraph.Graph.pair(this, string, path + string));

         while(true) {
            makegraph.Graph.pair rv;
            String vname;
            do {
               if (queue.isEmpty()) {
                  continue label41;
               }

               rv = (makegraph.Graph.pair)queue.removeFirst();
               vname = rv.vname;
            } while(map.containsKey(vname));

            map.put(vname, true);
            System.out.println(vname + " via " + rv.path);
            HashMap<String, Integer> nbr = (HashMap)this.vtces.get(vname);
            ArrayList<String> keys1 = new ArrayList(nbr.keySet());
            Iterator var11 = keys1.iterator();

            while(var11.hasNext()) {
               String string1 = (String)var11.next();
               if (!map.containsKey(string1)) {
                  queue.addLast(new makegraph.Graph.pair(this, string1, rv.path + string1));
               }
            }
         }
      }
   }
}
