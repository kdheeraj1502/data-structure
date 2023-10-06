package array;

public class SubArraySum {
   public static int subArraySum(int[] num, int val) {
      int first = 0;
      int second = 0;
      int sum = num[first];

      while(first < num.length && second < num.length) {
         if (sum == val) {
            System.out.println(first + " " + second);
            int add = 0;

            for(int i = first; i <= second; ++i) {
               add += num[i];
            }

            System.out.print("Nums are " + num[first] + " and " + num[second] + " and sum is " + sum);
            System.out.println(" add is " + add);
         }

         if (sum < val) {
            ++second;
            if (second < num.length) {
               sum += num[second];
            }
         } else {
            sum -= num[first];
            ++first;
         }
      }

      return sum;
   }

   public static int subArraySum_self(int[] num, int val) {
      int one = 0;
      int two = 0;
      int sum = num[one];

      while(one < num.length && two < num.length) {
         if (sum == val) {
            System.out.println("Index first is : " + two + " index second is : " + one);
         }

         if (sum < val) {
            ++one;
            if (one < num.length) {
               sum += num[one];
            }
         } else {
            sum -= num[two];
            ++two;
         }
      }

      return sum;
   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 1, 2, 3, 4, 5, 6, 4, 2};
      System.out.println(subArraySum_self(num, 24));
   }
}
