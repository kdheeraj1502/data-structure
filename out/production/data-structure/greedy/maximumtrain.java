package greedy;

import java.util.Arrays;

public class maximumtrain {
   public static void main(String[] args) {
      train[] arr = new train[]{new train(1000, 1030, 1), new train(1010, 1030, 1), new train(1000, 1020, 2), new train(1030, 1230, 2), new train(1200, 1230, 3), new train(900, 1005, 1)};
      maxtrain(arr, 3);
   }

   public static void maxtrain(train[] arr, int n) {
      Arrays.parallelSort(arr);
      int[] platform = new int[n + 1];

      int maxc;
      for(maxc = 0; maxc < platform.length; ++maxc) {
         platform[maxc] = -1;
      }

      maxc = 0;

      int i;
      for(i = 0; i < arr.length; ++i) {
         int pn = arr[i].pn;
         if (platform[pn] == -1) {
            ++maxc;
            platform[pn] = i;
         } else {
            int tn = platform[pn];
            if (arr[tn].dt < arr[i].at) {
               ++maxc;
               platform[pn] = i;
            }
         }
      }

      for(i = 0; i < platform.length; ++i) {
         System.out.println(platform[i]);
      }

      System.out.println(maxc);
   }
}
