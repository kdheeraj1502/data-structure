package backtracking;

public class HamiltonianCycleSelf {
   private int[][] adjacencyMatrix;
   private int numOfVertex;
   private int[] hamitonianpath;

   public HamiltonianCycleSelf(int[][] adjacencyMatrix) {
      this.adjacencyMatrix = adjacencyMatrix;
      this.numOfVertex = adjacencyMatrix.length;
      this.hamitonianpath = new int[this.numOfVertex];
      this.hamitonianpath[0] = 0;
   }

   public boolean feasibleSolution(int position) {
      if (position == this.numOfVertex) {
         return this.adjacencyMatrix[this.hamitonianpath[position - 1]][this.hamitonianpath[0]] == 1;
      } else {
         for(int vertexIndex = 1; vertexIndex < this.hamitonianpath.length; ++vertexIndex) {
            if (this.isFeasibleVertex(position, vertexIndex)) {
               this.hamitonianpath[position] = vertexIndex;
               if (this.feasibleSolution(position + 1)) {
                  return true;
               }

               return false;
            }
         }

         return false;
      }
   }

   private boolean isFeasibleVertex(int actualPosition, int vertexIndex) {
      if (this.adjacencyMatrix[this.hamitonianpath[actualPosition - 1]][vertexIndex] == 0) {
         return false;
      } else {
         for(int i = 0; i < actualPosition; ++i) {
            if (this.hamitonianpath[i] == vertexIndex) {
               return false;
            }
         }

         return true;
      }
   }

   public void solve() {
      if (this.feasibleSolution(1)) {
         this.printPath();
      } else {
         System.out.println("No solution");
      }

   }

   public void printPath() {
      for(int i = 0; i < this.hamitonianpath.length; ++i) {
         System.out.print(this.hamitonianpath[i] + ", ");
      }

   }

   public static void main(String[] args) {
      int[][] adjacencyMatrix = new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {0, 1, 1, 1, 0}};
      HamiltonianCycleSelf hcf = new HamiltonianCycleSelf(adjacencyMatrix);
      hcf.solve();
   }
}
