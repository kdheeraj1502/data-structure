package array;

import java.util.ArrayList;
import java.util.List;

public class MaxPathSum {
   public static int maxPathSum(int[] num1, int[] num2) {
      int i = 0;
      int j = 0;
      int result = 0;
      int sum1 = 0;
      int sum2 = 0;
      List<Integer> num1List = new ArrayList();
      List<Integer> num2List = new ArrayList();

      while(i < num1.length && j < num2.length) {
         if (num1[i] < num2[j]) {
            System.out.println(num1[i]);
            num1List.add(num1[i]);
            sum1 += num1[i++];
         } else if (num2[j] < num1[i]) {
            System.out.println(num2[j]);
            num2List.add(num2[j]);
            sum2 += num2[j++];
         } else {
            result += Math.max(sum1, sum2);
            System.out.print("num of i is " + num1[i] + ", ");
            result += num2[j];
            System.out.print("num of j is :" + num2[j] + ", ");
            System.out.println();
            sum1 = 0;
            sum2 = 0;
            ++i;
            ++j;
         }
      }

      while(i < num1.length) {
         sum1 += num1[i++];
      }

      while(j < num1.length) {
         sum2 += num2[j++];
      }

      result += Math.max(sum1, sum2);
      return result;
   }

   public static void main(String[] args) {
      int[] num1 = new int[]{12, 13, 18, 20, 22, 26, 70};
      int[] num2 = new int[]{11, 15, 18, 19, 20, 26, 30, 31};
      int sum = maxPathSum(num1, num2);
      System.out.println(sum);
   }
}
