package graph;

public class AdjacencyMatrix {
   private static int[][] matrix = new int[][]{{0, 2, 4, 0}, {0, 0, 0, 3}, {0, 0, 0, 0}, {0, 0, 0, 0}};

   public static void main(String[] args) {
      for(int i = 0; i < matrix.length; ++i) {
         for(int j = 0; j < matrix[i].length; ++j) {
            if (matrix[i][j] != 0) {
               System.out.println("Edge with the weight " + matrix[i][j]);
            }
         }
      }

      System.out.println(matrix[0][2]);
      Vertex a = new Vertex("A");
      Vertex b = new Vertex("B");
      Vertex c = new Vertex("C");
      Vertex d = new Vertex("D");
      a.addNeighbor(b);
      a.addNeighbor(c);
      b.addNeighbor(d);
      a.showNeighbors();
      b.showNeighbors();
      c.showNeighbors();
      d.showNeighbors();
   }
}
