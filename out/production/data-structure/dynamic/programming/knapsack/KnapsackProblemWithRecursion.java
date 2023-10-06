package dynamic.programming.knapsack;

public class KnapsackProblemWithRecursion {
   public static void main(String[] args) {
      int numOfItems = 3;
      int capacityOfKnapsack = 5;
      int[] weights = new int[]{4, 2, 3};
      int[] values = new int[]{10, 4, 7};
      KnapsackProblemWithRecursion kp = new KnapsackProblemWithRecursion();
      System.out.println(kp.solveRecursion(capacityOfKnapsack, weights, values, numOfItems));
   }

   public int solveRecursion(int m, int[] w, int[] v, int n) {
      if (m != 0 && n != 0) {
         if (w[n - 1] > m) {
            return this.solveRecursion(m, w, v, n - 1);
         } else {
            int included = v[n - 1] + this.solveRecursion(m - w[n - 1], w, v, n - 1);
            int excluded = this.solveRecursion(m, w, v, n - 1);
            return Math.max(included, excluded);
         }
      } else {
         return 0;
      }
   }
}
