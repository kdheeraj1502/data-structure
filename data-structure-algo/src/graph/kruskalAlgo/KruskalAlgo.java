package graph.kruskalAlgo;

import java.util.*;

/**
 * 
 * MINIMUM SPANNING TREE - INCLUDES ALL VERTEX
 * TOTAL COST IS MINIMUM
 * 
 * USE CASE
 * 
 * 1. BIG DATA ANALYSIS
 * 2. CLUSTRING ALGO
 * 3. FIND MIN COST FOR TELECOM COMPANY LAYING CABLE TO NEIGHBORHOOD
 * 
 * ALGO
 * 1. PRIM ALGO
 * 2. KRUSKAL ALGO (GREEDY ALGO)
 * 
 * 
 * KRUSKAL ALGO
 * 1. SORT THE EDGES O(ElogE) WITH MERGE OR QUICK SORT BUT USE HEAPS INSTEAD
 * 2. USE DISJOINT SET (IT IS A DATA STRUCTURE TO KEEP 
 *    TRACK OF SET OF ELEMENTS PARTITIONED INTO NUMBER OF DISJOINT (NON OVERLAPPING)
 *    THREE MAIN OPERATIONS ARE, UNION, FIND, MAKE SETS
 *    a) MAKING SET
 *    b) FIND - FIND REPRESENTATIVE/ROOT NODE
 *    c) UNION-
 *       1) UNION BY RANK
 *       2) UNION BY PATH COMPRESSION 
 * 3. START ADDING EDGES TO MST, MAKE SURE NO CYCLE
 * 
 * @author dheerajkumar02
 *
 */
public class KruskalAlgo {

	 public void spanningTree(List<Vertex> vertexList,List<Edge> edgeList){
			
		 DisjointSet disjointSet = new DisjointSet(vertexList);

		    /* Create a list of edges */
		    List<Edge> tree = new ArrayList<Edge>();

		    /* Java's modified version of mergesort guarantees nlog(n) time here */
		    Collections.sort(edgeList);

		    /* Kruskal's algorithm */
		    for (Edge e : edgeList) {
		      Vertex u = e.getStartVertex();
		      Vertex v = e.getTargetVertex();
		      if (disjointSet.find(u.getNode()) != disjointSet.find(v.getNode())) {
		        /* Vertices v and u are not in the same component */
		        tree.add(e);

		        /* Union them in the tree */
		        disjointSet.union(u.getNode(), v.getNode());
		      }
		    }

		    for(Edge edge : tree){
		    	System.out.print(""+edge.getStartVertex()+""+edge.getTargetVertex()+"-");
		    }
	 }
	 
	public static void main(String[] args) {
		List<Vertex> vertexList = new ArrayList<>();
		vertexList.add(new Vertex("A"));
		vertexList.add(new Vertex("B"));
		vertexList.add(new Vertex("C"));
		vertexList.add(new Vertex("D"));
		vertexList.add(new Vertex("E"));
		vertexList.add(new Vertex("F"));
		vertexList.add(new Vertex("G"));
		vertexList.add(new Vertex("H"));
		
		List<Edge> edgeList = new ArrayList<>();
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(1), 3));
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(2), 2));
		edgeList.add(new Edge(vertexList.get(0), vertexList.get(3), 5));
		edgeList.add(new Edge(vertexList.get(1), vertexList.get(5), 13));
		edgeList.add(new Edge(vertexList.get(1), vertexList.get(3), 2));
		edgeList.add(new Edge(vertexList.get(2), vertexList.get(4), 5));
		edgeList.add(new Edge(vertexList.get(2), vertexList.get(3), 2));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(4), 4));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(5), 6));
		edgeList.add(new Edge(vertexList.get(3), vertexList.get(6), 3));
		edgeList.add(new Edge(vertexList.get(4), vertexList.get(6), 6));
		edgeList.add(new Edge(vertexList.get(5), vertexList.get(6), 2));
		edgeList.add(new Edge(vertexList.get(5), vertexList.get(7), 3));
		edgeList.add(new Edge(vertexList.get(6), vertexList.get(7), 6));
		
		KruskalAlgo kruskalAlgorithm = new KruskalAlgo();
		kruskalAlgorithm.spanningTree(vertexList, edgeList);
	}
}
