package com.hellokoding.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BackTracking_StringPermutations {
   List<String> result = new ArrayList();

   String swap(String str, int i, int j) {
      char[] arr = str.toCharArray();
      char temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
      return String.valueOf(arr);
   }

   void enumerate(String str, int startIndex) {
      if (startIndex == str.length() - 1) {
         this.result.add(str);
      } else {
         for(int i = startIndex; i < str.length(); ++i) {
            str = this.swap(str, startIndex, i);
            this.enumerate(str, startIndex + 1);
            str = this.swap(str, startIndex, i);
         }

      }
   }

   public static void main(String[] args) {
      String str = "ABC";
      BackTracking_StringPermutations permutations = new BackTracking_StringPermutations();
      permutations.enumerate(str, 0);
      System.out.println((String)permutations.result.stream().collect(Collectors.joining(" ")));
   }
}
