package com.hellokoding.algorithm;

public class AnagramsByHistogramming {
   static boolean areAnagrams(String s, String t) {
      if (s.length() != t.length()) {
         return false;
      } else {
         s = s.replaceAll("\\s", "");
         t = t.replaceAll("\\s", "");
         int[] frequencies = new int[26];

         for(int i = 0; i < s.length(); ++i) {
            ++frequencies[s.charAt(i) - 97];
            --frequencies[t.charAt(i) - 97];
         }

         int[] var7 = frequencies;
         int var4 = frequencies.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            int count = var7[var5];
            if (count != 0) {
               return false;
            }
         }

         return true;
      }
   }

   public static void main(String[] args) {
      System.out.println(areAnagrams("listen", "silent"));
      System.out.println(areAnagrams("eleven plus two", "twelve plus one"));
      System.out.println(areAnagrams("rat", "car"));
   }
}
