package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class printanagrams {
   public static void main(String[] args) {
      String[] arr = new String[]{"god", "act", "dog", "tac", "cat"};
      anagrams(arr);
   }

   public static void anagrams(String[] arr) {
      HashMap<HashMap<Character, Integer>, ArrayList<String>> list = new HashMap();

      for(int i = 0; i < arr.length; ++i) {
         HashMap<Character, Integer> map = new HashMap();
         String s = arr[i];

         for(int j = 0; j < s.length(); ++j) {
            if (!map.containsKey(s.charAt(j))) {
               map.put(s.charAt(j), 1);
            } else {
               map.replace(s.charAt(j), (Integer)map.get(s.charAt(j)) + 1);
            }
         }

         if (!list.containsKey(map)) {
            ArrayList<String> arrlist = new ArrayList();
            arrlist.add(s);
            list.put(map, arrlist);
         } else {
            ((ArrayList)list.get(map)).add(s);
            list.replace(map, list.get(map));
         }
      }

      List<List<String>> finalans = new ArrayList();
      Iterator var7 = list.values().iterator();

      while(var7.hasNext()) {
         ArrayList<String> anslist = (ArrayList)var7.next();
         finalans.add(anslist);
      }

      System.out.println(finalans);
   }
}
