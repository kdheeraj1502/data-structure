package searchingandsorting;

public class majorityelement {
   public static void main(String[] args) {
   }

   static int majorityElement(int[] arr, int size) {
      int majority = -1;
      int freq = 0;

      int ffreq;
      for(ffreq = 0; ffreq < arr.length; ++ffreq) {
         if (freq == 0) {
            freq = 1;
            majority = arr[ffreq];
         } else if (arr[ffreq] == majority) {
            ++freq;
         } else {
            --freq;
         }
      }

      ffreq = 0;

      for(int i = 0; i < arr.length; ++i) {
         if (arr[i] == majority) {
            ++ffreq;
         }

         if (ffreq > arr.length / 2) {
            return majority;
         }
      }

      return -1;
   }
}
