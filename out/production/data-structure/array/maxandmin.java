package array;

public class maxandmin {
   public static int count = 0;
   public static int count2 = 0;

   public static void main(String[] args) {
      int[] arr = new int[]{1, -3, 6, -2, 23, 5, 3, 7, 9, 87, 56, 45, 12, 34, 20, 23};
      Pair ans = maxminpair(arr, arr.length - 1);
      System.out.println(ans.max);
      System.out.println(ans.min);
   }

   public static void maxminarray(int[] arr) {
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;

      for(int i = 0; i < arr.length; ++i) {
         if (arr[i] > max) {
            max = arr[i];
            ++count2;
         } else {
            ++count2;
         }

         if (arr[i] < min) {
            min = arr[i];
            ++count2;
         } else {
            ++count2;
         }
      }

      System.out.println(max);
      System.out.println(min);
   }

   public static Pair maxminarrayrecursive(int[] arr, int start, int end) {
      Pair minmax = new Pair();
      new Pair();
      new Pair();
      int mid = (start + end) / 2;
      if (start == end) {
         minmax.max = arr[start];
         minmax.min = arr[start];
         return minmax;
      } else {
         Pair mml = maxminarrayrecursive(arr, start, mid);
         Pair mmh = maxminarrayrecursive(arr, mid + 1, end);
         if (mml.min < mmh.min) {
            minmax.min = mml.min;
            ++count;
         } else {
            minmax.min = mmh.min;
            ++count;
         }

         if (mml.max < mmh.max) {
            minmax.max = mmh.max;
            ++count;
         } else {
            minmax.max = mml.max;
            ++count;
         }

         return minmax;
      }
   }

   public static Pair maxminpair(int[] arr, int n) {
      Pair maxmin = new Pair();
      int i = false;
      int j = false;
      int i;
      int j;
      if (n % 2 == 0) {
         i = 0;
         j = 1;
      } else {
         j = 0;
         i = 0;
      }

      while(j < arr.length) {
         if (arr[i] < arr[j]) {
            if (maxmin.min > arr[i]) {
               maxmin.min = arr[i];
            }

            if (maxmin.max < arr[j]) {
               maxmin.max = arr[j];
            }
         } else {
            if (maxmin.min > arr[j]) {
               maxmin.min = arr[j];
            }

            if (maxmin.max < arr[i]) {
               maxmin.max = arr[i];
            }
         }

         ++i;
         ++j;
      }

      return maxmin;
   }
}
