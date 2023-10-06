package recursion;

public class Factorial_2 {
   public static int factorial(int n) {
      return n == 1 ? 1 : n * factorial(n - 1);
   }

   public static void main(String[] args) {
      System.out.println(factorial(6));
   }
}
