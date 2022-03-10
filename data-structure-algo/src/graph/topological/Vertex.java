package graph.topological;

import java.util.*;

public class Vertex {

	public String name;
	private boolean visited;
	private List<Vertex> neigborList;
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Vertex(String name) {
		this.name = name;
		this.neigborList = new ArrayList<>();
	}

	public void addNeighbor(Vertex vertex) {
		this.neigborList.add(vertex);
	}

	public List<Vertex> getNeighbor() {
		return this.neigborList;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + this.name + "]";
	}
}
