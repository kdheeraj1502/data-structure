package binary.search;

public class MajorityElementInArrayNby2TIme {
   public static int majorityEle(int[] num) {
      int j = 0;
      int len = num.length / 2 + 1;
      int result = -1;

      for(int i = 0; i < num.length && j < num.length; ++i) {
         j = i + len;
         if (num[i] == num[j]) {
            result = num[j];
            break;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, 6, 7, 3, 5, 2, 3, 2, 3, 3, 3, 5, 3, 3, 3, 3, 3, 5, 3};
      System.out.println(majorityEle(num));
   }
}
