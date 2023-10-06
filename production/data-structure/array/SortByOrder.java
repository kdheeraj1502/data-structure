package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortByOrder {
   public static int[] sortByOrder(int[] num, int[] order) {
      Map<Integer, Integer> map = new HashMap();
      int[] result = new int[num.length];
      int i = 0;

      int index;
      for(index = 0; i < num.length; ++i) {
         System.out.println(num[i]);
         map.put(num[i], (Integer)map.getOrDefault(num[i], 0) + 1);
      }

      int j;
      for(i = 0; i < order.length; ++i) {
         if (map.containsKey(order[i])) {
            for(j = (Integer)map.get(order[i]); j > 0; --j) {
               result[index] = order[i];
               ++index;
            }

            map.remove(order[i]);
         }
      }

      for(i = 0; i < num.length; ++i) {
         if (map.containsKey(num[i])) {
            for(j = (Integer)map.get(num[i]); j > 0; --j) {
               result[index] = num[i];
               ++index;
            }

            map.remove(num[i]);
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
      int[] order = new int[]{2, 1, 8, 3};
      int[] result = sortByOrder(num, order);
      System.out.println(Arrays.toString(result));
   }
}
