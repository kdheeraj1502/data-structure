package graph.dfs;

import java.util.*;

public class DepthFirstSearch {

	private Stack<Vertex> stack;

	public DepthFirstSearch() {
		this.stack = new Stack<>();
	}

	public void dfs(List<Vertex> vertexList) {
		for (Vertex v : vertexList) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsHelper(v);
			}
		}
	}

	private void dfsHelper(Vertex rootVertex) {
		// LIFO Structure
		stack.add(rootVertex);
		rootVertex.setVisited(true);

		while (!stack.isEmpty()) {
			Vertex actualVertex = stack.pop();
			System.out.println("actualVertex " + actualVertex);
			// Consider all the neighbors
			for (Vertex v : actualVertex.getNeighbors()) {
				if (!v.isVisited()) {
					v.setVisited(true);
					stack.add(v);
				}
			}
		}
	}

	public void dfs_recursion(List<Vertex> vertexList) {
		for (Vertex v : vertexList) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsHelper_recursion(v);
			}
		}
	}

	private void dfsHelper_recursion(Vertex rootVertex) {
		// LIFO Structure
		System.out.println("actualVertex " + rootVertex);
		// Consider all the neighbors
		for (Vertex v : rootVertex.getNeighbors()) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfsHelper_recursion(v);
			}
		}
	}

	public static void main(String[] args) {
		Vertex v1 = new Vertex("A");
		Vertex v2 = new Vertex("B");
		Vertex v3 = new Vertex("C");
		Vertex v4 = new Vertex("D");
		Vertex v5 = new Vertex("E");
		Vertex v6 = new Vertex("F");
		Vertex v7 = new Vertex("G");
		Vertex v8 = new Vertex("H");

		List<Vertex> list = new ArrayList<>();
		v1.addNeighbor(v2);
		v1.addNeighbor(v6);
		v1.addNeighbor(v7);
	
		v2.addNeighbor(v3);
		v2.addNeighbor(v4);

		v4.addNeighbor(v5);
		v7.addNeighbor(v8);

		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v4);
		list.add(v5);
		list.add(v6);
		list.add(v7);
		list.add(v8);

		DepthFirstSearch dfs = new DepthFirstSearch();
	//	dfs.dfs(list);
		System.out.println("--------");
		dfs.dfs_recursion(list);
	}
}