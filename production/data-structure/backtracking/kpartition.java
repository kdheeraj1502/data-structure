package backtracking;

import java.util.ArrayList;

public class kpartition {
   public static void main(String[] args) {
      int[] arr = new int[]{1, 5, 11, 5};
      int k = 2;
      ArrayList<ArrayList<Integer>> ans = new ArrayList();

      for(int i = 0; i < k; ++i) {
         ArrayList<Integer> a = new ArrayList();
         ans.add(a);
      }

      partition(arr, 0, k, 0, ans, new int[k]);
   }

   public static void partition(int[] arr, int i, int k, int psf, ArrayList<ArrayList<Integer>> ans, int[] sum) {
      if (k <= arr.length) {
         if (i == arr.length) {
            if (psf == k) {
               boolean flag = true;

               for(int j = 0; j < sum.length - 1; ++j) {
                  if (sum[j] != sum[j + 1]) {
                     flag = false;
                     break;
                  }
               }

               if (flag) {
                  System.out.println(ans);
               }
            }

         } else {
            for(int j = 0; j < k; ++j) {
               if (((ArrayList)ans.get(j)).size() <= 0) {
                  ((ArrayList)ans.get(j)).add(arr[i]);
                  sum[j] += arr[i];
                  partition(arr, i + 1, k, psf + 1, ans, sum);
                  sum[j] -= arr[i];
                  ((ArrayList)ans.get(j)).remove(((ArrayList)ans.get(j)).size() - 1);
                  break;
               }

               ((ArrayList)ans.get(j)).add(arr[i]);
               sum[j] += arr[i];
               partition(arr, i + 1, k, psf, ans, sum);
               sum[j] -= arr[i];
               ((ArrayList)ans.get(j)).remove(((ArrayList)ans.get(j)).size() - 1);
            }

         }
      }
   }
}
