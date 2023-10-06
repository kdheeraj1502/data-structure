package searching;

import java.util.Arrays;

public class MissingValues {
   public static void missingValues(int[] num) {
      Arrays.sort(num);
      int val = num[0];
      int i = 0;

      while(i < num.length) {
         if (val == num[i]) {
            ++val;
            ++i;
         } else {
            System.out.println(val);
            ++val;
         }
      }

   }
}
