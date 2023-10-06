package bitmasking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PowerSet_10 {
   public static void main(String[] args) {
      List<String> list = new ArrayList();
      subset("abc", "", list);
      System.out.println(list);
      System.out.println(AllPossibleStrings("abc"));
   }

   public static void subset(String s, String ans, List<String> list) {
      if (s.length() == 0) {
         list.add(ans);
      } else {
         char ch = s.charAt(0);
         String ros = s.substring(1);
         subset(ros, ans, list);
         subset(ros, ans + ch, list);
      }
   }

   public static List<String> AllPossibleStrings(String s) {
      List<String> list = new LinkedList();
      help(s, "", list);
      Collections.sort(list);
      list.remove(0);
      return list;
   }

   static void help(String s, String ans, List<String> list) {
      if (s.length() == 0) {
         list.add(ans);
      } else {
         char ch = s.charAt(0);
         String rest = s.substring(1);
         help(rest, ans, list);
         help(rest, ans + ch, list);
      }
   }
}
