package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithoutRepeat {
   static final int NO_OF_CHARS = 256;

   public static int lengthOfLongestSubstring(String s) {
      int winStart = 0;
      int winEnd = 0;
      int len = 0;
      Map<Character, Integer> map = new HashMap();
      char[] var5 = s.toCharArray();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         char ch = var5[var7];
         if (map.containsKey(ch)) {
            winStart = Math.max(winStart, (Integer)map.get(ch) + 1);
         }

         len = Math.max(len, winEnd - winStart + 1);
         map.put(ch, winEnd);
         ++winEnd;
      }

      return len;
   }

   public static int longestUniqueSubsttr(String str) {
      int n = str.length();
      int len = 0;
      int[] lastIndex = new int[256];
      Arrays.fill(lastIndex, -1);
      int start = 0;

      for(int end = 0; end < n; lastIndex[str.charAt(end)] = end++) {
         start = Math.max(start, lastIndex[str.charAt(end)] + 1);
         len = Math.max(len, end - start + 1);
      }

      return len;
   }

   public static void main(String[] args) {
      String s = "dvdf";
      int[] lastIndex = new int[256];

      for(int i = 0; i < s.length(); ++i) {
         lastIndex[s.charAt(i)] = s.charAt(i);
      }

      System.out.println(longestUniqueSubsttr(s));
      char c = 109;
      String str = "Dheeraj";
      str = str.toLowerCase();
      System.out.println(str);
      if (c > 57 || c < 48 && c < 97 && c > 122) {
         System.out.println(true);
      }

   }
}
