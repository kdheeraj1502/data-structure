package graph;

import java.util.*;

public class BFSLevelNode {

	public static void bfsLevelNode(UnDirectedGraph graph, int src) {
		boolean visited[] = new boolean[graph.getSize()];
		int level[] = new int[graph.getSize()];
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		level[src] = 0;
		System.out.println("Node   -  Level");
		queue.add(src);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			int depth = level[curr];
			List<Edge> neighbors = graph.getAdjacency().get(curr);
			System.out.println(curr + " - " + depth);
			for(Edge v : neighbors) {
				if(!visited[v.getDes()]) {
					visited[v.getDes()] = true;
					queue.add(v.getDes());
					level[v.getDes()] = depth + 1;
				}
			}
			
		}
	}

	public static void main(String[] args) {
		UnDirectedGraph graph = new UnDirectedGraph(7);
		graph.addUndirected(0, 1, 1);
		graph.addUndirected(0, 2, 1);
		graph.addUndirected(0, 4, 1);
		graph.addUndirected(1, 2, 1);
		graph.addUndirected(2, 5, 1);
		graph.addUndirected(3, 4, 1);
		graph.addUndirected(4, 5, 1);
		graph.addUndirected(4, 6, 1);
		
		bfsLevelNode(graph, 1);

	}
}
