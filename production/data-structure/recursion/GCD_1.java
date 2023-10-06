package recursion;

public class GCD_1 {
   public static int gcd(int a, int b) {
      return a % b != 0 ? gcd(b % a, a) : b;
   }

   public static void main(String[] args) {
      System.out.println(gcd(51, 85));
   }
}
