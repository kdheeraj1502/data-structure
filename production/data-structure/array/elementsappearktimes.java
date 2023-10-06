package array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class elementsappearktimes {
   public static void main(String[] args) {
      int[] arr = new int[]{3, 1, 2, 2, 1, 2, 3, 3};
      ktimes(arr, 4);
   }

   public static void ktimes(int[] arr, int k) {
      HashMap<Integer, Integer> map = new HashMap();

      for(int i = 0; i < arr.length; ++i) {
         if (map.containsKey(arr[i])) {
            map.put(arr[i], (Integer)map.get(arr[i]) + 1);
         } else {
            map.put(arr[i], 1);
         }
      }

      Iterator var6 = map.entrySet().iterator();

      while(var6.hasNext()) {
         Map.Entry m = (Map.Entry)var6.next();
         int value = (Integer)m.getValue();
         if (value > arr.length / k) {
            System.out.println(m.getKey());
         }
      }

   }
}
