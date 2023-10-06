package searching;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;

public class FirstRepeatingNumber {
   public static int firstRepeatingNum(int[] num) {
      int min = -1;
      if (num != null && num.length > 0) {
         Map<Integer, Integer> map = new HashMap();

         for(int i = num.length - 1; i >= 0; --i) {
            if (map.containsKey(num[i])) {
               min = i;
            }

            map.put(num[i], i);
         }
      }

      return Optional.of(num[min]).isPresent() ? num[min] : -1;
   }

   public static int firstRepeated(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         for(int j = i + 1; j < num.length; ++j) {
            if (num[i] == num[j]) {
               return num[i];
            }
         }
      }

      return 0;
   }

   public static int printFirstRepeating(int[] arr) {
      int min = -1;
      HashSet<Integer> set = new HashSet();

      for(int i = arr.length - 1; i >= 0; --i) {
         if (set.contains(arr[i])) {
            min = i;
         } else {
            set.add(arr[i]);
         }
      }

      if (min != -1) {
         System.out.println("The first repeating element is " + arr[min]);
         return arr[min];
      } else {
         System.out.println("There are no repeating elements");
         return -1;
      }
   }
}
