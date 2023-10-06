package array;

import java.util.Arrays;

public class CheckReverse {
   public static boolean checkReverse(int[] arr, int n) {
      if (n == 1) {
         return true;
      } else {
         int i;
         for(i = 1; arr[i - 1] < arr[i] && i < n; ++i) {
         }

         if (i == n) {
            return true;
         } else {
            int j;
            for(j = i; j < n && arr[j] < arr[j - 1]; ++j) {
               if (i > 1 && arr[j] < arr[i - 2]) {
                  return false;
               }
            }

            if (j == n) {
               return true;
            } else {
               int k = j;
               if (arr[j] < arr[i - 1]) {
                  return false;
               } else {
                  while(k > 1 && k < n) {
                     if (arr[k] < arr[k - 1]) {
                        return false;
                     }

                     ++k;
                  }

                  return true;
               }
            }
         }
      }
   }

   public static boolean checkReverse_sort(int[] num) {
      int[] temp = (int[])num.clone();
      int front = 0;
      int back = num.length - 1;
      Arrays.sort(temp);

      int i;
      for(i = 0; i < num.length; ++i) {
         if (temp[i] != num[i]) {
            front = i;
            break;
         }
      }

      for(i = num.length - 1; i >= 0; --i) {
         if (temp[i] != num[i]) {
            back = i;
            break;
         }
      }

      if (front >= back) {
         return true;
      } else {
         do {
            ++front;
            if (num[front - 1] < num[front]) {
               return false;
            }
         } while(front != back);

         return true;
      }
   }

   public static boolean checkReverse_sort_self(int[] num) {
      int[] temp = (int[])num.clone();
      int front = 0;
      int back = num.length - 1;
      Arrays.sort(temp);

      int i;
      for(i = 0; i < num.length; ++i) {
         if (temp[i] != num[i]) {
            front = i;
            break;
         }
      }

      for(i = num.length - 1; i >= 0; --i) {
         if (temp[i] != num[i]) {
            back = i;
            break;
         }
      }

      if (front >= back) {
         return true;
      } else {
         do {
            ++front;
            if (num[front - 1] < num[front]) {
               return false;
            }
         } while(front != back);

         return true;
      }
   }

   public static void main(String[] args) {
      int[] arr = new int[]{1, 5, 7, 10, 9, 6};
      int n = arr.length;
      System.out.println(checkReverse_sort_self(arr));
   }
}
