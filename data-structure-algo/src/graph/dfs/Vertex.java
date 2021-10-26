package graph.dfs;

import java.util.*;

public class Vertex {

	private String name;
	private boolean visited;
	private List<Vertex> adjacencyList;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public List<Vertex> getNeighbors() {
		return adjacencyList;
	}

	public void addNeighbor(Vertex vertex) {
		this.adjacencyList.add(vertex);
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}

}
