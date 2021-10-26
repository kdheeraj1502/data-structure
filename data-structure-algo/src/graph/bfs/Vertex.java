package graph.bfs;

import java.util.*;

public class Vertex {

	private String name;
	private boolean visited;
	private List<Vertex> adjacencyList;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getAdjacencyList() {
		return adjacencyList;
	}

	public void addNeighbors(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
}
