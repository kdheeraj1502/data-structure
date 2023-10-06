package array;

import java.util.Arrays;

public class ArithmeticProgressionTriplet_2MultiplyA_EqualsBplusC {
   public static void APTriplet(int[] num) {
      for(int i = 1; i < num.length; ++i) {
         int j = i - 1;
         int k = i + 1;

         while(j >= 0 && k < num.length) {
            if (num[j] + num[k] == 2 * num[i]) {
               System.out.println("Triplet : " + num[j] + ", 2 * num[i] is " + 2 * num[i] + ", " + num[k]);
               ++k;
               --j;
            } else if (num[j] + num[k] < 2 * num[i]) {
               ++k;
            } else {
               --j;
            }
         }
      }

   }

   public static void APTripletSelf(int[] num) {
      Arrays.sort(num);

      for(int i = 0; i < num.length; ++i) {
         int start = 0;
         int end = num.length - 1;

         while(start < end) {
            if (num[start] + num[end] == 2 * num[i]) {
               System.out.println("Triplet : , 2 * " + num[i] + " = " + num[start] + " + " + num[end]);
               ++start;
               --end;
            } else if (num[start] + num[end] < 2 * num[i]) {
               ++start;
            } else {
               --end;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 3, 5, -5, 8, -4, 1, 0, 12};
      APTriplet(num);
      System.out.println("-----------------------------------------------------------");
      APTripletSelf(num);
   }
}
