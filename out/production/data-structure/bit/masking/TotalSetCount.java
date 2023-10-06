package bit.masking;

public class TotalSetCount {
   public static int setCount(int num) {
      int count;
      for(count = 0; num > 0; ++count) {
         num &= num - 1;
      }

      return count;
   }

   public static void main(String[] args) {
      int num = 18;
      System.out.println(setCount(num));
   }
}
