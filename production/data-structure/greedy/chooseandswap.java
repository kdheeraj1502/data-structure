package greedy;

import java.util.Iterator;
import java.util.TreeSet;

public class chooseandswap {
   public static void main(String[] args) {
      String A = "abba";
      System.out.println(chooseandswap(A));
   }

   public static String chooseandswap(String A) {
      TreeSet<Character> set = new TreeSet();

      for(int i = 0; i < A.length(); ++i) {
         set.add(A.charAt(i));
      }

      StringBuilder s = new StringBuilder();
      int flag = false;

      for(int i = 0; i < A.length(); ++i) {
         char ch = A.charAt(i);
         set.remove(ch);
         char f = ' ';
         if (set.isEmpty()) {
            break;
         }

         Iterator var7 = set.iterator();
         if (var7.hasNext()) {
            char val = (Character)var7.next();
            f = val;
         }

         if (f < ch) {
            flag = true;

            for(int j = 0; j < A.length(); ++j) {
               if (A.charAt(j) == f) {
                  s.append(ch);
               } else if (A.charAt(j) == ch) {
                  s.append(f);
               } else {
                  s.append(A.charAt(j));
               }
            }

            return !flag ? A : s.toString();
         }
      }

      return !flag ? A : s.toString();
   }
}
