package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ZeroSumTriplets {
   public static List<List<Integer>> zeroSum(int[] num, Set<List<Integer>> output) {
      Arrays.sort(num);
      int[] result = new int[3];

      for(int i = 0; i < num.length - 2; ++i) {
         int start = i + 1;
         int end = num.length - 1;
         int a = num[i];

         while(start < end) {
            int b = num[start];
            int c = num[end];
            int sum = a + b + c;
            System.out.println(a + ", " + b + ", " + c + " = " + sum);
            if (sum == 0) {
               result[0] = num[i];
               result[1] = num[start];
               result[2] = num[end];
               List<Integer> curr = new ArrayList();
               curr.add(num[i]);
               curr.add(num[start]);
               curr.add(num[end]);
               output.add(curr);
               ++start;
               --end;
            } else if (sum > 0) {
               --end;
            } else {
               ++start;
            }
         }
      }

      List<List<Integer>> res = new ArrayList();
      res.addAll(output);
      return res;
   }

   public static void main(String[] args) {
      int[] num = new int[]{-1, 0, 1, 2, -1, -4};
      Set<List<Integer>> output = new HashSet();
      System.out.println(zeroSum(num, output));
   }
}
