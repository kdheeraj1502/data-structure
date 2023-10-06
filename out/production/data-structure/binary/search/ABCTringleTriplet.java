package binary.search;

public class ABCTringleTriplet {
   public static void abcTringle(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int a = num[i];
         int start = i + 1;
         int end = num.length - 1;

         while(start < end && num[i] > 0 && num[start] > 0 && num[end] > 0) {
            int sum = num[start] + num[end];
            if (sum < a) {
               ++start;
            } else {
               System.out.println(num[start] + " + " + num[end] + " >= " + a);
               --end;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{-15, 11, -6, -35, -23, -2, -1, 0, 19, -91, 3, 13, 7, 8, 9, 12, 18, 82};
      abcTringle(num);
   }
}
