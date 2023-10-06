package dynamic.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class LongestSubSequence {
   public int lengthOfLIS(int[] nums) {
      int len = nums.length;
      if (len == 0) {
         return 0;
      } else {
         int[] dp = new int[len];
         dp[0] = 1;
         int max = false;

         for(int i = 1; i < dp.length; ++i) {
            int max = 0;

            for(int j = 0; j < i; ++j) {
               if (nums[j] < nums[i] && dp[j] > max) {
                  max = dp[j];
               }

               dp[i] = max + 1;
            }

            max = Math.max(dp[i], max);
         }

         return Arrays.stream(dp).max().getAsInt();
      }
   }

   public static void findLIS(int[] arr) {
      if (arr != null && arr.length != 0) {
         List<List<Integer>> result = new ArrayList();

         int j;
         for(j = 0; j < arr.length; ++j) {
            result.add(new ArrayList());
         }

         ((List)result.get(0)).add(arr[0]);

         int i;
         for(j = 1; j < arr.length; ++j) {
            for(i = 0; i < j; ++i) {
               if (arr[i] < arr[j] && ((List)result.get(i)).size() > ((List)result.get(j)).size()) {
                  result.set(j, new ArrayList((Collection)result.get(i)));
               }
            }

            ((List)result.get(j)).add(arr[j]);
         }

         j = 0;

         for(i = 0; i < arr.length; ++i) {
            if (((List)result.get(j)).size() < ((List)result.get(i)).size()) {
               j = i;
            }
         }

         System.out.print(result.get(j));
      }
   }

   public static List<Integer> findLIS_self(int[] num) {
      if (num.length == 0) {
         return null;
      } else {
         List<List<Integer>> result = new ArrayList();

         int j;
         for(j = 0; j < num.length; ++j) {
            result.add(new ArrayList());
         }

         ((List)result.get(0)).add(1);

         int i;
         for(j = 1; j < num.length; ++j) {
            for(i = 0; i < num.length; ++i) {
               if (num[i] < num[j] && ((List)result.get(i)).size() > ((List)result.get(j)).size()) {
                  result.set(j, new ArrayList((Collection)result.get(i)));
               }
            }

            ((List)result.get(j)).add(num[j]);
         }

         j = 0;

         for(i = 1; i < result.size(); ++i) {
            if (((List)result.get(j)).size() < ((List)result.get(i)).size()) {
               j = i;
            }
         }

         return (List)result.get(j);
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
      int[] var10000 = new int[]{2, 3, 7, 101};
      LongestSubSequence lss = new LongestSubSequence();
      System.out.println(lss.lengthOfLIS(num));
      findLIS(num);
      System.out.println();
      System.out.println(findLIS_self(num));
   }
}
