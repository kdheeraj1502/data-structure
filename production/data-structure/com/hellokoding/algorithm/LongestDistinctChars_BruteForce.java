package com.hellokoding.algorithm;

import java.util.HashSet;

public class LongestDistinctChars_BruteForce {
   static String bruteforce(String s) {
      int l = 0;
      int i = 0;
      int j = false;

      for(int n = s.length(); i < n; ++i) {
         int j;
         for(j = i + 1; j <= n && isUnique(s, i, j); ++j) {
            l = Math.max(l, j - i);
         }

         if (j == n + 1) {
            break;
         }
      }

      return s.substring(i, i + l);
   }

   static boolean isUnique(String s, int i, int j) {
      HashSet<Character> set = new HashSet();

      for(int k = i; k < j; ++k) {
         if (set.contains(s.charAt(k))) {
            return false;
         }

         set.add(s.charAt(k));
      }

      return true;
   }

   public static void main(String[] args) {
      System.out.println(bruteforce("HelloKoding"));
   }
}
