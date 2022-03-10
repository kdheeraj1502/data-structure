package com.hellokoding.datastructure.graph;

import java.util.Iterator;
import java.util.List;

public class DetectCycleUndirected extends GraphUndirectedByAdjacencyList {
	public DetectCycleUndirected(int V) {
		super(V);
	}
	
	public boolean hasCycle() {
		boolean[] visited = new boolean[getV()];

		for (int i = 0; i < getV(); i++) {
			if (!visited[i] && dfs(i, visited, -1)) {
				return true;
			}
		}

		return false;
	}

	private boolean dfs(int v, boolean[] visited, int parent) {
		visited[v] = true;

		List<Integer> children = getAdjacencyList().get(v);
		for (Integer c : children) {
			if (!visited[c] && dfs(c, visited, v)) {
				return true;
			} else if (c != parent) {
				return true;
			}
		}

		return false;
	}

	Boolean isCyclic(DetectCycleUndirected graph) {
		Boolean visited[] = new Boolean[getV()];
		for (int i = 0; i < getV(); i++)
			visited[i] = false;
		for (int u = 0; u < getV(); u++) {
			if (!visited[u])
				if (isCyclicUtil(u, visited, -1))
					return true;
		}

		return false;
	}

	Boolean isCyclicUtil(int v, Boolean visited[], int parent) {
		visited[v] = true;
		Integer i;
		Iterator<Integer> it = getAdjacencyList().get(v).iterator();
		while (it.hasNext()) {
			i = it.next();
			if (!visited[i]) {
				if (isCyclicUtil(i, visited, v))
					return true;
			}
			else if (i != parent)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		DetectCycleUndirected graph = new DetectCycleUndirected(5);
		graph.addEdge(0, 1); //p = 0, c = 1, c = 2
		// graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		System.out.println(graph.hasCycle());
		System.out.println(graph.isCyclic(graph));
	}
}
// 0 -> 1
// 1 -> 2