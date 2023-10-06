package backtracking;

public class kpartitionequalsum {
   public static void main(String[] args) {
      int[] arr = new int[]{2, 1, 5, 5, 6};
      int k = 3;
      System.out.println(isKPartitionPossible(arr, arr.length, k));
   }

   public static boolean isKPartitionPossible(int[] arr, int n, int k) {
      int presum = 0;
      if (k > n) {
         return false;
      } else {
         for(int i = 0; i < n; ++i) {
            presum += arr[i];
         }

         return presum % k != 0 ? false : partition(arr, k, 0, new int[k], 0);
      }
   }

   public static boolean partition(int[] arr, int k, int psf, int[] sumarr, int i) {
      int j;
      if (i == arr.length) {
         if (psf == k) {
            for(j = 0; j < sumarr.length - 1; ++j) {
               if (sumarr[j] != sumarr[j + 1]) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         for(j = 0; j < k; ++j) {
            if (sumarr[j] == 0) {
               sumarr[j] += arr[i];
               if (partition(arr, k, psf + 1, sumarr, i + 1)) {
                  return true;
               }

               sumarr[j] -= arr[i];
               break;
            }

            sumarr[j] += arr[i];
            if (partition(arr, k, psf, sumarr, i + 1)) {
               return true;
            }

            sumarr[j] -= arr[i];
         }

         return false;
      }
   }
}
