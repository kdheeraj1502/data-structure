package binary.search;

import java.util.Arrays;

public class ClosetPairToNum {
   public static int[] closetPair(int[] num, int val) {
      Arrays.sort(num);
      int start = 0;
      int end = num.length - 1;
      int diff = Integer.MAX_VALUE;
      int[] result = new int[2];

      while(start < end) {
         System.out.println(num[start] + " " + num[end]);
         int min = val - (num[start] + num[end]);
         if (diff > Math.abs(min)) {
            diff = Math.abs(min);
            result[0] = num[start];
            result[1] = num[end];
         } else if (min > 0) {
            ++start;
         } else {
            --end;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{34, 8, 74, 76, 11, 25, 11, 90, 57, 0, 15};
      System.out.println(Arrays.toString(closetPair(num, 70)));
   }
}
