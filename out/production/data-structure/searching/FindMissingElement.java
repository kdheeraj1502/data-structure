package searching;

public class FindMissingElement {
   public static int findMissingNumber(int[] num) {
      int found = false;

      for(int i = 1; i < num.length; ++i) {
         found = false;

         for(int j = 0; j < num.length; ++j) {
            if (num[j] == i) {
               found = true;
               break;
            }
         }

         if (!found) {
            return i;
         }
      }

      return Integer.MAX_VALUE;
   }

   public static int findMissingNumberMath(int[] num) {
      int min = Integer.MAX_VALUE;
      int max = Integer.MIN_VALUE;

      int i;
      for(i = 0; i < num.length; ++i) {
         if (min > num[i]) {
            min = num[i];
         }

         if (max < num[i]) {
            max = num[i];
         }
      }

      i = 0;
      if (min > 0) {
         i = (min - 1) * (min - 1 + 1) / 2;
      }

      int maxTotal = max * (max + 1) / 2;
      int expectedTotal = maxTotal - i;
      int arrayTotal = 0;

      for(int i = 0; i < num.length; ++i) {
         arrayTotal += num[i];
      }

      return Math.abs(arrayTotal - expectedTotal);
   }
}
