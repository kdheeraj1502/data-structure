package graph.dijkstra.algo;

import java.util.ArrayList;
import java.util.List;

public class Vertex implements Comparable<Vertex> {

	private String name;
	private List<Edge> adjacencyList;
	private double distance = Double.MAX_VALUE;
	private boolean visited;
	private Vertex predecessor;
	
	public Vertex(String name){
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}
	
	public List<Edge> getNeighbors() {
		return adjacencyList;
	}
	public void addNeighbor(Edge edge) {
		this.adjacencyList.add(edge);
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	public Vertex getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	@Override
	public int compareTo(Vertex vertex) {
		return Double.compare(this.distance, vertex.getDistance());
	}

	@Override
	public String toString() {
		return " " + name + " ";
	}
}
