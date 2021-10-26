package graph.DAG;

import java.util.*;

public class ShortestPath {

	private TopologicalOrdering topologicalOrdering;

	public ShortestPath(List<Vertex> graph) {
		this.topologicalOrdering = new TopologicalOrdering(graph);
		graph.get(0).setMinDistance(0);
	}

	public void compute() {
		Stack<Vertex> topologicalOrder = topologicalOrdering.getStack();
		while (!topologicalOrder.isEmpty()) {
			Vertex u = topologicalOrder.pop();
			for (Edge e : u.getNeighbors()) {
				Vertex v = e.getTarget();
				if (u.getMinDistance() + e.getWeight() < v.getMinDistance()) {
					v.setMinDistance(u.getMinDistance() + e.getWeight());
					v.setPredecessor(u);
				}
			}
		}
	}

	public static void main(String[] args) {
		List<Vertex> graph = new ArrayList<>();
		Vertex v0 = new Vertex("S");
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");

		v0.addNeighbors(new Edge(v1, 1));
		v0.addNeighbors(new Edge(v3, 2));

		v1.addNeighbors(new Edge(v2, 6));

		v2.addNeighbors(new Edge(v4, 1));
		v2.addNeighbors(new Edge(v5, 2));

		v3.addNeighbors(new Edge(v1, 4));
		v3.addNeighbors(new Edge(v4, 3));

		v4.addNeighbors(new Edge(v5, 1));

		graph.add(v0);
		graph.add(v1);
		graph.add(v2);
		graph.add(v3);
		graph.add(v4);
		graph.add(v5);

		ShortestPath sp = new ShortestPath(graph);
		sp.compute();

		for (Vertex v : graph) {
			System.out.println("Distance from s: " + v.getMinDistance() + " - " + v.getPredecessor());
		}
	}
}
