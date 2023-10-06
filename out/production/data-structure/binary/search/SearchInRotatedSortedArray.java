package binary.search;

public class SearchInRotatedSortedArray {
   public static int search(int[] num, int low, int high, int val) {
      int maximaIdex = getMaxIndex(num, 0, num.length - 1);
      if (num[maximaIdex] == val) {
         return maximaIdex;
      } else {
         int index = true;
         int index;
         if (num[low] <= val && val < num[maximaIdex]) {
            index = BinarySearch.search(num, 0, maximaIdex, val);
         } else {
            index = BinarySearch.search(num, maximaIdex + 1, high, val);
         }

         return index;
      }
   }

   public static int getMaxIndex(int[] num, int low, int high) {
      if (high < low) {
         return -1;
      } else {
         int mid = (low + high) / 2;
         int maxIndex = true;
         int maxIndex;
         if (mid != 0 && num[mid] <= num[mid - 1] || mid != num.length - 1 && num[mid] <= num[mid + 1]) {
            if (num[low] > num[mid]) {
               maxIndex = getMaxIndex(num, low, mid - 1);
            } else {
               maxIndex = getMaxIndex(num, mid + 1, high);
            }
         } else {
            maxIndex = mid;
         }

         return maxIndex;
      }
   }

   public static void main(String[] args) {
      int[] num = new int[]{74, 76, 90, 8, 11, 15, 25, 34, 57};
      int[] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int in = var2[var4];
         System.out.println(search(num, 0, num.length - 1, in));
      }

   }
}
