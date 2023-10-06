package strings;

import java.util.HashMap;

public class ComputerCafeProblem_40 {
   public static void main(String[] args) {
      computercafe(1, "ABCBCADEED");
   }

   public static void computercafe(int n, String s) {
      HashMap<Character, Integer> map = new HashMap();
      int count = 0;
      int i = 0;
      int wait = 0;

      while(i < s.length()) {
         for(; count <= n && i < s.length(); ++i) {
            if (!map.containsKey(s.charAt(i))) {
               ++count;
               map.put(s.charAt(i), 1);
            } else {
               map.remove(s.charAt(i));
               --count;
            }
         }

         for(; count > n; ++i) {
            if (map.containsKey(s.charAt(i))) {
               map.remove(s.charAt(i));
               --count;
               ++wait;
            } else {
               ++count;
               map.put(s.charAt(i), 1);
            }
         }
      }

      System.out.println(wait);
   }
}
