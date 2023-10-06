package searchingandsorting;

public class repeatingandmissing {
   public static void main(String[] args) {
   }

   int[] findTwoElement(int[] arr, int n) {
      int duplicate = 0;
      int missing = 0;
      int[] vis = new int[n + 1];

      int i;
      for(i = 0; i < n; ++i) {
         if (vis[arr[i]] == 1) {
            duplicate = arr[i];
         }

         vis[arr[i]] = 1;
      }

      for(i = 1; i <= n; ++i) {
         if (vis[i] == 0) {
            missing = i;
            break;
         }
      }

      int[] ans = new int[]{duplicate, missing};
      return ans;
   }

   int[] findTwoElementopti(int[] arr, int n) {
      int z = 0;

      int rightsetbit;
      for(rightsetbit = 0; rightsetbit < n; ++rightsetbit) {
         z ^= arr[rightsetbit];
      }

      for(rightsetbit = 1; rightsetbit <= n; ++rightsetbit) {
         z ^= rightsetbit;
      }

      rightsetbit = z & ~(z - 1);
      int set = 0;
      int reset = 0;

      int missing;
      for(missing = 0; missing < n; ++missing) {
         if ((arr[missing] & rightsetbit) != 0) {
            set ^= arr[missing];
         } else {
            reset ^= arr[missing];
         }
      }

      for(missing = 1; missing <= n; ++missing) {
         if ((missing & rightsetbit) != 0) {
            set ^= missing;
         } else {
            reset ^= missing;
         }
      }

      missing = 0;
      int duplicate = 0;

      for(int i = 0; i < n; ++i) {
         if (set == arr[i]) {
            duplicate = set;
            missing = reset;
            break;
         }

         if (reset == arr[i]) {
            duplicate = reset;
            missing = set;
            break;
         }
      }

      int[] ans = new int[]{duplicate, missing};
      return ans;
   }
}
