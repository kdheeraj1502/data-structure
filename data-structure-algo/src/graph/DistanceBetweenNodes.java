package graph;

import java.util.*;

public class DistanceBetweenNodes {

	public static int bfsDistance(UnDirectedGraph graph, int src, int des) {
		boolean visited[] = new boolean[graph.getSize()];
		int level[] = new int[graph.getSize()];
		Queue<Integer> queue = new LinkedList<>();
		visited[src] = true;
		level[src] = 0;
		queue.add(src);
		while(!queue.isEmpty()) {
			int curr = queue.remove();
			int depth = level[curr];
			List<Edge> neighbors = graph.getAdjacency().get(curr);
			for(Edge edge : neighbors) {
				if(des == edge.getDes()) {
					return depth + 1;
				}
				if(!visited[edge.getDes()]) {
					visited[edge.getDes()] = true;
					queue.add(edge.getDes());
					level[edge.getDes()] = depth + 1;
				}
			}
		}
		return -1;
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

		int dis = bfsDistance(graph, 1, 6);
		System.out.println(dis);
	}
}
