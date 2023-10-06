package binary.search;

public class BalancePoint {
   public static int balancePoint(int[] num) {
      int first = 0;
      int second = 0;

      int balanceIndex;
      for(balanceIndex = 1; balanceIndex < num.length; ++balanceIndex) {
         second += num[balanceIndex];
      }

      balanceIndex = -1;

      for(int i = 0; i < num.length; ++i) {
         if (first == second) {
            balanceIndex = i;
            break;
         }

         if (i < num.length - 1) {
            first += num[i];
         }

         second -= num[i + 1];
      }

      return balanceIndex;
   }

   public static void main(String[] args) {
      int[] num = new int[]{90, 8, 11, 10, 9, 7, 15, 1, 25, 34, 1, 57, 3, 74, 76};
      System.out.println(balancePoint(num));
   }
}
