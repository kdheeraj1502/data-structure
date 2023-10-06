package searchingandsorting;

public class trailling0infactorial {
   public static void main(String[] args) {
      System.out.println(fact(85));
      fact2(22);
   }

   public static int fact(int n) {
      int a = 5;

      int c;
      for(c = 0; n / a != 0; a *= 5) {
         c += n / a;
      }

      return c;
   }

   public static void fact2(int n) {
      int lo = 0;
      int hi = 5 * n;

      while(lo <= hi) {
         int mid = lo + (hi - lo) / 2;
         if (fact(mid) >= n) {
            hi = mid - 1;
         } else {
            lo = mid + 1;
         }
      }

      System.out.println(lo);
   }
}
