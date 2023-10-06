package graphs;

public class makegraph {
   public static void main(String[] args) {
      Graph graph = new Graph();
      graph.addvertex("0");
      graph.addvertex("1");
      graph.addvertex("2");
      graph.addvertex("3");
      graph.addvertex("4");
      graph.addvertex("5");
      graph.addvertex("6");
      graph.addvertex("7");
      graph.addvertex("8");
      graph.addedge("0", "2", 1);
      graph.addedge("0", "5", 1);
      graph.addedge("1", "5", 1);
      graph.addedge("1", "6", 1);
      graph.addedge("1", "8", 1);
      graph.addedge("3", "4", 1);
      graph.addedge("3", "5", 1);
      graph.addedge("4", "7", 1);
      graph.addedge("5", "7", 1);
      graph.diplay();
      System.out.println();
      graph.BFT();
   }
}
