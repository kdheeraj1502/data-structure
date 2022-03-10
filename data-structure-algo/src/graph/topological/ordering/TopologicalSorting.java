package graph.topological.ordering;

import java.util.*;


public class TopologicalSorting {
	
	public static void topologicalSort(Graph graph) {
		Stack<Integer> stack = new Stack<>();
		int count = graph.count;
		boolean visited[] = new boolean[count];
		for(int i = 0; i < count; i++) {
			if(!visited[i]) {
				dfsUtil2(graph, i, visited, stack);
			}
		}
		System.out.print("Topological sort :: ");
		while(!stack.isEmpty()) {
			System.out.print(" " + stack.pop());
		}
	}
	
	public static void dfsUtil2(Graph graph, int index, boolean[] visited, Stack<Integer> stack) {
		visited[index] = true;
		List<Edge> adl = graph.adjacency.get(index);
		for(Edge edge : adl) {
			if(!visited[edge.getDest()]) {
				dfsUtil2(graph, edge.getDest(), visited, stack);
			}
		}
		stack.push(index);
	}

	public static void main(String[] args) {
		Graph graph = new Graph(6);
		graph.addDirectedEdge(5, 2, 1);
		graph.addDirectedEdge(5, 0, 1);
		graph.addDirectedEdge(4, 0, 1);
		graph.addDirectedEdge(4, 1, 1);
		graph.addDirectedEdge(2, 3, 1);
		graph.addDirectedEdge(3, 1, 1);
		topologicalSort(graph);
	}
}
