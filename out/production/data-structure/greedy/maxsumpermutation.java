package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class maxsumpermutation {
   public static void main(String[] args) {
      int[] a = new int[]{1, 2, 4, 8};
      ArrayList<Integer> arr = new ArrayList();

      for(int i = 0; i < a.length; ++i) {
         arr.add(a[i]);
      }

      maxsumoptimised(a);
      maxsumoptimised2(a);
   }

   public static void permutations(ArrayList<Integer> arr, ArrayList<Integer> ans) {
      if (arr.size() == 0) {
         sum(ans);
      } else {
         for(int j = 0; j < arr.size(); ++j) {
            int a = (Integer)arr.get(j);
            ArrayList<Integer> newarr = new ArrayList(arr);
            newarr.remove(j);
            ans.add(a);
            permutations(newarr, ans);
            ans.remove(ans.size() - 1);
         }

      }
   }

   public static void sum(ArrayList<Integer> arr) {
      int sum = 0;

      for(int i = 0; i < arr.size() - 1; ++i) {
         sum += Math.abs((Integer)arr.get(i) - (Integer)arr.get(i + 1));
      }

      sum += Math.abs((Integer)arr.get(arr.size() - 1) - (Integer)arr.get(0));
      System.out.println(sum);
   }

   public static void maxsumoptimised(int[] arr) {
      Arrays.parallelSort(arr);
      int[] newarr = new int[arr.length];
      int i = 0;
      int j = arr.length - 1;
      int k = 0;

      while(k < arr.length) {
         if (k % 2 != 0) {
            newarr[k++] = arr[j];
            --j;
         } else {
            newarr[k++] = arr[i];
            ++i;
         }
      }

      int sum = 0;

      for(int l = 0; l < newarr.length - 1; ++l) {
         sum += Math.abs(newarr[l] - newarr[l + 1]);
      }

      sum += Math.abs(newarr[newarr.length - 1] - newarr[0]);
      System.out.println(sum);
   }

   public static void maxsumoptimised2(int[] arr) {
      Arrays.parallelSort(arr);
      int sum = 0;

      for(int l = 0; l < arr.length / 2; ++l) {
         sum -= 2 * arr[l];
         sum += 2 * arr[arr.length - 1 - l];
      }

      System.out.println(sum);
   }
}
