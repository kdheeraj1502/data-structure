package array;

import array.reduction.Main;

public class SecondLargest {
   public static void secondLargest(int[] num, int count, int index, int last) {
      int maxIndex = 0;
      if (count != 0) {
         int max = num[0];

         for(int i = 0; i < num.length - last; ++i) {
            if (max < num[i] && max != num[i]) {
               max = num[i];
               maxIndex = i;
            }
         }

         Main.swap(num, maxIndex, index);
         secondLargest(num, count - 1, index - 1, last + 1);
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{6, 3, 9, 2, 7, 5, 3, 1, 8};
      secondLargest(num, 2, num.length - 1, 0);
      System.out.println(num[num.length - 2]);
   }
}
