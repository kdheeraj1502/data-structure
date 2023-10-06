package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class eulariancircuit {
   public static void main(String[] args) {
      makegraph.Graph graph = new makegraph.Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addedge("0", "1", 1);
      graph.addedge("0", "2", 1);
      graph.addedge("1", "2", 1);
      graph.addedge("2", "3", 1);
      graph.addedge("2", "4", 1);
      graph.addedge("3", "4", 1);
      int a = euler(graph.vtces);
      if (a == 0) {
         System.out.println("NO ");
      } else if (a == 1) {
         System.out.println("Euler ckt");
      } else {
         System.out.println("Semi euler");
      }

   }

   public static int euler(HashMap<String, HashMap<String, Integer>> vtces) {
      if (!checkcomponents(vtces)) {
         return 0;
      } else {
         int odd = 0;
         ArrayList<String> vlist = new ArrayList(vtces.keySet());
         Iterator var3 = vlist.iterator();

         while(var3.hasNext()) {
            String string = (String)var3.next();
            HashMap<String, Integer> nbr = (HashMap)vtces.get(string);
            if (nbr.size() % 2 != 0) {
               ++odd;
            }
         }

         if (odd > 2) {
            return 0;
         } else if (odd == 0) {
            return 1;
         } else {
            return 2;
         }
      }
   }

   private static boolean checkcomponents(HashMap<String, HashMap<String, Integer>> vtces) {
      ArrayList<String> vlist = new ArrayList(vtces.keySet());
      String start = "";
      Iterator var3 = vlist.iterator();

      while(var3.hasNext()) {
         String string = (String)var3.next();
         HashMap<String, Integer> nbr = (HashMap)vtces.get(string);
         if (nbr.size() > 0) {
            start = string;
            break;
         }
      }

      if (start == "") {
         return true;
      } else {
         HashSet<String> map = new HashSet();
         dfs(vtces, map, start);
         Iterator var8 = vlist.iterator();

         while(var8.hasNext()) {
            String string = (String)var8.next();
            if (!map.contains(string)) {
               HashMap<String, Integer> nbr = (HashMap)vtces.get(string);
               if (nbr.size() > 0) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   private static void dfs(HashMap<String, HashMap<String, Integer>> vtces, HashSet<String> map, String start) {
      map.add(start);
      HashMap<String, Integer> nbr = (HashMap)vtces.get(start);
      Iterator var4 = nbr.keySet().iterator();

      while(var4.hasNext()) {
         String string = (String)var4.next();
         if (!map.contains(string)) {
            dfs(vtces, map, string);
         }
      }

   }
}
