package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class aliendict {
   public static void main(String[] args) {
      String[] dict = new String[]{"baa", "abcd", "abca", "cab", "cad"};
      dict(dict, 4);
   }

   public static void dict(String[] dict, int noofalpha) {
      ArrayList<ArrayList<Integer>> g = new ArrayList();

      int i;
      for(i = 0; i < noofalpha; ++i) {
         ArrayList<Integer> nbr = new ArrayList();
         g.add(nbr);
      }

      for(i = 0; i < dict.length - 1; ++i) {
         String s1 = dict[i];
         String s2 = dict[i + 1];
         int j = 0;

         for(int k = 0; j < s1.length() && k < s2.length(); ++k) {
            if (s1.charAt(j) != s2.charAt(k)) {
               ((ArrayList)g.get(s1.charAt(j) - 97)).add(s2.charAt(k) - 97);
               break;
            }

            ++j;
         }
      }

      topsort(g);
   }

   public static void topsort(ArrayList<ArrayList<Integer>> vtces) {
      HashMap<Integer, Boolean> map = new HashMap();
      LinkedList<Integer> st = new LinkedList();

      for(int i = 0; i < vtces.size(); ++i) {
         if (!map.containsKey(i)) {
            dfs(map, i, vtces, st);
         }
      }

      char ch;
      String ans;
      for(ans = ""; st.size() > 0; ans = ans + ch) {
         int n = (Integer)st.removeFirst();
         ch = (char)(97 + n);
      }

      System.out.println(ans);
   }

   public static void dfs(HashMap<Integer, Boolean> map, int src, ArrayList<ArrayList<Integer>> vtces, LinkedList<Integer> st) {
      if (!map.containsKey(src)) {
         map.put(src, true);
         ArrayList<Integer> nbrlist = (ArrayList)vtces.get(src);

         for(int i = 0; i < nbrlist.size(); ++i) {
            if (!map.containsKey(nbrlist.get(i))) {
               dfs(map, (Integer)nbrlist.get(i), vtces, st);
            }
         }

         st.addFirst(src);
      }
   }
}
