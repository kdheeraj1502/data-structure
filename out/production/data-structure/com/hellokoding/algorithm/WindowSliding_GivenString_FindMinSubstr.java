package com.hellokoding.algorithm;

import java.util.HashMap;
import java.util.Map;

public class WindowSliding_GivenString_FindMinSubstr {
   public static String findMinSubstr(String s, String t) {
      Map<Character, Integer> tChars = new HashMap();
      char[] var3 = t.toCharArray();
      int var4 = var3.length;

      int i;
      for(int var5 = 0; var5 < var4; ++var5) {
         i = var3[var5];
         tChars.compute(Character.valueOf((char)i), (key, value) -> {
            return value == null ? 1 : Integer.valueOf(value + 1);
         });
      }

      Map<Character, Integer> sChars = new HashMap();
      String windowSubstr = "";
      String minSubstr = "";
      i = 0;
      int j = 0;

      for(int matched = 0; i < s.length(); ++i) {
         Character c;
         while(j < s.length() && matched < tChars.size()) {
            c = s.charAt(j++);
            sChars.compute(c, (key, value) -> {
               return value == null ? 1 : Integer.valueOf(value + 1);
            });
            windowSubstr = windowSubstr + c;
            if (tChars.containsKey(c) && ((Integer)tChars.get(c)).equals(sChars.get(c))) {
               ++matched;
            }
         }

         if (matched == tChars.size() && (minSubstr.equals("") || windowSubstr.length() < minSubstr.length())) {
            minSubstr = windowSubstr;
         }

         c = windowSubstr.charAt(0);
         sChars.compute(c, (key, value) -> {
            return value - 1;
         });
         if (tChars.containsKey(c) && (Integer)tChars.get(c) > (Integer)sChars.get(c)) {
            --matched;
         }

         windowSubstr = windowSubstr.substring(1);
      }

      return minSubstr;
   }

   public static void main(String[] args) {
      System.out.println(findMinSubstr("ADOBECODEBANC", "ABC"));
      System.out.println(findMinSubstr("aaaaaaaaaaaabbbbbcdd", "abcdd"));
      System.out.println(findMinSubstr("a", "aa"));
   }
}
