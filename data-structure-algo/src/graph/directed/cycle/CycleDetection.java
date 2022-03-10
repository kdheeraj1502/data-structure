package graph.directed.cycle;

import java.util.*;

public class CycleDetection {
//	static boolean isCyclic;
//	static boolean isCyclic_self;
	public void detectCycle(List<Vertex> graph) {
		// there are multiple independent clusters
		boolean isCyclic = false;
		for (Vertex v : graph)
			if (!v.isVisited())
				isCyclic = dfs(v, isCyclic);
		if (isCyclic) {
			System.out.println("it is cyclic : " + isCyclic);
		}
		System.out.println("it is cyclic : " + isCyclic);
	}

	private boolean dfs(Vertex vertex, boolean isCyclic) {
		vertex.setBeingVisited(true);
		for (Vertex v : vertex.getNeighbors()) {
			if (v.isBeingVisited()) {
				isCyclic = true;
				System.out.println("Backward edge .. there is a cycle");
				return true;
			}
			if (!v.isVisited()) {
				v.setVisited(true);
				isCyclic = dfs(v, isCyclic);
			}
		}
		vertex.setBeingVisited(false);
		vertex.setVisited(true);
		return isCyclic;
	}

	public static void detectCycle_self(List<Vertex> graph) {
		Map<String, Boolean> vis = new HashMap<>();
		Map<String, Boolean> stack = new HashMap<>();
		boolean isCyclic_self = false;
		for (Vertex v : graph) {
			vis.put(v.getName(), false);
			stack.put(v.getName(), false);
		}

		for (Vertex v : graph)
			if (isCyclic(v, vis, stack, isCyclic_self))
				System.out.println("it is cyclic self : " + true);
	}

	private static boolean isCyclic(Vertex v, Map<String, Boolean> vis, Map<String, Boolean> stack,
			boolean isCyclic_self) {
		if (stack.get(v.getName()))
			return true;
		vis.put(v.getName(), true);
		stack.put(v.getName(), true);
		for (Vertex n : v.getNeighbors()) {
			if (isCyclic(n, vis, stack, isCyclic_self)) {
				return true;
			}
		}
		stack.put(v.getName(), false);
		return false;
	}

	public static void main(String[] args) {
		Vertex v0 = new Vertex("A");
		Vertex v1 = new Vertex("B");
		Vertex v2 = new Vertex("C");
		Vertex v3 = new Vertex("D");
		Vertex v4 = new Vertex("E");
		Vertex v5 = new Vertex("F");

		v5.addNeighbors(v0);

		v0.addNeighbors(v2);
		v0.addNeighbors(v4);

		v4.addNeighbors(v5);

		v2.addNeighbors(v1);
		v2.addNeighbors(v3);

		List<Vertex> graph = new ArrayList<>();
		graph.add(v4);
		graph.add(v3);
		graph.add(v0);
		graph.add(v5);
		graph.add(v2);
		graph.add(v1);

		CycleDetection cd = new CycleDetection();
		cd.detectCycle(graph);

		detectCycle_self(graph);
	}
}
