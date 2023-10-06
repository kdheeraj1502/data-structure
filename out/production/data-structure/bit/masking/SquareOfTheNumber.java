package bit.masking;

public class SquareOfTheNumber {
   public static int square(int num) {
      if (num == 0) {
         return 0;
      } else if (num == 1) {
         return 1;
      } else {
         int square;
         int a;
         if ((num & 1) != 1) {
            a = square(num / 2) << 2;
            square = a;
         } else {
            a = (square(num / 2) << 2) + (num / 2 << 2) + 1;
            square = a;
         }

         return square;
      }
   }

   public static void main(String[] args) {
      System.out.println(square(10));
   }
}
