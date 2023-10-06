package bitmasking;

import java.util.Arrays;

public class FindTwoNonRepeatingNumbers_2 {
   public static void main(String[] args) {
      int[] arr = new int[]{5, 4, 3};
      missingno(5, arr);
      int z = 8;
      System.out.println(1);
      int a = z & ~(z - 1);
      System.out.println("a is " + a);
      int[] num = new int[]{1, 2, 3, 2, 1, 4};
      System.out.println(Arrays.toString(singleNumber(num)));
   }

   public static int[] singleNumber(int[] nums) {
      int xor = 0;
      int[] var2 = nums;
      int a = nums.length;

      int b;
      for(b = 0; b < a; ++b) {
         int val = var2[b];
         xor ^= val;
      }

      int rsbm = xor & ~(xor - 1);
      a = 0;
      b = 0;
      int[] result = new int[2];
      int[] var6 = nums;
      int var7 = nums.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         int val = var6[var8];
         if ((val & rsbm) == 0) {
            a ^= val;
         } else {
            b ^= val;
         }
      }

      if (a < b) {
         result[0] = a;
         result[1] = b;
      } else {
         result[1] = a;
         result[0] = b;
      }

      return result;
   }

   public static void missingno(int n, int[] arr) {
      int z = 1;

      int rightmostsetbit;
      for(rightmostsetbit = 2; rightmostsetbit <= n; ++rightmostsetbit) {
         z ^= rightmostsetbit;
      }

      for(rightmostsetbit = 0; rightmostsetbit < arr.length; ++rightmostsetbit) {
         z ^= arr[rightmostsetbit];
      }

      rightmostsetbit = z & ~(z - 1);
      int set = 0;
      int reset = 0;

      int i;
      for(i = 1; i <= n; ++i) {
         if ((i & rightmostsetbit) != 0) {
            set ^= i;
         } else {
            reset ^= i;
         }
      }

      for(i = 0; i < arr.length; ++i) {
         if ((arr[i] & rightmostsetbit) != 0) {
            set ^= arr[i];
         } else {
            reset ^= arr[i];
         }
      }

      System.out.println("missing no are -> " + set + " , " + reset);
   }
}
