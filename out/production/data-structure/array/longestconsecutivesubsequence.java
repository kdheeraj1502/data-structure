package array;

import java.util.HashSet;

public class longestconsecutivesubsequence {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 6, 1, 9, 4, 5, 3};
      LCS(arr);
   }

   public static void LCS(int[] arr) {
      HashSet<Integer> map = new HashSet();

      int longest;
      for(longest = 0; longest < arr.length; ++longest) {
         map.add(arr[longest]);
      }

      longest = 0;
      int start = 0;
      int end = 0;

      int i;
      for(i = 0; i < arr.length; ++i) {
         if (!map.contains(arr[i] - 1)) {
            int j = 1;

            int l;
            for(l = 1; map.contains(arr[i] + j); ++j) {
               ++l;
            }

            if (l >= longest) {
               longest = l;
               start = arr[i];
               end = arr[i] + l - 1;
            }
         }
      }

      System.out.println(longest);

      for(i = start; i <= end; ++i) {
         System.out.println(i);
      }

   }
}
