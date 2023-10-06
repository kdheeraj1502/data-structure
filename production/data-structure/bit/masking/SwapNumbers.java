package bit.masking;

public class SwapNumbers {
   public static void main(String[] args) {
      int a = 17;
      int b = 51;
      a ^= b;
      b ^= a;
      a ^= b;
      System.out.println(a + " " + b);
   }
}
