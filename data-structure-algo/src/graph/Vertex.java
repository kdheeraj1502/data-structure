package graph;

import java.util.*;

public class Vertex {

	private String name;
	private List<Vertex> adjacencyList;

	public Vertex(String name) {
		this.name = name;
		this.adjacencyList = new ArrayList<>();
	}

	public void addNeighbor(Vertex vertex) {
		adjacencyList.add(vertex);
	}

	public void showNeighbors() {
		System.out.print("Neighbor of " + name + " are ::");
		for (Vertex v : adjacencyList)
			System.out.print(v + ", ");
		System.out.println();
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + "]";
	}
}
