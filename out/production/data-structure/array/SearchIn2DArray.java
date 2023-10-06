package array;

public class SearchIn2DArray {
   public static boolean findElein2D(int[][] num, int key) {
      int val = num[0][num[0].length - 1];
      int row = 0;
      int column = num[row].length - 1;

      while(row >= 0 && row < num.length && column >= 0 && column < num[row].length) {
         if (key == val) {
            return true;
         }

         if (key < val) {
            --column;
            val = num[0][column];
         }

         if (key > val) {
            ++row;
            val = num[row][column];
         }
      }

      return false;
   }

   public static void main(String[] args) {
      int[][] num = new int[][]{{1, 2, 3, 4, 5}, {2, 3, 4, 5, 6}, {3, 4, 5, 6, 7}};
      int[][] var2 = num;
      int var3 = num.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int[] in = var2[var4];
         int[] var6 = in;
         int var7 = in.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            Integer i = var6[var8];
            System.out.println(findElein2D(num, i));
         }
      }

   }
}
