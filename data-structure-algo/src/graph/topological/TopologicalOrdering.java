package graph.topological;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Topological ordering only possible on acyclic graph
 * 
 * It defines to execute one which is not dependent for example in maven the
 * dependent class mvn install will get executed after non dependent class
 * 
 * USE DFS deep first search for Topological graph
 * 
 * @author dheerajkumar02
 *
 */
public class TopologicalOrdering {

	private Stack<Vertex> stack;

	public TopologicalOrdering() {
		this.stack = new Stack<>();
	}

	public void dfs(Vertex vertex) {
		vertex.setVisited(true);
		
		// Get all neighbors of the vertex and call method in recursion
		for (Vertex v : vertex.getNeighbor()) {
			if (!v.isVisited()) {
				v.setVisited(true);
				dfs(v);
			}
		}
		this.stack.push(vertex);
	}

	public Stack<Vertex> getStack() {
		return this.stack;
	}

	public static void main(String[] args) {
		TopologicalOrdering topologicalOrdering = new TopologicalOrdering();
		List<Vertex> graph = new ArrayList<>();
		graph.add(new Vertex("0"));
		graph.add(new Vertex("1"));
		graph.add(new Vertex("2"));
		graph.add(new Vertex("3"));
		graph.add(new Vertex("4"));
		graph.add(new Vertex("5"));

		graph.get(2).addNeighbor(graph.get(3));

		graph.get(3).addNeighbor(graph.get(1));

		graph.get(4).addNeighbor(graph.get(0));
		graph.get(4).addNeighbor(graph.get(1));

		graph.get(5).addNeighbor(graph.get(0));
		graph.get(5).addNeighbor(graph.get(2));

		for (int i = 0; i < graph.size(); i++) {
			if (!graph.get(i).isVisited()) {
				topologicalOrdering.dfs(graph.get(i));
			}
		}

		Stack<Vertex> stack = topologicalOrdering.getStack();

		for (int i = 0; i < graph.size(); i++) {
			Vertex vertex = stack.pop();
			System.out.println(vertex + " ->");
		}

	}
}
