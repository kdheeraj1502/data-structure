package array;

import java.util.Arrays;

public class GeometoryExpression_2MulitplyA_Equals_B_Plus_C {
   public static void geoExpression(int[] num) {
      Arrays.sort(num);

      for(int i = 0; i < num.length; ++i) {
         int start = 0;
         int end = num.length - 1;
         int a = 2 * num[i];

         while(start < end) {
            int b = num[start];
            int c = num[end];
            int sum = b + c;
            if (a == sum) {
               System.out.println("The numbers are, 2 times of " + num[i] + " = " + b + " + " + c + " and index are i " + i + " start is " + start + " end is " + end);
               ++start;
               --end;
            } else if (a < sum) {
               --end;
            } else {
               ++start;
            }
         }
      }

   }

   public static void APTriplets(int[] num) {
      for(int i = 1; i < num.length; ++i) {
         int j = i - 1;
         int k = i + 1;

         while(j >= 0 && k < num.length) {
            if (2 * num[i] == num[j] + num[k]) {
               System.out.println("The numbers are, 2 times of " + num[i] + " = " + num[j] + " + " + num[k] + " and index are i " + i + " start is " + k + " end is " + j);
               ++k;
               --j;
            } else if (2 * num[i] > num[j] + num[k]) {
               ++k;
            } else {
               --j;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 3, 5, -5, 8, -4, 1, 0};
      geoExpression(num);
      System.out.println("------------------------------------------------------");
      APTriplets(num);
   }
}
