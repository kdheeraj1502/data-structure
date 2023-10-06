package strings;

import java.util.HashMap;
import java.util.HashSet;

public class smallestwindowthatcontainallchar {
   public static void main(String[] args) {
      System.out.println(smallestwindow("GEEKSGEEKSFOR"));
   }

   public static int smallestwindow(String s) {
      HashSet<Character> map = new HashSet();

      int count;
      for(count = 0; count < s.length(); ++count) {
         map.add(s.charAt(count));
      }

      count = map.size();
      if (s.length() == count) {
         return count;
      } else {
         HashMap<Character, Integer> map2 = new HashMap();
         int i = 0;
         int j = 0;
         int distinct = false;
         int minlength = Integer.MAX_VALUE;
         int mini = 0;
         int minj = 0;

         while(i <= j && j < s.length()) {
            char ch;
            while(map2.size() < count) {
               ch = s.charAt(j);
               map2.put(ch, (Integer)map2.getOrDefault(ch, 0) + 1);
               ++j;
            }

            for(; map2.size() == count; ++i) {
               if (minlength > j - i) {
                  minlength = j - i;
                  minj = j;
                  mini = i;
               }

               ch = s.charAt(i);
               if ((Integer)map2.get(ch) == 1) {
                  map2.remove(ch);
               } else {
                  map2.replace(ch, (Integer)map2.get(ch) - 1);
               }
            }
         }

         System.out.println(s.substring(mini, minj));
         return minlength;
      }
   }
}
