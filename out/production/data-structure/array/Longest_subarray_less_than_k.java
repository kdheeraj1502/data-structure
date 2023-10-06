package array;

public class Longest_subarray_less_than_k {
   public static void main(String[] args) {
      template input = new template();
      int n = input.nextInt();
      int k = input.nextInt();
      int[] sub_a = new int[n];

      int sum;
      for(sum = 0; sum < n; ++sum) {
         sub_a[sum] = input.nextInt();
      }

      sum = 0;
      int ans = 0;
      int l = 0;

      for(int r = 0; r < n; ++r) {
         for(sum += sub_a[r]; sum > k; ++l) {
            sum -= sub_a[l];
         }

         ans = Math.max(ans, r - l + 1);
      }

      System.out.println(ans);
   }
}
