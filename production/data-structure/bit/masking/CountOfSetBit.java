package bit.masking;

public class CountOfSetBit {
   public static void main(String[] args) {
      int n = 4;

      int count;
      for(count = 0; n > 0; ++count) {
         n &= n - 1;
      }

      System.out.println(count);
   }
}
