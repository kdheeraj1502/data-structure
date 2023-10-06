package backtracking;

import java.util.ArrayList;

public class kthpermutation {
   public static int c = 0;

   public static void main(String[] args) {
      int n = 3;
      int k = 2;
      String s = "";
      ArrayList<Integer> arr = new ArrayList();

      for(int i = 1; i <= n; ++i) {
         s = s + i;
         arr.add(i);
      }

      solve(s, "", k);
      solveopti(arr, k);
   }

   public static void solve(String s, String ans, int k) {
      if (s.length() == 0) {
         ++c;
         if (c == k) {
            System.out.println(ans);
         }

      } else {
         for(int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            String res = s.substring(0, i) + s.substring(i + 1);
            solve(res, ans + ch, k);
         }

      }
   }

   public static void solveopti(ArrayList<Integer> arr, int k) {
      int[] fact = new int[10];
      fact[0] = 1;

      for(int i = 1; i < fact.length; ++i) {
         fact[i] = fact[i - 1] * i;
      }

      --k;
      String ans = "";

      while(true) {
         int bs = fact[arr.size() - 1];
         int fni = k / bs;
         int fn = (Integer)arr.get(fni);
         ans = ans + fn;
         arr.remove(fni);
         if (arr.size() == 0) {
            System.out.println(ans);
            return;
         }

         k %= bs;
      }
   }
}
