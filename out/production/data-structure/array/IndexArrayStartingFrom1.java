package array;

import java.util.Arrays;

public class IndexArrayStartingFrom1 {
   public static void orderNum(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int curr = i;

         int next;
         for(int value = -1; curr >= 0 && curr < num.length && num[curr] != curr + 1; curr = next - 1) {
            next = num[curr];
            num[curr] = value;
            value = next;
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 5, 6, 1, -1, 3, 2, 7, 4, 10};
      orderNum(num);
      System.out.println(Arrays.toString(num));
   }
}
