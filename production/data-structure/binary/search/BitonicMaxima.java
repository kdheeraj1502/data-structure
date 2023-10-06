package binary.search;

public class BitonicMaxima {
   public static int getMaximaIndex(int[] num) {
      int start = 0;
      int end = num.length - 1;
      int result = -1;

      while(start <= end) {
         int mid = (start + end) / 2;
         if ((mid == num.length - 1 || num[mid] > num[mid + 1]) && (mid == 0 || num[mid] > num[mid - 1])) {
            result = mid;
            break;
         }

         if (num[mid] < num[mid + 1]) {
            start = mid + 1;
         } else if (num[mid] < num[mid - 1]) {
            end = mid - 1;
         }
      }

      return result;
   }

   public static void main(String[] args) {
      int[] num = new int[]{34, 57, 74, 76, 90, 25, 15, 11, 8};
      System.out.println(getMaximaIndex(num));
   }
}
