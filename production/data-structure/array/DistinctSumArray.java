package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DistinctSumArray {
   public static int sum(int[] num) {
      if (num.length == 0) {
         return 0;
      } else {
         Arrays.sort(num);
         int maxSum = 0;

         for(int i = 0; i < num.length - 1; ++i) {
            if (num[i] != num[i + 1]) {
               maxSum += num[i];
            }
         }

         maxSum += num[num.length - 1];
         return maxSum;
      }
   }

   public static int sumMap(int[] num) {
      Map<Integer, Integer> map = new HashMap();
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Integer in = var2[var4];
         map.put(in, (Integer)map.getOrDefault(in, 1) + 1);
      }

      int maxSum = 0;

      Map.Entry m;
      for(Iterator var7 = map.entrySet().iterator(); var7.hasNext(); maxSum += (Integer)m.getKey()) {
         m = (Map.Entry)var7.next();
      }

      return maxSum;
   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 8, 2, 7, 3, 4, 6, 6, 9, 2, 1, 1, 6};
      System.out.println(sumMap(num));
   }
}
