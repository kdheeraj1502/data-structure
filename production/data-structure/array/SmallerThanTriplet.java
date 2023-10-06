package array;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SmallerThanTriplet {
   static int sum = 0;
   static int count = 1;

   public static List<List<Integer>> numberSum(int[] num, int val, List<List<Integer>> output) {
      Arrays.sort(num);

      for(int i = 0; i < num.length - 2; ++i) {
         int start = i + 1;
         int end = num.length - 1;

         while(start < end) {
            int sum = num[i] + num[start] + num[end];
            if (sum < val) {
               List<Integer> curr = new ArrayList();
               curr.add(num[i]);
               curr.add(num[start]);
               curr.add(num[end]);
               output.add(curr);
               ++start;
            } else {
               --end;
            }
         }
      }

      return output;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 3, 5, -5, 8, -4, 1, 0};
      List<List<Integer>> result = numberSum(num, 12, new ArrayList());
      List<String> output = (List)result.stream().map((r) -> {
         return r.stream().reduce(0, (a, b) -> {
            return a + b;
         }) + "_" + count++;
      }).collect(Collectors.toList());
      Stream var10000 = output.stream();
      PrintStream var10001 = System.out;
      var10000.forEach(var10001::println);
   }
}
