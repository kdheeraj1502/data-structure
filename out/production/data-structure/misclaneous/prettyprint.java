package misclaneous;

public class prettyprint {
   public static void main(String[] args) {
      System.out.println(-1);
   }

   public static void prettyPrint(int A) {
      int sz = 2 * A - 1;
      int[][] ans = new int[sz][sz];
      int temp = 0;

      int i;
      int j;
      for(int limit = sz; A > 0; --limit) {
         for(i = temp; i < limit; ++i) {
            for(j = temp; j < limit; ++j) {
               ans[i][j] = A;
            }
         }

         --A;
         ++temp;
      }

      for(i = 0; i < ans.length; ++i) {
         for(j = 0; j < ans.length; ++j) {
            System.out.print(ans[i][j] + " ");
         }

         System.out.println();
      }

   }
}
