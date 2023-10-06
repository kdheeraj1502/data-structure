package array;

public class FindFloorAndCeilInUnsortedArray {
   public static void findFloorAndCeil(int[] num, int key) {
      int fDist = Integer.MAX_VALUE;
      int cDist = Integer.MAX_VALUE;
      int fInd = -1;
      int cInd = -1;

      for(int i = 0; i < num.length; ++i) {
         if (num[i] <= key && fDist > key - num[i]) {
            fInd = i;
            fDist = key - num[i];
         }

         if (num[i] >= key && cDist > num[i] - key) {
            cInd = i;
            cDist = num[i] - key;
         }
      }

      System.out.println("Ceil " + cInd + " floor " + fInd);
   }

   public static void main(String[] args) {
      int[] num = new int[]{5, 6, 8, 9, 6, 5, 5, 6};
      findFloorAndCeil(num, 7);
   }
}
