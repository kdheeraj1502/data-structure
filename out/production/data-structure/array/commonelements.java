package array;

public class commonelements {
   public static void main(String[] args) {
      int[] A = new int[]{1, 5, 10, 20, 40, 80, 100, 100};
      int[] B = new int[]{6, 7, 20, 80, 100, 100};
      int[] C = new int[]{3, 4, 15, 20, 30, 70, 80, 100, 100, 120};
      ce(A, B, C);
   }

   public static void ce(int[] arr1, int[] arr2, int[] arr3) {
      int i = 0;
      int j = 0;
      int k = 0;
      int last = 0;

      while(i < arr1.length && j < arr2.length && k < arr3.length) {
         if (arr1[i] > arr2[j] && arr1[i] > arr3[k]) {
            ++j;
            ++k;
         } else if (arr2[j] > arr1[i] && arr2[j] > arr3[k]) {
            ++i;
            ++k;
         } else if (arr3[k] > arr1[i] && arr3[k] > arr2[j]) {
            ++i;
            ++j;
         } else if (arr1[i] == arr2[j] && arr1[i] == arr3[k]) {
            if (last != arr1[i]) {
               System.out.println(arr1[i]);
            }

            last = arr1[i];
            ++i;
            ++k;
            ++j;
         } else if (arr1[i] >= arr2[j] && arr1[i] >= arr3[k]) {
            if (arr2[j] >= arr1[i] && arr2[j] >= arr3[k]) {
               if (arr3[k] < arr1[i] || arr3[k] < arr2[j]) {
                  ++k;
               }
            } else {
               ++j;
            }
         } else {
            ++i;
         }
      }

   }
}
