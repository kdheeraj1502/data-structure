package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class minplatforms {
   public static void main(String[] args) {
      int[] arrival = new int[]{2200, 900, 2230};
      int[] dept = new int[]{800, 2200, 2250};
      train[] arr = new train[2];

      for(int i = 0; i < arr.length; ++i) {
         if (arrival[i] >= dept[i]) {
            arr[i] = new train(1, 2);
         } else {
            arr[i] = new train(arrival[i], dept[i]);
         }
      }

      System.out.println(findPlatform(arrival, dept, dept.length));
      solve(arr);
   }

   public static void solve(train[] arr) {
      Arrays.parallelSort(arr);
      int maxp = 1;
      PriorityQueue<train> heap = new PriorityQueue();
      heap.add(new train(arr[0].dt, arr[0].at));

      for(int i = 1; i < arr.length; ++i) {
         if (((train)heap.peek()).at < arr[i].at) {
            train rv = (train)heap.remove();
            System.out.println(rv.dt + " - " + rv.at);
         } else {
            ++maxp;
         }

         heap.add(new train(arr[i].dt, arr[i].at));
      }

      System.out.println(maxp);
   }

   static int findPlatform(int[] arr, int[] dep, int n) {
      Arrays.sort(arr);
      Arrays.sort(dep);
      int maxplat = 1;
      int i = 1;

      for(int j = 0; i < arr.length; ++i) {
         if (arr[i] <= dep[j]) {
            ++maxplat;
         } else {
            ++j;
         }
      }

      return maxplat;
   }
}
