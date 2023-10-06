package array;

import java.util.Arrays;

public class IndexArray {
   public static void indexArray(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int curr = i;

         int value;
         int temp;
         for(value = -1; num[curr] != -1 && num[curr] != curr; curr = temp) {
            temp = num[curr];
            num[curr] = value;
            value = temp;
         }

         if (value != -1) {
            num[curr] = value;
         }
      }

   }

   public static void indexArraySelf(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int curr = i;

         int value;
         int temp;
         for(value = -1; num[curr] != -1 && num[curr] != curr; curr = temp) {
            temp = num[curr];
            num[curr] = value;
            value = temp;
         }

         if (value != -1) {
            num[curr] = value;
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 10, 6, 1, 9, 3, 2, 7, 4, 5};
      indexArraySelf(num);
      System.out.println(Arrays.toString(num));
   }
}
