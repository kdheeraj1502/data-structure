package array;

public class medianoftwosortedarray {
   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 3};
      int[] arr2 = new int[]{2};
      System.out.println(median(arr1, arr2));
   }

   public static double median(int[] arr1, int[] arr2) {
      if (arr1.length > arr2.length) {
         return median(arr2, arr1);
      } else {
         int n = arr1.length;
         int m = arr2.length;
         int start = 0;
         int end = n;

         while(start <= end) {
            int pivotx = (start + end) / 2;
            int pivoty = (n + m + 1) / 2 - pivotx;
            int xleft = pivotx == 0 ? Integer.MIN_VALUE : arr1[pivotx - 1];
            int xright = pivotx == n ? Integer.MAX_VALUE : arr1[pivotx];
            int yleft = pivoty == 0 ? Integer.MIN_VALUE : arr2[pivoty - 1];
            int yright = pivoty == m ? Integer.MAX_VALUE : arr2[pivoty];
            if (xleft <= yright && yleft <= xright) {
               if ((n + m) % 2 == 0) {
                  return (double)(Math.max(xleft, yleft) + Math.min(xright, yright)) / 2.0;
               }

               return (double)Math.max(xleft, yleft);
            }

            if (arr2[pivoty - 1] > arr1[pivotx]) {
               start = pivotx + 1;
            } else {
               --end;
            }
         }

         return 0.0;
      }
   }
}
