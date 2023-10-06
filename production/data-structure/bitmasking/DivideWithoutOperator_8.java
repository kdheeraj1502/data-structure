package bitmasking;

public class DivideWithoutOperator_8 {
   public static void main(String[] args) {
      division1(10, 3);
   }

   public static void division1(int a, int b) {
      int q;
      for(q = 0; a >= b; ++q) {
         a -= b;
      }

      System.out.println(q);
      System.out.println(a);
   }
}
