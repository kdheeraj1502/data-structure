package reverse;

public class ReverseInteger {
   public int reverse(int num, int reversed) {
      if (num == 0) {
         return reversed;
      } else {
         int remainder = num % 10;
         int divide = num / 10;
         return this.reverse(divide, reversed * 10 + remainder);
      }
   }

   public int reverse_iteration(int num) {
      int reversed = 0;

      int remainder;
      for(int remainder = false; num > 0; reversed = reversed * 10 + remainder) {
         remainder = num % 10;
         num /= 10;
      }

      return reversed;
   }

   public static void main(String[] args) {
      ReverseInteger ri = new ReverseInteger();
      System.out.println(ri.reverse_iteration(880686902));
   }
}
