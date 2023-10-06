package dp;

public class permutationcoffecient {
   public static void main(String[] args) {
      System.out.println(npr(5, 2));
   }

   static int npr(int n, int r) {
      int ans = 1;

      for(int i = 0; i < r; ++i) {
         ans *= n - i;
      }

      return ans;
   }
}
