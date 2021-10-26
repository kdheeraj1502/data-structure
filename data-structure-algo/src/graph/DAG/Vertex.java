package graph.DAG;

import java.util.*;

public class Vertex {

	private String name;
	private List<Edge> adjacencyList;
	private boolean visited;
	private int minDistance;
	private Vertex predecessor;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
		this.minDistance = Integer.MAX_VALUE;
	}

	public List<Edge> getNeighbors() {
		return this.adjacencyList;
	}

	public void addNeighbors(Edge edge) {
		this.adjacencyList.add(edge);
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public int getMinDistance() {
		return minDistance;
	}

	public void setMinDistance(int minDistance) {
		this.minDistance = minDistance;
	}

	public Vertex getPredecessor() {
		return predecessor;
	}

	public void setPredecessor(Vertex predecessor) {
		this.predecessor = predecessor;
	}

	@Override
	public String toString() {
		return "" + name + " - " + predecessor;
	}
}
