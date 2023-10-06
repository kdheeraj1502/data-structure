package dynamic.programming.topdown;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
   public int fibonacci(int n, Map<Integer, Integer> memo) {
      if (!memo.containsKey(n)) {
         memo.put(n, this.fibonacci(n - 1, memo) + this.fibonacci(n - 2, memo));
      }

      return (Integer)memo.get(n);
   }

   public static void main(String[] args) {
      Map<Integer, Integer> memo = new HashMap();
      memo.put(0, 1);
      memo.put(1, 1);
      FibonacciNumber fn = new FibonacciNumber();
      System.out.println(fn.fibonacci(8, memo));
   }
}
