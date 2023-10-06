package searchingandsorting;

import java.util.Scanner;

public class doubblehelix {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);

      while(true) {
         int n = scn.nextInt();
         if (n == 0) {
            return;
         }

         int[] arr1 = new int[n];

         int m;
         for(m = 0; m < arr1.length; ++m) {
            arr1[m] = scn.nextInt();
         }

         m = scn.nextInt();
         int[] arr2 = new int[m];

         for(int i = 0; i < arr2.length; ++i) {
            arr2[i] = scn.nextInt();
         }

         solve(arr1, arr2);
      }
   }

   public static void solve(int[] arr1, int[] arr2) {
      int i = 0;
      int j = 0;
      int sum1 = 0;
      int sum2 = 0;
      int max = 0;

      while(i < arr1.length && j < arr2.length) {
         if (arr1[i] < arr2[j]) {
            sum1 += arr1[i];
            ++i;
         } else if (arr1[i] > arr2[j]) {
            sum2 += arr2[j];
            ++j;
         } else {
            max += arr1[i] + Math.max(sum1, sum2);
            sum1 = 0;
            sum2 = 0;
            ++i;
            ++j;
         }
      }

      while(i < arr1.length) {
         sum1 += arr1[i];
         ++i;
      }

      while(j < arr2.length) {
         sum2 += arr2[j];
         ++j;
      }

      max += Math.max(sum2, sum1);
      System.out.println(max);
   }
}
