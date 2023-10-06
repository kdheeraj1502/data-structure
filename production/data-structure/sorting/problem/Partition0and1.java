package sorting.problem;

import array.reduction.Main;

public class Partition0and1 {
   public static int partition(int[] num) {
      int a = 0;
      int b = num.length - 1;
      int count = 0;

      while(a < b) {
         while(num[a] == 0) {
            ++a;
         }

         while(num[b] == 1) {
            --b;
         }

         if (a < b) {
            Main.swap(num, a, b);
            ++count;
         }
      }

      return count;
   }
}
