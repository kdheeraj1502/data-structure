package array;

public class CancellationApproachForMajorityEle {
   public static void findMajority(int[] num) {
      int count = 1;
      int majIndex = 0;

      int i;
      for(i = 1; i < num.length; ++i) {
         int var10000 = num[majIndex];
         if (num[majIndex] == num[i]) {
            ++count;
         } else {
            --count;
         }

         if (count == 0) {
            majIndex = i;
            count = 1;
         }
      }

      int candidate = num[majIndex];
      count = 0;

      for(i = 0; i < num.length; ++i) {
         if (candidate == num[i]) {
            ++count;
         }
      }

      if (count > num.length / 2) {
         System.out.println("Majority is : " + num[majIndex]);
      } else {
         System.out.println("Majority not found, count is :" + count);
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 3, 5, 2, 5, 5, 3, 5, 8};
      findMajority(num);
   }
}
