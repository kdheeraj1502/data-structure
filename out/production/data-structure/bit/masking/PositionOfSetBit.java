package bit.masking;

public class PositionOfSetBit {
   static int findPosition(int N) {
      int position = 0;
      if (N != 0 && (N & N - 1) == 0) {
         while(N > 0) {
            if ((N & 1 << position) > 0) {
               return position + 1;
            }

            ++position;
         }

         return position + 1;
      } else {
         return -1;
      }
   }

   public static void main(String[] args) {
      System.out.println(findPosition(1));
   }
}
