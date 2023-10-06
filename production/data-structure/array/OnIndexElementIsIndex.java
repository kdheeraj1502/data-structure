package array;

import java.util.Arrays;

public class OnIndexElementIsIndex {
   public static int[] indexArray(int[] num) {
      for(int i = 1; i < num.length; ++i) {
         int curr = i;

         int val;
         int temp;
         for(val = -1; curr != -1 && curr < num.length && num[curr] != curr - 1; val = temp) {
            temp = num[curr - 1];
            num[curr - 1] = val;
            curr = temp;
         }

         if (val != -1) {
            num[curr - 1] = val;
         }
      }

      return num;
   }

   public static void indexArrayOnSwap(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         while(num[i] != -1 && num[i] != i) {
            int temp = num[i];
            num[i] = num[temp];
            num[temp] = temp;
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{8, -1, 6, 1, 9, 3, 2, 7, 4, -1, 0};
      indexArrayOnSwap(num);
      System.out.println(Arrays.toString(num));
   }
}
