package array;

import java.util.Arrays;

public class MaxCountOfElementInArray {
   public static int findMaxCount(int[] num) {
      Arrays.sort(num);
      int currCount = 1;
      int maxCount = 1;
      int currEle = num[0];
      int maxEle = num[0];

      for(int i = 0; i < num.length - 1; ++i) {
         if (num[i] == num[i + 1]) {
            ++currCount;
         } else {
            currCount = 1;
            currEle = num[i + 1];
         }

         if (maxCount < currCount) {
            maxCount = currCount;
         }
      }

      return maxCount;
   }

   public static void main(String[] args) {
      int[] num = new int[]{4, 9, 6, 9, 1, 4, 1, 7, 6, 1, 9};
      count(num);
      System.out.println(Arrays.toString(num));
      System.out.println(findMaxCountUsingCountSort(num));
      System.out.println("===============================");
      System.out.println(findMaxCount(num));
      System.out.println(findMaxCountIsingCountSort_1(num));
   }

   public static int findMaxCountUsingCountSort(int[] num) {
      int[] aux = new int[100];

      int max;
      for(max = 0; max < num.length; ++max) {
         ++aux[num[max]];
      }

      max = 0;

      for(int i = 0; i < num.length; ++i) {
         max = Math.max(max, aux[num[i]]);
      }

      return max;
   }

   public static int findMaxCountIsingCountSort_1(int[] num) {
      int currCount = true;
      int maxCount = 1;
      int maxEle = num[0];
      int[] aux = new int[100];

      for(int i = 0; i < num.length; ++i) {
         ++aux[num[i]];
         int currCount = aux[num[i]];
         if (currCount > maxCount) {
            maxCount = currCount;
            maxEle = num[i];
         }
      }

      return maxEle;
   }

   public static void count(int[] num) {
      int[] aux = new int[100];

      int j;
      for(j = 0; j < num.length; ++j) {
         ++aux[num[j]];
      }

      j = 0;

      for(int i = 0; i < aux.length; ++i) {
         for(int val = aux[i]; val > 0; --val) {
            num[j++] = i;
         }
      }

   }
}
