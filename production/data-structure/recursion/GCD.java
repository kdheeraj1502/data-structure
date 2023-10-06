package recursion;

public class GCD {
   private static int gcd(int a, int b) {
      return a % b != 0 ? gcd(b, a % b) : b;
   }

   public static void main(String[] args) {
      System.out.println(gcd(102, 85));
   }
}
