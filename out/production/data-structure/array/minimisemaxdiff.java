package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class minimisemaxdiff {
   public static void main(String[] args) {
      int[] arr = new int[]{6, 1, 9, 1, 1, 7, 9, 5, 2, 10};
      minimise(arr, 4, arr.length);
      System.out.println(getMinDiff(arr, arr.length, 4));
   }

   public static void minimise(int[] arr, int k, int n) {
      ArrayList<pair> list = new ArrayList();
      int[] visited = new int[n];

      int l;
      for(l = 0; l < arr.length; ++l) {
         pair p = new pair();
         p.value = arr[l] + k;
         p.ind = l;
         list.add(p);
         if (arr[l] - k >= 0) {
            pair a = new pair();
            a.value = arr[l] - k;
            a.ind = l;
            list.add(a);
         }
      }

      Collections.sort(list, new 1());
      l = 0;
      int r = 0;

      int ele;
      for(ele = 0; ele < n && r < list.size(); ++r) {
         if (visited[((pair)list.get(r)).ind] == 0) {
            ++ele;
         }

         ++visited[((pair)list.get(r)).ind];
      }

      int ans;
      for(ans = ((pair)list.get(r - 1)).value - ((pair)list.get(l)).value; r < list.size(); ans = Math.min(ans, ((pair)list.get(r - 1)).value - ((pair)list.get(l)).value)) {
         if (visited[((pair)list.get(l)).ind] == 1) {
            --ele;
         }

         --visited[((pair)list.get(l)).ind];
         ++l;

         while(ele < n && r < list.size()) {
            if (visited[((pair)list.get(r)).ind] == 0) {
               ++ele;
            }

            ++visited[((pair)list.get(r)).ind];
            ++r;
         }

         if (ele != n) {
            break;
         }
      }

      System.out.println(ans);
   }

   static int getMinDiff(int[] arr, int n, int k) {
      if (n == 1) {
         return 0;
      } else {
         Arrays.sort(arr);
         int ans = arr[n - 1] - arr[0];
         int small = arr[0] + k;
         int big = arr[n - 1] - k;
         int temp = false;
         if (small > big) {
            int temp = small;
            small = big;
            big = temp;
         }

         for(int i = 1; i < n - 1; ++i) {
            int subtract = arr[i] - k;
            int add = arr[i] + k;
            if (subtract < small && add > big) {
               if (big - subtract <= add - small) {
                  small = subtract;
               } else {
                  big = add;
               }
            }
         }

         return Math.min(ans, big - small);
      }
   }
}
