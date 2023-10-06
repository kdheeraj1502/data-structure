package bit.masking;

public class SetBitCountFrom1ToN {
   public static int largestPowerOf2(int N) {
      int x;
      for(x = 0; 1 << x <= N; ++x) {
      }

      return x - 1;
   }

   public static int setCount(int N) {
      if (N == 0) {
         return 0;
      } else {
         int x = largestPowerOf2(N);
         int bitUpTo2RaiseX = x * (1 << x - 1);
         int setCountForRemaining = N - (1 << x) + 1;
         int remaing = N - (1 << x);
         int result = bitUpTo2RaiseX + setCountForRemaining + setCount(remaing);
         return result;
      }
   }

   public static void main(String[] args) {
      System.out.println(setCount(1000000000));
   }
}
