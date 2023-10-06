package binary.search;

import java.util.Arrays;

public class APlusBEqualsCPower2 {
   public static void geoExp(int[] num) {
      Arrays.sort(num);

      for(int i = 1; i < num.length; ++i) {
         int j = i - 1;
         int k = i + 1;
         int a = num[i] * num[i];

         while(j >= 0 && k < num.length) {
            int sum = num[j] + num[k];
            if (sum == a) {
               System.out.println(num[j] + " + " + num[k] + " = " + a + " /" + num[i]);
               ++k;
               --j;
            } else if (sum < a) {
               ++k;
            } else {
               --j;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{-15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82};
      geoExp(num);
   }
}
