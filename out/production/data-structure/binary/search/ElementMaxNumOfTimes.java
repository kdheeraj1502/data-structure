package binary.search;

import java.util.Arrays;

public class ElementMaxNumOfTimes {
   public static int maxCount(int[] num) {
      int count = 0;
      int curr = -1;
      int max = -1;
      int result = -1;
      Arrays.sort(num);

      for(int i = 1; i < num.length; ++i) {
         if (num[i - 1] == num[i]) {
            ++count;
            curr = i;
         } else {
            count = 1;
         }

         if (max < count) {
            max = count;
            result = curr;
         }
      }

      System.out.println("max count is : " + max);
      return num[result];
   }

   public static void main(String[] args) {
      int[] num = new int[]{15, 11, 6, 35, 23, 2, 1, 0, 19, 1, 34, 5, 6, 3, 2, 91, 3, 13, 7, 8, 9, 12, 18, 82};
      System.out.println(maxCount(num));
   }
}
