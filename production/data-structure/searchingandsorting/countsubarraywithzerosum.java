package searchingandsorting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class countsubarraywithzerosum {
   public static void main(String[] args) {
      int[] arr = new int[]{6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7};
      findSubarrayprint(arr, arr.length);
      System.out.println(findSubarray(arr, arr.length));
   }

   public static long findSubarray(int[] arr, int n) {
      int i = -1;
      int sum = 0;
      int count = 0;
      HashMap<Integer, Integer> map = new HashMap();
      map.put(sum, 1);

      while(i < n - 1) {
         ++i;
         sum += arr[i];
         if (map.containsKey(sum)) {
            count += (Integer)map.get(sum);
            map.replace(sum, (Integer)map.get(sum) + 1);
         } else {
            map.put(sum, 1);
         }
      }

      return (long)count;
   }

   public static void findSubarrayprint(int[] arr, int n) {
      int i = -1;
      int sum = 0;
      int count = false;
      HashMap<Integer, ArrayList<Integer>> map = new HashMap();
      ArrayList<Integer> list = new ArrayList();
      list.add(i);
      map.put(sum, list);

      while(true) {
         while(i < n - 1) {
            ++i;
            sum += arr[i];
            ArrayList l;
            if (map.containsKey(sum)) {
               l = (ArrayList)map.get(sum);
               Iterator var8 = l.iterator();

               while(var8.hasNext()) {
                  Integer idx = (Integer)var8.next();
                  System.out.println(idx + 1 + " - " + i);
               }

               l.add(i);
               map.replace(sum, l);
            } else {
               l = new ArrayList();
               l.add(i);
               map.put(sum, l);
            }
         }

         return;
      }
   }
}
