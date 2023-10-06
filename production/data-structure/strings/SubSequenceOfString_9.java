package strings;

import java.util.ArrayList;
import java.util.List;

public class SubSequenceOfString_9 {
   static List<String> subSequence(String str) {
      List<String> result = new ArrayList();
      subSequence(0, str, result, "");
      return result;
   }

   static void subSequence(int index, String str, List<String> result, String ans) {
      if (index < str.length()) {
         for(int i = index; i < str.length(); ++i) {
            ans = ans + str.charAt(i);
            result.add(ans);
            subSequence(i + 1, str, result, ans);
            ans = ans.substring(0, ans.length() - 1);
         }

      }
   }

   public static void main(String[] args) {
      String str = "abc";
      System.out.println(subSequence(str));
   }
}
