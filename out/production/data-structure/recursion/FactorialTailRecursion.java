package recursion;

public class FactorialTailRecursion {
   public static int factorial_head_recursion(int n) {
      return n == 1 ? 1 : n * factorial_head_recursion(n - 1);
   }

   public static int factorial(int n, int result) {
      return n == 1 ? result : factorial(n - 1, n * result);
   }

   public static void main(String[] args) {
      System.out.println(factorial(5, 1));
      System.out.println(factorial_head_recursion(5));
   }
}
