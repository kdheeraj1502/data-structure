package strings;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class secondmostrepeatedword {
   public static void main(String[] args) {
      String[] arr = new String[]{"aaa", "bbb", "ccc", "bbb", "aaa", "aaa"};
      repeat(arr);
   }

   public static void repeat(String[] arr) {
      Map<String, Integer> map = new HashMap();

      int max;
      for(max = 0; max < arr.length; ++max) {
         if (map.containsKey(arr[max])) {
            map.replace(arr[max], (Integer)map.get(arr[max]) + 1);
         } else {
            map.put(arr[max], 1);
         }
      }

      max = 0;
      int secondmax = 0;
      String maxstring = "";
      String secondmaxstring = "";
      Iterator var6 = map.entrySet().iterator();

      while(var6.hasNext()) {
         Map.Entry<String, Integer> item = (Map.Entry)var6.next();
         if ((Integer)item.getValue() > max) {
            secondmax = max;
            secondmaxstring = maxstring;
            max = (Integer)item.getValue();
            maxstring = (String)item.getKey();
         } else if ((Integer)item.getValue() > secondmax && (Integer)item.getValue() != max) {
            secondmax = (Integer)item.getValue();
            secondmaxstring = (String)item.getKey();
         }
      }

      System.out.println(secondmaxstring);
   }
}
