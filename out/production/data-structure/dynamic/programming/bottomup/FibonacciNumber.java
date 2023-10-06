package dynamic.programming.bottomup;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
   public static void main(String[] args) {
      Map<Integer, Integer> memo = new HashMap();
      memo.put(0, 1);
      memo.put(1, 1);
      FibonacciNumber fn = new FibonacciNumber();
      System.out.println(fn.fibonacci(999999, memo));
      memo.clear();
      System.out.println(fn.fibo(memo, 999999));
   }

   private int fibonacci(int n, Map<Integer, Integer> memo) {
      for(int i = 2; i <= n; ++i) {
         memo.put(i, (Integer)memo.get(i - 1) + (Integer)memo.get(i - 2));
      }

      return (Integer)memo.get(n);
   }

   public int fibo(Map<Integer, Integer> memo, int n) {
      if (n != 0 && n != 1) {
         if (memo.containsKey(n)) {
            memo.get(n);
         } else {
            memo.put(n, this.fibo(memo, n - 1) + this.fibo(memo, n - 2));
         }

         return (Integer)memo.get(n);
      } else {
         return 1;
      }
   }
}
