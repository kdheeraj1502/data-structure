package backtracking;

public class HamiltonianCycle {
   private int[][] adjacencyMatrix;
   private int numOfVertexes;
   private int[] hamiltonianPath;

   public HamiltonianCycle(int[][] adjacencyMatrix) {
      this.adjacencyMatrix = adjacencyMatrix;
      this.hamiltonianPath = new int[adjacencyMatrix.length];
      this.numOfVertexes = adjacencyMatrix.length;
      this.hamiltonianPath[0] = 0;
   }

   private boolean findFeasibleSolution(int position) {
      if (position == this.numOfVertexes) {
         return this.adjacencyMatrix[this.hamiltonianPath[position - 1]][this.hamiltonianPath[0]] == 1;
      } else {
         for(int vertexIndex = 1; vertexIndex < this.numOfVertexes; ++vertexIndex) {
            if (this.isFeasibleVertex(vertexIndex, position)) {
               this.hamiltonianPath[position] = vertexIndex;
               if (this.findFeasibleSolution(position + 1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   private boolean isFeasibleVertex(int vertexIndex, int actualPosition) {
      if (this.adjacencyMatrix[this.hamiltonianPath[actualPosition - 1]][vertexIndex] == 0) {
         return false;
      } else {
         for(int i = 0; i < actualPosition; ++i) {
            if (this.hamiltonianPath[i] == vertexIndex) {
               return false;
            }
         }

         return true;
      }
   }

   private void showHamitonianPath() {
      for(int i = 0; i < this.hamiltonianPath.length; ++i) {
         System.out.print(this.hamiltonianPath[i] + ", ");
      }

   }

   public void solve() {
      if (this.findFeasibleSolution(1)) {
         this.showHamitonianPath();
      } else {
         System.out.println("No solution");
      }

   }

   public static void main(String[] args) {
      int[][] adjacencyMatrix = new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 1}, {0, 1, 1, 1, 0}};
      int[][] graph2 = new int[][]{{0, 1, 0, 1, 0}, {1, 0, 1, 1, 1}, {0, 1, 0, 0, 1}, {1, 1, 0, 0, 0}, {0, 1, 1, 0, 0}};
      HamiltonianCycle hc = new HamiltonianCycle(adjacencyMatrix);
      hc.solve();
      System.out.println();
      HamiltonianCycle hc2 = new HamiltonianCycle(graph2);
      hc2.solve();
   }
}
