package stackandqueue;

import java.util.HashMap;
import java.util.LinkedList;

public class firstnonrepeatingcharacterstream {
   public static void main(String[] args) {
      String s = "aabc";
      System.out.println(FirstNonRepeatingopti(s));
   }

   public static String FirstNonRepeating(String s) {
      StringBuilder temp = new StringBuilder();
      StringBuilder ans = new StringBuilder();
      HashMap<Character, Integer> map = new HashMap();

      for(int i = 0; i < s.length(); ++i) {
         temp.append(s.charAt(i));
         map.put(s.charAt(i), (Integer)map.getOrDefault(s.charAt(i), 0) + 1);
         int j = 0;

         boolean flag;
         for(flag = true; j < temp.length(); ++j) {
            if ((Integer)map.get(temp.charAt(j)) == 1) {
               ans.append(temp.charAt(j));
               flag = false;
               break;
            }
         }

         if (flag) {
            ans.append('#');
         }
      }

      return ans.toString();
   }

   public static String FirstNonRepeatingopti(String s) {
      LinkedList<Character> temp = new LinkedList();
      StringBuilder ans = new StringBuilder();
      HashMap<Character, Integer> map = new HashMap();

      for(int i = 0; i < s.length(); ++i) {
         temp.addLast(s.charAt(i));
         map.put(s.charAt(i), (Integer)map.getOrDefault(s.charAt(i), 0) + 1);

         while(!temp.isEmpty() && (Integer)map.get(temp.getFirst()) != 1) {
            temp.removeFirst();
         }

         if (temp.size() == 0) {
            ans.append('#');
         } else {
            ans.append(temp.getFirst());
         }
      }

      return ans.toString();
   }
}
