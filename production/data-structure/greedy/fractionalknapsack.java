package greedy;

import java.util.Arrays;

public class fractionalknapsack {
   public static void main(String[] args) {
   }

   public static double fractionalKnapsack(int W, Item[] arr, int n) {
      Arrays.sort(arr, new 1());
      int sumweight = 0;
      int i = 0;

      double maxvalue;
      for(maxvalue = 0.0; sumweight != W && i < arr.length; ++i) {
         if (arr[i].weight + sumweight > W) {
            double left = (double)(W - sumweight);
            double r = (double)arr[i].value / (double)arr[i].weight;
            maxvalue += left * r;
            int var10000 = (int)((double)sumweight + left);
            break;
         }

         sumweight += arr[i].weight;
         maxvalue += (double)arr[i].value;
      }

      return maxvalue;
   }
}
