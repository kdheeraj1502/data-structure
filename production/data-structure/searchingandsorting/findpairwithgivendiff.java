package searchingandsorting;

import java.util.Arrays;

public class findpairwithgivendiff {
   public static void main(String[] args) {
   }

   public boolean findPair(int[] arr, int size, int n) {
      Arrays.sort(arr);
      int i = 0;
      int j = 1;

      while(i < arr.length && j < arr.length) {
         if (arr[j] - arr[i] == n) {
            return true;
         }

         if (arr[j] - arr[i] < n) {
            ++j;
         } else {
            ++i;
         }
      }

      return false;
   }
}
