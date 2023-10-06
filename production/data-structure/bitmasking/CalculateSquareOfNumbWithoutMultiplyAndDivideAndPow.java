package bitmasking;

public class CalculateSquareOfNumbWithoutMultiplyAndDivideAndPow {
   public static int squareOf(int n) {
      if (n == 0) {
         return 0;
      } else if (n == 1) {
         return 1;
      } else {
         int square;
         if (isEven(n)) {
            square = squareOf(n / 2) << 2;
         } else {
            square = (squareOf(n / 2) << 2) + (n / 2 << 2) + 1;
         }

         return square;
      }
   }

   private static boolean isEven(int n) {
      return (n & 1) == 0;
   }

   public static void main(String[] args) {
      for(int i = 0; i < 30; ++i) {
         System.out.println(squareOf(i));
      }

   }
}
