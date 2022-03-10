package graph;

import java.util.*;
import java.util.List;

import graph.topological.Vertex;

public class RootVertex {

	public static int findRootVertex(List<Vertex> graph) {
		int retVal = -1;
		boolean[] visited = new boolean[graph.size()];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < graph.size(); i++) {
			if(!visited[i]) {
				findRootVertex(graph, visited, i, stack);
				retVal = i;
			}
		}
		System.out.println(stack);
		return retVal;
	}

	public static void findRootVertex(List<Vertex> graph, boolean[] visited, int src, Stack<Integer> stack) {
		visited[src] = true;
		List<Vertex> neighbors = graph.get(src).getNeighbor();
		for (Vertex v : neighbors) {
			if (!visited[Integer.parseInt(v.name)]) {
				findRootVertex(graph, visited, Integer.parseInt(v.name), stack);
			}
		}
		stack.push(src);
	}

	public static void main(String[] args) {
		List<Vertex> graph = new ArrayList<>();
		Vertex zero = new Vertex("0");
		Vertex one = new Vertex("1");
		Vertex two = new Vertex("2");
		Vertex three = new Vertex("3");
		Vertex four = new Vertex("4");
		Vertex five = new Vertex("5");
		Vertex six = new Vertex("6");
		
		graph.add(zero);
		graph.add(one);
		graph.add(two);
		graph.add(three);
		graph.add(four);
		graph.add(five);
		graph.add(six);

		graph.get(0).addNeighbor(graph.get(1));

		graph.get(0).addNeighbor(graph.get(2));

		graph.get(1).addNeighbor(graph.get(3));

		graph.get(4).addNeighbor(graph.get(1));

		graph.get(6).addNeighbor(graph.get(4));

		graph.get(5).addNeighbor(graph.get(6));

		graph.get(5).addNeighbor(graph.get(2));

		graph.get(6).addNeighbor(graph.get(0));

		System.out.println(findRootVertex(graph));
	}
}
