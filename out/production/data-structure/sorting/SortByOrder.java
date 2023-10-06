package sorting;

import java.util.HashMap;
import java.util.Map;

public class SortByOrder {
   public static void sortByOrder(int[] num1, int[] num2) {
      Map<Integer, Integer> map = new HashMap();

      int i;
      for(i = 0; i < num1.length; ++i) {
         map.put(num1[i], (Integer)map.getOrDefault(map.get(num1[i]), 1) + 1);
      }

      int value;
      int k;
      for(i = 0; i < num2.length; ++i) {
         if (map.containsKey(num2[i])) {
            value = (Integer)map.get(num2[i]);

            for(k = 0; k < value; ++k) {
               System.out.print(num2[i] + ", ");
            }

            map.remove(num2[i]);
         }
      }

      System.out.println();

      for(i = 0; i < num1.length; ++i) {
         if (map.containsKey(num1[i])) {
            value = (Integer)map.get(num1[i]);

            for(k = 0; k < value; ++k) {
               System.out.print(num1[i] + ", ");
            }

            map.remove(num1[i]);
         }
      }

      System.out.println();
   }
}
