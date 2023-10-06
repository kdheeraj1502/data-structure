package greedy;

public class smallestnowithgivensum {
   public static void main(String[] args) {
      int s = 36;
      int d = 4;
      solve(s, d, "");
      System.out.println(solve2(s, d));
   }

   public static boolean solve(int s, int d, String ans) {
      if (d == 0) {
         if (s == 0 && ans.charAt(0) != '0') {
            System.out.println(ans);
            return true;
         } else {
            return false;
         }
      } else {
         for(int i = 9; i >= 0; --i) {
            if (s >= i && solve(s - i, d - 1, i + ans)) {
               return true;
            }
         }

         return false;
      }
   }

   public static String solve2(int s, int d) {
      String ans = "";
      if (9 * d < s) {
         return "-1";
      } else {
         for(int i = d; i > 0; --i) {
            if (s <= 9) {
               if (i == 1) {
                  ans = s + ans;
                  return ans;
               }

               ans = s - 1 + ans;
               --i;

               while(i > 1) {
                  ans = "0" + ans;
                  --i;
               }

               ans = "1" + ans;
               return ans;
            }

            ans = "9" + ans;
            s -= 9;
         }

         return ans;
      }
   }
}
