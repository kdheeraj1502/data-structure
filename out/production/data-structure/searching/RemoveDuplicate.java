package searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class RemoveDuplicate {
   public static int[] removeDuplicate(int[] num) {
      Map<Integer, Integer> map = new HashMap();

      for(int i = 0; i < num.length; ++i) {
         if (!map.containsValue(num[i])) {
            map.put(i, num[i]);
         }
      }

      int[] result = new int[map.size()];
      int i = 0;

      Map.Entry entry;
      for(Iterator var4 = map.entrySet().iterator(); var4.hasNext(); result[i++] = (Integer)entry.getValue()) {
         entry = (Map.Entry)var4.next();
      }

      return result;
   }

   public static int[] removeDuplicateUseArray(int[] num) {
      Arrays.sort(num);
      int j = 0;

      for(int i = 0; i < num.length; ++i) {
         if (num[i] != num[j]) {
            ++j;
            num[j] = num[i];
         }
      }

      int[] result = Arrays.copyOf(num, j + 1);
      return result;
   }
}
