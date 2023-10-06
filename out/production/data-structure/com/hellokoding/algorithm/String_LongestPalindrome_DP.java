package com.hellokoding.algorithm;

public class String_LongestPalindrome_DP {
   static String findLongestPalindromicSubstring(String s) {
      if (s != null && !s.isEmpty()) {
         int n = s.length();
         int startIndex = 0;
         int maxLength = 1;
         boolean[][] P = new boolean[n][n];

         int l;
         for(l = 0; l < n; ++l) {
            P[l][l] = true;
         }

         for(l = 0; l < n - 1; ++l) {
            if (s.charAt(l) == s.charAt(l + 1)) {
               P[l][l + 1] = true;
               startIndex = l;
               maxLength = 2;
            }
         }

         for(l = 3; l <= n; ++l) {
            for(int i = 0; i < n - l + 1; ++i) {
               int j = i + l - 1;
               if (s.charAt(i) == s.charAt(j) && P[i + 1][j - 1]) {
                  P[i][j] = true;
                  if (l > maxLength) {
                     maxLength = l;
                     startIndex = i;
                  }
               }
            }
         }

         return s.substring(startIndex, startIndex + maxLength);
      } else {
         return "";
      }
   }

   public static void main(String[] args) {
      System.out.println(findLongestPalindromicSubstring("a"));
      System.out.println(findLongestPalindromicSubstring("bb"));
      System.out.println(findLongestPalindromicSubstring("ccc"));
      System.out.println(findLongestPalindromicSubstring("bananas"));
   }
}
