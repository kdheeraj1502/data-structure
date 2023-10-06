package strings;

import java.util.HashMap;

public class Isomorphicstring_42 {
   public static void main(String[] args) {
      String s1 = "pepcoding";
      String s2 = "sosherlok";
      System.out.println(isomorphic(s1, s2));
   }

   public static boolean isomorphic(String s1, String s2) {
      HashMap<Character, Character> map1 = new HashMap();
      HashMap<Character, Boolean> map2 = new HashMap();
      int i = 0;

      for(int j = 0; i < s1.length() && j < s2.length(); ++j) {
         char ch1 = s1.charAt(i);
         char ch2 = s2.charAt(j);
         if (map1.containsKey(ch1)) {
            if ((Character)map1.get(ch1) != ch2) {
               return false;
            }
         } else {
            if (map2.containsKey(ch2)) {
               return false;
            }

            map1.put(ch1, ch2);
            map2.put(ch2, true);
         }

         ++i;
      }

      System.out.println(map1);
      System.out.println(map2);
      return true;
   }
}
