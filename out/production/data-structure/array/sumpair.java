package array;

import java.util.HashMap;
import java.util.Map;

public class sumpair {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 2, 3, 1, 4, 3};
      sumpair(arr, 6);
   }

   public static void sumpair(int[] arr, int k) {
      Map<Integer, Integer> temp = new HashMap();

      int sumpair;
      for(sumpair = 0; sumpair < arr.length; ++sumpair) {
         if (temp.containsKey(arr[sumpair])) {
            temp.put(arr[sumpair], (Integer)temp.get(arr[sumpair]) + 1);
         } else {
            temp.put(arr[sumpair], 1);
         }
      }

      sumpair = 0;

      for(int i = 0; i < arr.length; ++i) {
         if (temp.containsKey(k - arr[i])) {
            sumpair += (Integer)temp.get(k - arr[i]);
         }

         if (k - arr[i] == arr[i]) {
            --sumpair;
         }
      }

      System.out.println(sumpair / 2);
   }
}
