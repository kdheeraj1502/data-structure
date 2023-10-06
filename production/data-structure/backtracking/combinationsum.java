package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class combinationsum {
   public static void main(String[] args) {
      int[] a = new int[]{8, 1, 8, 6, 8};
      int sum = 12;
      ArrayList<Integer> arr = new ArrayList();

      for(int i = 0; i < a.length; ++i) {
         arr.add(a[i]);
      }

      HashSet<Integer> hs = new HashSet(arr);
      arr = new ArrayList(hs);
      Collections.sort(arr);
      ArrayList<ArrayList<Integer>> fans = new ArrayList();
      ArrayList<Integer> ans = new ArrayList();
      solve(arr, sum, fans, ans, 0);
      System.out.println(fans);
   }

   public static void solve(ArrayList<Integer> arr, int sum, ArrayList<ArrayList<Integer>> fans, ArrayList<Integer> ans, int lastcoinused) {
      if (sum >= 0) {
         if (sum == 0) {
            fans.add(new ArrayList(ans));
         } else {
            for(int i = lastcoinused; i < arr.size(); ++i) {
               ans.add(arr.get(i));
               solve(arr, sum - (Integer)arr.get(i), fans, ans, i);
               ans.remove(ans.size() - 1);
            }

         }
      }
   }

   public static void solve2(ArrayList<Integer> arr, int sum, ArrayList<ArrayList<Integer>> fans, ArrayList<Integer> ans, int i) {
      if (sum >= 0 && i < arr.size()) {
         if (sum == 0) {
            fans.add(new ArrayList(ans));
         } else {
            ans.add(arr.get(i));
            solve2(arr, sum - (Integer)arr.get(i), fans, ans, i);
            ans.remove(ans.size() - 1);
            solve2(arr, sum, fans, ans, i + 1);
         }
      }
   }
}
