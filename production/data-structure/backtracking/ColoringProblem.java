package backtracking;

public class ColoringProblem {
   private int[][] matrix;
   private int numOfVertex;
   private int numOfColors;
   private int[] colors;

   public ColoringProblem(int[][] matrix, int numOfColors) {
      this.matrix = matrix;
      this.numOfColors = numOfColors;
      this.numOfVertex = matrix.length;
      this.colors = new int[this.numOfVertex];
   }

   private boolean canBeColored(int nodePosition) {
      if (nodePosition == this.numOfVertex) {
         return true;
      } else {
         for(int colorType = 1; colorType <= this.numOfColors; ++colorType) {
            if (this.isColorValid(nodePosition, colorType)) {
               this.colors[nodePosition] = colorType;
               if (this.canBeColored(nodePosition + 1)) {
                  return true;
               }

               return false;
            }
         }

         return false;
      }
   }

   private boolean isColorValid(int actualPosition, int colorType) {
      for(int i = 0; i < this.numOfVertex; ++i) {
         if (this.matrix[actualPosition][i] == 1 && colorType == this.colors[i]) {
            return false;
         }
      }

      return true;
   }

   public void solve() {
      if (this.canBeColored(0)) {
         this.printPath();
      } else {
         System.out.println("There is no solutio .. . ");
      }

   }

   public void printPath() {
      for(int i = 0; i < this.colors.length; ++i) {
         System.out.println("Node " + (i + 1) + " has color " + this.colors[i]);
      }

   }

   public static void main(String[] args) {
      int[][] matrix = new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}, {1, 1, 1, 0, 1}, {0, 0, 0, 1, 0}};
      int numOfColors = 3;
      ColoringProblem cp = new ColoringProblem(matrix, numOfColors);
      cp.solve();
   }
}
