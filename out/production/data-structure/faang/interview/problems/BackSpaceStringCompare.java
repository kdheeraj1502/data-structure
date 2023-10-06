package faang.interview.problems;

import java.util.ArrayList;
import java.util.List;

public class BackSpaceStringCompare {
   public boolean backspaceCompare(String s, String t) {
      List<Character> sList = new ArrayList();
      List<Character> tList = new ArrayList();

      int i;
      for(i = 0; i < s.length(); ++i) {
         if (s.charAt(i) == '#') {
            if (sList.size() > 0) {
               sList.remove(sList.size() - 1);
            }
         } else {
            sList.add(s.charAt(i));
         }
      }

      for(i = 0; i < t.length(); ++i) {
         if (t.charAt(i) == '#') {
            if (tList.size() > 0) {
               tList.remove(tList.size() - 1);
            }
         } else {
            tList.add(t.charAt(i));
         }
      }

      for(i = 0; i < sList.size(); ++i) {
         if (sList.size() != tList.size()) {
            return false;
         }

         if (i < sList.size() && i < tList.size() && sList.get(i) != tList.get(i)) {
            return false;
         }
      }

      return true;
   }

   public static void main(String[] args) {
      String s = "a#c###";
      String t = "ad#c";
      BackSpaceStringCompare bsc = new BackSpaceStringCompare();
      System.out.println(bsc.backspaceCompare(s, t));
   }
}
