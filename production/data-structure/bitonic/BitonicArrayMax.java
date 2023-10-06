package bitonic;

public class BitonicArrayMax {
   public static int bitonicArrayMax(int[] num) {
      int start = 0;
      int end = num.length - 1;
      int mid = (start + end) / 2;
      int maximaFound = false;
      if (num.length < 3) {
         System.out.println("error");
         return 0;
      } else {
         while(start <= end) {
            mid = (start + end) / 2;
            if (num[mid - 1] < num[mid] && num[mid] > num[mid + 1]) {
               maximaFound = true;
               break;
            }

            if (num[mid - 1] < num[mid] && num[mid] < num[mid + 1]) {
               start = mid + 1;
            } else {
               if (num[mid - 1] <= num[mid] || num[mid + 1] >= num[mid]) {
                  break;
               }

               end = mid - 1;
            }
         }

         if (!maximaFound) {
            System.out.println("error");
            return 0;
         } else {
            return num[mid];
         }
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
      System.out.println(bitonicArrayMaxSelf(num));
   }

   public static int bitonicArrayMaxSelf(int[] num) {
      int start = 0;
      int end = num.length - 1;
      int maxFound = false;
      int mid = (start + end) / 2;

      while(start <= end) {
         mid = (start + end) / 2;
         if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1]) {
            maxFound = true;
            break;
         }

         if (num[mid] < num[mid + 1] && num[mid] > num[mid - 1]) {
            start = mid + 1;
         } else {
            if (num[mid] >= num[mid - 1] || num[mid] <= num[mid + 1]) {
               break;
            }

            end = mid - 1;
         }
      }

      return maxFound ? num[mid] : 0;
   }
}
