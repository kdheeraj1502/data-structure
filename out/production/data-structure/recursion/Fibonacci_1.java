package recursion;

public class Fibonacci_1 {
   public static int fibonacci(int num) {
      return num <= 2 ? 1 : fibonacci(num - 1) + fibonacci(num - 2);
   }

   public static void main(String[] args) {
      System.out.println(fibonacci(8));
   }
}
