package bit.masking;

public class BitShiftToFInd1Or0 {
   public static int findBitVal(int num, int i) {
      return (num & 1 << i) == 0 ? 0 : 1;
   }

   public static void main(String[] args) {
      int num = 88;
      int i = 5;
      System.out.println(findBitVal(num, i));
   }
}
