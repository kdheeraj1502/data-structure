package graph.topological.ordering;

import java.util.*;

public class Graph {

	public int count;
	public List<List<Edge>> adjacency = new ArrayList<>();
	
	Graph(int count){
		this.count = count;
		for(int i = 0; i < count; i++) {
			adjacency.add(new ArrayList<>());
		}
	}
	
	public void addDirectedEdge(int source, int dest, int cost) {
		Edge edge = new Edge(dest, cost);
		adjacency.get(source).add(edge);
	}
	
	private void addDirectedEdge(int source, int dest) {
		addDirectedEdge(source, dest, 1);
	}
	
	private void addUnDirectedEdge(int source, int dest, int cost) {
		addDirectedEdge(source, dest, 1);
		addDirectedEdge(dest, source, 1);
	}

	public void addUnDirectedEdge(int source, int dest) {
		addUnDirectedEdge(source, dest, 1);
	}
	
	public void print() {
		for(int i = 0; i < count; i++) {
			List<Edge> ad = adjacency.get(i);
			System.out.print("Vertex " + i + " is connected to :");
			for(Edge edge : ad) {
				System.out.print("(" + edge.getDest() + " . " + edge.getCost() + ") ");
			}
			System.out.println();
		}
	}
}
