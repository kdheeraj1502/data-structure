package strings;

import java.util.HashMap;

public class smallestwindow2 {
   public static void main(String[] args) {
      String S = "timetopractice";
      String P = "toc";
      smallestwindow(S, P);
   }

   public static void smallestwindow(String s, String pat) {
      HashMap<Character, Integer> map = new HashMap();
      int dist = pat.length();

      int i;
      int j;
      for(i = 0; i < pat.length(); ++i) {
         j = pat.charAt(i);
         map.put(Character.valueOf((char)j), (Integer)map.getOrDefault(Character.valueOf((char)j), 0) + 1);
      }

      i = 0;
      j = 0;
      int count = 0;
      int minlength = Integer.MAX_VALUE;
      int mini = 0;
      int minj = 0;
      HashMap<Character, Integer> stringmap = new HashMap();

      while(i <= j && j < s.length()) {
         char ch;
         for(; j < s.length() && count < dist; ++j) {
            ch = s.charAt(j);
            stringmap.put(ch, (Integer)stringmap.getOrDefault(ch, 0) + 1);
            if ((Integer)stringmap.getOrDefault(ch, 0) <= (Integer)map.getOrDefault(ch, 0)) {
               ++count;
            }
         }

         for(; count == dist; ++i) {
            if (minlength > j - i) {
               minlength = j - i;
               mini = i;
               minj = j;
            }

            ch = s.charAt(i);
            if ((Integer)stringmap.get(ch) == 1) {
               stringmap.remove(ch);
            } else {
               stringmap.replace(ch, (Integer)stringmap.get(ch) - 1);
            }

            if ((Integer)stringmap.getOrDefault(s.charAt(i), 0) < (Integer)map.getOrDefault(s.charAt(i), 0)) {
               --count;
            }
         }
      }

      System.out.println(s.substring(mini, minj));
   }
}
