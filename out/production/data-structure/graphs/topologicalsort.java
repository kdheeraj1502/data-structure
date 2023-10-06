package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class topologicalsort {
   public static void topsort(HashMap<String, HashMap<String, Integer>> vtces) {
      HashMap<String, Boolean> map = new HashMap();
      LinkedList<String> st = new LinkedList();
      ArrayList<String> nbrlist = new ArrayList(vtces.keySet());
      Iterator var4 = nbrlist.iterator();

      while(var4.hasNext()) {
         String string = (String)var4.next();
         if (!map.containsKey(string)) {
            dfs(map, string, vtces, st);
         }
      }

      int[] ans = new int[st.size()];

      for(int j = 0; st.size() > 0; ans[j++] = Integer.parseInt((String)st.removeFirst())) {
      }

      for(int i = 0; i < ans.length; ++i) {
         System.out.println(ans[i]);
      }

   }

   public static void dfs(HashMap<String, Boolean> map, String src, HashMap<String, HashMap<String, Integer>> vtces, LinkedList<String> st) {
      if (!map.containsKey(src)) {
         map.put(src, true);
         HashMap<String, Integer> nbr = (HashMap)vtces.get(src);
         ArrayList<String> nbrlist = new ArrayList(nbr.keySet());
         Iterator var6 = nbrlist.iterator();

         while(var6.hasNext()) {
            String string = (String)var6.next();
            if (!map.containsKey(string)) {
               dfs(map, string, vtces, st);
            }
         }

         st.addFirst(src);
      }
   }

   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("4");
      graph.addvertex("5");
      graph.addvertex("6");
      graph.addedge("4", "5", 1);
      graph.addedge("5", "6", 1);
      graph.addedge("6", "4", 1);
      graph.diplay();
      topsort(graph.vtces);
   }
}
