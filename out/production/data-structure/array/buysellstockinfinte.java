package array;

import java.util.Scanner;

public class buysellstockinfinte {
   public static void main(String[] args) {
      Scanner scn = new Scanner(System.in);
      int n = scn.nextInt();
      int[] arr = new int[n];

      for(int i = 0; i < arr.length; ++i) {
         arr[i] = scn.nextInt();
      }

      buysell(arr);
   }

   public static void buysell(int[] arr) {
      int buy = 0;
      int sell = 0;
      int profit = 0;

      while(buy < arr.length && sell < arr.length) {
         if (sell < arr.length - 1 && arr[sell] <= arr[sell + 1]) {
            ++sell;
         } else {
            profit += arr[sell] - arr[buy];
            ++sell;
            buy = sell;
         }
      }

      System.out.println(profit);
   }
}
