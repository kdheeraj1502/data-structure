package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ABCTriplet {
   public static void findTriplet(int[] num) {
      Arrays.sort(num);

      for(int i = num.length - 1; i >= 0; --i) {
         int j = 0;
         int k = i - 1;
         int var10000 = num[i];

         while(j < k) {
            int b = num[j];
            int c = num[k];
            int sum = b + c;
            if (num[i] == sum) {
               System.out.println("numbers are " + num[i] + " = " + num[j] + " + " + num[k]);
               ++j;
               --k;
            } else if (num[i] > sum) {
               ++j;
            } else {
               --k;
            }
         }
      }

   }

   public static void main(String[] args) {
      int[] num = new int[]{2, 7, 3, 5, -5, 8, -4, 1, 0, 12};
      new ArrayList();
      System.out.println("-----Found triplet--------");
      findTriplet(num);
      System.out.println("-----Found triplet self--------");
      findTriplet_self(num);
      System.out.println("-----Found triplet similar to self--------");
      findTriplets(num, num.length);
   }

   public static List<List<Integer>> abcTriplet(int[] num, List<List<Integer>> output) {
      Arrays.sort(num);
      int[] result = new int[3];

      for(int i = 0; i < num.length - 2; ++i) {
         int start = i + 1;
         int end = num.length - 1;
         int a = num[i];

         while(start < end) {
            int b = num[start];
            int c = num[end];
            int sum = b + c;
            if (a == sum) {
               result[0] = num[start];
               result[1] = num[i];
               result[2] = num[end];
               List<Integer> list = new ArrayList();
               list.add(num[start]);
               list.add(num[end]);
               list.add(num[i]);
               output.add(list);
               ++start;
               --end;
            } else if (a > sum) {
               ++start;
            } else {
               --end;
            }
         }
      }

      return output;
   }

   public static void numberSumBook(int[] num) {
      for(int i = 0; i < num.length; ++i) {
         int start = i + 1;
         int stop = num.length - 1;
         System.out.println("hi");

         while(start < stop) {
            if (num[i] == num[start] + num[stop]) {
               System.out.println("hello");
               System.out.println("Triplet ::%d, %d, %d" + num[i] + num[start + num[stop]]);
               ++start;
               --stop;
            } else if (num[i] > num[start] + num[stop]) {
               --stop;
            } else {
               ++start;
            }
         }
      }

   }

   public static void findTriplet_self(int[] num) {
      Arrays.sort(num);

      for(int i = num.length - 1; i >= 0; --i) {
         int start = 0;
         int end = i - 1;
         int c = num[i];

         while(start < end) {
            int a = num[start];
            int b = num[end];
            int sum = a + b;
            if (sum == c) {
               System.out.println("numbers are " + Math.abs(c) + " = " + a + " + " + b);
               ++start;
               --end;
            } else if (sum > c) {
               --end;
            } else {
               ++start;
            }
         }
      }

   }

   public static void findTriplets(int[] arr, int n) {
      boolean found = false;
      Arrays.sort(arr);

      for(int i = 0; i < n - 1; ++i) {
         int l = i + 1;
         int r = n - 1;
         int x = arr[i];

         while(l < r) {
            if (x + arr[l] + arr[r] == 0) {
               System.out.print(x + " ");
               System.out.print(arr[l] + " ");
               System.out.println(arr[r] + " ");
               ++l;
               --r;
               found = true;
            } else if (x + arr[l] + arr[r] < 0) {
               ++l;
            } else {
               --r;
            }
         }
      }

      if (!found) {
         System.out.println(" No Triplet Found");
      }

   }
}
