package searchingandsorting;

public class mergewithoutspace {
   public static void main(String[] args) {
      int[] arr1 = new int[]{1, 1, 1, 2, 3, 4, 4, 5, 5, 5, 7, 8, 8, 9, 9, 10, 11, 12, 12, 13, 13, 15, 16, 16, 16, 18, 20};
      int[] arr2 = new int[]{1, 2, 2, 2, 3, 3, 4, 6, 7, 8, 8, 9, 9, 11, 11, 12, 13, 14, 14, 15, 16, 18, 19, 20};
      merge(arr1, arr2, arr1.length, arr2.length);

      int i;
      for(i = 0; i < arr1.length; ++i) {
         System.out.println(arr1[i]);
      }

      for(i = 0; i < arr2.length; ++i) {
         System.out.println(arr2[i]);
      }

   }

   public static void merge(int[] arr1, int[] arr2, int n, int m) {
      int ts = n + m;
      int rem = ts % 2;
      int gap = ts / 2 + rem;
      int i = 0;
      int j = gap;

      while(true) {
         int temp;
         while(i >= n || j >= n) {
            if (j >= n) {
               j -= n;
            }

            while(i < n && j < m) {
               if (arr1[i] > arr2[j]) {
                  temp = arr1[i];
                  arr1[i] = arr2[j];
                  arr2[j] = temp;
               }

               ++i;
               ++j;
            }

            if (i >= n) {
               i -= n;
            }

            while(j < m) {
               if (arr2[i] > arr2[j]) {
                  temp = arr2[i];
                  arr2[i] = arr2[j];
                  arr2[j] = temp;
               }

               ++i;
               ++j;
            }

            if (gap == 1) {
               return;
            }

            rem = gap % 2;
            gap = gap / 2 + rem;
            i = 0;
            j = gap;
         }

         if (arr1[i] > arr1[j]) {
            temp = arr1[i];
            arr1[i] = arr1[j];
            arr1[j] = temp;
         }

         ++i;
         ++j;
      }
   }
}
