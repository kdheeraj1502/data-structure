package searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;

public class foursum {
   public static void main(String[] args) {
   }

   public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int K) {
      Arrays.sort(arr);
      ArrayList<ArrayList<Integer>> fans = new ArrayList();

      for(int i = 0; i < arr.length; ++i) {
         for(int j = i + 1; j < arr.length; ++j) {
            int sum = K - arr[i] - arr[j];
            int k = j + 1;
            int l = arr.length - 1;

            while(true) {
               while(k < l) {
                  if (sum == arr[k] + arr[l]) {
                     ArrayList<Integer> ans = new ArrayList();
                     ans.add(arr[i]);
                     ans.add(arr[j]);
                     ans.add(arr[k]);
                     ans.add(arr[l]);
                     fans.add(ans);

                     while(k < l && arr[k] == (Integer)ans.get(2)) {
                        ++k;
                     }

                     while(k < l && arr[l] == (Integer)ans.get(3)) {
                        --l;
                     }
                  } else if (sum > arr[k] + arr[l]) {
                     ++k;
                  } else {
                     --l;
                  }
               }

               while(j + 1 < arr.length && arr[j] == arr[j + 1]) {
                  ++j;
               }
               break;
            }
         }

         while(i + 1 < arr.length && arr[i] == arr[i + 1]) {
            ++i;
         }
      }

      return fans;
   }
}
