package searchingandsorting;

public class maxsumnoadjacent {
   public static void main(String[] args) {
   }

   public int FindMaxSum(int[] arr, int n) {
      int exc = 0;
      int inc = arr[0];

      for(int i = 1; i < n; ++i) {
         int temp = inc;
         inc = exc + arr[i];
         exc = Math.max(temp, exc);
      }

      return Math.max(inc, exc);
   }
}
