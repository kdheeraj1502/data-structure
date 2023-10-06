package recursion;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
   private static int fibonacci(int num, Map<Integer, Integer> memo) {
      if (num <= 1) {
         return num;
      } else if (memo.containsKey(num)) {
         return (Integer)memo.get(num);
      } else {
         memo.put(num, fibonacci(num - 1, memo) + fibonacci(num - 2, memo));
         return (Integer)memo.get(num);
      }
   }

   public static void main(String[] args) {
      int n = 9;
      Map<Integer, Integer> map = new HashMap();
      map.put(0, 0);
      map.put(1, 1);
      System.out.println(fibonacci(n, map));
      System.out.println(fibonacci_self(n, map));
   }

   private static int fibonacci_self(int num, Map<Integer, Integer> memo) {
      for(int i = 2; i <= num; ++i) {
         memo.put(i, (Integer)memo.get(i - 1) + (Integer)memo.get(i - 2));
      }

      return (Integer)memo.get(num);
   }
}
