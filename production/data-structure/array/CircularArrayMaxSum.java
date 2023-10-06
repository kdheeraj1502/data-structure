package array;

public class CircularArrayMaxSum {
   static int maxSum(int[] arr, int n) {
      int cum_sum = 0;

      int curr_val;
      for(curr_val = 0; curr_val < n; ++curr_val) {
         cum_sum += arr[curr_val];
      }

      curr_val = 0;

      int res;
      for(res = 0; res < n; ++res) {
         System.out.println(" i " + res + " arr[i] " + arr[res] + " multiply = " + res * arr[res] + " curr_val is " + curr_val);
         curr_val += res * arr[res];
      }

      System.out.println("Sum is " + cum_sum + " and Val is " + curr_val);
      res = curr_val;

      for(int i = 1; i < n; ++i) {
         int next_val = curr_val - (cum_sum - arr[i - 1]) + arr[i - 1] * (n - 1);
         System.out.println(next_val + " =  " + curr_val + " -  (" + cum_sum + " - " + arr[i - 1] + " ) = " + (cum_sum - arr[i - 1]) + " + " + arr[i - 1] + " * ( " + n + " - " + 1 + " ) = " + arr[i - 1] * (n - 1));
         curr_val = next_val;
         res = Math.max(res, next_val);
      }

      return res;
   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 1, 3, 2};
      System.out.println(maxSum(num, num.length));
   }
}
