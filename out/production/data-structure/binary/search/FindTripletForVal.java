package binary.search;

import java.util.Arrays;

public class FindTripletForVal {
   public static void findTriplet(int[] num, int val) {
      Arrays.sort(num);

      for(int i = 0; i < num.length - 2; ++i) {
         int start = i + 1;
         int end = num.length - 1;

         while(start < end) {
            int sum = num[i] + num[start] + num[end];
            if (sum == val) {
               System.out.println(num[i] + " + " + num[start] + " + " + num[end] + " = " + sum + " :: " + val);
               ++start;
               --end;
            } else if (sum > val) {
               --end;
            } else {
               ++start;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{-15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82};
      findTriplet(num, 10);
   }
}
