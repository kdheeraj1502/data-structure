package array;

public class SearchInRotatedArray {
   public static int searchInRotatedArray(int[] num, int key) {
      int maxIndex = MaxElementInArray.findMaxIndex(num);
      int index = true;
      int index;
      if (num[0] <= key && key <= num[maxIndex]) {
         index = searchFirst(num, 0, maxIndex, key);
      } else {
         index = searchFirst(num, maxIndex + 1, num.length, key);
      }

      return index != -1 ? index : -1;
   }

   public static int searchFirst(int[] num, int start, int end, int key) {
      while(start <= end) {
         int mid = (start + end) / 2;
         if (num[mid] == key) {
            return mid;
         }

         if (num[mid] < key) {
            start = mid + 1;
         } else {
            end = mid - 1;
         }
      }

      return -1;
   }

   public static void main(String[] args) {
      int[] num = new int[]{13, 14, 15, 1, 2, 3, 4};
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         Integer in = var2[var4];
         System.out.println(searchInRotatedArray(num, in));
      }

   }
}
